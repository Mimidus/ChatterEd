package ClientSide;

import javax.swing.*;
import ClientSide.GUI.*;
import Msg.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Register extends RegistrationFrame
{
    private ObjectOutputStream out;
    private ObjectInputStream in;
    public boolean isRegistered = false;
    private Log login;
    
    public Register(ObjectOutputStream out, ObjectInputStream in, Log login)
    {
        super();
        this.out = out;
        this.in = in;
        this.login = login;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if(comparePasswords())
            {
                register();
            }
            else
            {
                notMatchingPasswords();
            }
        }catch(Exception except){}
    }
    
    private void register() throws Exception
    {
        out.writeObject(new LoginRegisterRequest(username,password, true));
        loginBtn.setEnabled(false);
        if(((TechnicalMsg)in.readObject()).getBooleanData())
        {
            System.out.println("Registered");
            successfulRegistration();
            isRegistered = true;
            login.setVisible(true);
        }
        else
        {
            existingUsername();
            loginBtn.setEnabled(true);
        }
    }
    
    public boolean getIsRegistered()
    {
        return isRegistered;
    }
}
