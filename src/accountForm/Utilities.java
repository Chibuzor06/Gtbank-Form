package accountForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilities {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	
	public Utilities(){
		connection = new JDBC().getConnection();
		//		DriverManager.getConnection(JDBC.URL, JDBC.USER, JDBC.PASSWORD);
	}
	public Connection getConnection(){
		return connection;
		
	}
	public ResultSet ExecuteSQLStatement(String sql_stmt){
		try {
			statement = connection.createStatement();
			resultset = statement.executeQuery(sql_stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultset;
	}
}