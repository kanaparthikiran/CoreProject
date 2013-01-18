import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

/**
 * 
 */

/**
 * @author kikanapa
 *
 */
public class MyTask  implements Runnable {

	private static final Logger log = Logger.getLogger(MyTask.class.getName());
	int count;
	AtomicInteger ac = new AtomicInteger();
	/**
	 * 
	 */
	public void run() {
		count++;
	//	count = ac.incrementAndGet();
		log.info("run method in my task in thread :"+ Thread.currentThread().getName()+
				"count is:"+ count);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
