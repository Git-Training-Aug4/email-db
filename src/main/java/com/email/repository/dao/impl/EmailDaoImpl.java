package com.email.repository.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.email.model.Email;
import com.email.repository.base.HibernateDAOImpl;
import com.email.repository.dao.EmailDao;

@Service
@Transactional
public class EmailDaoImpl extends HibernateDAOImpl<Email, Serializable> implements EmailDao{

}
