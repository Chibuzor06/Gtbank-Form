package accountForm;

import java.sql.*;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{

	public ResultSet result;
	ResultSetMetaData metadata; 
	int numberOfRows;
	boolean connectedToDatabase = false;
	
	public MyTableModel(String sql) {
		// TODO Auto-generated constructor stub
		
		try {
			
			result = new JDBC().getConnection().createStatement().executeQuery(sql);
			connectedToDatabase = true;
			metadata = result.getMetaData();
			result.last();
			numberOfRows = result.getRow();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//fireTableDataChanged();
		
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		
		return numberOfRows;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		if(!connectedToDatabase){
			throw new IllegalStateException("Not Connected to Database");
		}
		try {
			return metadata.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public Class getColumnClass(int columnIndex) throws IllegalStateException{
		if(!connectedToDatabase){
			throw new IllegalStateException("Not Connected to Database");
		}
		try{
			String className = metadata.getColumnClassName(columnIndex + 1);
			return Class.forName(className);
		}catch(ClassNotFoundException | SQLException ex){
			System.out.println(ex.getMessage());
		}
		return Object.class;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		try {
			result.absolute(rowIndex + 1);
			return result.getObject(columnIndex + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}
	public String getColumnName(int column) throws IllegalStateException {
		if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }
		 try {
	            return metadata.getColumnName(column + 1);
	        } catch (SQLException sex) {
	            System.out.println(sex.getMessage());
	        }

	        return "";
		
	}
	public void disconnectFromDatabase() {
        if (connectedToDatabase) {
            try {
                result.close();
            } catch (SQLException sex) {
                System.out.println(sex.getMessage());
            } finally {
                connectedToDatabase = false;
            }
        }
    }
	
}
