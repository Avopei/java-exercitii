// Fisier original: ex8/Exercitiul08.java

import java.util.Scanner;

class CountyException extends Exception{
    public CountyException(String mesaj){
        super(mesaj);
    }
}

class DigitGroupException extends Exception{
    public DigitGroupException(String mesaj){
        super(mesaj);
    }
}

class LastLettersException extends Exception{
    public LastLettersException(String mesaj){
        super(mesaj);
    }
}

class CharacterGroupException extends Exception{
    public CharacterGroupException(String mesaj){
        super(mesaj);
    }
}

public class Exercitiul08{

    static boolean esteLitera(char c){
        return c >= 'A' && c <= 'Z';
    }

    static boolean esteCifra(char c){
        return c >= '0' && c <= '9';
    }

    static void verificaNumar(String numar) throws CountyException, DigitGroupException, LastLettersException, CharacterGroupException{
        String text = numar.toUpperCase();
        text = text.replace(" ", "");
        text = text.replace("-", "");

        if(text.length() < 6 || text.length() > 8){
            throw new CharacterGroupException("Lungimea numarului nu este corecta.");
        }

        int pozitie = 0;
        String judet = "";
        String cifre = "";
        String litereFinal = "";

        while(pozitie < text.length() && esteLitera(text.charAt(pozitie))){
            judet = judet + text.charAt(pozitie);
            pozitie++;
        }

        while(pozitie < text.length() && esteCifra(text.charAt(pozitie))){
            cifre = cifre + text.charAt(pozitie);
            pozitie++;
        }

        while(pozitie < text.length() && esteLitera(text.charAt(pozitie))){
            litereFinal = litereFinal + text.charAt(pozitie);
            pozitie++;
        }

        if(pozitie != text.length()){
            throw new CharacterGroupException("Numarul contine caractere nepermise.");
        }

        if(judet.length() != 1 && judet.length() != 2){
            throw new CountyException("Grupul judetului trebuie sa aiba 1 sau 2 litere.");
        }

        if(judet.length() == 1 && !judet.equals("B")){
            throw new CountyException("Doar Bucuresti poate avea o singura litera in primul grup.");
        }

        if(cifre.length() != 2 && cifre.length() != 3){
            throw new DigitGroupException("Grupul de cifre trebuie sa aiba 2 sau 3 cifre.");
        }

        if(judet.length() == 2 && cifre.length() == 3){
            throw new DigitGroupException("Daca judetul are 2 litere, grupul de cifre nu poate avea 3 cifre.");
        }

        if(litereFinal.length() != 3){
            throw new LastLettersException("Ultimul grup trebuie sa aiba exact 3 litere.");
        }

        char prima = litereFinal.charAt(0);
        char ultima = litereFinal.charAt(2);
        if(prima == 'I' || prima == 'O' || ultima == 'I' || ultima == 'O'){
            throw new LastLettersException("Ultimul grup nu poate avea I sau O pe prima sau ultima pozitie.");
        }

        System.out.println("Numarul este corect: " + text);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti numarul de inmatriculare: ");
        String numar = scanner.nextLine();

        try{
            verificaNumar(numar);
        }
        catch(CountyException e){
            System.out.println("Eroare judet: " + e.getMessage());
        }
        catch(DigitGroupException e){
            System.out.println("Eroare cifre: " + e.getMessage());
        }
        catch(LastLettersException e){
            System.out.println("Eroare ultimul grup: " + e.getMessage());
        }
        catch(CharacterGroupException e){
            System.out.println("Eroare caractere: " + e.getMessage());
        }

        scanner.close();
    }
}
