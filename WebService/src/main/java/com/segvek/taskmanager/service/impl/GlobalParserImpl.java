package com.segvek.taskmanager.service.impl;

import com.segvek.taskmanager.service.GlobalParser;
import com.segvek.taskmanager.service.ManagerFunctions;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Panas
 */
public class GlobalParserImpl extends DefaultHandler implements GlobalParser {

    private String responce = "";

    private String nameActivFunction;
    private String tempRequest = "";
    private static ManagerFunctions manager;

    static {
//        Object tepmObj = SpringUtil.getInstance().getBean("managerFunctions");
        Object tepmObj = new ManagerFunctionsImpl();
        if (tepmObj instanceof ManagerFunctions) {
            manager = (ManagerFunctions) tepmObj;
        } else {
            throw new ExceptionInInitializerError("Не соответствует указание bean!");
        }
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if (manager.isProcesses(qName)) {
            nameActivFunction = qName;
        }
        if (nameActivFunction != null) {
            tempRequest += "<" + qName + ">";
        }
        //...
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        if (nameActivFunction != null) {
            tempRequest += "</" + qName + ">";
        }
        if (qName.equals(nameActivFunction)) {
            nameActivFunction = null;
            try {
                responce += manager.getFunction(qName).processes(tempRequest);
            } catch (Exception ex) {
                Logger.getLogger(GlobalParserImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (nameActivFunction != null) {
            tempRequest += new String(ch, start, length);
        }
    }

    @Override
    public String getResponce() throws Exception {
        String title = "<responce>";
        String end = "</responce>";
        return title + responce + end;
    }
}
