package uta.cse.cse3310.JSBSimEdit;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.io.File;




public class SystemTab extends JPanel
{
    public SystemTab(File fileName)
    {
        this.fileName = fileName;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel pushBackPanel = new JPanel();
        pushBackPanel.setLayout(new BoxLayout(pushBackPanel, BoxLayout.Y_AXIS));
        pushBackPanel.setBorder(BorderFactory.createTitledBorder("PushBack"));

        JTextField kpField = new JTextField();
        JTextField kiField = new JTextField();
        JTextField kdField = new JTextField();

        addLabeledTextField(pushBackPanel, "proportional(kp)", kpField);
        addLabeledTextField(pushBackPanel, "integral(ki)", kiField);
        addLabeledTextField(pushBackPanel, "derivative(kd)", kdField);
        
        add(pushBackPanel);

    }
    private void addLabeledTextField(JPanel panel, String labelText, JTextField textField) 
    {
        JPanel subPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Center-align the sub-panel
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(150, 20)); // Adjust label size
        textField.setPreferredSize(new Dimension(150, 20)); // Adjust text field size
        subPanel.add(label);
        subPanel.add(textField);
        panel.add(subPanel);
    }
    
    private File fileName;
}
