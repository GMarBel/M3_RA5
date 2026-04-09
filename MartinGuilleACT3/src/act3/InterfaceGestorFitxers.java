package act3;

import java.io.IOException;
import java.util.Set;

public interface InterfaceGestorFitxers {
	public boolean desaPacients(String nomFitxer,Set<Pacient> listaPacients) throws InvalidCodiPacientException;
	public Set<Pacient> llegirPacients(String nomFitxer) throws IOException;
}
