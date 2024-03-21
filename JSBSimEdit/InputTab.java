package uta.cse.cse3310.JSBSimEdit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class InputTab extends JPanel
{
    public InputTab()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        
        addLabel("Port:", 0, 0, gbc);
        field1 = new JTextField(20);
        addTextField(1, 0, 1, 1, gbc, field1, GridBagConstraints.BOTH);
        
        addLabel("Type:", 0, 1, gbc);
        field2 = new JTextField(20);
        addTextField(1, 1, 1, 1, gbc, field2, GridBagConstraints.BOTH);
        
       
      
        
        
    }
    private void addLabel(String text, int x, int y, GridBagConstraints gbc) 
    {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(new JLabel(text), gbc);
    }
    private void addTextField(int x, int y, int width, int height, GridBagConstraints gbc, JTextField tf, int fillValue) 
    {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = fillValue;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        //gbc.weightx = 0.5;
        //gbc.weighty = 0;
        add(tf, gbc);
    }
    private JLabel portLabel;
    private JTextField field1;
    private JTextField field2;
    private JLabel label2;
   
}
