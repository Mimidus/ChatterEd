package ClientSide.GUI.CustomLabels;

import javax.swing.*;
import java.awt.*;

public class ChatLabelSent extends JLabel
{
    String text;
    int arcX = 10;
    int arcY = 10;
    
    public ChatLabelSent(String text)
    {
        super(text);
        this.text = text;
        setVisible(true);
    }
    
    public ChatLabelSent()
    {
        super();
        setVisible(true);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D graph2D = (Graphics2D)g;
        graph2D.setColor(getBackground());
        graph2D.fillRoundRect(getX()-arcX/4,getY()-arcY/4,getWidth()-2*arcX,getHeight()-2*arcY,arcX, arcY );
    }
}
