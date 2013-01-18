/**
 * 
 */
package com.cisco.np6.parsers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.cisco.np6.util.NPProp;

/**
 * @author kikanapa
 * 
 */
public class XMLFileReaderNew {

	private static final Logger log = Logger.getLogger(XMLFileReaderNew.class
			.getName());
	private static Map<String, NPProp> propMap = new ConcurrentHashMap<String, NPProp>();
	private static Map<String, String> propertyMap = new ConcurrentHashMap<String, String>();
	private static Set<String> propFilesSet = new HashSet<String>();
	private static String parseXMLPath = "src\\propertiesDefs.xml";

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

			File fXmlFile = new File(parseXMLPath);

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			log.info("Root Element  NEW :"
					+ doc.getDocumentElement().getTagName());
			log.info("Root element :" + doc.getDocumentElement().getNodeName());
			
			Element rootElement = doc.getDocumentElement();
			
			log.info("-----------------------");
			NodeList propFileNodes = rootElement
					.getElementsByTagName("propertyfile");
			for (int k = 0; k < propFileNodes.getLength(); k++) {
				Node propFileNode = propFileNodes.item(k);
				if (propFileNode.getNodeType() == Node.ELEMENT_NODE) {
					Element propFileElement = (Element) propFileNode;
					log.info("Prop File  :" + propFileElement.getTagName()
							+ " Name : " + propFileElement.getAttribute("name"));
					String myPropFileName = propFileElement
							.getAttribute("name");
					log.info(" myPropFileName :  " + myPropFileName
							+ " propertyFileName: " + propFileName);

					NodeList propNodes = propFileNode.getChildNodes();
					for (int l = 0; l < propNodes.getLength(); l++) {
						Node propNode = propNodes.item(l);
						if (propNode.getNodeType() == Node.ELEMENT_NODE) {
							Element propElement = (Element) propNode;
							storeProperties(propFileName, propElement);
						
							}
						}
				}
				}
		} catch (Exception e) {
			log.info("-----------------------");
			e.printStackTrace();
		}
	}


	
	

	
	
	/**
	 * 
	 * @return
	 */
	public static void storeProperties(String propFilePath , Element propElement) {
		log.info("Called Stored Properties*****");
		Properties props = new Properties();
		String propKey = propElement.getAttribute("name");
		
		String serverName = "";
		String clusterName="";

		NodeList sCNodeList = propElement.getElementsByTagName("value");

		String propValue=  null;
		log.info("scNodeList Size :"+ sCNodeList.getLength());
		
		log.info("Now Printing the Values of the Values for Server and Cluster Details ***********");
		
		for(int i=0;i<sCNodeList.getLength();i++) {
				Node sCValueNode =  sCNodeList.item(i);
				if(sCValueNode.getNodeType() == Node.ELEMENT_NODE) {
					Element scValueElement = (Element)sCValueNode;

					log.info("Node Value:" + scValueElement.getNodeValue());
					propValue = propElement.getTextContent().trim();
					clusterName = scValueElement.getAttribute("cluster");
					serverName =  scValueElement.getAttribute("server");
					log.info("Cluster Name : "+ clusterName + " Server Name : "+serverName);
					StringBuffer sbLocal = new StringBuffer();	
					String key = clusterName+"_"+serverName+"_"+propFilePath;
					String propertyFileName = clusterName+"_"+serverName+"_"+propFilePath;
					
					String propertyFileNameKey = propertyFileName+"_"+propKey;
					
					String value = "";
					//propKey+"="+propValue+"\n";
					sbLocal.append(propKey+"="+propValue+"\n");
					//place property key and values in properties
					props.put(propKey, propValue);
					NPProp npProp = new NPProp();
					
					npProp.setFilePath(propertyFileName);
					npProp.setPropKey(propKey);
					npProp.setPropValue(propValue);
					
					
					propMap.put(propertyFileNameKey, npProp);
					
					writeToPropertiesFiles(clusterName+"_"+serverName+"_"+propFilePath,sbLocal);
				//	propFilesSet.add(propertyFileName);
				}
		}
					log.info("Property Details in Main : Tag Name" +  propElement.getTagName()+"  "+" Prop Key "+ propKey  +" Prop Value " + propValue);
	}
	


	
	/**
	 * 
	 * @param filePath
	 */
public static void writeToPropertiesFiles(String filePath,StringBuffer name) {
		
		File propFilePath = new File(filePath);
		try {
		FileWriter fileWriter = new FileWriter(propFilePath,true);
		BufferedWriter bWriter = new BufferedWriter(fileWriter);
	//	bWriter.newLine();
		bWriter.append(name);
		bWriter.flush();
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
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// parseXML("src\\hibernate.cfg.xml");
		String inputPropFile  =  "hibernate.cfg.properties";
		String inputCluster = "cluster1";
		String inputServer = "server1";
		parseXML(inputCluster, inputServer, inputPropFile);
		//writeToPropertiesFiles("",new StringBuffer(""));
	}

}
