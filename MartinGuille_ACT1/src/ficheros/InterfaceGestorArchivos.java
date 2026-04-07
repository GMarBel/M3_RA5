package ficheros;

import java.util.Set;

public interface InterfaceGestorArchivos {
	Set<Vehiculo> leer(String nombreArchivo) throws Exception;
	boolean guardar(String nombreArchivo, Set<Vehiculo> vehiculos);
}
