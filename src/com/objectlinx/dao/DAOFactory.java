/**
 * 
 */
package com.objectlinx.dao;

/**
 * @author test
 *
 */
public interface DAOFactory {
	
	public CountryDAO getCountryDAO();
	public ContinentDAO getContinentDAO();
	

}
