
public class MuchaCarne extends AmborguesaDecorator{

	public MuchaCarne(Amborguesa s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void cocinar() {
		// TODO Auto-generated method stub
		super.cocinar();
		System.out.print(" mucha carne ");
	}

}
