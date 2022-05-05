package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository
@Transactional
public class PersonDao {
	
	@Autowired
	private SessionFactory factory;
	
	public Session getSession() {
		Session session=factory.getCurrentSession();
		if(session==null) {
			session=factory.openSession();
		}
		return session;
	}
	
	public void savePerson(Person person) {
		getSession().save(person);
	}
	
	@SuppressWarnings("deprecation")
	public List<Person> getPerson(){
		return getSession().createCriteria(Person.class).list();
	}

}
