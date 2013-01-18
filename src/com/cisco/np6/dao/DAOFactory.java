/**
 * 
 */
package com.cisco.np6.dao;

/**
 * @author test
 *
 */
public interface DAOFactory {
	
	public CountryDAO getCountryDAO();
	public ContinentDAO getContinentDAO();
	

}
