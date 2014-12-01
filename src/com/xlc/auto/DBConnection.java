package com.xlc.auto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBConnection {

	private static BasicDataSource dbs;

	private final static String MYSQL_CONN_URL = "jdbc:mysql://127.0.0.1:3306/app_message?characterEncoding=utf-8";

	static {

		if (dbs == null) {

			dbs = new BasicDataSource();

			dbs.setDriverClassName("com.mysql.jdbc.Driver");

			dbs.setUrl(MYSQL_CONN_URL);

			dbs.setUsername("root");

			dbs.setPassword("6516384");

		}

	}

	public static Connection getConnection() {

		try {

			return dbs.getConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void closeConnection(Connection conn, PreparedStatement ps,
			ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
