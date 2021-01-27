package MiB;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Utrustning {
    
    private static InfDB databas = Start.getDatabas();
    
    //Metod för att hämta benämningen på en vald utrustning utifrån utrustningsId
    public static String getBenamningById(int utrustningsId) {
        String resultat = "";
        try {
            String query = "SELECT benamning FROM utrustning WHERE utrustnings_id = " + utrustningsId;
            resultat = databas.fetchSingle(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när benämning skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;  
    }
    
    //Metod för att hämta idnummer över all utrustning som är utkvitterad av en agent utifrån agentens id
    public static ArrayList<String> getAllUtrustningByAgentId(int agentId) {
        ArrayList<String> resultat = new ArrayList<>();
        try {
            String query = "SELECT utrustings_id FROM innehar_utrustning WHERE agent_id = " + agentId + ")";
            resultat = databas.fetchColumn(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när utrustning skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;  
    }
        
    //Metod för att hämta utkvitteringsdatum för en vald utrustning utifrån en vald agents id
    public static String getUtkvitteringsdatumById(int utrustningsId, int agentId) {
        String resultat = "";
        try {
            String query = "SELECT utkvitteringsdatum FROM innehar_utrustning WHERE utrustnings_id = '" + utrustningsId + "' AND agent_id = '" + agentId + "'";
            resultat = databas.fetchSingle(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när utkvitteringsdatum skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //metod för att kvittera ut utrustning mha en agents id
    public static boolean kvitteraUt(int agentId, int utrustningsId, String datum) {
        boolean success = false;
        
        try {
            databas.insert("INSERT INTO innehar_utrustning (agent_id, utrustnings_id, utkvitteringsdatum) VALUES (" + agentId + ", " + utrustningsId + ", '" + datum + "')");
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när utrustning skulle kvitteras ut. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    
    }
    
    //Metod för att kontrollera om en vald utrustning är utkvitterad
    public static boolean arUtkvitterad(int utrustningsId) {
        boolean utkvitterat = false;
        
        try {
            String resultat = databas.fetchSingle("SELECT utrustnings_id FROM innehar_utrustning WHERE utrustnings_id = " + utrustningsId);
            
            if(resultat != null && !resultat.isEmpty()) {
                utkvitterat = true;
            }
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när utkvitteringsstatus skulle kontrolleras. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return utkvitterat;
    }
    
    //Metod för att lämna tillbaka/ta bort utkvittering av en vald utrustning utifrån utrustningsId
    public static boolean lamnaTillbaka(String utrustningsId) {
        boolean tillbakalamnad = false;
        
        try{ 
            databas.delete("DELETE FROM innehar_utrustning WHERE utrustnings_id = '" + utrustningsId + "'");
            tillbakalamnad = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när utrustningen skulle återlämnas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return tillbakalamnad;
    }
    
    //Metod för att ta bort en utrustning utifrån utrustningsId och vilken kategori utrustningen tillhör
    public static boolean taBort(int utrustningsId, String kategori) {
        boolean borttagen = false;
        
        try{
            databas.delete("DELETE FROM utrustning WHERE utrustnings_id = '" + utrustningsId + "'");
            databas.delete("DELETE FROM " + kategori + " WHERE utrustnings_id = '" + utrustningsId + "'");
            borttagen = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när utrustningen skulle tas bort. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return borttagen;
    }
    
    //Metod för att hämta vilken agent (agentId) som har kvitterat ut en vald utrustning utifrån utrustningsId
    public static int getUtkvitteratAv(int utrustningsId) {
        int resultat = 0;
        
        try{
            resultat = Integer.parseInt(databas.fetchSingle("SELECT agent_id FROM innehar_utrustning WHERE utrustnings_id = " + utrustningsId));
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när agentId för utkvitterad utrustning skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
}
