package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;

public class GestorArchivos {

	// EJERCICIO 1 - Suma archivo
	public int leerArchivo(String archivo) throws FileNotFoundException, IOException {
		File f = new File(archivo);
		try (BufferedReader bReader = new BufferedReader(new FileReader(f))) {
			String linea;
			int res = 0;
			while ((linea = bReader.readLine()) != null) {
				res += Integer.parseInt(linea);
			}
			return res;
		} catch (FileNotFoundException e) {
			System.out.println("Fitxer no existeix");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	// EJERCICIO 2: Escribir en un fichero
	public boolean writeArchivo(String archivo) throws IOException {
		boolean append = false;
		Scanner sc = new Scanner(System.in);
		try (PrintWriter pWriter = new PrintWriter(new FileWriter(archivo, append))) {

			String linea = sc.nextLine();
			int cont = 0;
			while (!"fin".equals(linea.trim())) {
				String[] palabras = linea.split(" ");
				int contPalabras = palabras.length;
				cont += contPalabras;

				pWriter.println(linea + "	(Hay " + contPalabras + " palabras)");

				linea = sc.nextLine();
			}
			if (cont > 0)
				pWriter.println("Hay un total de " + cont + " palabras");
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	// EJERCICIO 3:

	// csv <-> vehiculo
	public Vehiculo toVehiculo(String linea) throws MatriculaInvalidaException {
	    String[] datos = linea.trim().split(";");

	    for (int i = 0; i < datos.length; i++) {
	        datos[i] = datos[i].trim();
	    }

	    if (!"cotxe".equals(datos[0]) && !"moto".equals(datos[0])) return null;

	    String mat = datos[1];
	    int km = Integer.parseInt(datos[2]);
	    String marca = datos[3];
	    String modelo = datos[4];
	    String color = datos[5];

	    if ("cotxe".equals(datos[0])) {
	        int numPuertas = Integer.parseInt(datos[6]);
	        boolean esAuto = Boolean.parseBoolean(datos[7]);
	        return new Coche(mat, km, marca, modelo, color, numPuertas, esAuto);
	    }

	    if ("moto".equals(datos[0])) {
	        int cc = Integer.parseInt(datos[6]);
	        String tipo = datos[7];
	        return new Moto(mat, km, marca, modelo, color, cc, tipo);
	    }

	    return null;
	}

	public String toCSV(Vehiculo v) {
		return v.toString();
	}
	
	
	public void mostrarVehiculos(Set<Vehiculo> vehiculos) {
		for(Vehiculo v: vehiculos) {
			System.out.println(v.mostrarLinea());			
		}
	}
	
	public Vehiculo buscarVehiculo(String matricula,Set<Vehiculo> vehiculos) {
		for(Vehiculo v: vehiculos) {
			if(matricula.matches(v.getMatricula())) {
				return v;
			}
		}
		return null;
	}
	
	public boolean borrarVehiculo(String matricula,Set<Vehiculo> vehiculos) {
		Vehiculo v = buscarVehiculo(matricula,vehiculos);
		if(v!=null)return vehiculos.remove(v);
		return false;
	}
	
	public Vehiculo cocheMayorKm(Set<Vehiculo> vehiculos) {
		Coche masKm = null;
	    for (Vehiculo v : vehiculos) {
	        if (v instanceof Coche) {
	            Coche c = (Coche) v;
	            if (masKm == null || c.getKm() > masKm.getKm()) {
	                masKm = c;
	                
	            }
	        }
	    }
	    return masKm;
	}
	
}
