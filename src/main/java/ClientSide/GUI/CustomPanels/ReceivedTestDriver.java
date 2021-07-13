package ClientSide.GUI.CustomPanels;

import javax.swing.*;
import java.awt.*;


public class ReceivedTestDriver
{
    
    public static void main()
    {
        JFrame frame = new JFrame();
        JPanel pane = new ReceivedMsgPanel();
        JPanel pane1 = new ReceivedMsgPanel();
        pane.setBackground(Color.RED);
        pane1.setBackground(Color.YELLOW);
        
        // frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridy = 0;
        c.gridx = 0;
        c.weighty = 0.1;
        c.weightx = 0.1;
        c.fill = GridBagConstraints.BOTH;
        
        
        // pane.add(new JButton("hahah"));
        
        c.insets = pane.getInsets();
        pane.setVisible(true);
        
        frame.add(pane);
        frame.add(pane1);
        frame.add(new JButton("DASDASDASD"));
        frame.setSize(500,500);
        frame.setVisible(true);
    }

}
