package work2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.sql.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Work2 extends JFrame {

	private JPanel contentPane;
	JTextField textFieldCompanyName;
	private JTextField textFieldOfficeTel;
	private JTextField textFieldWebAddress;
	private JTextField textFieldAccountNumber;
	private JTextField textFieldRMTemail;
	private JTextField textFieldName1;
	private JTextField textFieldName2;
	private JTextField textFieldSignatureDate1;
	private JTextField textFieldSignatureDate2;
	private JTextField textFieldSignatureVerification;
	private JTextField textFieldTreatedBy1;
	private JTextField textFieldTreatedBy2;
	private JTextField textFieldDay;
	private JTextField textFieldMonth;
	private JTextField textFieldYear;
	private JDBC connect;
	JCheckBox chckbxAllAccounts;
	JCheckBox chckbxSelectAccount;
	JCheckBox chckbxChequeConfirmation;
	JCheckBox chckbxNibbsInstantPayment;
	JCheckBox chckbxStandingInstruction;
	JCheckBox chckbxCustomDuty;
	JCheckBox chckbxNew;
	JCheckBox chckbxExisting;
	
	
	/**
	 * Launch the application.
	 */
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Work2 frame = new Work2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Work2() {
		setTitle("GAPS-lite - Single User Registration Form");
		connect = new JDBC();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		//setBounds(100, 100, 700, 600);
		setBounds(100, 100, 728, 836);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
	//	JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
	//	scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(10, 11, 379, 44);
		panel.add(panel2);
		JLabel gaps = new JLabel("   GAPS-lite - Single User Registration Form                 ");
		gaps.setFont(new Font("Tahoma", Font.BOLD, 14));
		gaps.setForeground(Color.WHITE);
		panel2.setBackground(Color.BLACK);
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		panel2.add(gaps);
		JLabel companyName = new JLabel("Company Name:");
		companyName.setBounds(26, 113, 103, 22);
		panel.add(companyName);
		textFieldCompanyName = new JTextField(40);
		textFieldCompanyName.setBounds(128, 113, 520, 22);
		panel.add(textFieldCompanyName);
		
		JLabel lblOfficeTelephone = new JLabel("Office Telephone:");
		lblOfficeTelephone.setBounds(26, 151, 103, 14);
		panel.add(lblOfficeTelephone);
		
		textFieldOfficeTel = new JTextField(40);
		textFieldOfficeTel.setBounds(129, 147, 121, 22);
		panel.add(textFieldOfficeTel);
		
		JLabel lblWebAddress = new JLabel("Web Address:");
		lblWebAddress.setBounds(261, 151, 103, 14);
		panel.add(lblWebAddress);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.BLACK);
		panel1.setBounds(10, 193, 161, 38);
		
		textFieldWebAddress = new JTextField();
		textFieldWebAddress.setBounds(365, 147, 283, 20);
		panel.add(textFieldWebAddress);
		textFieldWebAddress.setColumns(10);
		panel.add(panel1);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		
		JLabel lblAccountInformation = new JLabel("   Account Information");
		lblAccountInformation.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel1.add(lblAccountInformation);
		lblAccountInformation.setForeground(Color.WHITE);
		
		JLabel lblAccountNo = new JLabel("Account No.:");
		lblAccountNo.setBounds(22, 242, 83, 14);
		panel.add(lblAccountNo);
		
		textFieldAccountNumber = new JTextField();
		textFieldAccountNumber.setBounds(111, 239, 92, 20);
		panel.add(textFieldAccountNumber);
		textFieldAccountNumber.setColumns(10);
		
		JLabel lblRelationshipMgtTeam = new JLabel("Relationship Mgt. Team e-mail address:");
		lblRelationshipMgtTeam.setBounds(213, 242, 234, 14);
		panel.add(lblRelationshipMgtTeam);
		
		textFieldRMTemail = new JTextField();
		textFieldRMTemail.setBounds(444, 239, 200, 20);
		panel.add(textFieldRMTemail);
		textFieldRMTemail.setColumns(10);
		
		chckbxSelectAccount = new JCheckBox("Select Account");
		chckbxSelectAccount.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxSelectAccount.setBackground(Color.WHITE);
		chckbxSelectAccount.setBounds(311, 263, 121, 23);
		panel.add(chckbxSelectAccount);
		
		JLabel lbllistAccountsOr = new JLabel("(List accounts or related account(s) and companies to be activated for single profile user below)");
		lbllistAccountsOr.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbllistAccountsOr.setBounds(311, 282, 367, 14);
		panel.add(lbllistAccountsOr);
		
		chckbxAllAccounts = new JCheckBox("All Accounts");
		chckbxAllAccounts.setBackground(Color.WHITE);
		chckbxAllAccounts.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxAllAccounts.setBounds(213, 263, 92, 23);
		panel.add(chckbxAllAccounts);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.BLACK);
		panel3.setBounds(10, 312, 161, 38);
		panel.add(panel3);
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		
		JLabel lblOtherServices = new JLabel("   Other Services");
		lblOtherServices.setForeground(Color.WHITE);
		lblOtherServices.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel3.add(lblOtherServices);
		
		//JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(0, 0, 2, 2);
		//contentPane.add(scrollPane);
		
		chckbxChequeConfirmation = new JCheckBox("Cheque Confirmation");
		chckbxChequeConfirmation.setBackground(Color.WHITE);
		chckbxChequeConfirmation.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxChequeConfirmation.setBounds(26, 357, 144, 23);
		panel.add(chckbxChequeConfirmation);
		
		chckbxNibbsInstantPayment = new JCheckBox("NIBBS Instant payment to other Banks");
		chckbxNibbsInstantPayment.setBackground(Color.WHITE);
		chckbxNibbsInstantPayment.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxNibbsInstantPayment.setBounds(177, 358, 237, 23);
		panel.add(chckbxNibbsInstantPayment);
		
		chckbxStandingInstruction = new JCheckBox("Standing Instruction");
		chckbxStandingInstruction.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxStandingInstruction.setBackground(Color.WHITE);
		chckbxStandingInstruction.setBounds(426, 358, 137, 23);
		panel.add(chckbxStandingInstruction);
		
		chckbxCustomDuty = new JCheckBox("Custom Duty");
		chckbxCustomDuty.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxCustomDuty.setBackground(Color.WHITE);
		chckbxCustomDuty.setBounds(566, 358, 97, 23);
		panel.add(chckbxCustomDuty);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(9, 407, 161, 38);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblApprovalInformation = new JLabel("   Approval Information");
		lblApprovalInformation.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApprovalInformation.setForeground(Color.WHITE);
		panel_1.add(lblApprovalInformation);
		
		JTextArea txtrPleaseNoteThat = new JTextArea();
		txtrPleaseNoteThat.setEditable(false);
		txtrPleaseNoteThat.setBorder(null);
		txtrPleaseNoteThat.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtrPleaseNoteThat.setLineWrap(true);
		txtrPleaseNoteThat.setText("Please note that all approvers are set up in accordance with the Bank's mandate. Non-signatories to the account(s) shall not be set up as approver(s) until the board resolution authorizing such persons to act in that capacity is submitted to the bank. ");
		txtrPleaseNoteThat.setRows(2);
		txtrPleaseNoteThat.setBounds(26, 456, 622, 28);
		panel.add(txtrPleaseNoteThat);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(26, 501, 46, 14);
		panel.add(lblName);
		
		textFieldName1 = new JTextField();
		textFieldName1.setBounds(82, 498, 234, 20);
		panel.add(textFieldName1);
		textFieldName1.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(26, 534, 46, 14);
		panel.add(lblName_1);
		
		textFieldName2 = new JTextField();
		textFieldName2.setBounds(80, 531, 236, 20);
		panel.add(textFieldName2);
		textFieldName2.setColumns(10);
		
		JLabel lblSignatureDate = new JLabel("Signature & Date");
		lblSignatureDate.setBounds(326, 501, 103, 14);
		panel.add(lblSignatureDate);
		
		JLabel lblSignatureDate_1 = new JLabel("Signature & Date");
		lblSignatureDate_1.setBounds(324, 534, 97, 14);
		panel.add(lblSignatureDate_1);
		
		textFieldSignatureDate1 = new JTextField();
		textFieldSignatureDate1.setBounds(426, 498, 222, 20);
		panel.add(textFieldSignatureDate1);
		textFieldSignatureDate1.setColumns(10);
		
		textFieldSignatureDate2 = new JTextField();
		textFieldSignatureDate2.setBounds(426, 531, 222, 20);
		panel.add(textFieldSignatureDate2);
		textFieldSignatureDate2.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(10, 562, 161, 38);
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JLabel lblForOfficialUse = new JLabel("   For Official Use");
		lblForOfficialUse.setForeground(Color.WHITE);
		lblForOfficialUse.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(lblForOfficialUse);
		
		JLabel lblSignatureVerification = new JLabel("Signature Verification:");
		lblSignatureVerification.setBounds(26, 611, 145, 14);
		panel.add(lblSignatureVerification);
		
		textFieldSignatureVerification = new JTextField();
		textFieldSignatureVerification.setBounds(149, 608, 167, 20);
		panel.add(textFieldSignatureVerification);
		textFieldSignatureVerification.setColumns(10);
		
		JLabel lblTokenIdStatus = new JLabel("Token ID Status:");
		lblTokenIdStatus.setBounds(344, 611, 92, 14);
		panel.add(lblTokenIdStatus);
		
		chckbxNew = new JCheckBox("New");
		chckbxNew.setBackground(Color.WHITE);
		chckbxNew.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxNew.setBounds(448, 607, 55, 23);
		panel.add(chckbxNew);
		
		chckbxExisting = new JCheckBox("Existing");
		chckbxExisting.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxExisting.setBackground(Color.WHITE);
		chckbxExisting.setBounds(532, 607, 97, 23);
		panel.add(chckbxExisting);
		
		JLabel lblSvStamoname = new JLabel("SV Stamp/Name");
		lblSvStamoname.setBounds(177, 628, 103, 14);
		panel.add(lblSvStamoname);
		
		JLabel lblTreatedBy = new JLabel("Treated by");
		lblTreatedBy.setBounds(26, 649, 83, 14);
		panel.add(lblTreatedBy);
		
		textFieldTreatedBy1 = new JTextField();
		textFieldTreatedBy1.setBounds(99, 646, 217, 20);
		panel.add(textFieldTreatedBy1);
		textFieldTreatedBy1.setColumns(10);
		
		JLabel lblCisOfficernamesignature = new JLabel("CIS Officer (Name/Signature)");
		lblCisOfficernamesignature.setBounds(149, 668, 167, 14);
		panel.add(lblCisOfficernamesignature);
		
		JLabel label = new JLabel("Treated by");
		label.setBounds(344, 649, 83, 14);
		panel.add(label);
		
		textFieldTreatedBy2 = new JTextField();
		textFieldTreatedBy2.setColumns(10);
		textFieldTreatedBy2.setBounds(426, 646, 222, 20);
		panel.add(textFieldTreatedBy2);
		
		JLabel lblTsgOfficernamesignature = new JLabel("TSG Officer (Name/Signature)");
		lblTsgOfficernamesignature.setBounds(462, 668, 167, 14);
		panel.add(lblTsgOfficernamesignature);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(26, 77, 46, 14);
		panel.add(lblDate);
		
		textFieldDay = new JTextField(2);
		textFieldDay.setBounds(64, 74, 35, 20);
		panel.add(textFieldDay);
		textFieldDay.setColumns(10);
		
		textFieldMonth = new JTextField(2);
		textFieldMonth.setBounds(106, 74, 35, 20);
		panel.add(textFieldMonth);
		textFieldMonth.setColumns(10);
		
		textFieldYear = new JTextField(4);
		textFieldYear.setBounds(149, 74, 86, 20);
		panel.add(textFieldYear);
		textFieldYear.setColumns(10);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(70, 93, 46, 14);
		panel.add(lblDay);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(180, 93, 46, 14);
		panel.add(lblYear);
		
		JLabel lblAccountsubAccountsTo = new JLabel("Account/Sub Accounts to be profiled:");
		panel.add(lblAccountsubAccountsTo);
		lblAccountsubAccountsTo.setBounds(22, 267, 181, 14);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(111, 93, 46, 14);
		panel.add(lblMonth);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uploadData();
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 12));
		btnNewButton.setBounds(532, 697, 89, 23);
		panel.add(btnNewButton);
		
		panel.setVisible(true);
		
	}
	
	private void uploadData(){
		int year, month, day;
		year = Integer.parseInt(textFieldYear.getText());
		textFieldYear.setText("");
		month = Integer.parseInt(textFieldMonth.getText());
		textFieldMonth.setText("");
		day = Integer.parseInt(textFieldDay.getText());
		textFieldDay.setText("");
		String companyName, webAddress, officeTelephone, date;
		companyName = textFieldCompanyName.getText();
		textFieldCompanyName.setText("");
		webAddress = textFieldWebAddress.getText();
		textFieldWebAddress.setText("");
		officeTelephone = textFieldOfficeTel.getText();
		textFieldOfficeTel.setText("");
		date = year + "-" + month + "-" + day;
		System.out.println(companyName + " " + webAddress + " " + " " + 
		 officeTelephone + " " + date);
		
		String RMTemail, accountNumber;
		char allAccounts = 'N', selectAccount = 'N', chequeConfirmation = 'N';
		char nibbsInstantPayment = 'N', standingInstructions = 'N', customDuty = 'N';
		RMTemail = textFieldRMTemail.getText();
		textFieldRMTemail.setText("");
		accountNumber = textFieldAccountNumber.getText();
		textFieldAccountNumber.setText("");
		if(chckbxAllAccounts.isSelected()){
			allAccounts = 'Y';
			chckbxAllAccounts.setSelected(false);
		}
		if(chckbxSelectAccount.isSelected()){
			selectAccount = 'Y';
			chckbxSelectAccount.setSelected(false);
		}
		if(chckbxChequeConfirmation.isSelected()){
			chequeConfirmation = 'Y';
			chckbxChequeConfirmation.setSelected(false);
		}
		if(chckbxNibbsInstantPayment.isSelected()){
			nibbsInstantPayment = 'Y';
			chckbxNibbsInstantPayment.setSelected(false);
		}
		if(chckbxStandingInstruction.isSelected()){
			standingInstructions = 'Y';
			chckbxStandingInstruction.setSelected(false);
		}
		if(chckbxCustomDuty.isSelected()){
			customDuty = 'Y';
			chckbxCustomDuty.setSelected(false);
		}
		String name1, name2, signatureDate1, signatureDate2;
		name1 = textFieldName1.getText();
		textFieldName1.setText("");	
		name2 = textFieldName2.getText();
		textFieldName2.setText("");
		signatureDate1 = textFieldSignatureDate1.getText();
		textFieldSignatureDate1.setText("");
		signatureDate2 = textFieldSignatureDate2.getText();
		textFieldSignatureDate2.setText("");
		
		String signatureVerification, treatedBy1, treatedBy2;
		signatureVerification = textFieldSignatureVerification.getText();
		textFieldSignatureVerification.setText("");
		treatedBy1 = textFieldTreatedBy1.getText();
		textFieldTreatedBy1.setText("");
		treatedBy2 = textFieldTreatedBy2.getText();
		textFieldTreatedBy2.setText("");
		
				
		char New = 'N', Existing = 'N';
		if(chckbxNew.isSelected()){
			New = 'Y';
			chckbxNew.setSelected(false);
		}
		if(chckbxExisting.isSelected()){
			Existing = 'N';
			chckbxExisting.setSelected(false);
		}
		
		String syntax = "', '";
		String sql = null;;
		sql = "INSERT INTO work_database VALUES('" + date + syntax + companyName 
				+ syntax + officeTelephone + syntax + webAddress + syntax + accountNumber
				+ syntax + RMTemail + syntax + allAccounts + syntax + selectAccount + syntax +
				chequeConfirmation + syntax + nibbsInstantPayment + syntax + standingInstructions +
				syntax + customDuty + syntax + name1 + syntax + signatureDate1 + syntax + name2 + syntax +
				signatureDate2 + syntax + signatureVerification + syntax + New + syntax + Existing + syntax + treatedBy1 +
				syntax + treatedBy2 + "');";
		Statement statem = null;
		try {
			statem = connect.getConnection().createStatement();
			int rows = statem.executeUpdate(sql);
			System.out.println(rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(statem != null){
				try{
					statem.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
}
