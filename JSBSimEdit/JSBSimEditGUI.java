package uta.cse.cse3310.JSBSimEdit;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.awt.Component;

public class JSBSimEditGUI extends JFrame
{
    public JSBSimEditGUI()
    {
        super("JSBSimEdit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        add(tabbedPane, BorderLayout.CENTER);
       
        // Adding buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton openButton = new JButton("Open a file");
        JButton saveButton = new JButton("Save a file");
        
        openButton.addActionListener(event -> onOpenClick());
        saveButton.addActionListener(event -> onSaveClick());
        
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.NORTH);

        setSize(800, 600);
        setVisible(true);    
    }
    
    protected void onOpenClick()
    {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter xmlFilter = new FileNameExtensionFilter("XML files", "xml");
        fc.addChoosableFileFilter(xmlFilter);
        fc.setFileFilter(xmlFilter);
        
        int choice = fc.showOpenDialog(this);
        if(choice == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fc.getSelectedFile();
            tabbedPane.removeAll();
            
            String[] tabNames = {"Fileheader", "Metrics", "Mass Balance", "Ground Reactions", "External Reactions"
                 , "Propulsion", "System", "Autopilot", "Flight Control", "Aerodynamics", "Input", "Output"};
            for (String tabName : tabNames) 
            {
                JPanel panel = null;
                
                switch(tabName)
                {
                    case "Fileheader":
                        panel = new FileheaderTab(selectedFile);
                        break;
                    case "Metrics":
                        panel = new MetricsTab(selectedFile);
                        break;
                    case "Mass Balance":
                        panel = new MassBalanceTab();
                        break;
                    case "Ground Reactions":
                        panel = new GroundReactionsTab();
                        break;
                    case "External Reactions":
                        panel = new ExternalReactionsTab(selectedFile);
                        break;
                    case "Propulsion":
                        panel = new PropulsionTab();
                        break;
                    case "System":
                        panel = new SystemTab(selectedFile);
                        break;
                    case "Autopilot":
                        panel = new AutopilotTab();
                        break;
                    case "Flight Control":
                        panel = new FlightControlTab();
                        break;
                    case "Aerodynamics":
                        panel = new AerodynamicsTab();
                        break;
                    case "Input":
                        panel = new InputTab();
                        break;
                    case "Output":
                        panel = new OutputTab(selectedFile);
                        break;
                    default:
                        System.out.println("Not a tab");
                        break;                                   
                                    
                }
                
                tabbedPane.addTab(tabName, panel);
            }
            tabbedPane.setFont(new Font("Serif", Font.PLAIN, 13)); // Adjust the tab font size here

            this.revalidate();
            this.repaint();
        }    
    }
    protected void onSaveClick()
    {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter xmlFilter = new FileNameExtensionFilter("XML files", "xml");
        fc.addChoosableFileFilter(xmlFilter);
        fc.setFileFilter(xmlFilter);
        
        int choice = fc.showSaveDialog(this);
        
        if(choice == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fc.getSelectedFile();
            
            Component selectedTab = tabbedPane.getSelectedComponent();
            if(selectedTab instanceof Saveable)
            {
                ((Saveable) selectedTab).saveChangestoXML(selectedFile);
            }
        }
        
        
            
    }
    private JTabbedPane tabbedPane;
}
