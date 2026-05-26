
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayout_01 implements ItemListener {
	JPanel cards; //a panel that uses CardLayout
	final static String BUTTONPANEL = "Card with JButtons";
	final static String TEXTPANEL = "Card with JTextField";
    
	public void addComponentToPane(Container pane) {
        
        	JPanel comboBoxPane = new JPanel(); //implicit FlowLayout
        	String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL };
        	JComboBox<String> cb = new JComboBox<>(comboBoxItems);
        	cb.setEditable(false);
        	cb.addItemListener(this);
        	comboBoxPane.add(cb);
        
        	//Create the "cards".
        	JPanel card1 = new JPanel();
        	card1.add(new JButton("Button 1"));
        	card1.add(new JButton("Button 2"));
        	card1.add(new JButton("Button 3"));
        
        	JPanel card2 = new JPanel();
        	card2.add(new JTextField("TextField", 20));
        
        	//Create the panel that contains the "cards".
        	cards = new JPanel(new CardLayout());
        	cards.add(card1, BUTTONPANEL);
        	cards.add(card2, TEXTPANEL);
        
        	pane.add(comboBoxPane, BorderLayout.PAGE_START);
        	pane.add(cards, BorderLayout.CENTER);
    	}
    
    	public void itemStateChanged(ItemEvent evt) {
        	CardLayout cl = (CardLayout)(cards.getLayout());
        	cl.show(cards, (String)evt.getItem());
    	}
    
    
    	private static void createAndShowGUI() {
        	JFrame frame = new JFrame("Card Layout Demo");
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        	CardLayout_01 cards = new CardLayout_01();
        	cards.addComponentToPane(frame.getContentPane());
        
        
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
        
        	UIManager.put("swing.boldMetal", Boolean.FALSE);
        
                createAndShowGUI();
            
    	}
}