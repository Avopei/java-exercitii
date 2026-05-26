import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MyFrame extends JFrame implements ActionListener{
    JTextField nume, grupa;
    JComboBox curs;
    JButton inregistrare;
    JLabel mesaj;

    MyFrame(String titlu){
        super(titlu);
        setLayout(new FlowLayout());

        nume = new JTextField(15);
        grupa = new JTextField(8);
        curs = new JComboBox();
        inregistrare = new JButton("Inregistrare");
        mesaj = new JLabel("Completeaza datele");

        curs.addItem("Java");
        curs.addItem("Baze de date");
        curs.addItem("Grafica");

        // doar litere in nume
        nume.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != ' '){
                    e.consume();
                }
            }
        });

        // doar cifre in grupa
        grupa.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE){
                    e.consume();
                }
            }
        });

        add(new JLabel("Nume:")); add(nume);
        add(new JLabel("Grupa:")); add(grupa);
        add(new JLabel("Curs:")); add(curs);
        add(inregistrare);
        add(mesaj);

        inregistrare.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 220);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        try{
            FileWriter fw = new FileWriter("studenti.txt", true);
            fw.write(nume.getText() + ";" + grupa.getText() + ";" + curs.getSelectedItem() + "\n");
            fw.close();
            mesaj.setText("Date salvate");
        }
        catch(IOException ex){
            mesaj.setText("Eroare fisier");
        }
    }
}

class Test{
    public static void main(String args[]){
        new MyFrame("Inregistrare student");
    }
}
