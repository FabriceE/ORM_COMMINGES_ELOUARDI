package net.joastbg.sampleapp;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.joastbg.sampleapp.dao.EcheanceDao;
import net.joastbg.sampleapp.entities.Echeances;

public class EcheanceDaoTest {

	EcheanceDao echeanceDao;
	Echeances echeances;
	
	@Before
	public void setUp() throws Exception {
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
