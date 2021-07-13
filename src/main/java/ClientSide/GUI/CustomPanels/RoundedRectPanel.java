package ClientSide.GUI.CustomPanels;

import java.awt.*;
import javax.swing.*;

public class RoundedRectPanel extends JPanel
{
    public int arcX = 20;
    public int arcY = 20;
    private boolean hasBorder = true;
    public int stroke = 3;
    
    
    public RoundedRectPanel()
    {
        super();
        setVisible(true);
        setOpaque(true);
        // this.repaint();
    }
    
    public void setHasBorder(boolean hasBorder)
    {
        this.hasBorder = hasBorder;
    }
    
    @Override
    protected void paintComponent(Graphics graph)
    {
        // super.paintComponent(graph);
        
        Graphics2D graph2D = (Graphics2D) graph;
        
        graph2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
        graph2D.setStroke(new BasicStroke(1));
        graph2D.setColor(getBackground());
        graph2D.fillRoundRect(getX()-arcX/4,getY()-arcY/4,getWidth()-arcX*2,getHeight()-arcY*2,arcX, arcY );
        
        if(hasBorder)
        {
            graph2D.setStroke(new BasicStroke(stroke));
            graph2D.setColor(getForeground());
            graph2D.drawRoundRect(getX()-arcX/4,getY()-arcY/4,getWidth()-arcX*2,getHeight()-arcY*2,arcX, arcY );
        }
    }
    
    
}
