
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Jefe d= new Jefe();
		
		Trabajador p1= new Trabajador("Napo");
		Trabajador p2= new Trabajador("Pingu");
		Trabajador p3= new Trabajador("Bob el Manetes");
		Trabajador p4= new Trabajador("Humero");
		
		d.support.addPropertyChangeListener(p1);
		d.support.addPropertyChangeListener(p2);
		d.support.addPropertyChangeListener(p3);
		d.support.addPropertyChangeListener(p4);
		
		
		for(int i= 0; i<12;i++)
			try {
				d.setNew();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

}
