package com.email.repository;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.email.model.Email;
import com.email.repository.dao.EmailDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:hibernate4.xml"})
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class TestEmailRepository {

	@Autowired
    private SessionFactory sessionFactory;
	@Autowired
	private EmailDao eMailDao;
	
	@Test
	public void testCreateEntity(){
		Email email = new Email();
		email.setName("Bank");
		email.setPattern("pattern");	
		Integer id = (Integer) eMailDao.insert(email);
		
		Email afterEmail = eMailDao.findById(id);
		assertEquals(email.getName(), afterEmail.getName());
		
	}
	
}
