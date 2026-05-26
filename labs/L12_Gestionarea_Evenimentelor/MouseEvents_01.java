
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


class MyFrame extends Frame implements WindowListener{
  
	Label label;
	MyCanvas canvas;
	
	MyFrame(String title){
		super(title);
		
		setLayout(new FlowLayout());
		
		label = new Label("click in zona portocalie");
		canvas = new MyCanvas();

		add(label);
		add(canvas);
		
		this.addWindowListener(this);
		
		setSize(300, 300);
		setVisible(true);
		
		
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(1);
		
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}

class MyCanvas extends Canvas implements MouseListener{
	
	Graphics g;
	int radius = 20;
	
	String output = "* *";
	int smile_width = 10;
	int smile_height = 5;
	
	MyCanvas(){
		this.setSize(new Dimension(200, 200));
		this.setBackground(new Color(255, 125, 0));
		
		
		this.addMouseListener(this);
	}
	
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		
		g = this.getGraphics();
		g.setColor(new Color(255, 255, 255));
		
		int x, y;
		x = mouseEvent.getX();
		y = mouseEvent.getY();
		
		g.getFontMetrics().stringWidth(output);
		
		g.drawString(output, x - g.getFontMetrics().stringWidth(output)/2, y);
		g.drawArc(x-smile_width, y+smile_height, 2*smile_width, smile_height, 180, 180);
		
		g.drawOval(x-radius, y-radius, 2*radius, 2*radius);
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

class Test{
	public static void main(String...strings){
	
		MyFrame frame = new MyFrame("Mouse events");
		
	}
}
