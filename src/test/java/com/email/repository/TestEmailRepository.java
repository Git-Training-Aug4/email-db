package com.email.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.email.model.MailTemplate;
import com.email.repository.dao.MailTemplateDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:hibernate4.xml"})
@TransactionConfiguration
@Transactional
public class TestEmailRepository {

	@Autowired
	private MailTemplateDao eMailDao;
	
	@Test
	public void testCreateEntity(){
		MailTemplate email = new MailTemplate();
		email.setName("Bank");
		email.setTemplate("pattern");	
		Integer id = (Integer) eMailDao.insert(email);
		
		MailTemplate afterEmail = eMailDao.findById(id);
		assertEquals(email.getName(), afterEmail.getName());
		
	}
	
	@Test
	public void testUpdateEntity(){
		
		MailTemplate email = new MailTemplate();
		email.setName("Bank");
		email.setTemplate("pattern");	
		Integer id = (Integer) eMailDao.insert(email);
		
		MailTemplate updateEmail = eMailDao.findById(id);
		updateEmail.setName("Ball");
		eMailDao.update(updateEmail);
		
		MailTemplate afterEmail = eMailDao.findById(id);
		assertEquals(updateEmail.getName(), afterEmail.getName());
	}
	
	@Test
	public void testDeleteEntity(){
		
		MailTemplate email = new MailTemplate();
		email.setName("Bank");
		email.setTemplate("pattern");	
		Integer id = (Integer) eMailDao.insert(email);
		
		List<MailTemplate> emailListBefore = eMailDao.findAll();	
		eMailDao.delete(email);		
		
		List<MailTemplate> emailListAfter = eMailDao.findAll();
		
		assertEquals(emailListBefore.size()-1,emailListAfter.size());
		
	}
	
	@Test
	public void testFindAllEntity(){
		
		MailTemplate email1 = new MailTemplate();
		email1.setName("Bank");
		email1.setTemplate("pattern");	
		eMailDao.insert(email1);
		
		MailTemplate email2 = new MailTemplate();
		email2.setName("Bank");
		email2.setTemplate("pattern");	
		eMailDao.insert(email2);
		
		assertEquals(2,eMailDao.findAll().size());
	}
	
	@Test
	public void testFindByNameEntity(){
		
		MailTemplate email = new MailTemplate();
		email.setName("Bank");
		email.setTemplate("pattern");	
		eMailDao.insert(email);
		
		assertEquals("Bank",eMailDao.findByName(email.getName()).getName());
	}
	
}
