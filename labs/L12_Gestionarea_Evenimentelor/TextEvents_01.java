
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

class MyFrame extends Frame implements WindowListener{
  
	Label label;
	TextField textField;
	
	MyFrame(String title){
		super(title);
		
		setLayout(new FlowLayout());
		
		label = new Label();
		textField  = new TextField(20);
		textField.setBackground(new Color(255, 125, 0));
		textField.addTextListener(new MyTextListener(this));
		
		this.add(textField);
		this.add(label);
		
		this.addWindowListener(this);
		
		setSize(300, 300);
		setVisible(true);
		
		
	}
	public void setLabelText(String text){
		//pt. ajustarea dimensiunilor etichetei
		label.invalidate();
		label.setText(text);
		validate();
	}

	public String getTextFieldText(){
		return textField.getText();
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

class MyTextListener implements TextListener{

	MyFrame frame;
	
	MyTextListener(MyFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void textValueChanged(TextEvent te) {
		frame.setLabelText(frame.getTextFieldText());
		
	}
	
}

class Test{
	public static void main(String...strings){
	
		MyFrame frame = new MyFrame("Text events");
		
	}
}
