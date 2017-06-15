package work2;

import java.sql.*;
import java.util.Properties;

public class JDBC {
	private String URL = "jdbc:mysql://localhost/gregs_list"; 
	private String USER = "username-here";
	private String PASSWORD = "password-here";
	
	Connection getConnection(){
		Connection con = null;
		Properties prop = new Properties();
		prop.put("user", this.USER);
		prop.put("password", this.PASSWORD);
		try{
			con = DriverManager.getConnection(this.URL, prop);
			}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
}
