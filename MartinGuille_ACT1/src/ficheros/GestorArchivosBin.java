package ficheros;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class GestorArchivosBin extends GestorArchivos implements InterfaceGestorArchivos,Serializable{

	@Override
	public Set<Vehiculo> leer(String archivo) {
	    Set<Vehiculo> vehiculos = new TreeSet<>();
	    File f = new File(archivo);
	    
	    try (ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(f))) {
	        while (true) {
	            try {
	                Vehiculo v = (Vehiculo) fileIn.readObject();
	                if (v != null) {
	                    vehiculos.add(v);
	                }
	            } catch (EOFException e) {
	                break; 
	            }
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("El archivo Bin no existe.");
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Error al cargar Bin: " + e.getMessage());
	    }
	    return vehiculos;
	}

    @Override
    public boolean guardar(String archivo, Set<Vehiculo> vehiculos) {
	    File f = new File(archivo);
	    try (ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(f))) {
	        for(Vehiculo v : vehiculos) {
	        	fileOut.writeObject(v);
	        }
	        fileOut.close();
	        return true;
	    } catch (FileNotFoundException e) {
	        System.out.println("No se pudo crear el archivo Bin");
	        return false;
	    } catch (Exception e) {
	        System.out.println("Error al guardar Bin: " + e.getMessage());
	        return false;
	    }
	}
	
	
}
