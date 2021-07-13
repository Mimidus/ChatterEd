package ClientSide.GUI;


import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import ClientSide.GUI.CustomPanels.*;

public class LoginFrame extends JFrame implements WindowListener, ActionListener, DocumentListener
{
    private JLabel welcomeLbl = new JLabel("Welcome to ChatterED");
    private JLabel wrongLbl = new JLabel("Wrong username or password");
    
    private JPanel mainPanel = new RoundedRectPanel();
    private JPanel login = new JPanel();
    
    private boolean isClicked = false;
    
    private Font font = new Font("Verdana", Font.BOLD, 28);
    
    protected JTextField usernameTxt = new JTextField();
    protected JPasswordField passwordField = new JPasswordField();
    
    protected JButton loginBtn = new JButton("login");
    private JButton registerBtn = new JButton("no account yet");
    
    protected String username;
    protected String password;
    
    GridBagConstraints mainPanelConstraint = new GridBagConstraints();
    GridBagConstraints inPanelConstraint = new GridBagConstraints();
    
    Border blackBorder = BorderFactory.createLineBorder(Color.black);
    
    
    public LoginFrame()
    {
        super();
        setSize(500,400);
        getContentPane().setBackground(new Color(214,255,191));
        setResizable(false);
        setTitle("ChatterED login");
        addWindowListener(this);
        setLayout(new GridBagLayout());
        mainPanel.setLayout(new GridBagLayout());
        
        inPanelConstraint.insets = new Insets(40,20,10,20);
        inPanelConstraint.weightx = 0.1;
        inPanelConstraint.weighty = 0.1;
        inPanelConstraint.gridx = 1;
        inPanelConstraint.gridy = 0;
        inPanelConstraint.gridwidth = 3;
        inPanelConstraint.anchor = GridBagConstraints.PAGE_START;
        inPanelConstraint.fill = GridBagConstraints.HORIZONTAL;
        welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLbl.setFont(font);
        
        mainPanel.add(welcomeLbl,inPanelConstraint);
        
        inPanelConstraint.insets = new Insets(25,40,10,40);
        inPanelConstraint.gridx = 1;
        inPanelConstraint.gridy = 1;
        
        Border usernameBorder = BorderFactory.createTitledBorder(blackBorder,"Username:");
        usernameTxt.setBorder(usernameBorder);
        
        // usernameTxt.addActionListener(this);
        
        // usernameTxt.setActionCommand("usernameTxt");
        
        usernameTxt.getDocument().addDocumentListener(this);
        
        mainPanel.add(usernameTxt,inPanelConstraint);
        
        inPanelConstraint.insets = new Insets(10,40,10,40);
        inPanelConstraint.gridx = 1;
        inPanelConstraint.gridy = 2;
        Border passwordBorder = BorderFactory.createTitledBorder(blackBorder,"Password:");
        passwordField.setBorder(passwordBorder);
        
        // passwordField.addActionListener(this);
        
        // passwordField.setActionCommand("passwordField");
        
        passwordField.getDocument().addDocumentListener(this);
        
        mainPanel.add(passwordField, inPanelConstraint);
        
        inPanelConstraint.fill = GridBagConstraints.HORIZONTAL;
        inPanelConstraint.insets = new Insets(0,40,0,40);
        inPanelConstraint.gridy = 3;
        inPanelConstraint.gridx = 1;
        
        mainPanel.add(wrongLbl,inPanelConstraint);
        wrongLbl.setVisible(false);
        
        inPanelConstraint.fill = GridBagConstraints.VERTICAL;
        inPanelConstraint.insets = new Insets(10,40,40,10);
        inPanelConstraint.gridy = 4;
        inPanelConstraint.gridx = 1;
        
        
        registerBtn.addActionListener(this);
        
        registerBtn.setActionCommand("registerBtn");
        
        mainPanel.add(registerBtn, inPanelConstraint);
        
        inPanelConstraint.insets = new Insets(10,10,40,40);
        inPanelConstraint.gridy = 4;
        inPanelConstraint.gridx = 2;
        inPanelConstraint.fill = GridBagConstraints.VERTICAL;
        inPanelConstraint.anchor = GridBagConstraints.LAST_LINE_END;
        
        loginBtn.addActionListener(this);
        
        loginBtn.setActionCommand("loginBtn");
        
        loginBtn.setMnemonic(KeyEvent.VK_ENTER);
        
        mainPanel.add(loginBtn, inPanelConstraint);
        
        mainPanelConstraint.fill = GridBagConstraints.BOTH;
        mainPanelConstraint.weightx = 0.1;
        mainPanelConstraint.weighty = 0.1;
        mainPanelConstraint.gridx = 0;
        mainPanelConstraint.gridy = 0;
        mainPanelConstraint.insets = new Insets(25,25,25,25);
        mainPanel.setBackground(new Color(255,255,255));
        mainPanel.setForeground(new Color(0,0,0));
        // mainPanel.setHasBorder(true);
        
        
        add(mainPanel, mainPanelConstraint);
        
        setLocationRelativeTo(null);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        switch(e.getActionCommand())
        {
            case "loginBtn": isClicked = false;
                             break;
            case "registerBtn":
        }
        System.out.println(username);
        System.out.println(password);
    }
    
    public void insertUpdate(DocumentEvent e)
    {
        username = usernameTxt.getText();
        password = passwordField.getText();
    }
    
    public void changedUpdate(DocumentEvent e)
    {
        username = usernameTxt.getText();
        password = passwordField.getText();
    }
    
    public void removeUpdate(DocumentEvent e)
    {
        username = usernameTxt.getText();
        password = passwordField.getText();
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setClicked(boolean isClicked)
    {
        this.isClicked = isClicked;
    }
    
    public void wrongPassword()
    {
        wrongLbl.setVisible(true);
    }
    
    public void windowDeactivated(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowOpened(WindowEvent e){}
    public void windowClosing(WindowEvent e){}
}
