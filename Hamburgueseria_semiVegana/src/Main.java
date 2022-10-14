
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Amborguesa a= new MuchaCarne(new Cebolla_pocha(new Lechuga(new Basic_amborguesa())));
		
		a.cocinar();
		System.out.println("");
		System.out.print("Para Carlos ");
		Amborguesa s= new Carne_Vegana(new Brocoli(new Lechuga(new Cebolla_pocha(new Basic_amborguesa()))));

		s.cocinar();
	}

}
