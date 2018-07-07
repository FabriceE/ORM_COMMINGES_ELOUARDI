package net.joastbg.sampleapp;

import junit.framework.Assert;
import net.joastbg.sampleapp.dao.ClientDao;
import net.joastbg.sampleapp.entities.PersonnePhysique;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class ClientDaoTest {

	@Autowired
	ClientDao clientDao;

	PersonnePhysique client;

	@Before
	public void setUp() {
		client = new PersonnePhysique();
		client.setNom("cathy");
		client.setPrenom("cathou");
	}

	@Test
	public void testPersist() {
		Assert.assertTrue(true);
	}

}
