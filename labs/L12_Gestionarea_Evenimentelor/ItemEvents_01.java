
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Checkbox;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class MyFrame extends Frame implements WindowListener{
  
	Label label;
	Checkbox checkbox;
	
	MyFrame(String title){
		super(title);
		
		setLayout(new FlowLayout());
		
		label = new Label("text vizibil");
		label.setBackground(new Color(255, 125, 0));

		checkbox  = new Checkbox("Ar trebui sa fie vizibil texul?");
		checkbox.setState(true);
		checkbox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					label.setVisible(true);
				} 
				else {
					label.setVisible(false);
				}
			}	
		});
		
		this.add(checkbox);
		this.add(label);
		
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

class Test{
	public static void main(String...strings){
	
		MyFrame frame = new MyFrame("Item events");
		
	}
}
