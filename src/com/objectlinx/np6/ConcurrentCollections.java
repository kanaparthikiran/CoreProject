/**
 * 
 */
package com.objectlinx.np6;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.log4j.Logger;

/**
 * @author kikanapa
 *
 */
public class ConcurrentCollections {

	private static final Logger log = Logger.getLogger(ConcurrentCollections.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcurrentMap<String,String> ch = new ConcurrentHashMap<String,String>();
		
		ch.put("one", "one");
		ch.put("one", "one11");
		
		Set<String> keys = ch.keySet();
		for(String keyElement : keys) {
			log.info("Key and Value are as below :"+ keyElement +"  Value: " + ch.get(keyElement));
		}

	}

}
