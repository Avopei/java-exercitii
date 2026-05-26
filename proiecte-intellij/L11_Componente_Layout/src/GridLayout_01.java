
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridLayout_01 extends JFrame {

	static final long serialVersionUID = 1L;

    static final String gapList[] = {"0", "10", "15", "20"};
    final static int maxGap = 20;
    JComboBox<String> horGapComboBox;
    JComboBox<String> verGapComboBox;
    JButton applyButton = new JButton("Apply gaps");
    GridLayout experimentLayout = new GridLayout(0,2);
    
    public GridLayout_01(String name) {
        super(name);
        setResizable(false);
    }
    
    public void initGaps() {
        horGapComboBox = new JComboBox<>(gapList);
        verGapComboBox = new JComboBox<>(gapList);
    }
    
    public void addComponentsToPane(final Container pane) {
        initGaps();
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(experimentLayout);
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(2,3));
        
       
        JButton b = new JButton("Just fake button");
        Dimension buttonSize = b.getPreferredSize();
        compsToExperiment.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap,
                (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));
        
       
        compsToExperiment.add(new JButton("Button 1"));
        compsToExperiment.add(new JButton("Button 2"));
        compsToExperiment.add(new JButton("Button 3"));
        compsToExperiment.add(new JButton("Long-Named Button 4"));
        compsToExperiment.add(new JButton("5"));
        
        
        controls.add(new Label("Horizontal gap:"));
        controls.add(new Label("Vertical gap:"));
        controls.add(new Label(" "));
        controls.add(horGapComboBox);
        controls.add(verGapComboBox);
        controls.add(applyButton);
        
     
        applyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                String horGap = (String)horGapComboBox.getSelectedItem();
               
                String verGap = (String)verGapComboBox.getSelectedItem();
                
                experimentLayout.setHgap(Integer.parseInt(horGap));
               
                experimentLayout.setVgap(Integer.parseInt(verGap));
               
                experimentLayout.layoutContainer(compsToExperiment);
            }
        });
        pane.add(compsToExperiment, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(controls, BorderLayout.SOUTH);
    }
    
   
    private static void createAndShowGUI() {
        
        GridLayout_01 frame = new GridLayout_01("Grid Layout_01");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.addComponentsToPane(frame.getContentPane());
       
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
       
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
       
        createAndShowGUI();
        
    }
}