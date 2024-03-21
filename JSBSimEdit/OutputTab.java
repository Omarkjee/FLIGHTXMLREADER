package uta.cse.cse3310.JSBSimEdit;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.BorderFactory;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;


public class OutputTab extends JPanel
{
    public OutputTab(File fileName)
    {
        setLayout(new FlowLayout());
        
        JLabel nameLabel = createLabel("Name", "Helvetica", 14, "#232323");
        JTextField textInput1 = createTextField(180, 32, "Helvetica", 14, "#C0C0C0", "#232323");
        JLabel typeLabel = createLabel("Type", "Helvetica", 14, "#232323");
        JComboBox<String> comboBox1 = createComboBox(180, 32, "Helvetica", 14, "#232323", "#EBEBEB");
        JLabel rateLabel = createLabel("Rate", "Helvetica", 14, "#232323");
        JTextField textInput2 = createTextField(180, 32, "Helvetica", 14, "#C0C0C0", "#232323");
        JCheckBox checkbox1 = createCheckBox("simulation", "Helvetica", 14, "#232323", "#FFFFFF");
        JCheckBox checkbox2 = createCheckBox("atmosphere", "Helvetica", 14, "#232323", "#FFFFFF");
        JCheckBox checkbox3 = createCheckBox("massprops", "Helvetica", 14, "#232323", "#FFFFFF");
        JCheckBox checkbox4 = createCheckBox("aerosurfaces", "Helvetica", 14, "#232323", "#FFFFFF");
        JCheckBox checkbox5 = createCheckBox("rates", "Helvetica", 14, "#232323", "#FFFFFF");
        JCheckBox checkbox6 = createCheckBox("velocities", "Helvetica", 14, "#232323", "#FFFFFF");
        JCheckBox checkbox7 = createCheckBox("forces", "Helvetica", 14, "#232323", "#FFFFFF");
        JCheckBox checkbox8 = createCheckBox("moments", "Helvetica", 14, "#232323", "#FFFFFF");
        JCheckBox checkbox9 = createCheckBox("position", "Helvetica", 14, "#232323", "#FFFFFF");
        JCheckBox checkbox10 = createCheckBox("coefficients", "Helvetica", 14, "#232323", "#FFFFFF");
        JCheckBox checkbox11 = createCheckBox("ground reactions", "Helvetica", 14, "#232323", "#FFFFFF");
        JCheckBox checkbox12 = createCheckBox("FCS", "Helvetica", 14, "#232323", "#FFFFFF");
        JCheckBox checkbox13 = createCheckBox("propulsion", "Helvetica", 14, "#232323", "#FFFFFF");
        
        add(nameLabel);
        add(textInput1);
        add(typeLabel);
        add(comboBox1);
        add(rateLabel);
        add(textInput2);
        add(checkbox1);
        add(checkbox2);
        add(checkbox3);
        add(checkbox4);
        add(checkbox5);
        add(checkbox6);
        add(checkbox7);
        add(checkbox8);
        add(checkbox9);
        add(checkbox10);
        add(checkbox11);
        add(checkbox12);
        add(checkbox13);
    }
    private JLabel createLabel(String text, String fontFamily, int fontSize, String color) 
    {
        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(47, 19));
        label.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
        label.setForeground(Color.decode(color));
        return label;
    }

    private JTextField createTextField(int width, int height, String fontFamily, int fontSize, String textColor, String borderColor) 
    {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(width, height));
        textField.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
        textField.setForeground(Color.decode(textColor));
        textField.setBorder(BorderFactory.createLineBorder(Color.decode(borderColor), 1));
        return textField;
    }

    private JComboBox<String> createComboBox(int width, int height, String fontFamily, int fontSize, String textColor, String backgroundColor) 
    {
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setPreferredSize(new Dimension(width, height));
        comboBox.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
        comboBox.setForeground(Color.decode(textColor));
        comboBox.setBackground(Color.decode(backgroundColor));
        comboBox.setBorder(BorderFactory.createLineBorder(Color.decode("#232323"), 1));
        return comboBox;
    }

    private JCheckBox createCheckBox(String text, String fontFamily, int fontSize, String textColor, String backgroundColor) 
    {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
        checkBox.setForeground(Color.decode(textColor));
        checkBox.setBackground(Color.decode(backgroundColor));
        //checkBox.setBorder(BorderFactory.createLineBorder(Color.decode("#232323"), 1.5));
        return checkBox;
    }
}
