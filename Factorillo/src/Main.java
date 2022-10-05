
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PersonaEnCentre p= new PersonaEnCentre();
		
		Persona al= p.getPersonal("alumne", "Wancho");
		
		System.out.println("Etoo "+al.getName());
		
		 al= p.getPersonal("professor", "Wancho");
		
		System.out.println("Etoo "+al.getName());
		
		al= p.getPersonal("marc", "Marc");
		
		System.out.println("Etoo "+al.getName());
	}

}
