package mainPackage.BusinessLayer;

import java.sql.ResultSet;

import mainPackage.DataLayer.ConnectDB;

public class Admin_Information {
	ConnectDB FRS_DataBase;
	
	Admin_Information(){
		FRS_DataBase = new ConnectDB();
	}
	
	protected String GenerateAdmID() {
		return FindMaxIDandIncrement("FRS_ADMIN","ADMIN_ID", 3);
	}
	protected boolean AddAdmin(String admID, String name, String pass, long cnic, int age, String gender, String address, String joindate, String nation, long phone, long passport) {
		String personID = FindMaxIDandIncrement("FRS_PERSON", "PERSON_ID", 2);
		String q = "INSERT INTO FRS_Person(Person_ID,Person_Name,CNIC,Age,Address,Gender,Nationality,Phone_No,Passport_No) VALUES ('"
		+personID+"','"+name+"',"+cnic+","+age+",'"+address+"','"+gender+"','"+nation+"',"+phone+","+passport+")";
		if (FRS_DataBase.ExecuteUpdate(q)) {
			String q1 = "INSERT INTO FRS_Admin(Person_ID,Admin_ID,Admin_Password,Join_Date) VALUES "
					+ "('"+personID+"','"+admID+"','"+pass+"','"+joindate+"')";
			return FRS_DataBase.ExecuteUpdate(q1);
		}
		return false;
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
	
	String FindPassword(String user) {
		try {
			String q = "SELECT * FROM FRS_ADMIN WHERE ADMIN_ID = '"+user+"'";
			ResultSet rs = FRS_DataBase.ExecuteQueryRS(q);
			while (rs.next()) {
				
				if (rs.getString("ADMIN_ID").equals(user))
					return rs.getString("ADMIN_PASSWORD");
					
			}
			
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		return "";
	}
	
	boolean UpdatePassword(String newpass, String userName){
		
		String q = "UPDATE FRS_ADMIN SET ADMIN_PASSWORD = '"+newpass+"' WHERE ADMIN_ID = '"+userName+"'";

		return FRS_DataBase.ExecuteUpdate(q);
	
	}
}
