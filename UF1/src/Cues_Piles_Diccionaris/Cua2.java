package Cues_Piles_Diccionaris;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Cua2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Michis_en_adopcio> cua_en_adopcio= new LinkedList<>();
		
		//Amb Deque podem accedir tant a la primera posicio com a la segona
		
		//generem uns quants gatets
		
		Michis_en_adopcio michi1= new Michis_en_adopcio("Lulo", "Talanjo");
		Michis_en_adopcio michi2= new Michis_en_adopcio("Kernel", "Color pernilet dolç");
		Michis_en_adopcio michi3 = new Michis_en_adopcio("Wancho","Verd");
		
		//afegim els gatets
		cua_en_adopcio.add(michi1);
		cua_en_adopcio.add(michi2);
		cua_en_adopcio.add(michi3);
		
		//pudem imprimir la cua sencera
		System.out.println(cua_en_adopcio);


		System.out.println("Esta buida?: "+cua_en_adopcio.isEmpty());
		System.out.println("numero elements: "+cua_en_adopcio.size());
		
		//pudem imprimir el primer element
		System.out.println(cua_en_adopcio.element());
		System.out.println(cua_en_adopcio.getFirst());
		
		System.out.println("numero elements: "+cua_en_adopcio.size());

		//pudem imprimir el primer element i esborrar-ho
		System.out.println(cua_en_adopcio.remove());
		//System.out.println(cua_en_adopcio.removeFirst());	
		

		System.out.println(cua_en_adopcio);

		System.out.println("numero elements: "+cua_en_adopcio.size());
		
		//pudem imprimir l'ultim element i esborrar-ho
		System.out.println(""+cua_en_adopcio.getLast());
		

		//pudem imprimir l'ultim element i esborrar-ho
		System.out.println(""+cua_en_adopcio.removeLast());
		
		System.out.println(cua_en_adopcio);
		
		System.out.println("numero elements: "+cua_en_adopcio.size());
		
		//pudem buidar-la sencera amb:
		cua_en_adopcio.clear();
		
	}

}
