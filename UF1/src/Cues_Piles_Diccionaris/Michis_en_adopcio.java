package Cues_Piles_Diccionaris;

public class Michis_en_adopcio {

	private String nom;
	private String color;
	public Michis_en_adopcio(String nom, String color) {
		super();
		this.nom = nom;
		this.color = color;
	}
	public String getNom() {
		return nom;
	}
	@Override
	public String toString() {
		return "Michis: "+nom+" "+color;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
