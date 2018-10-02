package com.training.utils;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbConnection {

	public static Connection getOracleConnection() {

		Connection con = null;

		try {

			Properties props = new Properties();
			FileInputStream inStream = new FileInputStream(new File("jdbc.properties"));

			props.load(inStream);

			Class.forName(props.getProperty("db.driverClass"));

			String url = props.getProperty("db.url");
			String username = props.getProperty("db.userName");
			String password = props.getProperty("db.passWord");

			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

}
