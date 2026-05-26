
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class MyFrame extends Frame implements WindowListener{
  
	Button b1, b2;
	Label label;
	
	MyFrame(String title){
		super(title);
		
		setLayout(new FlowLayout());
		
		b1 = new Button("Apasa b1");
		b2 = new Button("Apasa b2");


		b1.addActionListener(e -> {
			setLabelText("Buton 1 apasat");
		});

		b2.addActionListener(e -> {
			setLabelText("Buton 2 apasat");
		});



		this.add(b1);
		this.add(b2);

		label = new Label("Apasa pe butoane...");
		this.add(label);
		
		this.addWindowListener(this);
		
		setSize(300, 300);
		setVisible(true);
		
		
	}

	public void setLabelText(String text){
		label.setText(text);	
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

class Test{
	public static void main(String...strings){
	
		MyFrame frame = new MyFrame("Button events");
		
	}
}
