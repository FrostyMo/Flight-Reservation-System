package mainPackage.BusinessLayer;

import java.sql.ResultSet;

import mainPackage.DataLayer.ConnectDB;

public class Employee_EditEmployee {
	ConnectDB FRS_DataBase;
		
	Employee_EditEmployee(){
		FRS_DataBase = new ConnectDB();
	}
	
	protected boolean AddEmployee(String empID, String name, String pass, long cnic, int age, String gender, String address, String joindate, String nation, long phone, long passport) {
		String personID = FindMaxIDandIncrement("FRS_PERSON", "PERSON_ID", 2);
		String q = "INSERT INTO FRS_Person(Person_ID,Person_Name,CNIC,Age,Address,Gender,Nationality,Phone_No,Passport_No) VALUES ('"
		+personID+"','"+name+"',"+cnic+","+age+",'"+address+"','"+gender+"','"+nation+"',"+phone+","+passport+")";
		if (FRS_DataBase.ExecuteUpdate(q)) {
			String q1 = "INSERT INTO FRS_Assistant(Person_ID,Assistant_ID,Assistant_Password,Join_Date) VALUES "
					+ "('"+personID+"','"+empID+"','"+pass+"','"+joindate+"')";
			return FRS_DataBase.ExecuteUpdate(q1);
		}
		return false;
	}
	
	protected boolean UpdateEmployee(String pID, String newAge, String newAddress, String newName, String newContact) {
		
		String q = "UPDATE FRS_PERSON SET AGE = '"+newAge+"', ADDRESS = '"+newAddress+"', PERSON_NAME = '"+newName+"', PHONE_NO = '"+newContact+"' "
				+ "WHERE PERSON_ID = '"+pID+"'";
		return FRS_DataBase.ExecuteUpdate(q);
	}
	
	protected boolean DeleteEmployee(String empID) {
		String q = "DELETE FROM FRS_ASSISTANT WHERE ASSISTANT_ID = '"+empID+"'";
		return FRS_DataBase.ExecuteUpdate(q);
	}
	
	protected String GenerateEmpID() {
		return FindMaxIDandIncrement("FRS_ASSISTANT","ASSISTANT_ID", 3);
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
