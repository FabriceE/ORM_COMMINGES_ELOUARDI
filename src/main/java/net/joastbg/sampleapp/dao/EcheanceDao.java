package net.joastbg.sampleapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.joastbg.sampleapp.entities.Echeances;

@Service
@Transactional
public class EcheanceDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public int persist(Echeances echeance) {
		Session session = sessionFactory.getCurrentSession();
		int returnID = (int) session.save(echeance);
		return returnID;
	}

	public Echeances find(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Echeances) session.load(Echeances.class, id);
	}
	
	public void delete(Echeances echeance) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(echeance);
	}
}
