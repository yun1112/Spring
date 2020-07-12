package javademo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

public class MysqlPstmt {
	private MysqlPstmt() {}
	static private MysqlPstmt java=new MysqlPstmt();
	public static MysqlPstmt getInstance() {return java;}
	
	
	public static Scanner sc = new Scanner(System.in);

	public static void selectQuery(Connection conn) throws SQLException {
		String query = "select * from users";
		PreparedStatement preparedStmt;
		ResultSet rs = null;

		try {
			preparedStmt = conn.prepareStatement(query);
			System.out.println("----------users----------");
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				System.out.printf("%s\t%s\t%d\t\n", rs.getString("first_name"), rs.getString("last_name"),
						rs.getInt("num_points"));

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void deleteQuery(Connection conn) {
		System.out.println("last_name(String)");
		String last_name = sc.nextLine();
		String query = "delete from users where last_name=?";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, last_name);
			preparedStmt.execute();
			if (preparedStmt != null)
				preparedStmt.close();
			System.out.println("delete successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateQuery(Connection conn) {
		System.out.println("first_name(String)");
		String first_name = sc.nextLine();
		System.out.println("last_name(String)");
		String last_name = sc.nextLine();
		System.out.println("num_points(int)");
		int num_points = sc.nextInt();

		String query = "update users set first_name=?, last_name=? where num_points=?";

		PreparedStatement preparedStmt;
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, first_name);
			preparedStmt.setString(2, last_name);
			preparedStmt.setInt(3, num_points);
			preparedStmt.execute();
			if (preparedStmt != null)
				preparedStmt.close();
			System.out.println("update successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void insertQuery(Connection conn) {
		Calendar calendar = Calendar.getInstance();
		Date startDate = new Date(calendar.getTime().getTime());
		System.out.println("first_name(String)");
		String first_name = sc.nextLine();
		System.out.println("last_name(String)");
		String last_name = sc.nextLine();
		System.out.println("num_points(int)");
		int num_points = sc.nextInt();

		// the mysql insert statement
		String query = " insert into users (first_name, last_name, date_created, is_admin, num_points)"
				+ " values (?, ?, ?, ?, ?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt;
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, first_name);
			preparedStmt.setString(2, last_name);
			preparedStmt.setDate(3, startDate);
			preparedStmt.setBoolean(4, false);
			preparedStmt.setInt(5, num_points);
			preparedStmt.execute();
			if (preparedStmt != null)
				preparedStmt.close();
			System.out.println("insert successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int type = 0;
		try {
			// create a mysql database connection
//      String myDriver = "org.gjt.mm.mysql.Driver";
//      String myUrl = "jdbc:mysql://localhost/demo";
//      Class.forName(myDriver);
//      Connection conn = DriverManager.getConnection(myUrl, "temp", "temp");

			String dbURL = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
			String dbID = "temp";
			String dbPW = "temp";

			Connection conn = DriverManager.getConnection(dbURL, dbID, dbPW);

			System.out.println("Connection OK");

			// create a sql date object so we can use it in our INSERT statement
//      Calendar calendar = Calendar.getInstance();
			// java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

			while (true) {
				System.out.println("--------------------------");
				System.out.println("choose type");
				System.out.println("0: exit");
				System.out.println("1: insert");
				System.out.println("2: update");
				System.out.println("3: delete");
				System.out.println("4: select");
				System.out.println("--------------------------");
				type = sc.nextInt();
				switch (type) {
				case 0:
					System.exit(0);
				case 1:
					insertQuery(conn);
					break;
				case 2:
					updateQuery(conn);
					break;
				case 3:
					deleteQuery(conn);
					break;
				case 4:
					selectQuery(conn);
					break;

				}

				if (conn != null)
					conn.close();
			}
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}
}