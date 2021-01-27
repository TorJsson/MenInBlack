package MiB;

import java.util.ArrayList;
import oru.inf.InfDB;
import oru.inf.InfException;

import javax.swing.JOptionPane;

public class Omrade {
    private static InfDB databas = Start.getDatabas();
    
    //Metod för att hämta ett områdes benämning utifrån områdesId
    public static String getBenamningById(int id) {
        String resultat = "";
        
        try {
            //Förbered SQLfråga
            String query = "SELECT benamning FROM omrade WHERE omrades_id = '" + id + "'";
            resultat = databas.fetchSingle(query);
        //Om nÃ¥gonting går fel under vägen, visa felmeddelande för anvädaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod för att hämta ett områdes Id utifrån dess benämning
    public static String getIdByBenamning(String benamning) {
        String resultat = "";
        
        try {
            //Förbered SQLfråga
            String query = "SELECT omrades_id FROM omrade WHERE benamning = '" + benamning + "'";
            resultat = databas.fetchSingle(query);
        //Om någonting går fel under vägen, visa felmeddelande för användaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod för att hämta områdeschefens agentId utifrån områdesId
    public static int getOmradesChefById(int id) {
        int resultat = 0;
        
        try {
            //Förbered SQLfråga
            String query = "SELECT agent_id FROM omradeschef WHERE omrade = '" + id + "'";
            resultat = Integer.parseInt(databas.fetchSingle(query));
        //Om någonting går fel under vägen, visa felmeddelande för användaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        
        return resultat;
    }
    
    //Metod för att hämta antalet aliens som är registrerade i ett område utifrån områdesId
    public static int getAntalAliens(int id) {
        int resultat = 0;
        try {
            //Förbered SQLfråga
            String query = "SELECT COUNT(*) FROM ALIEN JOIN PLATS ON ALIEN.PLATS = PLATS.PLATS_ID JOIN OMRADE ON PLATS.FINNS_I = OMRADE.OMRADES_ID WHERE OMRADE.OMRADES_ID =" + id;
            resultat = Integer.parseInt(databas.fetchSingle(query));
        //Om någonting går fel under vägen, visa felmeddelande för användaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
        
    }
    
    //Metod för att hämta en lista över alla områdesbenämningar
    public static ArrayList<String> getAllaOmradesBenamningar() {
    ArrayList<String> resultat = new ArrayList<>();
        try {
            String query = "SELECT benamning FROM omrade";
            resultat = databas.fetchColumn(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när områdesbenämningar skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
}