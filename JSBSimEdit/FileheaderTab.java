package uta.cse.cse3310.JSBSimEdit;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ListModel;
import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;



import generated.FdmConfig;
import generated.Fileheader;
import generated.Reference;
import java.io.File;
import java.util.List;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.Marshaller;
import java.io.FileOutputStream;

public class FileheaderTab extends JPanel implements Saveable
{

    
    public FileheaderTab(File fileName) 
    {
        this.fileName = fileName;
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints(); // this is causing me problems. Having a hard time adjusting the size of individual text fields
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Padding for top, left, bottom, and right respectively

        // First row
        addLabel("Aircraft Name", 0, 0, gbc);
        aircraftTextField = new JTextField();
        addTextField(1, 0, 1, 1, gbc, aircraftTextField, GridBagConstraints.BOTH);
        addLabel("File Name", 3, 0, gbc);
        filenameTextField = new JTextField();
        addTextField(4, 0, 2, 1, gbc, filenameTextField, GridBagConstraints.BOTH);

        // Second row
        String[] rlsLevels = {"BETA", "ALPHA", "PRODUCTION"}; 
        addLabel("Release Level", 0, 1, gbc);
        releaseLevelComboBox = new JComboBox<>(rlsLevels);
        addComboBox(1, 1, gbc, releaseLevelComboBox);
        addLabel("Config Version", 2, 1, gbc);
        configTextField = new JTextField();
        addTextField(3, 1, 1, 1, gbc, configTextField, GridBagConstraints.BOTH);
        addLabel("Flight Model Version", 4, 1, gbc);
        flightVersionTextField = new JTextField();
        addTextField(5, 1, 1, 1, gbc, flightVersionTextField, GridBagConstraints.BOTH);

        // Third row
        addLabel("Author", 0, 2, gbc);
        authorTextField = new JTextField();
        addTextField(1, 2, 2, 1, gbc, authorTextField, GridBagConstraints.BOTH);
        addLabel("Email", 3, 2, gbc);
        emailTextField = new JTextField();
        addTextField(4, 2, 2, 1, gbc, emailTextField, GridBagConstraints.BOTH);

        // Fourth row
        addLabel("Organization", 0, 3, gbc);
        organizationTextArea = new JTextArea(5,20);
        addTextArea(1, 3, 2, 2, gbc, organizationTextArea, GridBagConstraints.BOTH);
        addLabel("Description", 3, 3, gbc);
        descriptionTextArea = new JTextArea(5,20);
        addTextArea(4, 3, 2, 2, gbc, descriptionTextArea, GridBagConstraints.BOTH);

        // Fifth row (used by text areas of Fourth row)

        // Sixth row
        addLabel("File Date", 0, 5, gbc);
        fileDateTextField = new JTextField();
        addTextField(1, 5, 2, 1, gbc, fileDateTextField, GridBagConstraints.BOTH);
        
        addLabel("License", 3, 5, gbc);
        licenseTextField = new JTextField();
        addTextField(4, 5, 2, 1, gbc, licenseTextField, GridBagConstraints.BOTH);
        
        // Seventh row - Table and other components
        String[] columns = {"Ref ID", "Author", "Title", "Date"};
        referenceTable = new JTable();
        JScrollPane scrollPane = new JScrollPane();
        
        referenceTable.setModel(new DefaultTableModel(new Object[][]{}, columns));
        scrollPane.setViewportView(referenceTable);
        
          
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 6;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(scrollPane, gbc);
        
        

        // Eighth row (used by table)

        // Ninth row
        addLabel("Limitations", 0, 8, gbc);
        limitationsTextArea = new JTextArea(5, 20);
        addTextArea(1, 8, 5, 1, gbc, limitationsTextArea, GridBagConstraints.BOTH);

        // Tenth row
        addLabel("Notes", 0, 9, gbc);
        notesTextArea = new JTextArea(5, 20);
        addTextArea(1, 9, 5, 1, gbc, notesTextArea, GridBagConstraints.BOTH);
        
        //file = new File("f16.xml");
        cfg = XMLDataLoader.loadXMLData(this.fileName); 
        //loadXMLData("f16.xml"); //load data from the xml
        
        aircraftTextField.setText(cfg.getName()); // attempt to get the aircraft name
        filenameTextField.setText(this.fileName.getAbsolutePath()); // reads succesfully, its just that the text field is too small
        releaseLevelComboBox.addItem(cfg.getRelease());
        configTextField.setText(cfg.getVersion()); // reads succesfully, its just that the text field is too small
        
        fileheader = (Fileheader) cfg.getFileheader();
        
        flightVersionTextField.setText(fileheader.getVersion());
        
        List<JAXBElement<String>> aeo = fileheader.getAuthorOrEmailOrOrganization();
        for(JAXBElement<String> element : aeo)
        {
            String val = element.getValue();
            if(element.getName().getLocalPart().equals("author"))
            {
                authorTextField.setText(val);
            }
            else if(element.getName().getLocalPart().equals("email"))
            {
                emailTextField.setText(val);
            }
            else if(element.getName().getLocalPart().equals("organization"))
            {
                organizationTextArea.setText(val);
            }
        }
        
        descriptionTextArea.setText(fileheader.getDescription());
        fileDateTextField.setText(fileheader.getFilecreationdate().toString());
        //System.out.println(fileheader.getLicense().getLicenseName());
        licenseTextField.setText(fileheader.getLicense().getLicenseName());
        
        List<Object> nlr = fileheader.getNoteOrLimitationOrReference();
        
        
        for(var element : nlr)
        {
            if(element instanceof JAXBElement<?>)
            {
                JAXBElement<String> el = (JAXBElement<String>) element;
                String value = (String) el.getValue();
                if(el.getName().getLocalPart().equals("limitation"))
                {
                    limitationsTextArea.setText(value);
                }
                else if(el.getName().getLocalPart().equals("note"))
                {
                    notesTextArea.setText(value);
                }
            }
            else if(element instanceof Reference)
            {
                Reference r = (Reference) element;
                DefaultTableModel model = (DefaultTableModel) referenceTable.getModel();
                model.setRowCount(0);
				model.addRow(new Object[]{
					r.getRefID(), r.getTitle(), r.getAuthor(), r.getDate(), r.getURL()
				});
            }
            
        }
        
        
       
      
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
/*
    private void addTextField(int x, int y, GridBagConstraints gbc, JTextField tf) {
        addTextField(x, y, 1, 1, gbc, tf);
    }
*/
    private void addComboBox(int x, int y, GridBagConstraints gbc, JComboBox<String> cb) 
    {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0;
        add(cb, gbc);
    }

    private void addTextArea(int x, int y, int width, int height, GridBagConstraints gbc, JTextArea ta, int fillValue) 
    {
        
        JScrollPane scrollPane = new JScrollPane(ta);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = fillValue;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(scrollPane, gbc);
    }
    @Override
    public void saveChangestoXML(File toFileDestination)
    {
        
        
        cfg.setName(aircraftTextField.getText());
        cfg.setRelease(releaseLevelComboBox.getSelectedItem().toString());
        cfg.setVersion(configTextField.getText());
        fileheader.setVersion(flightVersionTextField.getText());
        fileheader.setDescription(descriptionTextArea.getText());
        try
        {
            JAXBContext jc = JAXBContext.newInstance("generated");
            Marshaller m = jc.createMarshaller();
            m.setProperty("jaxb.formatted.output", true);
            m.marshal(cfg, new FileOutputStream(toFileDestination));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        
    }
    
    private JTextField aircraftTextField;
    private JTextField filenameTextField;
    private JComboBox<String> releaseLevelComboBox;
    private JTextField configTextField;
    private JTextField flightVersionTextField;
    private JTextField authorTextField;
    private JTextField emailTextField;
    private JTextField licenseTextField;
    private JTextArea organizationTextArea;
    private JTextArea descriptionTextArea;
    private JTextField fileDateTextField;
    private JTable referenceTable;
    private JTextArea limitationsTextArea;
    private JTextArea notesTextArea;
    private Fileheader fileheader;
    private FdmConfig cfg;
    private File fileName;
   
}


