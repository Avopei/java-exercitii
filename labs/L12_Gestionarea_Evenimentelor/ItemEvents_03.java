
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Choice;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;

class MyFrame extends Frame implements WindowListener{
  
	Label label;
	Choice day, month, year;
	
	MyFrame(String title){
		super(title);
		
		setLayout(new FlowLayout());
		
		day = new Choice();
		month = new Choice();
		year = new Choice();

		for(int i=1; i<32; i++){
			day.addItem(Integer.toString(i));
		}

		for(int i=1; i<13; i++){
			month.addItem(Integer.toString(i));
		}

		for(int i=2018; i<2200; i++){
			year.addItem(Integer.toString(i));
		}

		label = new Label("");
		label.setBackground(new Color(255, 125, 0));

		
		day.addItemListener(e -> {
			processSelection();
		});

		month.addItemListener(e -> {
			processSelection();
		});

		year.addItemListener(e -> {
			processSelection();
		});		
		
		this.add(day);
		this.add(month);
		this.add(year);
		this.add(label);

		processSelection();
		
		this.addWindowListener(this);
		
		setSize(300, 300);
		setVisible(true);
		
		
	}

	public void processSelection(){
		String date = "";
		date = date + day.getSelectedItem()+" / "+ month.getSelectedItem() + " / " + year.getSelectedItem();
		label.setText(date);
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
