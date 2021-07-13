package ClientSide.GUI.CustomPanels;

import java.awt.*;
import javax.swing.*;

public class testeeee extends JPanel
{
    private Polygon polygon = new Polygon();
    
    public testeeee()
    {super();}
    
    @Override
    protected void paintComponent(Graphics g)
    {
        setBackground(Color.RED);
        
        Graphics2D graph2D = (Graphics2D)g;
        
        polygon.addPoint(getX(),getY());
        polygon.addPoint(getX(),getY()+20);
        polygon.addPoint(getX()+20, getY()+10);
        graph2D.fillPolygon(polygon);
    }
}
