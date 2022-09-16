package Generics_Iterators_Dinasoures_i_Michis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterator_Rex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Dino> list= new ArrayList<Dino>();
		
		list.add(new Dino("T-Rex", 50, 1000));
		list.add(new Dino("Velocirraptor", 2, 100));
		list.add(new Dino("Michisaure", 300, 5000));
		list.add(new Dino("Albertosaurus", 30, 600));
		
		Iterator<Dino> iterator= list.iterator();
		
		while(iterator.hasNext())
		{
			
			System.out.println(iterator.next());
		}
		
		while(iterator.hasNext())
		{
			
			System.out.println(iterator.next());
		}
		
		iterator= list.iterator();
		while(iterator.hasNext())
		{
			Dino d= iterator.next();
			if(d.nom.equals("Michisaure"))
			{
				System.err.println(d.nom+" Tu no ets un dinosaure");
				iterator.remove();				
			}else	
				System.out.println(d);
		}
	}

}
