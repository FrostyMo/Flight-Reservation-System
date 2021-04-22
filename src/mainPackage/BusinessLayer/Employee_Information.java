package mainPackage.BusinessLayer;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import mainPackage.DataLayer.ConnectDB;

public class Employee_Information {
	ConnectDB FRS_DataBase;
	
	Employee_Information(){
		FRS_DataBase = new ConnectDB();
	}
	
	// A.ASSISTANT_ID, P.PERSON_NAME, A.ASSISTANT_PASSWORD, P.AGE, P.ADDRESS, A.JOIN_DATE, P.PHONE_NO
	String[] getAllEmployeeIDs() {
		String[] lol = new String[1];
		Vector<String> ar = new Vector<String>();
		try {
			String q = "SELECT * FROM FRS_ASSISTANT_INFO";
			ResultSet rs = FRS_DataBase.ExecuteQueryRS(q);
			while (rs.next()) {
				if (!ar.contains(rs.getString("ASSISTANT_ID"))) {
					ar.addElement(rs.getString("ASSISTANT_ID"));
				}
			}
			String[] empIDs = new String[ar.size()];
			for (int i=0; i<ar.size(); i++) {
				empIDs[i] = ar.elementAt(i);
			}
			return empIDs;
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return lol;
	}
	
	ArrayList<String[]> EmployeeList() {
		ArrayList<String[]> ar = new ArrayList<String[]>();
		try {
			String q = "SELECT * FROM FRS_ASSISTANT_INFO";
			ResultSet rs = FRS_DataBase.ExecuteQueryRS(q);
			while (rs.next()) {
				String[] tempRow = new String[7];
				for (int i=1; i<=7; i++) {
					tempRow[i-1] = rs.getString(i);
				}
				ar.add(tempRow);
			}
			
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		return ar;
	}
	
	String FindPassword(String user) {
		try {
			String q = "SELECT * FROM FRS_ASSISTANT WHERE ASSISTANT_ID = '"+user+"'";
			ResultSet rs = FRS_DataBase.ExecuteQueryRS(q);
			while (rs.next()) {
				
				if (rs.getString("ASSISTANT_ID").equals(user))
					return rs.getString("ASSISTANT_PASSWORD");
					
			}
			
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		return "";
	}
	
	boolean UpdatePassword(String newpass, String userName){
		
		String q = "UPDATE FRS_ASSISTANT SET ASSISTANT_PASSWORD = '"+newpass+"' WHERE ASSISTANT_ID = '"+userName+"'";

		return FRS_DataBase.ExecuteUpdate(q);
	
	}
	
	String getEmployeeName(String empID) {
		String q = "SELECT * FROM FRS_ASSISTANT_INFO WHERE ASSISTANT_ID = '"+empID+"'";
		try {
			
			ResultSet rs = FRS_DataBase.ExecuteQueryRS(q);
			while (rs.next()) {
				
				if (rs.getString("ASSISTANT_ID").equals(empID))
					return rs.getString("PERSON_NAME");
					
			}
			
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		return "";
	}
	
	String getPersonID(String empID) {
		String q = "SELECT * FROM FRS_ASSISTANT WHERE ASSISTANT_ID = '"+empID+"'";
		try {
			
			ResultSet rs = FRS_DataBase.ExecuteQueryRS(q);
			while (rs.next()) {
				
				if (rs.getString("ASSISTANT_ID").equals(empID))
					return rs.getString("PERSON_ID");
					
			}
			
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		return "";
	}
	
	String[] getEmployeeInfo(String empID) {
		String[] empInfo = new String[4];
		String q = "SELECT * FROM FRS_ASSISTANT_INFO WHERE ASSISTANT_ID = '"+empID+"'";
		try {
			
			ResultSet rs = FRS_DataBase.ExecuteQueryRS(q);
			while (rs.next()) {
				
				if (rs.getString("ASSISTANT_ID").equals(empID)) {
					int i=0;
					empInfo[i++] = rs.getString("AGE");
					empInfo[i++] = rs.getString("ADDRESS");
					empInfo[i++] = rs.getString("JOIN_DATE");
					empInfo[i++] = rs.getString("PHONE_NO");
				}
			}
			
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		return empInfo;
	}
	
	
	
}
