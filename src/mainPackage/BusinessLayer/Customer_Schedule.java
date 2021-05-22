package mainPackage.BusinessLayer;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Vector;



import mainPackage.DataLayer.ConnectDB;

public class Customer_Schedule {
	ConnectDB FRS_DataBase;
	Customer_Schedule(){
		FRS_DataBase = new ConnectDB();
	}
	
//	protected String[] getFlightIDs() {
//		String[] flights = new String[100];
//		Vector<String> flightsV = new Vector<String>(100);
//		ResultSet rs = null;
//		try {
//			rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_FLIGHT_SCHEDULE");
//			ResultSetMetaData rsm = rs.getMetaData();
//			//int col = rsm.getColumnCount();
//			
//			while (rs.next()) {
//				
//				flightsV.addElement(rs.getString("FLIGHT_ID"));
//				
//			}
//			for (int i=0; i<flightsV.size(); i++) {
//				
//				flights[i] = flightsV.elementAt(i);
//				System.out.println(flights[i]);
//			
//			}
//			
//			}
//			catch (Exception exc) {
//				exc.printStackTrace();
//			}
//			
//		
//		return flights;
//	}
	
	public ArrayList<String[]> ViewSched(String from, String to, String date, String passengers, String classType) {
	
		ArrayList<String[]> flightlist = new ArrayList<String[]>();
			
			Vector<String> flightsV = new Vector<String>(7);
			ResultSet rs = null;
			try {
				
				rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_CUSTOMER_VIEW WHERE SRC='"+from+"' AND DESTINATION='"+to+"' AND FLIGHT_DATE like '"+date+"'");
				ResultSetMetaData rsm = rs.getMetaData();
				int col = rsm.getColumnCount();
			
				
				while (rs.next()) {
					String[] flights = new String[7];
					for (int i=1; i<=col; i++) {
						flightsV.addElement(rs.getString(i));
					}
					for (int j=0; j<flightsV.size(); j++) {
						
						flights[j] = flightsV.elementAt(j);
						System.out.println(flights[j]);
					
					}
					flightsV.clear();
					flightlist.add(flights);
					
				}
				
				
				}
			catch (Exception exc) {
				exc.printStackTrace();
			}
				
			for(int i = 0; i<flightlist.size(); i++) {
				for (int j=0; j<flightlist.get(i).length; j++)
					System.out.println(flightlist.get(i)[j]);
	    		
	    	}
			return flightlist;
	}
	
	public ArrayList<String[]> ViewSched(String choice) {
		ArrayList<String[]> flightlist = new ArrayList<String[]>();
		
		Vector<String> flightsV = new Vector<String>(10);
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_CUSTOMER_VIEW order by "+ choice);
			ResultSetMetaData rsm = rs.getMetaData();
			int col = rsm.getColumnCount();
			
			while (rs.next()) {
				String[] flights = new String[10];
				for (int i=1; i<=col; i++) {
					flightsV.addElement(rs.getString(i));
				}
				for (int j=0; j<flightsV.size(); j++) {
					
					flights[j] = flightsV.elementAt(j);
					System.out.println(flights[j]);
				
				}
				flightsV.clear();
				flightlist.add(flights);
				
			}
			
			
			}
		catch (Exception exc) {
			exc.printStackTrace();
		}
			
		for(int i = 0; i<flightlist.size(); i++) {
			for (int j=0; j<flightlist.get(i).length; j++)
				System.out.println(flightlist.get(i)[j]);
    		
    	}
		return flightlist;
	}
}
