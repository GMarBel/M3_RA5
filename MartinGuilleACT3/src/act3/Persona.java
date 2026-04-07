package act3;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Persona{
	protected String nom, dni, tlf;
	protected LocalDate dataNaixement;

	public Persona(String nom, String dni, LocalDate dataNaixement, String tlf) {
		super();
		this.nom = nom;
		if(valDni(dni))this.dni = dni;
		else throw new IllegalArgumentException("Error: El dni es incorrecte");
		this.dataNaixement = dataNaixement;
		this.tlf = tlf;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		if(valDni(dni))this.dni = dni;
		else throw new IllegalArgumentException("Error: El dni es incorrecte");
	}
	public String getTlf() {
		return tlf;
	}
	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
	public LocalDate getDataNaixement() {
		return dataNaixement;
	}
	public void setDataNaixement(LocalDate dataNaixement) {
		this.dataNaixement = dataNaixement;
	}
	
	/**
	 * Validacio dni
	 * @param dni
	 * @return True / False
	 */
	public static boolean valDni(String dni) {
		String regex = "^\\d{8}[A-Z]$";
		return regex.matches(dni);
	}

	@Override
	public String toString() {
		return "Persona [nom=" + nom + ", dni=" + dni + ", tlf=" + tlf + ", dataNaixement=" + dataNaixement + "]";
	}


	
	
	

	
}
