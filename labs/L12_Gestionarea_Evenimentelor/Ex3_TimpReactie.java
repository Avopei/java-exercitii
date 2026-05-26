import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class MyFrame extends Frame implements ActionListener{
    Button rosu, negru, start;
    Label info;
    MyCanvas canvas;
    Random rnd = new Random();
    int pas = 0, corecte = 0;
    int culoareCurenta = 0; // 0 rosu, 1 negru
    long timpStart, totalTimp = 0;

    MyFrame(String titlu){
        super(titlu);
        setLayout(new FlowLayout());

        start = new Button("Start");
        rosu = new Button("ROSU");
        negru = new Button("NEGRU");
        info = new Label("Apasa Start");
        canvas = new MyCanvas();

        add(start); add(rosu); add(negru);
        add(canvas); add(info);

        start.addActionListener(this);
        rosu.addActionListener(this);
        negru.addActionListener(this);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        setSize(330, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == start){
            pas = 0;
            corecte = 0;
            totalTimp = 0;
            urmatorulCerc();
            return;
        }

        if(pas == 0 || pas > 10) return;

        long acum = System.currentTimeMillis();
        totalTimp += acum - timpStart;

        if(e.getSource() == rosu && culoareCurenta == 0) corecte++;
        if(e.getSource() == negru && culoareCurenta == 1) corecte++;

        if(pas == 10){
            info.setText("Corecte: " + corecte + "  Medie: " + (totalTimp / 10) + " ms");
            pas++;
        }
        else{
            urmatorulCerc();
        }
    }

    void urmatorulCerc(){
        pas++;
        culoareCurenta = rnd.nextInt(2);
        canvas.culoare = culoareCurenta;
        canvas.repaint();
        info.setText("Cercul " + pas + " din 10");
        timpStart = System.currentTimeMillis();
    }
}

class MyCanvas extends Canvas{
    int culoare = 0;

    MyCanvas(){
        setSize(200, 120);
        setBackground(Color.white);
    }

    public void paint(Graphics g){
        if(culoare == 0) g.setColor(Color.red);
        else g.setColor(Color.black);
        g.fillOval(75, 35, 50, 50);
    }
}

class Test{
    public static void main(String args[]){
        new MyFrame("Timp reactie");
    }
}
