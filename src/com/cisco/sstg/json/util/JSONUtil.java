/**
 * 
 */
package com.cisco.sstg.json.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.parsers.DocumentBuilderFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



/**
 * @author kikanapa
 *
 */
public class JSONUtil {

	
	private static final Logger log = Logger.getLogger(JSONUtil.class.getName());
	private static Map<String, List<String>> jsonFileMap = new ConcurrentHashMap<String, List<String>>();	
	private static final String ALIAS_SUFFIX = "alias";
	private static String dbTableName = "np_inventory_chassis_summary";
	private static int series  = 600;
	
	/**
	 * 
	 * @param parseDDPath
	 * @return
	 */
	public static 	Map<String,List<String>> getJsonFileAndPropNames(String parsePath) {
			List<String>  propList =null;
			String fileName="";
			String propName="";
			try {
				Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(parsePath);
				doc.normalize();
				Element rootNode = doc.getDocumentElement();
				log.info("Root Node Name :" + rootNode);
				NodeList nodeList = rootNode.getElementsByTagName("file");
				for(int i=0;i<nodeList.getLength();i++) {
						Node clusterNode = nodeList.item(i);
					if(clusterNode.getNodeType() == Node.ELEMENT_NODE) {
						Element clusterElement = (Element)clusterNode;
						fileName = clusterElement.getAttribute("name");
						log.info("file Node :"+ clusterNode.getTextContent().trim()+" fileName "+fileName);
						NodeList propNodes = clusterElement.getElementsByTagName("property");
						propList = new ArrayList<String>();
						for(int j=0;j<propNodes.getLength();j++) {
							Node propNode = propNodes.item(j);
							if(propNode.getNodeType() == Node.ELEMENT_NODE) {
								Element propElement = (Element)propNode;
								propName = propElement.getAttribute("name");
								log.info("property Element Name :" + propName);
								propList.add(propName);
							}
						}
					}
					log.info("prop list size before placing in map:"+ propList.size());
					jsonFileMap.put(fileName, propList);
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			log.info("File Map Size Before returning the Method "+jsonFileMap.size());
			
			return jsonFileMap;
		}
	

	
    private static Connection getOracleConnection() {
        // TODO Auto-generated method stub
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        //String dbUrl = "jdbc:mysql://localhost/test";
        String dbUrl = "jdbc:oracle:thin:@lnxdb-stg-158.cisco.com:1538:PROFTST2";
        /*		+
        				"" +
        				"jdbc:oracle:thin:@lnxdb-stg-158.cisco.com:1538:PROFTST2";*/
        	//	String dbUrl = "jdbc:oracle:thin:@171.69.37.26:1521:xe";
		String dbUserName = "nettools_appl";
		String dbPassword = "nettools_appl";
		String dbDriverName = "oracle.jdbc.driver.OracleDriver";
        try {
	        Class.forName(dbDriverName);
	        con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
	        log.info("Got Connection*******");
	        log.info("Returning Connection *****");
	        st = con.createStatement();
	        rs = st.executeQuery("select * from tab");
        if(!rs.next()) {
                log.info("There are no records in the database********");
        } else {
                log.info("There are tables in the database with some count:");
        }
        } catch(Exception ex) {
                ex.printStackTrace();
        }

        return con;
}


    
	/**
	 * 
	 * @return
	 */

    private static Connection getConnection() {
            // TODO Auto-generated method stub
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
            //String dbUrl = "jdbc:mysql://localhost/test";
            String dbUrl = "jdbc:mysql://npr-dev-06/ssue?user=np_main&password=np123";
            
            String dbClass = "com.mysql.jdbc.Driver";
            try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection (dbUrl);
            log.info("Returning Connection *****");
            st = con.createStatement();
            rs = st.executeQuery("show tables");
            if(!rs.next()) {
                    log.info("There are no records in the database********");
            } else {
                    log.info("There are tables in the database with some count:");
            }
            } catch(Exception ex) {
                    ex.printStackTrace();
            }

            return con;
    }

	/**
	 * 
	 * @return
	 */
	private static Map<String,List<String>> getDBMetadata(String tableName) throws SQLException {
		Connection con =  getOracleConnection();
		String sql = "select * from "+ "np_inventory_chassis_summary"; 
		ResultSet rs = null;
		Statement st = null;
		st = con.createStatement();
		rs = st.executeQuery(sql);
        ResultSetMetaData metaData = rs.getMetaData();
        int rowCount = metaData.getColumnCount();
        
        log.info("Table Name : " + metaData.getTableName(2));
        
        dbTableName  = tableName;
        log.info("Field  \tsize\tDataType");

        for (int i = 0; i < rowCount; i++) {
	        log.info(metaData.getColumnName(i + 1) + " "+metaData.getColumnDisplaySize(i + 1) + "  "+metaData.getColumnTypeName(i + 1)+"\n");
	        //log.info(metaData.getColumnDisplaySize(i + 1) + "");
	        //log.info(metaData.getColumnTypeName(i + 1));
        } 

		return null;
	}
	/**
	 * 
	 */
	private static void createAndPopulateJsonFiles() throws Exception {
		
		if(jsonFileMap!= null && jsonFileMap.size()>0) {
			//process the JSON files and Populate each JSON file
			Set<String> jsonFiles = jsonFileMap.keySet();
			for(String jsonFile :  jsonFiles) {
				String newTableName = (++series) + dbTableName.toUpperCase()+jsonFile+".json";
				log.info("Processing jsonFile :"+ newTableName);
				List<String> jsonElements =  jsonFileMap.get(newTableName);
				File file  = new File(newTableName);
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				
				
				JSONObject json = new JSONObject();
		        
		        // Put a simple element
//		        json.put( "aircraft", "A320");
		        
		        json.put("type", "ssue.model.core.DataModelObject");
		        // Add a JSON Object
		        JSONObject pilot = new JSONObject();
		        pilot.put("firstName", "John");
		        pilot.put("lastName", "Adams");
		        JSONArray ja = new JSONArray();
		        ja.add(pilot);
//json.put( "pilot", pilot);

		        // Accumulate values in an array
		    //    json.accumulate("passenger", "George Washington");
		     //   json.accumulate("passenger", "Thomas Jefferson");
		        json.accumulate("items", ja);
		        //json.accumulate("passenger",pilot );
		        bw.write(json.toString());
		        
				log.info("This is Test Write to JSON File "+ newTableName);
				bw.flush();
				bw.close();
			}
			
		} else {
			log.info("There are no elements in the JSONMap, Please verify the jsonDefs.xml file");
			return;
		}
		
		
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
		getJsonFileAndPropNames("jsonDefs.xml");
		
		getDBMetadata("np_inventory_chassis_summary");
		
		createAndPopulateJsonFiles();
		
	}

}
