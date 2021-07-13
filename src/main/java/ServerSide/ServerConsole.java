package ServerSide;


public class ServerConsole extends ServerConsoleUtility implements Runnable
{
    public static final ServerConsole console = new ServerConsole();
    
    private ServerConsole()
    {
        
    }
    
    public static ServerConsole getInstance()
    {
        return console;
    }   
    
}
