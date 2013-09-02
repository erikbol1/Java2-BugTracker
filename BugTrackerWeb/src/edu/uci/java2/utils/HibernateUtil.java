package edu.uci.java2.utils;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public static SessionFactory getSessionFactory() throws ClassNotFoundException {
		if(sessionFactory==null){
			Class.forName("com.mysql.jdbc.Driver");
			Configuration configuration = new Configuration();
		    configuration.configure();
		    if(serviceRegistry==null){
		    	serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
		    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		    }
		}
	    return sessionFactory;
	}

}
