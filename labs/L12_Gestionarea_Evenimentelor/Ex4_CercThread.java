import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame implements ActionListener{
    Button startStop;
    MyCanvas canvas;
    Thread fir;
    boolean merge = false;

    MyFrame(String titlu){
        super(titlu);
        setLayout(new FlowLayout());

        startStop = new Button("Start");
        canvas = new MyCanvas();

        add(startStop);
        add(canvas);
        startStop.addActionListener(this);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        setSize(350, 350);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(!merge){
            merge = true;
            startStop.setLabel("Stop");
            fir = new Thread(new Runnable(){
                public void run(){
                    while(merge){
                        canvas.misca();
                        try{ Thread.sleep(30); }
                        catch(Exception ex){}
                    }
                }
            });
            fir.start();
        }
        else{
            merge = false;
            startStop.setLabel("Start");
        }
    }
}

class MyCanvas extends Canvas{
    int x = 0, y = 0;
    int dx = 3, dy = 3;
    int r = 30;

    MyCanvas(){
        setSize(250, 250);
        setBackground(Color.white);
    }

    void misca(){
        x += dx;
        y += dy;

        if(x < 0 || x + r > getWidth()) dx = -dx;
        if(y < 0 || y + r > getHeight()) dy = -dy;

        repaint();
    }

    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.fillOval(x, y, r, r);
    }
}

class Test{
    public static void main(String args[]){
        new MyFrame("Cerc cu thread");
    }
}
