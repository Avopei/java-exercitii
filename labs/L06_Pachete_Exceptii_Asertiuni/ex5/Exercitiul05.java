// Fisier original: ex5/Exercitiul05.java

import java.util.Random;

class AcuteTriangle extends Exception{
    public AcuteTriangle(){
        super("Triunghiul este ascutitunghic.");
    }
}

class RightTriangle extends Exception{
    public RightTriangle(){
        super("Triunghiul este dreptunghic.");
    }
}

class ImpossibleTriangle extends Exception{
    public ImpossibleTriangle(){
        super("Punctele nu pot forma un triunghi.");
    }
}

class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Exercitiul05{

    static double distantaPatrat(Point p1, Point p2){
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        return dx * dx + dy * dy;
    }

    static int arieDubla(Point p1, Point p2, Point p3){
        return p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y);
    }

    static void verificaTriunghi(Point p1, Point p2, Point p3) throws AcuteTriangle, RightTriangle, ImpossibleTriangle{
        double a2 = distantaPatrat(p1, p2);
        double b2 = distantaPatrat(p1, p3);
        double c2 = distantaPatrat(p2, p3);

        if(a2 == 0 || b2 == 0 || c2 == 0 || arieDubla(p1, p2, p3) == 0){
            throw new ImpossibleTriangle();
        }

        double max = a2;
        double s1 = b2;
        double s2 = c2;

        if(b2 > max){
            max = b2;
            s1 = a2;
            s2 = c2;
        }

        if(c2 > max){
            max = c2;
            s1 = a2;
            s2 = b2;
        }

        if(max > s1 + s2){
            System.out.println("Triunghiul este obtuzunghic.");
        }
        else if(max == s1 + s2){
            throw new RightTriangle();
        }
        else{
            throw new AcuteTriangle();
        }
    }

    public static void main(String[] args){
        Random random = new Random();

        Point p1 = new Point(random.nextInt(10), random.nextInt(10));
        Point p2 = new Point(random.nextInt(10), random.nextInt(10));
        Point p3 = new Point(random.nextInt(10), random.nextInt(10));

        System.out.println("P1 = (" + p1.x + ", " + p1.y + ")");
        System.out.println("P2 = (" + p2.x + ", " + p2.y + ")");
        System.out.println("P3 = (" + p3.x + ", " + p3.y + ")");

        try{
            verificaTriunghi(p1, p2, p3);
        }
        catch(AcuteTriangle e){
            System.out.println(e.getMessage());
        }
        catch(RightTriangle e){
            System.out.println(e.getMessage());
        }
        catch(ImpossibleTriangle e){
            System.out.println("Atentie: " + e.getMessage());
            throw new RuntimeException("Program oprit deoarece triunghiul este imposibil.");
        }
    }
}
