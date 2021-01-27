package MiB;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Fordon {
    private static InfDB databas = Start.getDatabas();
    
    //Metod för att hämta fordonsbeskrivning för ett vald fordon utifrån fordonsId
    public static String getBeskrivningById(String fordonsId) {
        String resultat = "";
        
        try {
            String query = "SELECT fordonsbeskrivning FROM fordon WHERE fordons_id = '" + fordonsId + "'";
            resultat = databas.fetchSingle(query);
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när fordonsbeskrivning skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        
        return resultat;
    }
    
    //Metod för att hämta registreringsdatum för ett vald fordon utifrån fordonsId
    public static String getRegistreringsdatumById(String fordonsId) {
        String resultat = "";
        
        try {
            String query = "SELECT registreringsdatum FROM fordon WHERE fordons_id = '" + fordonsId + "'";
            resultat = databas.fetchSingle(query);
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när registreringsdatum skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        
        return resultat;
    }    
    
    //Metod för att hämta årsmodell för ett vald fordon utifrån fordonsId
    public static String getArsmodellById(String fordonsId) {
        String resultat = "";

        try {
            String query = "SELECT arsmodell FROM fordon WHERE fordons_id = '" + fordonsId + "'";
            resultat = databas.fetchSingle(query);
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när årsmodell skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }

        return resultat;
    }
    
    //Metod för att hämta alla fordonsIdn utkvitterade av en vald agent utifrån agentens Id
    public static ArrayList<String> getAllaFordonsIdByAgentId(int agentId) {
    ArrayList<String> resultat = new ArrayList<>();
        try {
            String query = "SELECT fordons_id FROM innehar_fordon WHERE agent_id = " + agentId;
            resultat = databas.fetchColumn(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när fordonsIDn skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod för att hämta utkvitteringsdatum för ett vald fordon för en vald agent utifrån fordonsId och agentId
    public static String getUtkvitteringsDatumById(String fordonsId, int agentId) {
        String resultat = "";

        try {
            String query = "SELECT utkvitteringsdatum FROM innehar_fordon WHERE agent_id = " + agentId + " AND FORDONS_ID = '" + fordonsId + "'";
            resultat = databas.fetchSingle(query);        
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när utkvitteringsdatum skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());        
        }
        return resultat;
    }
    
    //Metod som genererar en arraylist över fordonsinformation utifrån en vald agent
    public static ArrayList<HashMap<String, String>> getListaData(int agentId){
        ArrayList<HashMap<String, String>> resultat = new ArrayList<>();

        try{
            String query = "SELECT FORDON.FORDONS_ID, FORDON.FORDONSBESKRIVNING, FORDON.ARSMODELL, FORDON.REGISTRERINGSDATUM, INNEHAR_FORDON.UTKVITTERINGSDATUM FROM FORDON JOIN INNEHAR_FORDON ON INNEHAR_FORDON.FORDONS_ID = FORDON.FORDONS_ID WHERE INNEHAR_FORDON.AGENT_ID = " + agentId;
            resultat = databas.fetchRows(query);
        } catch(InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när listdata skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod för att hämta fordonsinformation för alla fordon
    public static ArrayList<HashMap<String, String>> getAllListaData(){
        ArrayList<HashMap<String, String>> resultat = new ArrayList<>();

        try{
            String query = "SELECT FORDON.FORDONS_ID, FORDON.FORDONSBESKRIVNING, FORDON.ARSMODELL, FORDON.REGISTRERINGSDATUM FROM FORDON";
            resultat = databas.fetchRows(query);
        } catch(InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när listdata skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod för att kontrollera om ett fordonsId är ledigt.
    public static boolean ledigtId(String id) {
        boolean ledigt = true;
        try{
            String query = "SELECT fordons_id FROM fordon WHERE UPPER(fordons_id) = '" + id.toUpperCase() + "'";
            String resultat = databas.fetchSingle(query);
            
            if(resultat != null && !resultat.isEmpty()) {
                ledigt = false;
            }
            
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när fordonsId skulle kontrolleras. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return ledigt;
    
    }
    
    //Metod för att lägga till ett fordon
    public static boolean laggTill(String id, String beskrivning, String datum, int arsmodell) {
        boolean success = false;
        
        
        try {
        String query = "INSERT INTO fordon (fordons_id, fordonsbeskrivning, registreringsdatum, arsmodell) VALUES ('" + id + "', '" + beskrivning + "', '" + datum + "', " + arsmodell + ")";
        databas.insert(query);
        success = true;
        } catch(InfException e) {
        JOptionPane.showMessageDialog(null, "Någonting gick fel när fordon skulle läggas till. Försök igen.");
        System.out.println("Felmeddelande: " + e.getMessage());
        }
        
        return success;
    }
    
    //Metod för att kvittera ut ett fordon och registrera det på en agent
    public static boolean kvitteraUt(int agentId, String fordonsId, String datum) {
        boolean success = false;
        
        try {
            databas.insert("INSERT INTO innehar_fordon (agent_id, fordons_id, utkvitteringsdatum) VALUES (" + agentId + ", '" + fordonsId + "', '" + datum + "')");
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när fordon skulle kvitteras ut. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    
    }
    
    //Metod för att kontrollera om ett fordon är utkvitterat utifrån fordonsId
    public static boolean arUtkvitterad(String fordonsId) {
        boolean utkvitterat = false;
        
        try {
            String resultat = databas.fetchSingle("SELECT fordons_id FROM innehar_fordon WHERE fordons_id = '" + fordonsId + "'");
            
            if(resultat != null && !resultat.isEmpty()) {
                utkvitterat = true;
            }
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när utkvitteringsstatus skulle kontrolleras. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return utkvitterat;
    }
    
    //Metod för att återlämna/återställa utkvittering för ett valt fordon utifrån fordonsId
    public static boolean lamnaTillbaka(String fordonsId) {
        boolean tillbakalamnad = false;
        
        try{ 
            databas.delete("DELETE FROM innehar_fordon WHERE fordons_id = '" + fordonsId + "'");
            tillbakalamnad = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när fordonet skulle återlämnas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return tillbakalamnad;
    }
    
    //Metod för att ta bort ett fordon utifrån fordonsId
    public static boolean taBort(String fordonsId) {
        boolean borttagen = false;
        
        try{ 
            databas.delete("DELETE FROM fordon WHERE UPPER(fordons_id) = '" + fordonsId.toUpperCase() + "'");
            borttagen = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när fordonet skulle tas bort. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return borttagen;
    }
    
    //Metod som returnerar agentId tillhörande den agent som har kvitterat ut ett fordon utifrån fordonsId
    public static int getUtkvitteratAv(String fordonsId) {
        int resultat = 0;
        
        try{
            resultat = Integer.parseInt(databas.fetchSingle("SELECT agent_id FROM innehar_fordon WHERE UPPER(fordons_id) = '" + fordonsId.toUpperCase() + "'"));
        } catch(InfException e) {
            //Fel
        }
        return resultat;
    }
}
