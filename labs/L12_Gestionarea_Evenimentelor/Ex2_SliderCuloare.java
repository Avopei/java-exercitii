import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame implements AdjustmentListener{
    Scrollbar red, green, blue;
    MyCanvas canvas;

    MyFrame(String titlu){
        super(titlu);
        setLayout(new FlowLayout());

        red = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 256);
        green = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 256);
        blue = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 256);

        red.setPreferredSize(new Dimension(200, 20));
        green.setPreferredSize(new Dimension(200, 20));
        blue.setPreferredSize(new Dimension(200, 20));

        canvas = new MyCanvas();

        add(new Label("R")); add(red);
        add(new Label("G")); add(green);
        add(new Label("B")); add(blue);
        add(canvas);

        red.addAdjustmentListener(this);
        green.addAdjustmentListener(this);
        blue.addAdjustmentListener(this);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        setSize(300, 300);
        setVisible(true);
    }

    public void adjustmentValueChanged(AdjustmentEvent e){
        canvas.r = red.getValue();
        canvas.g = green.getValue();
        canvas.b = blue.getValue();
        canvas.repaint();
    }
}

class MyCanvas extends Canvas{
    int r = 0, g = 0, b = 0;

    MyCanvas(){
        setSize(150, 150);
        setBackground(Color.white);
    }

    public void paint(Graphics gr){
        gr.setColor(new Color(r, g, b));
        gr.fillRect(25, 25, 100, 100);
    }
}

class Test{
    public static void main(String args[]){
        new MyFrame("Slider culoare");
    }
}
