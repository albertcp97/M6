
public class PersonaEnCentre {

	public Persona getPersonal(String rol, String nom) {

		switch (rol.toLowerCase()) {
		case "alumne":
			return new Alumne(nom);
		case "professor":
			return new Profe(nom);
		case "director":
			return new Director(nom);
		case "marc":
			return new Cordinador(nom);
		default:
			System.out.println("Escribe bien manco de 'NAPO'");
			return null;

		}

	}
}
