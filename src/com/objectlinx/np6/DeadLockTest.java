/**
 * 
 */
package com.objectlinx.np6;

import org.apache.log4j.Logger;

/**
 * @author kikanapa
 *
 */

class Lock1 implements Runnable {
	Semaphore s1,s2;
	private static final Logger log = Logger.getLogger(Lock1.class.getName());
	Lock1(Semaphore sem1,Semaphore sem2) {
		s1 = sem1;
		s2 = sem2;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(s1) {
			log.info("Lock1 acquired on sem1 going to acuire lock on sem2");		
			synchronized(s2) {
				log.info("Lock1 acquiredon sem2");			
			}
		}
	}
	
}


class Lock2 implements Runnable {
	Semaphore s1,s2;
	private static final Logger log = Logger.getLogger(Lock2.class.getName());
	Lock2(Semaphore sem1,Semaphore sem2) {
		s1 = sem1;
		s2 = sem2;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(s2) {
			log.info("Lock2 acquired on sem2 going to acuire lock on sem1");		
			synchronized(s1) {
				log.info("Lock2 acquiredon sem1");			
			}
		}
	}
}


class Semaphore {
	private static final Logger log = Logger.getLogger(Semaphore.class.getName());
	
	public void set(int i) {
		
	}
	
	public int get() {
		return 1;
	}
}

/**
 * 
 * @author kikanapa
 *
 */
public class DeadLockTest {

	private static final Logger log = Logger.getLogger(DeadLockTest.class.getName());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore s1 = new Semaphore(),s2=new Semaphore();
		Runnable r1 = new Lock1(s1,s2);
		Runnable r2 = new Lock2(s1,s2);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();t2.start();
		log.info("Thread t1 holds lock on r1 object****"+ t1.holdsLock(s1));
		log.info("Thread t1 holds lock on r2 object****"+ t1.holdsLock(s2));
		
		log.info("Thread t2 holds lock on r1 object****"+ t2.holdsLock(s1));
		log.info("Thread t2 holds lock on r2 object****"+ t2.holdsLock(s2));
		
	}

}
