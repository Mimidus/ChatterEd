package ServerSide;

import java.net.*;
import java.io.*;
import java.util.*;

public class ServerConsoleUtility
{
    
    public void run()
    {
        boolean isRunning = true;
        while(isRunning)
        {
            try(BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));)
            {
                commandLine(localReader);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void commandLine(BufferedReader reader) throws Exception
    {
        switch(reader.readLine())
        {
            case "listUsers": listUsers();
                              break;
            case "closeServer": closeServer();
                                break;
            case "help": help();
                         break;
            default: System.out.println("Unknown command, type 'help' for list of commands");
        }
    }
    
    public void help()
    {
        System.out.println("listUsers - creates a list of currently logged users");
        System.out.println("closeServer - closes the server");
    }
    
    public void listUsers()
    {
        if(DataBaseUtility.clientsRegister.size() != 0)
        {
            System.out.println("Users online:");
            for(int index = 0; index < DataBaseUtility.clientsRegister.size(); index++)
            {
                System.out.println(DataBaseUtility.clientsRegister.get(index).getId() + ": " + DataBaseUtility.clientsRegister.get(index).getUsername());
            }
        }
        else
        {
            System.out.println("No users online");
        }
    }
    
    public void closeServer() throws Exception
    {
        Iterator<ClientMachine> iterator = DataBaseUtility.iterator;
        while(iterator.hasNext())
        {
            try
            {
                ClientMachine next = iterator.next();
                next.closeConnection();
                iterator.remove();
                ChatterEdServer.isStarted = false;
            }
            catch(Exception e)
            {
                
            }
        }
        ChatterEdServer.stop();
    }
}
