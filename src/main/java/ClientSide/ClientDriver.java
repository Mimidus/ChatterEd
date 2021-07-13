package ClientSide;

public class ClientDriver
{
    public static void main(String[] args)
    {
        Client client = new Client();
        String hostname = args[0];
        int port = 9997;
        client.establishConnection(hostname, port);
    }
}