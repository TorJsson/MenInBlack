package MiB;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Vapen {
    private static InfDB databas = Start.getDatabas();
    
    //Metod f�r att h�mta utrustningsId fr�n all utrustning som �r utkvitterad av en vald agent (agentId)    
    public static ArrayList<String> getAllUtrustningByAgentId(int agentId) {
        ArrayList<String> resultat = new ArrayList<>();
        try {
            String query = "SELECT utrustnings_id FROM vapen WHERE utrustnings_id IN (SELECT utrustnings_id FROM innehar_utrustning WHERE agent_id = " + agentId + ")";
            resultat = databas.fetchColumn(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r vapenutrustning skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;  
    }
        
    //Metod f�r att h�mta kaliber p� ett vapen utifr�n utrustningsId (/vapenId)
    public static String getKaliberById(String vapenId) {
        String resultat = "";
        
        try {
            //F�rbered SQLfr�ga
            String query = "SELECT kaliber FROM vapen WHERE utrustnings_id = " + vapenId;
            resultat = databas.fetchSingle(query);
        //Om någonting g�r fel under v�gen, visa felmeddelande f�r anv�daren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r kaliber skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att h�mta data �ver utrustning som �r utkvitterad av en vald agent utifr�n agentId
    public static ArrayList<HashMap<String, String>> getListaData(int agentId){
        ArrayList<HashMap<String, String>> resultat = new ArrayList<>();

        try{
            String query = "SELECT UTRUSTNING.BENAMNING, VAPEN.KALIBER, INNEHAR_UTRUSTNING.UTKVITTERINGSDATUM, UTRUSTNING.UTRUSTNINGS_ID FROM UTRUSTNING JOIN INNEHAR_UTRUSTNING ON INNEHAR_UTRUSTNING.UTRUSTNINGS_ID = UTRUSTNING.UTRUSTNINGS_ID JOIN VAPEN ON UTRUSTNING.UTRUSTNINGS_ID = VAPEN.UTRUSTNINGS_ID WHERE INNEHAR_UTRUSTNING.AGENT_ID =" + agentId;
            resultat = databas.fetchRows(query);
        } catch(InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r listdata skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }

    //Metod f�r att h�mta data �ver all utrustning
    public static ArrayList<HashMap<String, String>> getAllListaData(){
        ArrayList<HashMap<String, String>> resultat = new ArrayList<>();

        try{
            String query = "SELECT UTRUSTNING.BENAMNING, VAPEN.KALIBER, UTRUSTNING.UTRUSTNINGS_ID FROM UTRUSTNING JOIN VAPEN ON UTRUSTNING.UTRUSTNINGS_ID = VAPEN.UTRUSTNINGS_ID";
            resultat = databas.fetchRows(query);
        } catch(InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r listdata skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }    
    
    //Metod f�r att l�gga till utrustning av kategorin vapen.
    public static boolean laggTill(String benamning, int kaliber) {
        boolean success = false;

        try {
            
            String id = databas.getAutoIncrement("utrustning", "utrustnings_id");
            int nyttId = Integer.parseInt(id);

            String query1 = "INSERT INTO vapen (utrustnings_id, kaliber) VALUES (" + nyttId + ", " + kaliber + ")";
            databas.insert(query1);

            String query2 = "INSERT INTO utrustning (utrustnings_id, benamning) VALUES (" + nyttId + ", '" + benamning + "')";
            databas.insert(query2);

            success = true;
            
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r vapen skulle l�ggas till. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
}
