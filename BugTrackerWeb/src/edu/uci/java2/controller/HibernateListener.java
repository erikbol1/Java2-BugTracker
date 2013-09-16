package edu.uci.java2.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.HibernateException;

import edu.uci.java2.utils.HibernateUtil;

public class HibernateListener implements ServletContextListener {  
	   
 

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			HibernateUtil.getSessionFactory();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			HibernateUtil.getSessionFactory().close();
		} catch (HibernateException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}  
}  
 