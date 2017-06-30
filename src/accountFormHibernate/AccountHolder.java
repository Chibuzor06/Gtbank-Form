package accountFormHibernate;

import java.sql.Blob;
import java.util.Calendar;
import java.util.Date;

public class AccountHolder {

	private int ID;
	private Calendar date;
	private String companyName;
	private String officeTelephone;
	private String webAddress;
	private String accountNumber;
	private String rmtEmailAddress;
	private char allAccounts;
	private char selectAccounts;
	private char chequeConfirmation;
	private char nibbs;
	private char standingInstructions;
	private char customDuty;
	private String name1;
	private String name2;
	private Blob signature1;
	private Blob signature2;
	private String signatureVerification;
	private char New;
	private char Existing;
	private String treatedBy1;
	private String treatedBy2;
	
	public AccountHolder(){
		date = null;
		//date = Calendar.getInstance();
		companyName = null;
		officeTelephone = null;
		webAddress = null;
		accountNumber = null;
		rmtEmailAddress = null;
		allAccounts = 'N';
		selectAccounts = 'N';
		chequeConfirmation = 'N';
		nibbs = 'N';
		standingInstructions = 'N';
		customDuty = 'N';
		name1 = null;
		name2 = null;
		signature1 = null;
		signature2 = null;
		signatureVerification = null;
		New = 'N';
		Existing = 'N';
		treatedBy1 = null;
		treatedBy2 = null;
		
	}
	public int getID(){
		return ID;
	}
	public void setID(int value){
		ID = value;
	}
	public Calendar getDate(){
		return date;
	}
	public void setDate(int year, int month, int day){
		//date = Calendar.getInstance();
	//	date.set(year, month, day);
		(date = Calendar.getInstance()).set(year, month, day);
	}
	public void setDate(Calendar value){
		date = value;
	}
	public String getCompanyName(){
		return companyName;
	}
	public void setCompanyName(String name){
		companyName = name;
	}
	public String getOfficeTelephone(){
		return officeTelephone;
	}
	public void setOfficeTelephone(String value){
		officeTelephone = value;
	}
	public String getWebAddress(){
		return webAddress;
	}
	public void setWebAddress(String number){
		webAddress = number;
	}
	public String getAccountNumber(){
		return accountNumber;
	}
	public void setAccountNumber(String number){
		accountNumber = number;
	}
	
	public String getRmtEmailAddress(){
		return rmtEmailAddress;
	}
	public void setRmtEmailAddress(String number){
		rmtEmailAddress = number;
	}
	public char getAllAccounts(){
		return allAccounts;
	}
	public void setAllAccounts(char value){
		allAccounts = value;
	}
	public char getSelectAccounts(){
		return selectAccounts;
	}
	public void setSelectAccounts(char value){
		selectAccounts = value;
	}
	public char getChequeConfirmation(){
		return chequeConfirmation;
	}
	public void setChequeConfirmation(char value){
		chequeConfirmation = value;
	}
	public char getNibbs(){
		return nibbs;
	}
	public void setNibbs(char value){
		nibbs = value;
	}
	public char getStandingInstructions(){
		return standingInstructions;
	}
	public void setStandingInstructions(char value){
		standingInstructions = value;
	}
	public char getCustomDuty(){
		return customDuty;
	}
	public void setCustomDuty(char value){
		customDuty = value;
	}
	public String getName1(){
		return name1;
	}
	public void setName1(String number){
		name1 = number;
	}
	public String getName2(){
		return name2;
	}
	public void setName2(String number){
		name2 = number;
	}
	public Blob getSignature1(){
		return signature1;
	}
	public void setSignature1(Blob value){
		signature1 = value;
	}
	public Blob getSignature2(){
		return signature2;
	}
	public void setSignature2(Blob value){
		signature2 = value;
	}
	public String getSignatureVerification(){
		return signatureVerification;
	}
	public void setSignatureVerification(String number){
		signatureVerification = number;
	}
	public char getNew(){
		return New;
	}
	public void setNew(char value){
		New = value;
	}
	public char getExisting(){
		return Existing;
	}
	public void setExisting(char value){
		Existing = value;
	}
	public String getTreatedBy1(){
		return treatedBy1;
	}
	public void setTreatedBy1(String number){
		treatedBy1 = number;
	}
	public String getTreatedBy2(){
		return treatedBy2;
	}
	public void setTreatedBy2(String number){
		treatedBy2 = number;
	}
	
	
	
	
}
