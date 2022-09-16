package Generics_Iterators_Dinasoures_i_Michis;

public class Dino {

	public String nom;
	public int altura;
	public int pes;
	
	
	public Dino(String nom, int altura, int pes) {
		super();
		this.nom = nom;
		this.altura = altura;
		this.pes = pes;
	}
	

	@Override
	public String toString() {
		return "Dino [nom=" + nom + ", altura=" + altura + "m, pes=" + pes + "kg]";
	}
	
}
