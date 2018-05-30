/**
 * 
 */
package com.objectlinx.util;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.internal.SQLQueryImpl;

/**
 * @author kikanapa
 *
 */
public class QueryThread implements Callable<BigDecimal>{
	private Logger log = null;
	private Session session = HibernateUtil.getHibernateSession();
	int count;
	
	@Override
	public BigDecimal call() {
		String curThreadName = Thread.currentThread().getName();
		log = Logger.getLogger(curThreadName);
		log.info("*** DONE DELETING ******");
		Random rn = new Random(1l); 
		int nextInt = rn.nextInt();
		log.info("next int created is**********: "+ nextInt);
		log.info("Testing the Flow using SQL Query****************");
		String delSql = "delete from HOUSE where HOUSE_NUMBER="+nextInt;
		Query delQuery = session.createSQLQuery(delSql);
		SQLQuery sq = null;SQLQueryImpl simpl = null;
		int delRows = delQuery.executeUpdate();
		log.info("Number of Deleted Rows*********************"+ delRows);
		log.info("Now trying to call the Stored Procedure*****************");
		Query exQuery = session.createSQLQuery("CALL " +
				"insertHouseHello(:timestmp,:hname,:hno,:hvalue)");
		exQuery.setParameter("timestmp", 
				new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
		exQuery.setParameter("hname", 34);
		exQuery.setParameter("hno", nextInt);
		exQuery.setParameter("hvalue", 12);
		int exRows =  0;
		exQuery.executeUpdate();
		log.info("Executed Rows from Stored Procedure****************"+exRows);
		count++;
		log.info("Executed the Query**** "+ count+"  times");
		log.info("*****DUMP STACK START*****");
		Thread.dumpStack();
		log.info("****DUMP STACK END*****");
		 return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
