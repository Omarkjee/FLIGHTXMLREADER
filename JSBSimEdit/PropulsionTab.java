package uta.cse.cse3310.JSBSimEdit;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;


public class PropulsionTab extends JPanel
{
    public PropulsionTab()
    {
        setLayout(new GridLayout(1, 4));
        
        JPanel availableEnginesPanel = createListPanel("Available Engines:");
        JPanel availableThrustersPanel = createListPanel("Available Thrusters:");
        JPanel subscribedEnginesPanel = createListPanel("Subscribed Engines:");
        JPanel tanksPanel = createListPanel("Tanks:");
        
        add(availableEnginesPanel);
        add(availableThrustersPanel);
        add(subscribedEnginesPanel);
        add(tanksPanel);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));

        JButton newPairButton = new JButton("New Pair");
        JButton deletePairButton = new JButton("Delete Pair");
        JButton detailPairButton = new JButton("Detail Pair");
        JButton newTankButton = new JButton("New Tank");
        JButton deleteTankButton = new JButton("Delete Tank");
        JButton detailTankButton = new JButton("Detail Tank");
        
        buttonPanel.add(newPairButton);
        buttonPanel.add(deletePairButton);
        buttonPanel.add(detailPairButton);
        buttonPanel.add(newTankButton);
        buttonPanel.add(deleteTankButton);
        buttonPanel.add(detailTankButton);
        
        
        add(buttonPanel, BorderLayout.EAST);
    }
    private JPanel createListPanel(String title) 
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }    
    
}
