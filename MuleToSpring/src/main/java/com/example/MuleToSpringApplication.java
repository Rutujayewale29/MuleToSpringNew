package com.example;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@SpringBootApplication
public class MuleToSpringApplication {
	private static final String FILENAME = "D:\\STS\\MuleToSpring\\MuleToSpring\\src\\main\\resources\\Input\\muleflow.xml";

	public static void main(String[] args) 
	{
		
		//SpringApplication.run(MuleToSpringApplication.class, args);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try
		{
			dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			DocumentBuilder db = dbf.newDocumentBuilder();
	          Document doc = db.parse(new File(FILENAME));
	          
	          doc.getDocumentElement().normalize();
	          NodeList rootElement = doc.getChildNodes();

	          NodeList nlist = rootElement.item(0).getChildNodes();
	          //for mule
	          System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
	        //for flow
	        //  NodeList list = doc.getElementsByTagName("flow");

	          for (int temp = 0; temp < nlist.getLength(); temp++) {
	        	  Node node = nlist.item(temp);
	        	  System.out.println("\nCurrent Element :" + node.getNodeName());
	        	  if (node.getNodeType() == Node.ELEMENT_NODE) {
	        		  Element element = (Element) node;
	        		  String name = element.getAttribute("name");
	        		  System.out.println(node.getNodeName());
	        		  System.out.println("name : " + name);
	        		  
	        		 
                        //for http:listener
	        		 // NodeList httpListenerNodeList = doc.getElementsByTagName("http:listener");
	        		//  NodeList httpListenerNodeList = element.getElementsByTagName("http:listener");
	        		//  System.out.println(node);
	        		//  String httpListener = httpListenerNodeList.item(0).getTextContent();
	        		  //System.out.println(node.getNodeName());
	        		  //System.out.println(httpListener);
	        		  
	        		  //get Attributes from httpListener
	        		 // String configRef = httpListenerNodeList.item(0).getAttributes().getNamedItem("config-ref").getTextContent();
	        		  //String path = httpListenerNodeList.item(0).getAttributes().getNamedItem("path").getTextContent();
	        		  //System.out.println("http:listener : " + httpListener);
	                  //System.out.println("configRef : " + configRef);
	                  //System.out.println("path : " + path);
	        		  
	                  
	        		  //for logger
	        		  NodeList loggerNodeList = element.getElementsByTagName("logger");
	        		  String logger = loggerNodeList.item(0).getTextContent();
	        		  //get attributes from logger
	        		  String level = loggerNodeList.item(0).getAttributes().getNamedItem("level").getTextContent();
	        		  String message = loggerNodeList.item(0).getAttributes().getNamedItem("message").getTextContent();
	        		  System.out.println("logger : ");
		                 // System.out.println(node.getNodeName());
		                  System.out.println("level : " + level);
		                  System.out.println("message : " + message);
		                  
		                  
	        		  //for ee:transform
	        		  //NodeList transformNodeList = element.getElementsByTagName("ee:transform");
	        		  //String transform = transformNodeList.item(0).getTextContent();
	        		  //get
	        		  //for set:payload
	        		  NodeList setPayloadNodeList = element.getElementsByTagName("set-payload");
	        		  String setPayload = setPayloadNodeList.item(0).getTextContent();
	        		  //get Attributes from set:payload
	        		  String value = setPayloadNodeList.item(0).getAttributes().getNamedItem("value").getTextContent();
	        		  System.out.println("setPayload : ");
		                 // System.out.println(node.getNodeName());
		                  System.out.println("value : " + value);
		                  
		                  
	        		  //for logger
	        		  NodeList logger1NodeList = element.getElementsByTagName("logger1");
	        		  String logger1 = logger1NodeList.item(0).getTextContent();
	        		  //get attributes from logger1
	        		  String level1 = logger1NodeList.item(0).getAttributes().getNamedItem("level").getTextContent();
	        		  String message1 = logger1NodeList.item(0).getAttributes().getNamedItem("message").getTextContent();
	        		  System.out.println("logger : ");
		                 // System.out.println(node.getNodeName());
		                  System.out.println("level1 : " + level1);
		                  System.out.println("message1 : " +message1);
      		
	                  
	        	  }
	          }
	          
              
		}
		catch (ParserConfigurationException | SAXException | IOException e) {
	          e.printStackTrace();
	      }
	
	}

}
