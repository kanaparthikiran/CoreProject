/**
 * 
 */
package com.objectlinx.np6;

import java.util.logging.Logger;

/**
 * @author kikanapa
 *
 */
public class SimpleOnes {
private static final Logger log = Logger.getLogger(SimpleOnes.class.getName());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.info("factorial is  :"+ fact(5));
		//fibo(10);
		//log.info("fiboRec is :" + fiboRec(5));
		for(int  i=0;i<10;i++) {
			log.info("prinitng fibo num :"+ fiboRec(i));
		}
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	static int factRec(int n) {
		if(n<=1) {
			return 1;
		} 
		n = n * factRec(n-1);	
		return n;
	}
	
	static int fact(int n) {
		int x=1;
		for(int i =n-1;i>0;i--) {
			n = n*i;
		}
		return n;
	}
	
	
	static void fibo(int n) {
		int n1 = 1;
		int n2 =1;
		System.out.print(n1+" "+n2);
		for(int i=0;i<n-2;i++) {
			int n3 = n1+n2;
			n1 = n2;
			n2 = n3;
			//fibo(n);
			System.out.print(" "+ n3);
	}
	//return;
	}
	
	/**
	 * 
	 * @param n
	 */
	static int  fiboRec(int n) {
		int x=0 ;
		if(n<=2) {
			return 1;
		}
		log.info("Now came to else fiboRec****");
		return (fiboRec(n-1) +fiboRec(n-2));
		
	}
}
