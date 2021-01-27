package MiB;

import java.util.ArrayList;
import oru.inf.InfDB;
import oru.inf.InfException;

import javax.swing.JOptionPane;

public class Plats {
    private static InfDB databas = Start.getDatabas();
    
    //Metod för att hämta platsbenämning utifrån platsId
    public static String getBenamningById(int id) {
        String resultat = "";
        
        try {
            //Förbered SQLfråga
            String query = "SELECT benamning FROM plats WHERE plats_id = '" + id + "'";
            resultat = databas.fetchSingle(query);
        //Om någonting går fel under vägen, visa felmeddelande för användaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod för att hämta områdesId tillhörande en vald plats utifrån platsId
    public static int getFinnsIById(int id) {
        int resultat = 0;
        
        try {
            //Förbered SQLfråga
            String query = "SELECT finns_i FROM plats WHERE plats_id = '" + id + "'";
            resultat = Integer.parseInt(databas.fetchSingle(query));
        //Om någonting går fel under vägen, visa felmeddelande för användaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod för att hämta id för en plats utifrån platsbenämning
    public static String getIdByBenamning(String benamning) {
        String resultat = "";
        
        try {
            //Förbered SQLfråga
            String query = "SELECT plats_id FROM plats WHERE benamning = '" + benamning + "'";
            resultat = databas.fetchSingle(query);
        //Om någonting går fel under vägen, visa felmeddelande för användaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod för att hämta alla platsbenämningar
    public static ArrayList<String> getAllaPlatsNamn() {
        ArrayList<String> resultat = new ArrayList<>();
        try {
            String query = "SELECT benamning FROM plats";
            resultat = databas.fetchColumn(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när platsnamn skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;  
    }    
}