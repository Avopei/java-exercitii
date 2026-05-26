import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class MyFrame extends JFrame{
  	private static final long serialVersionUID = 1L;
	JLabel label;
	JTextField textField;
	
	MyFrame(String title){
		super(title);
		setLayout(new FlowLayout());
		
		label = new JLabel("doar valori numerice");
		textField  = new JTextField(20);
		textField.setBackground(new Color(255, 125, 0));
		textField.addKeyListener(new MyKeyListener());
		
		this.add(textField);
		this.add(label);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(300, 300);
		}
	
	}

class MyKeyListener extends KeyAdapter{

	@Override
	public void keyTyped(KeyEvent ke) {
		char c = ke.getKeyChar();
	      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
	         ke.consume();  // caracterul nu mai apare pe ecran
	      }
		
	}
	
}

public class KeyAdapter_01{
	public static void main(String...strings){
		MyFrame frame = new MyFrame("Key events");
		frame.setVisible(true);
	}
}
