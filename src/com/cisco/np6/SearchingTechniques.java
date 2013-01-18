/**
 * 
 */
package com.cisco.np6;

/**
 * @author kikanapa
 *
 */
public class SearchingTechniques {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("found the element at the index :"+ 
		birarySearch(new int[]{3,4,6,5,7,8,9,10,17,19,20,30,11,12,13,14,15,16},13));
	}
	
	
	/**
	 * 
	 * @param a
	 * @return
	 */
	public static int birarySearch(int a[],int find) {
		int low = 1;
		int high = a.length;
		int mid = 0;
		int index = 0;
		int count = 0;
		while(low <= high) {
			count++;
			System.out.println("Counter Incremented "+ count+" times");
			mid = low + (high-low)/2;
			if(find == a[mid]) {
				index = mid;
				return index;
			} else if(find < a[mid]) {
				high = mid-1;
			} else if(find > a[mid]) {
				low = mid+1;
			}
		}
		System.out.println("found the element at the index :" +index);
		return index;
	}

}
