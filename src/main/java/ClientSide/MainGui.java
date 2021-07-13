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
import java.net.*;

public class MainGui extends MainMenuFrame
{
    private ObjectOutputStream out;
    public ArrayList<Conversation> conversations = new ArrayList();
    private MainGui instance;
    private Socket socket;
    
    Conversation conversation;
    
    
    public MainGui(String username, ObjectOutputStream out, Socket socket)
    {
        super(username);
        this.out = out;
        this.socket = socket;
    }
    
    public void setInstance(MainGui instance)
    {
        this.instance = instance;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        errorDisable();
        if(exists(usernameTxt.getText()))
        {
            errorEnable();
        }
        else
        {
            add(usernameTxt.getText());
        }
    }
    
    public boolean exists(String username)
    {
        for(Conversation conversation: conversations)
        {
            if(conversation.getUsername().equals(username))
            {
                return true;
            }
        }
        return false;
    }
    
    public void add(String username)
    {
        conversations.add(new Conversation(username, getOwnUsername(), out, instance));
    }
    
    public void receivedMessage(Message msg)
    {
        conversation = findConversation(msg.getSender());
        if(conversation != null)
        {
            conversation.addReceivedMessage(msg.getContent(), msg.getSender());
        }
        else
        {
            add(msg.getSender());
            receivedMessage(msg);
        }
    }
    
    public Conversation findConversation(String username)
    {
        for(Conversation conversation: conversations)
        {
            if(conversation.getUsername().equals(username))
            {
                return conversation;
            }
        }
        return null;
    }
    
    public int findIndex(String username)
    {
        for(int index = 0; index < conversations.size(); index++)
        {
            if(conversations.get(index).getUsername().equals(username))
            {
                return index;
            }
        }
        return 0;
    }
    
    public void closeAllTabs()
    {
        for(Conversation conversation: conversations)
        {
            conversation.setVisible(false);
        }
    }
    
    @Override
    public void windowClosing(WindowEvent event)
    {
        try
        {
            out.writeObject(new Message("exit"));
            closeAllTabs();
            socket.close();
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            System.exit(0);
        }
    }
}
