
import javax.swing.SpringLayout;
import javax.swing.Spring;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.Component;

public class SpringLayout_01 {
  
    private static void createAndShowGUI() {
       
        JFrame frame = new JFrame("Spring Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        
        JLabel label = new JLabel("Write some text, resize the window ");
        JTextField textField = new JTextField("Text field", 15);
        contentPane.add(label);
        contentPane.add(textField);

       
        SpringLayout.Constraints  labelCons = 
		layout.getConstraints(label);
        labelCons.setX(Spring.constant(5));
        labelCons.setY(Spring.constant(5));

       
        SpringLayout.Constraints textFieldCons =
                layout.getConstraints(textField);
        textFieldCons.setX(Spring.sum(Spring.constant(5),
                labelCons.getConstraint(SpringLayout.EAST)));
        textFieldCons.setY(Spring.constant(5));

        
        setContainerSize(contentPane, 5);

       
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
	createAndShowGUI();
    }

    public static void setContainerSize(Container parent, int pad) {
        SpringLayout layout = (SpringLayout) parent.getLayout();
        Component[] components = parent.getComponents();
        Spring maxHeightSpring = Spring.constant(0);
        SpringLayout.Constraints pCons = layout.getConstraints(parent);

        Component rightmost = components[components.length - 1];
        SpringLayout.Constraints rCons =
                layout.getConstraints(rightmost);
        pCons.setConstraint(
                SpringLayout.EAST,
                Spring.sum(Spring.constant(pad),
                           rCons.getConstraint(SpringLayout.EAST)));

        for (int i = 0; i < components.length; i++) {
            SpringLayout.Constraints cons =
                layout.getConstraints(components[i]);
            maxHeightSpring = Spring.max(maxHeightSpring,
                                         cons.getConstraint(
                                                SpringLayout.SOUTH));
        }
        pCons.setConstraint(
                SpringLayout.SOUTH,
                Spring.sum(Spring.constant(pad), maxHeightSpring));
   }
}