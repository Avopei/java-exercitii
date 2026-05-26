
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;

class MyFrame extends Frame implements WindowListener{
  
	Label label;
	Checkbox checkbox1, checkbox2, checkbox3;
	CheckboxGroup cbg;
	
	MyFrame(String title){
		super(title);
		
		setLayout(new GridLayout(4, 1));
		
		cbg = new CheckboxGroup();

		label = new Label("");
		label.setBackground(new Color(255, 125, 0));

		checkbox1  = new Checkbox("Male", cbg, true);
		checkbox2  = new Checkbox("Female", cbg, false);
		checkbox3  = new Checkbox("Other", cbg, false);
		checkbox1.addItemListener(e -> {
			if (checkbox1.getState()) {
				label.setText(checkbox1.getLabel());
			}	
		});

		checkbox2.addItemListener(e -> {
			if (checkbox2.getState()) {
				label.setText(checkbox2.getLabel());
			}	
		});

		checkbox3.addItemListener(e -> {
			if (checkbox3.getState()) {
				label.setText("Additional data needed...");
			}	
		});
		
		this.add(checkbox1);
		this.add(checkbox2);
		this.add(checkbox3);
		this.add(label);

		label.setText(cbg.getSelectedCheckbox().getLabel());
		
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
