package uta.cse.cse3310.JSBSimEdit;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
public class FlightControlTab extends JPanel
{
    public FlightControlTab()
    {
        tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        JPanel pitchTab = new JPanel();
        tabbedPane.addTab("Pitch", pitchTab);
        
        add(tabbedPane, BorderLayout.CENTER);
        
        JButton pitchButton = new JButton(new ImageIcon("JSBSimEdit/summer.bmp"));
        
        add(pitchButton);
    }
    private JTabbedPane tabbedPane;
}
