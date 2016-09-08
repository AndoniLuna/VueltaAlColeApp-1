package com.ipartek.formacion.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.pojo.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {
	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		final Usuario user = new Usuario();
		user.setId(rs.getInt("id"));
		user.setNombre(rs.getString("nombre"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		return user;
	}

}
