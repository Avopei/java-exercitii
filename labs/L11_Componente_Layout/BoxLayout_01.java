
import javax.swing.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

public class BoxLayout_01 {
    
	public void addComponentsToPane(Container pane) {
        
        	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        
		createButton("Button 1", pane);
		createButton("Button 2", pane);
		createButton("Button 3", pane);
		createButton("Button 44444444444", pane);
		createButton("Button cinci", pane);

    	}
    
	private void createButton(String text, Container container) {
        	JButton button = new JButton(text);
        	button.setAlignmentX(Component.CENTER_ALIGNMENT);
        	container.add(button);
    	}
    
    	private void createAndShowGUI() {
        
        	
        	JFrame frame = new JFrame("Box Layout Demo");
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        	addComponentsToPane(frame.getContentPane());
        
        	frame.pack();
        	frame.setVisible(true);
    	}
    
    	public static void main(String[] args) {
        
       		BoxLayout_01 box = new BoxLayout_01(); 	
       
                box.createAndShowGUI();
            
    	}
}