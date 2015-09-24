package com.email.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.email.model.MailTemplate;
import com.email.repository.dao.MailTemplateDao;
import com.email.service.MailTemplateService;

@Service("mailServiceDaoImpl")
@Transactional
public class MailTemplateServiceImpl implements MailTemplateService{
	
	@Autowired
	private MailTemplateDao emailDao;
	
	public MailTemplate findById(Integer id) {
		return emailDao.findById(id);
	}
	
	public MailTemplate findByName(String name){
		return emailDao.findByName(name);
	}

	public List<MailTemplate> findAll() {
		return emailDao.findAll();
	}

	public Integer insert(MailTemplate model) {
		return (Integer) emailDao.insert(model);
	}

	public void update(MailTemplate model) {
		emailDao.update(model);
	}

	public void delete(MailTemplate model) {
		emailDao.delete(model);
	}

}
