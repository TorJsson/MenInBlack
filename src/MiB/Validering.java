package MiB;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Validering {
    
    //Returnerar true om ett textf�lt �r ifyllt
    public static boolean txtFaltHarVarde(JTextField txtFalt) {
        boolean success = false;
        if(!txtFalt.getText().isEmpty()) {
            success = true;
        }
        return success;
    }
    
    //Returnerar true om ett l�senordsf�lt �r ifyllt
    public static boolean pwdFaltHarVarde(JPasswordField pwdFalt) {
        boolean success = false;
        
        //Omvandlar char[]-arrayen fr�n getPassword() till en str�ng
        String pwd = new String(pwdFalt.getPassword());
        //Kontrollerar om str�ngen �r tom
        if(!pwd.isEmpty()) {
            success = true;
        }  
        return success;
    }
    
    //Returnerar true om anv�ndaren �r agent och false om anv�ndaren �r alien (baserat p� anv�ndarnamnet)
    public static boolean arAgent(String anvandarNamn) {
        boolean agent = false;
        //Omvandlar str�ngen som skickats in som inparameter till versaler och kontrollerar om den b�rjar med "AGENT ".
        if(anvandarNamn.toUpperCase().startsWith("AGENT ")) {
            agent = true;
        }
        return agent;
    }
    
    //Returnerar FALSE om l�senorden inte st�mmer, TRUE om dom st�mmer. Inparameter �r anv�ndarens ID, det angivna l�senordet och en boolean som representerar om anv�ndaren �r agent eller alien.
    public static boolean valideraLosenord(int id, String losenord, boolean isAgent) {
        boolean success = false;
        if(isAgent) {
            if(Agent.getLosenordById(id).equals(losenord)) {
                success = true;
            }
        } else if(!isAgent) {
            if(Alien.getLosenordById(id).equals(losenord)) {
                success = true;
            }
        }
            return success;
    }
    
    //Metod f�r att kontrollera att en str�ng �r i r�tt format f�r datum (YYYY-MM-DD)
    public static boolean valideraDatum(String datum) {
        boolean success = false;

        //Anv�nder metoden matches() tillsammans med en regular expression f�r att kontrollera formatet
        if(datum.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")){
            success = true;
        }
        return success;
    }
    
    //Metod f�r att kontrollera l�ngden p� en str�ng. Inparametrar Str�ng s, minimil�ngd min och maxl�ngd max. Returnerar true/false beroende p� om str�ngen uppfyller villkoren eller ej.
    public static boolean valideraLangd(String s, int min, int max) {
        boolean success = false;

        if(s.length() >= min && s.length() <= max) {
                success = true;
        }
        return success;
    }
    
    //Metod f�r att kontrollera att en str�ng enbart inneh�ller siffror. Inparameter Str�ng s.
    public static boolean enbartSiffror(String s) {
        boolean success = false;
        
        //Anv�nder metoden matches() med en regular expression som kontrollerar att hela str�ngen best�r av enbart siffror
        if(s.matches("^[0-9]*$")) {
            success = true;
        }
        return success;
    }
    
    //Metod f�r att kontrollera att en str�ng �r i formatet "123-1231234....."
    public static boolean valideraTelefonnummer(String s) {
        boolean success = false;
        
        //Anv�nder metoden matches() med en regular expression som kontrollerar att str�ngen b�rjar med 3 siffror (0-9), d�refter ett bindestreck (-) och efter det valfri m�ngd siffror.
        if(s.matches("^[0-9]{3}-\\d*$")) {
            success = true;
        }
        return success;
    }
    
}