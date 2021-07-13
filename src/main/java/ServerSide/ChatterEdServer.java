
package ServerSide;

import java.net.*;
import java.io.*;
import java.util.*;



public class ChatterEdServer
{
    public static boolean isStarted = false;
    private static ChatterEdServer server = new ChatterEdServer();
    static Thread console = new Thread(ServerConsole.getInstance());
    static ServerSocket serverSocket;
    
    private ChatterEdServer()
    {
        DataBaseUtility.registeredClientsList.add(new UserLoginData("test","test"));
        DataBaseUtility.registeredClientsList.add(new UserLoginData("milo","milo"));
    }
    
    public static void startServer(int port)
    {        
    
        isStarted = true;
        
        try
        {
            System.out.println("Openinig Server Socket at port: " + port);
            serverSocket = new ServerSocket(port);
            console.start();
            
            while(isStarted)
            {
                Socket client = new Socket();
                
                client = serverSocket.accept();
                DataBaseUtility.clientsRegister.add(new ClientMachine(DataBaseUtility.counter, "user" + DataBaseUtility.counter, client));
                System.out.println("Connection request from ip: " + client.getRemoteSocketAddress().toString());
                //-----------------------------------
                Thread thread = new Thread(DataBaseUtility.clientsRegister.get(DataBaseUtility.counter - 1));
                DataBaseUtility.clientsRegister.get(DataBaseUtility.counter - 1).setThread(thread);
                thread.start();
                DataBaseUtility.counter++;
            }
        }
        catch(SocketException e)
        {
            System.out.println("Server Socket accept method interrupted");
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            stop();
        }
    }
    
    public static void stop()
    {
        try
        {
            System.out.println("closing server");
            serverSocket.close();
            isStarted = false;
            console.stop();
            System.exit(0);
        }
        catch(Exception e)
        {
            
        }
    }
    
    
}