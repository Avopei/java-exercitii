import java.io.*;

public class Ex8_Separare_Fisiere {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("date_lab.txt"));
            PrintWriter out = null;
            String linie;

            while((linie = br.readLine()) != null) {
                if(linie.startsWith("*/")) {
                    if(out != null) {
                        out.close();
                    }

                    String numeFisier = linie.substring(2);
                    out = new PrintWriter(new FileWriter(numeFisier));
                }
                else if(linie.equals(".")) {
                    if(out != null) {
                        out.close();
                        out = null;
                    }
                }
                else {
                    if(out != null) {
                        out.println(linie);
                    }
                }
            }

            if(out != null) out.close();
            br.close();

            System.out.println("Separarea a fost terminata.");
        }
        catch(IOException e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }
}
