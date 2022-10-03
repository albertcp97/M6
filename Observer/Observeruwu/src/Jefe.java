import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Jefe {
	
	private String news;

    public PropertyChangeSupport support;
    
    public Jefe() {
		super();
		this.support = new PropertyChangeSupport(this);
	}

	public void setNew() throws InterruptedException {
    	
    	Random random = new Random();
    	
    	while (random.nextInt(1, 20)!=10) {
			Thread.sleep(1000);
			System.out.println("Esperate, me estoy haciendo el café, con Napo");
			
		}
    	support.firePropertyChange("news", this.news, "Hola");
    	
    }

}
