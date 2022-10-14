
public class Carne_Vegana extends AmborguesaDecorator{

	public Carne_Vegana(Amborguesa s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cocinar() {
		// TODO Auto-generated method stub
		super.cocinar();
		System.out.print(" carne vegana (puede contener trazas de carne)");
	}

}
