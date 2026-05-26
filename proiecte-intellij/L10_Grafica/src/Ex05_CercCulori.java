import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyCanvas5 extends Canvas{
    public void paint(Graphics g){
        int width = getWidth();
        int height = getHeight();

        int r = Math.min(width, height) / 2 - 30;
        int cx = width / 2;
        int cy = height / 2;

        for(int angle = 0; angle < 360; angle++){
            float hue = angle / 360.0f;
            g.setColor(Color.getHSBColor(hue, 1.0f, 1.0f));

            double rad = Math.toRadians(angle);
            int x = cx + (int)(r * Math.cos(rad));
            int y = cy + (int)(r * Math.sin(rad));

            g.drawLine(cx, cy, x, y);
        }

        g.setColor(Color.black);
        g.drawOval(cx - r, cy - r, 2 * r, 2 * r);
    }
}

public class Ex05_CercCulori{
    public static void main(String args[]){
        Frame frame = new Frame("Exercitiul 5");
        frame.add(new MyCanvas5());
        frame.setSize(500, 500);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}
