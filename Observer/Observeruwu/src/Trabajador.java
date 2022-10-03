import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

public class Trabajador implements PropertyChangeListener{
int salario=2;
String nom="";
public Trabajador(String nom) {
	super();
	this.nom = nom;
}
int ahorros_actual=0;
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
		Random random = new Random();
    	int i =0;
    	while (random.nextInt(1, 5)!=2) {
    		try {
				Thread.sleep(1000);
				i++;
				System.err.println("Oye no he cobrado hoy");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if(i!=0)
    		System.out.println("He tardado "+i+" dias en cobrar de más");
    	
    	System.out.println("He cobrado");
    	ahorros_actual+=salario;
    	System.out.println(nom+" tengo "+ahorros_actual+" €");
	}

}
