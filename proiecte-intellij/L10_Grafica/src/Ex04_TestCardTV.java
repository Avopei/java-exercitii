import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyCanvas4 extends Canvas{
    public void paint(Graphics g){
        int width = getWidth();
        int height = getHeight();

        int h1 = height / 2;
        int h2 = height - h1;

        int grayWidth = width / 10;
        for(int i = 0; i < 10; i++){
            int value = i * 255 / 9;
            g.setColor(new Color(value, value, value));
            g.fillRect(i * grayWidth, 0, grayWidth + 1, h1);
        }

        Color colors[] = new Color[6];
        colors[0] = Color.red;
        colors[1] = Color.green;
        colors[2] = Color.blue;
        colors[3] = Color.yellow;
        colors[4] = Color.cyan;
        colors[5] = Color.magenta;

        int colorWidth = width / 6;
        for(int i = 0; i < 6; i++){
            g.setColor(colors[i]);
            g.fillRect(i * colorWidth, h1, colorWidth + 1, h2);
        }
    }
}

public class Ex04_TestCardTV{
    public static void main(String args[]){
        Frame frame = new Frame("Exercitiul 4");
        frame.add(new MyCanvas4());
        frame.setSize(600, 400);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}
