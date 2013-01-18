/**
 * 
 */
package com.cisco.np6.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;

import com.cisco.np6.entity.Country;
import com.cisco.np6.util.HibernateUtil;

/**
 * @author test
 *
 */
public class CountryDAO {

	private static final Logger log = Logger.getLogger(CountryDAO.class.getName());
	
	/**
	 * 
	 * @return
	 */
	public List<Country> getAllCountries() {
		Session session = HibernateUtil.getHibernateSession();
		//List<Country> countriesList = session.load(Country.class);
		return null;
	}
	
	/**
	 * 
	 * @param countryId
	 * @return
	 */
	public Country getCountry(int countryId) {
		Session session = HibernateUtil.getHibernateSession();
		Country country = (Country)session.load(Country.class, countryId);
		log.info("Got Country with Id :" + countryId);
		log.info("Country Details :::: "+ country.getCountryId()+ " "+country.getCountryName()+" "+ country.getCountryDescription());
		return country;
	}

	/**
	 * 
	 * @param country
	 */
	public void addCountry(Country country) {
		Session session = HibernateUtil.getHibernateSession();
		Transaction tx = session.beginTransaction();
		try {
		session.save(country);
		tx.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		}
		log.info("Country Object Saved Successfully*****");
	}
	
	public void deleteCountry(int countryId) {
		
	}
	
	
	/**
	 * 
	 */
	public CountryDAO() {
		// TODO Auto-generated constructor stub
	}

}
