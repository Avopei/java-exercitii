import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class MyFrame extends Frame implements ActionListener{
    Button arunca;
    MyCanvas canvas;
    Random rnd = new Random();

    MyFrame(String titlu){
        super(titlu);
        setLayout(new FlowLayout());

        arunca = new Button("Arunca");
        canvas = new MyCanvas();

        add(arunca);
        add(canvas);
        arunca.addActionListener(this);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        setSize(350, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        canvas.z1 = rnd.nextInt(6) + 1;
        canvas.z2 = rnd.nextInt(6) + 1;
        canvas.repaint();
    }
}

class MyCanvas extends Canvas{
    int z1 = 1, z2 = 1;

    MyCanvas(){
        setSize(300, 150);
        setBackground(Color.white);
    }

    public void paint(Graphics g){
        deseneazaZar(g, 40, 30, z1);
        deseneazaZar(g, 170, 30, z2);
        g.setColor(Color.black);
        g.drawString("Suma = " + (z1 + z2), 120, 135);
    }

    void deseneazaZar(Graphics g, int x, int y, int val){
        g.setColor(Color.white);
        g.fillRect(x, y, 80, 80);
        g.setColor(Color.black);
        g.drawRect(x, y, 80, 80);

        if(val == 1 || val == 3 || val == 5) punct(g, x+40, y+40);
        if(val >= 2){ punct(g, x+20, y+20); punct(g, x+60, y+60); }
        if(val >= 4){ punct(g, x+60, y+20); punct(g, x+20, y+60); }
        if(val == 6){ punct(g, x+20, y+40); punct(g, x+60, y+40); }
    }

    void punct(Graphics g, int x, int y){
        g.fillOval(x-5, y-5, 10, 10);
    }
}

class Test{
    public static void main(String args[]){
        new MyFrame("Zaruri");
    }
}
