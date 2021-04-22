package mainPackage.BusinessLayer;

import java.sql.*;


import mainPackage.DataLayer.*;

public class Login {
	
	ConnectDB FRS_DataBase;
	public Login(){
		FRS_DataBase = new ConnectDB();
	}
	
	public boolean GeneralLogin(String Who_Is_It, String Pass_Name, String user, String pass, String query) {
		System.out.println("USER: " + user + " and PASSWORD: " + pass );
		try {
		ResultSet rs = FRS_DataBase.ExecuteQueryRS(query);
		
		while (rs.next()) {
			
			if (rs.getString(Who_Is_It).equals(user) && rs.getString(Pass_Name).equals(pass))
				return true;
				
		}
		
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return false;
		
	}
	public boolean loginEmployee(String user, String pass) 
	{
		//System.out.println("USER: " + user + " and PASSWORD: " + pass );
		return GeneralLogin("Assistant_ID", "Assistant_Password", user, pass,"SELECT * FROM FRS_ASSISTANT");
	}

	public boolean loginAdmin(String user, String pass) 
	{
		return GeneralLogin("Admin_ID", "Admin_Password", user, pass,"SELECT * FROM FRS_ADMIN");
	}
	
	public boolean loginUser(String user, String pass) 
	{
		return GeneralLogin("Customer_USER", "Customer_Password", user, pass,"SELECT * FROM FRS_CUSTOMER_ACCOUNT");
	}
	
	
}
