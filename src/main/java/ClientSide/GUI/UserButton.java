package ClientSide.GUI;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import ClientSide.GUI.CustomPanels.*;
import Msg.*;


public class UserButton extends JButton
    {
        private String username;
        private UserButton instance;
        
        public UserButton(String username)
        {
            super(username);
            this.username = username;
        }
        
        public UserButton getInstance()
        {
            return instance;
        }
        
        public void setInstance(UserButton instance)
        {
            this.instance = instance;
        }
        
        public void disable()
        {
            setEnabled(false);
        }
        
        public void enable()
        {
            setEnabled(false);
        }
    }