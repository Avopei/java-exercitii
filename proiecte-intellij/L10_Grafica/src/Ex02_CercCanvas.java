import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyCanvas2 extends Canvas{
    MyCanvas2(){
        setSize(new Dimension(400, 250));
        setBackground(Color.white);
    }

    public void paint(Graphics g){
        int width = getWidth();
        int height = getHeight();

        int d = Math.min(width, height);
        int x = (width - d) / 2;
        int y = (height - d) / 2;

        g.setColor(Color.red);
        g.drawOval(x, y, d, d);
    }
}

public class Ex02_CercCanvas{
    public static void main(String args[]){
        Frame frame = new Frame("Exercitiul 2");
        frame.setLayout(new FlowLayout());
        frame.add(new MyCanvas2());
        frame.setSize(500, 350);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}
