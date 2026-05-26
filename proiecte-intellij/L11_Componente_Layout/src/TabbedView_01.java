
import java.awt.*;
import javax.swing.*;

public class TabbedView_01 {
    	final static String BUTTONPANEL = "Tab with JButtons";
    	final static String TEXTPANEL = "Tab with JTextField";
    	final static int extraWindowWidth = 100;
	
   	public void addComponentToPane(Container pane) {
        	JTabbedPane tabbedPane = new JTabbedPane();

        	//Create the "cards".
        	JPanel card1 = new JPanel() {
            
            		public Dimension getPreferredSize() {
                		Dimension size = super.getPreferredSize();
                		size.width += extraWindowWidth;
                		return size;
            		}
        	};

        	card1.add(new JButton("Button 1"));
        	card1.add(new JButton("Button 2"));
        	card1.add(new JButton("Button 3"));

        	JPanel card2 = new JPanel();
        	card2.add(new JTextField("TextField", 20));

        	tabbedPane.addTab(BUTTONPANEL, card1);
        	tabbedPane.addTab(TEXTPANEL, card2);

        	pane.add(tabbedPane, BorderLayout.CENTER);
    	}

    
    	private static void createAndShowGUI() {
        
        	JFrame frame = new JFrame("TabbedView_01");
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        	TabbedView_01 demo = new TabbedView_01();
        	demo.addComponentToPane(frame.getContentPane());

       
        	frame.pack();
        	frame.setVisible(true);
    	}

    	public static void main(String[] args) {
        
		try {
            		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        	} 
		catch (UnsupportedLookAndFeelException ex) {
            		ex.printStackTrace();
        	} 
		catch (IllegalAccessException ex) {
            		ex.printStackTrace();
        	} 
		catch (InstantiationException ex) {
            		ex.printStackTrace();
        	} 
		catch (ClassNotFoundException ex) {
            		ex.printStackTrace();
        	}
        
        	//UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        
                createAndShowGUI();
            
    	}
}