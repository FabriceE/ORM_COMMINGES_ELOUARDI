package net.joastbg.sampleapp;

import static org.junit.Assert.*;

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
import net.joastbg.sampleapp.dao.CompteDao;
import net.joastbg.sampleapp.entities.Assurance;
import net.joastbg.sampleapp.entities.CompteBancaire;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class AssuranceTest {

	@Autowired
    AssuranceDao assuranceDao;

    @Before
    public void setUp() {
    	
        
    }

    @Test
    public void testPersist(){
    }

    @Test
    public void testFind(){
    }
	
	@Test
	public void testActivationResiliation() {
	}

}
