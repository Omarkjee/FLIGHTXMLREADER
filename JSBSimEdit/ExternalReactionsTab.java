package uta.cse.cse3310.JSBSimEdit;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.io.File;
import generated.FdmConfig;
import generated.ExternalReactions;
import generated.Force;
import javax.swing.JList;
import java.util.List;


public class ExternalReactionsTab extends JPanel
{
    private JTextField xLocationTextField;
    private JTextField yLocationTextField;
    private JTextField zLocationTextField;
    private JTextField xDirectionTextField;
    private JTextField yDirectionTextField;
    private JTextField zDirectionTextField;
    private FdmConfig cfg;
    private ExternalReactions externalReactions;
    private File fileName;
    public ExternalReactionsTab(File fileName)
    {
        this.fileName = fileName;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
    
        JPanel locationPanel = createSubPanel("Location");
        
        xLocationTextField = addRow(locationPanel, "x-value");
        yLocationTextField = addRow(locationPanel, "y-value");
        zLocationTextField = addRow(locationPanel, "z-value");
    
        JPanel directionPanel = createSubPanel("Direction");
        
        xDirectionTextField = addRow(directionPanel, "x-value");
        yDirectionTextField = addRow(directionPanel, "y-value");
        zDirectionTextField = addRow(directionPanel, "z-value");
        
        JPanel unitPanel = createSubPanel("Unit");
        JComboBox<String> unitComboBox = new JComboBox<>(new String[]{"M", "IN", "FT"});
        unitPanel.add(unitComboBox);
        
        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(locationPanel, gbc);
        
        gbc.gridx = 1;
        add(directionPanel, gbc);
        
        gbc.gridx = 2;
        add(unitPanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        add(buttonPanel, gbc);

        cfg = XMLDataLoader.loadXMLData(this.fileName);

        externalReactions = (ExternalReactions) cfg.getExternalReactions();
        
        List<Force> forces = externalReactions.getForce();
        
        for(Force f : forces)
        {
            xLocationTextField.setText(String.valueOf(f.getLocation().getX()));
            yLocationTextField.setText(String.valueOf(f.getLocation().getY()));
            zLocationTextField.setText(String.valueOf(f.getLocation().getZ()));
            
            xDirectionTextField.setText(String.valueOf(f.getDirection().getX()));
            yDirectionTextField.setText(String.valueOf(f.getDirection().getY()));
            zDirectionTextField.setText(String.valueOf(f.getDirection().getZ()));
            
            unitComboBox.addItem(f.getLocation().getUnit());
            
            
        }
        
        
    }
    private JPanel createSubPanel(String title) 
    {
       JPanel panel = new JPanel(new GridLayout(3, 2));
       panel.setBorder(BorderFactory.createTitledBorder(title));
       return panel;
    }
    private JTextField addRow(JPanel panel, String label) 
    {
        JTextField textField = new JTextField();
        panel.add(new JLabel(label));
        panel.add(textField);
        return textField;
    }
    
    
}

