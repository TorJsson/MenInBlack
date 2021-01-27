package MiB;

//Importerar behövda paket
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.JOptionPane;

public class Agent {
    //Instansierar variabeln databas som ett objekt av klassen InfDB. Hämtar objektet genom Start-klassens getDatabas()-metod.
    private static InfDB databas = Start.getDatabas();

    //Returnerar true om namnet är ledigt, annars false.
    public static boolean getLedigtNamn(String namn) {
        boolean ledigt = false;
        try{
            String query = "SELECT namn FROM agent WHERE UPPER(namn) = '" + namn.toUpperCase() + "'";
            if(databas.fetchSingle(query) == null) {
                ledigt = true;
            }
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när kontroll om namnet är ledigt skulle göras. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return ledigt;
    }
    
    //Returnerar agentens ID som en integer. Tar en inparameter i form av en sträng (agentens namn)
    public static String getIdByNamn(String namn) {    
        String resultat = "0";
        try {
            resultat = databas.fetchSingle("SELECT agent_id FROM agent WHERE UPPER(namn) = '" + namn.toUpperCase() + "'");
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }        
        return resultat;
    }
    
    //Returnerar agentens namn som en sträng. Tar en inparameter i form av en integer (agentens id)
    public static String getNamnById(int id) {
        String resultat = "";
        try {
            String query = "SELECT namn FROM agent WHERE agent_id = '" + id + "'";
            resultat = databas.fetchSingle(query);
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "0";
        }
        return resultat;
    }
    
    //Returnerar agentens telefonnummer i form av en sträng. Tar en inparameter i form av en integer (agentens id)
    public static String getTelefonnummerById(int id) {
        String resultat = "Inget telefonnummer lagrat";
        
        try {
            String query = "SELECT telefon FROM agent WHERE agent_id = " + id;
            resultat = databas.fetchSingle(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage()); 
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "0";
        }
        return resultat;
    
    }
    
    //Returnerar agentens anställningsdatum i form av en sträng. Tar en inparameter i form av en integer (agentens id)
    public static String getAnstallningsdatumById(int id) {
        String resultat = "";
        
        try {
            String query = "SELECT anstallningsdatum FROM agent WHERE agent_id = '" + id + "'";
            resultat = databas.fetchSingle(query);
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "0";
        }
        return resultat;
    }
    
    //Returnerar true om agenten är administratör, annars false. Tar en inparameter i form av en integer (agentens id)
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
            JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Returnerar agentens lösenord som en sträng. Tar en inparameter i form av en integer (agentens id)
    public static String getLosenordById(int id) {
        String resultat = "";
        
        try {
            String query = "SELECT losenord FROM agent WHERE agent_id = '" + id + "'";
            resultat = databas.fetchSingle(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "0";
        }
        return resultat;
    }
    //Returnerar agentens område som en integer. Tar en inparameter i form av en integer (agentens id).
    public static String getOmradeById(int id) {
        String resultat = "";
        
        try {
            String query = "SELECT omrade FROM agent WHERE agent_id = '" + id + "'";
            resultat = databas.fetchSingle(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        if(resultat == null || resultat.isEmpty()) {
            resultat = "0";
        }
        return resultat;        
    }
    
    
    //Metod som returnerar true om en agent är fältagent. Tar en integer som inparameter (agentens id).
    public static boolean getIsFaltAgent(int agentId) {
        boolean resultat = false;
            try {
                String query = "SELECT agent_id FROM faltagent WHERE EXISTS (SELECT agent_id FROM faltagent WHERE agent_id = " + agentId + ")";
                resultat = databas.fetchSingle(query) != null;
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när fältagent skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
        
    }
    
    //Returnerar agentId för den agent som är ansvarig för ett område. Tar en integer som inparameter (områdesId)
    public static boolean getIsOmradesChef(int agentId) {
        boolean resultat = false;
        try {
            String query = "SELECT agent_id FROM omradeschef WHERE EXISTS (SELECT agent_id FROM omradeschef WHERE agent_id = " + agentId + ")";
            resultat = databas.fetchSingle(query) != null;
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när områdeschef skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;

    }
    
    //Returnerar true om agent är kontorschef. Tar en integer som inparameter (agentId)
    public static boolean getIsKontorsChef(int agentId) {
        boolean resultat = false;
            try {
                String query = "SELECT agent_id FROM kontorschef WHERE EXISTS (SELECT agent_id FROM kontorschef WHERE agent_id = " + agentId + ")";
                resultat = databas.fetchSingle(query) != null;
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när fältagent skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
        
    }
    
    //Returnerar en ArrayList av strängar med alla agenters namn.
    public static ArrayList<String> getAllaAgentNamn() {
        ArrayList<String> resultat = new ArrayList<>();
        try {
            String query = "SELECT namn FROM agent";
            resultat = databas.fetchColumn(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när agentnamn skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;  
    }    
   
    //Returnerar en HashMap med utvald agentdata samt områdesbenämningen för det område agenten tillhör. Tar en integer som inparameter (agentId)
    public static HashMap<String, String> getAgentDataById(int agentId) {
        HashMap<String, String> resultat = new HashMap<>();
        
        try {
            String query = "SELECT agent.namn, agent.telefon, agent.anstallningsdatum, agent.administrator, agent.losenord, omrade.benamning FROM agent JOIN omrade ON omrade.omrades_id = agent.omrade WHERE agent.agent_id = " + agentId;
            resultat = databas.fetchRow(query);
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när agentdata skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Returnerar true om lösenordet ändrats. Ändrar lösenordet för den angivna agenten. Tar två inparametrar: En integer (agentId) som representerar den agent man vill ändra lösenordet för, och en sträng som representerar det nya lösenordet.
    public static boolean setPassword(int agentId, String losenord) {
        boolean success = false;
        try {
            String query = "UPDATE agent SET losenord = '" + losenord + "' WHERE agent_id = " + agentId;
            databas.update(query);
            success = true;
        } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när lösenord skulle sparas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod som returnerar alla namn och IDn som matchar namnet som matas in som inparameter (sträng). Jämförelse sker på namn i versaler.
    public static ArrayList<HashMap<String,String>> getAllaNamnOchIdByNamn(String agentNamn) {
        ArrayList<HashMap<String,String>> resultat = null;
        try {
            resultat = databas.fetchRows("SELECT agent_id, namn FROM agent WHERE UPPER(namn) LIKE '" + agentNamn.toUpperCase() + "'");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när agenter med namnet " + agentNamn + " skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    //Metod som returnerar alla namn och IDn på agenter som anställts mellan datumen som angetts som inparametrar.
    public static ArrayList<HashMap<String,String>> getAllaNamnOchIdByDatum(String startDatum, String slutDatum) {
        ArrayList<HashMap<String,String>> resultat = null;
        try {
            resultat = databas.fetchRows("SELECT namn, agent_id FROM agent WHERE anstallningsdatum BETWEEN '" + startDatum + "' AND '" + slutDatum + "'");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när alla namn och IDn med anställningsdatum mellan " + startDatum + " och " + slutDatum + " skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod som returnerar alla namn och IDn på agenter som är av en viss typ (fältagent, områdeschef, kontorschef). 
    public static ArrayList<HashMap<String,String>> getAllaNamnOchIdByTyp(String typ) {
            ArrayList<HashMap<String,String>> resultat = null;
            
            //Omvandlar inparametern typ till rätt tabellnamn i databasen (utan åäö)
            String valdTyp = "";
            if(typ.equals("Fältagent")) {
                valdTyp = "Faltagent";
            } else if(typ.equals("Områdeschef")) {
                valdTyp = "Omradeschef";
            } else if(typ.equals("Kontorschef")) {
                valdTyp = "Kontorschef";
            }
            
            try {
                resultat = databas.fetchRows("SELECT namn, agent_id FROM agent WHERE agent_id IN (SELECT agent_id FROM " + valdTyp + ")");
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när alla namn och IDn av typen " + typ + " skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
    }
    
    //Metod som returnerar alla namn och IDn på agenter som är tilldelade ett angivet område (inparametern int omradeId)
    public static ArrayList<HashMap<String,String>> getAllaNamnOchIdByOmrade(int omradeId) {
        ArrayList<HashMap<String,String>> resultat = null;
        try {
            resultat = databas.fetchRows("SELECT namn, agent_id FROM agent WHERE omrade = " + omradeId);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när alla namn och IDn från ett område skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod som lägger till en ny agent. Hämtar ut det första lediga IDt i agent_id-tabellen genom metoden getAutoIncrement() och använder sig av den, 
    //dagens datum genom metoden LocalDate.now().format() samt datan som skickats med som inparametrar för att lägga till ny data i databasen.
    //Returnerar true om tilläggningen har gått att genomföra, annars false.
    public static boolean laggTill(String losenord, String namn, String telefon, String omradesNamn, boolean faltagent, boolean omradeschef, boolean kontorschef, String kontorsbeteckning, boolean administrator) {
        boolean success = false;
        
        //Hämtar det första lediga agent_id't genom att använda InfDB-metoden getAutoIncrement() och tilldelar variabeln nyttId resultatet av databasfrågan.
        int nyttId = 0;
        try {
            nyttId = Integer.parseInt(databas.getAutoIncrement("agent", "agent_id"));
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när agent-ID skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        
        //Genererar en sträng med dagens datum i formatet YYYY-MM-DD genom att använda klasserna DateTimeFormatter och dess metod ofPattern() samt klassen LocalDate + metoden now() och format().
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String anstallningsdatum = LocalDate.now().format(format);
        
        //Kontrollerar om inparametern omradesNamn har ett värde eller är null. Om det har ett värde hämtas områdesId genom att använda klassen Omrade's metod getIdByBenamning.
        String omradesId = "";
        if(omradesNamn != null) {
            omradesId = Omrade.getIdByBenamning(omradesNamn);
        } else {
            omradesId = null;
        }
        
        //Kontrollerar om inparametern administrator är true eller false och skapar en sträng som innehåller "J" eller "N" som sedan används vid inmatning i databasen.
        String arAdmin = "";
        if(administrator) {
            arAdmin = "J";
        } else {
            arAdmin = "N";
        }
        
        //Skapar databasfrågor för att lägga till en agent i rätt tabell.
        try{
            //Lägger till alla agenter i tabellen agent med inparameter-datan.
            databas.insert("insert into agent (agent_id, anstallningsdatum, losenord, namn, telefon, omrade, administrator) values (" + nyttId + ", '" + anstallningsdatum + "', '" + losenord + "' , '" + namn + "' , '" + telefon + "' ," + omradesId + ", '" + arAdmin + "')");
            
            //Kontrollerar om inparametern faltagent är true eller false. Lägger till agenten i tabellen faltagent om inparametern är true.
            if(faltagent) {
                databas.insert("insert into faltagent (agent_id) values (" + nyttId + ")");
            } 
            
            //Kontrollerar om inparametern omradeschef är true eller false. Tar bort eventuell områdeschef från tabellen omradeschef med det angivna omradesId't
            //och lägger till den nya områdeschefen
            if(omradeschef) {
                databas.delete("delete from omradeschef where omrade = " + omradesId);
                databas.insert("insert into omradeschef (agent_id, omrade) values (" + nyttId + "," + omradesId + ")");
            } 
            
            //Kontrollerar om inparametern kontorschef är true eller false. Tar bort eventuell nuvarande kontorschef från tabellen kontorschef med den angivna kontorsbeteckningen
            //och lägger till den nya kontorschefen.
            if(kontorschef) {
                databas.delete("delete from kontorschef where kontorsbeteckning = '" + kontorsbeteckning + "'");
                databas.insert("insert into kontorschef (agent_id, kontorsbeteckning) values (" + nyttId + ", '" + kontorsbeteckning + "')");
            }
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när agent skulle läggas till. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    //Metod för att ändra områdeschef utifrån nuvarande agents ID och den nya agentens namn.
    public static boolean andraOmradesChef(int valdAgent, String valdNyAgentNamn) {
        boolean success = false;
        
        int valdNyAgentId = Integer.parseInt(Agent.getIdByNamn(valdNyAgentNamn));
        
        try {
            databas.update("UPDATE omradeschef SET agent_id = '" + valdNyAgentId + "' WHERE agent_id = " + valdAgent);
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när områdeschef skulle ändras. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod för att göra en agent till områdeschef utifrån den valda agentens ID och det valda områdets namn
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
            JOptionPane.showMessageDialog(null, "Någonting gick fel när agent skulle göras till områdeschef. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod för att ta bort en agent från fältagent
    public static boolean taBortFaltAgent(int valdAgent) {
        boolean success = false;        
        try {
                databas.delete("DELETE FROM faltagent WHERE agent_id = " + valdAgent);
                success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när agent tas bort som fältagent. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    } 
    //Metod för att göra en agent till fältagent
    public static boolean gorTillFaltAgent(int valdAgent) {
        boolean success = false;
        
        try {
            databas.insert("INSERT INTO faltagent (agent_id) VALUES ("+ valdAgent +")");
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när agent skulle göras till fältagent. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod för att göra en agent till kontorschef över ett valt kontor mha kontorsbeteckningen
    public static boolean gorTillKontorsChef(int valdAgent, String beteckning) {
        boolean success = false;
        
        try {
            databas.insert("INSERT INTO kontorschef (agent_id, kontorsbeteckning) VALUES ("+ valdAgent +", '" + beteckning + "')");
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när agent skulle göras till kontorschef. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod för att ta bort en agent från kontorschef utifrån agentens Id
    public static boolean taBortKontorsChef(int valdAgent) {
        boolean success = false;        
        try {
                databas.delete("DELETE FROM kontorschef WHERE agent_id = " + valdAgent);
                success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när skulle tas bort som kontorschef. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod för att generera en ArrayList<String> över agenter som inte har något områdesansvar
    public static ArrayList<String> listaAgenterUtanOmradesAnsvar() {
        ArrayList<String> resultat = null;
        
        try{
            resultat = databas.fetchColumn("SELECT agent.namn FROM agent LEFT JOIN omradeschef ON agent.agent_id = omradeschef.agent_id WHERE omradeschef.agent_id IS NULL");
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när agenter utan områdesansvar skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    } 
    
    //Metod för att uppdatera en agent
    public static boolean uppdateraAgent(int valdAgent, String losenord, String namn, String telefon, String omradesNamn, boolean administrator) {
        boolean success = false;
        
        //Kontrollerar om inparametern omradesNamn har ett värde eller är null. Om det har ett värde hämtas områdesId genom att använda klassen Omrade's metod getIdByBenamning.
        String omradesId = "";
        if(omradesNamn != null) {
            omradesId = Omrade.getIdByBenamning(omradesNamn);
        } else {
            omradesId = null;
        }
        
        //Kontrollerar om inparametern administrator är true eller false och skapar en sträng som innehåller "J" eller "N" som sedan används vid inmatning i databasen.
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
            JOptionPane.showMessageDialog(null, "Någonting gick fel när agent skulle läggas till. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod för att hämta kontorsbeteckningen över det kontor som den valda agenten är ansvarig för
    public static String getKontorsbeteckningById(int agentId) {
        String resultat = "";
            try {
                String query = "SELECT kontorsbeteckning FROM kontorschef WHERE agent_id = " + agentId;
                resultat = databas.fetchSingle(query);
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när fältagent skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return resultat;
        
    }
    
    //Metod för att hämta agentId tillhörande den kontorschef som finns på ett valt kontor utifrån kontorsbeteckningen.
    public static String getKontorsChefIdByBenamning(String kontorsbeteckning) {
        String resultat = "0";
        
        try {
            resultat = databas.fetchSingle("SELECT agent_id FROM kontorschef WHERE kontorsbeteckning = '" + kontorsbeteckning + "'");
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när kontorschefens ID skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod för att generera en lista som visar alla existerande kontorsbeteckningar
    public static ArrayList<String> getAllaKontorsbeteckningar() {
    ArrayList<String> resultat = new ArrayList<>();
        try {
            String query = "SELECT kontorsbeteckning FROM kontorschef";
            resultat = databas.fetchColumn(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när kontorsbeteckningar skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
    
    //Metod för att ändra kontorschef över ett valt kontor till utifrån kontorsbeteckning mha den nya kontorschefens namn
    public static boolean andraKontorsChef(String valtKontor, String valdNyAgentNamn) {
        boolean success = false;
        
        int valdNyAgentId = Integer.parseInt(Agent.getIdByNamn(valdNyAgentNamn));
        
        try {
            databas.update("UPDATE kontorschef SET agent_id = '" + valdNyAgentId + "' WHERE kontorsbeteckning = '" + valtKontor + "'");
            success = true;
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när kontorschef skulle ändras. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return success;
    }
    
    //Metod för att generera en lista över agenter som inte ansvarar för något kontor
    public static ArrayList<String> listaAgenterUtanKontorsAnsvar() {
        ArrayList<String> resultat = null;

        try{
            resultat = databas.fetchColumn("SELECT agent.namn FROM agent LEFT JOIN kontorschef ON agent.agent_id = kontorschef.agent_id WHERE kontorschef.agent_id IS NULL");
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när agenter utan områdesansvar skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
        } 
    
    //Metod för att ta bort en agent från agent+fältagent-tabellerna
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
            JOptionPane.showMessageDialog(null, "Någonting gick fel när agenten skulle tas bort. Försök igen.");
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
                JOptionPane.showMessageDialog(null, "Någonting gick fel när ansvarig agent-status skulle hämtas. Försök igen.");
                System.out.println("Felmeddelande: " + e.getMessage());
            }
            return ansvarig;
        
    }
   
    public static int getForstaBastaAgentId() {
        int resultat = 0;
        try {
            resultat = Integer.parseInt(databas.fetchSingle("SELECT agent_id FROM agent"));
        } catch(InfException e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel när ansvarig agent-status skulle hämtas. Försök igen.");
            System.out.println("Felmeddelande: " + e.getMessage());
        }
        return resultat;
    }
}
