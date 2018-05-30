/**
 * 
 */
package com.objectlinx.parsers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

import com.objectlinx.util.NPProp;

/**
 * @author kikanapa
 * 
 */
public class CopyOfDOMXMLFileReaderWorking {

	private static final Logger log = Logger.getLogger(CopyOfDOMXMLFileReaderWorking.class
			.getName());
	private static Map<String, NPProp> propMap = new ConcurrentHashMap<String, NPProp>();
	private static Map<String, Properties> proMap = new ConcurrentHashMap<String, Properties>();
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
	public static void parseXML(String clusterName, String serverName) {

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
					
					String myPropFilePath = propFileElement.getAttribute("location");
					
					
					
					log.info(" myPropFileName :  " + myPropFileName
							+ " propertyFileName: " + " PropertyFilePath"+ myPropFilePath);
					

					NodeList propNodes = propFileNode.getChildNodes();
					
					Properties props = new Properties();
					
					for (int l = 0; l < propNodes.getLength(); l++) {
						Node propNode = propNodes.item(l);
						if (propNode.getNodeType() == Node.ELEMENT_NODE) {
							Element propElement = (Element) propNode;
							Properties storeProps = storeProperties(myPropFileName,myPropFilePath, propElement,clusterName,serverName);
							props.putAll(storeProps);
							log.info("Adding each property values to Props for Each property" +props.size());
							}
						}
					
					log.info("Adding OverAll Props to proMap"+props.size());
					proMap.put(myPropFileName, props);
					log.info("propMap Size :"+ proMap.size());
					
					
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
	public static Properties storeProperties(String propertyFileName, String propFilePath , Element propElement,String clusterName,String serverName) {
		log.info("Called Stored Properties*****");
		Properties props = new Properties ();
		String propertyKey = propElement.getAttribute("name");
		
		String MserverName = "";
		String MclusterName="";
		String propertyValue="";

		NodeList sCNodeList = propElement.getElementsByTagName("value");

		String propValue=  null;
		
		log.info("scNodeList Size :"+ sCNodeList.getLength());
		
		log.info("Now Printing the Values of the Values for Server and Cluster Details ***********");
		
		for(int i=0;i<sCNodeList.getLength();i++) {
				Node sCValueNode =  sCNodeList.item(i);
				if(sCValueNode.getNodeType() == Node.ELEMENT_NODE) {
					Element scValueElement = (Element)sCValueNode;

					log.info("Node Value:" + scValueElement.getNodeValue());
				//	propValue = propElement.getTextContent().trim();
					clusterName = scValueElement.getAttribute("cluster");
					serverName =  scValueElement.getAttribute("server");
					propertyValue = scValueElement.getTextContent().trim();
					log.info("Cluster Name : "+ clusterName + " Server Name : "+serverName+" property Value:"+propertyValue+"propertyName: "+propertyKey);
					StringBuffer sbLocal = new StringBuffer();	
					String key = clusterName+"_"+serverName+"_"+propFilePath;
		//			propertyFileName = clusterName+"_"+serverName+"_"+propFilePath;
					
					String propertyFileNameKey = propertyFileName+"_"+propertyKey;
					
					String value = "";
					//propKey+"="+propValue+"\n";
					sbLocal.append(propertyKey+"="+propertyValue+"\n");
					//place property key and values in properties
					props.put(propertyKey, propertyValue);
					log.info("Adding Properties to Props : Name: "+ propertyKey+" propValue: "+propertyValue);
					
					
					NPProp npProp = new NPProp();
					npProp.setFilePath(propertyFileName);
					npProp.setPropKey(propertyKey);
					npProp.setPropValue(propValue);
					
					
					//propMap.put(propertyFileNameKey, npProp);
					
					//log.info(message)
			//		proMap.put(propertyFileName, props);
					
				//	writeToPropertiesFiles(clusterName+"_"+serverName+"_"+propFilePath,sbLocal);
				//	propFilesSet.add(propertyFileName);
				}
			
		}
		log.info("Came out of the Property Evaluation");
		//			log.info("Property Details in Main : Tag Name" +  propElement.getTagName()+"  "+" Prop Key "+ propKey  +" Prop Value " + propValue);
		
		return props;
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
		Map<String,Properties> myMap = proMap;
		
		Properties myProp =  (Properties)myMap.get(propFileName);
		Set<Object> mapkeys = myProp.keySet();
		for(Object mapKey : mapkeys) {
			
			log.info("Map Key :"+ (String)mapKey+" Map(Prop) Value: "+myProp.get(mapKey));
			
			
		}
		
/*		for(int i=0;i<myProp.size();i++) {
			myProp.get("hibernate.c3p0.timeout");
		
		log.info("Properties from the Class Props :" + myProp.get("hibernate.c3p0.timeout"));
		}*/
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
		parseXML(inputCluster, inputServer);
		getProperties("hibernate.cfg.properties","","");
		//writeToPropertiesFiles("",new StringBuffer(""));
		readWriteProperties("hibernate.cfg.properties");
	}

	
	/**
	 * 
	 * @param propFileName
	 */
	public static void readWriteProperties(String propFileName) throws Exception {
		Map<String,Properties> myMap = proMap;
		Properties pr = new Properties();
		pr.load(new BufferedReader(new FileReader(propFileName)));
		log.info("Read Properties Successfully to Properties from input file");
		
		Set<Object> common= pr.keySet();
		
		//Set<Object> common =new HashSet<Object>();
		Properties myProp =  (Properties)myMap.get(propFileName);
		Set<Object> mapkeys = myProp.keySet();
		
		log.info("Properties Size before removing Common Properties"+pr.size());
		Set<Object> backUp  = common;
		//common.retainAll(mapkeys);
		
		//common.removeAll(mapkeys);
		for(Object mapKey : mapkeys) {
			if(common.contains(mapKey)) {
				log.info("Adding Modified Properties to the Property: Name :"
			+ mapKey+"Prop Value: "+myProp.get(mapKey));
				pr.put(mapKey, myProp.get(mapKey));
/*				
				common.remove(mapKey);
				common.add(mapKey);*/
				
			}
		}
		
		log.info("Properties Size AFTER removing Common Properties"+pr.size());
		
		
		
		pr.store(new BufferedWriter(new FileWriter(propFileName)),"Adding Values");
		log.info("Added Properties Successfully to output file");
		
		
	}
}
