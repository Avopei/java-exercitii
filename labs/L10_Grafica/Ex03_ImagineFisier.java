import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class MyCanvas3 extends Canvas{
    BufferedImage image;
    String fileName = "image_01.jpg";

    MyCanvas3(){
        setSize(new Dimension(500, 380));
        setBackground(Color.white);

        try{
            image = ImageIO.read(new File(fileName));
        }
        catch(IOException e){
            System.out.println("Imaginea nu a fost gasita: " + fileName);
        }
    }

    public void paint(Graphics g){
        int yText = 40;

        if(image != null){
            int x = (getWidth() - image.getWidth()) / 2;
            int y = 30;
            g.drawImage(image, x, y, this);
            yText = y + image.getHeight() + 35;
        }

        int red = 50;
        int green = 120;
        int blue = 220;

        g.setColor(new Color(red, green, blue));
        g.setFont(new Font("Arial", Font.BOLD, 20));

        FontMetrics fm = g.getFontMetrics();
        int xText = (getWidth() - fm.stringWidth(fileName)) / 2;
        g.drawString(fileName, xText, yText);
    }
}

public class Ex03_ImagineFisier{
    public static void main(String args[]){
        Frame frame = new Frame("Exercitiul 3");
        frame.setLayout(new FlowLayout());
        frame.add(new MyCanvas3());
        frame.setSize(600, 450);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}
