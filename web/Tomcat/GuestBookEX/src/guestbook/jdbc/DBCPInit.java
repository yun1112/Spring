package guestbook.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInit extends HttpServlet {

	@Override
	public void init() throws ServletException {
		loadJDBCDriver();
		initConnectionPool();
	}

	
	public void loadJDBCDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 데이터베이스 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void initConnectionPool() {
		try {
			String jdbcDriver="jdbc:oracle:thin:@localhost:1521:xe";
			String username="scott";
			String pw="tiger";
			
			ConnectionFactory connFactory=new DriverManagerConnectionFactory(jdbcDriver,username,pw);
			
			PoolableConnectionFactory poolableConnFactory=new PoolableConnectionFactory(connFactory,null);
			
			GenericObjectPoolConfig poolConfig=new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L*60L*5L);
			poolConfig.setTestWhileIdle(true);
			
			poolConfig.setMinIdle(4);
			poolConfig.setMaxTotal(50);
			GenericObjectPool<PoolableConnection> connectionPool=new GenericObjectPool<>(poolableConnFactory,poolConfig);
			poolableConnFactory.setPool(connectionPool);
			
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver=(PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			
			driver.registerPool("pool",connectionPool);
			
			System.out.println("컨넥션 풀 등록");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
