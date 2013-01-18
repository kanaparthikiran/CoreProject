import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
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
class Consumer  implements  Runnable {
	
	private static final Logger log = Logger.getLogger(Consumer.class.getName());
	
	BlockingQueue bq = null;
	/**
	 * 
	 * @param bq
	 */
	Consumer(BlockingQueue bq) {
		this.bq = bq;
	}
	
	/**
	 * 
	 */
	@Override
	public void run() {
		
		consume(1);
	}
	
	/**
	 * 
	 */
	public void consume(int x){
		try {
		for(int i =x;i<10;i++) {
			log.info("For Thread::::" + Thread.currentThread().getName()+
					"Consumed*****:"+ bq.take().toString());
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

/**
 * 
 * @author kikanapa
 *
 */
class Producer implements Runnable{
	
	private static final Logger log = Logger.getLogger(Producer.class.getName());
	
	BlockingQueue bq = null;
	/**
	 * 
	 * @param bq
	 */
	Producer(BlockingQueue bq) {
		this.bq = bq;
	}
	
	/**
	 * 
	 */
	@Override
	public void run() {
		log.info("For Thread::::" + Thread.currentThread().getName());
		produce(1);
	}
	
	/**
	 * 
	 */
	public void produce(int x) {
		try {
		for(int i =x;i<10;i++) {
			 bq.put(i);
			log.info("For Thread::::" + Thread.currentThread().getName()+
					"Produced*****:"+i);
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
	}
	
}


public class MultiProdCons {

	private static final Logger log = Logger.getLogger(MultiProdCons.class.getName());

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue bq = new ArrayBlockingQueue(10);
		
		ThreadPoolExecutor poolEx = new ThreadPoolExecutor(2,10,10,TimeUnit.SECONDS,bq);
		
		Producer p1 = new Producer(bq);
		Producer p2 = new Producer(bq);
		Producer p3 = new Producer(bq);
		
		Consumer c1 = new Consumer(bq);
		Consumer c2 = new Consumer(bq);
		Consumer c3 = new Consumer(bq);
		
		List<Runnable> allItems = new ArrayList<Runnable>();

		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(p3).start();
		
		new Thread(c1).start();
		new Thread(c2).start();
		new Thread(c3).start();
		
/*		poolEx.execute(p1);
		poolEx.execute(p2);
		poolEx.execute(p3);
		
		poolEx.execute(c1);
		poolEx.execute(c2);
		poolEx.execute(c3);*/
		
		log.info("Issuing ShutDown Command to the ThreadPool Executor*************");
		poolEx.shutdown();
		log.info("ThreadPool Executor Did SHUTDOWN *************");
		
	}

}
