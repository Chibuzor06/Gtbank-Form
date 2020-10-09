package accountForm;

import java.sql.*;
import java.util.Properties;

public class JDBC {
	protected final String URL = "jdbc:mysql://localhost/gregs_list"; 
	protected final String USER = "<enter user here>";
	protected final String PASSWORD = "<enter password here>";
	
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
