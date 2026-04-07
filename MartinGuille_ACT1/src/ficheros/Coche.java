package ficheros;

public class Coche  extends Vehiculo{
	private int numPuertas;
	private boolean esAuto;
	
	public Coche(String matricula, int km, String marca, String modelo, String color, int numPuertas, boolean esAuto)
			throws MatriculaInvalidaException {
		super(matricula, km, marca, modelo, color);
		this.numPuertas = numPuertas;
		this.esAuto = esAuto;
	}
	
	public Coche(){
		super();
	}
	
	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public boolean isEsAuto() {
		return esAuto;
	}

	public void setEsAuto(boolean esAuto) {
		this.esAuto = esAuto;
	}

	@Override
	public String toString() {
	    return "cotxe;" + matricula + ";" + km + ";" + marca + ";" + modelo + ";" + color + ";"
	            + numPuertas + ";" + esAuto;
	}
	
	    
}
