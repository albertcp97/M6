package Cues_Piles_Diccionaris;
import java.util.Stack;

public class Pila {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack cua_en_adopcio = new Stack();
		
		Michis_en_adopcio michi1= new Michis_en_adopcio("Lulo", "Talanjo");
		Michis_en_adopcio michi2= new Michis_en_adopcio("Kernel", "Color pernilet dolç");
		Michis_en_adopcio michi3 = new Michis_en_adopcio("Wancho","Verd");
		
		//afegim els gatets
		cua_en_adopcio.push(michi1);
		cua_en_adopcio.push(michi2);
		cua_en_adopcio.push(michi3);
		
		//pudem imprimir la cua sencera
		System.out.println(cua_en_adopcio);


		System.out.println("Esta buida?: "+cua_en_adopcio.isEmpty());
		System.out.println("numero elements: "+cua_en_adopcio.size());
		
		//pudem imprimir el primer element
		System.out.println(cua_en_adopcio.firstElement());
		//pudem imprimir per index
		System.out.println(cua_en_adopcio.get(1));
		//pudem imprimir per index
		System.out.println(cua_en_adopcio.elementAt(1));
		//pudem imprimir l'ultim element
		System.out.println(cua_en_adopcio.lastElement());
		
		System.out.println("numero elements: "+cua_en_adopcio.size());

		//pudem imprimir el primer element i esborrar-ho
		System.out.println(cua_en_adopcio.pop());	

		//pudem afegir un element a una posicio 
		cua_en_adopcio.add(1, michi3);
		
		System.out.println(cua_en_adopcio);
		
		System.out.println("numero elements: "+cua_en_adopcio.size());	
		
		//pudem buidar-la sencera amb:
		cua_en_adopcio.clear();

		System.out.println("numero elements: "+cua_en_adopcio.size());
	}

}
