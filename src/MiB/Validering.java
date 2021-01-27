package MiB;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Validering {
    
    //Returnerar true om ett textfält är ifyllt
    public static boolean txtFaltHarVarde(JTextField txtFalt) {
        boolean success = false;
        if(!txtFalt.getText().isEmpty()) {
            success = true;
        }
        return success;
    }
    
    //Returnerar true om ett lösenordsfält är ifyllt
    public static boolean pwdFaltHarVarde(JPasswordField pwdFalt) {
        boolean success = false;
        
        //Omvandlar char[]-arrayen från getPassword() till en sträng
        String pwd = new String(pwdFalt.getPassword());
        //Kontrollerar om strängen är tom
        if(!pwd.isEmpty()) {
            success = true;
        }  
        return success;
    }
    
    //Returnerar true om användaren är agent och false om användaren är alien (baserat på användarnamnet)
    public static boolean arAgent(String anvandarNamn) {
        boolean agent = false;
        //Omvandlar strängen som skickats in som inparameter till versaler och kontrollerar om den börjar med "AGENT ".
        if(anvandarNamn.toUpperCase().startsWith("AGENT ")) {
            agent = true;
        }
        return agent;
    }
    
    //Returnerar FALSE om lösenorden inte stämmer, TRUE om dom stämmer. Inparameter är användarens ID, det angivna lösenordet och en boolean som representerar om användaren är agent eller alien.
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
    
    //Metod för att kontrollera att en sträng är i rätt format för datum (YYYY-MM-DD)
    public static boolean valideraDatum(String datum) {
        boolean success = false;

        //Använder metoden matches() tillsammans med en regular expression för att kontrollera formatet
        if(datum.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")){
            success = true;
        }
        return success;
    }
    
    //Metod för att kontrollera längden på en sträng. Inparametrar Sträng s, minimilängd min och maxlängd max. Returnerar true/false beroende på om strängen uppfyller villkoren eller ej.
    public static boolean valideraLangd(String s, int min, int max) {
        boolean success = false;

        if(s.length() >= min && s.length() <= max) {
                success = true;
        }
        return success;
    }
    
    //Metod för att kontrollera att en sträng enbart innehåller siffror. Inparameter Sträng s.
    public static boolean enbartSiffror(String s) {
        boolean success = false;
        
        //Använder metoden matches() med en regular expression som kontrollerar att hela strängen består av enbart siffror
        if(s.matches("^[0-9]*$")) {
            success = true;
        }
        return success;
    }
    
    //Metod för att kontrollera att en sträng är i formatet "123-1231234....."
    public static boolean valideraTelefonnummer(String s) {
        boolean success = false;
        
        //Använder metoden matches() med en regular expression som kontrollerar att strängen börjar med 3 siffror (0-9), därefter ett bindestreck (-) och efter det valfri mängd siffror.
        if(s.matches("^[0-9]{3}-\\d*$")) {
            success = true;
        }
        return success;
    }
    
}