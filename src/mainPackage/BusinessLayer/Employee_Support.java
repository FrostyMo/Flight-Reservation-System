package mainPackage.BusinessLayer;

import java.sql.ResultSet;
import java.util.Vector;

import mainPackage.DataLayer.ConnectDB;

public class Employee_Support {
	ConnectDB FRS_DataBase;
	
	Employee_Support(){
		FRS_DataBase = new ConnectDB();
	}
	
	protected boolean respondToCustomer(String ticketID, String customerID, String assistantID, String response) {
		//String q = "INSERT INTO FRS_Customer_Support(Ticket_ID, Assistant_ID,Cust_ID,C_Query,Response,ticket_Closed) VALUES ('"+ticketID+"','"+assistantID+"','"+customerID+"','','"+response+"',0)";
		String q = "UPDATE FRS_CUSTOMER_SUPPORT SET ASSISTANT_ID = '"+assistantID+"', RESPONSE = '"+response+"' WHERE TICKET_ID = '"+ticketID+"' AND ASSISTANT_ID = 'null'";
		return FRS_DataBase.ExecuteUpdate(q);
	}
	
	protected String[] getCustomerSupportIDs() {
		
		Vector<String> custV = new Vector<String>();
		String[] custID = new String[1];
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_CUSTOMER_SUPPORT WHERE TICKET_CLOSED=0");
			
			
			while (rs.next()) {
				if (!custV.contains(rs.getString("TICKET_ID")))
					custV.addElement(rs.getString("TICKET_ID"));
			}
			String[] custID1 = new String[custV.size()];
			for (int i=0; i<custV.size(); i++) {
				custID1[i] = custV.elementAt(i);
			}
			return custID1;
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
		
		return custID;
	}
	
	protected String getCustomerID(String ticketID) {
		
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_CUSTOMER_SUPPORT WHERE TICKET_ID = '"+ticketID+"'");
			
			
			while (rs.next()) {
				return rs.getString("CUST_ID");
			}
			
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
		
		return "";
	}
	
	
	protected String getResponses(String ticketID) {
		
		String pastResponses = "";
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_CUSTOMER_SUPPORT WHERE TICKET_ID = '"+ticketID+"'");
			
			while (rs.next()) {
				String whoIsIt = rs.getString("CUST_ID") + ": " + rs.getString("C_QUERY") +"\n";
				String whoIsIt1 = rs.getString("Assistant_ID") + ": " + rs.getString("RESPONSE") +"\n";
				pastResponses += whoIsIt + whoIsIt1;
			}
			return pastResponses;
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
		
		return "";
	}
	
}
