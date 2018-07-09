package net.joastbg.sampleapp;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.joastbg.sampleapp.dao.SinistreDao;
import net.joastbg.sampleapp.entities.AssuranceAuto;
import net.joastbg.sampleapp.entities.Sinistre;

public class SinistreDaoTest {

	SinistreDao sinistreDao;
	Sinistre sinistre;
	
	@Before
	public void setUp() throws Exception {
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
