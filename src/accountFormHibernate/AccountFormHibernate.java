package accountFormHibernate;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.hibernate.query.Query;

import accountForm.Utilities;

public class AccountFormHibernate extends JFrame {
	
		private JPanel contentPane, panel;
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
		private JButton btnOpenFile;
		private JTextField textFieldSignature1;
		private JTextField textFieldSignature2;
		private JTextField textFieldSignatureVerification;
		private JTextField textFieldTreatedBy1;
		private JTextField textFieldTreatedBy2;
		
		private File signatureFile1, signatureFile2;
		private JTable table;
		private JFileChooser fc;
		protected boolean update = false;
		private int updateID = -1;
		private final double FILESIZE = 64;
		private static HibernateUtilities hibernate = null;
		
		BufferedImage imageSignature1, imageSignature2;
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
				        // Set System L&F
				        UIManager.setLookAndFeel(
				                UIManager.getSystemLookAndFeelClassName());
				    } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
				        System.out.println(ex.getMessage());
				    }
					try {
						AccountFormHibernate frame = new AccountFormHibernate();
						frame.setVisible(true);
						//frame.pack();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						/*if(hibernate != null){
							hibernate.getSessionFactory().close();
						}*/
						
					}
				}
			});
		}
	
		/**
		 * Create the frame.
		 */
		public AccountFormHibernate() {
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowOpened(WindowEvent e) {
					try {
						loadRecords();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			//pack();
			hibernate = new HibernateUtilities();
			setTitle("GAPS-lite - Single User Registration Form");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 710, 789);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			panel = new JPanel();
			panel.setBorder(null);
			panel.setBackground(Color.WHITE);
			JScrollPane scrollPane = new JScrollPane(panel);
			scrollPane.setAutoscrolls(true);
			//contentPane.add(scrollPane, BorderLayout.CENTER);
			
			GroupLayout layout = new GroupLayout(panel);
			panel.setLayout(layout);
			
			JPanel panel_1 = new JPanel();
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			
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
			JLabel lblSDate1 = new JLabel("Date");
			JLabel lblSignature2 = new JLabel("Signature");
			JLabel lblForOfficialUse = new JLabel("    For Official Use");
			lblForOfficialUse.setFont(new Font("Tahoma", Font.BOLD, 12));
			JLabel lblSignatureVerification = new JLabel("Signature Verification");
			JLabel lblTokenIDStattus = new JLabel("Token ID Status:");
			JLabel lblTreatedBy1 = new JLabel("Treated by:");
			JLabel lblTreatedBy2 = new JLabel("Treated by:");
			JLabel lblSvStamp = new JLabel("SV Stamp/Name");
			JLabel lblCISOfficer = new JLabel("CIS Officer (Name/Signature)");
			JLabel lblTSGOfficer = new JLabel("TSG Officer (Name/Signature)");
			
			
			//new
			JLabel lblSignature = new JLabel("Signature");
			
			textFieldDay = new JTextField(2);
			textFieldMonth = new JTextField(3);
			textFieldYear = new JTextField(4);
			textFieldCompanyName = new JTextField();
			textFieldOfficeTelephone = new JTextField(20);
			textFieldWebAddress = new JTextField(20);
			textFieldAccountNumber = new JTextField(15);
			textFieldRMTemailAddress = new JTextField(20);
			textFieldName1 = new JTextField();
			textFieldName1.setColumns(10);
			textFieldName2 = new JTextField();
			textFieldName2.setColumns(10);
			
			fc = new JFileChooser();
			fc.setAcceptAllFileFilterUsed(false);
			fc.addChoosableFileFilter(new FileNameExtensionFilter("Image Files Only","jpg", "jpeg", "png"));
			
			
			signatureFile1 = null;
			signatureFile2 = null;   
			
			
			imageSignature1 = null;
			imageSignature2 = null;
			
			
			
			btnOpenFile = new JButton("Select From File");
			btnOpenFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int value = fc.showOpenDialog(panel);
					if(value == JFileChooser.APPROVE_OPTION){
						signatureFile1 = fc.getSelectedFile();
						if ((signatureFile1.length()/1024) > FILESIZE){
							JOptionPane.showMessageDialog(panel, "Please select an image less than 64kb",
									"Image File too large", JOptionPane.ERROR_MESSAGE);
							return;
						}
						try {
							imageSignature1 = ImageIO.read(signatureFile1);
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						textFieldSignature1.setText(signatureFile1.getPath());
					}
					
				}
			});
			
			
			JButton btnOpenFile2 = new JButton("Select From File");   //new Addition
			btnOpenFile2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int returnValue = fc.showOpenDialog(panel);
					if(returnValue == JFileChooser.APPROVE_OPTION){
						signatureFile2 = fc.getSelectedFile();
						if ((signatureFile2.length()/1024) > FILESIZE){
							JOptionPane.showMessageDialog(panel, "Please select an image less than 64kb",
									"Image File too large", JOptionPane.ERROR_MESSAGE);
							return;
						}
						try {
							imageSignature2 = ImageIO.read(signatureFile2);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						textFieldSignature2.setText(signatureFile2.getPath());
					}
				}
			});
			
			JPanel panel1 = new JPanel();
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
			
			JButton btnViewImage1 = new JButton("View Image");	
			btnViewImage1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(imageSignature1 == null){
						JOptionPane.showMessageDialog(panel, "Please select an Image File", "No image file selected", JOptionPane.ERROR_MESSAGE);
						return;
					}else{
						new DisplayImage(panel1, imageSignature1);
					}
				}
			});
			
			JButton btnViewImage2 = new JButton("View Image");
			btnViewImage2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(imageSignature2 == null){
						JOptionPane.showMessageDialog(panel, "Please select an Image File", "No image file selected", JOptionPane.ERROR_MESSAGE);
						return;
					}else{
						new DisplayImage(panel1, imageSignature2);
					}
				}
			});
			
			textFieldSignature1 = new JTextField();
			textFieldSignature1.setColumns(10);
			textFieldSignature1.setBackground(Color.WHITE);
			textFieldSignature1.setEditable(false);
			
			textFieldSignature2 = new JTextField();
			textFieldSignature2.setBackground(Color.WHITE);
			textFieldSignature2.setEditable(false);
			textFieldSignature2.setColumns(10);
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
													.addComponent(lblSignature)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(btnOpenFile)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(layout.createParallelGroup(Alignment.LEADING)
															.addComponent(textFieldSignature1)
															.addComponent(btnViewImage1))
													//.addComponent(textFieldSignature)
													/*.addComponent(lblSDate1)
													.addPreferredGap(ComponentPlacement.RELATED)
													*/
													)	
											.addGroup(layout.createSequentialGroup()
													.addComponent(lblName2)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textFieldName2)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(lblSignature2)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(btnOpenFile2)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(layout.createParallelGroup(Alignment.LEADING)
															.addComponent(textFieldSignature2)
															.addComponent(btnViewImage2))
													
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
							.addComponent(lblSignature)
							.addComponent(btnOpenFile)
							.addComponent(textFieldSignature1)										
							)
					//.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnViewImage1)
					//.addGap(12)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblName2)
							.addComponent(textFieldName2)
							.addComponent(lblSignature2)
							.addComponent(btnOpenFile2)
							.addComponent(textFieldSignature2))
					.addComponent(btnViewImage2)
					//.addPreferredGap(ComponentPlacement.UNRELATED)
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
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("Add Details", scrollPane);
			contentPane.add(tabbedPane, BorderLayout.CENTER);
			
		
			/*panel_1.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					try {
						loadRecords();
						System.out.println("Focus Gained");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});*/
			tabbedPane.addTab("View Table", null, panel_1, null);
			
			
			table = new JTable();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setBackground(Color.WHITE);
			
			JScrollPane scrollPane_1 = new JScrollPane(table);
			scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			table.setFillsViewportHeight(true);
			scrollPane_1.setBackground(Color.WHITE);
			
			JButton btnAddNew = new JButton("ADD NEW");
			btnAddNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clearFields();
					JOptionPane.showMessageDialog(panel_1, "Switching to New tab..." , "Information Message",
							JOptionPane.INFORMATION_MESSAGE);
					tabbedPane.setSelectedIndex(0);
				}
			});
			
			JButton btnUpdate = new JButton("UPDATE");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table.getSelectedRow() < 0){
						JOptionPane.showMessageDialog(panel_1, "Please select a row to update", "No row selected",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					JOptionPane.showMessageDialog(panel_1, "Switching to editing tab..." , "Information Message",
							JOptionPane.INFORMATION_MESSAGE);
					update  = true;
					updateID = (Integer)table.getValueAt(table.getSelectedRow(), 0);
					System.out.println("UpdateId = " + updateID);
					tabbedPane.setSelectedIndex(0);
					
					
				}
			});
			
			JButton btnDelete = new JButton("DELETE");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table.getSelectedRow() < 0){
						JOptionPane.showMessageDialog(panel_1, "Please select a row in the table" , "No row selected",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					int dialogResult = JOptionPane.showConfirmDialog(panel_1, "Are you sure you want to delete this record?",
							"Confirm Delete Record?", JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
						//delete();
						//delete = true;
						try {
							delete((Integer)table.getValueAt(table.getSelectedRow(), 0));
							
							loadRecords();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					
				}
			});
			
			JButton btnRefresh = new JButton("REFRESH");
			btnRefresh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						System.out.println("Refresh");
						loadRecords();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			
		//	fc.showOpenDialog(panel);
			
			
			//scrollPane_1.setViewportView(table);
			
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(50)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 597, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(64)
								.addComponent(btnAddNew)
								.addGap(18)
								.addComponent(btnUpdate)
								.addGap(18)
								.addComponent(btnDelete)
								.addGap(18)
								.addComponent(btnRefresh)
								.addPreferredGap(ComponentPlacement.RELATED)
								))
						.addContainerGap(32, Short.MAX_VALUE))
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(5)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAddNew)
							.addComponent(btnUpdate)
							.addComponent(btnDelete)
							.addComponent(btnRefresh)
							)
						.addContainerGap(300, Short.MAX_VALUE))
			);
			panel_1.setLayout(gl_panel_1);
			
			
	}
		protected void delete(Integer valueAt) {
			// TODO Auto-generated method stub
			hibernate.startNewSession();
			hibernate.beginTransaction();
			AccountHolder dyingPerson = hibernate.getSession().get(AccountHolder.class, valueAt);
			System.out.println(dyingPerson);
			hibernate.getSession().delete(dyingPerson);
			hibernate.getTransaction().commit();
			hibernate.getSession().close();
			
		}
		protected String[] columnNames = {"ID", "Date", "Company Name", "Office Telephone", "Web Address", "Account Number",
				"RMT Email Address", "All Accounts", "Select Accounts", "ChequeConfirmation", "NIBBS", "Standing Instructions"
				, "Custom Duty", "Name1", "Signature1", "Name2", "Signature2", "Signature Verification", "New", "Existing",
				"Treated By1", "Treated By2"};
		
		private void loadRecords(){
			String hql1 = " from AccountHolder";
			MyTableModel tableModel = new MyTableModel(columnNames, hql1);
			table.setModel(tableModel);
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
				@Override
				public void valueChanged(ListSelectionEvent e){
					clearFields();
					if(table.getSelectedRow() >= 0){
						ArrayList<Object> list = new ArrayList<Object>();
						for(int i = 0; i < 22; i++){
							Object obj = table.getValueAt(table.getSelectedRow(), i);
							list.add(obj);
						}
						
						int	ID = Integer.parseInt(list.get(0).toString());
						String date = list.get(1).toString();
						 String data[] = date.split("-");
						 if(data.length != 3){
							 	//System.out.println("Error in date formatting, I think");
						 }else{
							textFieldYear.setText(data[0]);
						 	textFieldMonth.setText(data[1]);
						 	textFieldDay.setText(data[2]);
						 }				 
						 if(list.get(2) != null){
							 textFieldCompanyName.setText(list.get(2).toString());
						 }
						// System.out.println(textFieldCompanyName.getText());
						 if(list.get(4) != null){
							 textFieldWebAddress.setText(list.get(4).toString());
						 //System.out.println(textFieldWebAddress.getText());
						 }
						 if(list.get(3) != null){
							 textFieldOfficeTelephone.setText(list.get(3).toString());
						 //System.out.println(textFieldOfficeTelephone.getText());
						 }
						 if(list.get(5) != null){
							 textFieldAccountNumber.setText(list.get(5).toString());
						 //System.out.println(textFieldWebAddress.getText());
						 }
						 if(list.get(6) != null){
							 textFieldRMTemailAddress.setText(list.get(6).toString());
						 }
						 if(list.get(13) != null){
							 textFieldName1.setText(list.get(13).toString());
						 }
						 if(list.get(14) != null){
							 textFieldSignature1.setText("Click below to view");
							try {
								Blob imageBlob =  null;	
								
								String source = "data//image" + ID +"-1.jpg";
								File image = new File(source);
								
								if(image.exists()){
									imageSignature1 = ImageIO.read(image);
									signatureFile1 = new File(source);
								}else{
									String hql = "FROM AccountHolder WHERE ID=" + ID;
									hibernate.startNewSession();
									Query query =	hibernate.getSession().createQuery(hql);
									hibernate.getSession().close();
									AccountHolder person = (AccountHolder) query.uniqueResult();
									imageBlob = person.getSignature1();
								/*if(imageBlob == null){
									System.out.println("Blob is null");
								}
								*/
								byte b[] = imageBlob.getBytes(1, (int)imageBlob.length());
								
								imageSignature1 = ImageIO.read(new ByteArrayInputStream(b));
								signatureFile1 = new File(source);
								
					            FileOutputStream fos=new FileOutputStream(signatureFile1);
					            fos.write(b);
					            fos.close();
								}
								
								if(imageSignature1 == null){
									System.out.println("Signature1 is null");
								}
								
							} catch (SQLException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						 }
						 if(list.get(15) != null){
							 textFieldName2.setText(list.get(15).toString());
						 }
						 if(list.get(16) != null){
							 //textFieldSignature2.setText(list.get(16).toString());
							 textFieldSignature2.setText("Click below to view");
							 try {
									Blob imageBlob =  null;	
									
									String source = "data//image" + ID +"-2.jpg";
									File image = new File(source);
									if(image.exists()){
										imageSignature2 = ImageIO.read(image);
										signatureFile2 = new File(source);
									}else{
										String hql = " SELECT Signature2 FROM AccountHolder WHERE ID=" + ID;
										hibernate.startNewSession();
										Query query =	hibernate.getSession().createQuery(hql);
										hibernate.getSession().close();
										AccountHolder person = (AccountHolder)query.uniqueResult();
										imageBlob = person.getSignature2();
										/*if(imageBlob == null){
											System.out.println("Blob is null");
											}
										*/
										byte b[] = imageBlob.getBytes(1, (int)imageBlob.length());
									
										imageSignature2 = ImageIO.read(new ByteArrayInputStream(b));
										
										signatureFile2 = new File(source);
										FileOutputStream fos=new FileOutputStream(signatureFile2);
										fos.write(b);
										fos.close();
									}
									
									if(imageSignature2 == null){
										System.out.println("Signature2 is null");
									}
									
								} catch (SQLException | IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							
						 }
						 if(list.get(20) != null){
							 textFieldTreatedBy1.setText(list.get(20).toString());
						 }
						 if(list.get(21) != null){
							 textFieldTreatedBy2.setText(list.get(21).toString());
						 }
						 if(list.get(17) != null){
							 textFieldSignatureVerification.setText(list.get(17).toString());
						 }
						 if(list.get(7) != null){
							 if(list.get(7).toString().equals("Y")){
							 	chckbxAllAccounts.setSelected(true); 
						 	}
						 }
						 if(list.get(8) != null){
							 if(list.get(8).toString().equals("Y")){
							 	chckbxSelectAccount.setSelected(true); 
						 	}
						 }
						 if(list.get(9) != null){
							 if(list.get(9).toString().equals("Y")){
							 	chckbxChequeConfirmation.setSelected(true); 
						 	}
						 }
						 if(list.get(10) != null){
							 if(list.get(10).toString().equals("Y")){
							 	chckbxNIBBS.setSelected(true); 
						 	}
						 }
						 if(list.get(19) != null){
							 if(list.get(19).toString().equals("Y")){
								 chckbxExisting.setSelected(true); 
						 	}
						 }
						 if(list.get(18) != null){
							 if(list.get(18).toString().equals("Y")){
						 
								 chckbxNew.setSelected(true); 
							 }
						 }
						 if(list.get(12) != null){	
							 if(list.get(12).toString().equals("Y")){
							 	chckbxCustomDuty.setSelected(true); 
						 	}
						 }
						 if(list.get(11) != null){
							 if(list.get(11).toString().equals("Y")){
								 chckbxStandingInstructions.setSelected(true); 
							 }
						 }
						 
					}
				}
			});
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	        rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
	        table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
			
		}

		private void uploadData() {
			// TODO Auto-generated method stub
			AccountHolder person =  initializeAccountHolder(new AccountHolder());
			if(person == null){
				return;
			}
			if(hibernate != null){
				hibernate.startNewSession();
				hibernate.beginTransaction();
				String message;
				if(update){
					update = false;
					hibernate.getSession().update(person);
					System.out.println(person);
					message = "Database Updated";
				}else{
					hibernate.getSession().save(person);
					message = "New Data Added to Database.";
					System.out.println(person);
				}
				JOptionPane.showMessageDialog(panel, message);
				hibernate.getTransaction().commit();
				hibernate.getSession().close();
				clearFields();
			}else{
				System.out.println("Hibernate is NULL");
			}
		
		
			
		}
		private	void clearFields(){	
			textFieldYear.setText("");
			textFieldMonth.setText("");
			textFieldCompanyName.setText("");
			textFieldDay.setText("");
			textFieldWebAddress.setText("");
			textFieldOfficeTelephone.setText("");
			textFieldAccountNumber.setText("");
			textFieldRMTemailAddress.setText("");
			textFieldName1.setText("");	
			textFieldSignature1.setText("");
			imageSignature1 = null;
			textFieldName2.setText("");
			textFieldSignature2.setText("");
			imageSignature2 = null;
			textFieldTreatedBy1.setText("");
			textFieldTreatedBy2.setText("");
			textFieldSignatureVerification.setText("");
			chckbxAllAccounts.setSelected(false);
			chckbxChequeConfirmation.setSelected(false);
			chckbxCustomDuty.setSelected(false);
			chckbxExisting.setSelected(false);
			chckbxNew.setSelected(false);
			chckbxNIBBS.setSelected(false);
			chckbxSelectAccount.setSelected(false);
			chckbxStandingInstructions.setSelected(false);
			
		}
		private AccountHolder initializeAccountHolder(AccountHolder person){
			if(textFieldDay.getText().equals("") || textFieldMonth.getText().equals("") || textFieldYear.getText().equals("")){
				person.setDate(null);
			}
			else if(!(textFieldDay.getText().matches("[0-9]+")) || !(textFieldMonth.getText().matches("[0-9]+")) || !(textFieldYear.getText().matches("[0-9]+"))){
				JOptionPane.showMessageDialog(panel, "Please input only numeric values in date fields", "Error", JOptionPane.ERROR_MESSAGE );
				textFieldDay.setText("");
				textFieldMonth.setText("");
				textFieldYear.setText("");
				return null;
			}else{
				int year, month, day;				
				year = Integer.parseInt(textFieldYear.getText());		
				month = Integer.parseInt(textFieldMonth.getText());
				day = Integer.parseInt(textFieldDay.getText());
				person.setDate(year, month, day);
			}
			person.setCompanyName(textFieldCompanyName.getText());			
			person.setWebAddress(textFieldWebAddress.getText());			
			person.setOfficeTelephone(textFieldOfficeTelephone.getText());
			person.setRmtEmailAddress(textFieldRMTemailAddress.getText());		
			person.setAccountNumber(textFieldAccountNumber.getText());		
			if(chckbxAllAccounts.isSelected()){
				person.setAllAccounts('Y');
			}
			if(chckbxSelectAccount.isSelected()){
				person.setSelectAccounts('Y');
			}
			if(chckbxChequeConfirmation.isSelected()){
				person.setChequeConfirmation('Y');
			}
			if(chckbxNIBBS.isSelected()){
				person.setNibbs('Y');
			}
			if(chckbxStandingInstructions.isSelected()){
				person.setStandingInstructions('Y');
			}
			if(chckbxCustomDuty.isSelected()){
				person.setCustomDuty('Y');
			}
			person.setName1(textFieldName1.getText());
			person.setName2(textFieldName2.getText());
			person.setSignatureVerification(textFieldSignatureVerification.getText());
			person.setTreatedBy1(textFieldTreatedBy1.getText());
			person.setTreatedBy2(textFieldTreatedBy2.getText());				
			if(chckbxNew.isSelected()){
				person.setNew('Y');
			}
			if(chckbxExisting.isSelected()){
				person.setExisting('Y');
			}
			
			return person;
		}
}
	
