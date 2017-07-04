package accountFormHibernate;

public class DisplayReports extends JasperReports{
	
	
	public void showRecord(){
		sql = "SELECT * FROM work_database ORDER BY ID";
		reportSource = "rptAccountForm.jrxml";
		showReport(true);
	}
	public void saveRecord(){
		sql = "SELECT * FROM work_database ORDER BY ID";
		reportSource = "rptAccountForm.jrxml";
		showReport(false);
	}
}
