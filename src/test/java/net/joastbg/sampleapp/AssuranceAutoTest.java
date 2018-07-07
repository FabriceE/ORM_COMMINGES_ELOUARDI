package net.joastbg.sampleapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import net.joastbg.sampleapp.dao.AssuranceDao;
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

	}

	@Test
	public void testPersist() {
	}

	@Test
	public void testFind() {
	}

	@Test
	public void testActivationResiliation() {
	}

}
