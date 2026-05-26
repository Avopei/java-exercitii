import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;

public class GridLayout_02 {

	public static void main(String[] args) {
		// Create and set up a frame window
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Layout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Define new buttons
		JButton jb1 = new JButton("Button 1");		
		JButton jb2 = new JButton("Button 2");
		JButton jb3 = new JButton("Button 3");		
		JButton jb4 = new JButton("Button 4");
		JButton jb5 = new JButton("Button 5");			
		
		// Define the panel to hold the buttons	
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));
		panel.add(jb1);
		panel.add(jb2);
		panel.add(jb3);
		panel.add(jb4);
		panel.add(jb5);
		
		frame.add(panel);

		// show the window
		frame.pack();
		frame.setVisible(true);
		
	}

}

