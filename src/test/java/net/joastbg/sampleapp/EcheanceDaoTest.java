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
import net.joastbg.sampleapp.dao.EcheanceDao;
import net.joastbg.sampleapp.entities.Echeances;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class EcheanceDaoTest {

	@Autowired
	EcheanceDao echeanceDao;
	Echeances echeances;
	
	@Before
	public void setUp() {
		echeances = new Echeances();
		echeances.setDateEmission(new Date());
		echeances.setDateEmissionFacture(new Date());
		echeances.setDatePaiement(new Date());
		echeances.setPrix(125);
	}

	@Test
	public void testPersist() {
		int id = echeanceDao.persist(echeances);
		Assert.assertTrue(id != 0);
		echeanceDao.delete(echeances);
	}
 
	@Test
	public void testFind() {
		int id = echeanceDao.persist(echeances);
		Echeances ehceanceTest = echeanceDao.find(id);
		Assert.assertNotNull(ehceanceTest);
		Assert.assertEquals(echeances, ehceanceTest);
		echeanceDao.delete(echeances);
	}

}
