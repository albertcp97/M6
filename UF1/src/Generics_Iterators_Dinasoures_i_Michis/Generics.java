package Generics_Iterators_Dinasoures_i_Michis;

import java.util.ArrayList;

public class Generics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Muntanya m = new Muntanya(1000, "Montserrat");
		
		ArrayList<Clase_Generic> list= new ArrayList<>();
		
		list.add(new Clase_Generic<Muntanya>(m));
		list.add(new Clase_Generic<Muntanya>(new Muntanya(2000, "Mola")));
		list.add(new Clase_Generic<String>("Hola"));
		
		System.out.println(list);
		
		
	}

}
