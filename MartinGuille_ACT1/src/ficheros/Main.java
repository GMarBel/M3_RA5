package ficheros;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, MatriculaInvalidaException {
		//ABRIR SCANNER y GESTOR ARCHIVOS
        Scanner sc  = new Scanner(System.in);
        GestorArchivos GA = new GestorArchivos();
      
		//EJERCICIO 0
		System.out.println("<---------------EJERCICIO 0--------------->");
		 File file = new File("archivo");

	        if (file.exists()) {
	            System.out.println("AVISO:	El archivo ya existe");
	        } else {
	            System.out.println("Creando archivo...");
	            file.createNewFile();
	        }

	        System.out.println("path: " + file.getPath()); 
	        System.out.println("path absolut: " + file.getAbsolutePath()); 
	        System.out.println("ultima modificació : " + new Date(file.lastModified()));
	        System.out.println("longitud : " + file.length());

	        file.setExecutable(true);
	        System.out.println("Tiene permisos de:");
	        if (file.canExecute()) {
	            System.out.println("-	Ejecución");
	        }
	        if (file.canRead()) {
	            System.out.println("-	Lectura");
	        }
	        if (file.canWrite()) {
	            System.out.println("-	Escritura");
	        }
	        if (file.isFile()) {
	            System.out.println("Es un fichero");
	        }
	        if (file.isHidden()) {
	            System.out.println("Esta oculto");
	        }

	        File dir = new File("directorio");
	        if (dir.exists()) {
	            System.out.println("AVISO:	El directorio ya existe");
	        } else {
	            System.out.println("Creando directorio...");
	            dir.mkdir();
	        }
	        if (dir.isDirectory()) {
	            System.out.println("Es un directorio");
	        }

	        String[] fitxers = dir.list();
	        for (int i = 0; i < fitxers.length; i++) {
	            System.out.println("fitxer " + fitxers[i]);
	        }
	        
	        
	        //EJERCICIO 1
	        System.out.println("<---------------EJERCICIO 1--------------->");
	        try {
	        	System.out.println("¿Que archivo quieres ver?");
	        	String archivo = sc.nextLine();
	        	System.out.println(GA.leerArchivo(archivo));
	        }catch (Exception e) {
	        	System.out.println(e);
	        }
	        
	        //EJERCICIO 2
	        System.out.println("<---------------EJERCICIO 2--------------->");
	        try {
	        	System.out.println("¿Que archivo quieres ver?");
	        	String archivo = sc.nextLine();
	        	System.out.println(GA.writeArchivo(archivo) ? "Archivo escrito correctamente" : "El archivo no ha sido modificado");
	        }catch(Exception e) {
	        	System.out.println(e);
	        }
	        
	        //EJERCICIO 3 y 4
	        System.out.println("<---------------EJERCICIO 3&4--------------->");
	        try {
	        	System.out.print("Introduce el nombre del archivo para leer: ");
	        	String archivo = sc.nextLine();
	        	Set<Vehiculo> vehiculos = GA.leerCSV(archivo);
	        	
	        	System.out.println("Introduce el nombre del archivo CSV para escrivir: ");
	        	archivo = sc.nextLine();
	        	System.out.println(GA.guardarCSV(archivo, vehiculos) ? "El archivo se ha guardado correctamente":"Error al guardar el archivo" );
	        	
	        }catch(Exception e) {
	        	System.out.println(e);
	        }
	        
	        //EJERCICIO 5
	        System.out.println("<---------------EJERCICIO 5--------------->");
	        boolean salir = false;
	        
	        while(!salir) {
	        	
	        	
	        }
	        
	        sc.close();
	}

}
