package com.jinan.www.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private  static SessionFactory sessionFactory;
	private  static  Session session;
	static  {
		
		//创建configuration对象，读取hibernate.cfg.xml文件，完成初始化。
		/*
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder ssRegistryBuilder= new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		StandardServiceRegistry standardServiceRegistry = ssRegistryBuilder.build();
		sessionFactory=configuration.buildSessionFactory(standardServiceRegistry);
		*/
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		
	}
	//获取sessionfactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	//获取session
	public static Session getSession() {
		session=sessionFactory.openSession();
		return session;
	}
	
	//关闭session
	public static void closeSession(Session session) {
		if(session!=null) {
			session.close();
		}
	}
}
