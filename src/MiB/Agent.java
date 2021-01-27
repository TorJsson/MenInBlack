package MiB;

//Importerar beh�vda paket
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.JOptionPane;

public class Agent {
    //Instansierar variabeln databas som ett objekt av klassen InfDB. H�mtar objektet genom Start-klassens getDatabas()-metod.
    private static InfDB databas = Start.getDatabas();

    //Returnerar true om namnet �r ledigt, annars false.
    public static boolean getLedigtNamn(String namn) {
        boolean ledigt = false;
        try{
            String query = "SELECT namn FROM agent WHERE UPPER(namn) = '" + namn.toUpperCase() + "'";
            if(databas.fetchSingle(query) == null) {
                ledigt = true;
            }
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r kontroll om namnet �r ledigt skulle g�ras. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return ledigt;
    }
    
    //Returnerar agentens ID som en integer. Tar en inparameter i form av en str�ng (agentens namn)
    public static String getIdByNamn(String namn) {    
        String resultat = "0";
        try {
            resultat = databas.fetchSingle("SELECT agent_id FROM agent WHERE UPPER(namn) = '" + namn.toUpperCase() + "'");
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }        
        return resultat;
    }
    
    //Returnerar agentens namn som en str�ng. Tar en inparameter i form av en integer (agentens id)
    public static String getNamnById(int id) {
        String resultat = "";
        try {
            String query = "SELECT namn FROM agent WHERE agent_id = '" + id + "'";
            resultat = databas.fetchSingle(query);
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "0";
        }
        return resultat;
    }
    
    //Returnerar agentens telefonnummer i form av en str�ng. Tar en inparameter i form av en integer (agentens id)
    public static String getTelefonnummerById(int id) {
        String resultat = "Inget telefonnummer lagrat";
        
        try {
            String query = "SELECT telefon FROM agent WHERE agent_id = " + id;
            resultat = databas.fetchSingle(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage()); 
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "0";
        }
        return resultat;
    
    }
    
    //Returnerar agentens anst�llningsdatum i form av en str�ng. Tar en inparameter i form av en integer (agentens id)
    public static String getAnstallningsdatumById(int id) {
        String resultat = "";
        
        try {
            String query = "SELECT anstallningsdatum FROM agent WHERE agent_id = '" + id + "'";
            resultat = databas.fetchSingle(query);
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "0";
        }
        return resultat;
    }
    
    //Returnerar true om agenten �r administrat�r, annars false. Tar en inparameter i form av en integer (agentens id)
    public static boolean getAdminStatusById(int id) {
        boolean resultat = false;
        
        try {
            String query = "SELECT administrator FROM agent WHERE agent_id = '" + id + "'";
            if(databas.fetchSingle(query).equals("J")) {
                resultat = true;
            } else {
                resultat = false;
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Returnerar agentens l�senord som en str�ng. Tar en inparameter i form av en integer (agentens id)
    public static String getLosenordById(int id) {
        String resultat = "";
        
        try {
            String query = "SELECT losenord FROM agent WHERE agent_id = '" + id + "'";
            resultat = databas.fetchSingle(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "0";
        }
        return resultat;
    }
    //Returnerar agentens omr�de som en integer. Tar en inparameter i form av en integer (agentens id).
    public static String getOmradeById(int id) {
        String resultat = "";
        
        try {
            String query = "SELECT omrade FROM agent WHERE agent_id = '" + id + "'";
            resultat = databas.fetchSingle(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "0";
        }
        return resultat;        
    }
    
    
    //Metod som returnerar true om en agent �r f�ltagent. Tar en integer som inparameter (agentens id).
    public static boolean getIsFaltAgent(int agentId) {
        boolean resultat = false;
            try {
                String query = "SELECT agent_id FROM faltagent WHERE EXISTS (SELECT agent_id FROM faltagent WHERE agent_id = " + agentId + ")";
                resultat = databas.fetchSingle(query) != null;
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r f�ltagent skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
        
    }
    
    //Returnerar agentId f�r den agent som �r ansvarig f�r ett omr�de. Tar en integer som inparameter (omr�desId)
    public static boolean getIsOmradesChef(int agentId) {
        boolean resultat = false;
        try {
            String query = "SELECT agent_id FROM omradeschef WHERE EXISTS (SELECT agent_id FROM omradeschef WHERE agent_id = " + agentId + ")";
            resultat = databas.fetchSingle(query) != null;
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r omr�deschef skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;

    }
    
    //Returnerar true om agent �r kontorschef. Tar en integer som inparameter (agentId)
    public static boolean getIsKontorsChef(int agentId) {
        boolean resultat = false;
            try {
                String query = "SELECT agent_id FROM kontorschef WHERE EXISTS (SELECT agent_id FROM kontorschef WHERE agent_id = " + agentId + ")";
                resultat = databas.fetchSingle(query) != null;
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r f�ltagent skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
        
    }
    
    //Returnerar en ArrayList av str�ngar med alla agenters namn.
    public static ArrayList<String> getAllaAgentNamn() {
        ArrayList<String> resultat = new ArrayList<>();
        try {
            String query = "SELECT namn FROM agent";
            resultat = databas.fetchColumn(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r agentnamn skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;  
    }    
   
    //Returnerar en HashMap med utvald agentdata samt omr�desben�mningen f�r det omr�de agenten tillh�r. Tar en integer som inparameter (agentId)
    public static HashMap<String, String> getAgentDataById(int agentId) {
        HashMap<String, String> resultat = new HashMap<>();
        
        try {
            String query = "SELECT agent.namn, agent.telefon, agent.anstallningsdatum, agent.administrator, agent.losenord, omrade.benamning FROM agent JOIN omrade ON omrade.omrades_id = agent.omrade WHERE agent.agent_id = " + agentId;
            resultat = databas.fetchRow(query);
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r agentdata skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Returnerar true om l�senordet �ndrats. �ndrar l�senordet f�r den angivna agenten. Tar tv� inparametrar: En integer (agentId) som representerar den agent man vill �ndra l�senordet f�r, och en str�ng som representerar det nya l�senordet.
    public static boolean setPassword(int agentId, String losenord) {
        boolean success = false;
        try {
            String query = "UPDATE agent SET losenord = '" + losenord + "' WHERE agent_id = " + agentId;
            databas.update(query);
            success = true;
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r l�senord skulle sparas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod som returnerar alla namn och IDn som matchar namnet som matas in som inparameter (str�ng). J�mf�relse sker p� namn i versaler.
    public static ArrayList<HashMap<String,String>> getAllaNamnOchIdByNamn(String agentNamn) {
        ArrayList<HashMap<String,String>> resultat = null;
        try {
            resultat = databas.fetchRows("SELECT agent_id, namn FROM agent WHERE UPPER(namn) LIKE '" + agentNamn.toUpperCase() + "'");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r agenter med namnet " + agentNamn + " skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    //Metod som returnerar alla namn och IDn p� agenter som anst�llts mellan datumen som angetts som inparametrar.
    public static ArrayList<HashMap<String,String>> getAllaNamnOchIdByDatum(String startDatum, String slutDatum) {
        ArrayList<HashMap<String,String>> resultat = null;
        try {
            resultat = databas.fetchRows("SELECT namn, agent_id FROM agent WHERE anstallningsdatum BETWEEN '" + startDatum + "' AND '" + slutDatum + "'");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r alla namn och IDn med anst�llningsdatum mellan " + startDatum + " och " + slutDatum + " skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod som returnerar alla namn och IDn p� agenter som �r av en viss typ (f�ltagent, omr�deschef, kontorschef). 
    public static ArrayList<HashMap<String,String>> getAllaNamnOchIdByTyp(String typ) {
            ArrayList<HashMap<String,String>> resultat = null;
            
            //Omvandlar inparametern typ till r�tt tabellnamn i databasen (utan ���)
            String valdTyp = "";
            if(typ.equals("F�ltagent")) {
                valdTyp = "Faltagent";
            } else if(typ.equals("Omr�deschef")) {
                valdTyp = "Omradeschef";
            } else if(typ.equals("Kontorschef")) {
                valdTyp = "Kontorschef";
            }
            
            try {
                resultat = databas.fetchRows("SELECT namn, agent_id FROM agent WHERE agent_id IN (SELECT agent_id FROM " + valdTyp + ")");
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r alla namn och IDn av typen " + typ + " skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
    }
    
    //Metod som returnerar alla namn och IDn p� agenter som �r tilldelade ett angivet omr�de (inparametern int omradeId)
    public static ArrayList<HashMap<String,String>> getAllaNamnOchIdByOmrade(int omradeId) {
        ArrayList<HashMap<String,String>> resultat = null;
        try {
            resultat = databas.fetchRows("SELECT namn, agent_id FROM agent WHERE omrade = " + omradeId);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r alla namn och IDn fr�n ett omr�de skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod som l�gger till en ny agent. H�mtar ut det f�rsta lediga IDt i agent_id-tabellen genom metoden getAutoIncrement() och anv�nder sig av den, 
    //dagens datum genom metoden LocalDate.now().format() samt datan som skickats med som inparametrar f�r att l�gga till ny data i databasen.
    //Returnerar true om till�ggningen har g�tt att genomf�ra, annars false.
    public static boolean laggTill(String losenord, String namn, String telefon, String omradesNamn, boolean faltagent, boolean omradeschef, boolean kontorschef, String kontorsbeteckning, boolean administrator) {
        boolean success = false;
        
        //H�mtar det f�rsta lediga agent_id't genom att anv�nda InfDB-metoden getAutoIncrement() och tilldelar variabeln nyttId resultatet av databasfr�gan.
        int nyttId = 0;
        try {
            nyttId = Integer.parseInt(databas.getAutoIncrement("agent", "agent_id"));
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r agent-ID skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        
        //Genererar en str�ng med dagens datum i formatet YYYY-MM-DD genom att anv�nda klasserna DateTimeFormatter och dess metod ofPattern() samt klassen LocalDate + metoden now() och format().
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String anstallningsdatum = LocalDate.now().format(format);
        
        //Kontrollerar om inparametern omradesNamn har ett v�rde eller �r null. Om det har ett v�rde h�mtas omr�desId genom att anv�nda klassen Omrade's metod getIdByBenamning.
        String omradesId = "";
        if(omradesNamn != null) {
            omradesId = Omrade.getIdByBenamning(omradesNamn);
        } else {
            omradesId = null;
        }
        
        //Kontrollerar om inparametern administrator �r true eller false och skapar en str�ng som inneh�ller "J" eller "N" som sedan anv�nds vid inmatning i databasen.
        String arAdmin = "";
        if(administrator) {
            arAdmin = "J";
        } else {
            arAdmin = "N";
        }
        
        //Skapar databasfr�gor f�r att l�gga till en agent i r�tt tabell.
        try{
            //L�gger till alla agenter i tabellen agent med inparameter-datan.
            databas.insert("insert into agent (agent_id, anstallningsdatum, losenord, namn, telefon, omrade, administrator) values (" + nyttId + ", '" + anstallningsdatum + "', '" + losenord + "' , '" + namn + "' , '" + telefon + "' ," + omradesId + ", '" + arAdmin + "')");
            
            //Kontrollerar om inparametern faltagent �r true eller false. L�gger till agenten i tabellen faltagent om inparametern �r true.
            if(faltagent) {
                databas.insert("insert into faltagent (agent_id) values (" + nyttId + ")");
            } 
            
            //Kontrollerar om inparametern omradeschef �r true eller false. Tar bort eventuell omr�deschef fr�n tabellen omradeschef med det angivna omradesId't
            //och l�gger till den nya omr�deschefen
            if(omradeschef) {
                databas.delete("delete from omradeschef where omrade = " + omradesId);
                databas.insert("insert into omradeschef (agent_id, omrade) values (" + nyttId + "," + omradesId + ")");
            } 
            
            //Kontrollerar om inparametern kontorschef �r true eller false. Tar bort eventuell nuvarande kontorschef fr�n tabellen kontorschef med den angivna kontorsbeteckningen
            //och l�gger till den nya kontorschefen.
            if(kontorschef) {
                databas.delete("delete from kontorschef where kontorsbeteckning = '" + kontorsbeteckning + "'");
                databas.insert("insert into kontorschef (agent_id, kontorsbeteckning) values (" + nyttId + ", '" + kontorsbeteckning + "')");
            }
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r agent skulle l�ggas till. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    //Metod f�r att �ndra omr�deschef utifr�n nuvarande agents ID och den nya agentens namn.
    public static boolean andraOmradesChef(int valdAgent, String valdNyAgentNamn) {
        boolean success = false;
        
        int valdNyAgentId = Integer.parseInt(Agent.getIdByNamn(valdNyAgentNamn));
        
        try {
            databas.update("UPDATE omradeschef SET agent_id = '" + valdNyAgentId + "' WHERE agent_id = " + valdAgent);
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r omr�deschef skulle �ndras. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod f�r att g�ra en agent till omr�deschef utifr�n den valda agentens ID och det valda omr�dets namn
    public static boolean gorTillOmradesChef(int valdAgent, String omrade) {
        boolean success = false;
        int omradesId = Integer.parseInt(Omrade.getIdByBenamning(omrade));
        int nuvarandeOmradesChef = Omrade.getOmradesChefById(omradesId);
        String nyOmradesChefNamn = Agent.getNamnById(valdAgent);
        
        try {
            if(nuvarandeOmradesChef == 0){
                databas.insert("INSERT INTO omradeschef (agent_id, omrade) VALUES (" + valdAgent + ", " + omradesId + ")");
            } else {
                Agent.andraOmradesChef(nuvarandeOmradesChef, nyOmradesChefNamn);
            }
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r agent skulle g�ras till omr�deschef. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod f�r att ta bort en agent fr�n f�ltagent
    public static boolean taBortFaltAgent(int valdAgent) {
        boolean success = false;        
        try {
                databas.delete("DELETE FROM faltagent WHERE agent_id = " + valdAgent);
                success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r agent tas bort som f�ltagent. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    } 
    //Metod f�r att g�ra en agent till f�ltagent
    public static boolean gorTillFaltAgent(int valdAgent) {
        boolean success = false;
        
        try {
            databas.insert("INSERT INTO faltagent (agent_id) VALUES ("+ valdAgent +")");
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r agent skulle g�ras till f�ltagent. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod f�r att g�ra en agent till kontorschef �ver ett valt kontor mha kontorsbeteckningen
    public static boolean gorTillKontorsChef(int valdAgent, String beteckning) {
        boolean success = false;
        
        try {
            databas.insert("INSERT INTO kontorschef (agent_id, kontorsbeteckning) VALUES ("+ valdAgent +", '" + beteckning + "')");
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r agent skulle g�ras till kontorschef. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod f�r att ta bort en agent fr�n kontorschef utifr�n agentens Id
    public static boolean taBortKontorsChef(int valdAgent) {
        boolean success = false;        
        try {
                databas.delete("DELETE FROM kontorschef WHERE agent_id = " + valdAgent);
                success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r skulle tas bort som kontorschef. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod f�r att generera en ArrayList<String> �ver agenter som inte har n�got omr�desansvar
    public static ArrayList<String> listaAgenterUtanOmradesAnsvar() {
        ArrayList<String> resultat = null;
        
        try{
            resultat = databas.fetchColumn("SELECT agent.namn FROM agent LEFT JOIN omradeschef ON agent.agent_id = omradeschef.agent_id WHERE omradeschef.agent_id IS NULL");
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r agenter utan omr�desansvar skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    } 
    
    //Metod f�r att uppdatera en agent
    public static boolean uppdateraAgent(int valdAgent, String losenord, String namn, String telefon, String omradesNamn, boolean administrator) {
        boolean success = false;
        
        //Kontrollerar om inparametern omradesNamn har ett v�rde eller �r null. Om det har ett v�rde h�mtas omr�desId genom att anv�nda klassen Omrade's metod getIdByBenamning.
        String omradesId = "";
        if(omradesNamn != null) {
            omradesId = Omrade.getIdByBenamning(omradesNamn);
        } else {
            omradesId = null;
        }
        
        //Kontrollerar om inparametern administrator �r true eller false och skapar en str�ng som inneh�ller "J" eller "N" som sedan anv�nds vid inmatning i databasen.
        String arAdmin = "";
        if(administrator) {
            arAdmin = "J";
        } else {
            arAdmin = "N";
        }
        
        try{
            databas.update("UPDATE agent SET agent_id = " + valdAgent + ", losenord = '" + losenord + "', namn = '" + namn + "', telefon = '" + telefon + "', omrade = " + omradesId + ", administrator = '" + arAdmin + "' WHERE agent_id = " + valdAgent);
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r agent skulle l�ggas till. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod f�r att h�mta kontorsbeteckningen �ver det kontor som den valda agenten �r ansvarig f�r
    public static String getKontorsbeteckningById(int agentId) {
        String resultat = "";
            try {
                String query = "SELECT kontorsbeteckning FROM kontorschef WHERE agent_id = " + agentId;
                resultat = databas.fetchSingle(query);
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r f�ltagent skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
        
    }
    
    //Metod f�r att h�mta agentId tillh�rande den kontorschef som finns p� ett valt kontor utifr�n kontorsbeteckningen.
    public static String getKontorsChefIdByBenamning(String kontorsbeteckning) {
        String resultat = "0";
        
        try {
            resultat = databas.fetchSingle("SELECT agent_id FROM kontorschef WHERE kontorsbeteckning = '" + kontorsbeteckning + "'");
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r kontorschefens ID skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att generera en lista som visar alla existerande kontorsbeteckningar
    public static ArrayList<String> getAllaKontorsbeteckningar() {
    ArrayList<String> resultat = new ArrayList<>();
        try {
            String query = "SELECT kontorsbeteckning FROM kontorschef";
            resultat = databas.fetchColumn(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r kontorsbeteckningar skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod f�r att �ndra kontorschef �ver ett valt kontor till utifr�n kontorsbeteckning mha den nya kontorschefens namn
    public static boolean andraKontorsChef(String valtKontor, String valdNyAgentNamn) {
        boolean success = false;
        
        int valdNyAgentId = Integer.parseInt(Agent.getIdByNamn(valdNyAgentNamn));
        
        try {
            databas.update("UPDATE kontorschef SET agent_id = '" + valdNyAgentId + "' WHERE kontorsbeteckning = '" + valtKontor + "'");
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r kontorschef skulle �ndras. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod f�r att generera en lista �ver agenter som inte ansvarar f�r n�got kontor
    public static ArrayList<String> listaAgenterUtanKontorsAnsvar() {
        ArrayList<String> resultat = null;

        try{
            resultat = databas.fetchColumn("SELECT agent.namn FROM agent LEFT JOIN kontorschef ON agent.agent_id = kontorschef.agent_id WHERE kontorschef.agent_id IS NULL");
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r agenter utan omr�desansvar skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
        } 
    
    //Metod f�r att ta bort en agent fr�n agent+f�ltagent-tabellerna
    public static boolean taBort(int valdAgent) {
        boolean resultat = false;
        
        try {
            
            if(Agent.getIsFaltAgent(valdAgent)) {
                databas.delete("DELETE FROM innehar_fordon WHERE agent_id  = " + valdAgent);
                databas.delete("DELETE FROM innehar_utrustning WHERE agent_id  = " + valdAgent);
                databas.delete("DELETE FROM faltagent WHERE agent_id = " + valdAgent);
                databas.delete("DELETE FROM agent WHERE agent_id = " + valdAgent);
                resultat = true;
            } else {
                databas.delete("DELETE FROM innehar_fordon WHERE agent_id  = " + valdAgent);
                databas.delete("DELETE FROM innehar_utrustning WHERE agent_id  = " + valdAgent);
                databas.delete("DELETE FROM agent WHERE agent_id = " + valdAgent);
                resultat = true;
            }
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r agenten skulle tas bort. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    
    }
    
    public static boolean isAnsvarigAgent(int agentId) {
        boolean ansvarig = false;
            try {
                String query = "SELECT ansvarig_agent FROM alien WHERE ansvarig_agent = " + agentId;
                String resultat = databas.fetchSingle(query);
                if(resultat != null) {
                    ansvarig = true;
                }
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r ansvarig agent-status skulle h�mtas. F�rs�k igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return ansvarig;
        
    }
   
    public static int getForstaBastaAgentId() {
        int resultat = 0;
        try {
            resultat = Integer.parseInt(databas.fetchSingle("SELECT agent_id FROM agent"));
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "N�gonting gick fel n�r ansvarig agent-status skulle h�mtas. F�rs�k igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
}
