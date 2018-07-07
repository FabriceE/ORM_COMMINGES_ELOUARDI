package net.joastbg.sampleapp.dao;

import net.joastbg.sampleapp.entities.CompteBancaire;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompteDao {

	@Autowired
	SessionFactory sessionFactory;

	public String persist(CompteBancaire compteBancaire) {
		Session session = sessionFactory.getCurrentSession();
		String returnID = (String) session.save(compteBancaire);
		return returnID;
	}

	public CompteBancaire find(String iban) {
		Session session = sessionFactory.getCurrentSession();
		return (CompteBancaire) session.load(CompteBancaire.class, iban);
	}

	public void delete(CompteBancaire compteBancaire) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(compteBancaire);
	}
}
