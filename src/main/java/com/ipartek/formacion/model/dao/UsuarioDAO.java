package com.ipartek.formacion.model.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Usuario;

public interface UsuarioDAO {

	/**
	 * Modifica o Crea un nuevo {@code Usuario}, en funcion del atributo
	 * {@code id}.<br>
	 * Si id = -1 crea nuevo.<br>
	 * Si id <> -1 Modifica el usuario existente en la BBDD.<br>
	 *
	 * @param u
	 *            {@code Usuario}
	 * @return boolean
	 */
	boolean save(Usuario u);

	boolean borrar(long id);

	Usuario buscarPorId(long id);

	List<Usuario> listar();

	/**
	 * Comprobar si {@code Usuario} existe en BBDD
	 * 
	 * @param nombre
	 *            {@code String} Nombre a buscar
	 * @param pass
	 *            {@code String} Contraseña a buscar
	 * @return {@code Usuario}, {@code null} si no existe
	 */
	Usuario checkLogin(String nombre, String pass);
}
