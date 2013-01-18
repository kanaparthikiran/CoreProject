/**
 * 
 */


import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;

/**
 * @author kikanapa
 *
 */

public class ClassLoaderTest {

//	private static final Logger log = Logger.getLogger(ClassLoaderTest.class.getName());
	
	
	public boolean isConfusing() {
		   try {
		     return true;
		   } finally {
		     return false;
		   }
		}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)  {
		System.out.println("This is First line*****");
		// TODO Auto-generated method stub
//		DriverManager.getConnection("");
		
		System.out.println( "ret is : "+ new ClassLoaderTest().isConfusing());
		List<Item> al1 = new ArrayList<Item>();
		List<MyTask> al2 = new ArrayList<MyTask>();
		
		//System.out.println("Th op is "+  (al1 instanceof al2));
/*Hashtable ht = new Hashtable();
ht.put("", "");
HashMap hm = new HashMap();
hm.put(null, null);
hm.put(null, null);
		try {
		//	int i =1/0;
			Class.forName("StringTest");
			System.out.println("Class Loading Success*************");
			System.out.println("Class Loader Info :" +  ClassLoaderTest.class.getClassLoader().getParent().getParent());
			//StringTest s = new StringTest();
	} catch(Exception ex) {
			System.out.println("The exception ex is ---> "+ ex);	
			ex.printStackTrace();
	}
	}*/
	}
}
