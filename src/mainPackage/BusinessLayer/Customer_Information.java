package mainPackage.BusinessLayer;

import java.sql.ResultSet;

import mainPackage.DataLayer.ConnectDB;

public class Customer_Information {
	ConnectDB FRS_DataBase;
	
	Customer_Information(){
		FRS_DataBase = new ConnectDB();
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
	
}
