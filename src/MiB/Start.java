package MiB;

//Importerar klasser som beh�vs i Startklassen
import MiB.CommonViews.Login;
import java.io.File;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Start {
    
    //Deklarerar ett nytt objekt av klassen InfDB
    private static InfDB databas;
    
    public static void main(String[] args) {
        try {
            
            //Skapar en str�ng av den nuvarande projekts�kv�gen. Anv�nder sig av biblioteket File, "skapar" en fil utan ett filnamn och h�mtar sen s�kv�gen till denna (vilket �r projekts�kv�gen).
            //f�r p� s� s�tt en "relative path" till projektet och kan d�refter anv�nda den f�r att lokalisera databasfilen oavsett vart p� h�rddisken den ligger oavsett vilket operativsystem projektet k�rs p�
            String projektSokVag = new File("").getAbsolutePath();
            //Instansierar ett databasobjekt med hj�lp av InfDB-klassen. Skickar in projekts�kv�gen och konkatenerar den str�ngen med "\db\MIBDB.FDB" f�r att alltid kunna hitta databasfilen oavsett var p� datorn projektet ligger.
            databas = new InfDB(projektSokVag + "\\db\\MIBDB.FDB");
            //�ppnar Loginf�nstret
            new Login().setVisible(true);
            
        } catch (InfException e) {
            
            //Visar ett felmeddelande om n�gonting har g�tt fel
            JOptionPane.showMessageDialog(null, "N�gonting gick fel. F�rs�k igen eller kontakta systemadministrat�ren.");
            //Skriver ut det det faktiska felmeddelandet.
            System.out.println("Felmeddelande:" + e.getMessage());
            
        }
    }
    
    //Metod som returnerar InfDB-objektet (databasen). Anv�nds f�r att kunna anv�nda databasen fr�n alla filer i projektet utan att beh�va deklarera och instansiera objektet i varje fil.
    public static InfDB getDatabas() {
        return databas;
    }
}
