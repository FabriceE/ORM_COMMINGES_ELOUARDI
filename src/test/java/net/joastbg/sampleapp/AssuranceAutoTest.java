package net.joastbg.sampleapp;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.Assert;
import net.joastbg.sampleapp.dao.AssuranceDao;
import net.joastbg.sampleapp.entities.Assurance;
import net.joastbg.sampleapp.entities.AssuranceAuto;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class AssuranceAutoTest {

	@Autowired
	AssuranceDao assuranceDao;
	AssuranceAuto assuranceAuto;

	@Before
	public void setUp() {
		assuranceAuto = new AssuranceAuto();
		assuranceAuto.setDateAnniversaire(new Date());
		assuranceAuto.setDateSouscription(new Date());
		assuranceAuto.setDatePrelevement(new Date());
		assuranceAuto.setImmatriculation("ZL-015-AJ");
		assuranceAuto.setBonusMalus(2);
	}

	@Test
	public void testPersist() {
		int id = assuranceDao.persist(assuranceAuto);
		Assert.assertTrue(id != 0);
		assuranceDao.delete(assuranceAuto);
	}

	@Test
	public void testFind() {
		int id = assuranceDao.persist(assuranceAuto);
		AssuranceAuto assuranceFound = (AssuranceAuto) assuranceDao.find(id);
		Assert.assertNotNull(assuranceFound);
		Assert.assertEquals(assuranceAuto, assuranceFound);
		assuranceDao.delete(assuranceAuto);
	}

	@Test
	public void testFindAll() {
		List<Assurance> assurance = assuranceDao.findAll();
		Assert.assertNotNull(assurance);
	}

	@Test
	public void testActivationResiliation() {
		assuranceAuto.setResiliation(true);
		assuranceAuto.activationResiliation();
		Assert.assertTrue(assuranceAuto.getResiliation());
	}

}
