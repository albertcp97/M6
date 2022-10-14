
public abstract class AmborguesaDecorator implements Amborguesa{

	Amborguesa s;

	public AmborguesaDecorator(Amborguesa s) {
		super();
		this.s = s;
	}
	@Override
	public void cocinar() {
		// TODO Auto-generated method stub
		s.cocinar();
	}
	
}
