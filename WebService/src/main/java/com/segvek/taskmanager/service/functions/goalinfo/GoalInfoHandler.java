package com.segvek.taskmanager.service.functions.goalinfo;

import com.segvek.taskmanager.service.functions.FunctionHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class GoalInfoHandler extends FunctionHandler{
    private String goalID="";
    private String activEl="";
        
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes); //To change body of generated methods, choose Tools | Templates.
        activEl=qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length); //To change body of generated methods, choose Tools | Templates.
         if(activEl.equals("golaID"))
            goalID=new String(ch, start, length);
    }
    
    public String getGoalId(){
        return goalID;
    }
}
