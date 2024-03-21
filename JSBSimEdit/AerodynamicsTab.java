package uta.cse.cse3310.JSBSimEdit;
import javax.swing.JTree;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;

public class AerodynamicsTab extends JPanel
{
    public AerodynamicsTab()
    {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("aerodynamics");
        
        root.add(new DefaultMutableTreeNode("function(kl/ccg/Change_in_lift_due_to_ground_effect)"));
        root.add(new DefaultMutableTreeNode("DRAG(LBS)"));
        root.add(new DefaultMutableTreeNode("SIDE(LBS)"));
        root.add(new DefaultMutableTreeNode("LIFT(LBS)"));
        root.add(new DefaultMutableTreeNode("ROLL(LBS*FT)"));
        root.add(new DefaultMutableTreeNode("PITCH(LBS*FT)"));
        root.add(new DefaultMutableTreeNode("YAW(LBS*FT)"));
        
        tree = new JTree(root);
        JScrollPane treeView = new JScrollPane(tree);
        add(treeView);

    }
    
    private JTree tree;
}
