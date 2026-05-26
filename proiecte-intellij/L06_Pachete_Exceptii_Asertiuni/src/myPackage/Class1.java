package myPackage;

public class Class1{
    protected double x;
    protected double y;

    public Class1(){
        x = 0;
        y = 0;
    }

    public Class1(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
}
