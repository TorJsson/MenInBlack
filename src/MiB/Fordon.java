package MiB;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Fordon {
    private static InfDB databas = Start.getDatabas();
    
    //Metod f�r att h�mta fordonsbeskrivning f�r ett vald fordon utifr�n fordonsId
    public static String getBeskrivningById(String fordonsId) {
        String resultat = "";
        
        try {
            String query = "SELECT fordonsbeskrivning FROM fordon WHERE fordons_id = '" + fordonsId + "'";
            resultat = databas.fetchSingle(query);
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r fordonsbeskrivning skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        
        return resultat;
    }
    
    //Metod f�r att h�mta registreringsdatum f�r ett vald fordon utifr�n fordonsId
    public static String getRegistreringsdatumById(String fordonsId) {
        String resultat = "";
        
        try {
            String query = "SELECT registreringsdatum FROM fordon WHERE fordons_id = '" + fordonsId + "'";
            resultat = databas.fetchSingle(query);
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r registreringsdatum skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        
        return resultat;
    }    
    
    //Metod f�r att h�mta �rsmodell f�r ett vald fordon utifr�n fordonsId
    public static String getArsmodellById(String fordonsId) {
        String resultat = "";

        try {
            String query = "SELECT arsmodell FROM fordon WHERE fordons_id = '" + fordonsId + "'";
            resultat = databas.fetchSingle(query);
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r �rsmodell skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }

        return resultat;
    }
    
    //Metod f�r att h�mta alla fordonsIdn utkvitterade av en vald agent utifr�n agentens Id
    public static ArrayList<String> getAllaFordonsIdByAgentId(int agentId) {
    ArrayList<String> resultat = new ArrayList<>();
        try {
            String query = "SELECT fordons_id FROM innehar_fordon WHERE agent_id = " + agentId;
            resultat = databas.fetchColumn(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r fordonsIDn skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att h�mta utkvitteringsdatum f�r ett vald fordon f�r en vald agent utifr�n fordonsId och agentId
    public static String getUtkvitteringsDatumById(String fordonsId, int agentId) {
        String resultat = "";

        try {
            String query = "SELECT utkvitteringsdatum FROM innehar_fordon WHERE agent_id = " + agentId + " AND FORDONS_ID = '" + fordonsId + "'";
            resultat = databas.fetchSingle(query);        
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r utkvitteringsdatum skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());        
        }
        return resultat;
    }
    
    //Metod som genererar en arraylist �ver fordonsinformation utifr�n en vald agent
    public static ArrayList<HashMap<String, String>> getListaData(int agentId){
        ArrayList<HashMap<String, String>> resultat = new ArrayList<>();

        try{
            String query = "SELECT FORDON.FORDONS_ID, FORDON.FORDONSBESKRIVNING, FORDON.ARSMODELL, FORDON.REGISTRERINGSDATUM, INNEHAR_FORDON.UTKVITTERINGSDATUM FROM FORDON JOIN INNEHAR_FORDON ON INNEHAR_FORDON.FORDONS_ID = FORDON.FORDONS_ID WHERE INNEHAR_FORDON.AGENT_ID = " + agentId;
            resultat = databas.fetchRows(query);
        } catch(InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r listdata skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att h�mta fordonsinformation f�r alla fordon
    public static ArrayList<HashMap<String, String>> getAllListaData(){
        ArrayList<HashMap<String, String>> resultat = new ArrayList<>();

        try{
            String query = "SELECT FORDON.FORDONS_ID, FORDON.FORDONSBESKRIVNING, FORDON.ARSMODELL, FORDON.REGISTRERINGSDATUM FROM FORDON";
            resultat = databas.fetchRows(query);
        } catch(InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r listdata skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att kontrollera om ett fordonsId �r ledigt.
    public static boolean ledigtId(String id) {
        boolean ledigt = true;
        try{
            String query = "SELECT fordons_id FROM fordon WHERE UPPER(fordons_id) = '" + id.toUpperCase() + "'";
            String resultat = databas.fetchSingle(query);
            
            if(resultat != null && !resultat.isEmpty()) {
                ledigt = false;
            }
            
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r fordonsId skulle kontrolleras. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return ledigt;
    
    }
    
    //Metod f�r att l�gga till ett fordon
    public static boolean laggTill(String id, String beskrivning, String datum, int arsmodell) {
        boolean success = false;
        
        
        try {
        String query = "INSERT INTO fordon (fordons_id, fordonsbeskrivning, registreringsdatum, arsmodell) VALUES ('" + id + "', '" + beskrivning + "', '" + datum + "', " + arsmodell + ")";
        databas.insert(query);
        success = true;
        } catch(InfException e) {
        JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r fordon skulle l�ggas till. F�rs�k igen.");
        System.out.println("Felmeddelande: " + e.getMessage());
        }
        
        return success;
    }
    
    //Metod f�r att kvittera ut ett fordon och registrera det p� en agent
    public static boolean kvitteraUt(int agentId, String fordonsId, String datum) {
        boolean success = false;
        
        try {
            databas.insert("INSERT INTO innehar_fordon (agent_id, fordons_id, utkvitteringsdatum) VALUES (" + agentId + ", '" + fordonsId + "', '" + datum + "')");
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r fordon skulle kvitteras ut. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    
    }
    
    //Metod f�r att kontrollera om ett fordon �r utkvitterat utifr�n fordonsId
    public static boolean arUtkvitterad(String fordonsId) {
        boolean utkvitterat = false;
        
        try {
            String resultat = databas.fetchSingle("SELECT fordons_id FROM innehar_fordon WHERE fordons_id = '" + fordonsId + "'");
            
            if(resultat != null && !resultat.isEmpty()) {
                utkvitterat = true;
            }
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r utkvitteringsstatus skulle kontrolleras. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return utkvitterat;
    }
    
    //Metod f�r att �terl�mna/�terst�lla utkvittering f�r ett valt fordon utifr�n fordonsId
    public static boolean lamnaTillbaka(String fordonsId) {
        boolean tillbakalamnad = false;
        
        try{ 
            databas.delete("DELETE FROM innehar_fordon WHERE fordons_id = '" + fordonsId + "'");
            tillbakalamnad = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r fordonet skulle �terl�mnas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return tillbakalamnad;
    }
    
    //Metod f�r att ta bort ett fordon utifr�n fordonsId
    public static boolean taBort(String fordonsId) {
        boolean borttagen = false;
        
        try{ 
            databas.delete("DELETE FROM fordon WHERE UPPER(fordons_id) = '" + fordonsId.toUpperCase() + "'");
            borttagen = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r fordonet skulle tas bort. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return borttagen;
    }
    
    //Metod som returnerar agentId tillh�rande den agent som har kvitterat ut ett fordon utifr�n fordonsId
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
