package act3;

import java.time.LocalDate;
import java.util.Objects;

public class Doctor extends Persona{
	private Especialitat especialitat;
	private int codi;
	private static int numDoctors = 0;
	
	public Doctor(String nom, String dni, String dataNaixement, String tlf, Especialitat especialitat) {
		super(nom, dni, dataNaixement, tlf);
		this.especialitat = especialitat;
		this.codi = numDoctors + 1;
		numDoctors++;
	}

	public Especialitat getEspecialitat() {
		return especialitat;
	}

	public void setEspecialitat(Especialitat especialitat) {
		this.especialitat = especialitat;
	}

	public int getCodi() {
		return codi;
	}

	public void setCodi(int codi) {
		this.codi = codi;
	}

	@Override
	public String toString() {
		return "Doctor [nom=" + nom + ", dni=" + dni + ", tlf=" + tlf + ", dataNaixement=" + dataNaixement
				+ ", especialitat=" + especialitat + ", codi=" + codi + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codi, especialitat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return codi == other.codi && Objects.equals(especialitat, other.especialitat);
	}
	
	
}
