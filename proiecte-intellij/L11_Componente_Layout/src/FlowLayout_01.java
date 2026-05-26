
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class FlowLayout_01 extends JFrame{
    JRadioButton RtoLbutton;
    JRadioButton LtoRbutton;
    FlowLayout experimentLayout = new FlowLayout();
    final String RtoL = "Right to left";
    final String LtoR = "Left to right";
    JButton applyButton = new JButton("Apply component orientation");
    
    public FlowLayout_01(String name) {
        super(name);
    }
    
    public void addComponentsToPane(final Container pane) {
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(experimentLayout);
        experimentLayout.setAlignment(FlowLayout.TRAILING);
        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout());
        
        LtoRbutton = new JRadioButton(LtoR);
        LtoRbutton.setActionCommand(LtoR);
        LtoRbutton.setSelected(true);
        RtoLbutton = new JRadioButton(RtoL);
        RtoLbutton.setActionCommand(RtoL);
        
        
        compsToExperiment.add(new JButton("Button 1"));
        compsToExperiment.add(new JButton("Button 2"));
        compsToExperiment.add(new JButton("Button 3"));
        compsToExperiment.add(new JButton("Long-Named Button 4"));
        compsToExperiment.add(new JButton("5"));
        
        compsToExperiment.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
        
        
        final ButtonGroup group = new ButtonGroup();
        group.add(LtoRbutton);
        group.add(RtoLbutton);
        controls.add(LtoRbutton);
        controls.add(RtoLbutton);
        controls.add(applyButton);
        
       
        applyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String command = group.getSelection().getActionCommand();
                //Check the selection
                if (command.equals("Left to right")) {
                    compsToExperiment.setComponentOrientation(
                            ComponentOrientation.LEFT_TO_RIGHT);
                } else {
                    compsToExperiment.setComponentOrientation(
                            ComponentOrientation.RIGHT_TO_LEFT);
                }
                //update the experiment layout
                compsToExperiment.validate();
                compsToExperiment.repaint();
            }
        });
        pane.add(compsToExperiment, BorderLayout.CENTER);
        pane.add(controls, BorderLayout.SOUTH); ;
    }
    
    
    private static void createAndShowGUI() {
       
        FlowLayout_01 frame = new FlowLayout_01("Flow Layout_01");
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