/**
 * 
 */
package com.cisco.np6.dao;

import java.util.List;

import org.hibernate.Session;

import com.cisco.np6.entity.House;
import com.cisco.np6.util.HibernateUtil;

/**
 * @author test
 *
 */
public class HouseAddressDAO {

	/**
	 * 
	 * @param newHouse
	 */
	private void addHouse(House newHouse) {
		
	}
	
	/**
	 * 
	 * @param houseId
	 * @return
	 */
	
	private House getHouse(int houseId) {
		
		Session session =  HibernateUtil.getHibernateSession();
		House  newHouse =  (House)session.load(House.class, houseId);
		return newHouse;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private List<House> getAllHouses() {
		
		return null;
	}
	
	/**
	 * 
	 * @param houseId
	 */
	private void deleteHouse(int houseId) {
		
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
