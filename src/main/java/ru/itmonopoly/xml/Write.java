package ru.itmonopoly.xml;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Write {
    public static void main(String[] args)throws Exception {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

        Document document = documentBuilder.newDocument();

        Element root = document.createElement("question");
        document.appendChild(root);
        root.setAttribute("name", "Лает?");

        for(int i=0;i<100;i++){
            Element yes = document.createElement("yes");
            root.appendChild(yes);

            Element zver = document.createElement("zver");
            yes.appendChild(zver);


        }


        //transform the DOM Object to an XML File
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult =
                new StreamResult(new File("zver.xml"));

        transformer.transform(domSource, streamResult);
    }
}
