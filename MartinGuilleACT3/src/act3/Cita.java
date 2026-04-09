package act3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Cita implements Comparable<Cita>{
	private Pacient pacient;
	private Doctor doctor;
	private LocalDate data;
	private LocalTime hora;
	private Estat estat;

	public Cita(Pacient pacient, Doctor doctor, LocalDate data, LocalTime hora) {
	    java.time.LocalDateTime citaTime = java.time.LocalDateTime.of(data, hora);
	    if (citaTime.isBefore(java.time.LocalDateTime.now())) {
	        throw new IllegalArgumentException("La data de la cita ha de ser posterior a l'actual");
	    }
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
	    int edad = java.time.Period.between(persona.getDataNaixement(), LocalDate.now()).getYears();
	    
	    Especialitat e = doctor.getEspecialitat();
	    return edad >= e.getEdadMin() && edad <= e.getEdadMax();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cita other = (Cita) obj;
		return Objects.equals(data, other.data) && Objects.equals(doctor, other.doctor)
				&& Objects.equals(hora, other.hora) && Objects.equals(pacient, other.pacient);
	}

	

	@Override
	public int compareTo(Cita c) {
		int fecha = this.data.compareTo(c.data);
		if(fecha != 0) return fecha;
		return this.hora.compareTo(c.hora);
	}

	@Override
	public String toString() {
		return "Cita [pacient=" + pacient + ", doctor=" + doctor + ", data=" + data + ", hora=" + hora + ", estat="
				+ estat + "]";
	}
	
	
	
	
}
