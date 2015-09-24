package com.email.repository.dao;

import java.io.Serializable;

import com.email.model.MailTemplate;
import com.email.repository.base.GenericDao;

public interface MailTemplateDao extends GenericDao<MailTemplate, Serializable>{

	public MailTemplate findByName(String name);
}
