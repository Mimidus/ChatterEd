package ClientSide;

import java.util.*;
import java.io.*;
import java.net.*;
import Msg.*;
import ClientSide.GUI.*;
import javax.swing.*;

public class Client
{
    public Socket clientSocket;
    public ObjectOutputStream objectStreamOut;
    public ObjectInputStream objectStreamIn;
    public String username;
    //---------------------
    public String recipient;
    //---------------------
    public int ownId;
    
    
    
    public void establishConnection(String hostname, int port)
    {
        try
        {
            clientSocket = new Socket(hostname, port);
            this.recipient = recipient;
            objectStreamOut = new ObjectOutputStream(clientSocket.getOutputStream());
            
            objectStreamIn = new ObjectInputStream(clientSocket.getInputStream());
            
            BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
            
            String localInput;
            
            Log log = new Log(objectStreamOut, objectStreamIn);
            log.setInstance(log);
            
            while(!(log.getLoggedIn())){Thread.sleep(1);}
            
            log.setVisible(false);
            
            username = log.getUsername();
            
            Thread listener = new Thread(new Listener(clientSocket, objectStreamIn, username, objectStreamOut));
            
            listener.start();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     }
    
    public boolean loggedIn()
    {
        try
        {
            return ((TechnicalMsg)objectStreamIn.readObject()).getBooleanData();
        }
        catch(Exception e){return false;}
    }
}