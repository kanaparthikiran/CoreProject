/**
 * 
 */
package com.objectlinx.util;



import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.objectlinx.dao.ContinentDAO;
import com.objectlinx.dao.DAOFactory;
import com.objectlinx.dao.DAOFactoryImpl;
import com.objectlinx.entity.Continent;
import com.objectlinx.entity.Country;

import dto.UserDetails;
/**
 * @author kikanapa
 *
 */
public class HibernateUtil {
	
	private static ThreadLocal<Session> local = new ThreadLocal<Session>();
	
	private static final Logger log = Logger.getLogger(HibernateUtil.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//getHibernateSession();
		DAOFactory daoFactory = new DAOFactoryImpl();
		
		ContinentDAO continentDAO = daoFactory.getContinentDAO();
		
		Continent continent = new Continent();
		Country country = new Country();
		
		country.setCountryName("USA");
		country.setCountryDescription("USA");
		
		Session  session  = HibernateUtil.getHibernateSession();
		Transaction tx = session.beginTransaction();
		try {
/*		Continent existingCont = (Continent)session.load(Continent.class, 32);
		continent.addCountry(country);
		session.saveOrUpdate(existingCont);
		
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");
		session.save(user);
		log.info("Now Trying to use the SQL Named Query*********");
	
*/	
		UserDetails user = new UserDetails();
		/*			Query query = session.getNamedQuery("findbyUserName").setString("userName", "First User");
	
		List<String> results = (List<String>)query.list();
		
		log.info("No of Results: " + results.size()); */
		
		log.info("Now Trying to Get All the Users********");
		
		Query queryAll = session.getNamedQuery("getAllUsers");
		
		List<UserDetails> allUsers = queryAll.list();
		
		log.info("All The Users in the  List Are*****");
		
		log.info("All Users List Size :"+ allUsers.size());
		for(UserDetails userElem : allUsers) {
			log.info("Users in the List  Are : userId "+ userElem.getUserId()+ " userName "+userElem.getUserName() );
		}
		int i =1;
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		Random rn = new Random(1l); 
		ThreadPoolExecutor ex = new ThreadPoolExecutor(4, 20, 60, TimeUnit.SECONDS, queue);
		while(i<2) {
			Future sf = ex.submit(new QueryThread());
		}
		ex.shutdown();

		/*while(i<50) {
		log.info("*** DONE DELETING ******");
		Random rn = new Random(1l); 
		int nextInt = rn.nextInt();
		log.info("next int created is**********: "+ nextInt);
		log.info("Testing the Flow using SQL Query****************");
		String delSql = "delete from HOUSE where HOUSE_NUMBER="+nextInt;
		Query delQuery = session.createSQLQuery(delSql);
		SQLQuery sq = null;SQLQueryImpl simpl = null;
		int delRows = delQuery.executeUpdate();
		log.info("Number of Deleted Rows*********************"+ delRows);
		log.info("Now trying to call the Stored Procedure*****************");
		Query exQuery = session.createSQLQuery("CALL " +
				"insertHouseHello(:timestmp,:hname,:hno,:hvalue)");
		exQuery.setParameter("timestmp", 
				new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
		exQuery.setParameter("hname", 34);
		exQuery.setParameter("hno", nextInt);
		exQuery.setParameter("hvalue", 12);
		int exRows =  0;
		exQuery.executeUpdate();
		log.info("Executed Rows from Stored Procedure****************"+exRows);
		}*/
		tx.commit();
		log.info("Committed Transactions********************");
		} catch(Exception ex) {
			ex.printStackTrace();
			log.info("Rollback the Transaction****************");
		} finally {
			log.info("Closed All Resources**********************");
		}
	}

	public static Session getHibernateSession(String threadName) {
	    Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = (Session)local.get();
		try {
		if(session==null) {
			session = sessionFactory.openSession();
			local.set(session);
			log.info("No Session Found in ThreadLocal*****, so creating a new Session for thread "+threadName);
		}  else {
			log.info(" There is a Session Found in ThreadLocal*****, so returning that Session for thread "+threadName);
		}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		log.info("Returning Hibernate Session from Util for thread"+ threadName);
		return session;
	}
	
	
	public static Session getHibernateSession() {
	    Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = (Session)local.get();
		try {
		if(session==null) {
			session = sessionFactory.openSession();
			local.set(session);
			log.info("No Session Found in ThreadLocal*****, so creating a new Session");
		}  else {
			log.info(" There is a Session Found in ThreadLocal*****, so returning that Session");
		}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		log.info("Returning Hibernate Session from Util");
		return session;
	}
}
