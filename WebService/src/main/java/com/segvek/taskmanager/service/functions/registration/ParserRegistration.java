/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.functions.registration;

import com.segvek.taskmanager.service.model.User;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Panas
 */
class ParserRegistration extends DefaultHandler {

    private String name, mail,hashPass;
    
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
            case "mail": {
                if (mail == null) {
                    mail = new String(ch, start, length);
                }
                break;
            }
        }
    }
    public User getUser() {
        User user = new User();
        user.setName(name);
        user.setHashPass(hashPass);
        user.setMail(mail);
        return user;
    }
}

