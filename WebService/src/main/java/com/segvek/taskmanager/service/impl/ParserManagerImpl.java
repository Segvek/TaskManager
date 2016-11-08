package com.segvek.taskmanager.service.impl;

import com.segvek.taskmanager.service.GlobalParser;
import com.segvek.taskmanager.service.ParserManager;
import com.segvek.taskmanager.service.util.SAXParserUtil;
import com.segvek.taskmanager.service.util.XMLUtils;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Panas
 */
public class ParserManagerImpl implements ParserManager {

    /*данная часть сделана из за отсутствия спринг*/
    private static ParserManager parserManagerImpl = new ParserManagerImpl();

    public static ParserManager getInstance() {
        return parserManagerImpl;
    }

    /*конец части*/


    /**
     * @inheritDoc
     */
    public String parse(String xml) {
        if (!XMLUtils.validateXMLByXSD(xml, "http://localhost:8080/WebService//schems/APIRequest.xsd")) {
            return "<error>error valid(load) schem requesrAPI.xsd</error>";
            /*<TODO> здесь необходимо сделать настройку из файла конфигурации 
            автоматическую настройку порта**/
        }
        //Object tempObj = SpringUtil.getInstance().getBean("globalParser");
        Object tempObj = new GlobalParserImpl();
        
        if (!(tempObj instanceof GlobalParser)) {
            return "error not equals type!";
        }
        
        GlobalParser globalParser = (GlobalParser) tempObj;
        InputSource source = new InputSource(new StringReader(xml));

        String response = "parse exeption";
        try {
            SAXParserUtil.getParser().parse(source, (DefaultHandler) globalParser);
            response = globalParser.getResponce();
        } catch (SAXException ex) {
            Logger.getLogger(ParserManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ParserManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParserManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
}
