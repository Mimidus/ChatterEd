package ClientSide.GUI;

import javax.swing.*;
import Msg.*;
import ClientSide.GUI.CustomPanels.*;
import java.awt.*;
import java.awt.event.*;

public class AutoScrollPane extends JScrollPane
{
    JScrollBar scrollBar;
    int max;
    
    public AutoScrollPane(JPanel panel)
    {
        super(panel);
        scrollBar = getVerticalScrollBar();
    }
    
    public void setToBottom()
    {
        refresh();
        max = scrollBar.getMaximum();
        scrollBar.setValue(max);
        revalidate();
    }
    
    public void refresh()
    {
        invalidate();
        validate();
        repaint();
    }
}
