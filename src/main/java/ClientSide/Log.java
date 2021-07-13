package ClientSide;

import javax.swing.*;
import ClientSide.GUI.*;
import Msg.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Log extends LoginFrame
{
    private ObjectOutputStream out;
    private ObjectInputStream in;
    public boolean isLoggedIn = false;
    public Register register = null;
    private Log instance;
    
    public Log(ObjectOutputStream out, ObjectInputStream in)
    {
        super();
        this.out = out;
        this.in = in;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            switch(e.getActionCommand())
            {
                case "loginBtn":login();
                                break;
                case "registerBtn": register = new Register(out, in, instance);
                                    setVisible(false);
            }
        }catch(Exception except){}
    }
    
    private void login() throws Exception
    {
        out.writeObject(new LoginRegisterRequest(username,password));
        loginBtn.setEnabled(false);
        if(((TechnicalMsg)in.readObject()).getBooleanData())
        {
            isLoggedIn = true;
            
        }
        else
        {
            wrongPassword();
        }
        loginBtn.setEnabled(true);
    }
    
    public void setInstance(Log instance)
    {
        this.instance = instance;
    }
    
    public boolean getLoggedIn()
    {
        return isLoggedIn;
    }
}
