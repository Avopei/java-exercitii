// Fisier original: ex4/Exercitiul04.java

class SuperException extends Exception{
    public SuperException(){
        super("A aparut SuperException");
        System.out.println("Constructor: SuperException");
    }
}

class SmallerException extends SuperException{
    public SmallerException(){
        super();
        System.out.println("Constructor: SmallerException");
    }
}

class TestExceptii{
    public void a() throws SmallerException{
        throw new SmallerException();
    }

    public void b() throws SuperException{
        throw new SuperException();
    }
}

public class Exercitiul04{
    public static void main(String[] args){
        TestExceptii test = new TestExceptii();

        try{
            test.a();
        }
        catch(SmallerException e){
            System.out.println("In metoda a() s-a prins SmallerException.");
            System.out.println(e.getMessage());
        }
        catch(SuperException e){
            System.out.println("In metoda a() s-a prins SuperException.");
            System.out.println(e.getMessage());
        }

        System.out.println();

        try{
            test.b();
        }
        catch(SmallerException e){
            System.out.println("In metoda b() s-a prins SmallerException.");
            System.out.println(e.getMessage());
        }
        catch(SuperException e){
            System.out.println("In metoda b() s-a prins SuperException.");
            System.out.println("Catch-ul pentru SmallerException nu poate prinde un SuperException.");
            System.out.println(e.getMessage());
        }
    }
}
