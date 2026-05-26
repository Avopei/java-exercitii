
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


class MyFrame extends JFrame{
  
	JLabel label;
	MyCanvas canvas;
	
	MyFrame(String title){
		super(title);
		
		setLayout(new FlowLayout());
		
		label = new JLabel("Click si apoi WASD ;)");
		canvas = new MyCanvas();

		add(label);
		add(canvas);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(300, 300);
		setVisible(true);
	}
	
}

class MyCanvas extends Canvas implements KeyListener{
	
	int x, y, radius;
	
	MyCanvas(){
		this.setSize(new Dimension(200, 200));
		this.setBackground(new Color(255, 125, 0));
		
		x = 100;
		y = 100;
		radius = 20;
		
		this.addKeyListener(this);
	}
	
	public void paint(Graphics g){
		g.drawOval(x-radius, y-radius, 2*radius, 2*radius);
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getKeyChar()){
		case 'w': y -= 5; break;
		case 'a': x -= 5; break;
		case 's': y += 5; break;
		case 'd': x += 5; break;
			
		}
		
		repaint();
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class Test{
	public static void main(String...strings){
	
		MyFrame frame = new MyFrame("Key events");
		
	}
}
