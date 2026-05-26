import java.io.*;

public class Ex1_StreamTokenizer_KB {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StreamTokenizer st = new StreamTokenizer(br);

            st.eolIsSignificant(true);
            System.out.println("Scrie datele: mesaj zi luna an");
            System.out.println("Pentru stop scrie STOP sau treci pe linie noua.");

            boolean gata = false;

            while(!gata) {
                int token = st.nextToken();

                if(token == StreamTokenizer.TT_EOF || token == StreamTokenizer.TT_EOL) {
                    gata = true;
                }
                else if(token == StreamTokenizer.TT_WORD) {
                    if(st.sval.equalsIgnoreCase("STOP")) {
                        gata = true;
                    }
                    else {
                        System.out.println("Cuvant: " + st.sval);
                    }
                }
                else if(token == StreamTokenizer.TT_NUMBER) {
                    System.out.println("Numar: " + (int)st.nval);
                }
                else {
                    System.out.println("Caracter: " + (char)token);
                }
            }
        }
        catch(IOException e) {
            System.out.println("Eroare la citire: " + e.getMessage());
        }
    }
}
