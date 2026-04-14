package act3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Hospital {
	private String nom,adreça;
	private Set<Pacient> listaPacients;
	private Set<Doctor> listaDoctors;
	private Set<Especialitat> listaEspecialitats;
	private Set<Cita> listaCites;
	
	public Hospital(String nom, String adreça) {
		super();
		this.nom = nom;
		this.adreça = adreça;
		this.listaPacients = new HashSet<>();
		this.listaDoctors = new HashSet<>();
		this.listaEspecialitats = new HashSet<>();
		this.listaCites = new TreeSet<>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdreça() {
		return adreça;
	}

	public void setAdreça(String adreça) {
		this.adreça = adreça;
	}

	public Set<Pacient> getListaPacients() {
		return listaPacients;
	}

	public void setListaPacients(Set<Pacient> listaPacients) {
		this.listaPacients = listaPacients;
	}

	public Set<Doctor> getListaDoctors() {
		return listaDoctors;
	}

	public void setListaDoctors(Set<Doctor> listaDoctors) {
		this.listaDoctors = listaDoctors;
	}

	public Set<Especialitat> getListaEspecialitats() {
		return listaEspecialitats;
	}

	public void setListaEspecialitats(Set<Especialitat> listaEspecialitats) {
		this.listaEspecialitats = listaEspecialitats;
	}

	public Set<Cita> getListaCites() {
		return listaCites;
	}

	public void setListaCites(Set<Cita> listaCites) {
		this.listaCites = listaCites;
	}
	
	//pacientes
	/**
	 * Registrar pacientes
	 * @param p
	 * @return
	 */
	public boolean registrarPacient(Pacient p) {
		if(p == null)return false;
		return listaPacients.add(p);
	}
	
	/**
	 * Buscar pacientes mediante su dni
	 * @param dni
	 * @return
	 */
	public Pacient buscarPacient(String dni) {
		if(dni.isEmpty())return null;
		for(Pacient p: listaPacients) {
			if(p.getDni().equals(dni))return p;
		}
		return null;
	}
	
	/**
	 * Eliminar pacientes mediante su dni
	 * @param dni
	 * @return
	 */
	public boolean eliminarPacient(String dni) {
		Pacient p = buscarPacient(dni);
		if(p ==null)return false;
		for(Cita c : listaCites) {
			if(c.getPacient().equals(p)) {
				c.cancelarCita();
			}
		}
		return listaPacients.remove(p);
	}
	
	/**
	 * Mostrar los datos de todos los pacientes de la lista
	 */
	public void mostrarDadesPacients() {
		for(Pacient p : listaPacients) {
			System.out.println( 
						p.getNom() +
						"\nDNI: " + p.getDni() +
						"\nData naixement: " + p.getDataNaixement()+
						"\nTelefon: " + p.getTlf()+
						"\nCodi pacient: " + p.getCodi()+
						"\nHistorial medic: " + p.getHistorial()
					);
		}
	}
	
	/**
	 * Mostrar numero de pacientes en el hospital
	 */
	public void mostrarNumPacients() {
		System.out.println("Num pacients: " + listaPacients.size());
	}
	
	//doctores
	/**
	 * Registrar doctores en la lista doctores
	 * @param d
	 * @return
	 */
	public boolean registrarDoctor(Doctor d) {
		if(d == null)return false;
		return listaDoctors.add(d);
	}
	
	/**
	 * Mostrar los datos de los doctores
	 */
	public void mostrarDadesDoctors() {
		for(Doctor d : listaDoctors) {
			System.out.println( 
						d.getNom() +
						"\nDNI: " + d.getDni() +
						"\nData naixement: " + d.getDataNaixement()+
						"\nTelefon: " + d.getTlf() +
						"\nEspecialidad: " + d.getEspecialitat().getNom() +
						"\nCodi: " + d.getCodi()
					);
		}
	}
	
	//especialitats
	/**
	 * Registrar especialidades en la lista de especialidades
	 * @param e
	 * @return
	 */
	public boolean registrarEspecialitat(Especialitat e) {
		if(e == null)return false;
		return listaEspecialitats.add(e);
	}
	
	/**
	 * Mostrar lista especialidades
	 */
	public void mostrarEspecialidades() {
		for(Especialitat e : listaEspecialitats) {
			System.out.println(
						e.getNom() +
						"\nDesc: " + e.getDesc()+
						"\nEdat minima: " + e.getEdadMin()+
						"\nEdat maxima: " + e.getEdadMax()
						
					);
		}
	}
	
	//cites
	/**
	 * Registrar citas en la lista 
	 * @param c
	 * @return
	 */
	public boolean registrarCita(Cita c) {
		if(c == null)return false; 
		return listaCites.add(c);
	}
	
	/**
	 * Buscar una cita en la lista
	 * @param nom
	 * @param data
	 * @param hora
	 * @return
	 */
	public Cita buscarCitaPacient(String dni, LocalDate data, LocalTime hora) {
		for(Cita c : listaCites) {
			if(c.getPacient().getDni().equals(dni)
					&& c.getData().equals(data)
					&& c.getHora().equals(hora))return c;
		}
		return null;
	}
	
	public Cita buscarCitaDoctor(String dni, LocalDate data, LocalTime hora) {
		for(Cita c : listaCites) {
			if(c.getDoctor().getDni().equals(dni)
					&& c.getData().equals(data)
					&& c.getHora().equals(hora))return c;
		}
		return null;
	}
	
	/**
	 * Cancelar citas
	 * @param c
	 * @return
	 */
	public boolean cancelarCita(String dni,LocalDate data, LocalTime hora) {
		Cita cita = buscarCitaPacient(dni,data,hora);
		if(cita == null)return false;
		return cita.cancelarCita();
	}
	
	/**
	 * Confirmar citas
	 * @param c
	 * @return
	 */
	public boolean confirmarCita(String dni,LocalDate data, LocalTime hora) {
		Cita cita = buscarCitaDoctor(dni,data,hora);
		if(cita == null)return false;
		return cita.confirmarCita();
	}
	
	/**
	 * Muestra por consola todas las citas programadas para una fecha específica.
	 * @param fecha La fecha que queremos consultar.
	 */
	public void mostrarCitesPerDia(LocalDate fecha) {
	    System.out.println("--- Cites per al dia: " + fecha + " ---");
	    boolean hayCitas = false;
	    
	    for (Cita c : listaCites) {
	        if (c.getData().equals(fecha)) {
	            System.out.println(c.getHora() + " - Pacient: " + c.getPacient().getNom() + 
	                               " | Doctor: " + c.getDoctor().getNom() + 
	                               " [" + c.getEstat() + "]");
	            hayCitas = true;
	        }
	    }
	    
	    if (!hayCitas) {
	        System.out.println("No hi ha cites programades per a este dia.");
	    }
	}
	
}
