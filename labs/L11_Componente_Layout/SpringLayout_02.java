import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class SpringLayout_02 {

	public static void main(String[] args) {
		// Create and set up a frame window
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Layout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Define the panel to hold the components	
		JPanel panel = new JPanel();
		SpringLayout layout = new SpringLayout();
		
		JLabel label = new JLabel("Label: ");
		JTextField text = new JTextField("Text field", 15);
		panel.setSize(300, 300);
		panel.setLayout(layout);
		panel.add(label);
		panel.add(text);

		// Put constraint on components
		layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, text, 5, SpringLayout.EAST, label);
		layout.putConstraint(SpringLayout.NORTH, text, 5, SpringLayout.NORTH, panel);
		
		frame.add(panel);

		// show the window		
		frame.pack();
		frame.setVisible(true);
		
	}

}

