package com.ipartek.formacion.model.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.pojo.Usuario;

public class UsuarioDAOImplTest {

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
	public void testGuardar() {
		fail("Not yet implemented");
	}

	@Test()
	public void testBorrar() {
		fail("Not yet implemented");
	}

	@Test()
	public void testBuscarPorId() {
		fail("Not yet implemented");
	}

	@Test()
	public void testListar() {
		fail("Not yet implemented");
	}

	@Test()
	public void testCheckLogin() {
		final UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();

		final Usuario userExistente = dao.checkLogin("ernesto", "pecho");
		assertNotNull("Este usuario debe existir", userExistente);

		final Usuario userNull = dao.checkLogin("fqwe", "pecrwerqwho");
		assertNull("Este usuario debe ser null", userNull);
	}

}
