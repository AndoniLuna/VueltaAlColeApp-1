package com.ipartek.formacion.model;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataBaseHelper {

	void desconectar();

	Connection getConexion();

	void commit() throws SQLException;

	void rollback() throws SQLException;

}
