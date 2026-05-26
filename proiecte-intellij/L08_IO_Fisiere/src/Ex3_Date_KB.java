import java.io.*;
import java.text.DateFormatSymbols;

public class Ex3_Date_KB {
    static boolean anBisect(int an) {
        if(an % 400 == 0) return true;
        if(an % 100 == 0) return false;
        return an % 4 == 0;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] luni = new DateFormatSymbols().getMonths();

            while(true) {
                System.out.print("Data DD/MM/YYYY sau X: ");
                String linie = br.readLine();

                if(linie.equalsIgnoreCase("X")) {
                    break;
                }

                String[] p = linie.split("/");

                if(p.length == 3) {
                    int zi = Integer.parseInt(p[0]);
                    int luna = Integer.parseInt(p[1]);
                    int an = Integer.parseInt(p[2]);

                    System.out.println(zi + " " + luni[luna - 1] + " " + an);

                    if(anBisect(an)) {
                        System.out.println("Anul este bisect");
                    }
                    else {
                        System.out.println("Anul nu este bisect");
                    }
                }
                else {
                    System.out.println("Format gresit");
                }
            }
        }
        catch(Exception e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }
}
