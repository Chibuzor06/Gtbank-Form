package accountForm;

import java.sql.*;
import java.util.Properties;

public class JDBC {
	private String URL = "jdbc:mysql://localhost/gregs_list"; 
	private String USER = "root";
	private String PASSWORD = "daRemix06";
	
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
