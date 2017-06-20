# Gtbank-Form
Account Opening form, practcing working with mysql

# Work4.java is the current working form

code to create the database table
//old code
CREATE TABLE work_database(Date DATE, Company_Name BLOB, Office_Telephone VARCHAR(15),
Web_Address VARCHAR(50), Account_Number VARCHAR(20), RMT_email VARCHAR(50),
All_Accounts CHAR(1), Select_Account CHAR(1), Cheque_Confirmation CHAR(1),
NIBBS_Instant_Payment CHAR(1), Standing_Instructions CHAR(1), Custom_Duty CHAR(1),
Name1 VARCHAR(40), Signature_Date1 VARCHAR(30), Name2 VARCHAR(40), 
Signature_Date2 VARCHAR(30), Signature_Verification VARCHAR(20), New CHAR(1),
Existing CHAR(1), Treated_by1 VARCHAR(40), Treated_by2 VARCHAR(40)); 

//new create table code
CREATE TABLE work_database(Date DATE, Company_Name VARCHAR(60), Office_Telephone VARCHAR(15),
Web_Address VARCHAR(50), Account_Number VARCHAR(20), RMT_email VARCHAR(50),
All_Accounts CHAR(1), Select_Account CHAR(1), Cheque_Confirmation CHAR(1),
NIBBS_Instant_Payment CHAR(1), Standing_Instructions CHAR(1), Custom_Duty CHAR(1),
Name1 VARCHAR(40), Signature_Date1 VARCHAR(30), Name2 VARCHAR(40), 
Signature_Date2 VARCHAR(30), Signature_Verification VARCHAR(20), New CHAR(1),
Existing CHAR(1), Treated_by1 VARCHAR(40), Treated_by2 VARCHAR(40)); 
