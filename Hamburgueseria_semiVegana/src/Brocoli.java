
public class Brocoli extends AmborguesaDecorator{

	public Brocoli(Amborguesa s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cocinar() {
		// TODO Auto-generated method stub
		super.cocinar();
		System.out.print(" brocoli para Carlos ");
	}
}
