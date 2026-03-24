package ficheros;

public class Moto extends Vehiculo{
	private int cc;
	private String tipo;
	public Moto(String matricula, int km, String marca, String modelo, String color, int cc, String tipo)
			throws MatriculaInvalidaException {
		super(matricula, km, marca, modelo, color);
		this.cc = cc;
		this.tipo = tipo;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "moto;" + matricula + ";" + marca + ";" + modelo + ";" + color + ";"
				+ km + ";" + cc + ";" + tipo ;
	}
	
	
	
	
}
