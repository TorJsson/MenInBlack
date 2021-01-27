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

    //Metod f�r att h�mta en aliens Id utifr�n aliens namn
    public static String getIdByNamn(String namn) {    
        String resultat = "0";
        try {
            resultat = databas.fetchSingle("SELECT alien_id FROM alien WHERE UPPER(namn) = '" + namn.toUpperCase() + "'");
        //Om n�gonting g�r fel under v�gen, visa felmeddelande f�r anv�ndaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r ID skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }        
        
        return resultat;
    }
    
    //Metod f�r att h�mta registreringsdatum f�r en alien utifr�n dess Id
    public static String getRegistreringsdatumById(int alienId) {
        String resultat = "";
        
        try {
            //F�rbered SQLfr�ga
            String query = "SELECT registreringsdatum FROM alien WHERE alien_id = '" + alienId + "'";
            resultat = databas.fetchSingle(query);
        //Om n�gonting g�r fel under v�gen, visa felmeddelande f�r anv�ndaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r registreringsdatum skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "";
        }
        return resultat;
    }
    
    //En s�n h�r public-metod har v�l alla? :) Metod f�r att h�mta l�senorded tillh�rande en alien utifr�n aliens Id
    public static String getLosenordById(int alienId) {
        String resultat = "";
        
        try {
        //F�rbered SQLfr�ga
            String query = "SELECT losenord FROM alien WHERE alien_id = '" + alienId + "'";
            resultat = databas.fetchSingle(query);
        //Om n�gonting g�r fel under v�gen, visa felmeddelande f�r anv�ndaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r l�senordet skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "";
        }
        return resultat;
    }
        
    //Metod f�r att h�mta en aliens namn utifr�n dess Id
    public static String getNamnById(int alienId) {
        String resultat = "";
        try {
        //F�rbered SQLfr�ga
            String query = "SELECT namn FROM alien WHERE alien_id = '" + alienId + "'";
            resultat = databas.fetchSingle(query);
        //Om n�gonting g�r fel under v�gen, visa felmeddelande f�r anv�ndaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r namn skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att h�mta en aliens registrerade telefonnummer utifr�n dess Id
    public static String getTelefonnummerById(int alienId) {
        String resultat = "";
        
        try {
        //F�rbered SQLFr�ga
            String query = "SELECT telefon FROM alien WHERE alien_id = " + alienId;
            resultat = databas.fetchSingle(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r telefonnummer skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage()); 
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "";
        }
        return resultat;
    
    }
   
    //Metod f�r att h�mta platsId f�r den plats en alien �r registrerad p� utifr�n alienId
    public static String getPlatsById(int alienId) {
        String resultat = "";
        
        try {
            //F�rbered SQLfr�ga
            String query = "SELECT plats FROM alien WHERE alien_id = '" + alienId + "'";
            resultat = databas.fetchSingle(query);
        //Om n�gonting g�r fel under v�gen, visa felmeddelande f�r anv�ndaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r plats skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "";
        }
        return resultat;
    }
    
    //Metod f�r att h�mta agentId f�r den agent som ansvarar f�r en vald alien
    public static String getAnsvarigAgentById(int alienId) {
        String resultat = "";
        
        try {
            //F�rbered SQLfr�ga
            String query = "SELECT ansvarig_agent FROM alien WHERE alien_id = '" + alienId + "'";
            resultat = databas.fetchSingle(query);
        //Om n�gonting g�r fel under v�gen, visa felmeddelande f�r anv�ndaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r ansvarig agent skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "";
        }
        return resultat;
    }
    
    //Metod f�r att uppdatera l�senordet f�r en alien
    public static boolean setPassword(int alienId, String losenord) {
        boolean success = false;
        try {
            //F�rbered SQLfr�ga
            String query = "UPDATE alien SET losenord = '" + losenord + "' WHERE alien_id = " + alienId;
            databas.update(query);
            success = true;
        //Om n�gonting g�r fel under v�gen, visa felmeddelande f�r anv�ndaren och spara det faktiska felmeddelandet internt.
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r l�senord skulle sparas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod f�r att h�mta alla registrerade aliens namn och id
    public static ArrayList<HashMap<String,String>> getAllaNamnOchId() {
            ArrayList<HashMap<String,String>> resultat = null;
            try {
                resultat = databas.fetchRows("SELECT namn, alien_id FROM alien");
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r alla namn och IDn skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
    }
    
    //Metod f�r att h�mta alla registrerade aliens namn och id utifr�n vilken plats de �r registrerade p�
    public static ArrayList<HashMap<String,String>> getAllaNamnOchIdByPlats(int platsId) {
            ArrayList<HashMap<String,String>> resultat = null;
            try {
                resultat = databas.fetchRows("SELECT namn, alien_id FROM alien WHERE plats = " + platsId);
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r alla namn och IDn p� en plats skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
    }
    
    //Metod f�r att h�mta alla namn p� aliens registrerade p� en vald plats
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
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r all data om en alien skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att h�mta all data f�r en alien utifr�n den plats de �r registrerade p�
    public static ArrayList<HashMap<String,String>> getAllaByPlats(int platsId) {
        ArrayList<HashMap<String,String>> resultat = null;
        try {
            resultat = databas.fetchRows("SELECT alien_id, registreringsdatum, losenord, namn, telefon, plats, ansvarig_agent FROM alien WHERE plats = " + platsId);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r alla aliens p� en plats skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att h�mta namn och id p� aliens av en vald ras
    public static ArrayList<HashMap<String,String>> getAllaNamnOchIdByRas(String ras) {
            ArrayList<HashMap<String,String>> resultat = null;
            try {
                resultat = databas.fetchRows("SELECT namn, alien_id FROM alien WHERE alien_id IN (SELECT alien_id FROM " + ras + ")");
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r alla namn och IDn av rasen " + ras + " skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
    }
    
    //Metod f�r att h�mta namn och id f�r aliens registrerade mellan tv� valda datum
    public static ArrayList<HashMap<String,String>> getAllaNamnOchIdByDatum(String startDatum, String slutDatum) {
        ArrayList<HashMap<String,String>> resultat = null;
        try {
            resultat = databas.fetchRows("SELECT namn, alien_id FROM alien WHERE registreringsdatum BETWEEN '" + startDatum + "' AND '" + slutDatum + "'");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r alla namn och IDn med registreringsdatum efter " + startDatum + " och innan " + slutDatum + " skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
   
    //Metod som returnerar en enskild aliens ras som en str�ng. Anv�nder sig av getIsBoglodite(), getIsSquid() och getIsWorm(). Tar en integer som inparameter (aliens id).
    public static String getRas(int alienId) {
        String resultat = "Ok�nd ras";

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
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r ras skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
            return resultat;
    }
    
    //Metod som returnerar true om en alien �r av rasen boglodite. Tar en integer som inparameter (aliens id).
    public static boolean getIsBoglodite(int alienId) {
        boolean resultat = false;
            try {
                String query = "SELECT alien_id FROM boglodite WHERE EXISTS (SELECT alien_id FROM boglodite WHERE alien_id = " + alienId + ")";
                resultat = databas.fetchSingle(query) != null;
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r boglodites skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
        
    }
    
    //Metod som returnerar true om en alien �r av rasen squid. Tar en integer som inparameter (aliens id).
    public static boolean getIsSquid(int alienId) {
        boolean resultat = false;
            try {
                String query = "SELECT alien_id FROM squid WHERE EXISTS (SELECT alien_id FROM squid WHERE alien_id = " + alienId + ")";
                resultat = databas.fetchSingle(query) != null;
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r squids skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
        
    }
    //Metod som returnerar true om en alien �r av rasen worm. Tar en integer som inparameter (aliens id).
    public static boolean getIsWorm(int alienId) {
        boolean resultat = false;
            try {
                String query = "SELECT alien_id FROM worm WHERE EXISTS (SELECT alien_id FROM worm WHERE alien_id = " + alienId + ")";
                resultat = databas.fetchSingle(query) != null;
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r worms skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
        
    }
    
    //Metod f�r att returnera rasattribut f�r en vald ras
    public static String getRasAttribut(String ras) {
        String rasAttribut = "Inga attribut angivna.";    
        if(ras.equals("Boglodite")) {
            rasAttribut = "Antal boogies";
        } else if(ras.equals("Squid")) {
            rasAttribut = "Antal armar";
        }
        return rasAttribut;
    }
    
    //Metod f�r att returnera rasattributdata f�r en vald alien av en vald ras
    public static int getRasAttributData(String ras, int alienId) {
        int rasAttribut = 0;
        if(ras.equals("Boglodite")) { 
            try {
                String query = "SELECT antal_boogies FROM boglodite WHERE alien_id = " + alienId;
                rasAttribut = Integer.parseInt(databas.fetchSingle(query));
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r antal boogies skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
        } else if(ras.equals("Squid")) {
            try {
                String query = "SELECT antal_armar FROM squid WHERE alien_id = " + alienId;
                rasAttribut = Integer.parseInt(databas.fetchSingle(query));
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r antal armar skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
        }
        return rasAttribut;
    }
    
    //Metod f�r att h�mta alla namn och id p� aliens som matchar en namnstr�ng
    public static ArrayList<HashMap<String,String>> getAllaNamnOchIdByNamn(String alienNamn) {
        ArrayList<HashMap<String,String>> resultat = null;
        try {
            resultat = databas.fetchRows("SELECT alien_id, namn FROM ALIEN WHERE UPPER(namn) LIKE '" + alienNamn.toUpperCase() + "'");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r aliens med namnet " + alienNamn + " skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att l�gga till en alien
    public static boolean laggTill(String losenord, String namn, String telefon, String platsNamn, int ansvarigAgent, String ras, int rasAttribut) {
        boolean success = false;
        String nyttId = "";
        
        try {
            nyttId = databas.getAutoIncrement("alien","alien_id");
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r alien-ID skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        //F�r f�ltet alien_id
        int id = Integer.parseInt(nyttId);
        
        //F�r f�ltet registreringsdatum
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String registreringsdatum = LocalDate.now().format(formatter);
        
        //F�r f�ltet plats
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
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r alien skulle l�ggas till. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    //Metod f�r att uppdatera en alien
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
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r alien skulle uppdateras. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod f�r att ta bort en alien
    public static boolean taBort(int alienId) {
        boolean success = false;
        
        try {
            databas.delete("DELETE FROM alien WHERE alien_id = " + alienId);
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r alien skulle tas bort. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
        
    }
    

    //Metod f�r att kontrollera om ett namn p� alien �r upptaget eller ledigt. Returnerar true om namnet �r ledigt, annars false.
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
    
    //Metod f�r att h�mta en topplista �ver de topp 3 agenter som ansvarar f�r flest aliens i ett vald omr�de 
    public static ArrayList<HashMap<String, String>> hamtaTopplista(int omradesId){

          ArrayList<HashMap<String, String>> resultat = null;

          try {
              resultat = databas.fetchRows("SELECT AGENT.NAMN, COUNT(*) FROM AGENT JOIN ALIEN ON ALIEN.ANSVARIG_AGENT = AGENT.AGENT_ID JOIN OMRADE ON OMRADE.OMRADES_ID = AGENT.OMRADE WHERE OMRADE.OMRADES_ID = '" + omradesId + "' GROUP BY AGENT.NAMN ORDER BY COUNT(*) DESC ROWS 1 TO 3");
          } catch (InfException e) {
              JOptionPane.showMessageDialog(null, "N�got gick fel vid h�mtning av topplistan!");
              System.out.println("Felmeddelande: " + e.getMessage());

          }

          return resultat;

    }
    
    public static boolean andraAnsvarigAgent (int valdAgent, int nyAnsvarigAgent) {
        boolean resultat = false;
        
        try{
            databas.update("UPDATE alien SET ansvarig_agent = " + nyAnsvarigAgent + " WHERE ansvarig_agent = " + valdAgent);
        }catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�got gick fel vid �ndring av ansvarig agent!");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
}

