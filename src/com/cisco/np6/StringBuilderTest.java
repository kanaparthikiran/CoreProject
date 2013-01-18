/**
 * 
 */
package com.cisco.np6;

import java.util.logging.Logger;

/**
 * @author kikanapa
 *
 */
public class StringBuilderTest {

	private static final Logger log = Logger.getLogger(StringBuilderTest.class.getName());
	
	/**
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int Search(String haystack, String needle){
	    for(int i = 0; i < haystack.length(); i++ ) {
	        for(int j = 0; j < needle.length() &&
	                        i+j < haystack.length(); j++ ) {
	        	log.info("i is :"+i+" and j is : "+j+" and i+j is"+(i+j));
	        	if(needle.charAt(j) != haystack.charAt(i+j)) {
	                break;
	            } else if (j == needle.length()-1) {
	                return i;
	            }
	        }
	    }
	    return -1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Search("Welcome","come");
			StringBuilder sb = new StringBuilder("Hello");
			System.out.println("sb before :"+ sb);
			sb.reverse();
			System.out.println("sb after :"+ sb);
			String s = new String("Hello");
			char a[] = new char[s.length()];
			for(int i=s.length()-1,j=0;i>=0;i--) {
				a[j] = s.charAt(i);
				sb.append(a[j]);
				System.out.println(" i and a[i] in the loop: "+j+" and a[j]"+a[j] );
				j++;
			}
			sb.replace(0, 5, "");
			for(int i=0;i<a.length;i++) {
				System.out.println("a[i] is "+ a[i]+ " and sb is "+sb);
			}
			
			log.info("Called String ReverSE*******************");
			log.info("Out put of the call is: "+ revString("JAVALOGaeu"));
			
			printUpAndDown("WHATIS");
	}
	
	  /**
	   * 
	   * @param phrase
	   */
	  public static void printUpAndDown(String phrase){
		     
	         for(int i=0;i<phrase.length();i++){
	             System.out.print(phrase.charAt(i));
	             System.out.print("  ");
	             System.out.println(phrase.charAt(phrase.length()-i-1));
	            }         
	        }  
	  
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	private static String revString(String s) {
		String rev;
		StringBuilder sb = new StringBuilder();
		String vowels ="aeiouAEIOU";
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			log.info("prining the character c as :"+ c);
			//if(vowels.contains(String.valueOf(c)))
			if(vowels.indexOf(c)>0) {
			
			log.info("The Given character is Vowel*********** which is " + c);
			sb.append("*");
		} else {
			sb.append(c);
		}
		}
		rev = sb.toString();
		return rev;
	}

}
