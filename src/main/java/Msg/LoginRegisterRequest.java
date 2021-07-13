package Msg;


import java.io.*;

public class LoginRegisterRequest implements Serializable
{
    private String username;
    private String password;
    private boolean isRegisterRequest = false;
    
    public LoginRegisterRequest(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    public LoginRegisterRequest(String username, String password, boolean isRegisterRequest)
    {
        this.username = username;
        this.password = password;
        this.isRegisterRequest = isRegisterRequest;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public boolean isRegisterRequest()
    {
        return isRegisterRequest;
    }
}
