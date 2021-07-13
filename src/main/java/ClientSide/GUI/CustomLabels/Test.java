package ClientSide.GUI.CustomLabels;

import javax.swing.*;
import java.awt.*;


public class Test
{
    public static void main()
    {
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        
        JLabel label = new ChatLabelSent("asddddadsdasd");
        label.setBackground(Color.RED);
        // JLabel lab = new ChatLabelSent("sadfsgdsgdsgdsgsdg");
        // lab.setBackground(Color.RED);
        frame.add(label);
        // frame.add(lab);
        frame.setVisible(true);
        frame.setSize(500,500);
    }
}
