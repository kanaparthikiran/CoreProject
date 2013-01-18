/*import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import org.apache.log4j.Logger;

*//**
 * 
 *//*

*//**
 * @author kikanapa
 *
 *//*

class One {
	One() {}
	private int a;
	private  int b;
	*//**
	 * @return the a
	 *//*
	public int getA() {
		return a;
	}
	*//**
	 * @param a the a to set
	 *//*
	public void setA(int a) {
		this.a = a;
	}
	*//**
	 * @return the b
	 *//*
	public int getB() {
		return b;
	}
	*//**
	 * @param b the b to set
	 *//*
	public void setB(int b) {
		this.b = b;
	}
}


public class BasicTest {
Object o1 = null;

	private static final Logger log = Logger.getLogger(BasicTest.class.getName());
	
	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int j =1;
				
		for(int i=0;i<100;i++) {
			j++;
		}
			log.info("Log the J Value :" + j);
		
			
			
			One one = new One();
			
			one.setA(3);
			one.setB(4);
			
		One b2 = isValid(20,one);
			//log.info("boolean value :" + b);
			
			log.info("One b2 values after Return :a -" +  b2.getA()+" b-"+b2.getB());
			
			isValid(4,one);
			
			int z = 213321343;
			log.info("int number range is :" + Math.pow(2.0, 31.0));
			
			BigInteger bi1 = new BigInteger("1");
			
			BigDecimal bd = new BigDecimal("1234344");
			
			BigDecimal bd2 = new BigDecimal("12343442222");
			
		log.info("bd2 : "+ bd2);
			
		
	       // create 2 BigDecimal Objects
        BigDecimal bg1, bg2;

	bg1 = new BigDecimal("5.46497");

        MathContext mc = new MathContext(1); // 3 precision

        // bg1 is rounded using mc
        bg2 = bg1.round(mc);

	String str = "The value " + bg1 + " after rounding is " + bg2;

        // print bg2 value
        System.out.println( str );
			
		}
	

*//**
 * 
 * @param i
 * @param one
 * @return
 *//*
public static One  isValid(int i, One one) {
		//return (i%2 == 1);
		one = new One();
		one.setA(5);
		one.setB(6);
		int a[] = new int[100000];
		return one;
	}
}
*/