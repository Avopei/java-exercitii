import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame implements ActionListener{
    TextField t1, t2, rezultat;
    Button adunare, scadere, inmultire, impartire;

    MyFrame(String titlu){
        super(titlu);
        setLayout(new FlowLayout());

        t1 = new TextField(8);
        t2 = new TextField(8);
        rezultat = new TextField(12);
        rezultat.setEditable(false);

        adunare = new Button("+");
        scadere = new Button("-");
        inmultire = new Button("*");
        impartire = new Button("/");

        add(new Label("a=")); add(t1);
        add(new Label("b=")); add(t2);
        add(adunare); add(scadere); add(inmultire); add(impartire);
        add(new Label("rezultat=")); add(rezultat);

        adunare.addActionListener(this);
        scadere.addActionListener(this);
        inmultire.addActionListener(this);
        impartire.addActionListener(this);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        setSize(300, 180);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        try{
            double a = Double.parseDouble(t1.getText());
            double b = Double.parseDouble(t2.getText());
            double r = 0;

            if(e.getSource() == adunare) r = a + b;
            if(e.getSource() == scadere) r = a - b;
            if(e.getSource() == inmultire) r = a * b;
            if(e.getSource() == impartire) r = a / b;

            rezultat.setText("" + r);
        }
        catch(Exception ex){
            rezultat.setText("date gresite");
        }
    }
}

class Test{
    public static void main(String args[]){
        new MyFrame("Calculator simplu");
    }
}
