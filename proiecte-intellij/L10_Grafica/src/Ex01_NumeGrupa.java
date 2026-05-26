import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyPanel1 extends Panel{
    String nume = "Numele tau";
    String grupa = "Grupa ta";

    public void paint(Graphics g){
        int width = getWidth();
        int height = getHeight();

        String text = nume + " - " + grupa;

        g.setColor(Color.blue);
        g.setFont(new Font("Arial", Font.BOLD, 24));

        FontMetrics fm = g.getFontMetrics();
        int x = (width - fm.stringWidth(text)) / 2;
        int y = (height - fm.getHeight()) / 2 + fm.getAscent();

        g.drawString(text, x, y);
    }
}

public class Ex01_NumeGrupa{
    public static void main(String args[]){
        Frame frame = new Frame("Exercitiul 1");
        frame.add(new MyPanel1());
        frame.setSize(500, 300);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}
