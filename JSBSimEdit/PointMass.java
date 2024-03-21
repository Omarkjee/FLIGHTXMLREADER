package uta.cse.cse3310.JSBSimEdit;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
public class PointMass extends JDialog
{
    public PointMass(String name, Double weight, String weightUnit, Double x, Double y, Double z, String locUnit)
    { 
        this.name = name;
        if(weight != null)
        {
            this.weight = weight;
        } 
        else
        { 
            this.weight = 0.0;
        }
        this.weightUnit = weightUnit;
        this.x = x;
        this.y = y;
        this.z = z;
        this.locUnit = locUnit;
    }
    @Override
    public String toString()
    { //since each PointMass Object will be displayed in a JList, I want a specific format for printing it out
        StringBuilder sb = new StringBuilder();
        sb.append(name + " is ");
        sb.append(weight + " ");
        sb.append(weightUnit + " at point ");
        sb.append("[" + x + ", " + y + ", " + z + "] in ");
        sb.append(locUnit);
        
        return sb.toString();
    }
    private String name, weightUnit, locUnit;
    private Double weight, x, y, z;

}
