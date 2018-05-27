import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import com.mysql.jdbc.log.Log;

/**
 * 
 */

/**
 * @author Kiran
 *
 */
public class BRTest {
	
	private static final Logger log = Logger.getLogger(BRTest.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i=0;i<100;i++) {
			
			if(i%15 == 0) {
				System.out.println("FizzKick"+i);
			//	continue;
			}
			if(i%3 == 0) {
				System.out.println("fizz"+i);
			//	continue;
			}
			if(i%5 == 0) {
				System.out.println("Kick"+i);
			//	continue;
			}
		}
		
		Map m = null;
		log.info("mao elements*****:"+ m.get(""));
	}
	
	

}
