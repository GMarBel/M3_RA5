package act3;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class GestorXML implements InterfaceGestorFitxers {

	@Override
	public boolean desaPacients(String nomFitxer, Set<Pacient> listaPacients) throws InvalidCodiPacientException {
		 File f = new File(nomFitxer);
		    try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(f)))) {
		        encoder.writeObject(listaPacients);
		        return true;
		    } catch (FileNotFoundException e) {
		        System.out.println("No se pudo crear el archivo XML");
		        return false;
		    } catch (Exception e) {
		        System.out.println("Error al guardar XML: " + e.getMessage());
		        return false;
		    }
	}

	@Override
	public Set<Pacient> llegirPacients(String nomFitxer) throws IOException, InvalidCodiPacientException {
		Set<Pacient> listaPacients = new TreeSet<>();
	    File f = new File(nomFitxer);
	    
	    try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(f)))) {
	        listaPacients = (Set<Pacient>) decoder.readObject();
	    } catch (FileNotFoundException e) {
	        System.out.println("El archivo XML no existe.");
	    } catch (Exception e) {
	        System.out.println("Error al cargar XML: " + e.getMessage());
	    }
	    return listaPacients;
	}

}
