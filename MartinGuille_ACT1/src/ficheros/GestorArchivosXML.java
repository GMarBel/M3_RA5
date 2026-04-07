package ficheros;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class GestorArchivosXML extends GestorArchivos implements InterfaceGestorArchivos {
    @Override
    public Set<Vehiculo> leer(String archivo) {
	    Set<Vehiculo> vehiculos = new TreeSet<>();
	    File f = new File(archivo);
	    
	    try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(f)))) {
	        vehiculos = (Set<Vehiculo>) decoder.readObject();
	    } catch (FileNotFoundException e) {
	        System.out.println("El archivo XML no existe.");
	    } catch (Exception e) {
	        System.out.println("Error al cargar XML: " + e.getMessage());
	    }
	    return vehiculos;
	}

    @Override
    public boolean guardar(String archivo, Set<Vehiculo> vehiculos) {
	    File f = new File(archivo);
	    try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(f)))) {
	        encoder.writeObject(vehiculos);
	        return true;
	    } catch (FileNotFoundException e) {
	        System.out.println("No se pudo crear el archivo XML");
	        return false;
	    } catch (Exception e) {
	        System.out.println("Error al guardar XML: " + e.getMessage());
	        return false;
	    }
	}
}