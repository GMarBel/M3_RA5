package act3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.io.IOException;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== INICIANT TEST DE CONTROL D'EXCEPCIONS ===\n");

        Hospital hospital = new Hospital("Hospital Central", "Carrer Major 1");
        
        // 1. TEST: CREACIÓ DE PACIENT AMB CODI INVÀLID
        System.out.println("TEST 1: Codi de pacient incorrecte");
        try {
            // El codi ha de ser MED + 5 dígits + 3 dígits
            new Pacient("Joan", "12345678Z", "01/01/2000", "600000000", "CODI-ERROR");
        } catch (InvalidCodiPacientException e) {
            System.out.println("OK: Excepció capturada correctament -> " + e.getMessage());
        }
        System.out.println("---");

        // 2. TEST: CITA EN DATA PASSADA
        System.out.println("TEST 2: Cita en data anterior a l'actual");
        try {
            Pacient p = new Pacient("Marta", "11111111H", "10/10/1990", "611222333", "MED12345001");
            Especialitat e = new Especialitat("General", "Desc", 0, 99);
            Doctor d = new Doctor("Dr. Casa", "22222222J", "01/01/1970", "677888999", e);
            
            // Forcem data passada
            new Cita(p, d, LocalDate.of(2020, 1, 1), LocalTime.of(10, 00));
        } catch (InvalidCodiPacientException e) {
            System.out.println("Error inesperat de codi: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("OK: Excepció capturada correctament -> " + e.getMessage());
        }
        System.out.println("---");

        // 3. TEST: INCOMPATIBILITAT D'EDAT (Pacient vs Especialitat)
        System.out.println("TEST 3: Edat del pacient fora del rang de l'especialitat");
        try {
            Pacient adult = new Pacient("Pere", "33333333K", "15/05/1980", "655444333", "MED55555002");
            Especialitat pediatria = new Especialitat("Pediatria", "Nens", 0, 14);
            Doctor drPediatra = new Doctor("Dra. Sandra", "44444444L", "12/12/1985", "644555666", pediatria);
            
            // Intentem assignar un adult de 40+ anys a pediatria
            new Cita(adult, drPediatra, LocalDate.of(2026, 05, 20), LocalTime.of(11, 00));
        } catch (InvalidCodiPacientException e) {
            System.out.println("Error de codi");
        } catch (IllegalArgumentException e) {
            System.out.println("OK: Excepció capturada correctament -> " + e.getMessage());
        }
        System.out.println("---");

        // 4. TEST: GESTIÓ DE FITXERS (IOExceptions)
        System.out.println("TEST 4: Lectura de fitxer inexistent");
        GestorCSV gestor = new GestorCSV();
        try {
            // Intentem llegir un fitxer que no hem creat encara
            gestor.llegirPacients("fitxer_fantasma.csv");
        } catch (IOException e) {
            System.out.println("OK: Error d'entrada/sortida capturat -> " + e.getMessage());
        } catch (InvalidCodiPacientException e) {
            System.out.println("Error de codi en lectura");
        }
        System.out.println("---");

        // 5. TEST: FUNCIONAMENT CORRECTE 
        System.out.println("TEST 5: Flux complet sense errors");
        try {
            Especialitat e = new Especialitat("Cardiologia", "Cor", 18, 120);
            hospital.registrarEspecialitat(e);
            
            Doctor d = new Doctor("Dr. Cor", "99999999X", "01/01/1975", "934445566", e);
            hospital.registrarDoctor(d);
            
            Pacient p = new Pacient("Anna", "88888888P", "20/02/1995", "600111222", "MED12345678");
            hospital.registrarPacient(p);
            
            Cita c = new Cita(p, d, LocalDate.of(2026, 12, 01), LocalTime.of(9, 30));
            hospital.registrarCita(c);
            
            System.out.println("Cita creada amb èxit: " + c);
            
            // Confirmar cita
            boolean confirmada = hospital.confirmarCita("99999999X", LocalDate.of(2026, 12, 01), LocalTime.of(9, 30));
            System.out.println("Cita confirmada? " + confirmada + " [Estat: " + c.getEstat() + "]");
            
            // Guardar a XML
            GestorXML gXml = new GestorXML();
            gXml.desaPacients("hospital.xml", hospital.getListaPacients());
            System.out.println("Dades guardades correctament en XML.");

        } catch (Exception e) {
            System.out.println("ERROR INESPERAT: " + e.getMessage());
        }

        System.out.println("\n=== FI DE LES PROVES ===");
    }
}