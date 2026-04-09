package act3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class GestorCSV implements InterfaceGestorFitxers{

	@Override
	public boolean desaPacients(String nomFitxer,Set<Pacient> listaPacients) {
		File fitxer = new File(nomFitxer);
		try(BufferedReader bReader = new BufferedReader(new FileReader(fitxer))){
			
		}catch (FileNotFoundException e) {
			System.out.println("Fitxer no existeix");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public void llegirPacients(String nomFitxer) {
		// TODO Auto-generated method stub
		
	}


}
