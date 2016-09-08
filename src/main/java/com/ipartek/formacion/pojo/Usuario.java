package com.ipartek.formacion.pojo;

/**
 * POJO para Usuario
 *
 * @author ur00
 *
 */
public class Usuario {

	// propiedades
	private int id;
	private String nombre;
	private String password;
	private String email;

	// Constructores
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.password = "";
		this.email = "";
	}

	public Usuario(int id, String nombre, String password, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
	}

	// Getters y Setters

	public int getId() {
		return this.id;
	}

	public void setId(int idUsuario) {
		this.id = idUsuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Funciones o Metodos

	@Override()
	public String toString() {
		return "Usuario [id=" + this.id + ", nombre=" + this.nombre + ", password=" + this.password + ", email="
				+ this.email + "]";
	}

}
