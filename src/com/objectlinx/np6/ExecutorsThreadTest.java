/**
 * 
 */
package com.objectlinx.np6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

/**
 * @author kikanapa
 *
 */
class UserTask implements Runnable {
	
	private static final Logger  log = Logger.getLogger(UserTask.class.getName());
	private String threadName;
	public UserTask(String task) {
		threadName =  task;
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			try {
				log.info("The ThreadName in Execution is :"+ 
						Thread.currentThread().getName()+" AND "+ threadName);
				Thread.sleep(1000);
			} catch(InterruptedException iex) {
				iex.printStackTrace();
			}
		}
	}
	
	
}



public class ExecutorsThreadTest {
	
	private static final Logger log = Logger.getLogger(ExecutorsThreadTest.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService ex = Executors.newFixedThreadPool(10);
		
		UserTask u1 = new UserTask("user1");
		UserTask u2 = new UserTask("user2");
		UserTask u3 = new UserTask("user3");
	
		ex.execute(u1);
		ex.execute(u2);
		ex.execute(u3);
		
		Runtime t = null;

		ex.shutdown();
		log.info("Execution Completed...Exiting Main^^^^^^^^^^"); 
	}

}
