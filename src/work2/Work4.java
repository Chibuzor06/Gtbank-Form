package work2;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Work4 extends JFrame {

	private JPanel contentPane;
	private JCheckBox chckbxAllAccounts;
	private JCheckBox chckbxSelectAccount;
	private JCheckBox chckbxChequeConfirmation;
	private JCheckBox chckbxNIBBS;
	private JCheckBox chckbxStandingInstructions;
	private JCheckBox chckbxCustomDuty;
	private JCheckBox chckbxNew;
	private JCheckBox chckbxExisting;
	
	private JTextField textFieldDay;
	private JTextField textFieldMonth;
	private JTextField textFieldYear;
	private JTextField textFieldCompanyName;
	private JTextField textFieldOfficeTelephone;
	private JTextField textFieldWebAddress;
	private JTextField textFieldAccountNumber;
	private JTextField textFieldRMTemailAddress;
	private JTextField textFieldName1;
	private JTextField textFieldName2;
	private JTextField textFieldSignatureDate1;
	private JTextField textFieldSignatureDate2;
	private JTextField textFieldSignatureVerification;
	private JTextField textFieldTreatedBy1;
	private JTextField textFieldTreatedBy2;
	
	private JDBC connect;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Work4 frame = new Work4();
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
	public Work4() {
		setTitle("GAPS-lite - Single User Registration Form");
		connect = new JDBC();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 836);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(panel);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
		JLabel lblDate = new JLabel();
		lblDate.setText("Date");
		JLabel lblDay = new JLabel("Day");
		JLabel lblMonth = new JLabel("Month");
		JLabel lblYear = new JLabel("Year");
		JLabel lblCompanyName = new JLabel("CompanyName");
		JLabel lblOfficeTelephone = new JLabel("Office Telephone:");
		JLabel lblWebAddress = new JLabel("Web Address:");
		JLabel lblGAPSlite = new JLabel("    GAPS-lite - Single User Registration Form");
		lblGAPSlite.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLabel lblAccountInformation = new JLabel("    Account Information");
		lblAccountInformation.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel lblAccountNumber = new JLabel("Account No.:");
		JLabel lblRMTemailAddress = new JLabel("Relationship Mgt. Team e-mail address:");
		JLabel lblAccountsSubAccounts = new JLabel("Accounts/Sub Accounts to be profiled:");
		JLabel lblListAccounts = new JLabel("(List accounts or related account(s) and companies to be activated for single profile user below)");
		lblListAccounts.setFont(new Font("Tahoma", Font.PLAIN, 8));
		JLabel lblOtherServices = new JLabel("    Other Services");
		lblOtherServices.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel lblApprovalInformation = new JLabel("    Approval Information");
		lblApprovalInformation.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel lblName1 = new JLabel("Name:");
		JLabel lblName2 = new JLabel("Name:");
		JLabel lblSignatureDate1 = new JLabel("Signature & Date");
		JLabel lblSignatureDate2 = new JLabel("Signature & Date");
		JLabel lblForOfficialUse = new JLabel("    For Official Use");
		lblForOfficialUse.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel lblSignatureVerification = new JLabel("Signature Verification");
		JLabel lblTokenIDStattus = new JLabel("Token ID Status:");
		JLabel lblTreatedBy1 = new JLabel("Treated by:");
		JLabel lblTreatedBy2 = new JLabel("Treated by:");
		JLabel lblSvStamp = new JLabel("SV Stamp/Name");
		JLabel lblCISOfficer = new JLabel("CIS Officer (Name/Signature)");
		JLabel lblTSGOfficer = new JLabel("TSG Officer (Name/Signature)");
		
		textFieldDay = new JTextField(2);
		textFieldMonth = new JTextField(3);
		textFieldYear = new JTextField(4);
		textFieldCompanyName = new JTextField();
		textFieldOfficeTelephone = new JTextField(20);
		textFieldWebAddress = new JTextField(20);
		textFieldAccountNumber = new JTextField(15);
		textFieldRMTemailAddress = new JTextField(20);
		textFieldName1 = new JTextField();
		textFieldName2 = new JTextField();
		textFieldSignatureDate1 = new JTextField();
		textFieldSignatureDate2 = new JTextField();
		textFieldSignatureVerification = new JTextField();
		textFieldTreatedBy1 = new JTextField();
		textFieldTreatedBy2 = new JTextField();
		
		chckbxAllAccounts = new JCheckBox("All Accounts");
		chckbxAllAccounts.setBackground(Color.WHITE);
		chckbxAllAccounts.setHorizontalTextPosition(SwingConstants.LEADING);
		
				
		chckbxSelectAccount = new JCheckBox("Select Accounts");
		chckbxSelectAccount.setBackground(Color.WHITE);
		chckbxSelectAccount.setHorizontalTextPosition(SwingConstants.LEADING);
		
		chckbxChequeConfirmation = new JCheckBox("Cheque Confirmation");
		chckbxChequeConfirmation.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxChequeConfirmation.setBackground(Color.WHITE);
		
		chckbxNIBBS = new JCheckBox("NIBBS Instant Payment to other Banks");
		chckbxNIBBS.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxNIBBS.setBackground(Color.WHITE);
		
		chckbxStandingInstructions = new JCheckBox("Standing Instructions");
		chckbxStandingInstructions.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxStandingInstructions.setBackground(Color.WHITE);
		
		chckbxCustomDuty = new JCheckBox("Custom Duty");
		chckbxCustomDuty.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxCustomDuty.setBackground(Color.WHITE);
		
		chckbxNew = new JCheckBox("New");
		chckbxNew.setBackground(Color.WHITE);
		
		chckbxExisting = new JCheckBox("Existing");
		chckbxExisting.setBackground(Color.WHITE);
		
		JTextArea textArea = new JTextArea(2, 25);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		String text = "Please note that all approvers are set up in accordance with the Bank's mandate. "
				+ "Non-signatories to the account(s) shall not be set-up as approvers until the board resolution authorizing "
				+ "such persons to act in that capacity is submitted to the bank.";
		textArea.setText(text);

		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		
		lblGAPSlite.setForeground(Color.WHITE);
		panel1.setBackground(Color.BLACK);
		panel1.add(lblGAPSlite);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		panel2.setBackground(Color.BLACK);
		lblAccountInformation.setForeground(Color.WHITE);
		panel2.add(lblAccountInformation);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		panel3.setBackground(Color.BLACK);
		lblOtherServices.setForeground(Color.WHITE);
		panel3.add(lblOtherServices);
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
		panel4.setBackground(Color.BLACK);
		lblApprovalInformation.setForeground(Color.WHITE);
		panel4.add(lblApprovalInformation);
		
		JPanel panel5 = new JPanel();
		panel5.setLayout(new BoxLayout(panel5, BoxLayout.X_AXIS));
		panel5.setBackground(Color.BLACK);
		lblForOfficialUse.setForeground(Color.WHITE);
		panel5.add(lblForOfficialUse);
		
		JButton btnSubmitButton = new JButton("SUBMIT");
		btnSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uploadData();
			}
		});
		
		//layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel4, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel5, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
								)						
						.addGroup(layout.createSequentialGroup()
								.addGap(30)
								.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup()
												.addComponent(lblDate)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(textFieldDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addGap(35)
												.addComponent(lblDay)
												.addGap(10)
												.addComponent(lblMonth)
												.addGap(10)
												.addComponent(lblYear))
										.addGroup(layout.createSequentialGroup()
												.addComponent(lblCompanyName)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(textFieldCompanyName))
										.addGroup(layout.createSequentialGroup()
												.addComponent(lblOfficeTelephone)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldOfficeTelephone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblWebAddress)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldWebAddress))
										.addGroup(layout.createSequentialGroup()
												.addComponent(lblAccountNumber)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldAccountNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblRMTemailAddress)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldRMTemailAddress))
										.addGroup(layout.createSequentialGroup()
												.addComponent(lblAccountsSubAccounts)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(chckbxAllAccounts)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addComponent(chckbxSelectAccount)
														.addComponent(lblListAccounts)))
										.addGroup(layout.createSequentialGroup()
												.addComponent(chckbxChequeConfirmation)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(chckbxNIBBS)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(chckbxStandingInstructions)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(chckbxCustomDuty))
										.addComponent(textArea)
										.addGroup(layout.createSequentialGroup()
												.addComponent(lblName1)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldName1)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(lblSignatureDate1)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldSignatureDate1)
												)	
										.addGroup(layout.createSequentialGroup()
												.addComponent(lblName2)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldName2)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(lblSignatureDate2)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldSignatureDate2)
												)	
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(lblSignatureVerification)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(textFieldSignatureVerification))
														.addGroup(layout.createSequentialGroup()
																.addGap(130)
																.addComponent(lblSvStamp))
														.addGroup(layout.createSequentialGroup()
																.addComponent(lblTreatedBy1)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(textFieldTreatedBy1))
														.addGroup(layout.createSequentialGroup()
																.addGap(130)
																.addComponent(lblCISOfficer)))
												.addGap(20)
												.addGroup(layout.createParallelGroup(Alignment.TRAILING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(lblTokenIDStattus)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(chckbxNew)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(chckbxExisting))
														.addGroup(layout.createSequentialGroup()
																.addComponent(lblTreatedBy2)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(textFieldTreatedBy2))
														.addGroup(layout.createSequentialGroup()
																.addGap(130)
																.addComponent(lblTSGOfficer))
														.addComponent(btnSubmitButton)))
										//
						)
				.addContainerGap(40, Short.MAX_VALUE)
				)));
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
				.addGap(30)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDate)
						.addComponent(textFieldDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			//	.addGap(1)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDay)
						.addComponent(lblMonth)
						.addComponent(lblYear))
				.addGap(10)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCompanyName)
						.addComponent(textFieldCompanyName))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOfficeTelephone)
						.addComponent(textFieldOfficeTelephone)
						.addComponent(lblWebAddress)
						.addComponent(textFieldWebAddress))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
				.addGap(20)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccountNumber)
						.addComponent(textFieldAccountNumber)
						.addComponent(lblRMTemailAddress)
						.addComponent(textFieldRMTemailAddress))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccountsSubAccounts)
						.addComponent(chckbxAllAccounts)
						.addGroup(layout.createSequentialGroup()
								.addComponent(chckbxSelectAccount)
								.addComponent(lblListAccounts)))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
				.addGap(20)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxChequeConfirmation)
						.addComponent(chckbxNIBBS)
						.addComponent(chckbxStandingInstructions)
						.addComponent(chckbxCustomDuty))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(panel4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
				.addGap(6)
				.addComponent(textArea)
				.addGap(12)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName1)
						.addComponent(textFieldName1)
						.addComponent(lblSignatureDate1)
						.addComponent(textFieldSignatureDate1))
				.addGap(12)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName2)
						.addComponent(textFieldName2)
						.addComponent(lblSignatureDate2)
						.addComponent(textFieldSignatureDate2))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(panel5, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
				.addGap(12)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSignatureVerification)
						.addComponent(textFieldSignatureVerification)
						.addComponent(lblTokenIDStattus)
						.addComponent(chckbxNew)
						.addComponent(chckbxExisting))
				.addComponent(lblSvStamp)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTreatedBy1)
						.addComponent(textFieldTreatedBy1)
						.addComponent(lblTreatedBy2)
						.addComponent(textFieldTreatedBy2))
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCISOfficer)
						.addComponent(lblTSGOfficer))
				.addGap(10)
				.addComponent(btnSubmitButton)
				.addContainerGap(40, Short.MAX_VALUE));		
	
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
		officeTelephone = textFieldOfficeTelephone.getText();
		textFieldOfficeTelephone.setText("");
		date = year + "-" + month + "-" + day;
		System.out.println(companyName + " " + webAddress + " " + " " + 
		 officeTelephone + " " + date);
		
		String RMTemail, accountNumber;
		char allAccounts = 'N', selectAccount = 'N', chequeConfirmation = 'N';
		char nibbsInstantPayment = 'N', standingInstructions = 'N', customDuty = 'N';
		RMTemail = textFieldRMTemailAddress.getText();
		textFieldRMTemailAddress.setText("");
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
		if(chckbxNIBBS.isSelected()){
			nibbsInstantPayment = 'Y';
			chckbxNIBBS.setSelected(false);
		}
		if(chckbxStandingInstructions.isSelected()){
			standingInstructions = 'Y';
			chckbxStandingInstructions.setSelected(false);
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
