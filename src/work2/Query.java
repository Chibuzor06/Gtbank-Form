package work2;

import java.sql.*;

public class Query {
	Statement statement = null;
	//boolean query = false;
	String sql;
	Query(String sqlStatement){
		JDBC conn = new JDBC();
		try{
			statement = conn.getConnection().createStatement();
			statement.executeQuery(sqlStatement);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
}
