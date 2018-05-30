import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.objectlinx.entity.City;
import com.objectlinx.entity.Street;
import com.objectlinx.util.HibernateUtil;



/**
 * 
 */

/**
 * @author kikanapa
 *
 */
public class UtilsTest {
	
	private static final Logger log = Logger.getLogger(UtilsTest.class.getName());
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		getNatkVersion("wwqr");
	testJoins();
	}

	
	private static void testJoins() {
		
		Session session = 	HibernateUtil.getHibernateSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		City city =   new City();
		city.setCityId(123L);
		city.setCityName("sjc");
		city.setCityType("metro");
		
		Street street = new Street();
		street.setStreetId(222L);
		street.setStreetName("1ststreet");
		street.setStreetNumber("555");
		session.save(street);
		List<Street> list = new ArrayList<Street>();
		list.add(street);
		city.setStreets(list);
		

		session.save(city);
		
		log.info("Now Trying to Read the Values*******");
		
	/*	City lCity  = (City)session.load(City.class, 57L);
		log.info("City  Loaded SUccessfull******");
		log.info("lCityId: "+ lCity.getCityId()+" lCityName: "+lCity.getCityName()+" lCityType: " +
				 lCity.getCityType());
		List<Street> lStreets = lCity.getStreets();
		log.info("lStreets in lCity as follows : "+lStreets.get(0));
		

		List<City> cityItems = session.createQuery("select city.cityName,street.streetName" +
				" from City city,Street street").list();
		log.info("Total Items are :" + cityItems.size());

		log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		List l1 = session.createSQLQuery("select city.city_Name,street.street_Name from " +
				"CITY city ,STREET street").list();
		Query q1 = session.createSQLQuery("insert into CITY(CITY_ID,CITY_NAME,CITY_TYPE) values(?,?,?)");
		q1.setLong(0,82L);
		q1.setString(1, "sfo");
		q1.setString(2, "mga");
		q1.executeUpdate();
		log.info("sql query update happened*****");
		log.info("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		Query sel = session.createSQLQuery("select * from CITY");
		int cSz = sel.list().size();
		log.info("City Size :"+ cSz);
		
		Query selC = session.createSQLQuery("select new DemoCustomers(custId,custCity,custEmail)" +
				" from DEMO_CUSTOMERS");
		@SuppressWarnings("unchecked")
		List<DemoCustomers> dcList =  (List<DemoCustomers>)selC.list();
		
		for(DemoCustomers dcElem : dcList) {
			DemoCustomers elem = (DemoCustomers)dcElem;
			log.info("Ciust Id "+ elem.getCustId()+" CustCity "+elem.getCustCity()+" " +
					"CustEmail "+elem.getCustEmail());
		}
		
		
		int cSzC = selC.list().size();
		log.info("CountrySize :"+ cSzC);*/
		
	//	Query selQ = session.createSQLQuery("select city_Id,city_Name from City  where city_Type = :city_Type").addScalar("city_Id",Hibernate.LONG));
		
		//Query query = session.createSQLQuery("").addScalar("stdErr",Hibernate.DOUBLE).addScalar("mean",Hibernate.DOUBLE);
		
		
		
	//	Query selQ = session.createQuery("select c.city_Id,c.city_Name from City c where c.city_Type = :cityType");
		
		
/*		SQLQuery qry = session.createSQLQuery("select c.city_Id,c.city_Name from City c where c.city_Type= :cityType").addEntity(City.class);
		// Hear PRODUCTS is the table in the database...
		qry.setParameter("cityType", "mga");
		List<City> l = qry.list();
		Iterator it = l.iterator();
		while(it.hasNext())
		{
//			Object row[] = (Object[])it.next();
			//log.info(" row[0] :"+ row[0]+" row[1] : "+row[1]);
			City c = (City)it.next();
			log.info(" row[0] cityName :"+ c.getCityName());
		}
		*/
		
		
		/*SQLQuery qry = session.createSQLQuery("select c.city_Id,c.city_Name,c.city_Type from City c where c.city_Type= :cityType").addEntity(City.class);
		qry.setParameter("cityType", "mga");
		List l = qry.list();
		Iterator it = l.iterator();
		while(it.hasNext())
		{
			City p = (City)it.next();
			log.info("Here it is******* CityName ->"+ p.getCityName()+" CityType-> "+p.getCityType());
		}
		
		*/
		log.info("Now trying to run update on the tables using SQL");
		
		SQLQuery insqry = session.createSQLQuery("insert into   CITY(CITY_ID,CITY_NAME,CITY_TYPE) values (:cityId,:cityName,:cityType)");
		
		
		insqry.setParameter("cityId",3440);
		insqry.setParameter("cityName","nyc");
		insqry.setParameter("cityType", "mga");
		
		int s= insqry.executeUpdate();
		log.info("update count :"+s);
	//	List lu = updateqry.list();
		
		log.info("insert Query Completed");
		
		
		SQLQuery updateqry = session.createSQLQuery("update   CITY set CITY_TYPE= :cityType  where city_name= :cityName");
		
		
		updateqry.setParameter("cityType","villas");
		updateqry.setParameter("cityName","nyc");
		
		
		int su= updateqry.executeUpdate();
		
		log.info("updated queries count***** :"+ su);
		
	//	"select s.stock_code from stock s where s.stock_code = :stockCode"
		
		String input  ="mga";
		//selQ.setString("cityType", input);
		
		/*selQ.setParameter("city_Type", input);
		
		List<City> dcList = (List<City>)selQ.list();
		
		
		
		
		Query query = session.createSQLQuery(sql)
				.addScalar("stdErr",Hibernate.DOUBLE).
				 addScalar("mean",Hibernate.DOUBLE);
		
		
		log.info("Select list Size "  + selQ.list().size());
		
		for (Object row : dcList) {
				//row
				City my = (City)row;
				 System.out.println("cityId: " + my.getCityName());
				 //System.out.println("CIty Name: " + row[1]);
				  }*/
		
		
/*		for(City dcElem : dcList) {
			City elem = (City)dcElem;
			log.info("Ciust Id "+ elem.getCityId()+"" +
					" CustCity "+elem.getCityType()+" ");
		}*/
		
		tx.commit();
		
		log.info("Transaction Committed for City Update********");
		
		
	}
	/**
	 * 
	 * @return
	 */
	public static String getNatkVersion(String input) {
		
		if(input!=null && !input.isEmpty()) {
			
			Session session = HibernateUtil.getHibernateSession();
			
		if( StringUtils.isAlpha(input) ) {
			log.info("Alphabetic^^^^^^^^^^^^^^^^^^");
/*			Query selQuery  = session.createSQLQuery("SELECT * FROM CUSTOMER_INFO");
			List<CustomerInfo> custInfo  = selQuery.list();*/
			
	/*		String hql = "FROM City";
			Query query = session.createQuery(hql);
			List<City> results = query.list();*/
			
	/*		select group_id from np_group_master 
		       where cust_id='$custId' 
		       and VIEWER_GROUP =1*/
		       
			String hqlS = "select group_id from np_group_master where  VIEWER_GROUP = :VIEWER_GROUP";
			
			Query query = session.createSQLQuery(hqlS);
			Integer VIEWER_GROUP = new Integer(1);
		//	query.setParameter("custId", input);
			query.setParameter("VIEWER_GROUP", VIEWER_GROUP);
			
/*			List l = query.list();
			log.info("List Size IS****************"+ l.size());
            Iterator it = l.iterator();
            while(it.hasNext())
            {
            	BigDecimal row = (BigDecimal)it.next();
                   log.info(" row[0] :"+ row);
            }*/

            
            String hqlC = "select c.CITY_NAME,c.CITY_TYPE,s.CITY_ID" +
            		",s.STREET_NAME from CITY c, STREET s where c.CITY_ID=s.CITY_ID ";
			Query queryC = session.createSQLQuery(hqlC);
			List<City> results = queryC.list();
			Iterator it1 = results.iterator();
			while(it1.hasNext())
            {
            	Object[] row = (Object[])it1.next();
                   log.info(" row[0] :"+ row[0]+" row[1]"+ 
            	row[1]+" row[2] "+ row[2]+" row[3] "+row[3]);
            }
			
			
/*			List<City> results = query.list();
			log.info("results size :"+ results.size());
			
			log.info("QueryC Executed*************");
			for(City city : results) {
				log.info("CustInfo Details : city "+ city.getCityName());
			}*/
			
			
/*			log.info("Query Executed*************");
			for(CustomerInfo cInf : custInfo) {
				log.info("CustInfo Details : custId "+ cInf.getCustId()+" custName "+cInf.getNatkVersion());
			}*/
			
		} else if(StringUtils.isNumeric(input)) {
			log.info("Numeric**********");
		} else {
			log.info("The value is alphanumeric*****");
		}
		} else {
			log.error("The Exception is the input is blank or Null****");
			
		}
		
		return "result";
	}
	
}
