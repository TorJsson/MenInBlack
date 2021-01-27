package MiB;

import java.util.ArrayList;
import oru.inf.InfDB;
import oru.inf.InfException;

import javax.swing.JOptionPane;

public class Omrade {
    private static InfDB databas = Start.getDatabas();
    
    //Metod f�r att h�mta ett omr�des ben�mning utifr�n omr�desId
    public static String getBenamningById(int id) {
        String resultat = "";
        
        try {
            //F�rbered SQLfr�ga
            String query = "SELECT benamning FROM omrade WHERE omrades_id = '" + id + "'";
            resultat = databas.fetchSingle(query);
        //Om någonting g�r fel under v�gen, visa felmeddelande f�r anv�daren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att h�mta ett omr�des Id utifr�n dess ben�mning
    public static String getIdByBenamning(String benamning) {
        String resultat = "";
        
        try {
            //F�rbered SQLfr�ga
            String query = "SELECT omrades_id FROM omrade WHERE benamning = '" + benamning + "'";
            resultat = databas.fetchSingle(query);
        //Om n�gonting g�r fel under v�gen, visa felmeddelande f�r anv�ndaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att h�mta omr�deschefens agentId utifr�n omr�desId
    public static int getOmradesChefById(int id) {
        int resultat = 0;
        
        try {
            //F�rbered SQLfr�ga
            String query = "SELECT agent_id FROM omradeschef WHERE omrade = '" + id + "'";
            resultat = Integer.parseInt(databas.fetchSingle(query));
        //Om n�gonting g�r fel under v�gen, visa felmeddelande f�r anv�ndaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        
        return resultat;
    }
    
    //Metod f�r att h�mta antalet aliens som �r registrerade i ett omr�de utifr�n omr�desId
    public static int getAntalAliens(int id) {
        int resultat = 0;
        try {
            //F�rbered SQLfr�ga
            String query = "SELECT COUNT(*) FROM ALIEN JOIN PLATS ON ALIEN.PLATS = PLATS.PLATS_ID JOIN OMRADE ON PLATS.FINNS_I = OMRADE.OMRADES_ID WHERE OMRADE.OMRADES_ID =" + id;
            resultat = Integer.parseInt(databas.fetchSingle(query));
        //Om n�gonting g�r fel under v�gen, visa felmeddelande f�r anv�ndaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
        
    }
    
    //Metod f�r att h�mta en lista �ver alla omr�desben�mningar
    public static ArrayList<String> getAllaOmradesBenamningar() {
    ArrayList<String> resultat = new ArrayList<>();
        try {
            String query = "SELECT benamning FROM omrade";
            resultat = databas.fetchColumn(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r omr�desben�mningar skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
}