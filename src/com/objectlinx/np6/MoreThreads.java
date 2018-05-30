/**
 * 
 */
package com.objectlinx.np6;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.objectlinx.util.HibernateUtil;

/**
 * @author kikanapa
 *
 */

class LevelOneThread implements Callable<Integer> {

	private Logger log = null;
	private static int count = 0;
	Session session = null;

	public LevelOneThread(Session session) { 
		// TODO Auto-generated constructor stub
		this.session = session;
	}
	
	@Override
	public Integer call() {
		String currentThread = Thread.currentThread().getName();
		log = Logger.getLogger(LevelOneThread.class.getName());
		log.info("Entered Thread :" + currentThread);
//		Session session = HibernateUtil.getHibernateSession(currentThread);
		try {
			log.info("Thread " + currentThread+" sleeping");
			session.createSQLQuery("select * from country");
			log.info("Getting Session info for Thread "+ currentThread+" "+session.isOpen());
			Thread.sleep(20000);
		} catch(InterruptedException iex) {
			iex.printStackTrace();
		}
		synchronized(this) {
			log.info("This Block is Synchronized************ by thread: "+ currentThread);
		}
		log.info("Got Session with Id as : "+ session.getStatistics().toString());
		count++;
		log.info("Exiting Thread :" + currentThread+" and Thread Count is :"+count);
		return 0;
	}
	
}

public class MoreThreads {

	private static final Logger log = Logger.getLogger(MoreThreads.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		// TODO Auto-generated method stub
		ExecutorService exService = Executors.newFixedThreadPool(10);
		Collection<LevelOneThread> threads = new ArrayList<LevelOneThread>();
		Session session = HibernateUtil.getHibernateSession();
	//	Query myfunc = session.createSQLQuery("CALL  KIKANAPA.Days_Between(:startDate,:endDate)");
		String sql = "select insertDDNDefectSumm('bny2',93149,'DF','Image Deferrals',172,95338 ) from dual";
	//	 Query myfunc = session.createSQLQuery(" select  KIKANAPA.Days_Between(:currTime1,:currTime2) from dual");
		Query myfunc = session.createSQLQuery(sql);
/*		myfunc.setParameter("startDate", Calendar.getInstance().getTime());
		myfunc.setParameter("endDate", Calendar.getInstance().getTime());*/
		 Calendar cal1 = Calendar.getInstance();
		 cal1.add(Calendar.YEAR, 2);
		 Calendar cal2 = Calendar.getInstance();
		 
/*		 log.info("diff between dates : cal1 "+ (cal1.getTime()));
		 log.info("diff between dates : cal2 " + (cal2.getTime()));
		 myfunc.setParameter("currTime1", cal2.getTime());
		 myfunc.setParameter("currTime2", cal1.getTime());*/
/*		 myfunc.setParameter("hName", "somename");
		 myfunc.setParameter("hNum", 101);
		 myfunc.setParameter("hValue", 32434);*/
		 
		 List retList = new ArrayList();
		 retList = myfunc.list();
		for(Object retListElem : retList) {
			log.info("return list element*******:" + retListElem);
		}
		
	
		/*LevelOneThread l1 = null;
		for(int i=0;i<10;i++) {
			l1 = new LevelOneThread(session);
			threads.add(l1);
		}
		try { 
			exService.invokeAll(threads);
		} catch(Exception ex) {
			
			ex.printStackTrace();
		}
		
		log.info("Shutting down the ThreadPool**************");
		exService.shutdown();*/
		
		log.info("Total time taken to Execute with Threading*************"+ (System.currentTimeMillis() - startTime)+" seconds");
	}

}
