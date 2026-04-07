package act3;

public class InvalidCodiPacientException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidCodiPacientException() {
		super("Error: Codi del Pacient incorrecte");
	}
}
