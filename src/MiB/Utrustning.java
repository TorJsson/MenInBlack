package MiB;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Utrustning {
    
    private static InfDB databas = Start.getDatabas();
    
    //Metod f�r att h�mta ben�mningen p� en vald utrustning utifr�n utrustningsId
    public static String getBenamningById(int utrustningsId) {
        String resultat = "";
        try {
            String query = "SELECT benamning FROM utrustning WHERE utrustnings_id = " + utrustningsId;
            resultat = databas.fetchSingle(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r ben�mning skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;  
    }
    
    //Metod f�r att h�mta idnummer �ver all utrustning som �r utkvitterad av en agent utifr�n agentens id
    public static ArrayList<String> getAllUtrustningByAgentId(int agentId) {
        ArrayList<String> resultat = new ArrayList<>();
        try {
            String query = "SELECT utrustings_id FROM innehar_utrustning WHERE agent_id = " + agentId + ")";
            resultat = databas.fetchColumn(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r utrustning skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;  
    }
        
    //Metod f�r att h�mta utkvitteringsdatum f�r en vald utrustning utifr�n en vald agents id
    public static String getUtkvitteringsdatumById(int utrustningsId, int agentId) {
        String resultat = "";
        try {
            String query = "SELECT utkvitteringsdatum FROM innehar_utrustning WHERE utrustnings_id = '" + utrustningsId + "' AND agent_id = '" + agentId + "'";
            resultat = databas.fetchSingle(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r utkvitteringsdatum skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //metod f�r att kvittera ut utrustning mha en agents id
    public static boolean kvitteraUt(int agentId, int utrustningsId, String datum) {
        boolean success = false;
        
        try {
            databas.insert("INSERT INTO innehar_utrustning (agent_id, utrustnings_id, utkvitteringsdatum) VALUES (" + agentId + ", " + utrustningsId + ", '" + datum + "')");
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r utrustning skulle kvitteras ut. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    
    }
    
    //Metod f�r att kontrollera om en vald utrustning �r utkvitterad
    public static boolean arUtkvitterad(int utrustningsId) {
        boolean utkvitterat = false;
        
        try {
            String resultat = databas.fetchSingle("SELECT utrustnings_id FROM innehar_utrustning WHERE utrustnings_id = " + utrustningsId);
            
            if(resultat != null && !resultat.isEmpty()) {
                utkvitterat = true;
            }
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r utkvitteringsstatus skulle kontrolleras. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return utkvitterat;
    }
    
    //Metod f�r att l�mna tillbaka/ta bort utkvittering av en vald utrustning utifr�n utrustningsId
    public static boolean lamnaTillbaka(String utrustningsId) {
        boolean tillbakalamnad = false;
        
        try{ 
            databas.delete("DELETE FROM innehar_utrustning WHERE utrustnings_id = '" + utrustningsId + "'");
            tillbakalamnad = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r utrustningen skulle �terl�mnas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return tillbakalamnad;
    }
    
    //Metod f�r att ta bort en utrustning utifr�n utrustningsId och vilken kategori utrustningen tillh�r
    public static boolean taBort(int utrustningsId, String kategori) {
        boolean borttagen = false;
        
        try{
            databas.delete("DELETE FROM utrustning WHERE utrustnings_id = '" + utrustningsId + "'");
            databas.delete("DELETE FROM " + kategori + " WHERE utrustnings_id = '" + utrustningsId + "'");
            borttagen = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r utrustningen skulle tas bort. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return borttagen;
    }
    
    //Metod f�r att h�mta vilken agent (agentId) som har kvitterat ut en vald utrustning utifr�n utrustningsId
    public static int getUtkvitteratAv(int utrustningsId) {
        int resultat = 0;
        
        try{
            resultat = Integer.parseInt(databas.fetchSingle("SELECT agent_id FROM innehar_utrustning WHERE utrustnings_id = " + utrustningsId));
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r agentId f�r utkvitterad utrustning skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
}
