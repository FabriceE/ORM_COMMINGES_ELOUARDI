package net.joastbg.sampleapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.joastbg.sampleapp.entities.Assurance;
import net.joastbg.sampleapp.entities.CompteBancaire;

@Service
@Transactional
public class AssuranceDao {

	@Autowired
	SessionFactory sessionFactory;

	public String persist(Assurance assurance) {
		Session session = sessionFactory.getCurrentSession();
		String returnID = (String) session.save(assurance);
		return returnID;
	}

	public Assurance find(String idAssurance) {
		Session session = sessionFactory.getCurrentSession();
		return (Assurance) session.load(Assurance.class, idAssurance);
	}

	public void delete(Assurance assurance) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(assurance);
	}
}
