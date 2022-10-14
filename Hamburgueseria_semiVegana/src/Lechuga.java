
public class Lechuga extends AmborguesaDecorator{

	public Lechuga(Amborguesa s) {
		super(s);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void cocinar() {
		// TODO Auto-generated method stub
		super.cocinar();
		System.out.print(" lechuga pocha ");
	}
}
