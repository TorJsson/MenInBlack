package MiB;

//Importerar klasser som behövs i Startklassen
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
            
            //Skapar en sträng av den nuvarande projektsökvägen. Använder sig av biblioteket File, "skapar" en fil utan ett filnamn och hämtar sen sökvägen till denna (vilket är projektsökvägen).
            //får på så sätt en "relative path" till projektet och kan därefter använda den för att lokalisera databasfilen oavsett vart på hårddisken den ligger oavsett vilket operativsystem projektet körs på
            String projektSokVag = new File("").getAbsolutePath();
            //Instansierar ett databasobjekt med hjälp av InfDB-klassen. Skickar in projektsökvägen och konkatenerar den strängen med "\db\MIBDB.FDB" för att alltid kunna hitta databasfilen oavsett var på datorn projektet ligger.
            databas = new InfDB(projektSokVag + "\\db\\MIBDB.FDB");
            //Öppnar Loginfönstret
            new Login().setVisible(true);
            
        } catch (InfException e) {
            
            //Visar ett felmeddelande om någonting har gått fel
            JOptionPane.showMessageDialog(null, "Någonting gick fel. Försök igen eller kontakta systemadministratören.");
            //Skriver ut det det faktiska felmeddelandet.
            System.out.println("Felmeddelande:" + e.getMessage());
            
        }
    }
    
    //Metod som returnerar InfDB-objektet (databasen). Används för att kunna använda databasen från alla filer i projektet utan att behöva deklarera och instansiera objektet i varje fil.
    public static InfDB getDatabas() {
        return databas;
    }
}
