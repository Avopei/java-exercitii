// Fisier original: ex7/imageProcessor/MyImage.java

package imageProcessor;

import java.util.Random;

public class MyImage{
    private Pixel pixels[][];
    private int m;
    private int n;

    public MyImage(int m, int n){
        this.m = m;
        this.n = n;
        pixels = new Pixel[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                pixels[i][j] = new Pixel();
            }
        }
    }

    public void generateRandomPixels(){
        Random random = new Random();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                pixels[i][j] = new Pixel(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            }
        }
    }

    public void setPixel(int i, int j, Pixel pixel){
        pixels[i][j] = pixel;
    }

    public Pixel getPixel(int i, int j){
        return pixels[i][j];
    }

    public long cancelPixels(int minR, int minG, int minB){
        long start = System.currentTimeMillis();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pixels[i][j].getR() < minR && pixels[i][j].getG() < minG && pixels[i][j].getB() < minB){
                    pixels[i][j].setR(0);
                    pixels[i][j].setG(0);
                    pixels[i][j].setB(0);
                }
            }
        }

        long stop = System.currentTimeMillis();
        return stop - start;
    }

    public long deleteR(){
        long start = System.currentTimeMillis();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                pixels[i][j].setR(0);
            }
        }

        long stop = System.currentTimeMillis();
        return stop - start;
    }

    public long deleteG(){
        long start = System.currentTimeMillis();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                pixels[i][j].setG(0);
            }
        }

        long stop = System.currentTimeMillis();
        return stop - start;
    }

    public long deleteB(){
        long start = System.currentTimeMillis();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                pixels[i][j].setB(0);
            }
        }

        long stop = System.currentTimeMillis();
        return stop - start;
    }

    public long grayScale(){
        long start = System.currentTimeMillis();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int gri = (int)(0.21 * pixels[i][j].getR() + 0.71 * pixels[i][j].getG() + 0.07 * pixels[i][j].getB());
                pixels[i][j].setR(gri);
                pixels[i][j].setG(gri);
                pixels[i][j].setB(gri);
            }
        }

        long stop = System.currentTimeMillis();
        return stop - start;
    }

    public void display(){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(pixels[i][j] + " ");
            }
            System.out.println();
        }
    }
}
