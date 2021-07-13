package ServerSide;

import java.util.*;
import java.net.*;
import java.io.*;

import Msg.*;

public class DataBaseUtility
{
    static public List<ClientMachine> clientsRegister = new ArrayList();
    static public List<UserLoginData> registeredClientsList = new ArrayList();
    static public int counter = 1;
    static public Iterator<ClientMachine> iterator = clientsRegister.iterator();
    
    public DataBaseUtility()
    {
        registeredClientsList.add(new UserLoginData("test","test"));
        registeredClientsList.add(new UserLoginData("milo","milo"));
    }
    
    public static Socket searchSocket(int id)
    {
        for(int index = 0; index < clientsRegister.size(); index++)
        {
            if(clientsRegister.get(index).getId() == id)
            {
                return clientsRegister.get(index).getSocket();
            }
        }
        return null;
    }
    
    public static Socket searchSocket(String username)
    {
        for(int index = 0; index < clientsRegister.size(); index++)
        {
            if(clientsRegister.get(index).getUsername().equals(username))
            {
                return clientsRegister.get(index).getSocket();
            }
        }
        return null;
    }
    
    public static ObjectOutputStream searchWriteTo(int id)
    {
        for(int index = 0; index < clientsRegister.size(); index++)
        {
            if(clientsRegister.get(index).getId() == id)
            {
                return clientsRegister.get(index).getWriteTo();
            }
        }
        return null;
    }
    
    public static ObjectOutputStream searchWriteTo (String username)
    {
        for(int index = 0; index < clientsRegister.size(); index++)
        {
            if((clientsRegister.get(index).getUsername()).equals(username))
            {
                return clientsRegister.get(index).getWriteTo();
            }
        }
        return null;
    }
    
    public static boolean usernameIsFree(String newUsername, int ownId)
    {
        for(int index = 0; index < clientsRegister.size(); index++)
        {
            if(clientsRegister.get(index).getUsername().equals(newUsername))
            {
                if(clientsRegister.get(index).getId()!= ownId)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean usernameIsFree(String newUsername)
    { 
        for(int index = 0; index < registeredClientsList.size(); index++)
        {
            if(registeredClientsList.get(index).getUsername().equals(newUsername))
            {
                return false;
            }
        }
        return true;
    }
    
    public static void informAll(String text, int idLeft)
    {
        ClientMachine client;
        Iterator<ClientMachine> iterator1 = clientsRegister.iterator();
        try
        {
            for(int index = 0; index < clientsRegister.size(); index++)
            {
                client = clientsRegister.get(index);
                if(client.getId() != idLeft)
                {
                    client.getWriteTo().writeObject(new Message(text));
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static int findUsername(String username)
    {
        for(int index = 0; index < clientsRegister.size(); index++)
        {
            if(clientsRegister.get(index).getUsername().equals(username))
            {
                return index;
            }
        }
        return -1;
    }
    
    public static boolean canBeLoggedIn(String username, String password)
    {
        for(UserLoginData loginData :registeredClientsList)
        {
            if(loginData.checkValidity(username, password))
            {
                return true;
            }
        }
        return false;
    }
    
    public static void createNewUser(String username, String password)
    {
        registeredClientsList.add(new UserLoginData(username, password));
    }
    
    public String getClient(int index)
    {
        return clientsRegister.get(index).getUsername();
    }
}
