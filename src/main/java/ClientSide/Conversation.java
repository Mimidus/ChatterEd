package ClientSide;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import ClientSide.GUI.*;
import Msg.*;
import java.io.*;

public class Conversation extends ConversationFrame
{
    private ObjectOutputStream out;
    private String ownUsername;
    MainGui mainGui;
    
    public Conversation(String username, String ownUsername, ObjectOutputStream out, MainGui mainGui)
    {
        super(username);
        this.out = out;
        this.ownUsername = ownUsername;
        this.mainGui = mainGui;
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        try
        {
            out.writeObject(new Message(messageInput.getText(),ownUsername,getUsername()));
            addSentMessage(messageInput.getText());
            messageInput.setText("");
        }
        catch(Exception e)
        {
            
        }
    }
    
    @Override
    public void windowClosing(WindowEvent event)
    {
        mainGui.conversations.remove(mainGui.findIndex(getUsername()));
    }
}
