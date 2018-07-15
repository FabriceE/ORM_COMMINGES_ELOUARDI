package net.joastbg.sampleapp;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import net.joastbg.sampleapp.dao.ContactDao;
import net.joastbg.sampleapp.entities.Contact;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class ContactDaoTest {

	@Autowired
	ContactDao contactDao;
	Contact contact;

	
	@Before
	public void setUp() {
		contact = new Contact();
		//contact.setType();
		//contact
		//contact
	}

	@Test
	public void testPersist() {
		//fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		//fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		//fail("Not yet implemented");
	}

}
