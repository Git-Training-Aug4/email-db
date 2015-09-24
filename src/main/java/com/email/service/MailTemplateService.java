package com.email.service;

import java.util.List;

import com.email.model.MailTemplate;

public interface MailTemplateService {

	public MailTemplate findById(Integer id);
	
	public MailTemplate findByName(String name);
	
	public List<MailTemplate> findAll();

	public Integer insert(MailTemplate model);

	public void update(MailTemplate model);

	public void delete(MailTemplate model); 
}
