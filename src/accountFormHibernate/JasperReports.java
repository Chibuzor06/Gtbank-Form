package accountFormHibernate;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JasperReports {
	String reportSource = "/accountFormHibernate/";
	String sql;
	Map parameters = new HashMap();
	private static int number = 1;
	String documentName;
	
	public void showReport(boolean display){
		
		try {
			
			File pdfName; 
		
			
			InputStream is = getClass().getResourceAsStream(reportSource);
			Utilities util = new Utilities();
			
			JRDesignQuery designQuery = new JRDesignQuery();
			designQuery.setText(sql);
			
			JasperDesign jasperDesign = JRXmlLoader.load(is);
			jasperDesign.setQuery(designQuery);
			
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, util.getConnection());
			if(display){
				JasperViewer.viewReport(jasperPrint, false);
			}else{
				
				do{
					
						number++;
						documentName = "data/documents/report document-" + number + ".pdf";
						pdfName = new File(documentName);
			
				}
				while(pdfName.exists());
				JasperExportManager.exportReportToPdfFile(jasperPrint, documentName );
			}
			
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
