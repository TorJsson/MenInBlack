package MiB;

import java.util.ArrayList;
import oru.inf.InfDB;
import oru.inf.InfException;

import javax.swing.JOptionPane;

public class Plats {
    private static InfDB databas = Start.getDatabas();
    
    //Metod f�r att h�mta platsben�mning utifr�n platsId
    public static String getBenamningById(int id) {
        String resultat = "";
        
        try {
            //F�rbered SQLfr�ga
            String query = "SELECT benamning FROM plats WHERE plats_id = '" + id + "'";
            resultat = databas.fetchSingle(query);
        //Om n�gonting g�r fel under v�gen, visa felmeddelande f�r anv�ndaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att h�mta omr�desId tillh�rande en vald plats utifr�n platsId
    public static int getFinnsIById(int id) {
        int resultat = 0;
        
        try {
            //F�rbered SQLfr�ga
            String query = "SELECT finns_i FROM plats WHERE plats_id = '" + id + "'";
            resultat = Integer.parseInt(databas.fetchSingle(query));
        //Om n�gonting g�r fel under v�gen, visa felmeddelande f�r anv�ndaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att h�mta id f�r en plats utifr�n platsben�mning
    public static String getIdByBenamning(String benamning) {
        String resultat = "";
        
        try {
            //F�rbered SQLfr�ga
            String query = "SELECT plats_id FROM plats WHERE benamning = '" + benamning + "'";
            resultat = databas.fetchSingle(query);
        //Om n�gonting g�r fel under v�gen, visa felmeddelande f�r anv�ndaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att h�mta alla platsben�mningar
    public static ArrayList<String> getAllaPlatsNamn() {
        ArrayList<String> resultat = new ArrayList<>();
        try {
            String query = "SELECT benamning FROM plats";
            resultat = databas.fetchColumn(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r platsnamn skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;  
    }    
}