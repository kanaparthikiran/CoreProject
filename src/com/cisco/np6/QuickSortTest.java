package com.cisco.np6;

public class QuickSortTest {
	

	/**
	 * 
	 * @param a
	 */
	public static void main(String a[]) {
	
		int[] x = new int[10];
		
		quickSort(x,0,x.length-1);
		
	}
	

 /**
  * 
  * @param x
  * @param min
  * @param max
  */
 public static void quickSort(int[] x, int low, int high) {
	 
	 
	 if(low>=high) {
		 return;
	 }
	 
	 int pivot = x[(low+high)/2];
	 
	 while(low<high && x[low]<pivot) {
		 low++;
	 }
	 while(low<high && x[high]>pivot) {
		 high--;
	 }
	 
	 if(low<high) {
		 
	 }
	 
	 
 }
	
}