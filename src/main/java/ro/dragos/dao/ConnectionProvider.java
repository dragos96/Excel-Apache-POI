package ro.dragos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	
	public static Connection getConnection() throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/excelsample", "root", "1234");
		return con;
	}
}
