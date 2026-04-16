package act3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Persona{
	protected String nom, dni, tlf;
	protected LocalDate dataNaixement;

	public Persona(String nom, String dni, String dataNaixement, String tlf) {
		super();
		this.nom = nom;
		if(valDni(dni))this.dni = dni;
		else throw new IllegalArgumentException("Error: El dni es incorrecte");
		this.setDataNaixement(dataNaixement);
		this.tlf = tlf;
	}

	public Persona() {
		
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
	public void setDataNaixement(String dataNaixement) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if(valDataNaixement(dataNaixement))this.dataNaixement = LocalDate.parse(dataNaixement,format);
		else throw new IllegalArgumentException("Error: La data de naixement es incorrecta");
	}
	
	/**
	 * Validacio dni
	 * @param dni
	 * @return True / False
	 */
	public static boolean valDni(String dni) {
		String regex = "^\\d{8}[A-Z]$";
		return dni.matches(regex);
	}

	/**
	 * Validació de la data de naixement
	 * @param dataNaixement
	 * @return
	 */
	public static boolean valDataNaixement(String dataNaixement) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha = LocalDate.parse(dataNaixement, formato);
		if(fecha.isBefore(LocalDate.now()))return true;
		return false;
	}
	
	@Override
	public String toString() {
		return "Persona [nom=" + nom + ", dni=" + dni + ", tlf=" + tlf + ", dataNaixement=" + dataNaixement + "]";
	}
	

	
	
	

	
}
