package com.ipartek.formacion.model;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataBaseHelperImplTest {

	@BeforeClass()
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass()
	public static void tearDownAfterClass() throws Exception {
	}

	@Before()
	public void setUp() throws Exception {
	}

	@After()
	public void tearDown() throws Exception {
	}

	@Test()
	public void testConection() {

		final DataBaseHelper db = DataBaseHelperImpl.getInstance();
		final Connection con = db.getConexion();
		assertNotNull(con);
	}

}
