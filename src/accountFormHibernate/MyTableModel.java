package accountFormHibernate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.swing.table.AbstractTableModel;

import org.hibernate.query.Query;

import com.mysql.jdbc.Blob;

public class MyTableModel extends AbstractTableModel{

	private String[] columnNames;
	private List<Object> objectData;
	private HibernateUtilities hibernate;
	public MyTableModel(String[] columnNames, String hql){
		this.columnNames = columnNames;
		hibernate = new HibernateUtilities();
		
		hibernate.startNewSession();
		Query query = hibernate.getSession().createQuery(hql);
		objectData = query.list();
		hibernate.getSession().close();
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return objectData.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	@Override
	public String getColumnName(int column){
		return columnNames[column];
	}

	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		AccountHolder person = new AccountHolder();
		switch(columnIndex){
		case 0:
			return Integer.class;
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			return String.class;
		case 7:
		case 8:
		case 9:
		case 10:
		case 11:
		case 12:
			return Character.class;
		case 13:
			return String.class;
		case 14:
			return Blob.class;
		case 15:
			return String.class;
		case 16:
			return Blob.class;
		case 17:
			return String.class;
		case 18:
		case 19:
			return Character.class;
		case 20:
		case 21:
			return String.class;
		default:
			return super.getColumnClass(columnIndex);			
		}
		
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		AccountHolder person = (AccountHolder)objectData.get(rowIndex);
		switch(columnIndex){
		case 0:
			return (Integer)person.getID();
		case 1:
			if(person.getDate() == null){
				return "";
			}
			else{
				return format1.format(person.getDate().getTime());
			}
			//return person.getDate().getDisplayName(Calendar., Calendar.ALL_STYLES, Locale.ENGLISH);
		case 2:
			return person.getCompanyName();
		case 3:
			return person.getOfficeTelephone();
		case 4:
			return person.getWebAddress();
		case 5:
			return person.getAccountNumber();
		case 6:
			return person.getRmtEmailAddress();
		case 7:
			return (Character)person.getAllAccounts();
		case 8:
			return (Character)person.getSelectAccounts();
		case 9:
			return (Character)person.getChequeConfirmation();
		case 10:
			return (Character)person.getNibbs();
		case 11:
			return (Character)person.getStandingInstructions();
		case 12:
			return (Character)person.getCustomDuty();
		case 13:
			return person.getName1();
		case 14:
			return person.getSignature1();
		case 15:
			return person.getName2();
		case 16:
			return person.getSignature2();
		case 17:
			return person.getSignatureVerification();
		case 18:
			return (Character)person.getNew();
		case 19:
			return (Character)person.getExisting();
		case 20:
			return person.getTreatedBy1();
		case 21:
			return person.getTreatedBy2();
		default:
			return null;
			
		}
	
	}

}