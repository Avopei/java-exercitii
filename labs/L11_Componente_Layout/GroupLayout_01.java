
import java.awt.Component;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;

public class GroupLayout_01 extends JFrame {
    public GroupLayout_01() {
        JLabel label = new JLabel("GroupLayout_01 What:");;
        JTextField textField = new JTextField();
        JCheckBox caseCheckBox = new JCheckBox("Match Case");
        JCheckBox wrapCheckBox = new JCheckBox("Wrap Around");
        JCheckBox wholeCheckBox = new JCheckBox("Whole Words");
        JCheckBox backCheckBox = new JCheckBox("Search Backwards");
        JButton GroupLayout_01Button = new JButton("GroupLayout_01");
        JButton cancelButton = new JButton("Cancel");

        caseCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        wrapCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        wholeCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        backCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addComponent(label)
            .addGroup(layout.createParallelGroup(LEADING)
                .addComponent(textField)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(caseCheckBox)
                        .addComponent(wholeCheckBox))
                    .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(wrapCheckBox)
                        .addComponent(backCheckBox))))
            .addGroup(layout.createParallelGroup(LEADING)
                .addComponent(GroupLayout_01Button)
                .addComponent(cancelButton))
        );
       
        layout.linkSize(SwingConstants.HORIZONTAL, GroupLayout_01Button, cancelButton);

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(BASELINE)
                .addComponent(label)
                .addComponent(textField)
                .addComponent(GroupLayout_01Button))
            .addGroup(layout.createParallelGroup(LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(caseCheckBox)
                        .addComponent(wrapCheckBox))
                    .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(wholeCheckBox)
                        .addComponent(backCheckBox)))
                .addComponent(cancelButton))
        );

        setTitle("GroupLayout_01");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                                  "javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                new GroupLayout_01().setVisible(true);
            }
        });
    }
}
