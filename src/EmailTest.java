import org.apache.log4j.Logger;;

/**
 * 
 */

/**
 * @author kikanapa
 *
 */
public class EmailTest {

	private static final Logger log = Logger.getLogger(EmailTest.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.info("Calling Email Util Class***********");
		String finalEmail = null;
		String invalidEmail = null;
		StringBuffer invalidBuffer =  new StringBuffer();
		
		if(args.length<1) {
			log.error("Please enter the values");
		} else {
			StringBuffer sb = new StringBuffer();
		
			for(int i =0;i<args.length;i++) {
				String[] emails = args[i].split(",");
				
				for(String email : emails) {
					log.info("Email: :"+ email);
					if(email.contains("@")) {
						log.info("This is Valid EMail Address****");
						sb.append(email+",");
						
					} else {
						invalidBuffer.append(email+",");
					}
				}
			}
			if(!sb.equals("")  && sb.indexOf(",")>= 1) {
				finalEmail = sb.substring(0, sb.length()-1);
			}
			if(invalidBuffer.indexOf(",")>0) {
				invalidEmail = invalidBuffer.substring(0,invalidBuffer.length()-1); 
			}
			
		}
		
		log.info("Final Email******"+ finalEmail);
		log.info("Invalid Email Strings are:"+ invalidEmail);
	} 
}
