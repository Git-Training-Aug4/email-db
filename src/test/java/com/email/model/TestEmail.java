package com.email.model;

import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.email.model.MailTemplate;

public class TestEmail {

	private static final SessionFactory sessionFactory = createSessionFactory();
	private Session session;
	
	@Before
	public void setUp(){
		session = sessionFactory.openSession();
	}
	
	@After
	public void tearDown(){
		session.close();
	}
	
	@Test
	public void createEntity(){
		session.getTransaction().begin();
		MailTemplate email = new MailTemplate();
		email.setName("Bank");
		email.setTemplate("Pattern");
		session.save(email);
		session.getTransaction().commit();
	}
	
	@Test
	public void updateEntity(){
		
		session.getTransaction().begin();
		MailTemplate email = (MailTemplate)session.get(MailTemplate.class, 1);
		email.setName("Ball");
		session.update(email);
		session.getTransaction().commit();
		
		MailTemplate emailAfter = (MailTemplate)session.get(MailTemplate.class, 1);
		assertEquals("Ball",emailAfter.getName());
	}
	
	@Test
	public void deleteEntity(){
		session.getTransaction().begin();
		session.delete((MailTemplate)session.get(MailTemplate.class, 1));
		session.getTransaction().commit();
		
		assertNull((MailTemplate)session.get(MailTemplate.class, 1));
	}
	
	public static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()). buildServiceRegistry();
	    return configuration.buildSessionFactory(serviceRegistry);
	}
}