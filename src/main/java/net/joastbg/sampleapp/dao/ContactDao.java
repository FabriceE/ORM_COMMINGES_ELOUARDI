package net.joastbg.sampleapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.joastbg.sampleapp.entities.Contact;

@Service
@Transactional
public class ContactDao {

	@Autowired
	SessionFactory sessionFactory;

	public int persist(Contact contact) {
		Session session = sessionFactory.getCurrentSession();
		int returnID = (int) session.save(contact);
		return returnID;
	}

	public Contact find(int idContact) {
		Session session = sessionFactory.getCurrentSession();
		return (Contact) session.load(Contact.class, idContact);
	}

	public List<Contact> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select idContact, type, valeur from Contact").list();
	}

	public void delete(Contact contact) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(contact);
	}
}
