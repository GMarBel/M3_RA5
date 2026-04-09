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

public class GestorCSV implements InterfaceGestorFitxers{

	public Pacient toPacient(String linea) throws InvalidCodiPacientException {
		 String[] datos = linea.trim().split(";");
		 for (int i = 0; i < datos.length; i++) datos[i] = datos[i].trim();
	     
		 String nom = datos[0];
		 String dni = datos[1];
		 LocalDate dataNaix = LocalDate.parse(datos[2]);
		 String telefon = datos[3];
		 String codi = datos[4];
		 String historial = datos[5];
		 
		 Pacient p = new Pacient(nom,dni,dataNaix,telefon,codi,historial);
		 return p;
	}
	
	public String toCSV(Pacient p) {
		return p.getNom() + ";" + p.getDni() + ";" + p.getDataNaixement() + ";" + p.getTlf() + ";" + p.getCodi() + ";" + p.getHistorial();
	}

	//ORDENAR LEER Y GUARDAR
	
	@Override
	public Set<Pacient> llegirPacients(String nomFitxer) throws IOException {
		File fitxer = new File(nomFitxer);
		try(BufferedReader bReader = new BufferedReader(new FileReader(fitxer))){
			String linea;
			while ((linea = bReader.readLine()) != null) {
				linea = linea.trim();
				if (linea.startsWith("#") || linea.isEmpty()) continue;
				Pacient p = toPacient(linea);
				if (p != null)
					listaPacients.add(p);
			}
		}catch (FileNotFoundException e) {
			System.out.println("Fitxer no existeix");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
		
	}
	
	@Override
	public boolean desaPacients(String nomFitxer,Set<Pacient> listaPacients) throws InvalidCodiPacientException {
		boolean append = false;
		try(PrintWriter pWriter = new PrintWriter(new FileWriter(nomFitxer,append))){
			for(Pacient p:)
			pWriter.println(toCSV(p));
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	



}
