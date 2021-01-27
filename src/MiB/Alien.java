package MiB;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.JOptionPane;

public class Alien {
    private static InfDB databas = Start.getDatabas();

    //Metod för att hämta en aliens Id utifrån aliens namn
    public static String getIdByNamn(String namn) {    
        String resultat = "0";
        try {
            resultat = databas.fetchSingle("SELECT alien_id FROM alien WHERE UPPER(namn) = '" + namn.toUpperCase() + "'");
        //Om någonting går fel under vägen, visa felmeddelande för användaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när ID skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }        
        
        return resultat;
    }
    
    //Metod för att hämta registreringsdatum för en alien utifrån dess Id
    public static String getRegistreringsdatumById(int alienId) {
        String resultat = "";
        
        try {
            //Förbered SQLfråga
            String query = "SELECT registreringsdatum FROM alien WHERE alien_id = '" + alienId + "'";
            resultat = databas.fetchSingle(query);
        //Om någonting går fel under vägen, visa felmeddelande för användaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när registreringsdatum skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "";
        }
        return resultat;
    }
    
    //En sån här public-metod har väl alla? :) Metod för att hämta lösenorded tillhörande en alien utifrån aliens Id
    public static String getLosenordById(int alienId) {
        String resultat = "";
        
        try {
        //Förbered SQLfråga
            String query = "SELECT losenord FROM alien WHERE alien_id = '" + alienId + "'";
            resultat = databas.fetchSingle(query);
        //Om någonting går fel under vägen, visa felmeddelande för användaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när lösenordet skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "";
        }
        return resultat;
    }
        
    //Metod för att hämta en aliens namn utifrån dess Id
    public static String getNamnById(int alienId) {
        String resultat = "";
        try {
        //Förbered SQLfråga
            String query = "SELECT namn FROM alien WHERE alien_id = '" + alienId + "'";
            resultat = databas.fetchSingle(query);
        //Om någonting går fel under vägen, visa felmeddelande för användaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när namn skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod för att hämta en aliens registrerade telefonnummer utifrån dess Id
    public static String getTelefonnummerById(int alienId) {
        String resultat = "";
        
        try {
        //Förbered SQLFråga
            String query = "SELECT telefon FROM alien WHERE alien_id = " + alienId;
            resultat = databas.fetchSingle(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när telefonnummer skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage()); 
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "";
        }
        return resultat;
    
    }
   
    //Metod för att hämta platsId för den plats en alien är registrerad på utifrån alienId
    public static String getPlatsById(int alienId) {
        String resultat = "";
        
        try {
            //Förbered SQLfråga
            String query = "SELECT plats FROM alien WHERE alien_id = '" + alienId + "'";
            resultat = databas.fetchSingle(query);
        //Om någonting går fel under vägen, visa felmeddelande för användaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när plats skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "";
        }
        return resultat;
    }
    
    //Metod för att hämta agentId för den agent som ansvarar för en vald alien
    public static String getAnsvarigAgentById(int alienId) {
        String resultat = "";
        
        try {
            //Förbered SQLfråga
            String query = "SELECT ansvarig_agent FROM alien WHERE alien_id = '" + alienId + "'";
            resultat = databas.fetchSingle(query);
        //Om någonting går fel under vägen, visa felmeddelande för användaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när ansvarig agent skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "";
        }
        return resultat;
    }
    
    //Metod för att uppdatera lösenordet för en alien
    public static boolean setPassword(int alienId, String losenord) {
        boolean success = false;
        try {
            //Förbered SQLfråga
            String query = "UPDATE alien SET losenord = '" + losenord + "' WHERE alien_id = " + alienId;
            databas.update(query);
            success = true;
        //Om någonting går fel under vägen, visa felmeddelande för användaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när lösenord skulle sparas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod för att hämta alla registrerade aliens namn och id
    public static ArrayList<HashMap<String,String>> getAllaNamnOchId() {
            ArrayList<HashMap<String,String>> resultat = null;
            try {
                resultat = databas.fetchRows("SELECT namn, alien_id FROM alien");
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när alla namn och IDn skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
    }
    
    //Metod för att hämta alla registrerade aliens namn och id utifrån vilken plats de är registrerade på
    public static ArrayList<HashMap<String,String>> getAllaNamnOchIdByPlats(int platsId) {
            ArrayList<HashMap<String,String>> resultat = null;
            try {
                resultat = databas.fetchRows("SELECT namn, alien_id FROM alien WHERE plats = " + platsId);
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när alla namn och IDn på en plats skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
    }
    
    //Metod för att hämta alla namn på aliens registrerade på en vald plats
    public static ArrayList<String> getAllaNamnByPlats(int platsId) {
        String query = "SELECT namn FROM alien WHERE plats = " + platsId;
        ArrayList<String> allaNamn = new ArrayList<>();
        
        try {
            allaNamn = databas.fetchColumn(query);
            
        } catch(InfException e) {
            //
        }
        return allaNamn;
    }
    public static ArrayList<HashMap<String,String>> getAllaById(int alienId) {
        ArrayList<HashMap<String,String>> resultat = null;
        try {
            resultat = databas.fetchRows("SELECT alien.alien_id, alien.registreringsdatum, alien.ansvarig_agent, alien.namn, alien.telefon, alien.losenord, plats.benamning, plats.plats_id FROM alien JOIN plats on alien.plats = plats.plats_id WHERE alien.alien_id = " + alienId);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när all data om en alien skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod för att hämta all data för en alien utifrån den plats de är registrerade på
    public static ArrayList<HashMap<String,String>> getAllaByPlats(int platsId) {
        ArrayList<HashMap<String,String>> resultat = null;
        try {
            resultat = databas.fetchRows("SELECT alien_id, registreringsdatum, losenord, namn, telefon, plats, ansvarig_agent FROM alien WHERE plats = " + platsId);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när alla aliens på en plats skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod för att hämta namn och id på aliens av en vald ras
    public static ArrayList<HashMap<String,String>> getAllaNamnOchIdByRas(String ras) {
            ArrayList<HashMap<String,String>> resultat = null;
            try {
                resultat = databas.fetchRows("SELECT namn, alien_id FROM alien WHERE alien_id IN (SELECT alien_id FROM " + ras + ")");
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när alla namn och IDn av rasen " + ras + " skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
    }
    
    //Metod för att hämta namn och id för aliens registrerade mellan två valda datum
    public static ArrayList<HashMap<String,String>> getAllaNamnOchIdByDatum(String startDatum, String slutDatum) {
        ArrayList<HashMap<String,String>> resultat = null;
        try {
            resultat = databas.fetchRows("SELECT namn, alien_id FROM alien WHERE registreringsdatum BETWEEN '" + startDatum + "' AND '" + slutDatum + "'");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när alla namn och IDn med registreringsdatum efter " + startDatum + " och innan " + slutDatum + " skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
   
    //Metod som returnerar en enskild aliens ras som en sträng. Använder sig av getIsBoglodite(), getIsSquid() och getIsWorm(). Tar en integer som inparameter (aliens id).
    public static String getRas(int alienId) {
        String resultat = "Okänd ras";

        try{
            String boglodite = databas.fetchSingle("SELECT alien_id FROM boglodite WHERE alien_id = " + alienId);
            String squid = databas.fetchSingle("SELECT alien_id FROM squid WHERE alien_id = " + alienId);
            String worm = databas.fetchSingle("SELECT alien_id FROM worm WHERE alien_id = " + alienId);
            if(boglodite != null) {
                resultat = "Boglodite";
            } else if (squid != null) {
                resultat = "Squid";
            } else if(worm != null) {
                resultat = "Worm";
            }
        } catch(InfException e){
            JOptionPane.showMessageDialog(null, "Någonting gick fel när ras skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
            return resultat;
    }
    
    //Metod som returnerar true om en alien är av rasen boglodite. Tar en integer som inparameter (aliens id).
    public static boolean getIsBoglodite(int alienId) {
        boolean resultat = false;
            try {
                String query = "SELECT alien_id FROM boglodite WHERE EXISTS (SELECT alien_id FROM boglodite WHERE alien_id = " + alienId + ")";
                resultat = databas.fetchSingle(query) != null;
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när boglodites skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
        
    }
    
    //Metod som returnerar true om en alien är av rasen squid. Tar en integer som inparameter (aliens id).
    public static boolean getIsSquid(int alienId) {
        boolean resultat = false;
            try {
                String query = "SELECT alien_id FROM squid WHERE EXISTS (SELECT alien_id FROM squid WHERE alien_id = " + alienId + ")";
                resultat = databas.fetchSingle(query) != null;
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när squids skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
        
    }
    //Metod som returnerar true om en alien är av rasen worm. Tar en integer som inparameter (aliens id).
    public static boolean getIsWorm(int alienId) {
        boolean resultat = false;
            try {
                String query = "SELECT alien_id FROM worm WHERE EXISTS (SELECT alien_id FROM worm WHERE alien_id = " + alienId + ")";
                resultat = databas.fetchSingle(query) != null;
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när worms skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
        
    }
    
    //Metod för att returnera rasattribut för en vald ras
    public static String getRasAttribut(String ras) {
        String rasAttribut = "Inga attribut angivna.";    
        if(ras.equals("Boglodite")) {
            rasAttribut = "Antal boogies";
        } else if(ras.equals("Squid")) {
            rasAttribut = "Antal armar";
        }
        return rasAttribut;
    }
    
    //Metod för att returnera rasattributdata för en vald alien av en vald ras
    public static int getRasAttributData(String ras, int alienId) {
        int rasAttribut = 0;
        if(ras.equals("Boglodite")) { 
            try {
                String query = "SELECT antal_boogies FROM boglodite WHERE alien_id = " + alienId;
                rasAttribut = Integer.parseInt(databas.fetchSingle(query));
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när antal boogies skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
        } else if(ras.equals("Squid")) {
            try {
                String query = "SELECT antal_armar FROM squid WHERE alien_id = " + alienId;
                rasAttribut = Integer.parseInt(databas.fetchSingle(query));
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när antal armar skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
        }
        return rasAttribut;
    }
    
    //Metod för att hämta alla namn och id på aliens som matchar en namnsträng
    public static ArrayList<HashMap<String,String>> getAllaNamnOchIdByNamn(String alienNamn) {
        ArrayList<HashMap<String,String>> resultat = null;
        try {
            resultat = databas.fetchRows("SELECT alien_id, namn FROM ALIEN WHERE UPPER(namn) LIKE '" + alienNamn.toUpperCase() + "'");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när aliens med namnet " + alienNamn + " skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod för att lägga till en alien
    public static boolean laggTill(String losenord, String namn, String telefon, String platsNamn, int ansvarigAgent, String ras, int rasAttribut) {
        boolean success = false;
        String nyttId = "";
        
        try {
            nyttId = databas.getAutoIncrement("alien","alien_id");
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när alien-ID skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        //För fältet alien_id
        int id = Integer.parseInt(nyttId);
        
        //För fältet registreringsdatum
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String registreringsdatum = LocalDate.now().format(formatter);
        
        //För fältet plats
        int plats = Integer.parseInt(Plats.getIdByBenamning(platsNamn));
        
        try{
            databas.insert("insert into alien (alien_id, registreringsdatum, losenord, namn, telefon, plats, ansvarig_agent) values(" + id + ", '" + registreringsdatum + "', '" + losenord + "' , '" + namn + "' , '" + telefon + "' ," + plats + "," + ansvarigAgent + ")");
            if(ras.equals("Boglodite")) {
                databas.insert("insert into boglodite (alien_id, antal_boogies) values (" + id + "," + rasAttribut +")");
            } else if(ras.equals("Squid")) {
                databas.insert("insert into squid (alien_id, antal_armar) values (" + id + "," + rasAttribut +")");
            } else {
                databas.insert("insert into worm (alien_id) values (" + id + ")");
            }
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när alien skulle läggas till. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    //Metod för att uppdatera en alien
    public static boolean uppdateraAlien(String namn, String telefonnummer, String plats, String losenord, String ras, String nyRas, String rasAttribut, String ansvarigAgent, int valdAlien) {
        boolean success = false;
        int platsId = Integer.parseInt(Plats.getIdByBenamning(plats));
        int ansvarigAgentId = Integer.parseInt(Agent.getIdByNamn(ansvarigAgent));
        try {
            databas.update("UPDATE alien SET namn = '" + namn + "', TELEFON = '" + telefonnummer + "', PLATS = " + platsId + ", LOSENORD = '" + losenord + "', ANSVARIG_AGENT = " + ansvarigAgentId + " WHERE alien_id = " + valdAlien + "");
            databas.delete("DELETE FROM " + ras + " WHERE alien_id = " + valdAlien + "");
            if(nyRas.equals("Boglodite")) {
                databas.insert("insert into boglodite (alien_id, antal_boogies) values (" + valdAlien + "," + rasAttribut + ")");
            } else if(nyRas.equals("Squid")) {
                databas.insert("insert into squid (alien_id, antal_armar) values (" + valdAlien + "," + rasAttribut + ")");
            } else {
                databas.insert("insert into worm (alien_id) values (" + valdAlien + ")");
            }
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när alien skulle uppdateras. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod för att ta bort en alien
    public static boolean taBort(int alienId) {
        boolean success = false;
        
        try {
            databas.delete("DELETE FROM alien WHERE alien_id = " + alienId);
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när alien skulle tas bort. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
        
    }
    

    //Metod för att kontrollera om ett namn på alien är upptaget eller ledigt. Returnerar true om namnet är ledigt, annars false.
    public static boolean getLedigtNamn(String namn) {
        boolean ledigt = false;
        
        try{
            String query = "SELECT namn FROM alien WHERE UPPER(namn) = '" + namn.toUpperCase() + "'";
            if(databas.fetchSingle(query) == null) {
                ledigt = true;
            }
        } catch(InfException e) {
        
        }
        return ledigt;
    }
    
    //Metod för att hämta en topplista över de topp 3 agenter som ansvarar för flest aliens i ett vald område 
    public static ArrayList<HashMap<String, String>> hamtaTopplista(int omradesId){

          ArrayList<HashMap<String, String>> resultat = null;

          try {
              resultat = databas.fetchRows("SELECT AGENT.NAMN, COUNT(*) FROM AGENT JOIN ALIEN ON ALIEN.ANSVARIG_AGENT = AGENT.AGENT_ID JOIN OMRADE ON OMRADE.OMRADES_ID = AGENT.OMRADE WHERE OMRADE.OMRADES_ID = '" + omradesId + "' GROUP BY AGENT.NAMN ORDER BY COUNT(*) DESC ROWS 1 TO 3");
          } catch (InfException e) {
              JOptionPane.showMessageDialog(null, "Något gick fel vid hämtning av topplistan!");
              System.out.println("Felmeddelande: " + e.getMessage());

          }

          return resultat;

    }
    
    public static boolean andraAnsvarigAgent (int valdAgent, int nyAnsvarigAgent) {
        boolean resultat = false;
        
        try{
            databas.update("UPDATE alien SET ansvarig_agent = " + nyAnsvarigAgent + " WHERE ansvarig_agent = " + valdAgent);
        }catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel vid ändring av ansvarig agent!");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
}

