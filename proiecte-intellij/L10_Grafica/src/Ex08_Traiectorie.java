import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyCanvas8 extends Canvas{
    int xs[] = new int[10000];
    int ys[] = new int[10000];
    int nr = 0;
    double vitezaFinalaY = 0;

    public void calculeazaTraiectoria(){
        int width = getWidth();
        int height = getHeight();
        int r = 8;

        double x = 40;
        double y = 40;
        double vx = 7.0;
        double vy = 0.0;
        double g = 0.25;

        nr = 0;

        while(y < height - r && nr < xs.length){
            xs[nr] = (int)x;
            ys[nr] = (int)y;
            nr++;

            x = x + vx;
            vy = vy + g;
            y = y + vy;

            if(x > width - r){
                x = width - r;
                vx = -vx;
            }
            if(x < r){
                x = r;
                vx = -vx;
            }
        }

        vitezaFinalaY = vy;
    }

    public void paint(Graphics g){
        calculeazaTraiectoria();

        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.blue);
        for(int i = 0; i < nr - 1; i++){
            g.drawLine(xs[i], ys[i], xs[i + 1], ys[i + 1]);
        }

        if(nr > 0){
            g.setColor(Color.red);
            g.fillOval(xs[nr - 1] - 8, ys[nr - 1] - 8, 16, 16);
        }

        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Viteza verticala finala: " + vitezaFinalaY, 20, getHeight() - 20);
    }
}

public class Ex08_Traiectorie{
    public static void main(String args[]){
        Frame frame = new Frame("Exercitiul 8");
        frame.add(new MyCanvas8());
        frame.setSize(700, 500);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}
