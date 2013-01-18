/**
 * 
 */
package com.cisco.np6;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * @author kikanapa
 *
 */
public class ImplArrayList {
	private static final Logger log = Logger.getLogger(ImplArrayList.class.getName());
	int a[];
	int size;
	int index;
	
	/**
	 * 
	 */
	public  ImplArrayList() {
		log.info("Created Array List with Default Size***:"+3);
		a = new int[3];
		size = 3;
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	public int[] add(int x) {
		log.info("The Current int size is***:"+ a.length);
		try {
		if(size <= 0) {
			throw new Exception("Underflow Exception********");
		} else if(size >0 ) {
			if(index <= size-1) {
			a[index] = x;
			index++;
			log.info("Updated ArrayIndex to ::::"+ index+" and set the element "+x); 
			} else {
				size = 2*size;
				log.info("Size Doubled as the Capacity Increased****new size is: "+ size);
				a =  Arrays.copyOf(a, size);
				//new int[size];
			}
		}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public int get(int index) {
		int element =0; 
		try {
			if(index>a.length-1) {
				throw new Exception("ArrayIndexOutOfBounds Exception*****");
			}
			element = a[index];
		} catch(Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	public int lcm(int a, int b) {
		int result=0;

		for(int i=1;i<b;i++) {
			if((a*i)%(b) == 0) {
				log.info("Returning the LCM as****:"+ i*a);
				return i*a;
			}
		}
		return result;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplArrayList ia = new ImplArrayList();
		ia.add(12);
		ia.add(13);
		ia.add(14);
		ia.add(15);
		ia.add(15);
		ia.add(15);
		ia.add(15);ia.add(15);ia.add(15);ia.add(15);ia.add(15);ia.add(15);ia.add(15);ia.add(15);ia.add(15);ia.add(15);ia.add(15);ia.add(15);ia.add(15);
		
		log.info("lcm of two numbers is :"+ ia.lcm(20,36));
	}

}
