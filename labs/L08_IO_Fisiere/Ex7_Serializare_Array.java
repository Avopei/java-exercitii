import java.io.*;
import java.util.*;

class VectorInt implements Serializable {
    int n;
    int[] v;

    VectorInt(int n) {
        this.n = n;
        v = new int[n];
    }

    void sortare() {
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(v[i] > v[j]) {
                    int aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }
    }

    void afisare() {
        for(int i = 0; i < n; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }
}

public class Ex7_Serializare_Array {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("n = ");
            int n = sc.nextInt();
            VectorInt ob = new VectorInt(n);

            for(int i = 0; i < n; i++) {
                System.out.print("v[" + i + "] = ");
                ob.v[i] = sc.nextInt();
            }

            ob.sortare();

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("vector.dat"));
            out.writeObject(ob);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("vector.dat"));
            VectorInt citit = (VectorInt)in.readObject();
            in.close();

            System.out.println("Vector citit din fisier:");
            citit.afisare();
        }
        catch(Exception e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }
}
