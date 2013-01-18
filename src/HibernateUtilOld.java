/**
 * 
 */




import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author kikanapa
 *
 */
public class HibernateUtilOld {
	
	private static ThreadLocal<Session> local = new ThreadLocal<Session>();
	
	private static final Logger log = Logger.getLogger(HibernateUtilOld.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//getHibernateSession();

		Session  session  = HibernateUtilOld.getHibernateSession();
		Transaction tx = session.beginTransaction();
		
/*		Continent existingCont = (Continent)session.load(Continent.class, 32);
		continent.addCountry(country);
		session.saveOrUpdate(existingCont);
		
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");
		session.save(user);
		log.info("Now Trying to use the SQL Named Query*********");
	
*/	
		
		
		log.info("*** DONE DELETING ******");
		tx.commit();
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
	
	public static void shutdown() {
		getHibernateSession().close();
		}
}
