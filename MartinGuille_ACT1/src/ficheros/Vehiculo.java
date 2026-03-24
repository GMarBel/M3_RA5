package ficheros;

public abstract class Vehiculo implements Comparable<Vehiculo>{
	protected String matricula,marca,modelo,color;
	protected int km;
	
	public Vehiculo(String matricula, int km, String marca, String modelo, String color) throws MatriculaInvalidaException {
		super();
		if(validacionMatricula(matricula))this.matricula = matricula;
		else throw new MatriculaInvalidaException();
		if(km>0)this.km = km;
		else throw new IllegalArgumentException("Los km no pueden ser menor a 0");
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		if(km>0)this.km = km;
		else throw new IllegalArgumentException("Los km no pueden ser menor a 0");
	}
	
	
	//validacion matricula
	public static boolean validacionMatricula(String mat) {
		String regex1 = "^\\d{4}[A-Z]{3}$";
		String regex2 = "^\\d{4}-[A-Z]{3}$";

		if (mat.matches(regex1) || mat.matches(regex2))
			return true;
		return false;
	}
	
	@Override
    public int compareTo(Vehiculo otro) {
        return this.matricula.compareTo(otro.matricula);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return matricula.equals(vehiculo.matricula);
    }

    @Override
    public int hashCode() {
        return matricula.hashCode();
    }
}
