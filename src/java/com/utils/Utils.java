/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author luisperalta
 */
public class Utils {

    public static void main(String args[]){
        //Create XML
        System.out.println(Utils.crearXML(
                new Etiqueta("Familia",
                        new Etiqueta("Papas", new Etiqueta("Papa","Eduardo"), new Etiqueta("Mama","Francis")), 
                        new Etiqueta("Hijos", new Etiqueta("Hijo","Luis"), new Etiqueta("Hijo","Josue"), new Etiqueta("Hijo","Roberto")))));
    }
    
    public static String crearXML(Etiqueta e) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            doc.setXmlStandalone(true);
            doc.appendChild(crearCuerpo(e, doc));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter sw = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();
        } catch (ParserConfigurationException | DOMException | IllegalArgumentException | TransformerException ex) {
            return "error guey";
        }

    }

    private static Element crearCuerpo(Etiqueta e, Document doc) {
        Element el = doc.createElement(e.n);
        if (e.v != null) {
            el.appendChild(doc.createTextNode(e.v.toString()));
        }
        else if (e.h.size() > 0) {
            for (Etiqueta et : e.h) {
                el.appendChild(crearCuerpo(et, doc));
            }
        } 
        return el;
    }

    public static class Etiqueta {

        public String n;
        public Object v;
        public List<Etiqueta> h = new ArrayList<Etiqueta>();

        public Etiqueta(String n, Object v) {
            this.n = n;
            this.v = v;
        }

        public Etiqueta(String n, Etiqueta... ets) {
            this.n = n;
            for (Etiqueta e : ets) {
                this.h.add(e);
            }
        }

    }

    public static String parsearXML(String xml){
        return "";
    }
    
}
