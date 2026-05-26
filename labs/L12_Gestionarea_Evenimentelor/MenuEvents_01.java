import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Test{
	public static void main(String... args) {
		Frame f = new Frame("Fereastra principala");
		f.setSize(200, 200);

		Label label = new Label();

		//bara de meniu
		MenuBar mb = new MenuBar();
		//atasarea barei de meniu
		f.setMenuBar(mb);

		//un prim meniu
		Menu menu1 = new Menu("Primul meniu");
		MenuItem ma1 = new MenuItem("Articol 1");
		ma1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				label.setText("A fost selectat - "+ma1.getLabel());
			}
		});

		MenuItem ma2 = new MenuItem("Articol 2");
		ma2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				label.setText("A fost selectat - "+ma2.getLabel());
			}
		});

		menu1.add(ma1);
		menu1.add(ma2);

		//adaugarea meniului la bara de meniu
		mb.add(menu1);

		f.add(label);
		
		f.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		//fereastra este facuta vizibila
		f.setVisible(true);
	}
}
