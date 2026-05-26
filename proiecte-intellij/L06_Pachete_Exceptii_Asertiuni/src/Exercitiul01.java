import java.util.Scanner;

public class Exercitiul01{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double valori[] = new double[5];

        System.out.println("Citire sir cu 5 valori double:");
        for(int i=0; i<valori.length; i++){
            System.out.print("valori[" + i + "] = ");
            valori[i] = scanner.nextDouble();
        }

        try{
            System.out.print("Introduceti indexul dorit din sir: ");
            int index = scanner.nextInt();
            System.out.println("Valoarea este: " + valori[index]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Eroare: indexul pentru sir nu este corect.");
        }

        double matriceFixa[][] = new double[2][3];
        System.out.println("\nCitire matrice fixa 2 x 3:");
        for(int i=0; i<2; i++){
            for(int j=0; j<3; j++){
                System.out.print("matriceFixa[" + i + "][" + j + "] = ");
                matriceFixa[i][j] = scanner.nextDouble();
            }
        }

        try{
            System.out.print("Linie pentru matrice fixa: ");
            int linie = scanner.nextInt();
            System.out.print("Coloana pentru matrice fixa: ");
            int coloana = scanner.nextInt();
            System.out.println("Valoarea este: " + matriceFixa[linie][coloana]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Eroare: pozitia din matricea fixa nu exista.");
        }

        double matriceVariabila[][] = new double[3][];
        matriceVariabila[0] = new double[2];
        matriceVariabila[1] = new double[4];
        matriceVariabila[2] = new double[3];

        System.out.println("\nCitire matrice cu linii de lungimi diferite:");
        for(int i=0; i<matriceVariabila.length; i++){
            for(int j=0; j<matriceVariabila[i].length; j++){
                System.out.print("matriceVariabila[" + i + "][" + j + "] = ");
                matriceVariabila[i][j] = scanner.nextDouble();
            }
        }

        try{
            System.out.print("Linie pentru matrice variabila: ");
            int linie = scanner.nextInt();
            System.out.print("Coloana pentru matrice variabila: ");
            int coloana = scanner.nextInt();
            System.out.println("Valoarea este: " + matriceVariabila[linie][coloana]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Eroare: pozitia din matricea variabila nu exista.");
        }

        scanner.close();
    }
}
