package com.jinan.www.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.jinan.www.entity.Animals;
import com.jinan.www.util.HibernateUtil;

public class Test {
 
	public static void main(String[] args) {
		
//		saveAnimals();
//		updateAnimals();
//		selectAnimals();
//		testCache1();
		testCache2();
		
	}
	public static void saveAnimals() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		Animals animals1 = new Animals("Tom", 1);
		Animals animals2 = new Animals("Tom", 1);
		session.save(animals1);
		session.save(animals2);
		transaction.commit();
		HibernateUtil.closeSession(session);
	}
	public static void updateAnimals() {
		Session session = HibernateUtil.getSession();
		Transaction transaction  = session.beginTransaction();
		
		Animals animals = session.get(Animals.class,2);
		animals.setName("jerry");
		animals.setAge(2);
		session.update(animals);
		
		transaction.commit();
		HibernateUtil.closeSession(session);
	}
	
	/*
	 * query.list()方法是不会使用缓存的。
	 */
	public static void selectAnimals() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		
		Query query = session.createQuery("from Animals");
		List<Animals> list=query.list();
		for(Animals animals :list) {
			System.out.println(animals.toString());
		}
		System.out.println("----------------");
		
//		query = session.createQuery("from Animals");
		list=query.list();
		for(Animals animals :list) {
			System.out.println(animals.toString());
		}
//		System.out.println("-----------------");
		/*
		 * query.iterate()方法在此版本中已经废弃
		 */
//		Iterator<Animals> iterator  = query.iterate();
		
	}
	
	
	/*
	 * 当两次查询同一个对象时，使用了一级缓存
	 */
	public static void testCache1() {
		Session session = HibernateUtil.getSession();
		
		Animals animals = session.get(Animals.class, 1);
		System.out.println(animals.toString());
		
//		session.evict(animals); //evict方法清除一级缓存中的指定对象
//		session.clear();//将一级缓存中的所有对象都清除
		
		Animals animals2 = session.get(Animals.class,1);
		System.out.println(animals2.toString());
		
	}
	/*
	 * 测试二级缓存
	 */
	public static void testCache2() {
		Session session = HibernateUtil.getSession();
		
		Animals animals = session.get(Animals.class, 1);
		System.out.println(animals.toString());
		
		session= HibernateUtil.getSession();
		animals = session.get(Animals.class, 1);
		System.out.println(animals.toString());
	}
}
