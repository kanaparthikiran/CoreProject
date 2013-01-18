/**
 * 
 */
package com.cisco.np6;

import java.lang.reflect.Field;
import java.util.Arrays;

import org.apache.log4j.Logger;
import java.lang.CloneNotSupportedException;

/**
 * @author kikanapa
 *
 */

class SampleOne {
	private static final Logger log = Logger.getLogger(SampleOne.class.getName());
	private int id;
	private int name;
	private String description;
	
	public SampleOne(int id, int name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	/**
	 * @return the id
	 */
	private int getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	private int getName() {
		return name;
	}
	public SampleOne() throws NullPointerException {
		
		super();
		log.info("Constructor called in SampleOne");
		//throw new NullPointerException("Get lost from Reflection");
/*		this.id=20;
		this.name=30;
		this.description="forty";
*/
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the description
	 */
	private String getDescription() {
		return description;
	}
	
	
}

class Provider {
	private static final Logger log = Logger.getLogger(ReflectionTest.class.getName());
	Provider() throws Exception {
		log.info("This is Provider Cons()");
		throw new CloneNotSupportedException("NO You!!! Already Cloned!!!");
	}
	
}

public class ReflectionTest {
	private static final Logger log = Logger.getLogger(ReflectionTest.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws ClassNotFoundException,NoSuchFieldException,NoSuchMethodException, IllegalAccessException  {
		// TODO Auto-generated method stub
		
		log.info("Now Trying to Create the Class Instance Using Reflection********");
		Class provider = Class.forName("com.cisco.np6.Provider");
		log.info("Constructors***** : "+ provider.getConstructor().toGenericString());
		
		
		log.info("provider class created*********:"+ provider.getClassLoader().toString()+"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		Class<SampleOne> s1 = (Class<SampleOne>)Class.forName(SampleOne.class.getName());
		log.info("The Declared Methods in SampleOne class are :" + Arrays.toString(s1.getDeclaredMethods()));
		log.info("The Declared Fields in the SampleOne class are :" + Arrays.toString(s1.getDeclaredFields()));
		
		//SampleOne son = new SampleOne(12,23,"two");
		SampleOne son = new SampleOne();
		Field field = s1.getDeclaredField("id");
		field.setAccessible(true);
		int idValue = field.getInt(son);
		
		log.info("Here is the Private Field Value :::"+ field+ " and the Value is "+idValue);
	}

}
