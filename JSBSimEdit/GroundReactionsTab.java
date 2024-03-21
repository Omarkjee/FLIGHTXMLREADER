package uta.cse.cse3310.JSBSimEdit;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;

public class GroundReactionsTab extends JPanel 
{
    public GroundReactionsTab()
    {
        setLayout(new FlowLayout());
        
        JTextArea textArea1 = new JTextArea();
        textArea1.setPreferredSize(new Dimension(609, 389));
        textArea1.setMargin(new Insets(4, 8, 4, 8));
        textArea1.setBackground(Color.WHITE);
        textArea1.setForeground(Color.decode("#C0C0C0"));
        textArea1.setBorder(BorderFactory.createLineBorder(Color.decode("#232323"), 1));
        textArea1.setFont(new Font("Helvetica", Font.PLAIN, 14));
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);

        JButton button1 = new JButton("ADD");
        button1.setPreferredSize(new Dimension(120, 32));
        button1.setMargin(new Insets(0, 10, 0, 10));
        button1.setBackground(Color.decode("#EBEBEB"));
        button1.setForeground(Color.decode("#232323"));
        button1.setBorder(BorderFactory.createLineBorder(Color.decode("#232323"), 1));
        button1.setFont(new Font("Helvetica", Font.PLAIN, 14));

        JButton button2 = new JButton("DELETE");
        button2.setPreferredSize(new Dimension(120, 32));
        button2.setMargin(new Insets(0, 10, 0, 10));
        button2.setBackground(Color.decode("#EBEBEB"));
        button2.setForeground(Color.decode("#232323"));
        button2.setBorder(BorderFactory.createLineBorder(Color.decode("#232323"), 1));
        button2.setFont(new Font("Helvetica", Font.PLAIN, 14));
        
        JButton button3 = new JButton("DETAIL");
        button3.setPreferredSize(new Dimension(120, 32));
        button3.setMargin(new Insets(0, 10, 0, 10));
        button3.setBackground(Color.decode("#EBEBEB"));
        button3.setForeground(Color.decode("#232323"));
        button3.setBorder(BorderFactory.createLineBorder(Color.decode("#232323"), 1));
        button3.setFont(new Font("Helvetica", Font.PLAIN, 14));
        
        add(textArea1);
        add(button1);
        add(button2);
        add(button3);
    }   
}
