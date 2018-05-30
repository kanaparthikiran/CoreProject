/**
 * 
 */
package com.objectlinx.np6;

import org.apache.log4j.Logger;

/**
 * @author kikanapa
 *
 */

class MiniThread extends Thread {
	
	private static final Logger log = Logger.getLogger(MiniThread.class.getName());
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				log.info("MiniThread run() "+ Thread.currentThread().getName()+ i);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}


/**
 * 
 * @author kikanapa
 *
 */
class Shared {
	
	private static final Logger log = Logger.getLogger(Shared.class.getName());
	
	boolean valueSet  = false;
    int n;

       /**
        * 
        * @return
        */
	   synchronized int getVar() {
	      if(!valueSet)
	      try {
	         wait();
	      } catch(InterruptedException e) {
	         System.out.println("InterruptedException caught");
	      }
	      System.out.println("Got n value in get(): " + n);
	      valueSet = false;
	      notify();
	      return n;
	   }

	   /**
	    * 
	    * @param n
	    */
	   synchronized void setVar(int n) {
	      if(valueSet)
	      try {
	         wait();
	      } catch(InterruptedException e) {
	         System.out.println("InterruptedException caught");
	      }
	      this.n = n;
	      valueSet = true;
	      System.out.println("Put n value in put(): " + n);
	      notify();
	   }
	   
	
/*	public synchronized int getVar() {
		log.info("Called getVar in Shared*********");
		if(!valueSet ) {
		try {
			log.info("getVar is waiting*****");
			wait();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		}
		valueSet  =false;
		notify();
		return var;

	}
	
	public synchronized void setVar(int var) {
		
		log.info("Called setVar in Shared*********");
		try {
			log.info("setVar is waiting*****");
			wait();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		this.var = var;
		valueSet = true;
		notify();
	}*/
	
}

/**
 * 
 * @author kikanapa
 *
 */
class Producer implements Runnable {
	private static final Logger log = Logger.getLogger(Producer.class.getName());
	
	Shared shared;
	
	Producer(Shared s) {
		shared = s;
		new Thread(this,"Producer").start();
		
	}
	
	@Override
	public void run() {
		log.info("Producer Thread Started**************");
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<10;i++) {
			shared.setVar(i);
			log.info("Setting the Value to the Shared is : "+ i);
		//	Thread.sleep(5000);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		log.info("Producer Thread Completed**************");
	}
	
	
}

/**
 * 
 * @author kikanapa
 *
 */
class Consumer implements Runnable {
	private static final Logger log = Logger.getLogger(Consumer.class.getName());
	
	Shared shared;
	Consumer(Shared s){
		shared = s;
		new Thread(this,"Consumer").start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		log.info("Consumer Thread Started**************");
		try {
			for(int i=0;i<10;i++) {
			log.info("Getting the Value from the Shared is : "+ shared.getVar());
			//Thread.sleep(1);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		log.info("Consumer Thread Completed**************");
	}
	
	
}



/**
 * 
 * @author kikanapa
 *
 */
class ChildThread implements Runnable {
	
	private static final Logger log = Logger.getLogger(ChildThread.class.getName());
	
	ChildThread() {
		//start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		log.info("Coming out of Mini Thread***");
	}

	
	
}

public class ThreadsTest {

	private static final Logger log = Logger.getLogger(ThreadsTest.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new MiniThread();
		t1.setName("Mini Test");
		t1.start();
		Shared shared = new Shared();
	

		
		Runnable r3 = new Consumer(shared);
		
		Runnable r2 = new Producer(shared);
		
		Thread t3 = new Thread(r3);
		Thread t2 =  new Thread(r2);
		
		try {
		//	shared.
			t3.join();
			t2.join();
		} catch(InterruptedException iex) {
			iex.printStackTrace();
		}
		log.info("*****Completed Main Method/Thread****Finally");
		
		
	}

}
