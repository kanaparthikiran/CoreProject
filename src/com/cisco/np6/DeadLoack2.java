/**
 * 
 */
package com.cisco.np6;

import org.apache.log4j.Logger;

/**
 * @author kikanapa
 *
 */

class Friend {
	
private static final Logger log = Logger.getLogger(Friend.class.getName());
	/**
	 * 
	 */
	public synchronized void bow(Friend f1) {
		log.info("bowing friend:"+  Thread.currentThread().getName());
	}
	
	/**
	 * 
	 */
	public synchronized void bowback(Friend f2) {
		log.info("bowing BACK friend:"+  Thread.currentThread().getName());
	}
	
}


public class DeadLoack2 {



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Friend f1 = new Friend();
		final Friend f2 = new Friend();
		
		new Thread(new Runnable()  {
			@Override
			public void run(){
				// TODO Auto-generated method stub
				f1.bow(f2);
			}
		}).start();

		
		new Thread(new Runnable()  {
			@Override
			public void run(){
				// TODO Auto-generated method stub
				f2.bow(f1);
			}
		}).start();

}
}