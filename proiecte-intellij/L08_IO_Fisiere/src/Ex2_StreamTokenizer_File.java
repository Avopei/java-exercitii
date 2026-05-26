import java.io.*;

public class Ex2_StreamTokenizer_File {
    public static void main(String[] args) {
        try {
            Reader r = new BufferedReader(new FileReader("date_ex2.txt"));
            StreamTokenizer st = new StreamTokenizer(r);

            st.eolIsSignificant(true);
            boolean gata = false;

            while(!gata) {
                int token = st.nextToken();

                if(token == StreamTokenizer.TT_EOF) {
                    gata = true;
                }
                else if(token == StreamTokenizer.TT_EOL) {
                    System.out.println("Sfarsit de linie");
                }
                else if(token == StreamTokenizer.TT_WORD) {
                    System.out.println("Cuvant: " + st.sval);
                }
                else if(token == StreamTokenizer.TT_NUMBER) {
                    System.out.println("Numar: " + (int)st.nval);
                }
                else {
                    System.out.println("Caracter: " + (char)token);
                }
            }

            r.close();
        }
        catch(IOException e) {
            System.out.println("Eroare la fisier: " + e.getMessage());
        }
    }
}

/* fisier date_ex2.txt:
Salut 12 martie 2024
STOP
*/
