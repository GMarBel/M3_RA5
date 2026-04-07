package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;

public class GestorArchivosCSV extends GestorArchivos implements InterfaceGestorArchivos {
	
	@Override
	public Set<Vehiculo> leer(String archivo) throws MatriculaInvalidaException {
		Set<Vehiculo> vehiculos = new TreeSet<>();
		File f = new File(archivo);
		try (BufferedReader bReader = new BufferedReader(new FileReader(f))) {
			String linea;
			while ((linea = bReader.readLine()) != null) {
				linea = linea.trim();
				if (linea.startsWith("#") || linea.isEmpty()) continue;
				Vehiculo v = toVehiculo(linea);
				if (v != null)
					vehiculos.add(v);
			}
			return vehiculos;
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return vehiculos;
	}

	@Override
	public boolean guardar(String nombreArchivo, Set<Vehiculo> vehiculos) {
		boolean append = false;
		try (PrintWriter pWriter = new PrintWriter(new FileWriter(nombreArchivo, append))) {
			pWriter.println("#Nuevo archivo de vehiculos");
			for(Vehiculo v : vehiculos) {
				pWriter.println(toCSV(v));
			}
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
	        return false;
		} catch (IOException e) {
			System.out.println(e.getMessage());
	        return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        return false;
		}
	}
}
