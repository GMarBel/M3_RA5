package act3;

public class Especialitat {
	private String nom,desc;
	private int edadMin,edadMax;
	
	public Especialitat(String nom, String desc, int edadMin, int edadMax) {
		super();
		this.nom = nom;
		this.desc = desc;
		this.edadMin = edadMin;
		this.edadMax = edadMax;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getEdadMin() {
		return edadMin;
	}

	public void setEdadMin(int edadMin) {
		this.edadMin = edadMin;
	}

	public int getEdadMax() {
		return edadMax;
	}

	public void setEdadMax(int edadMax) {
		this.edadMax = edadMax;
	}

	@Override
	public String toString() {
		return "Especialitat [nom=" + nom + ", desc=" + desc + ", edadMin=" + edadMin + ", edadMax=" + edadMax + "]";
	}
	
	
}
