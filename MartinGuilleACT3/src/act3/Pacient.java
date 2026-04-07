package act3;

import java.time.LocalDate;
import java.util.Objects;

public class Pacient extends Persona{
	private String codi, historial;
	private static int numPacientes = 0;
	
	public Pacient(String nom, String dni, LocalDate dataNaixement, String tlf, String codi, String historial) throws InvalidCodiPacientException {
		super(nom, dni, dataNaixement, tlf);
		if(valCodi(codi))this.codi = codi;
		else throw new InvalidCodiPacientException();
		this.historial = historial;
		numPacientes++;
	}

	public Pacient(String nom, String dni, LocalDate dataNaixement, String tlf, String codi) {
		super(nom, dni, dataNaixement, tlf);
		this.codi = codi;
		numPacientes++;
	}

	public String getCodi() {
		return codi;
	}

	public void setCodi(String codi) throws InvalidCodiPacientException {
		if(valCodi(codi))this.codi = codi;
		else throw new InvalidCodiPacientException();
	}

	public String getHistorial() {
		return historial;
	}

	public void setHistorial(String historial) {
		this.historial = historial;
	}
	
	/**
	 * Validacio codi Pacient
	 * @param codi
	 * @return True / False
	 */
	public static boolean valCodi(String codi) {
		String regex ="^[A-Z]{3}\\d{8}$";
		return regex.matches(codi);
	}

	@Override
	public String toString() {
		return "Pacient [nom=" + nom + ", dni=" + dni + ", tlf=" + tlf + ", dataNaixement=" + dataNaixement + ", codi="
				+ codi + ", historial=" + historial + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codi, historial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacient other = (Pacient) obj;
		return Objects.equals(codi, other.codi) && Objects.equals(historial, other.historial);
	}
	
	
	
	
	
	
}
