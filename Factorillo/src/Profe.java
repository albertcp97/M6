
public class Profe implements Persona{
	public String nom;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Profe "+nom;
	}

	public Profe(String nom) {
		super();
		this.nom = nom;
	}
}
