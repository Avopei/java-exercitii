// Fisier original: ex7/imageProcessor/Pixel.java

package imageProcessor;

public class Pixel{
    private int r;
    private int g;
    private int b;

    public Pixel(){
        r = 0;
        g = 0;
        b = 0;
    }

    public Pixel(int r, int g, int b){
        setR(r);
        setG(g);
        setB(b);
    }

    private int corecteaza(int valoare){
        if(valoare < 0){
            return 0;
        }
        if(valoare > 255){
            return 255;
        }
        return valoare;
    }

    public void setR(int r){
        this.r = corecteaza(r);
    }

    public void setG(int g){
        this.g = corecteaza(g);
    }

    public void setB(int b){
        this.b = corecteaza(b);
    }

    public int getR(){
        return r;
    }

    public int getG(){
        return g;
    }

    public int getB(){
        return b;
    }

    public String toString(){
        return "(" + r + "," + g + "," + b + ")";
    }
}
