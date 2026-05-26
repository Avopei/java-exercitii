import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

class MyFrame extends Frame implements ActionListener{
  	private static final long serialVersionUID = 1L;
	Button b1, b2;
	Label label;
	
	MyFrame(String title){
		super(title);
		
		setLayout(new FlowLayout());
		
		b1 = new Button("Apasa b1");
		b2 = new Button("Apasa b2");
		b2.setActionCommand("#245rffgy");

		b1.addActionListener(this);
		b2.addActionListener(this);

		this.add(b1);
		this.add(b2);

		label = new Label("Apasa pe butoane...");
		this.add(label);
		
		//this.addWindowListener(this);
		 this.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0); } 
		    });    
		
		setSize(300, 300);
		}

	public void actionPerformed(ActionEvent ae){
		label.setText(ae.getActionCommand());	
	}
}

public class ButtonEvents_02_Adapter{
	public static void main(String...strings){
	
		MyFrame frame = new MyFrame("Button events");
		frame.setVisible(true);
	}
}
