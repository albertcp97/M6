package Generics_Iterators_Dinasoures_i_Michis;

public class Clase_Generic <T>{
	public T objecte;

	public Clase_Generic(T objecte) {
		super();
		this.objecte = objecte;
	}

	@Override
	public String toString() {
		return "Clase_Generic [objecte=" + objecte + ": "+objecte.getClass()+"]";
	}
}
