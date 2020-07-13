package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {
	private Driver() {};
	static private Driver driver=new Driver();
	public static Driver getInstance() {return driver;}
	public Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
		String dbID = "temp";
		String dbPW = "temp";
		int idx=0;
			
		return DriverManager.getConnection(dbURL,dbID,dbPW);
		
	}
	

}
