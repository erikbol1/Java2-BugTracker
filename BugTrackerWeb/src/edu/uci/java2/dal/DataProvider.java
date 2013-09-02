package edu.uci.java2.dal;


import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;



import edu.uci.java2.utils.HibernateUtil;

/**
 * @author dom
 * Class that provdies access thot Persisted object represented @param <T>
 */
class DataProvider<T> {
	
	
	//caching instances for performance
	private static InitialContext context;
	private final Class<T> type;
	
	//Added class to constructor to avoid expensive reflection
	DataProvider(Class<T> type){
		this.type = type;
	}
	
	T save(T object) throws NamingException, SQLException, DalException, ClassNotFoundException{
		
		if(context ==null){
			initInitialContext();
		}
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction=null;
		Session session = null;
		try{
			session = sessionFactory.openSession();
			
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(object);
			
			transaction.commit();
		}catch(Exception e){
			if(transaction!=null){
				transaction.rollback();
			}
			throw new DalException(e);
		}finally{
			if(session!=null){
				session.flush();
			}
		}
		return object;
	}
	
	T get(int ID) throws NamingException, ClassNotFoundException{
		if(context ==null){
			initInitialContext();
		}
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		return (T) session.get(type, ID);
	}
	
	T get(String attribute, String value) throws DalException, ClassNotFoundException{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<T> list = session.createCriteria(type).add(Restrictions.eq(attribute, value)).list();
		if(list.size()==0){
			throw new DalException("No reuslt to Return");
		}else if(list.size()>1){
			throw new DalException("More then one entry wiht: " + attribute + " equal " +value);
		}
		return list.get(0);
	}
	
	List<T> getAll() throws ClassNotFoundException{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<T> list = session.createCriteria(type).list();
		session.flush();
		return list;
		
	}
	
	private synchronized static void initInitialContext() throws NamingException{
		context = new InitialContext();
	}
}
