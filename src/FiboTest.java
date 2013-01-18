import org.apache.log4j.Logger;

/**
 * 
 */

/**
 * @author kikanapa
 *
 */
public class FiboTest {
	
	private static final Logger log =
			Logger.getLogger(FiboTest.class.getName());

	int series[] = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[] = new FiboTest().fib(10);
		for(int i=0;i<x.length;i++) {
			log.info("The Array Length is :"+ x.length);
			log.info("Elements in Fibo are***:" +
					" x["+i+"]"+x[i]);
			
		}
	}

	
	/**
	 * 
	 * @param limit
	 * @return
	 */
	public int[] fib(int limit) {
		series = new int[limit];
		series[0] =0;
		series[1] =1;
		for(int i=2;i<limit-1;i++) {
			series[i] = series[i-1]+series[i-2];
			log.info("Adding the Element*****:"+ series[i]);
		}
	
		return series;
	}
}
