package act3;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
	private Pacient pacient;
	private Doctor doctor;
	private LocalDate data;
	private LocalTime hora;
	private Estat estat;
	
	public Cita(Pacient pacient, Doctor doctor, LocalDate data, LocalTime hora) {
		super();
		if(compEdad(pacient,doctor)) {
			this.pacient = pacient;
			this.doctor = doctor;
			this.data = data;
			this.hora = hora;
			this.estat = estat.PENDENT;
		}else throw new IllegalArgumentException("Error al crear la cita");
	}

	public Pacient getPacient() {
		return pacient;
	}

	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Estat getEstat() {
		return estat;
	}

	//metodos
	
	/**
	 * Confirmar citas
	 * @return True / False
	 */
	public boolean confirmarCita() {
		if(estat == estat.CANCELADA)return false;
		this.estat = estat.REALITZADA;
		return true;
	}
	
	/**
	 * Cancelar citas
	 * @return
	 */
	public boolean cancelarCita() {
		if(estat == estat.PENDENT) {
			this.estat = estat.CANCELADA;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Comprovació de la edad de la cita
	 * @param 
	 * @param 
	 * @return
	 */
	public boolean compEdad(Persona persona, Doctor doctor) {
		LocalDate dataNaix = persona.getDataNaixement();
		int año = dataNaix.getYear();
		int diaAño = dataNaix.getDayOfYear();
		
		LocalDate hoy = LocalDate.now();
		
		int edad = hoy.getYear() - año;
		if(diaAño < hoy.getDayOfYear()) edad = edad - 1;
		
		Especialitat especialitat = doctor.getEspecialitat();
		int edadMin = especialitat.getEdadMin();
		int edadMax = especialitat.getEdadMax();
		
		if(edad>edadMin && edad<edadMax)return true;
		return false;
	}
	
	
	
}
