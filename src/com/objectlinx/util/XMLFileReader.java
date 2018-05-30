/**
 * 
 */
package com.objectlinx.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author kikanapa
 * 
 */
public class XMLFileReader {

	private static final Logger log = Logger.getLogger(XMLFileReader.class
			.getName());
	private static Map<String, Properties> propMap = new HashMap<String, Properties>();
	private static StringBuffer sb = new StringBuffer();

	/**
	 * 
	 * @param clusterName
	 * @param serverName
	 * @param propFileName
	 */
	public static void parseXML(String clusterName, String serverName,
			String propFileName) {

		try {

			File fXmlFile = new File("src\\properties.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			log.info("Root Element  NEW :"
					+ doc.getDocumentElement().getTagName());
			log.info("Root element :" + doc.getDocumentElement().getNodeName());
			
			Element rootElement = doc.getDocumentElement();
			NodeList clusters = rootElement.getElementsByTagName("cluster");
			
		//	NodeList nList = doc.getElementsByTagName("cluster");
			
			log.info("-----------------------");
			for(int i=0;i<clusters.getLength();i++) {
				Node clusterNode = clusters.item(i);
				if(clusterNode.getNodeType() == Node.ELEMENT_NODE) {
					Element clusterElement = (Element)clusterNode;
			//		log.info("Cluster Name :" + clusterElement.getTagName()+"  \t Attribute  "+ clusterElement.getAttribute("name"));
					String myClusterName = clusterElement.getAttribute("name");
					
					//Cluster Name Matching
					if(myClusterName.equalsIgnoreCase(clusterName)) {
						
						log.info("Cluster Name Matching **********");
						NodeList serverNodes = clusterElement.getElementsByTagName("server");
						for(int j=0;j<serverNodes.getLength();j++) {
							Node serverNode = serverNodes.item(j);
							if(serverNode.getNodeType() == Node.ELEMENT_NODE) {
								Element serverElement = (Element) serverNode;
		//						log.info("Server name :"  + serverElement.getTagName()+" Attribute Value :"+ serverElement.getAttribute("name"));
								String myServerName =  serverElement.getAttribute("name");
								
								//ServerName Matching
								if(myServerName.equalsIgnoreCase(serverName)) {
									log.info("Server Name Matching **********");
									
									NodeList propFileNodes = serverElement.getElementsByTagName("propertyfile");
									
									for(int k=0;k<propFileNodes.getLength();k++) {
										
										Node  propFileNode = propFileNodes.item(k);
										if(propFileNode.getNodeType() == Node.ELEMENT_NODE) {
											Element propFileElement = (Element)propFileNode;
											log.info("Prop File  :" +  propFileElement.getTagName()+ " Name : "+ propFileElement.getAttribute("name"));
											String myPropFileName = propFileElement.getAttribute("name");
											
											//PropertyFile name matching
											if(propFileName.equalsIgnoreCase(myPropFileName)) {
												log.info("Property File Name Matching ******Now Retrieving Properties");
												
												
												NodeList propNodes =  propFileNode.getChildNodes();
												for(int l=0;l<propNodes.getLength();l++) {
													Node propNode = propNodes.item(l);
													if(propNode.getNodeType() == Node.ELEMENT_NODE) {
														Element propElement = (Element)propNode;
														writeToProperties(propElement,propFileName);
														
													//	log.info("Property Details in Main : Tag Name" +  propElement.getTagName()+" Text Content:" +  propElement.getTextContent()+"  "+"  Attrib Value: "+ propElement.getAttribute("name"));
													}
													
													
												}
										//		getTextValue(propElement,"property");
												//log.info("Properties Details :"+ propNodes.item(k));
												getProperties("","","");
											}
											
										}
										
									}
									
								}
								
							}
							
						}
						
					}
				}
				
			}
			
			log.info("-----------------------");


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param ele
	 * @param tagName
	 * @return
	 */
	private static String getTextValue(Element ele, String tagName) {
	String textVal = null;
	NodeList nl = ele.getElementsByTagName(tagName);
	if(nl != null && nl.getLength() > 0) {
		Element el = (Element)nl.item(0);
		NodeList nodeList = el.getChildNodes();
		for(int i=0;i<nodeList.getLength();i++) {
		textVal = nodeList.item(i).getNodeValue(); 
		log.info("Node Text Value :" + textVal);
	}
	}
	return textVal;
	}
	
	/**
	 * 
	 * @param element
	 * @return
	 */
	private static String getTextValue_Ex(Element element,String tagName) {
		String textValue = null;
		log.info("Called method inside  :"+element.getTagName()+ " "+ tagName);
		NodeList nodeList = element.getElementsByTagName(tagName);
		if(nodeList!=null && nodeList.getLength()>0) {
			for(int n=0;n<nodeList.getLength();n++) {
				Node node = nodeList.item(n);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element myElement = (Element)node;
					log.info("Inside Function  Content****"+ myElement.getTextContent()+ " Attribute: "+ myElement.getAttribute("property"));
				}
			}
			
		}
		return null;
	}
	
	/**
	 * 
	 * @param sTag
	 * @param eElement
	 * @return
	 */
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}

	/**
	 * 
	 * @param filePath
	 */
/*	public static void writeToPropertiesFiles(String filePath,String name, String value) throws Exception {
		
		File propFilePath = new File(filePath);
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(propFilePath));
		bWriter.newLine();
		String property = name+"="+value;
		bWriter.append(property);
		bWriter.flush();
		
	}*/
	
	/**
	 * 
	 * @param filePath
	 */
	public static void writeToPropertiesFiles(String filePath,StringBuffer name) throws Exception {
		
		File propFilePath = new File(filePath);
		FileWriter fileWriter = new FileWriter(propFilePath,true);
	//	BufferedWriter bWriter = new BufferedWriter(new FileWriter(propFilePath));
		BufferedWriter bWriter = new BufferedWriter(fileWriter);
		bWriter.newLine();
		
		bWriter.append(name);
		bWriter.flush();
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static void writeToProperties(Element propElement,String propFileName) {
		Properties props = new Properties();
		String propKey = propElement.getAttribute("name");
		String propValue= propElement.getTextContent();
		try {
		log.info("Property Details in Main : Tag Name" +  propElement.getTagName()+"  "+" Prop Key "+ propKey  +" Prop Value " + propValue);
		props.put(propKey, propValue);
	/*	props.put("hibernate.connection.driver_class",
				"oracle.jdbc.OracleDriver");*/
		propMap.put("one", props);
		
		sb.append(propKey+"="+propValue+"\n");
	
		writeToPropertiesFiles(propFileName,sb);
		
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	public static Properties getProperties(String propFileName, String clusterName,
			String serverName) {
		Map myMap = propMap;
		Properties myProp =  (Properties)myMap.get("one");
		
		for(int i=0;i<myProp.size();i++) {
			myProp.get("hibernate.c3p0.timeout");
			
		}
		
		log.info("Properties from the Class Props :" + myProp.get("hibernate.c3p0.timeout"));
		return null;
	}

	/**
	 * 
	 * @param element
	 * @param tagName
	 */
	private static String getTagValue(Element element, String tagName) {
		NodeList childNodeList = element.getElementsByTagName(tagName).item(0)
				.getChildNodes();
		Node childNode = childNodeList.item(0);
		String childNodeValue = childNode.getNodeValue();
		return childNodeValue;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// parseXML("src\\hibernate.cfg.xml");
		parseXML("culster1", "server1", "data.properties");
	}

}
