package Msg;

import java.io.*;
import java.util.*;

public class Message implements Serializable
{
    
    private String content;
    private int senderId;
    private int recipientId;
    private String sender;
    private String recipientUsername;
    
    
    public Message(String content, int senderId, int recipientId)
    {
        this.content = content;
        this.senderId = senderId;
        this.recipientId = recipientId;
    }
    
    public Message(String content, String sender)
    {
        this.content = content;
        this.sender = sender;
    }
    
    public Message(String content)
    {
        this.content = content;
        sender = "server";
    }
    
    public Message(String content, String username, int recipientId)
    {
        this.content = content;
        this.sender = username;
        this.recipientId = recipientId;
    }
    
    public Message(String content, String username, String recipientUsername)
    {
        this.content = content;
        this.sender = username;
        this.recipientUsername = recipientUsername;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public int getSenderId()
    {
        return senderId;
    }
    
    public int getRecipientId()
    {
        return recipientId;
    }
    
    public String getSender()
    {
        return sender;
    }
    
    public String getRecipientUsername()
    {
        return recipientUsername;
    }
}
