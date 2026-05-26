// Fisier original: ex3/Exercitiul03.java

import java.util.Scanner;
import myPackage.*;

class Class2 extends Class1 implements Int1, Int2{

    public Class2(double x, double y){
        super(x, y);
    }

    public int sum(int a, int b){
        return a + b;
    }

    public double product(double a, double b){
        return a * b;
    }
}

public class Exercitiul03{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Primul numar intreg: ");
        int a = scanner.nextInt();
        System.out.print("Al doilea numar intreg: ");
        int b = scanner.nextInt();

        System.out.print("Primul numar real: ");
        double x = scanner.nextDouble();
        System.out.print("Al doilea numar real: ");
        double y = scanner.nextDouble();

        Class2 obiect = new Class2(x, y);

        System.out.println("Suma numerelor intregi este: " + obiect.sum(a, b));
        System.out.println("Produsul numerelor reale este: " + obiect.product(obiect.getX(), obiect.getY()));

        scanner.close();
    }
}
