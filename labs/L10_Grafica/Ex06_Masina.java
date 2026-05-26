import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyCanvas6 extends Canvas{
    public void paint(Graphics g){
        int w = getWidth();
        int h = getHeight();

        int baseY = h / 2 + 70;

        g.setColor(new Color(30, 144, 255));
        g.fillRect(120, baseY - 80, 300, 80);

        int xs[] = {170, 230, 330, 380};
        int ys[] = {baseY - 80, baseY - 150, baseY - 150, baseY - 80};
        g.setColor(new Color(70, 130, 180));
        g.fillPolygon(xs, ys, 4);

        g.setColor(new Color(180, 220, 255));
        g.fillRect(220, baseY - 135, 60, 50);
        g.fillRect(290, baseY - 135, 60, 50);

        g.setColor(Color.black);
        g.drawLine(285, baseY - 150, 285, baseY - 80);
        g.drawRect(250, baseY - 75, 80, 75);
        g.drawLine(330, baseY - 75, 330, baseY);

        g.setColor(Color.black);
        g.fillOval(160, baseY - 30, 70, 70);
        g.fillOval(320, baseY - 30, 70, 70);

        g.setColor(Color.gray);
        g.fillOval(180, baseY - 10, 30, 30);
        g.fillOval(340, baseY - 10, 30, 30);

        g.setColor(Color.yellow);
        g.fillRect(405, baseY - 55, 20, 20);

        g.setColor(Color.red);
        g.fillRect(115, baseY - 55, 15, 20);

        g.setColor(Color.darkGray);
        g.drawLine(0, baseY + 40, w, baseY + 40);
    }
}

public class Ex06_Masina{
    public static void main(String args[]){
        Frame frame = new Frame("Exercitiul 6");
        frame.add(new MyCanvas6());
        frame.setSize(600, 400);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}
