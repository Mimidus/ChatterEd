package ClientSide;

import java.io.*;
import java.net.*;
import Msg.*;

public class Listener implements Runnable
{
    private Socket clientSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private String username;
    
    Message msg;
    MainGui gui;
    
    public Listener(Socket clientSocket, ObjectInputStream inputStream)
    {
        this.clientSocket = clientSocket;
        this.in = inputStream;
        gui = new MainGui(username, out, clientSocket);
    }
    
    public Listener(Socket clientSocket, ObjectInputStream inputStream,String username, ObjectOutputStream out)
    {
        this.clientSocket = clientSocket;
        this.in = inputStream;
        this.username = username;
        this.out = out;
        gui = new MainGui(username, out, clientSocket);
        gui.setInstance(gui);
    }
    
    @Override
    public void run()
    {
        boolean isRunning = true;
        try
        {
            while(isRunning)
            {
                msg = (Message)in.readObject();
                if(msg.getSender() != null)
                {
                    gui.receivedMessage(msg);
                }
                else
                {
                    gui.receivedMessage(msg);
                }
            }
        }
        catch(Exception e)
        {
            
        }
    }
}
