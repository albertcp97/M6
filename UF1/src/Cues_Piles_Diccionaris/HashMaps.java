package Cues_Piles_Diccionaris;
import java.util.HashMap;

public class HashMaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Omplirem un hashmap amb els alumnes i el seu joc favorit
		HashMap<String, String> map_joc_alumne = new HashMap<String, String>();
		

		//Afegim keys i values
		map_joc_alumne.put("Albert", "Hollow Knight");
		map_joc_alumne.put("Polillo", "Furbo");
		map_joc_alumne.put("Aleix", "GTA V remake ps6 goty edition");
		
		System.out.println(map_joc_alumne);
		
		//imprimim totes les keys
		for (String i : map_joc_alumne.keySet()) {
			  System.out.println(i);
			}

		//imprimim tots els values
		for (String i : map_joc_alumne.values()) {
			  System.out.println(i);
			}
		
		//podem eliminar un objecte del hashmap amb el nom de la key
		System.out.println(map_joc_alumne.remove("Polillo"));
		
		// Per remplaçar un valor
		System.out.println(map_joc_alumne.replace("Albert", "Fornite"));
		

		System.out.println(map_joc_alumne);
		
		//que pasa si intento omplir de nou Albert?
		map_joc_alumne.put("Albert", "Hollow Knight");
		
		System.out.println(map_joc_alumne);
		
		//mostrar dades conjuntes
		for (String i : map_joc_alumne.keySet()) {
			  System.out.println("key: " + i + " value: " + map_joc_alumne.get(i));
			}
	}

}
