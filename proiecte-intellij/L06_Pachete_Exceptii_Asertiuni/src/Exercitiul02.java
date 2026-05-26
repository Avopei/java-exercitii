import java.util.Scanner;

public class Exercitiul02{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Alegeti exceptia de testat:");
        System.out.println("1 - ArithmeticException");
        System.out.println("2 - ArrayIndexOutOfBoundsException");
        System.out.println("3 - NullPointerException");
        System.out.println("4 - NumberFormatException");
        System.out.println("5 - NegativeArraySizeException");
        System.out.print("Optiune: ");
        int optiune = scanner.nextInt();

        try{
            if(optiune == 1){
                int a = 10 / 0;
                System.out.println(a);
            }
            else if(optiune == 2){
                int valori[] = new int[3];
                System.out.println(valori[5]);
            }
            else if(optiune == 3){
                String text = null;
                System.out.println(text.length());
            }
            else if(optiune == 4){
                int numar = Integer.parseInt("abc");
                System.out.println(numar);
            }
            else if(optiune == 5){
                int valori[] = new int[-2];
                System.out.println(valori.length);
            }
            else{
                System.out.println("Nu ati ales o optiune valida.");
            }
        }
        catch(ArithmeticException e){
            System.out.println("ArithmeticException: " + e.getMessage());
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
        catch(NullPointerException e){
            System.out.println("NullPointerException: " + e.getMessage());
        }
        catch(NumberFormatException e){
            System.out.println("NumberFormatException: " + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Alta exceptie: " + e.getMessage());
        }
        finally{
            System.out.println("I may or may not have caught an exception");
        }

        scanner.close();
    }
}
