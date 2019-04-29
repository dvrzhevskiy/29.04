package ru.itmonopoly.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlExample {

    public static void main(String[] args) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();


        Document document = builder.parse(new File("pom.xml"));

        Element root = document.getDocumentElement();
        System.out.println(root.getTagName());

        NodeList childNodes = root.getChildNodes();
        for(int i=0;i<childNodes.getLength();i++){
            Node item = childNodes.item(i);
            System.out.println("  "+item.getNodeName());
                    if(item.getNodeType()==Node.TEXT_NODE){
                System.out.println( "t"+item.getTextContent());
            }
        }
    }
}
