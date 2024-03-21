package uta.cse.cse3310.JSBSimEdit;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import generated.MassBalance;
import generated.FdmConfig;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JList;
import generated.Pointmass;



public class MassBalanceTab extends JPanel 
{
    public MassBalanceTab(File fileName)
    {
        this.fileName = fileName;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        
        addLabel("Mass", 0, 0, gbc);
        addLabel("Empty Weight(*) = ", 0, 1, gbc);
        
        
        emptyWeightTextField = new JTextField(10);
        addTextInput(1, 1, 1, 1, gbc, emptyWeightTextField);
        addComboBox(2,1,gbc, emptyWeightComboBox);
        
        addLabel("Location", 0, 2, gbc);
        addLabel("x=", 0, 3, gbc);
        locationXvalue = new JTextField(5);
        addTextInput(1, 3, 1, 1, gbc, locationXvalue);        
        addLabel("y=", 2, 3, gbc);
        locationYvalue = new JTextField(5);
        addTextInput(3,3,1,1,gbc,locationYvalue);        
        addLabel("z=", 4, 3, gbc);
        locationZvalue = new JTextField(5);
        addTextInput(5, 3, 1, 1, gbc, locationZvalue);
        addComboBox(6, 3, gbc, locationUnitComboBox);
        
        addLabel("Moment of Inertia(*)", 0, 4, gbc);
        addLabel("Ixx=", 0, 5, gbc);
        IxxValue = new JTextField(5);
        addTextInput(1, 5, 1, 1, gbc, IxxValue);
        addComboBox(2, 5, gbc, IxxValueComboBox);
        
        addLabel("Iyy=", 0, 6, gbc);
        IyyValue = new JTextField(5);
        addTextInput(1, 6, 1, 1, gbc, IyyValue);
        addComboBox(2, 6, gbc, IyyValueComboBox);
        
        addLabel("Izz=", 0, 7, gbc);
        IzzValue = new JTextField(5);
        addTextInput(1, 7, 1, 1, gbc, IzzValue);
        addComboBox(2, 7, gbc, IzzValueComboBox);
        
        addLabel("Ixz=", 3, 5, gbc);
        IxzValue = new JTextField(5);
        addTextInput(4, 5, 1, 1, gbc, IxzValue);
        addComboBox(5, 5, gbc, IxzValueComboBox);
        
        addLabel("Iyz=", 3, 6, gbc);
        IyzValue = new JTextField(5);
        addTextInput(4,6,1,1, gbc, IyzValue);
        addComboBox(5, 6, gbc, IyzValueComboBox);
        
        addLabel("Ixy=", 3, 7, gbc);
        IxyValue = new JTextField(5);
        addTextInput(4, 7, 1, 1, gbc, IxyValue);
        addComboBox(5, 7, gbc, IxyValueComboBox);
        
        addLabel("Point Mass", 0, 8, gbc);
        
        
        //ArrayList<Pointmass> pointMassArrayList = new ArrayList<Pointmass>();
        
        
        //pointMassListModel.addAll(pointMassArrayList);
        //pointMassListModel.addElement(massBalance);
        
        

        
        
        cfg = XMLDataLoader.loadXMLData(this.fileName);
        
        massBalance = (MassBalance) cfg.getMassBalance();
        
        emptyWeightTextField.setText(String.valueOf(massBalance.getEmptywt().getValue()));
        emptyWeightComboBox.addItem(massBalance.getEmptywt().getUnit().toString());
        
        locationXvalue.setText(String.valueOf(massBalance.getLocation().getX()));
        locationYvalue.setText(String.valueOf(massBalance.getLocation().getY()));
        locationZvalue.setText(String.valueOf(massBalance.getLocation().getZ()));
        
        locationUnitComboBox.addItem(massBalance.getLocation().getUnit().toString());
        
        IxxValue.setText(String.valueOf(massBalance.getIxx().getValue()));
        IyyValue.setText(String.valueOf(massBalance.getIyy().getValue()));
        IzzValue.setText(String.valueOf(massBalance.getIzz().getValue()));
        
        IxzValue.setText(String.valueOf(massBalance.getIxz().getValue()));
        IyzValue.setText(String.valueOf(massBalance.getIyz().getValue()));
        IxyValue.setText(String.valueOf(massBalance.getIxy().getValue()));
        
        List<Pointmass> pointMassList = massBalance.getPointmass();
        ArrayList<PointMass> pointMassArrayList = new ArrayList<PointMass>();
        for(Pointmass pm : pointMassList)
        {
            pointMassArrayList.add(new PointMass(
            pm.getName(),
            pm.getWeight().getValue(),
            pm.getWeight().getUnit().toString(),
            pm.getLocation().getX(),
            pm.getLocation().getY(),
            pm.getLocation().getZ(),
            pm.getLocation().getUnit().toString()));
            
        }
        
        pointMassListModel.addAll(pointMassArrayList);
        JList<PointMass> pointMassJList = new JList<>(pointMassListModel);
        
        JScrollPane listScrollPane = new JScrollPane(pointMassJList);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 7;
        gbc.fill = GridBagConstraints.BOTH;
        add(listScrollPane, gbc);
        
        JButton addButton = new JButton("Add a new Point Mass");
        JButton removeButton = new JButton("Remove selected Point Mass");
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(addButton, gbc);
        
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        add(removeButton, gbc);
        
    }
    private void addLabel(String text, int x, int y, GridBagConstraints gbc) 
    {
        gbc.gridx = x;
        gbc.gridy = y;
        add(new JLabel(text),gbc);
    }
    private void addTextInput(int x, int y, int width, int height, GridBagConstraints gbc, JTextField tf) 
    {
        gbc.gridx = x;
        gbc.gridy = y;
        
        gbc.gridwidth = width;
        gbc.gridheight = height;
        
        add(tf, gbc);
        
    }
    private void addComboBox(int x, int y, GridBagConstraints gbc, JComboBox<String> cb) 
    {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        //gbc.weightx = 0.5;
        //gbc.weighty = 0;
        add(cb, gbc);
    }
    private void addTextArea(JPanel panel, int width, int height)
    {
        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(width, height));
        textArea.setBackground(Color.decode("#FFFFFF"));
        textArea.setForeground(Color.decode("#000000"));
        textArea.setBorder(BorderFactory.createLineBorder(Color.decode("#232323"), 1));
        textArea.setMargin(new Insets(4, 8, 4, 8));
        textArea.setFont(new Font("Helvetica", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        panel.add(textArea);
    }
    private void addButton(JPanel panel, String text, int width) 
    {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(width, 32));
        button.setBackground(Color.decode("#EBEBEB"));
        button.setForeground(Color.decode("#232323"));
        button.setBorder(BorderFactory.createLineBorder(Color.decode("#232323"), 1));
        button.setFont(new Font("Helvetica", Font.PLAIN, 14));
        panel.add(button);
    }
    protected void onAddclick()
    {
    
    }
    
    
    private JTextField emptyWeightTextField;
    private JTextField locationXvalue;
    private JTextField locationYvalue;
    private JTextField locationZvalue;
    private JTextField IxxValue;
    private JTextField IyyValue;
    private JTextField IzzValue;
    private JTextField IxzValue;
    private JTextField IyzValue;
    private JTextField IxyValue;
    private FdmConfig cfg;
    private MassBalance massBalance;
    private File fileName;
    
    private JComboBox<String> IxxValueComboBox = new JComboBox<>(new String[]{"KG*M2"});
    private JComboBox<String> IyyValueComboBox = new JComboBox<>(new String[]{"KG*M2"});
    private JComboBox<String> IzzValueComboBox = new JComboBox<>(new String[]{"KG*M2"});
    private JComboBox<String> IxzValueComboBox = new JComboBox<>(new String[]{"KG*M2"});
    private JComboBox<String> IyzValueComboBox = new JComboBox<>(new String[]{"KG*M2"});
    private JComboBox<String> IxyValueComboBox = new JComboBox<>(new String[]{"KG*M2"});
    private JComboBox<String> emptyWeightComboBox = new JComboBox<>(new String[]{"KG", "N"});
    private JComboBox<String> locationUnitComboBox = new JComboBox<>(new String[]{"M", "FT"});
    private DefaultListModel<PointMass> pointMassListModel = new DefaultListModel<PointMass>();
}
