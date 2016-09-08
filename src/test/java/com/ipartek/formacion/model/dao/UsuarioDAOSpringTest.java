package com.ipartek.formacion.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ipartek.formacion.pojo.Usuario;

public class UsuarioDAOSpringTest {

	static ApplicationContext context;
	static UsuarioDAOSpring daoUsuario;
	static Usuario user;

	@BeforeClass()
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("beans.xml");
		daoUsuario = (UsuarioDAOSpring) context.getBean("UsuarioDAOSpring");
	}

	@AfterClass()
	public static void tearDownAfterClass() throws Exception {
		context = null;
		daoUsuario = null;
	}

	@Before()
	public void setUp() throws Exception {
		user = new Usuario();
	}

	@After()
	public void tearDown() throws Exception {
		user = null;
	}

	@Test
	public void testCheckLogin() {

		final Usuario uExsitente = daoUsuario.checkLogin("ernesto", "pecho");
		assertNotNull("Este Usuario de existir", uExsitente);

		final Usuario uNull = daoUsuario.checkLogin("dfgdfg", "gdfsg");
		assertNull("Usuario debe ser Null", uNull);

	}

	@Test
	public void testGuardar() {
		// insertar usuario
		assertTrue("Usuario No insertado" + user, daoUsuario.guardar(user));
		final int id = user.getId();
		assertNotEquals("Deberia tener ID <> -1 ", -1, id);

		// modificar usuario
		user.setEmail("borrar@borrar.com");
		user.setNombre("borrar");
		user.setPassword("12345456");
		assertTrue("Usuario No Modificado" + user, daoUsuario.guardar(user));
		assertEquals("Deberia ser mismo ID", id, user.getId());
		assertTrue("No se puedo eliminar " + user, daoUsuario.borrar(id));

	}

	@Test
	public void testBorrar() {
		assertFalse("No se puedo eliminar Usuario Inexistente ", daoUsuario.borrar(-1));
	}

	@Test
	public void testBuscarPorId() {
		daoUsuario.guardar(user);
		final int id = user.getId();
		assertNotNull(daoUsuario.buscarPorId(id));
		daoUsuario.borrar(id);
		assertNull(daoUsuario.buscarPorId(-1));
	}

	@Test
	public void testListar() {
		ArrayList<Usuario> users = (ArrayList<Usuario>) daoUsuario.listar();
		final int numUsuarioInciales = users.size();
		daoUsuario.guardar(user);
		users = (ArrayList<Usuario>) daoUsuario.listar();
		assertEquals((numUsuarioInciales + 1), users.size());
	}

}
