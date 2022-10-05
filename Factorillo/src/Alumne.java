
public class Alumne implements Persona{
	public String nom;
	
	public Alumne(String nom) {
		this.nom = nom;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Alumne "+nom;
	}

}
