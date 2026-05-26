
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Button;
import java.awt.Label;
import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class MyFrame extends Frame implements WindowListener{
  
	MyButton b1, b2;
	Label label;
	
	MyFrame(String title){
		super(title);
		
		setLayout(new FlowLayout());
		
		b1 = new MyButton("Apasa b1", this);
		b2 = new MyButton("Apasa b2", this);

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

class MyButton extends Button{
	
	MyFrame frame;

	public MyButton(String eticheta, MyFrame frame){
		super(eticheta);		
		this.frame = frame;
		enableEvents(AWTEvent.ACTION_EVENT_MASK);
	}
	public void processActionEvent(ActionEvent ae){
		frame.setLabelText("\""+this.getLabel()+"\" apasat...");
		super.processActionEvent(ae);
	}
}



class Test{
	public static void main(String...strings){
	
		MyFrame frame = new MyFrame("Button events");
		
	}
}
