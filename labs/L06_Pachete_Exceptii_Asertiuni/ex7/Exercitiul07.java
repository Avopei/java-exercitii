// Fisier original: ex7/Exercitiul07.java

import imageProcessor.*;

public class Exercitiul07{
    public static void main(String[] args){
        MyImage img = new MyImage(3, 4);
        img.generateRandomPixels();

        System.out.println("Imagine initiala:");
        img.display();

        long timp1 = img.cancelPixels(100, 100, 100);
        System.out.println("\nDupa anularea pixelilor sub pragul 100,100,100:");
        img.display();
        System.out.println("Timp operatie: " + timp1 + " ms");

        long timp2 = img.deleteR();
        System.out.println("\nDupa stergerea componentei R:");
        img.display();
        System.out.println("Timp operatie: " + timp2 + " ms");

        long timp3 = img.deleteG();
        System.out.println("\nDupa stergerea componentei G:");
        img.display();
        System.out.println("Timp operatie: " + timp3 + " ms");

        long timp4 = img.deleteB();
        System.out.println("\nDupa stergerea componentei B:");
        img.display();
        System.out.println("Timp operatie: " + timp4 + " ms");

        img.generateRandomPixels();
        long timp5 = img.grayScale();
        System.out.println("\nImagine in tonuri de gri:");
        img.display();
        System.out.println("Timp operatie: " + timp5 + " ms");
    }
}
