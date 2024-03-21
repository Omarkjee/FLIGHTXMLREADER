package uta.cse.cse3310.JSBSimEdit;

import javax.swing.*;
import java.awt.*;
import generated.FdmConfig;
import java.io.File;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.Marshaller;
import generated.Metrics;
import generated.Location;
import generated.LengthType;
import generated.AngleType;
import generated.AreaType;
import java.util.List;

public class MetricsTab extends JPanel implements Saveable
{

    
    
    public MetricsTab(File fileName) 
    {
        this.fileName = fileName;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        
        gbc.insets = new Insets(2, 2, 2, 2);
        

        // Add components
        addLabel("wingarea(*)", 0, 0, gbc);
        wingAreaTextField = new JTextField(10);
        addTextField(1, 0, 1, 1, gbc, wingAreaTextField);
        addComboBox(3, 0, gbc, wingAreaComboBox);
        
        addLabel("wingspan(*)", 0, 1, gbc);
        wingSpanTextField = new JTextField(10);
        addTextField(1, 1, 1, 1, gbc, wingSpanTextField);
        addComboBox(3, 1, gbc, wingSpanComboBox);
        
        addLabel("chord(*)", 0, 2, gbc);
        chordTextField = new JTextField(10);
        addTextField(1, 2, 1, 1, gbc, chordTextField);
        addComboBox(3, 2, gbc, chordComboBox);
        
        addLabel("wing incidence", 0, 3, gbc);
        wingIncidenceTextField = new JTextField(10);
        addTextField(1, 3, 1, 1, gbc, wingIncidenceTextField);
        addComboBox(3, 3, gbc, wingIncidenceComboBox);
        
        addLabel("htailarea", 4, 0, gbc);
        hTailAreaTextField = new JTextField(10);
        addTextField(5, 0, 1, 1, gbc, hTailAreaTextField);
        addComboBox(6, 0, gbc, hTailAreaComboBox);
        
        addLabel("htailarm", 4, 1, gbc);
        hTailArmTextField = new JTextField(10);
        addTextField(5, 1, 1, 1, gbc, hTailArmTextField);
        addComboBox(6, 1, gbc, hTailArmComboBox);
        
        addLabel("vtailarea", 4, 2, gbc);
        vTailAreaTextField = new JTextField(10);
        addTextField(5, 2, 1, 1, gbc, vTailAreaTextField);
        addComboBox(6, 2, gbc, vTailAreaComboBox);
        
        addLabel("vtailarm", 4, 3, gbc);
        vTailArmTextField = new JTextField(10);
        addTextField(5, 3, 1, 1, gbc, vTailArmTextField);
        addComboBox(6, 3, gbc, vTailArmComboBox);
        
        addLabel("Aerodynamic Reference Point(*)", 0, 4, gbc);
        addLabel("x=", 0, 5, gbc);
        arpXvalue = new JTextField(5);
        addTextField(1, 5, 1, 1, gbc, arpXvalue);
        addLabel("y=", 2, 5, gbc);
        arpYvalue = new JTextField(5);
        addTextField(3, 5, 1, 1, gbc, arpYvalue);
        addLabel("z=", 4, 5, gbc);
        arpZvalue = new JTextField(5);
        addTextField(5, 5, 1, 1, gbc, arpZvalue);
        addComboBox(6, 5, gbc, arpUnitComboBox);
        
        addLabel("Eye Point", 0, 6, gbc);
        addLabel("x=", 0, 7, gbc);
        eyepointXvalue = new JTextField(5);
        addTextField(1, 7, 1, 1, gbc, eyepointXvalue);
        addLabel("y=", 2, 7, gbc);
        eyepointYvalue = new JTextField(5);
        addTextField(3, 7, 1, 1, gbc, eyepointYvalue);
        addLabel("z=", 4, 7, gbc);
        eyepointZvalue = new JTextField(5);
        addTextField(5, 7, 1, 1, gbc, eyepointZvalue);
        addComboBox(6, 7, gbc, eyepointUnitComboBox);
        
        addLabel("Visual Reference Point", 0, 8, gbc);
        addLabel("x=", 0, 9, gbc);
        vrpXvalue = new JTextField(5);
        addTextField(1, 9, 1, 1, gbc, vrpXvalue);
        addLabel("y=", 2, 9, gbc);
        vrpYvalue = new JTextField(5);
        addTextField(3, 9, 1, 1, gbc, vrpYvalue);
        addLabel("z=", 4, 9, gbc);
        vrpZvalue = new JTextField(5);
        addTextField(5, 9, 1, 1, gbc, vrpZvalue);
        addComboBox(6, 9, gbc, vrpUnitComboBox);
        
        
        
        
        
        cfg = XMLDataLoader.loadXMLData(this.fileName);
        
        metrics = (Metrics) cfg.getMetrics();
        
        wingAreaTextField.setText(String.valueOf(metrics.getWingarea().getValue()));
        wingAreaComboBox.addItem(metrics.getWingarea().getUnit().toString());
        
        wingSpanTextField.setText(String.valueOf(metrics.getWingspan().getValue()));
        wingSpanComboBox.addItem(metrics.getWingspan().getUnit().toString());
        
        chordTextField.setText(String.valueOf(metrics.getChord().getValue()));
        chordComboBox.addItem(metrics.getChord().getUnit().toString());
        
        /*
        Threw a null pointer when ran with the f16 file. This if statement is for other xml files 
        that may have wing incidence data
        */
        if (metrics.getWingIncidence() != null) 
        {
            wingIncidenceTextField.setText(String.valueOf(metrics.getWingIncidence().getValue()));
            wingIncidenceComboBox.addItem(metrics.getWingIncidence().getUnit().toString());
        }
        
        hTailAreaTextField.setText(String.valueOf(metrics.getHtailarea().getValue()));
        hTailAreaComboBox.addItem(metrics.getHtailarea().getUnit().toString());
        hTailArmTextField.setText(String.valueOf(metrics.getHtailarm().getValue()));
        hTailArmComboBox.addItem(metrics.getHtailarm().getUnit().toString());
        vTailAreaTextField.setText(String.valueOf(metrics.getVtailarea().getValue()));
        vTailAreaComboBox.addItem(metrics.getVtailarea().getUnit().toString());
        vTailArmTextField.setText(String.valueOf(metrics.getVtailarm().getValue()));
        vTailArmComboBox.addItem(metrics.getVtailarm().getUnit().toString());
        
        List<Location> locations = metrics.getLocation();
        
        if(locations.size() > 0)
        {
            arpXvalue.setText(String.valueOf(locations.get(0).getX()));
            arpYvalue.setText(String.valueOf(locations.get(0).getY()));
            arpZvalue.setText(String.valueOf(locations.get(0).getZ()));
            arpUnitComboBox.addItem(locations.get(0).getUnit());
        }
        if(locations.size() > 1)
        {
            eyepointXvalue.setText(String.valueOf(locations.get(1).getX()));
            eyepointYvalue.setText(String.valueOf(locations.get(1).getY()));
            eyepointZvalue.setText(String.valueOf(locations.get(1).getZ()));
            eyepointUnitComboBox.addItem(locations.get(1).getUnit());
            
        }
        if(locations.size() > 2)
        {
            vrpXvalue.setText(String.valueOf(locations.get(2).getX()));
            vrpYvalue.setText(String.valueOf(locations.get(2).getY()));
            vrpZvalue.setText(String.valueOf(locations.get(2).getZ()));
            vrpUnitComboBox.addItem(locations.get(2).getUnit());
        }
        
        
        
        
    }
    private void addLabel(String text, int x, int y, GridBagConstraints gbc) 
    {
        gbc.gridx = x;
        gbc.gridy = y;
        add(new JLabel(text), gbc);
    }
    private void addTextField(int x, int y, int width, int height, GridBagConstraints gbc, JTextField tf) 
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
        add(cb, gbc);
    }
    @Override
    public void saveChangestoXML(File toFileDestination)
    {
        metrics.getWingarea().setValue(Double.parseDouble(wingAreaTextField.getText()));
        metrics.getWingarea().setUnit(AreaType.fromValue(wingAreaComboBox.getSelectedItem().toString()));
        
        metrics.getWingspan().setValue(Double.parseDouble(wingSpanTextField.getText()));
        metrics.getWingspan().setUnit(LengthType.fromValue(wingSpanComboBox.getSelectedItem().toString()));
        
        metrics.getChord().setValue(Double.parseDouble(chordTextField.getText()));
        metrics.getChord().setUnit(LengthType.fromValue(chordComboBox.getSelectedItem().toString()));
        
        if(metrics.getWingIncidence() != null)
        {
            metrics.getWingIncidence().setValue(Double.parseDouble(wingIncidenceTextField.getText()));
            metrics.getWingIncidence().setUnit(AngleType.fromValue(wingIncidenceComboBox.getSelectedItem().toString()));
        }
        
        metrics.getHtailarea().setValue(Double.parseDouble(hTailAreaTextField.getText()));
        metrics.getHtailarea().setUnit(AreaType.fromValue(hTailAreaComboBox.getSelectedItem().toString()));
        
        metrics.getHtailarm().setValue(Double.parseDouble(hTailArmTextField.getText()));
        metrics.getHtailarm().setUnit(LengthType.fromValue(hTailArmComboBox.getSelectedItem().toString()));
        
        metrics.getVtailarea().setValue(Double.parseDouble(vTailAreaTextField.getText()));
        metrics.getVtailarea().setUnit(AreaType.fromValue(vTailAreaComboBox.getSelectedItem().toString()));
        
        metrics.getVtailarm().setValue(Double.parseDouble(vTailAreaTextField.getText()));
        metrics.getVtailarm().setUnit(LengthType.fromValue(vTailAreaComboBox.getSelectedItem().toString()));
        
        List<Location> location = metrics.getLocation();
        location.clear();
        Location arpLocation = new Location();
        
        arpLocation.setX(Double.parseDouble(arpXvalue.getText()));
        arpLocation.setY(Double.parseDouble(arpYvalue.getText()));
        arpLocation.setZ(Double.parseDouble(arpZvalue.getText()));
        arpLocation.setUnit(arpUnitComboBox.getSelectedItem().toString());
        location.add(arpLocation);
        
        Location eyepointLocation = new Location();
        
        eyepointLocation.setX(Double.parseDouble(eyepointXvalue.getText()));
        eyepointLocation.setY(Double.parseDouble(eyepointYvalue.getText()));
        eyepointLocation.setZ(Double.parseDouble(eyepointZvalue.getText()));
        eyepointLocation.setUnit(eyepointUnitComboBox.getSelectedItem().toString());
        location.add(eyepointLocation);
        
        Location vrpLocation = new Location();
        
        vrpLocation.setX(Double.parseDouble(vrpXvalue.getText()));
        vrpLocation.setY(Double.parseDouble(vrpYvalue.getText()));
        vrpLocation.setZ(Double.parseDouble(vrpZvalue.getText()));
        vrpLocation.setUnit(vrpUnitComboBox.getSelectedItem().toString());
        location.add(eyepointLocation);         
    }
    private Metrics metrics;
    private FdmConfig cfg;
    private File fileName;
    private JTextField wingAreaTextField;
    private JTextField wingSpanTextField;
    private JTextField chordTextField;
    private JTextField wingIncidenceTextField;
    private JTextField hTailAreaTextField;
    private JTextField hTailArmTextField;
    private JTextField vTailAreaTextField;
    private JTextField vTailArmTextField;
    private JTextField arpXvalue;
    private JTextField arpYvalue;
    private JTextField arpZvalue;
    private JTextField eyepointXvalue;
    private JTextField eyepointYvalue;
    private JTextField eyepointZvalue;
    private JTextField vrpXvalue;
    private JTextField vrpYvalue;
    private JTextField vrpZvalue;
    private JComboBox<String> wingAreaComboBox = new JComboBox<>(new String[]{"M_2"});
    private JComboBox<String> wingSpanComboBox = new JComboBox<>(new String[]{"M"});
    private JComboBox<String> chordComboBox = new JComboBox<>(new String[]{"M"});
    private JComboBox<String> wingIncidenceComboBox = new JComboBox<>();
    private JComboBox<String> hTailAreaComboBox = new JComboBox<>(new String[]{"M_2"});
    private JComboBox<String> hTailArmComboBox = new JComboBox<>(new String[]{"M"});
    private JComboBox<String> vTailAreaComboBox = new JComboBox<>(new String[]{"M_2"});
    private JComboBox<String> vTailArmComboBox = new JComboBox<>(new String[]{"M"});
    private JComboBox<String> arpUnitComboBox = new JComboBox<>(new String[]{"M", "FT"});
    private JComboBox<String> eyepointUnitComboBox = new JComboBox<>(new String[]{"M", "FT"});
    private JComboBox<String> vrpUnitComboBox = new JComboBox<>(new String[]{"M", "FT"});
      
}

