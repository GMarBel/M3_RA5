package act3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class GestorCSV implements InterfaceGestorFitxers{

	public Pacient toPacient(String linea) throws InvalidCodiPacientException {
		 String[] datos = linea.trim().split(";");
		 for (int i = 0; i < datos.length; i++) datos[i] = datos[i].trim();
	     
		 String nom = datos[0];
		 String dni = datos[1];
		 String dataNaix = datos[2];
		 String telefon = datos[3];
		 String codi = datos[4];
		 String historial = datos[5];
		 
		 Pacient p = new Pacient(nom,dni,dataNaix,telefon,codi,historial);
		 return p;
	}
	
	public String toCSV(Pacient p) {
		return p.getNom() + ";" + p.getDni() + ";" + p.getDataNaixement() + ";" + p.getTlf() + ";" + p.getCodi() + ";" + p.getHistorial();
	}

	@Override
	public boolean desaPacients(String nomFitxer, Set<Pacient> listaPacients) throws InvalidCodiPacientException {
		boolean append = false;
		try (PrintWriter pWriter = new PrintWriter(new FileWriter(nomFitxer, append))) {
			pWriter.println("#Nuevo archivo de vehiculos");
			for(Pacient p : listaPacients) {
				pWriter.println(toCSV(p));
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

	@Override
	public Set<Pacient> llegirPacients(String nomFitxer) throws IOException, InvalidCodiPacientException {
		Set<Pacient> listaPacients = new TreeSet<>();
		File f = new File(nomFitxer);
		try (BufferedReader bReader = new BufferedReader(new FileReader(f))) {
			String linea;
			while ((linea = bReader.readLine()) != null) {
				linea = linea.trim();
				if (linea.startsWith("#") || linea.isEmpty()) continue;
				Pacient p = toPacient(linea);
				if (p != null)
					listaPacients.add(p);
			}
			return listaPacients;
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return listaPacients;
	}
}
