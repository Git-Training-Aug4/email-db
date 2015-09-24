package com.email.repository.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.email.model.MailTemplate;
import com.email.repository.base.HibernateDAOImpl;
import com.email.repository.dao.MailTemplateDao;

@Repository("mailTemplateDaoImpl")
public class MailTemplateDaoImpl extends HibernateDAOImpl<MailTemplate, Serializable> implements MailTemplateDao{

	public MailTemplate findByName(String name) {		
		Query query = sessionFactory.getCurrentSession().getNamedQuery("FIND_BY_NAME_MAIL_TEMPLATE");
		query.setParameter("NAME", name);
		List<MailTemplate> mailTemplates = query.list();
		if(mailTemplates!=null){
			return mailTemplates.get(0);
		}
		
		return null;
	}

}
