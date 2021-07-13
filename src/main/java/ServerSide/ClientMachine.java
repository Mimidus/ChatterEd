package ServerSide;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import Msg.*;


public class ClientMachine implements Runnable
{
    protected int id;
    protected String username;
    protected Socket socket;
    
    protected ObjectOutputStream out ;
    protected ObjectInputStream in;
    
    protected Thread userThread;
    protected boolean isRunning = true;
    
    public void setThread(Thread thread)
    {
        this.userThread = thread;
    }
    
    public void run()
    {
        try(
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            
        )
        {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            
            loginOrRegister();
            
            Message msg = new Message("Hello " + username + "!");
            
            out.writeObject(msg);
            System.out.println(username + " has successfully connected to the server");
            DataBaseUtility.informAll(username + " has joined the chat - say hi!", id);
            Message input;
            Socket targetSocket;
            while(isRunning)
            {
                input = ((Message)in.readObject());
                if(input.getContent().equals("exit"))
                {
                    isRunning = false;
                }
                if(canBeSent(input))
                {
                    DataBaseUtility.searchWriteTo(input.getRecipientUsername()).writeObject(input);
                }
            }  
                
        }
        catch(EOFException e)
        {
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            DataBaseUtility.informAll(username + " has left the server", id);
            closeConnection();
        }
    }
    
    public ClientMachine(int id, String username)
    {
        this.id = id;
        this.username = username;
    }
    
    public ClientMachine(int id, String username, Socket socket) throws Exception
    {
        this.id = id;
        this.username = username;
        this.socket = socket;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public Socket getSocket()
    {
        return socket;
    }
    
    public ObjectOutputStream getWriteTo()
    {
        return out;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public boolean canBeSent(Message input)
    {
        if(!(DataBaseUtility.clientsRegister.isEmpty()) && DataBaseUtility.searchWriteTo(input.getRecipientUsername()) != null && !(input.getRecipientUsername().equals(username)))
        {
            return true;
        }
        return false;
    }
    
    public void closeConnection()
    {
        try
        {
            System.out.println(username + " has disconnected");
            DataBaseUtility.clientsRegister.remove(DataBaseUtility.findUsername(username));
            DataBaseUtility.counter--;
            userThread.stop();
            isRunning = false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void loginOrRegister()
    {
        try
        {
           LoginRegisterRequest loginRequest = null;
           boolean isLoggedIn = false;
           do
           {
               loginRequest = (LoginRegisterRequest)in.readObject();
               if(loginRequest.isRegisterRequest())
               {
                   if(DataBaseUtility.usernameIsFree(loginRequest.getUsername()))
                   {
                       DataBaseUtility.createNewUser(loginRequest.getUsername(), loginRequest.getPassword());
                       out.writeObject(new TechnicalMsg(true));
                   }
                   else
                   {
                       out.writeObject(new TechnicalMsg(false));
                   }
               }
               else
               {
                   isLoggedIn = loginProcess(loginRequest);
               }
           }
           while(!isLoggedIn);
        }
        catch(Exception e)
        {
            
        }
    }
    
    public boolean loginProcess(LoginRegisterRequest request)
    {
        try
        {
            String loginUsername;
            String loginPassword;
            
            loginUsername = request.getUsername();
            loginPassword = request.getPassword();
            username = loginUsername;
            
            if(exists(loginUsername, loginPassword))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public void registerRequest()
    {
        
    }
    
    public boolean exists(String username, String password)
    {
        boolean isTrue;
        try
        {
            isTrue = DataBaseUtility.canBeLoggedIn(username,password);
            if(isTrue)
            {
                out.writeObject(new TechnicalMsg(true));
            }
            else
            {
                out.writeObject(new TechnicalMsg(false));
            }
            return isTrue;
        }catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
