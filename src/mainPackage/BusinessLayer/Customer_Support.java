package mainPackage.BusinessLayer;

import java.sql.ResultSet;
import java.util.Vector;

import mainPackage.DataLayer.ConnectDB;

public class Customer_Support {
	
	ConnectDB FRS_DataBase;
	
	Customer_Support(){
		FRS_DataBase = new ConnectDB();
	}
	public String Incrementor(String ID,int substringStart) {
		String pref = ID.substring(substringStart);
		ID = ID.substring(0, substringStart);
		Integer x = Integer.parseInt(pref);
		x++;
		String newStr = ID + x.toString();
		return newStr;
	}
	
	protected String GenerateNewTicketID() {
		String max="";
		String newID = "";
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_CUSTOMER_SUPPORT");
			while (rs.next()) {
				
				if (rs.getString("TICKET_ID").compareTo(max)>0) {
					max = rs.getString("TICKET_ID");
				}
				
			}
			newID = Incrementor(max,2);	
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return newID;
	}
	
	protected boolean respondToAssistant(String ticketID, String customerID, String assistantID, String query) {
		String q = "INSERT INTO FRS_Customer_Support(Ticket_ID, Assistant_ID,Cust_ID,C_Query,Response,ticket_Closed) VALUES ('"+ticketID+"','"+assistantID+"','"+customerID+"','"+query+"','',0)";
		
		return FRS_DataBase.ExecuteUpdate(q);
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
	
	protected String[] getCustomerSupportIDs(String custID) {	// RETURNS TICKET ID
			
			Vector<String> ticketV = new Vector<String>();
			String[] ticketID = new String[1];
			ResultSet rs = null;
			try {
				rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_CUSTOMER_SUPPORT WHERE TICKET_CLOSED=0 AND CUST_ID = '"+custID+"'");
				
				
				while (rs.next()) {
					if (!ticketV.contains(rs.getString("TICKET_ID")))
						ticketV.addElement(rs.getString("TICKET_ID"));
				}
				String[] ticketID1 = new String[ticketV.size()];
				for (int i=0; i<ticketV.size(); i++) {
					ticketID1[i] = ticketV.elementAt(i);
				}
				return ticketID1;
				}
			catch (Exception exc) {
				exc.printStackTrace();
			}
				
			
			return ticketID;
	}
	
	protected String getCustomerID(String userName) {
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_CUSTOMER_ACCOUNT WHERE CUSTOMER_USER = '"+userName+"'");
			
			
			while (rs.next()) {
				if (rs.getString("CUSTOMER_USER").equals(userName))
					return rs.getString("CUSTOMER_ID");
			}
		}
			
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return "";
	}
	
	
}
