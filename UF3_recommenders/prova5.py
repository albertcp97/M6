import numpy as np
import pandas as pd
import tensorflow as tf
from typing import Dict, Text
import pprint
import csv
import random
import tensorflow_recommenders as tfrs

#import matplotlib.pyplot as plt
#import tensorflow.compat.v1 as tf
#tf.disable_v2_behavior()
import os

'''
steam_raw = pd.read_csv("steam-200k.csv",usecols=[0,1,2,3],names=['userid','game','behavior','hoursplayed'],dtype={"userid":int})

steam_raw['userid'] = pd.to_numeric( steam_raw['userid'])
ratings = steam_raw.to_dict()
print(ratings)

print(steam_raw.items[steam_raw.isna().any()].tolist())
steam_raw.head()
steam_raw.isnull().values.any()
steam_raw['userid'] = pd.to_numeric( steam_raw['userid'])
steam_raw['game'] = steam_raw.game.astype(str)
steam_raw['hoursplayed'] = steam_raw.hoursplayed.astype(int)
print(steam_raw.__dict__)
print(steam_raw['userid'][0],steam_raw['game'][0])



steam_raw_u = pd.read_csv("steam-200k.csv",usecols=[0,1,2,3],names=['userid','game','behavior','hoursplayed'])
steam_raw_g = pd.read_csv("steam-200k.csv",usecols=[0,1,2,3],names=['userid','game','behavior','hoursplayed'])
'''
'''
ratings = []
with open('steam-200k.csv', mode='r') as f:
    steam_raw = csv.DictReader(f)
    for row in steam_raw:
        ratings.append(dict(row))
'''
'''ratings = map(lambda x: {
    "userid": x["userid"],
    "game": x["game"],
    "user_rating": x["hoursplayed"]
},steam_raw)

ratings = list(map(lambda x:{x["userid"]},steam_raw))
'''
steam_raw = pd.read_csv("steam-200k.csv",usecols=[0,1,2,3],names=['userid','game','behavior','hoursplayed'])
#steam_raw.head()
#steam_raw.isnull().values.any()

steam_raw.head()
steam_raw.isnull().values.any()
steam_raw['userid'] = steam_raw.game.astype(str)
steam_raw['game'] = steam_raw.game.astype(str)
steam_raw['hoursplayed'] = steam_raw.hoursplayed.astype(int)

ratings = tf.data.Dataset.from_tensor_slices(dict(steam_raw)).map(lambda x: {
    "userid": x["userid"],
    "game": x["game"],
    "rating": int(x["hoursplayed"])
})

'''
for a in ratings:
  print(a )
'''
tf.random.set_seed(42)
#ratings = list(ratings)
#print(ratings[0])
#shuffled=random.shuffle(steam_raw)
shuffled = ratings.shuffle(100_000, seed=42, reshuffle_each_iteration=False)

train = shuffled.take(80_000)
test = shuffled.skip(80_000).take(20_000)

game = ratings.batch(1_000_000).map(lambda x: x["game"])
user_ids = ratings.batch(1_000_000).map(lambda x: x["userid"])

unique_game = np.unique(np.concatenate(list(game)))
unique_user_ids = np.unique(np.concatenate(list(user_ids)))

class RankingModel(tf.keras.Model):

  def __init__(self):
    super().__init__()
    embedding_dimension = 32

    # Compute embeddings for movies.
    self.game_embeddings = tf.keras.Sequential([
      tf.keras.layers.StringLookup(
        vocabulary=unique_game, mask_token=None),
      tf.keras.layers.Embedding(len(unique_game) + 1, embedding_dimension)
    ])

    # Compute embeddings for users.
    self.user_embeddings = tf.keras.Sequential([
      tf.keras.layers.StringLookup(
        vocabulary=unique_user_ids, mask_token=None),
      tf.keras.layers.Embedding(len(unique_user_ids) + 1, embedding_dimension)
    ])



    # Compute predictions.
    self.ratings = tf.keras.Sequential([
      # Learn multiple dense layers.
      tf.keras.layers.Dense(256, activation="relu"),
      tf.keras.layers.Dense(64, activation="relu"),
      # Make rating predictions in the final layer.
      tf.keras.layers.Dense(1)
  ])

  def call(self, inputs):

    user_id, game = inputs

    user_embedding = self.user_embeddings(user_id)
    game_embedding = self.game_embeddings(game)

    return self.ratings(tf.concat([user_embedding, game_embedding], axis=1))


class MovielensModel(tfrs.models.Model):

  def __init__(self):
    super().__init__()
    self.ranking_model: tf.keras.Model = RankingModel()
    self.task: tf.keras.layers.Layer = tfrs.tasks.Ranking(
      loss = tf.keras.losses.MeanSquaredError(),
      metrics=[tf.keras.metrics.RootMeanSquaredError()]
    )

  def call(self, features: Dict[str, tf.Tensor]) -> tf.Tensor:
    return self.ranking_model(
        (features["userid"], features["game"]))

  def compute_loss(self, features: Dict[Text, tf.Tensor], training=False) -> tf.Tensor:
    labels = features.pop("rating")

    rating_predictions = self(features)

    # The task computes the loss and the metrics.
    return self.task(labels=labels, predictions=rating_predictions)

#RankingModel()((["1"], ["Fallout 4"]))

model = MovielensModel()
model.compile(optimizer=tf.keras.optimizers.Adagrad(learning_rate=0.1))

cached_train = train.shuffle(100_000).batch(8192).cache()
cached_test = test.batch(4096).cache()

model.fit(cached_train, epochs=3)

model.evaluate(cached_test, return_dict=True)

test_ratings = {}
test_movie_titles = ["Nether", "RUSH", "Spore"]
for games in test_movie_titles:
  test_ratings[games] = model({
      "userid": np.array(["42"]),
      "game": np.array([games])
  })

print("Ratings:")
for title, score in sorted(test_ratings.items(), key=lambda x: x[1], reverse=True):
  print(f"{title}: {score}")