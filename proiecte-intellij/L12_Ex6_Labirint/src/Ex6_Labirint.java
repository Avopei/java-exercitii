import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrame extends JFrame{
    MyCanvas canvas;

    MyFrame(String titlu){
        super(titlu);
        canvas = new MyCanvas();
        add(canvas);
        setSize(360, 390);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        canvas.requestFocus();
    }
}

class MyCanvas extends Canvas implements KeyListener{
    int[][] lab = {
        {1,1,1,1,1,1,1},
        {0,0,0,1,0,0,1},
        {1,1,0,1,0,1,1},
        {1,0,0,0,0,0,1},
        {1,0,1,1,1,0,1},
        {1,0,0,0,1,0,2},
        {1,1,1,1,1,1,1}
    };

    int lin = 1, col = 0;
    int startLin = 1, startCol = 0;
    String mesaj = "Muta cu sagetile";
    int dim = 45;

    MyCanvas(){
        setSize(320, 340);
        setBackground(Color.white);
        addKeyListener(this);
    }

    public void paint(Graphics g){
        for(int i=0;i<lab.length;i++){
            for(int j=0;j<lab[i].length;j++){
                if(lab[i][j] == 1) g.setColor(Color.black);
                else if(lab[i][j] == 2) g.setColor(Color.green);
                else g.setColor(Color.white);
                g.fillRect(j*dim, i*dim, dim, dim);
                g.setColor(Color.gray);
                g.drawRect(j*dim, i*dim, dim, dim);
            }
        }
        g.setColor(Color.red);
        g.fillRect(col*dim + 5, lin*dim + 5, dim - 10, dim - 10);
        g.setColor(Color.blue);
        g.drawString(mesaj, 10, 330);
    }

    void reset(){
        lin = startLin;
        col = startCol;
        mesaj = "Pozitie resetata";
    }

    public void keyPressed(KeyEvent e){
        int nl = lin;
        int nc = col;

        if(e.getKeyCode() == KeyEvent.VK_UP) nl--;
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) nl++;
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) nc--;
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) nc++;
        else{
            reset();
            repaint();
            return;
        }

        if(nl < 0 || nc < 0 || nl >= lab.length || nc >= lab[0].length || lab[nl][nc] == 1){
            reset();
        }
        else{
            lin = nl;
            col = nc;
            mesaj = "Continua";
            if(lab[lin][col] == 2) mesaj = "Labirint rezolvat";
        }
        repaint();
    }

    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
}

class Test{
    public static void main(String args[]){
        new MyFrame("Labirint");
    }
}
