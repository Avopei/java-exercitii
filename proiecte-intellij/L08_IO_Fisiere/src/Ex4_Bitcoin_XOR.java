import java.io.*;

public class Ex4_Bitcoin_XOR {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            FileInputStream fin = new FileInputStream("private_key.bin");
            byte[] privateKey = new byte[256];
            int n = fin.read(privateKey);
            fin.close();

            System.out.print("Public key: ");
            String publicKeyText = br.readLine();
            byte[] publicKey = publicKeyText.getBytes();

            byte[] rezultat = new byte[n];

            for(int i = 0; i < n; i++) {
                rezultat[i] = (byte)(privateKey[i] ^ publicKey[i % publicKey.length]);
            }

            FileOutputStream fout = new FileOutputStream("transaction_id.bin");
            fout.write(rezultat);
            fout.close();

            System.out.println("Transaction id scris in fisier.");
        }
        catch(IOException e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }
}
