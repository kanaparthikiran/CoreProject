/**
 * 
 */
package com.objectlinx.np6;

import org.apache.log4j.Logger;

/**
 * @author kikanapa
 *
 */
class Processor {

	private int version;
	private String name;
	
	@Override
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		if(o == null) {
			return false;
		}
		Processor p = (Processor)o;
		if(version!=p.version) {
			return false;
		}
		if(name != p.name) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result =1;
		result = result*prime+version;
		result = result*prime+ (name!= null?0 :name.hashCode());
		return result;
	}
	
	@myann
	public int myannot() {
		return 1;
	}

}


public class EqualsHashCodeTest {
	private static final Logger log = 
			Logger.getLogger(EqualsHashCodeTest.class.getName());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello";
		//s = null;
		log.info("Printing equals o/p :"+ (s).equals("null"));
	}

}
