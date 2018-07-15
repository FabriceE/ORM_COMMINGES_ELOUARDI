package net.joastbg.sampleapp;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.Assert;
import net.joastbg.sampleapp.dao.SinistreDao;
import net.joastbg.sampleapp.entities.AssuranceAuto;
import net.joastbg.sampleapp.entities.Sinistre;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class SinistreDaoTest {

	@Autowired
	SinistreDao sinistreDao;
	Sinistre sinistre;
	
	@Before
	public void setUp() {
		sinistre = new Sinistre(new Date(), "titre de sinistre", "description de sinistre", new AssuranceAuto());
	}

	@Test
	public void testPersist() {
		int id = sinistreDao.persist(sinistre);
		Assert.assertTrue(id != 0);
		sinistreDao.delete(sinistre);
	}

	@Test
	public void testFind() {
		int id = sinistreDao.persist(sinistre);
		Sinistre sinistreFound = sinistreDao.find(id);
		Assert.assertNotNull(sinistreFound);
		Assert.assertEquals(sinistre, sinistreFound);
		sinistreDao.delete(sinistre);
	}

}
