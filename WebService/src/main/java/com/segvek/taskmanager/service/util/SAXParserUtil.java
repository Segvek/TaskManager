/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Panas
 */
public class SAXParserUtil {

    private static SAXParserFactory parserFactory = SAXParserFactory.newInstance();

    public static SAXParser getParser() {
        SAXParser parser = null;
        try {
            parser = parserFactory.newSAXParser();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SAXParserUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SAXParserUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return parser;
    }
}
