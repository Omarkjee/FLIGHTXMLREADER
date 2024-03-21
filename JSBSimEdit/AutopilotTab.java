package uta.cse.cse3310.JSBSimEdit;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AutopilotTab extends JPanel
{
    public AutopilotTab()
    {
        setLayout(new GridLayout(6, 2, 10, 10));
        
        autopilotField = new JTextField();
        refPropertyField = new JTextField();
        refSensorField = new JTextField();
        refChannelField = new JTextField();
        fileField = new JTextField();
        nameField = new JTextField();
        
        add(new JLabel("Autopilot"));
        add(autopilotField);
        add(new JLabel("ref.property"));
        add(refPropertyField);
        add(new JLabel("file(string)(optional)"));
        add(fileField);
        add(new JLabel("ref.sensor"));
        add(refSensorField);
        add(new JLabel("name(string)(optional)"));
        add(nameField);
        add(new JLabel("ref.channel"));
        add(refChannelField);
    }
    private JTextField autopilotField;
    private JTextField refPropertyField;
    private JTextField refSensorField;
    private JTextField refChannelField;
    private JTextField fileField;
    private JTextField nameField;
}
