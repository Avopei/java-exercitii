import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.CheckboxMenuItem;
import java.awt.Choice;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainComponents_01{
	public static void main(String... args) {
		Frame f = new Frame("Fereastra principala");
		f.setLayout(new FlowLayout());
		
//------------- meniu ------------------------------------		
		
		//bara de meniu
		MenuBar mb = new MenuBar();
		//atasarea barei de meniu
		f.setMenuBar(mb);

		//un prim meniu
		Menu menu1 = new Menu("Primul meniu");
		menu1.add(new MenuItem("Articol 1"));
		menu1.add(new MenuItem("Articol 2"));
		menu1.addSeparator();
		menu1.add(new CheckboxMenuItem("Articol checkbox 1"));

		//un submeniu
		Menu submenu1 = new Menu("Submeniu 1");
		submenu1.add(new MenuItem("AAA"));
		submenu1.add(new MenuItem("BBB"));

		menu1.add(submenu1);

		//adaugarea meniului la bara de meniu
		mb.add(menu1);
	
//------------------- buton ----------------------------	
		
		Button b1 = new Button("Exemplu de buton");
		
		f.add(b1);
		
//------------------ checkbox --------------------------
		
		Checkbox check1 = new Checkbox("bifare");
		
		f.add(check1);
	
//------------------ radio buttons --------------------------
		
		CheckboxGroup cbg = new CheckboxGroup();
		f.add(new Checkbox("Articol 1", false, cbg));
		f.add(new Checkbox("Articol 2", false, cbg));
		f.add(new Checkbox("Articol 3", true, cbg));
		

//------------------ choice --------------------------
		
		Choice choice1 = new Choice(); 
		choice1.add("Articol 1");
		choice1.add("Articol 2");
		choice1.add("Articol 3");

				
		f.add(choice1);		
		
//------------------ file dialog --------------------------		
		
		Button loadFileDialog = new Button("incarca un fisier");
		
		loadFileDialog.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog fd = new FileDialog(f, "Alege un fisier", FileDialog.LOAD);
				fd.setVisible(true);
				System.out.println("A fost ales fisierul: "+fd.getFile());
				
			}
			
		});
		
		f.add(loadFileDialog);
		
//----------------- list -------------------------
		
		 List l1=new List(5);  
		 l1.setBounds(100,100, 75,75);
		 l1.add("Item 1");  
		 l1.add("Item 2");
		 l1.add("Item 3");
		 l1.add("Item 4");
		 l1.add("Item 5");  
		
		 f.add(l1);

//---------------- scroll pane ----------------
		 
		 ScrollPane sp1 = new ScrollPane();
		 Label eticheta = new Label("AAABBBCCCDDDEEEFFFGGGHHHIIIJJJ");
		 eticheta.setFont(new Font("SansSerif", Font.BOLD, 80));
		 sp1.add(eticheta);
		 
		 f.add(sp1);

//--------------- text field, text area -------------------------
		 
		 TextField tf1 = new TextField(5);
		 tf1.setFont(new Font("SansSerif", Font.PLAIN, 8));
		 tf1.setText("abcdefg");
			
		 int val = 7;

		 TextArea ta1 = new TextArea(3, 20);
		 ta1.setText("aaa\nbbb\nccc" + val);
		 ta1.append(tf1.getText());
		 
		 f.add(tf1);
		 f.add(ta1);

		
//----------------- functionalitatea ferestrei ----------------------		
		
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

		// afisarea ferestrei
		f.setSize(400, 500);
		
		f.setVisible(true);
	}
}
