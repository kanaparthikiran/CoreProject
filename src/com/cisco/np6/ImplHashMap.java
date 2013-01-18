/**
 * 
 *//*
package com.cisco.np6;

*//**
 * @author kikanapa
 *
 *//*
class Entry<K,V> {
	
private final K key;
private V value;

	Entry(K key, V value) { 
	 this.key = key;
	 this.value = value;
		
	}
public V getValue() {
	return value;
}
public void setValue(V value) {
	this.value = value;
}
public K getKey() {
	return key;
}
	
}

class MyMap<K,V> {
	private final int DEFAULT_INIT_CAPACITY=16;
	private float DEFAULT_LOAD_FACTOR = 0.75f;
	private Entry<K,V>[] myEntries = new Entry[DEFAULT_INIT_CAPACITY]; 
	
	*//**
	 * 
	 * @param key
	 *//*
	public void put(K key, V value) {
		for(int i=0;i<myEntries.length;i++) {
			if(myEntries[i].getKey().equals(key)) {
				myEntries[i].setValue(value);
			}
		}
	}
	
	*//**
	 * 
	 * @param key
	 * @return
	 *//*
	public V get(K key) {
		
	}
	
	*//**
	 * 
	 * @return
	 *//*
	private boolean ensureCapacity() {
		
	}
	
}



public class ImplHashMap {

	
		
	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
*/