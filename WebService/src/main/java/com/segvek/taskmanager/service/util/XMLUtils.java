package com.segvek.taskmanager.service.util;

import java.io.File;
import java.io.StringReader;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

public class XMLUtils {

    /**
     * This method validate XML by input XML as String and XSD path to File.
     *
     * @param xml     input XML as String
     * @param xsdPath input XSD File Path
     *
     * @return true or false, valid or not
     */
    public static boolean validateXMLByXSD(String xml, String xsdPath) {
        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(new URL(xsdPath))
                    .newValidator()
                    .validate(new StreamSource(new StringReader(xml)));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * This method validate XML by input XML as String and XSD File.
     *
     * @param xml input XML as String
     * @param xsd input XSD File
     *
     * @return true or false, valid or not
     */
    public static boolean validateXMLByXSD(String xml, File xsd) {
        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(xsd)
                    .newValidator()
                    .validate(new StreamSource(new StringReader(xml)));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * This method validate XML by XML File and XSD File.
     *
     * @param xml input XML File
     * @param xsd input XSD File
     *
     * @return true or false, valid or not
     */
    public static boolean validateXMLByXSD(File xml, File xsd) {
        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(xsd)
                    .newValidator()
                    .validate(new StreamSource(xml));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
