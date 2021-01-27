package MiB;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Teknik {
    private static InfDB databas = Start.getDatabas();
    
    //Metod för att hämta all utkvitterad utrustning per agent. Inparameter int agentId representerar agenten vars utkvitterad utrustning man vill hämta
    public static ArrayList<String> getAllUtrustningByAgentId(int agentId) {
        ArrayList<String> resultat = new ArrayList<>();
        try {
            String query = "SELECT utrustnings_id FROM teknik WHERE utrustnings_id IN (SELECT utrustnings_id FROM innehar_utrustning WHERE agent_id = " + agentId + ")";
            resultat = databas.fetchColumn(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när teknikutrustning skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;  
    }    
    
    //Hämtar data från fältet kraftkälla tillhörande ett visst utrustningsId.
    public static String getKraftkallaById(int utrustningsId) {
        String resultat = "";
        
        try {
            //Förbered SQLfråga
            String query = "SELECT kraftkalla FROM teknik WHERE utrustnings_id = " + utrustningsId;
            resultat = databas.fetchSingle(query);
        //Om någonting går fel under vägen, visa felmeddelande för användaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när kraftkälla skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Hämtar den data som krävs i utrustningslista för teknikutrustning per agent. Inparameter int agentId representerar den agent man vill hämta data för.
    public static ArrayList<HashMap<String, String>> getListaData(int agentId){
        ArrayList<HashMap<String, String>> resultat = new ArrayList<>();

        try{
            String query = "SELECT UTRUSTNING.BENAMNING, TEKNIK.KRAFTKALLA, INNEHAR_UTRUSTNING.UTKVITTERINGSDATUM, UTRUSTNING.UTRUSTNINGS_ID FROM UTRUSTNING JOIN INNEHAR_UTRUSTNING ON INNEHAR_UTRUSTNING.UTRUSTNINGS_ID = UTRUSTNING.UTRUSTNINGS_ID JOIN TEKNIK ON UTRUSTNING.UTRUSTNINGS_ID = TEKNIK.UTRUSTNINGS_ID WHERE INNEHAR_UTRUSTNING.AGENT_ID =" + agentId;
            resultat = databas.fetchRows(query);
        } catch(InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när listdata skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod för att hämta (nästan) all data som finns för teknikutrustning
    public static ArrayList<HashMap<String, String>> getAllListaData(){
        ArrayList<HashMap<String, String>> resultat = new ArrayList<>();

        try{
            String query = "SELECT UTRUSTNING.BENAMNING, TEKNIK.KRAFTKALLA, UTRUSTNING.UTRUSTNINGS_ID FROM UTRUSTNING JOIN TEKNIK ON UTRUSTNING.UTRUSTNINGS_ID = TEKNIK.UTRUSTNINGS_ID";
            resultat = databas.fetchRows(query);
        } catch(InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när listdata skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }    
    
    //Metod för att lägga till teknikutrustning
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
            JOptionPane.showMessageDialog(null, "Någonting gick fel när kommunikationsutrustning skulle läggas till. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
}