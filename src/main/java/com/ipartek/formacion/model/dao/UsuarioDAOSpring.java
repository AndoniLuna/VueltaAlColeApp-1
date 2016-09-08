package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ipartek.formacion.model.mapper.UsuarioMapper;
import com.ipartek.formacion.pojo.Usuario;

public class UsuarioDAOSpring implements UsuarioDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override()
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);

	}

	@Override
	public boolean guardar(final Usuario user) {
		boolean resul = false;
		int affectedRows = -1;

		// insert
		if (-1 == user.getId()) {
			final KeyHolder keyHolder = new GeneratedKeyHolder();
			final String sqlInsert = "INSERT INTO `usuario` ( `nombre`, `password`, `email`) VALUES ( ? , ? , ? );";
			affectedRows = this.jdbcTemplateObject.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					final PreparedStatement ps = conn.prepareStatement(sqlInsert);
					ps.setString(1, user.getNombre());
					ps.setString(2, user.getPassword());
					ps.setString(3, user.getEmail());
					return ps;
				}
			}, keyHolder);

			user.setId(keyHolder.getKey().intValue());

			// modificar
		} else {
			final String sqlInsert = "UPDATE `usuario` SET `nombre`=?, `password`=?, `email`=? WHERE  `id`= ?;";
			final Object[] args = { user.getNombre(), user.getPassword(), user.getEmail(), user.getId() };
			affectedRows = this.jdbcTemplateObject.update(sqlInsert, args);
		}

		if (affectedRows == 1) {
			resul = true;
		}
		return resul;
	}

	@Override
	public boolean borrar(int id) {
		boolean resul = false;
		final String sql = "DELETE FROM `usuario` WHERE  `id`= ?;";
		if (1 == this.jdbcTemplateObject.update(sql, id)) {
			resul = true;
		}
		return resul;
	}

	@Override()
	public Usuario buscarPorId(int id) {
		Usuario user = null;
		final String SQL = "SELECT id, nombre , password, email from `usuario` where id = ?";
		try {
			user = this.jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new UsuarioMapper());
		} catch (final EmptyResultDataAccessException e) {
			user = null;
		}
		return user;
	}

	@Override()
	public List<Usuario> listar() {
		final String SQL = "SELECT id, nombre, password, email from `usuario` ORDER BY id desc limit 1000 ";
		List<Usuario> users = null;
		try {
			users = this.jdbcTemplateObject.query(SQL, new UsuarioMapper());
		} catch (final EmptyResultDataAccessException e) {
			users = null;
		}
		return users;
	}

	@Override()
	public Usuario checkLogin(String nombre, String pass) {
		Usuario resul;
		final String SQL = "select * from Usuario where nombre = ? and password = ?";
		final Object[] args = new Object[] { nombre, pass };
		try {
			resul = this.jdbcTemplateObject.queryForObject(SQL, args, new UsuarioMapper());
		} catch (final EmptyResultDataAccessException e) {
			resul = null;
		}
		return resul;
	}

}