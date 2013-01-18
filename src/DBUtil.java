/**
 * 
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * @author kikanapa
 *
 */
public class DBUtil {
	
	private static final Logger log = Logger.getLogger(DBUtil.class.getName());
	
	//private static Connection con = null;
	/**
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		
		//ThreadLocal<Connection> localCon = new ThreadLocal<Connection>();
		Connection con  = null;
		long startTime = System.currentTimeMillis();
		try {
//		String dbUrl = "jdbc:oracle:thin:@lnxdb-prd-226-vip.cisco.com:1536:PROFPRD3";
		
		String dbUrl ="jdbc:oracle:thin:@lnxdb-stg-158.cisco.com:1538:PROFTST2";
	//	String dbUrl = "jdbc:oracle:thin:@171.69.37.26:1521:xe";
		String dbUserName = "nettools_appl";
		String dbPassword = "nettools_appl";
		String dbDriverName = "oracle.jdbc.driver.OracleDriver";
		
		
		Class.forName(dbDriverName);
		con	= DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		log.info("Got Connection*******");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from tab");

		if(!rs.next()) {

			System.out.println("There are no results in the Database");
		} else {

		do {
		//	System.out.println("Results :" + rs.getInt(1)+" Auhor :"+ rs.getString(2)+"  Title :"+rs.getString(3));
		} while(rs.next());

		}
		} catch(Exception ex) {
			ex.printStackTrace();
			log.error("The Exception is :"+ ex);
		}
		
		long endTime = System.currentTimeMillis();
		log.info("Total time spent to get a connection is :"+ (endTime-startTime)+" ms");		
		return con;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static boolean closeResources(Connection[] cons, Statement[] stmts, ResultSet[] rsets) {
		boolean result = false;
		long startTime = System.currentTimeMillis();
		
		if(rsets!=null) {
			for(ResultSet rs : rsets) {
				if(rs!=null) {
					try {
					rs.close();
					log.info("Closed the ResultSet Successfully");
					} catch(Exception e) {
						e.printStackTrace();
					}
				} else {
					log.error("result set element is null****");
				}
			}
		} else {
			log.error("resultset set is null****");
		}
		
	if(stmts!=null) {
		for(Statement stmt : stmts) {
			if(stmt!=null) {
				try {
					stmt.close();
					log.info("Closed the Statement Successfully");
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else {
				log.error("Statement element is null****");
			}
		}
		} else {
			log.error("Statement set is null****");
		}
	
	
	if(cons!=null) {
		for(Connection con : cons) {
			if(con!=null) {
				try {
					con.close();
					log.info("Closed the Connection Successfully");
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else {
				log.error("Connection element is null****");
			}
		}
	} else {
		log.error("Connection set is null****");
	}

		long endTime = System.currentTimeMillis();
		log.info("Total time spent to release a connection is :"+ (endTime-startTime)+" ms");		
		
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	public static boolean disConnect(Connection con) {
		boolean result = false;
		long startTime = System.currentTimeMillis();
		if(con!= null) {
			try {
			con.close();
			log.info("Conneciton is  not null, so disconnected succesfully");
			result = true;
			} catch(Exception e) {
				log.error("Exception while closing the connection");
				e.printStackTrace();
			}
		} else {
			log.error("The Connection is NULL****, so ignoring the close Connection");
		}
		long endTime = System.currentTimeMillis();
		log.info("Total time spent to release a connection is :"+ (endTime-startTime)+" ms");		
		
		return result;
	}

	public static void main(String a[]) {
		log.info("Calling get Conneciton");
		Connection con =  DBUtil.getConnection();
		log.info("Calling disconnect");
		DBUtil.disConnect(con);
		DBUtil.closeResources(new Connection[]{con}, null, null);
	}
}
