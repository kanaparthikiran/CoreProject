import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 * 
 */

/**
 * @author kikanapa
 *
 */
public class MyThreadPools {
	
	private static final Logger log =  Logger.getLogger(MyThreadPools.class.getName());

	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService service = Executors.newFixedThreadPool(10);
		MyTask task = new MyTask();
		
		BlockingQueue<Runnable> bq = new ArrayBlockingQueue<Runnable>(10);
//		bq.add(task);
		int corePoolSize =2;
		int maximumPoolSize =10;
		long keepAliveTime =10;
		
		ThreadPoolExecutor poolEx = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, bq);
		
		log.info("Tasks Submitted to ThreadPool****");
	for(int i=0;i<120;i++) {
		log.info("Called :"+ i +" th time");
			service.execute(task);
		}
		log.info("Trying to ShutDown the ThreadPool Service************");
		service.shutdownNow();
		log.info("Completed Shutting Down the ThreadPool Service************");
	}

}
