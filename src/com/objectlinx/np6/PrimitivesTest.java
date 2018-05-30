/**
 * 
 */
package com.objectlinx.np6;
import java.lang.Throwable;
/**
 * @author kikanapa
 *
 */
public class PrimitivesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean result = isValid(5);
		System.out.println("The result is :" + result);
		int j =0;
		for(int i=0;i<10;i++) {
			System.out.println(" j before: "+j );
			++j;
			System.out.println(" j after: "+j );
		}
		System.out.println("j is "+j);
	}
	
	
	public static boolean isValid(int i) {
		return (i%2==3);
	}

}
