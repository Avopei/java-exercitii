import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GroupLayout_02 {

	public static void main(String[] args) {
		// Create and set up a frame window
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Layout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Define new buttons with different width on help of the ---
		JButton jb1 = new JButton("1");
		JButton jb2 = new JButton("2");
		JButton jb3 = new JButton("3");
		JButton jb4 = new JButton("4");

		// Define the panel to hold the buttons
		JPanel panel = new JPanel();
		panel.setSize(300, 300);
		GroupLayout layout = new GroupLayout(panel);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		panel.setLayout(layout);

		// Set for horizontal and vertical group
		layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(jb1).addComponent(jb2)
				.addGroup(layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jb3).addComponent(jb4))));
		layout.setVerticalGroup(
				layout.createSequentialGroup().addComponent(jb1).addComponent(jb2).addComponent(jb3).addComponent(jb4));
		

		frame.add(panel);

		// show the window		
		frame.pack();
		frame.setVisible(true);

	}

}
