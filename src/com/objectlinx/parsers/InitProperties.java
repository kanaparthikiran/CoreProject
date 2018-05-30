/**
 * 
 */
package com.objectlinx.parsers;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.objectlinx.util.BuildConstants;

/**
 * @author kikanapa
 *
 */
public class InitProperties  {

	private static final Logger log = Logger.getLogger(InitProperties.class.getName());
	private static Map<String,List<String>> clusterMapInit = new ConcurrentHashMap<String,List<String>>();
	
	/**
	 * 
	 * @return
	 */
	public static final Map<String,List<String>> getHashMap() {
		File file = null;
		FileInputStream fis = null;
		XMLDecoder decode = null;
		Map<String,List<String>> dataMap = new HashMap<String,List<String>>();
		try {
			file = new File(BuildConstants.propFile);
			fis = new FileInputStream(file);
			decode = new XMLDecoder(fis);
			dataMap = (ConcurrentHashMap<String,List<String>>)decode.readObject();
			Set<String> mKeySet = dataMap.keySet();
			for(String se : mKeySet) {
				List<String> valList =  dataMap.get(se);
				for(String val : valList) {
					log.info("Elements in the Map->List are : Cluster -"+ se +" Server - " + val);
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(decode!=null) {
				decode.close();
				}
				if(fis!=null) {
				fis.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
			return dataMap;
	}
	
	
	
	/**
	 * 
	 */
	public static void storeHashMap(Map<String,List<String>> clusterMap) {
		File file = null;
		FileOutputStream fos = null;
		XMLEncoder encode = null;
		try {
			file = new File(BuildConstants.propFile);
			fos = new FileOutputStream(file);
			encode = new XMLEncoder(fos);
			encode.writeObject(clusterMap);
			log.info("Done Saving the Map to propFile.properties file");
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(encode!=null) {
				encode.flush();
				encode.close();
				}
				if(fos!=null) {
				fos.flush();
				fos.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	
	/**
	 * 
	 * @param parseDDPath
	 * @return
	 */
	public static 	Map<String,List<String>> getClusterAndServerFromXML(String parseDDPath) {
			List<String>  serverList =null;
			String clusterName="";
			String serverName="";
			try {
				Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(parseDDPath);
				doc.normalize();
				Element rootNode = doc.getDocumentElement();
				log.info("Root Node Name :" + rootNode);
				NodeList nodeList = rootNode.getElementsByTagName("cluster");
				for(int i=0;i<nodeList.getLength();i++) {
						Node clusterNode = nodeList.item(i);
					if(clusterNode.getNodeType() == Node.ELEMENT_NODE) {
						Element clusterElement = (Element)clusterNode;
						clusterName = clusterElement.getAttribute("name");
						log.info("cluster Node :"+ clusterNode.getTextContent().trim()+" cluserName "+clusterName);
						NodeList serverNodes = clusterElement.getElementsByTagName("server");
						serverList = new ArrayList<String>();
						for(int j=0;j<serverNodes.getLength();j++) {
							Node serverNode = serverNodes.item(j);
							if(serverNode.getNodeType() == Node.ELEMENT_NODE) {
								Element serverElement = (Element)serverNode;
								serverName = serverElement.getAttribute("name");
								log.info("server Element Name :" + serverName);
								serverList.add(serverName);
							}
						}
					}
					log.info("server list size before placing in map:"+ serverList.size());
					clusterMapInit.put(clusterName, serverList);
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			log.info("Cluster Map Size Before returning the Method "+clusterMapInit.size());
			storeHashMap(clusterMapInit);
			return clusterMapInit;
		}
	
	/**
	 * 
	 * @param parseDDPath
	 * @return
	 */
	public static 	Map<String,List<String>> getClusterAndServerFromPropXML(String parseDDPath) {
			List<String>  serverList =null;
			String clusterName="";
			String serverName="";
			try {
				Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(parseDDPath);
				document.normalize();
				NodeList propNodeList = document.getElementsByTagName("propertyfile");
				for(int i=0;i<propNodeList.getLength();i++) {
					Node propNode = propNodeList.item(i);
					if(propNode.getNodeType() == Node.ELEMENT_NODE) {
						Element propElement = (Element)propNode;
						NodeList propChildNodeList = propElement.getElementsByTagName("property");
						for(int j=0;j<propChildNodeList.getLength();j++) {
							Node propChildNode =  propChildNodeList.item(j);
							if(propChildNode.getNodeType() ==  Node.ELEMENT_NODE) {
								Element propChildElement = (Element)propChildNode;
								
								
							}
							
							
						}
					}
					
				}
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			log.info("Cluster Map Size Before returning the Method "+clusterMapInit.size());
			storeHashMap(clusterMapInit);
			return clusterMapInit;
		}
	

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Map<String,List<String>> myMap = getClusterAndServerFromXML(BuildConstants.parseDDPath);
		
		Map<String,List<String>> myMap = getClusterAndServerFromXML(BuildConstants.parseDDPath);
	}
}
