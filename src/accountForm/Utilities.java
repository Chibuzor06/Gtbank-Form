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
		System.out.println("Line 16, Utilities");
		//		DriverManager.getConnection(JDBC.URL, JDBC.USER, JDBC.PASSWORD);
	}
	public Connection getConnection(){
		return connection;
		
	}
	public ResultSet ExecuteSQLStatement(String sql_stmt){
		try {
			if(connection == null){
				connection = new JDBC().getConnection();
				System.out.println("Line 26, Utilities");
			}
			statement = connection.createStatement();
			resultset = statement.executeQuery(sql_stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return resultset;
	}
	public int executeUpdate(String sql_stmt){
		int returnValue = -1;
		try {
			if(connection == null) connection = new JDBC().getConnection();
			statement = connection.createStatement();
			returnValue = statement.executeUpdate(sql_stmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(connection != null){
				
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return returnValue;
	}
}