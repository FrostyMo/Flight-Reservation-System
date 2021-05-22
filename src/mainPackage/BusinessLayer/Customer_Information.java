package mainPackage.BusinessLayer;

import java.sql.ResultSet;

import mainPackage.DataLayer.ConnectDB;

public class Customer_Information {
	ConnectDB FRS_DataBase;
	
	Customer_Information(){
		FRS_DataBase = new ConnectDB();
	}
	
	public boolean AddCustomer(String custID, String name,String user, String pass, long cnic, int age, String gender, String address, String joindate, String nation, long phone, long passport) {
		String personID = FindMaxIDandIncrement("FRS_PERSON", "PERSON_ID", 2);
		String q = "INSERT INTO FRS_Person(Person_ID,Person_Name,CNIC,Age,Address,Gender,Nationality,Phone_No,Passport_No) VALUES ('"
		+personID+"','"+name+"',"+cnic+","+age+",'"+address+"','"+gender+"','"+nation+"',"+phone+","+passport+")";
		if (FRS_DataBase.ExecuteUpdate(q)) {
			String q1 = "INSERT INTO FRS_CUSTOMER(Person_ID,Customer_ID,is_Logged) VALUES "
					+ "('"+personID+"','"+custID+"','FALSE')";
			if (FRS_DataBase.ExecuteUpdate(q1)) {
				String q2 = "INSERT INTO FRS_CUSTOMER_ACCOUNT(Customer_ID,Customer_User,Customer_Password,Join_Date) VALUES "
						+ "('"+custID+"','"+user+"','"+pass+"','"+joindate+"')";
				return FRS_DataBase.ExecuteUpdate(q2);
			}

		}
		return false;
	}
	
	protected boolean userExists(String username) {
		try {
			String q = "SELECT * FROM FRS_CUSTOMER_ACCOUNT WHERE CUSTOMER_USER = '"+username+"'";
			ResultSet rs = FRS_DataBase.ExecuteQueryRS(q);
			while (rs.next()) {
				
				if (rs.getString("CUSTOMER_USER").equals(username))
					return true;
					
			}
			
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		return false;
	}
	
	
	String FindPassword(String user) {
		try {
			String q = "SELECT * FROM FRS_CUSTOMER_ACCOUNT WHERE CUSTOMER_USER = '"+user+"'";
			ResultSet rs = FRS_DataBase.ExecuteQueryRS(q);
			while (rs.next()) {
				
				if (rs.getString("CUSTOMER_USER").equals(user))
					return rs.getString("CUSTOMER_PASSWORD");
					
			}
			
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		return "";
	}
	
	boolean UpdatePassword(String newpass, String userName){
		
		String q = "UPDATE FRS_CUSTOMER_ACCOUNT SET CUSTOMER_PASSWORD = '"+newpass+"' WHERE CUSTOMER_USER = '"+userName+"'";

		return FRS_DataBase.ExecuteUpdate(q);
	
	}
	
	protected String GenerateCustomerID() {
		return FindMaxIDandIncrement("FRS_CUSTOMER","CUSTOMER_ID", 2);
	}
	protected String Incrementor(String ID,int substringStart) {
		String pref = ID.substring(substringStart);
		ID = ID.substring(0, substringStart);
		Integer x = Integer.parseInt(pref);
		x++;
		String newStr = ID + x.toString();
		return newStr;
	}
	protected String FindMaxIDandIncrement(String Table, String Column, int substringIndex) {
		String max="";
		String newID = "";
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM "+Table);
			while (rs.next()) {
				
				if (rs.getString(Column).compareTo(max)>0) {
					max = rs.getString(Column);
				}
				
			}
			newID = Incrementor(max,substringIndex);	
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return newID;
	}
	
}
