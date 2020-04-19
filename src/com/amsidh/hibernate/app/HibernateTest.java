package com.amsidh.hibernate.app;




import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.amsidh.hibernate.domains.UserDetails;

public class HibernateTest {

	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
        Query query=session.createQuery("from userdetails");
		List<UserDetails> users=(List<UserDetails>)query.list();
		session.getTransaction().commit();
		session.close();
		
		for (UserDetails userDetails : users) {
			System.out.println(userDetails.getUserName());
		}
		
		
	}

}
