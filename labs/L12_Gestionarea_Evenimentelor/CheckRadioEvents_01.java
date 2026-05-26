
import javax.swing.* ;    
import java.awt.* ;   
import java.awt.event.* ;

class CheckRadio extends JFrame implements ItemListener  
{			
  private static final long serialVersionUID = 1L;
JPanel northpanel, southpanel;			// declare reference variables
  JTextField jfield;
  JCheckBox pastrybox, burgerbox, pizzabox;
  JRadioButton veg, nonveg;
  ButtonGroup bg; // to group radio buttons- only one selected
 
  public CheckRadio ( )   
  {
    northpanel = new JPanel( ); 			// for adding checkboxes
    southpanel = new JPanel( );                         // for adding radio buttons
    northpanel.setBackground(Color.pink);               
    southpanel.setBackground(Color.magenta);
 
    jfield = new JTextField("Click and See");           // for displaying the state of buttons
    jfield.setBackground(Color.cyan);
 
    pastrybox = new JCheckBox("Pastry");                // instantiate all checkboxes
    burgerbox = new JCheckBox("Burger");
    pizzabox = new JCheckBox("Pizza");
 
    veg = new JRadioButton("Vegetarian");               // instantiate all radiobuttons
    nonveg = new JRadioButton("Non-Vegetarian", true);  // displayed in selected state
 
    bg = new ButtonGroup( );                            // a button group to add all radio buttons
    bg.add( veg ) ;  bg.add( nonveg ) ;                              // add radio buttons to the group
					                // add checkboxes one by one to panel
    northpanel.add(pastrybox);    northpanel.add(burgerbox);    northpanel.add(pizzabox);
   southpanel.add(veg);          southpanel.add(nonveg);  
    //southpanel.add(bg);
    // observe: bg is not added as ButtonGroup is not a component
    pastrybox.addItemListener(this);                    // add listener to each JComponent
    burgerbox.addItemListener(this);  pizzabox.addItemListener(this); 
    veg.addItemListener(this);        nonveg.addItemListener(this); 
 
    Container c = getContentPane();
    c.add(northpanel, BorderLayout.NORTH);
    c.add(southpanel, BorderLayout.SOUTH);
    c.add( jfield, BorderLayout.CENTER);
 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// closing the JFrame
  }
  public void itemStateChanged(ItemEvent e)  
  {
    String str = "";
    if(veg.isSelected())	  str = "You are Vegetarian";	
    else if(nonveg.isSelected()) str = "You are Non_Vegetarian";	
 
    jfield.setText("Pastry: " + pastrybox.isSelected() + "  Burger: " + burgerbox.isSelected() + "  Pizza: " + pizzabox.isSelected() + "  AND  " + str);
  }
  
  public static void main(String ... args)   
  {                                                
    JFrame f = new CheckRadio();
    f.setSize(400, 200);    
    f.setVisible(true);
  }
  
}
