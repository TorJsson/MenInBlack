package MiB;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Kommunikation {
    private static InfDB databas = Start.getDatabas();
    
    //Metod f�r att h�mta all kommunikationsutrustning som �r utkvitterad av en vald agent utifr�n agentens id
    public static ArrayList<String> getAllUtrustningByAgentId(int agentId) {
        ArrayList<String> resultat = new ArrayList<>();
        try {
            String query = "SELECT utrustnings_id FROM kommunikation WHERE utrustnings_id IN (SELECT utrustnings_id FROM innehar_utrustning WHERE agent_id = " + agentId + ")";
            resultat = databas.fetchColumn(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r kommunikationsutrustning skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;  
    }    
    
    //Metod f�r att h�mta �verf�ringsteknik f�r en vald kommunikationsutrustning utifr�n utrustningens id
    public static String getOverforingsteknikById(int utrustningsId) {
        String resultat = "";
        
        try {
            //F�rbered SQLfr�ga
            String query = "SELECT overforingsteknik FROM kommunikation WHERE utrustnings_id = " + utrustningsId;
            resultat = databas.fetchSingle(query);
        //Om någonting g�r fel under v�gen, visa felmeddelande f�r anv�daren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r �verf�ringsteknik skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att h�mta data om utrustning som �r utkvitterad av en vald agent utifr�n agentens id
    public static ArrayList<HashMap<String, String>> getListaData(int agentId){
        ArrayList<HashMap<String, String>> resultat = new ArrayList<>();

        try{
            String query = "SELECT UTRUSTNING.BENAMNING, KOMMUNIKATION.OVERFORINGSTEKNIK, INNEHAR_UTRUSTNING.UTKVITTERINGSDATUM, UTRUSTNING.UTRUSTNINGS_ID FROM UTRUSTNING JOIN INNEHAR_UTRUSTNING ON INNEHAR_UTRUSTNING.UTRUSTNINGS_ID = UTRUSTNING.UTRUSTNINGS_ID JOIN KOMMUNIKATION ON UTRUSTNING.UTRUSTNINGS_ID = KOMMUNIKATION.UTRUSTNINGS_ID WHERE INNEHAR_UTRUSTNING.AGENT_ID =" + agentId;
            resultat = databas.fetchRows(query);
        } catch(InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r listdata skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att h�mta data om all utrustning
    public static ArrayList<HashMap<String, String>> getAllListaData(){
        ArrayList<HashMap<String, String>> resultat = new ArrayList<>();

        try{
            String query = "SELECT UTRUSTNING.BENAMNING, KOMMUNIKATION.OVERFORINGSTEKNIK, UTRUSTNING.UTRUSTNINGS_ID FROM UTRUSTNING JOIN KOMMUNIKATION ON UTRUSTNING.UTRUSTNINGS_ID = KOMMUNIKATION.UTRUSTNINGS_ID";
            resultat = databas.fetchRows(query);
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r listdata skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att l�gga till kommunikationsutrustning
    public static boolean laggTill(String benamning, String overforingsteknik) {
        boolean success = false;

        try {
            String id = databas.getAutoIncrement("utrustning", "utrustnings_id");
            int nyttId = Integer.parseInt(id);

            String query1 = "INSERT INTO kommunikation (utrustnings_id, overforingsteknik) VALUES (" + nyttId + ", '" + overforingsteknik + "')";
            databas.insert(query1);

            String query2 = "INSERT INTO utrustning (utrustnings_id, benamning) VALUES (" + nyttId + ", '" + benamning + "')";
            databas.insert(query2);

            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r kommunikationsutrustning skulle l�ggas till. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
}
