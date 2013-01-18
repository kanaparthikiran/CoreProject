/**
 * 
 */
package com.linx.threads;

import org.apache.log4j.Logger;
/**
 * @author kikanapa
 *
 */
class One implements Runnable {
	private static final Logger log = Logger.getLogger(One.class.getName());
	
	@Override
	public void run() {
		log.info("This is run() in One class");
	}
}

class Two implements Runnable  {
	
	private static final Logger log = Logger.getLogger(Two.class.getName());
	
	@Override
	public void run() {
		log.info("This is run() in Two class");
	}
}	

class Shared {
	
	/**
	 * 
	 */
	private void shareMe() {
		
	}
	
}


public class DeadLockTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
