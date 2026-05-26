// Fisier original: ex9/Exercitiul09.java

import java.util.Scanner;

class PointTooClose extends Exception{
    public PointTooClose(){
        super("Punctul este prea aproape de punctul fix.");
    }
}

class Position{
    private String pointName;
    private int x;
    private int y;
    private int z;

    public Position(){
        pointName = "";
        x = 0;
        y = 0;
        z = 0;
    }

    public Position(String pointName, int x, int y, int z){
        this.pointName = pointName;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setPointName(String pointName){
        this.pointName = pointName;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setZ(int z){
        this.z = z;
    }

    public String getPointName(){
        return pointName;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getZ(){
        return z;
    }

    public String toString(){
        return pointName + "(" + x + ", " + y + ", " + z + ")";
    }
}

public class Exercitiul09{

    static void verifica(Position p, Position fix) throws PointTooClose{
        int dx = p.getX() - fix.getX();
        int dy = p.getY() - fix.getY();
        int dz = p.getZ() - fix.getZ();
        double distanta = Math.sqrt(dx * dx + dy * dy + dz * dz);

        if(distanta < 5){
            throw new PointTooClose();
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Position pozitii[] = new Position[3];
        Position punctFix = new Position("FIX", 0, 0, 0);
        int n;

        System.out.print("Cate puncte doriti sa introduceti? ");
        n = scanner.nextInt();

        try{
            if(n < 0 || n > 3){
                throw new ArrayIndexOutOfBoundsException("numar de puncte incorect");
            }

            for(int i=0; i<n; i++){
                scanner.nextLine();
                System.out.print("Numele punctului: ");
                String nume = scanner.nextLine();
                System.out.print("X = ");
                int x = scanner.nextInt();
                System.out.print("Y = ");
                int y = scanner.nextInt();
                System.out.print("Z = ");
                int z = scanner.nextInt();

                pozitii[i] = new Position(nume, x, y, z);
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Ati cerut prea multe puncte. Se pastreaza maxim 3 puncte.");
            n = 3;
        }

        for(int i=0; i<n; i++){
            if(pozitii[i] == null){
                scanner.nextLine();
                System.out.println("Introducere date pentru punctul lipsa " + (i + 1));
                System.out.print("Numele punctului: ");
                String nume = scanner.nextLine();
                System.out.print("X = ");
                int x = scanner.nextInt();
                System.out.print("Y = ");
                int y = scanner.nextInt();
                System.out.print("Z = ");
                int z = scanner.nextInt();
                pozitii[i] = new Position(nume, x, y, z);
            }

            boolean corect = false;
            while(!corect){
                try{
                    verifica(pozitii[i], punctFix);
                    corect = true;
                }
                catch(PointTooClose e){
                    System.out.println(e.getMessage());
                    System.out.println("Reintroduceti coordonatele pentru " + pozitii[i].getPointName());
                    System.out.print("X = ");
                    pozitii[i].setX(scanner.nextInt());
                    System.out.print("Y = ");
                    pozitii[i].setY(scanner.nextInt());
                    System.out.print("Z = ");
                    pozitii[i].setZ(scanner.nextInt());
                }
            }
        }

        System.out.println("\nPuncte acceptate:");
        for(int i=0; i<n; i++){
            System.out.println(pozitii[i]);
        }

        scanner.close();
    }
}
