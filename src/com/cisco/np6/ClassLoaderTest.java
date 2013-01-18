/**
 * 
 */
package com.cisco.np6;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * @author kikanapa
 *
 */

public class ClassLoaderTest {

	private static final Logger log = Logger.getLogger(ClassLoaderTest.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException,ClassNotFoundException {
		log.info("This is First line*****");
		Class.forName("SeveralThreads");
		// TODO Auto-generated method stub
		DriverManager.getConnection("");
	//	try {
			log.info("Class Loader Info :" +  ClassLoaderTest.class.getClassLoader().getParent().getParent().getParent());
		/*} catch(Exception ex) {
	
			ex.printStackTrace();
			log.info("The exception is ---> "+ ex);
		}*/
	}

}
