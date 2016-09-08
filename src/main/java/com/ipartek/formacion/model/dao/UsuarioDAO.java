package com.ipartek.formacion.model.dao;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.pojo.Usuario;

public interface UsuarioDAO {

	/**
	 * Inserta o crea un nuevo usuario {@code Usuario} en funcion del campo id.
	 * Si id= -1 crea uno nuevo Si id <> a -1 Modifica el usuario existente en
	 * la base de datos
	 *
	 * @param user
	 *            {@code Usuario}
	 * @return boolean
	 */
	boolean guardar(Usuario user);

	boolean borrar(int id);

	Usuario buscarPorId(int id);

	List<Usuario> listar();

	/**
	 * This is the method to be used to initialize database resources ie.
	 * connection.
	 */
	public void setDataSource(DataSource ds);

	/**
	 * Comprobar si {@code Usuario} existe en la base de datos
	 *
	 * @param nombre
	 *            {@code String} nombre a buscar
	 * @param pass
	 *            {@code String} contraseña a buscar
	 * @return {@code Usuario}, {@code null} si no existe
	 */
	Usuario checkLogin(String nombre, String pass);

}