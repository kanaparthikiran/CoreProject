/**
 * 
 */
package com.cisco.np6.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cisco.np6.entity.Continent;
import com.cisco.np6.util.HibernateUtil;

/**
 * @author test
 *
 */
public class ContinentDAO {
	
	private static final Logger log = Logger.getLogger(ContinentDAO.class.getName());
	
	/**
	 * 
	 * @param continent
	 */
	public void addContinent(Continent continent) {
		Session session = HibernateUtil.getHibernateSession();
		Transaction tx = session.beginTransaction();
		try {
			
			session.save(continent);
			tx.commit();
			log.info("Added Continent Successfully");
		}
		catch(Exception ex ){
			ex.printStackTrace();
			tx.rollback();
		}
	}

	
	/**
	 * 
	 * @param continentId
	 */
	public void deleteContinent(int continentId) {
		Session session = HibernateUtil.getHibernateSession();
		
		Transaction tx = session.beginTransaction();
		Continent delContinent = (Continent)session.load(Continent.class, continentId);
		session.delete(delContinent);
		log.info("Deleted Continent with Continent ID :" + continentId);
		tx.commit();
		
	}
	
	/**
	 * 
	 * @param continent
	 */
	public void updateContinent(Continent continent) {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Continent> getAllContinents() {
		Session session = HibernateUtil.getHibernateSession();
	
		List<Continent> continentsList = session.createQuery("from Continent").list();

		for(Continent ct : continentsList) {
			log.info("Continent Id:"+ ct.getContinentId()+" Continent Name: "+ct.getContinentName()+" Continent Description :"+ ct.getContintDescription());
		}
		
		return continentsList;
	}
	
	/**
	 * 
	 * @param continent
	 * @return
	 */
	public Continent getContinent(int continent) {
		return null;
	}
	
	
	public ContinentDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
