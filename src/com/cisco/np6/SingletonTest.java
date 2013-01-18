/**
 * 
 */
package com.cisco.np6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

/**
 * @author kikanapa
 *
 */

class Singleton implements Serializable {
	
	private static final Singleton single = new Singleton();
	private static final Logger log = Logger.getLogger(Singleton.class.getName());
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		log.info("Returning instance from Singleton-getInstance method");
		return single;
	}
	protected Object readResolve() {
		log.info("Returning instance from Singleton-readResolve method");
		return single;
	}
}

public class SingletonTest {

	private static final Logger log = Logger.getLogger(SingletonTest.class.getName());
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		log.info("Singleton Test ...:");
		String fileName = "testsingle.txt";
		java.util.Hashtable s = null;
		ConcurrentHashMap<Object, Object> chm = null;
		
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Singleton single = Singleton.getInstance();
		oos.writeObject(single);
		
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		ois.readObject();
		
		 Object x = new Integer(5);
	     System.out.println((Integer)x);
	     
	     BigDecimal bd1 = new BigDecimal(10898909.01);
	     BigDecimal bd = new BigDecimal(10);
	     log.info("BigDecimal Long Value is : " +  bd.longValue());
	     long n =101;
	     long l1= 1;
/*	     if(n == bd.longValueExact()) {
	    	 log.info("this is fine and equal*********");
	     } else {
	    	 log.info("?????some thing wrong and missing*******");
	     }*/
	     long bdToLong = bd.longValueExact();
	     if(n<bdToLong) {
	    	 log.info("n "+n+" is less than bd "+bd);
	     } else if(n>bdToLong) {
	    	 log.info("n "+n+" is greater than bd "+bd);
	     } else if(n==bdToLong) {
	    	 log.info("n "+n+" is equal to bd "+bd);
	     } else {
	    	 log.info(" n is nothing***");
	     }
	}

}
