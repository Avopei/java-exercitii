import java.io.*;
import java.util.*;

public class Ex5_CSV_Students {
    public static void main(String[] args) {
        try {
            // nume fisiere simple pentru test
            String[] fisiere = {"Year_1_Group_1001.txt", "Year_1_Group_1002.txt"};
            Vector<InputStream> v = new Vector<InputStream>();

            for(int i = 0; i < fisiere.length; i++) {
                v.add(new FileInputStream(fisiere[i]));
            }

            SequenceInputStream sis = new SequenceInputStream(v.elements());
            BufferedReader br = new BufferedReader(new InputStreamReader(sis));

            ArrayList<String> studenti = new ArrayList<String>();
            String linie;

            while((linie = br.readLine()) != null) {
                if(linie.trim().length() > 0) {
                    studenti.add(linie);
                }
            }
            br.close();

            Collections.sort(studenti);

            PrintWriter pw = new PrintWriter(new FileWriter("studenti_ordonati.txt"));
            for(int i = 0; i < studenti.size(); i++) {
                pw.println(studenti.get(i));
            }
            pw.close();

            System.out.println("Fisierul final a fost creat.");
        }
        catch(IOException e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }
}
