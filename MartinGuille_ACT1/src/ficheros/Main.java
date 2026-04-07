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
	        	InterfaceGestorArchivos gestor;
	        	gestor =  new GestorArchivosCSV();
	        	System.out.print("Introduce el nombre del archivo para leer: ");
	        	String archivo = sc.nextLine();
	        	Set<Vehiculo> vehiculos = gestor.leer(archivo);
	        	
	        	System.out.println("Introduce el nombre del archivo CSV para escrivir: ");
	        	archivo = sc.nextLine();
	        	System.out.println(gestor.guardar(archivo, vehiculos) ? "El archivo se ha guardado correctamente":"Error al guardar el archivo" );
	        	
	        }catch(Exception e) {
	        	System.out.println(e);
	        }
	        //EJERCICIO 5
	        System.out.println("<---------------EJERCICIO 5--------------->");
	        boolean salir = false;
	        Set<Vehiculo> vehiculos = new TreeSet<>();
	        InterfaceGestorArchivos gestor;
	        
	        while(!salir) {
	        	System.out.println("0:	Salir");
	        	System.out.println("1:	Cargar vehiculos desde CSV");
	        	System.out.println("2:	Cargar vehiculos desde XML");
	        	System.out.println("3:	Cargar vehiculos desde Bin");
	        	System.out.println("4:	Ver lista vehiculos");
	        	System.out.println("5:	Añadir un vehiculo");
	        	System.out.println("6:	Eliminar un vehiculo");
	        	System.out.println("7:	Ver coche con mas KM");
	        	System.out.println("8:	Guardar vehiculos en CSV");
	        	System.out.println("9:	Guardar vehiculos en XML");
	        	System.out.println("10:	Guardar vehiculos en Bin");
	        	
	        	int caso = sc.nextInt();
	        	switch(caso) {
	        	case 0:
	        		salir = true;
	        		break;
	        	case 1:
	        		try{
	        			System.out.println("Indica el nombre del archivo CSV:");
		        		sc.nextLine();
		        		String csv = sc.nextLine();
		        		gestor = new GestorArchivosCSV();
	        			vehiculos = gestor.leer(csv);
	        			System.out.println(!vehiculos.isEmpty() ? "Vehiculos cargados correctamente" : "Los vehiculos no se han cargado correctamente");
	        		}catch (Exception e){
	        			System.out.println("Error:	" + e.getMessage());
	        		}
	        		break;
	        	case 2:
	        		try {
		        		System.out.println("Nombre del archivo XML:");
		        	    sc.nextLine();
		        	    String xml = sc.nextLine();
		        	    gestor = new GestorArchivosXML();
	        	    
	        	        vehiculos = gestor.leer(xml);
	        	        System.out.println(!vehiculos.isEmpty() ? "Vehiculos cargados correctamente" : "Los vehiculos no se han cargado correctamente");
	        	    } catch (Exception e) {
	        	        System.out.println("Error: " + e.getMessage());
	        	    }
	        	    break;
	        	case 3:
	        		try {
	        			System.out.println("Nombre del archivo Bin:");
	        			sc.nextLine();
	        			String bin = sc.nextLine();
	        			gestor = new GestorArchivosBin();
	        			
	        			vehiculos = gestor.leer(bin);
	        			System.out.println(!vehiculos.isEmpty()  ? "Vehiculos cargados correctamente" : "Los vehiculos no se han cargado correctamente");
	        		} catch (Exception e) {
	        	        System.out.println("Error: " + e.getMessage());
	        	    }
	        		
	        		break;
	        	
	        	case 4:
	        		GA.mostrarVehiculos(vehiculos);
	        		break;
	        	
	        	case 5:
	        		int resTipo = 0;
	        		while(resTipo != 1 && resTipo != 2) {
		        		System.out.println("¿Que tipo de vehiculo quieres añadir?");
		        		
		        		System.out.println("1.	Coche");
		        		System.out.println("2.	Moto");
		        		resTipo = sc.nextInt();
		        		sc.nextLine();
		        		if(resTipo!=1 && resTipo!=2)System.out.println("Elige entre una de las dos opciones");
	        		}
	        		
	        		String mat = "matriculaInvalida";
	        		while(!Vehiculo.validacionMatricula(mat)) {
		        		System.out.println("Indica la matricula del vehiculo:");
		        		mat = sc.nextLine();
		        		if(!Vehiculo.validacionMatricula(mat))System.out.println("Matricula invalida");
	        		}
	        		
	        		int km = -1;
	        		while(km<0) {
	        			System.out.println("Indica los km:");
	        			km = sc.nextInt();
	        			sc.nextLine();
	        			if(km<0)System.out.println("Los km no pueden ser menores a 0");;
	        		}
	        		
	        		System.out.println("Indica la marca:");
	        		String marca = sc.nextLine();
	        		
	        		System.out.println("Indica el modelo:");
	        		String modelo  = sc.nextLine();
	        		
	        		System.out.println("Indica el color:");
	        		String color = sc.nextLine();
	        		
	        		
	        		
	        		try {
	        		switch(resTipo) {
	        		case 1:
	        			System.out.println("Indica el numero de puertas:");
	        			int numPuertas = sc.nextInt();
	        			sc.nextLine();
	        			
	        			System.out.println("¿Es manual o automatico?");
	        			System.out.println("1.Manual");
	        			System.out.println("2.Automatico");
	        			
	        			int resAuto = sc.nextInt();
	        			sc.nextLine();
	        			boolean esAuto = (resAuto > 1);
	        			
	        			Coche c = new Coche(mat,km,marca,modelo,color,numPuertas,esAuto);
	        			vehiculos.add(c);
	        			break;
	        		
	        		case 2:
	        			System.out.println("Indica las cilindradas:");
	        			int cc = sc.nextInt();
	        			sc.nextLine();
	        			
	        			System.out.println("Indica el tipo:");
	        			String tipo  = sc.nextLine();
	        			Moto m = new Moto(mat,km,marca,modelo,color,cc,tipo);
	        			vehiculos.add(m);
	        			break;
	        		}
	        		}catch(Exception e) {
	        			System.out.println(e);
	        		}
	        		break;
	        		
	        	case 6:
	        		sc.nextLine();
	        		System.out.println("Indica la matricula del vehiculo que quieres borrar:");
	        		String matricula = sc.nextLine();
	        		System.out.println(GA.borrarVehiculo(matricula, vehiculos) ? "Vehiculo borrado correctamente" : "Error al borrar el vehiculo");
	        		break;
	        	
	        	case 7:
	        		System.out.println("El coche con mas Km es:"+ GA.cocheMayorKm(vehiculos).getMatricula() + " con " +GA.cocheMayorKm(vehiculos).getKm() + " Kms" ); 
	        		break;
	        	
	        	case 8:
	        		try {
	        			sc.nextLine();
		        		System.out.println("Indica el nombre del archivo CSV");
		        		String archivo  = sc.nextLine();
		        		gestor = new GestorArchivosCSV();
		        		System.out.println(gestor.guardar(archivo, vehiculos) ? "Archivo guardado" : "Error al guardar el archivo");
		
	        		}catch(Exception e) {
	        			System.out.println(e);
	        		}
	        		break;
	        		
	        	case 9:
	        		try {
	        			sc.nextLine();
		        		System.out.println("Indica el nombre del archivo XML");
		        		String archivo  = sc.nextLine();
		        		
		        		gestor = new GestorArchivosXML();
		        		System.out.println(gestor.guardar(archivo, vehiculos) ? "Archivo guardado" : "Error al guardar el archivo");
		
	        		}catch(Exception e) {
	        			System.out.println(e);
	        		}
	        		break;
	        	case 10:
	        		try {
	        			sc.nextLine();
		        		System.out.println("Indica el nombre del archivo Bin");
		        		String archivo  = sc.nextLine();
		        		
		        		gestor = new GestorArchivosBin();
		        		System.out.println(gestor.guardar(archivo, vehiculos) ? "Archivo guardado" : "Error al guardar el archivo");
		
	        		}catch(Exception e) {
	        			System.out.println(e);
	        		}
	        		
	        		break;
	        	}
	        }
	        
	        sc.close();
	}

}
