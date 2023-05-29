package com.example;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.AttributeList;
import org.xml.sax.SAXException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
public class ReadXml {
	public ReadJson read;
	
	public void iterateChildNode( NodeList nlist)
	{
	  for (int temp = 0; temp < nlist.getLength(); temp++) {
		 Node node = nlist.item(temp);
	       	  if (node.getNodeType() == Node.ELEMENT_NODE) {
	       		  Element element = (Element) node;
	       		  System.out.println(node.getNodeName());
	       		if(node.hasAttributes())
	     		  {
	       		 NamedNodeMap attributes = node.getAttributes();
	             for (int a = 0; a < attributes.getLength(); a++) {
	               Node theAttribute = attributes.item(a);
	               System.out.println(theAttribute.getNodeName() + "=" + theAttribute.getNodeValue());
	           }
	         }       		
      	   }
	    } 
	  }

	private static final String FILENAME = "D:\\STS\\MuleToSpring\\MuleToSpring\\src\\main\\resources\\Input\\muleflow.xml";
	public static void main(String[] args) {
		ReadXml obj=new ReadXml();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try
		{
			dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			DocumentBuilder db = dbf.newDocumentBuilder();
	          Document doc = db.parse(new File(FILENAME));
	          doc.getDocumentElement().normalize();
	          NodeList rootElement = doc.getChildNodes();
              NodeList nlist = rootElement.item(0).getChildNodes();
	          System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
	          	  for (int temp = 0; temp < nlist.getLength(); temp++)
	          	 {
       	         Node node = nlist.item(temp);
       	       	  if(node.getNodeType()==Node.ELEMENT_NODE)
       	  {
       		  Element element=(Element)node;
       		  System.out.println(element.getNodeName());
       		   if(node.hasAttributes())
     		  {
       		NamedNodeMap attributes = node.getAttributes();
	        for (int a = 0; a < attributes.getLength(); a++) {
	         Node theAttribute = attributes.item(a);
	         
	         System.out.println(theAttribute.getNodeName() + "=" + theAttribute.getNodeValue());
	          }
       		  }
               if(node.hasChildNodes() && node.hasAttributes())
               {
            	 obj.iterateChildNode(node.getChildNodes());
//            	 JSONArray data = writeJson(doc.getChildNodes());
//   	             System.out.println(data);
   	            }
             }
       	   }    
	     }
		 catch (ParserConfigurationException | SAXException | IOException e) {
	          e.printStackTrace();
	      }
	 }
}
