package testoracleconn;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class TestOracleConn {
	
	public static void main(String... arguments) {
		if (arguments.length != 3) {
			System.err.println("usage:");
			System.err.println("  java -jar testoracleconn <url> <username> <password>");
			System.exit(2);
		}
		String url = arguments[0];
		String username = arguments[1];
		String password = arguments[2];
		
		Properties properties = new Properties();
		properties.setProperty("driverClassName", System.getProperty("oracle.driverClassName", "oracle.jdbc.driver.OracleDriver"));
		properties.setProperty("url", url);
		properties.setProperty("username", username);
		properties.setProperty("password", password);
		
		try {
			System.out.println("Connecting to " + url + " with credentials " + username + "/" + password + "...");
			
			DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
			dataSource.getConnection();
			
			System.out.println("... connection accepted");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
}