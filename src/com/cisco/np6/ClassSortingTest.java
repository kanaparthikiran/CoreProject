/**
 * 
 */
package com.cisco.np6;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author kikanapa
 *
 */

class Person implements Comparable<Person> {
	
	private int personId;
	private String personName;
	
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.personId-o.personId;
	}
	public Person(int personId, String personName) {
		super();
		this.personId = personId;
		this.personName = personName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + personId;
		result = prime * result
				+ ((personName == null) ? 0 : personName.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		if (personId != other.personId) {
			return false;
		}
		if (personName == null) {
			if (other.personName != null) {
				return false;
			}
		} else if (!personName.equals(other.personName)) {
			return false;
		}
		return true;
	}
	

	
	
}


class PersonNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		// TODO Auto-generated method stub
		return p1.getPersonName().compareTo(p2.getPersonName());
	}
	
	
}


public class ClassSortingTest {
	java.lang.Runtime rt = null;
	static {
		System.out.println("My Static test 444444444");
	}
	static {
		System.out.println("My Static test 111");
	}
	
	static void testM() {
		System.out.println("My Static method M");
	}
	
	static {
		System.out.println("My Static test 2222");
	}
	private static final Logger log = Logger.getLogger(ClassSortingTest.class.getName());
	
	static {
		System.out.println("My Static test 3333");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	log.info("Class Started to Execute*********");
	BigDecimal bd = new BigDecimal(2.0);
	

		// TODO Auto-generated method stub
		Person p1 = new Person(20,"Kiran");
		Person p2 = new Person(30,"Swe");
		Person p3 = new Person(25,"WNal");
		
		List<Person> list = new ArrayList<Person>();
		list.add(p1);list.add(p2);list.add(p3);
		
		PersonNameComparator pname = new PersonNameComparator();
		Collections.sort(list);
		Collections.sort(list, pname);
		log.info("Sortimg Completed>>...");
		for(Person elem : list){
			log.info("Person Details :: Id: "+ elem.getPersonId()+" Name "+elem.getPersonName());
		}
	}
	
	

}
