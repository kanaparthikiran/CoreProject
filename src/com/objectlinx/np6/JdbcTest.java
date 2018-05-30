package com.objectlinx.np6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.objectlinx.util.HibernateUtil;

public class JdbcTest {
	
	private static final Logger log = Logger.getLogger(JdbcTest.class.getName());

	public static void main(String a[]) throws Exception {
		
		String dbUrl =  null;
		
		//"jdbc:oracle:thin:@lnxdb-prd-226-vip.cisco.com:1536:PROFPRD3"; //This is Production
		
				//"jdbc:oracle:thin:@lnxdb-stg-158.cisco.com:1538:PROFTST2";//This is QA
		
	//	String dbUrl = "jdbc:oracle:thin:@171.69.37.26:1521:xe";
		
		//dbUrl = "jdbc:oracle:thin:@10.21.71.103:1521:xe";
		dbUrl = "lnxdb-dev-vm-116.cisco.com:1540:PROFDEV";
		
		String dbUserName =  null;
		
		
		String dbDriverName = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(dbDriverName);
		dbUserName ="netaware";
		String dbPassword = "netaware";
		Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		log.info("Got Connection******* from the DB Url -> "+ dbUrl);
		
		
		//"nettools_appl"; //production
		//"lppahcet121"; //production
		
		// nettools_appl proftst
		//nettools_appl proftst
		
		/*		String dbPassword = null;
		dbUserName ="kikanapa";
		dbPassword = "test";
		
		String dbDriverName = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(dbDriverName);
		Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		log.info("Got Connection******* from the DB Url -> "+ dbUrl);
		
		String callSql = "{? =call KIKANAPA.Days_Between(?, ?)}";
		
		CallableStatement st = con.prepareCall(callSql);
		st.registerOutParameter(1, java.sql.Types.INTEGER);
		
		st.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, -3);  
		st.setDate(3, new java.sql.Date((today.getTimeInMillis())));*/
	
		//	st.setInt(2, 300);
	//	st.setInt(3, 260);
		//st.setString(4, "THIS");
		
	//	st.setInt(5, 12);
	//	st.setInt(6, 15);
		
		
	//	st.execute();
		
	/*	Integer inResult = st.getInt(1);
		log.info("response from func is :"+ inResult);*/
		//st.executeUpdate();
		
		
		
		
	//	Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery("select * from tab");

	/*	if(!rs.next()) {

			System.out.println("There are no results in the Database");
		} else {

		do {
			System.out.println("Results :" + rs.getInt(1)+" Auhor :"+ rs.getString(2)+"  Title :"+rs.getString(3));
		} while(rs.next());

		}*/
		
		Session session = HibernateUtil.getHibernateSession();
		
/*		Query spQuery = session.createSQLQuery("{CALL KIKANAPA.Days_Between(:startDt,:endDt)}");
	//	spQuery.setParameter(1, java.sql.Types.INTEGER);
		
		//st.registerOutParameter(1, java.sql.Types.INTEGER);
		
		spQuery.setParameter("startDt",new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, -3);  
		
		spQuery.setParameter("endDt", new java.sql.Date((today.getTimeInMillis())));
		
	//spQuery.setParameter(1, 12);
		
		spQuery.executeUpdate();*/
		
		
		log.info("using the Connection JDBC Approach");
		
		Query nQuery =  session.getNamedQuery("KK");
		
		
		session.getNamedQuery("RP").setDate("tday", new java.sql.Date(Calendar.getInstance().getTime().getTime())).setDate("yday",new java.sql.Date(Calendar.getInstance().getTime().getTime())).executeUpdate();

		log.info("Done using Named Query***********");
	
		
	/*	session.doWork(new Work() {

			  public void execute(Connection con) throws SQLException {

					String callSql = "{? =call KIKANAPA.Days_Between(?, ?)}";
					
					CallableStatement st = con.prepareCall(callSql);
					st.registerOutParameter(1, java.sql.Types.INTEGER);
					
					st.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
					Calendar today = Calendar.getInstance();
					today.add(Calendar.DATE, -3);  
					st.setDate(3, new java.sql.Date((today.getTimeInMillis())));
				
				st.execute();
					
					Integer inResult = st.getInt(1);
					log.info("response from func is :"+ inResult);

			    int result = st.getInt(1); // propagate this back to enclosing class
			    log.info("response from func is :"+ result);
			 
			 }
			});*/
		
		log.info("Function also Executed from Hibernate*****Work Way");


	}

}
