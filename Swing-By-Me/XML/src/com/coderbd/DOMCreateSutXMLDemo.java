package com.coderbd;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class DOMCreateSutXMLDemo {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //root element
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("student");
            doc.appendChild(rootElement);
            
            Element std = doc.createElement("std");
            rootElement.appendChild(std);
            
            Element attr = doc.createElement("id");
           attr.setValue("1");
            std.appendChild(attr);
            
            

        } catch (Exception e) {
        }
    }

}
