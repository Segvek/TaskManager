package com.segvek.taskmanager.service.functions.authorization;

import com.segvek.taskmanager.service.functions.FunctionHandler;
import com.segvek.taskmanager.service.model.User;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 * @author Panas
 */
public class ParserAuthorization extends FunctionHandler {

    private String name, hashPass;
    
    private String tempElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes); //To change body of generated methods, choose Tools | Templates.
        tempElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length); //To change body of generated methods, choose Tools | Templates.

        switch (tempElement) {
            case "name": {
                if (name == null) {
                    name = new String(ch, start, length);
                }
                break;
            }
            case "hashPass": {
                if (hashPass == null) {
                    hashPass = new String(ch, start, length);
                }
                break;
            }
        }
    }

    public User getUser() {
        User user = new User();
        user.setName(name);
        user.setHashPass(hashPass);
        return user;
    }
}
