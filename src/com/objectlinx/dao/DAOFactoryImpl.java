/**
 * 
 */
package com.objectlinx.dao;

/**
 * @author test
 *
 */
public class DAOFactoryImpl implements DAOFactory {
	
	private static CountryDAO countryDAO =  null;
	private static ContinentDAO continentDAO = null;

	/* (non-Javadoc)
	 * @see com.cisco.np6.dao.DAOFactory#getCountrDAO()
	 */
	@Override
	public CountryDAO getCountryDAO() {
		// TODO Auto-generated method stub
		
		if(countryDAO == null) {
			countryDAO = new CountryDAO();
		}
		return countryDAO;
	
	}

	/* (non-Javadoc)
	 * @see com.cisco.np6.dao.DAOFactory#getContinentDAO()
	 */
	@Override
	public ContinentDAO getContinentDAO() {
		// TODO Auto-generated method stub
		if(continentDAO == null) {
		continentDAO = new ContinentDAO();
		} 
		return continentDAO;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
