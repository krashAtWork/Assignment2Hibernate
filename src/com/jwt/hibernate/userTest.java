package com.jwt.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class userTest {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("*******welcome to the world of magic*********");
		System.out.println("please Sign up by entering a username");

		// take input
		String userName = input.next();
		User userObj = new User();
		userObj.username = userName;

		addUser(userObj);

	}

	/*
	 * private static void addUser( User userObj ) { //code using annnotation
	 * Session session = factory.openSession(); Transaction tx = null; try{ tx =
	 * session.beginTransaction(); userObj.setUsername(userObj.username);
	 * session.save(userObj); tx.commit(); }catch (HibernateException e) { if
	 * (tx!=null) tx.rollback(); e.printStackTrace(); }finally {
	 * session.close(); }
	 */

	// code for xml mapping
	private static void addUser(User userObj) {
		Configuration cfg = new Configuration();// opening and creating
												// configuration instance//
		//cfg.configure("hibernate.cfg.xml");
		System.out.println("1");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		System.out.println("2");
		//User userObj = new User();
		userObj.setUsername(userObj.username);

		Transaction tx = session.beginTransaction();
		session.save(userObj);
		System.out.println("Object saved successfully.....!!");
		tx.commit();
		session.close();
		factory.close();

	}

}/*this is my test class, where i take user input, reference my database location using the configuration file
hibernate.cfg.xml. build a session factory, open a session, 
	in this session, i add the input to the database, the transaction begins, the input is saved and the action commited,
	session and factory both are closed
*/






