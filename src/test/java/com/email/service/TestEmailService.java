package com.email.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.email.model.MailTemplate;
import com.email.service.MailTemplateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:hibernate4.xml"})
@TransactionConfiguration
@Transactional
public class TestEmailService {

	@Autowired
	private MailTemplateService emailServiceDao;
	
	@Test
	public void testCreateEntity(){
		MailTemplate email = new MailTemplate();
		email.setName("Bank");
		email.setTemplate("pattern");	
		Integer id = (Integer) emailServiceDao.insert(email);
		
		MailTemplate afterEmail = emailServiceDao.findById(id);
		assertEquals(email.getName(), afterEmail.getName());
		
	}
	
	@Test
	public void testUpdateEntity(){
		
		MailTemplate email = new MailTemplate();
		email.setName("Bank");
		email.setTemplate("pattern");	
		Integer id = (Integer) emailServiceDao.insert(email);
		
		MailTemplate updateEmail = emailServiceDao.findById(id);
		updateEmail.setName("Ball");
		emailServiceDao.update(updateEmail);
		
		MailTemplate afterEmail = emailServiceDao.findById(id);
		assertEquals(updateEmail.getName(), afterEmail.getName());
	}
	
	@Test
	public void testDeleteEntity(){
		
		MailTemplate email = new MailTemplate();
		email.setName("Bank");
		email.setTemplate("pattern");	
		Integer id = (Integer) emailServiceDao.insert(email);
		
		List<MailTemplate> emailListBefore = emailServiceDao.findAll();	
		emailServiceDao.delete(email);		
		
		List<MailTemplate> emailListAfter = emailServiceDao.findAll();
		
		assertEquals(emailListBefore.size()-1,emailListAfter.size());
		
	}
	
	@Test
	public void testFindAllEntity(){
		
		MailTemplate email1 = new MailTemplate();
		email1.setName("Bank");
		email1.setTemplate("pattern");	
		emailServiceDao.insert(email1);
		
		MailTemplate email2 = new MailTemplate();
		email2.setName("Bank");
		email2.setTemplate("pattern");	
		emailServiceDao.insert(email2);
		
		assertEquals(2,emailServiceDao.findAll().size());
	}
	
	@Test
	public void testFindByNameEntity(){
		
		MailTemplate email = new MailTemplate();
		email.setName("Bank");
		email.setTemplate("pattern");	
		emailServiceDao.insert(email);
		
		assertEquals("Bank",emailServiceDao.findByName(email.getName()).getName());
	}
}
