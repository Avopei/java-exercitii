import java.io.*;
import java.util.*;

public class Ex9_Convolutie {
    static void afisare(int[][] a, int n, int m) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] aplicaFiltru(int[][] img, int n, int m, int[][] f) {
        int[][] rez = new int[n][m];

        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < m - 1; j++) {
                int s = 0;

                for(int x = -1; x <= 1; x++) {
                    for(int y = -1; y <= 1; y++) {
                        s += img[i + x][j + y] * f[x + 1][y + 1];
                    }
                }

                if(s < 0) s = 0;
                if(s > 255) s = 255;
                rez[i][j] = s;
            }
        }

        return rez;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("imagine.txt"));

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] img = new int[n][m];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    img[i][j] = sc.nextInt();
                }
            }

            System.out.println("Imagine initiala:");
            afisare(img, n, m);

            int nrFiltre = sc.nextInt();

            for(int k = 0; k < nrFiltre; k++) {
                int[][] f = new int[3][3];

                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        f[i][j] = sc.nextInt();
                    }
                }

                int[][] rez = aplicaFiltru(img, n, m, f);
                System.out.println("Rezultat filtru " + (k + 1) + ":");
                afisare(rez, n, m);
            }

            sc.close();
        }
        catch(Exception e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }
}

/* exemplu imagine.txt:
5 5
10 10 10 10 10
10 50 50 50 10
10 50 100 50 10
10 50 50 50 10
10 10 10 10 10
1
0 -1 0
-1 5 -1
0 -1 0
*/
