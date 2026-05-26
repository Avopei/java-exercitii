import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

class MyCanvas7 extends Canvas{
    Random random = new Random();

    public void paint(Graphics g){
        int width = getWidth();
        int height = getHeight();

        int y = 20;

        while(y < height - 20){
            int maxR = 0;
            int r = 10 + random.nextInt(25);
            int x = r;

            while(x + r < width){
                g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                g.fillOval(x - r, y, 2 * r, 2 * r);
                g.setColor(Color.black);
                g.drawOval(x - r, y, 2 * r, 2 * r);

                if(r > maxR){
                    maxR = r;
                }

                int oldR = r;
                r = 10 + random.nextInt(25);
                x = x + oldR + r;
            }

            if(maxR == 0){
                maxR = 20;
            }
            y = y + 2 * maxR;
        }
    }
}

public class Ex07_CercuriTangente{
    public static void main(String args[]){
        Frame frame = new Frame("Exercitiul 7");
        frame.add(new MyCanvas7());
        frame.setSize(700, 500);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}
