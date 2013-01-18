/**
 * 
 */
package com.cisco.np6.parsers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
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

import com.cisco.np6.util.BuildConstants;


/**
 * @author kikanapa
 * 
 */
public class DOMXMLFileReader {

	private static final Logger log = Logger
			.getLogger(DOMXMLFileReader.class.getName());

	private static Map<String, Properties> proMap = new ConcurrentHashMap<String, Properties>();
	private static Map<String,String> propFileMap = new ConcurrentHashMap<String,String>();
	private static Map<String,List<String>> clusterMap = new ConcurrentHashMap<String,List<String>>();



	/**
	 * This method parses the propDefs.xml for all the cluster servers combinations
	 * @param clusterName
	 * @param serverName
	 * @param propFileName
	 */
	public static void parseXML(String clusterName, String serverName) {

		try {
			File fXmlFile = new File(BuildConstants.parseXMLPath);

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
					String myPropFilePath = propFileElement
							.getAttribute("location");

					log.info(" myPropFileName :  " + myPropFileName
							+ " propertyFileName: " + " PropertyFilePath"
							+ myPropFilePath);

					NodeList propNodes = propFileNode.getChildNodes();

					Properties props = new Properties();

					for (int l = 0; l < propNodes.getLength(); l++) {
						Node propNode = propNodes.item(l);
						if (propNode.getNodeType() == Node.ELEMENT_NODE) {
							Element propElement = (Element) propNode;
							Properties storeProps = storeProperties(
									myPropFileName, myPropFilePath,
									propElement, clusterName, serverName);
							props.putAll(storeProps);
							log.info("Adding each property values to Props for Each property"
									+ props.size());
						}
					}
					log.info("Adding OverAll Props to proMap" + props.size());
					proMap.put(myPropFileName, props);
					propFileMap.put(myPropFileName,myPropFilePath);
					log.info("propMap Size :" + proMap.size());
				}
			}
		} catch (Exception e) {
			log.info("-----------------------");
			e.printStackTrace();
		}
	}


	/**
	 * This method reads the properties from the existing properties files and saves in properties objects.
	 * @return
	 */
	public static Properties storeProperties(String propertyFileName,
			String propFilePath, Element propElement, String clusterName,
			String serverName) {
		log.info("Called Stored Properties*****");
		Properties properties = new Properties();
		String propertyKey = propElement.getAttribute("name");
		String propertyValue = "";

		NodeList sCNodeList = propElement.getElementsByTagName("value");
		log.info("scNodeList Size :" + sCNodeList.getLength());

		log.info("Now Printing the Values of the Values for Server and Cluster Details ***********");

		for (int i = 0; i < sCNodeList.getLength(); i++) {
			Node sCValueNode = sCNodeList.item(i);
			if (sCValueNode.getNodeType() == Node.ELEMENT_NODE) {
				Element scValueElement = (Element) sCValueNode;

				log.info("Node Value:" + scValueElement.getNodeValue());
				String myClusterName = scValueElement.getAttribute("cluster");
				String myServerName = scValueElement.getAttribute("server");
				propertyValue = scValueElement.getTextContent().trim();
				log.info("Cluster Name : " + myClusterName + " Server Name : "
						+ myServerName + " property Value:" + propertyValue
						+ "propertyName: " + propertyKey);
				if(clusterName!=null&&!clusterName.isEmpty()) {
					if(serverName!=null&&!serverName.isEmpty()) {
						if(clusterName.equalsIgnoreCase(myClusterName) && serverName.equalsIgnoreCase(myServerName)) {
							// place property key and values in properties
							properties.put(propertyKey, propertyValue);
							log.info("Adding Properties to Props : Name: " + propertyKey
								+ " propValue: " + propertyValue);
					}
				} else {
					properties.put(propertyKey, propertyValue);
					log.info("There is No Server for this Cluster>>Though populating the properties Adding Properties to Props : Name: " + propertyKey
							+ " propValue: " + propertyValue);
				}
				} else {
					log.error("The Cluster  is Null, Check Your propDefs XML file");
				}
			}
		}
		log.info("Came out of the Property Evaluation - Size of Props Returning is "+properties.size());
		return properties;
	}


	
	/**
	 * This is a utility method to display the current properties,mainly used for debugging.
	 * @return
	 */
	public static Properties getProperties(String propFileName,
			String clusterName, String serverName) {
		Map<String, Properties> myMap = proMap;

		Properties myProp = (Properties) myMap.get(propFileName);
		Set<Object> mapkeys = myProp.keySet();
		for (Object mapKey : mapkeys) {

			log.info("Map Key :" + (String) mapKey + " Map(Prop) Value: "
					+ myProp.get(mapKey));
		}
		return null;
	}


	/**
	 * This method takes care of reading the existing properties from property files, reading latest values from propDefs.xml,comparing both and updating
	 * the properties files with the latest values for the matvhing property names.
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		clusterMap = InitProperties.getHashMap();

		if(clusterMap!= null && clusterMap.size()!=0) {
			log.info("cluster Map Size in DOMXML :" + clusterMap.size());

			Map<String,List<String>>  allClustersAndServers = clusterMap;
			//getClusterAndServer();
			String currentServer = null;
			if(allClustersAndServers!=null && allClustersAndServers.size()>0) {
				log.info("There are some Clusters and Servers to be Parsed with Size "+ allClustersAndServers.size());
				Set<String> clustersSet = allClustersAndServers.keySet();
				log.info("cluster Set Size :"+ clustersSet.size());
				for(String cluster : clustersSet) {
					List<String> serversList = allClustersAndServers.get(cluster);
					log.info("servers list size :"+ serversList.size());

					for(String server : serversList) {
						log.info("Calling parseXML for Cluster:"+cluster+" and Server: "+server);
						parseXML(cluster, server);
						setZipfileProperties(cluster,server);
						currentServer = server;
						//process Only one Cluster and One Server combination and exit 
						log.info("Coming Out of the Loop Servers :************* server name "+ server);
						break;
					}
					
					log.info("Servers List Size before Removing Current Server :" + serversList.size());
					if(serversList!=null && serversList.size()>0) {
						log.info("Removing Server from the List :"+ currentServer);
						serversList.remove(currentServer);
					}
					log.info("Servers List Size AFTER Removing Current Server :" + serversList.size());

					//updating the Cluster with the new Servers List,Already Processed Server Will be removed from the List
					if(serversList== null || serversList.size() ==0) {
						//Remove the CLuster if All the Servers are Processed for the Cluster OR there is no Server for the Cluster
						log.info("Cluster "+ cluster+" is empty so remving the Cluster from the Map");
						clusterMap.remove(cluster);

					} else {

						clusterMap.put(cluster, serversList);
					}

					log.info("Coming Out of the Loop Clusters :*************"+cluster);
					break;
				}
			}
			updatePropertiesFiles();
			InitProperties.storeHashMap(clusterMap);
			System.out.println("Done Parsing the XML and updating the Properties Files");
		} else {
			log.warn("There are No Elements in the Cluster->Server Hierarchy that Need to be processed, Please Initialie the Properties using InitProperties");
			return;
		}
	}

	/**
	 * This method prepares the zipfile properties which is used by ant to get current cluster and server names.
	 * @param clusterName
	 * @param serverName
	 */
	private static boolean setZipfileProperties(String clusterName,String serverName) {
		Properties props =new Properties();
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		boolean updated = false;
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
				file = new File(BuildConstants.zipFilePath);
				fr = new FileReader(file);
				br = new BufferedReader( new FileReader(file));
				props.load(br);
			if(clusterName!=null) {
				if(serverName!=null) {
					props.put("cluster", clusterName);
					props.put("server", serverName);
					//If there is no server for the Cluster add only the ClusterName to zipfile.properties
				} else {
					props.put("cluster", clusterName);	
				}
			} else {
					log.error("There is a Problem, the Cluster Name is Null, Skipping Adding Entries to ZipFile Properties");
			}
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			props.store(bw, "Updating ZipFile Properties");
			updated = true;
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
			if(fr!=null) {
				fr.close();
			} 
			if(br!=null) {
				br.close();
			}
			if(fw!=null) {
				fw.close();
			}
			if(bw!=null) {
				bw.close();
			}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
		return updated;
	}




	/**
	 * This method updates the properties in properties files with the latest values from propDefs.xml for the matching property names.
	 * @param propFileName
	 */
	public static void updatePropertiesFiles() {
		Map<String, Properties> myMap = proMap;
		
		Properties prWrite = new Properties();
		String proFilePath = null;
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			if(propFileMap!=null && propFileMap.size()>0) {

				Set<String> propFileSet = propFileMap.keySet();
					
				for(String propFileName : propFileSet ){
					proFilePath = propFileMap.get(propFileName);
					Properties pr = new Properties();
					File propfileCreate = new File(proFilePath); 	
					log.info("Created File at :"+ proFilePath+" Absolute Path: "+propfileCreate.getAbsolutePath());
					log.info("propFilePath :" + proFilePath+"propFileName: "+propFileName);
					
					//Read all the Properties for the file into properties
					fr = new FileReader(propfileCreate);
					br = new BufferedReader(fr);
					pr.load(br);
					log.info("Read Properties Successfully to Properties from input file"+propFileName+" at path "+proFilePath+" and properties Size :"+pr.size());
					Set<Object> common = pr.keySet();

					//Now Read the Properties that we stored into the myMap during parse method.
					Properties myProp = (Properties) myMap.get(propFileName);
					Set<Object> mapkeys = myProp.keySet();

					log.info("Properties Size before removing Common Properties"+pr.size()+" myProp which are read from XML size: "+myProp.size());

					for (Object mapKey : mapkeys) {
						if (common.contains(mapKey)) {
							log.info("Adding Modified Properties to the Property: Name :"
									+ mapKey + "Prop Value: " + myProp.get(mapKey));
							pr.put(mapKey, myProp.get(mapKey));
							prWrite.put(mapKey, myProp.get(mapKey));
						}
					}
					log.info("Properties Size AFTER removing Common Properties" + pr.size());
					fw = new FileWriter(propFileName);
					bw = new BufferedWriter(fw);
					pr.store(bw,"Adding Dynamic Property Values");
					log.info("Added Properties Successfully to output file");
				}
			} else {
				log.error("The Exception is the Size of the Properties Files Map is Zero or Map is Null"+propFileMap);
			}
		} catch(Exception ex ){
			ex.printStackTrace();
		} finally {
			try {
				if(fr!=null) {
					fr.close();
				}
				if(br!=null) {
					br.close();
				}
				if(fw!=null) {
					fw.close();
				}
				if(bw!=null) {
					bw.close();
				}

			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
