package net.joastbg.sampleapp;

import junit.framework.Assert;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import net.joastbg.sampleapp.dao.ClientDao;
import net.joastbg.sampleapp.entities.Client;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.entities.PersonneMorale;
import net.joastbg.sampleapp.entities.PersonnePhysique;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class ClientDaoTest {

	@Autowired
	ClientDao clientDao;

	PersonnePhysique client;

	PersonneMorale client2;

	@Before
	public void setUp() {
		client = new PersonnePhysique();
		client.setNom("cathy");
		client.setPrenom("cathou");

		client2 = new PersonneMorale();
		client2.setNom("cathy");
		client2.setSiren(213454218);

		CompteBancaire compteBancaire = new CompteBancaire();
		compteBancaire.setIban("FR7630001512146598567890185");
		compteBancaire.setBIC("FR45714574");
		client.setComptePrincipal(compteBancaire);
	}

	@Test
	public void testPersist() {
		Assert.assertTrue(true);
	}

	@Test
	public void testFindAll() {
		List<Client> clients = clientDao.findAll();
		Assert.assertNotNull(clients);
	}

	@Test
	public void testFindPP() {
		int id = clientDao.persist(client);
		PersonnePhysique clientFound = (PersonnePhysique) clientDao.find(id);
		Assert.assertNotNull(clientFound);
		Assert.assertEquals(client, clientFound);
		clientDao.delete((Client) client);
	}

	@Test
	public void testFindPM() {
		int id = clientDao.persist(client2);
		PersonneMorale clientFound = (PersonneMorale) clientDao.find(id);
		Assert.assertNotNull(clientFound);
		Assert.assertEquals(client2, clientFound);
		clientDao.delete((Client) client2);
	}

}
