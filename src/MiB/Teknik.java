package MiB;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Teknik {
    private static InfDB databas = Start.getDatabas();
    
    //Metod f�r att h�mta all utkvitterad utrustning per agent. Inparameter int agentId representerar agenten vars utkvitterad utrustning man vill h�mta
    public static ArrayList<String> getAllUtrustningByAgentId(int agentId) {
        ArrayList<String> resultat = new ArrayList<>();
        try {
            String query = "SELECT utrustnings_id FROM teknik WHERE utrustnings_id IN (SELECT utrustnings_id FROM innehar_utrustning WHERE agent_id = " + agentId + ")";
            resultat = databas.fetchColumn(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r teknikutrustning skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;  
    }    
    
    //H�mtar data fr�n f�ltet kraftk�lla tillh�rande ett visst utrustningsId.
    public static String getKraftkallaById(int utrustningsId) {
        String resultat = "";
        
        try {
            //F�rbered SQLfr�ga
            String query = "SELECT kraftkalla FROM teknik WHERE utrustnings_id = " + utrustningsId;
            resultat = databas.fetchSingle(query);
        //Om n�gonting g�r fel under v�gen, visa felmeddelande f�r anv�ndaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r kraftk�lla skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //H�mtar den data som kr�vs i utrustningslista f�r teknikutrustning per agent. Inparameter int agentId representerar den agent man vill h�mta data f�r.
    public static ArrayList<HashMap<String, String>> getListaData(int agentId){
        ArrayList<HashMap<String, String>> resultat = new ArrayList<>();

        try{
            String query = "SELECT UTRUSTNING.BENAMNING, TEKNIK.KRAFTKALLA, INNEHAR_UTRUSTNING.UTKVITTERINGSDATUM, UTRUSTNING.UTRUSTNINGS_ID FROM UTRUSTNING JOIN INNEHAR_UTRUSTNING ON INNEHAR_UTRUSTNING.UTRUSTNINGS_ID = UTRUSTNING.UTRUSTNINGS_ID JOIN TEKNIK ON UTRUSTNING.UTRUSTNINGS_ID = TEKNIK.UTRUSTNINGS_ID WHERE INNEHAR_UTRUSTNING.AGENT_ID =" + agentId;
            resultat = databas.fetchRows(query);
        } catch(InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r listdata skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att h�mta (n�stan) all data som finns f�r teknikutrustning
    public static ArrayList<HashMap<String, String>> getAllListaData(){
        ArrayList<HashMap<String, String>> resultat = new ArrayList<>();

        try{
            String query = "SELECT UTRUSTNING.BENAMNING, TEKNIK.KRAFTKALLA, UTRUSTNING.UTRUSTNINGS_ID FROM UTRUSTNING JOIN TEKNIK ON UTRUSTNING.UTRUSTNINGS_ID = TEKNIK.UTRUSTNINGS_ID";
            resultat = databas.fetchRows(query);
        } catch(InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r listdata skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }    
    
    //Metod f�r att l�gga till teknikutrustning
    public static boolean laggTill(String benamning, String kraftkalla) {
        boolean success = false;

        try {
            
            String id = databas.getAutoIncrement("utrustning", "utrustnings_id");
            int nyttId = Integer.parseInt(id);

            String query1 = "INSERT INTO teknik (utrustnings_id, kraftkalla) VALUES (" + nyttId + ", '" + kraftkalla + "')";
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