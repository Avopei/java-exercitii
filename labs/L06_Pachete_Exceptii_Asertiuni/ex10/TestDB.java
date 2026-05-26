// Fisier original: ex10/TestDB.java

import java.util.Scanner;
import dbInteraction.*;

public class TestDB{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        UserManager manager = new UserManager();
        int optiune = 0;

        while(optiune != 5){
            System.out.println("\n1 - creare utilizator");
            System.out.println("2 - stergere utilizator");
            System.out.println("3 - login");
            System.out.println("4 - afisare utilizatori");
            System.out.println("5 - iesire");
            System.out.print("Optiune: ");
            optiune = Integer.parseInt(scanner.nextLine());

            if(optiune == 1){
                System.out.print("Nume: ");
                String name = scanner.nextLine();
                System.out.print("Prenume: ");
                String surname = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("UserID: ");
                String userID = scanner.nextLine();
                System.out.print("Parola: ");
                String password = scanner.nextLine();

                Person p = new Person(name, surname, email, userID, password);
                if(manager.createUser(p)){
                    System.out.println("Utilizator creat.");
                }
                else{
                    System.out.println("Utilizatorul nu a fost creat.");
                }
            }
            else if(optiune == 2){
                System.out.print("UserID de sters: ");
                String userID = scanner.nextLine();
                Person p = new Person();
                p.setUserID(userID);

                if(manager.deleteUser(p)){
                    System.out.println("Utilizator sters.");
                }
                else{
                    System.out.println("Utilizatorul nu exista.");
                }
            }
            else if(optiune == 3){
                System.out.print("UserID: ");
                String userID = scanner.nextLine();
                System.out.print("Parola: ");
                String password = scanner.nextLine();

                if(manager.login(userID, password)){
                    System.out.println("Login reusit.");
                }
                else{
                    System.out.println("Login esuat.");
                }
            }
            else if(optiune == 4){
                manager.displayUsers();
            }
            else if(optiune == 5){
                System.out.println("Program terminat.");
            }
            else{
                System.out.println("Optiune incorecta.");
            }
        }

        scanner.close();
    }
}
