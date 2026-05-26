
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class MyFrame extends Frame implements WindowListener{
  
	MyFrame(String title){
		super(title);
		
		setSize(300, 300);
		setVisible(true);
		
		addWindowListener(this);
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		System.out.println("windowActivated");
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		System.out.println("windowClosed");
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.out.println("windowClosing");
		System.exit(1);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		System.out.println("windowDeactivated");
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		System.out.println("windowDeiconified");
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		System.out.println("windowIconified");
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		System.out.println("windowOpened");
		
	}
	
}

class Test{
	public static void main(String...strings){
	
		MyFrame frame = new MyFrame("Prima fereastra");
		
	}
}
