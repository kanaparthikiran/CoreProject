/**
 * 
 */
package com.objectlinx.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 * @author kikanapa
 * 
 */
public class XMLFileProcessor {

	private static final Logger log = Logger.getLogger(XMLFileProcessor.class
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

			File fXmlFile = new File("src\\propertiesNew.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			log.info("Root Element  NEW :"
					+ doc.getDocumentElement().getTagName());
			log.info("Root element :" + doc.getDocumentElement().getNodeName());
			
			Element rootElement = doc.getDocumentElement();
	//		NodeList clusters = rootElement.getElementsByTagName("propertyfile");
			
		//	NodeList nList = doc.getElementsByTagName("cluster");
			
			log.info("-----------------------");
		/*	for(int i=0;i<clusters.getLength();i++) {
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
									log.info("Server Name Matching **********");*/
									
									NodeList propFileNodes = rootElement.getElementsByTagName("propertyfile");
									
									for(int k=0;k<propFileNodes.getLength();k++) {
										
										Node  propFileNode = propFileNodes.item(k);
										if(propFileNode.getNodeType() == Node.ELEMENT_NODE) {
											Element propFileElement = (Element)propFileNode;
											log.info("Prop File  :" +  propFileElement.getTagName()+ " Name : "+ propFileElement.getAttribute("name"));
											String myPropFileName = propFileElement.getAttribute("name");
											log.info(" myPropFileName :  "+ myPropFileName+" propertyFileName: "+propFileName);
											//PropertyFile name matching
											if(propFileName.equalsIgnoreCase(myPropFileName)) {
												log.info("Property File Name Matching ******Now Retrieving Properties");
												
												NodeList propNodes =  propFileNode.getChildNodes();
												
												for(int l=0;l<propNodes.getLength();l++) {
													Node propNode = propNodes.item(l);
													if(propNode.getNodeType() == Node.ELEMENT_NODE) {
														Element propElement = (Element)propNode;
														writeToPropertiesTwo(propFileName,propElement);
														
													//	log.info("Property Details in Main : Tag Name" +  propElement.getTagName()+" Text Content:" +  propElement.getTextContent()+"  "+"  Attrib Value: "+ propElement.getAttribute("name"));
													}
													
													
												}
										//		getTextValue(propElement,"property");
												//log.info("Properties Details :"+ propNodes.item(k));
												getProperties("","","");
											}
											
										}
										
										/*			}
									
							}
								
							}*/
							
		/*				}
						
					}
				}
			*/	
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
	public static void writeToProperties(Element propElement) {
		
//		log.info("Called : writeToProperties");
		Properties props = new Properties();
		String propKey = propElement.getAttribute("name");
		
		//String propValueKey = propElement.getAttribute("value");
		
//		log.info("Cluster Details :"+propValueKey );
		NodeList sCNodeList = propElement.getElementsByTagName("value");
				//.getChildNodes();
	//	NodeList sCNodeList =  propElement.getElementsByTagName("value");
		
		log.info("scNodeList Size :"+ sCNodeList.getLength());
		
		log.info("Now Printing the Values of the Values for Server and Cluster Details ***********");
		
		for(int i=0;i<sCNodeList.getLength();i++) {
				Node sCValueNode =  sCNodeList.item(i);
				if(sCValueNode.getNodeType() == Node.ELEMENT_NODE || 1>0) {
					Element scValueElement = (Element)sCValueNode;
				/*	log.info("Node Data:" + scValueElement.getData());
					log.info("Whole Text:" + scValueElement.getWholeText());
					log.info("Prfix:" + scValueElement.getPrefix());*/
					log.info("Node Value:" + scValueElement.getNodeValue());
					
					/*log.info("Value Element Details : Node Name^^^^^" + sCValueNode.getNodeName()
							+"  NodeType : "+"   "+sCValueNode.getNodeType()+" Node Value:  "+sCValueNode.getNodeValue());*/
						log.info("Cluster Name : "+  scValueElement.getAttribute("cluster")+ " Server Name : "+ scValueElement.getAttribute("server"));
					
							//sCValueNode.getAttribute("cluster"));
				}
		}
		
		String propValue= propElement.getTextContent();
		//		log.info("Property Details in Main : Tag Name" +  " Prop Key "+ propKey  +" Prop Value " + propValue);
		try {
		log.info("Property Details in Main : Tag Name" +  propElement.getTagName()+"  "+" Prop Key "+ propKey  +" Prop Value " + propValue);
		props.put(propKey, propValue);
	/*	props.put("hibernate.connection.driver_class",
				"oracle.jdbc.OracleDriver");*/
		propMap.put("one", props);
		
		sb.append(propKey+"="+propValue+" ");
	
		writeToPropertiesFiles("hibernate.cfg.properties",sb);
		
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static void writeToPropertiesTwo(String propFilePath , Element propElement) {
		
//		log.info("Called : writeToProperties");
		Properties props = new Properties();
		String propKey = propElement.getAttribute("name");
		
		String serverName = "";
		String clusterName="";
		
		
		//String propValueKey = propElement.getAttribute("value");
		
//		log.info("Cluster Details :"+propValueKey );
		NodeList sCNodeList = propElement.getElementsByTagName("value");
				//.getChildNodes();
	//	NodeList sCNodeList =  propElement.getElementsByTagName("value");
		String propValue=  null;
		log.info("scNodeList Size :"+ sCNodeList.getLength());
		
		log.info("Now Printing the Values of the Values for Server and Cluster Details ***********");
		
		for(int i=0;i<sCNodeList.getLength();i++) {
				Node sCValueNode =  sCNodeList.item(i);
				if(sCValueNode.getNodeType() == Node.ELEMENT_NODE || 1>0) {
					Element scValueElement = (Element)sCValueNode;
				/*	log.info("Node Data:" + scValueElement.getData());
					log.info("Whole Text:" + scValueElement.getWholeText());
					log.info("Prfix:" + scValueElement.getPrefix());*/
					log.info("Node Value:" + scValueElement.getNodeValue());
					
					/*log.info("Value Element Details : Node Name^^^^^" + sCValueNode.getNodeName()
							+"  NodeType : "+"   "+sCValueNode.getNodeType()+" Node Value:  "+sCValueNode.getNodeValue());*/
						propValue = propElement.getTextContent().trim();
						clusterName = scValueElement.getAttribute("cluster");
						serverName =  scValueElement.getAttribute("server");
						log.info("Cluster Name : "+ clusterName + " Server Name : "+serverName);
						
						sb.append(propKey+"="+propValue+"\n");
						
						writeToPropertiesFiles(clusterName+"_"+serverName+""+propFilePath,sb);
						
					
							//sCValueNode.getAttribute("cluster"));
				}
		}
		
		//String propValue= propElement.getTextContent();
		//		log.info("Property Details in Main : Tag Name" +  " Prop Key "+ propKey  +" Prop Value " + propValue);
		try {
		log.info("Property Details in Main : Tag Name" +  propElement.getTagName()+"  "+" Prop Key "+ propKey  +" Prop Value " + propValue);
		props.put(propKey, propValue);
	/*	props.put("hibernate.connection.driver_class",
				"oracle.jdbc.OracleDriver");*/
		propMap.put("one", props);
		
	/*	sb.append(propKey+"="+propValue+"\n");
	
		writeToPropertiesFiles("hibernate.cfg.properties",sb);*/
		
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	

	/**
	 * 
	 * @param filePath
	 */
	public static void writeToPropertiesFiles(String filePath,String name, String value) throws Exception {
		
		File propFilePath = new File(filePath);
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(propFilePath));
		bWriter.newLine();
		String property = name+"="+value;
		bWriter.append(property);
		bWriter.flush();
		
	}
	
	/**
	 * 
	 * @param filePath
	 */
	public static void writeToPropertiesFiles(String filePath,StringBuffer name) {
		
		File propFilePath = new File(filePath);
		try {
		FileWriter fileWriter = new FileWriter(propFilePath,true);
	//	BufferedWriter bWriter = new BufferedWriter(new FileWriter(propFilePath));
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
		parseXML("culster1", "server1", "hibernate.cfg.properties");
	}

}
