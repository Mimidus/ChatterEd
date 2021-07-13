package ClientSide.GUI.CustomPanels;

import javax.swing.*;
import java.awt.*;

public class TestDriver
{
    public static void main()
    {
        JFrame frame = new JFrame();
        JPanel pane = new RoundedRectPanel();
        JPanel pane2 = new RoundedRectPanel();
        
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        
        pane.setBackground(Color.RED);
        pane2.setBackground(Color.GREEN);
        
        JButton btn1 = new JButton("HEJUNIA");
        JButton btn2 = new JButton("Hasdsadasdasdasd");
        
        pane.add(btn1);
        
        
        pane2.add(btn2);
        
        frame.add(pane,c);
        
        c.gridx = 1;
        c.gridy = 1;
        
        frame.add(pane2,c);
        
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
