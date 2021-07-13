package ClientSide.GUI;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import ClientSide.GUI.CustomPanels.*;

public class ConversationFrame extends JFrame implements WindowListener, ActionListener, DocumentListener
{
    
    private String username;
    private String message;
    
    private int index = 1;
    
    private JLabel startLbl = new JLabel();
    
    protected JTextField messageInput = new JTextField();
    
    private JPanel mainPanel = new JPanel();
    private JPanel msgPanel = new JPanel();
    
    private AutoScrollPane scrollPane = new AutoScrollPane(msgPanel);
    
    private GridBagConstraints mainPanelConstraints = new GridBagConstraints();
    private GridBagConstraints sendMessageConstraints = new GridBagConstraints();
    private GridBagConstraints receivedMessageConstraints = new GridBagConstraints();
    
    private JButton sendBtn = new JButton("send");
    
    public ConversationFrame(String username)
    {
        this.username = username;
        
        
        setSize(600,500);
        addWindowListener(this);
        setLayout(new GridBagLayout());
        setTitle("Conversation with: " + username);
        
        mainPanelConstraints.fill = GridBagConstraints.BOTH;
        mainPanelConstraints.insets = new Insets(5,5,5,5);
        mainPanelConstraints.gridy = 0;
        mainPanelConstraints.gridx = 0;
        mainPanelConstraints.gridwidth = 10;
        mainPanelConstraints.gridheight = 18;
        mainPanelConstraints.weightx = 1;
        mainPanelConstraints.weighty = 0.6;
        
        msgPanel.setLayout(new GridBagLayout());
        
        add(scrollPane, mainPanelConstraints);
        
        mainPanelConstraints.weighty = 0.1;
        mainPanelConstraints.weightx = 0.7;
        mainPanelConstraints.gridy = 19;
        mainPanelConstraints.gridwidth = 1;
        mainPanelConstraints.gridheight = 1;
        
        messageInput.setVisible(true);
        
        messageInput.getDocument().addDocumentListener(this);
        add(messageInput, mainPanelConstraints);
        
        mainPanelConstraints.weightx = 0.1;
        mainPanelConstraints.gridx = 8;
        
        messageInput.setVisible(true);
        
        receivedMessageConstraints.insets = new Insets(10,10,10,10);
        receivedMessageConstraints.anchor = GridBagConstraints.PAGE_START;
        receivedMessageConstraints.gridx = 0;
        receivedMessageConstraints.gridy = 0;
        receivedMessageConstraints.weightx = 0.5;
        receivedMessageConstraints.weighty = 0.5;
        receivedMessageConstraints.gridwidth = 2;
        receivedMessageConstraints.gridheight = 1;
        
        startLbl.setText("Beginning of your conversation with: " + username);
        startLbl.setVisible(true);
        
        msgPanel.add(startLbl, receivedMessageConstraints);
        
        sendBtn.addActionListener(this);
        add(sendBtn, mainPanelConstraints);
        
        scrollPane.setVisible(true);
        setVisible(true);
        
        receivedMessageConstraints.gridwidth = 1;
        
        receivedMessageConstraints.gridx = 0;
        receivedMessageConstraints.gridy = index;
        receivedMessageConstraints.anchor = GridBagConstraints.LINE_START;
        
        sendMessageConstraints.anchor = GridBagConstraints.LINE_END;
        
        sendMessageConstraints.insets = new Insets(10,10,10,10);
        sendMessageConstraints.weightx = 0.5;
        sendMessageConstraints.weighty = 0.5;
    }
    
    public String getMessage()
    {
        return message;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void addSentMessage(String message)
    {
        sendMessageConstraints.gridx = 0;
        sendMessageConstraints.gridy = index;
        JLabel sendLbl = new JLabel();
        sendLbl.setText("you: " + message);
        msgPanel.add(sendLbl, sendMessageConstraints);
        
        index++;
        scrollPane.setToBottom();
        refresh();
    }
    
    public void addReceivedMessage(String message, String username)
    {
        receivedMessageConstraints.gridx = 0;
        receivedMessageConstraints.gridy = index;
        JLabel receivedLbl = new JLabel();
        receivedLbl.setText(username + ": " + message);
        msgPanel.add(receivedLbl, receivedMessageConstraints);
        index++;
        scrollPane.setToBottom();
        refresh();
    }
    
    public void actionPerformed(ActionEvent event)
    {
        System.out.println("Needs override");
    }
    
    public void changedUpdate(DocumentEvent event)
    {
        message = messageInput.getText();
    }
    
    public void removeUpdate(DocumentEvent event)
    {
        message = messageInput.getText();
    }
    
    public void insertUpdate(DocumentEvent event)
    {
        message = messageInput.getText();
    }
    
    public void refresh()
    {
        invalidate();
        validate();
        repaint();
    }
    
    public void windowDeactivated(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowOpened(WindowEvent e){}
    public void windowClosing(WindowEvent e){}
}
