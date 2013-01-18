import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 */

/**
 * @author kikanapa
 *
 */
public class SpringHiberIntegTest {

	private static final Logger log = Logger.getLogger(SpringHiberIntegTest.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 
	 * @return
	 */
	public boolean testConnection() {
		Session session = sessionFactory.openSession(); 
		 if(session!= null) {
			 return true;
		} else {
			return true;
	
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*ApplicationContext context = 
		    	  new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});*/
		
		log.info("Test Conn Value :" + new SpringHiberIntegTest().testConnection());
	}

}
