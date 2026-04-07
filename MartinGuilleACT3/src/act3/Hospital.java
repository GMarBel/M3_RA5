package act3;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//ArrayList → Llista basada en array, ordenada, permet duplicats i té accés ràpid per índex.
//LinkedList → Llista de nodes enllaçats, ordenada, permet duplicats, inserció/eliminació ràpida però accés lent.
//HashMap → Clau-valor, basat en hash, claus úniques, sense ordre, accés.
//TreeMap → Clau-valor, arbre ordenat, claus úniques, accés.
//HashSet → Conjunt basat en hash, sense duplicats, sense ordre.
//TreeSet → Conjunt amb arbre ordenat, sense duplicats.

//Listas
//List<String> arrayList = new ArrayList<>();
//List<String> linkedList = new LinkedList<>();

//Mapas (clave-valor)
//Map<String, Integer> hashMap = new HashMap<>();
//Map<String, Integer> treeMap = new TreeMap<>();

//Conjuntos
//Set<String> hashSet = new HashSet<>();
//Set<String> treeSet = new TreeSet<>();

/*
public boolean equals(Object a) {
     return this.nom.equals(((Gos) a).getNom());
 }

 // hashCode calcula la clau hash que permet recuperar un element
 // Si dos elements tenen la mateixa clau van al mateix lloc
  
public int hashCode () {
     return this.nom.hashCode();
 }
}

COMPARE TO:
< 0    El objeto actual es menor que el objeto comparado 
0      Los dos objetos son iguales                       
> 0    El objeto actual es mayor que el objeto comparado 


*/

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
	
	
	
	
}
