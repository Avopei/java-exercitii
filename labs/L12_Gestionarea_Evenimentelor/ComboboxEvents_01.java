
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Gdemo2 {
public static void main(String[] args) {
// TODO Auto-generated method stub
Window win= new Window();
				}
		}//Gdemo2
class Window extends JFrame implements ItemListener {
	JTextArea ta= new JTextArea(2,25);
	JComboBox combo1= new JComboBox();
		public Window(){
	super ("Window Title Demo2");
	setSize(400,200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	Container ca= getContentPane();
	ca.setBackground(Color.lightGray);
	FlowLayout flm= new FlowLayout();
	ca.setLayout(flm);
	combo1.addItemListener(this);
	combo1.addItem("Test 1");
	combo1.addItem("Test 2");
	ca.add(combo1);
	ca.add(ta);
	setContentPane(ca);
				}//constructor
	public void itemStateChanged(ItemEvent ev){
	String str = ev.getItem().toString();
	ta.setText(str);		}
	}//Window class
