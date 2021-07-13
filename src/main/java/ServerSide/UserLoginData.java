package ServerSide;



public class UserLoginData
{
    private String username;
    private String password;
    private int id;
    
    public UserLoginData(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    public boolean checkValidity(String username, String password)
    {
        if(username.equals(this.username)&& password.equals(this.password))
        {
            return true;
        }
        return false;
    }
    
    public String getUsername()
    {
        return username;
    }
}
