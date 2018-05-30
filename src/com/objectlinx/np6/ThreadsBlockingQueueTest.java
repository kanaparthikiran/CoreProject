/**
 * 
 */
package com.objectlinx.np6;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

/**
 * @author kikanapa
 *
 */
class ProducerOne implements Runnable {
	
	private static final Logger log = Logger.getLogger(ProducerOne.class.getName());
	private final BlockingQueue<Integer> shared;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<10;i++) {
			try {
				shared.put(i);
				log.info("Produced the variable :"+ i);
				
			} catch(InterruptedException iex) {
				iex.printStackTrace();
			}
		}
		
	}

	public ProducerOne(BlockingQueue<Integer> s) {
		shared = s;
		// TODO Auto-generated constructor stub
	}
}

/**
 * 
 * @author kikanapa
 *
 */
class ConsumerOne implements Runnable {
	private final BlockingQueue<Integer> shared;
	private static final Logger log = Logger.getLogger(ConsumerOne.class.getName());
	@Override
	public void run() {
		// TODO Auto-generated method stub
	//	for(int i=0;i<10;i++) {
		while(true) {
			try {
			Object x = shared.take();
			log.info("Consumed the variable :"+ x.toString());
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	public ConsumerOne(BlockingQueue<Integer> s) {
		shared = s;
		// TODO Auto-generated constructor stub
	}
}


/**
 * 
 * @author kikanapa
 *
 */
public class ThreadsBlockingQueueTest {

	
	private static final Logger log = Logger.getLogger(ThreadsBlockingQueueTest.class.getName());
	
	public ThreadsBlockingQueueTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<Integer> lq = new LinkedBlockingQueue<Integer>();
		log.info("Called the BlockingQueue implementation for Produder/Consumer Problem****");
		Thread pThread = new Thread(new ProducerOne(lq),"Producer");
		Thread cThread = new Thread(new ConsumerOne(lq),"Consumer");
		pThread.start();
		cThread.start();
	}

}
