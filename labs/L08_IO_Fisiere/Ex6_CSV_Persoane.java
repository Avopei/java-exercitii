import java.io.*;

public class Ex6_CSV_Persoane {
    static boolean esteFixSauInternational(String telefon) {
        if(telefon.startsWith("+40")) return false;
        if(telefon.startsWith("07")) return false;
        return true;
    }

    static boolean facebookNecustomizat(String link) {
        int i = link.length() - 1;
        int cnt = 0;
        while(i >= 0 && Character.isDigit(link.charAt(i))) {
            cnt++;
            i--;
        }
        return cnt >= 5;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("persoane.csv"));

            PrintWriter dec = new PrintWriter(new FileWriter("nascuti_decembrie.txt"));
            PrintWriter tel = new PrintWriter(new FileWriter("telefoane_speciale.txt"));
            PrintWriter nume = new PrintWriter(new FileWriter("andrei_nicolae.txt"));
            PrintWriter fb = new PrintWriter(new FileWriter("facebook_necustomizat.txt"));

            String linie;
            while((linie = br.readLine()) != null) {
                String[] p = linie.split("/");

                if(p.length == 5) {
                    String name = p[0];
                    String surname = p[1];
                    String phone = p[2];
                    String birth = p[3];
                    String facebook = p[4];

                    if(birth.contains("/12/") || birth.contains(".12.") || birth.contains("-12-")) {
                        dec.println(linie);
                    }

                    if(esteFixSauInternational(phone)) {
                        tel.println(linie);
                    }

                    if(name.equalsIgnoreCase("Andrei") || name.equalsIgnoreCase("Nicolae")) {
                        nume.println(linie);
                    }

                    if(facebookNecustomizat(facebook)) {
                        fb.println(linie);
                    }
                }
            }

            br.close();
            dec.close(); tel.close(); nume.close(); fb.close();
            System.out.println("Fisierele au fost create.");
        }
        catch(IOException e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }
}
