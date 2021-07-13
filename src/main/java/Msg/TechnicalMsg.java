package Msg;

import java.io.*;

public class TechnicalMsg implements Serializable
{
    private int intData;
    private String stringData;
    private boolean booleanData;
    
    public TechnicalMsg(int intData, String stringData)
    {
        this.intData = intData;
        this.stringData = stringData;
    }
    
    public TechnicalMsg(String stringData, boolean booleanData)
    {
        this.booleanData = booleanData;
        this.stringData = stringData;
    }
    
    public TechnicalMsg(boolean booleanData)
    {
        this.booleanData = booleanData;
    }
    
    public TechnicalMsg(boolean booleanData, int intData)
    {
        this.booleanData = booleanData;
        this.intData = intData;
    }
    
    public TechnicalMsg(int intData)
    {
        this.intData = intData;
    }
    
    public TechnicalMsg(String stringData)
    {
        this.stringData = stringData;
    }
    
    public int getIntData()
    {
        return intData;
    }
    
    public String getStringData()
    {
        return stringData;
    }
    
    public boolean getBooleanData()
    {
        return booleanData;
    }
}