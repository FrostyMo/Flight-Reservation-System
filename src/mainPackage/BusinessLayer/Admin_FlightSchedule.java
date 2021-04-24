package mainPackage.BusinessLayer;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import java.util.Vector;

import mainPackage.DataLayer.*;
public class Admin_FlightSchedule {

	ConnectDB FRS_DataBase;
	Admin_FlightSchedule(){
		FRS_DataBase = new ConnectDB();
	}
	
	protected String[] getFlightIDs() {
		String[] flights = new String[100];
		Vector<String> flightsV = new Vector<String>(100);
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_FLIGHT_SCHEDULE");
			
			while (rs.next()) {
				
				flightsV.addElement(rs.getString("FLIGHT_ID"));
				
			}
			for (int i=0; i<flightsV.size(); i++) {
				
				flights[i] = flightsV.elementAt(i);
				System.out.println(flights[i]);
			
			}
			
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
		
		return flights;
	}
	
	protected String getPlaneName(String Flight_ID) {
		String PlaneName = "";
		
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT P.PLANE_NAME FROM FRS_PLANE P, FRS_FLIGHT_SCHEDULE FS WHERE FS.FLIGHT_ID = '"+Flight_ID+"' AND P.PLANE_ID = FS.PLANE_ID");
			rs.next();
			return rs.getString("P.PLANE_NAME");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
			
		
		return PlaneName;
	}
	protected String getRoute(String Flight_ID) {
		String RouteID = "";
		
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT FS.ROUTE_ID FROM FRS_FLIGHT_SCHEDULE FS WHERE FS.FLIGHT_ID = '"+Flight_ID+"' ");
			rs.next();
			return rs.getString("FS.ROUTE_ID");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
			
		
		return RouteID;
	}
	
	protected String getSrc(String Flight_ID) {
		
		
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT R.Src FROM FRS_ROUTE R, FRS_FLIGHT_SCHEDULE FS WHERE FLIGHT_ID = '"+Flight_ID+"' AND R.ROUTE_ID = FS.ROUTE_ID");
			rs.next();
			System.out.println(rs.getString("R.Src"));
			return rs.getString("R.Src");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
			
		
		return "";
	}
	
	protected String getDest(String Flight_ID) {
		
		
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT R.Destination FROM FRS_ROUTE R, FRS_FLIGHT_SCHEDULE FS WHERE FLIGHT_ID = '"+Flight_ID+"' AND R.ROUTE_ID = FS.ROUTE_ID");
			rs.next();
			System.out.println(rs.getString("R.Destination"));
			return rs.getString("R.Destination");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
			
		
		return "";
	}
	//getdeptime
	protected String getdeptime(String Flight_ID) {
			
			
			ResultSet rs = null;
			try {
				rs = FRS_DataBase.ExecuteQueryRS("SELECT Time_Of_Depart FROM FRS_FLIGHT_SCHEDULE WHERE FLIGHT_ID = '"+Flight_ID+"' ");
				rs.next();
				System.out.println(rs.getString("Time_Of_Depart"));
				return rs.getString("Time_Of_Depart");
				
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
				
			
			return "";
		}
	//getarrTime
	protected String getarrTime(String Flight_ID) {
		
		
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT Time_Of_Arrival FROM FRS_FLIGHT_SCHEDULE WHERE FLIGHT_ID = '"+Flight_ID+"' ");
			rs.next();
			System.out.println(rs.getString("Time_Of_Arrival"));
			return rs.getString("Time_Of_Arrival");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
			
		
		return "";
	}
	//getdate
	protected String getdate(String Flight_ID) {
			
			
			ResultSet rs = null;
			try {
				rs = FRS_DataBase.ExecuteQueryRS("SELECT Flight_Date FROM  FRS_FLIGHT_SCHEDULE WHERE FLIGHT_ID = '"+Flight_ID+"' ");
				rs.next();
				System.out.println(rs.getString("Flight_Date"));
				return rs.getString("Flight_Date");
				
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
				
			
			return "";
		}
	//getbamount
	protected String getbamount(String Flight_ID) {
		
		
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT Base_Amount FROM  FRS_FLIGHT_SCHEDULE WHERE FLIGHT_ID = '"+Flight_ID+"' ");
			rs.next();
			System.out.println(rs.getString("Base_Amount"));
			return rs.getString("Base_Amount");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
			
		
		return "";
	}
	//getarrStatus
	protected String getarrStatus(String Flight_ID) {
			
			
			ResultSet rs = null;
			try {
				rs = FRS_DataBase.ExecuteQueryRS("SELECT Status_Complete FROM FRS_FLIGHT_SCHEDULE WHERE FLIGHT_ID = '"+Flight_ID+"' ");
				rs.next();
				System.out.println(rs.getString("Status_Complete"));
				return rs.getString("Status_Complete");
				
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
				
			
			return "";
		}
	public ArrayList<String[]> ViewSched() {
		ArrayList<String[]> flightlist = new ArrayList<String[]>();
		
		Vector<String> flightsV = new Vector<String>(11);
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_AVAILABLE_FLIGHTS");
			ResultSetMetaData rsm = rs.getMetaData();
			int col = rsm.getColumnCount();
			
			while (rs.next()) {
				String[] flights = new String[11];
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
		
		Vector<String> flightsV = new Vector<String>(11);
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_AVAILABLE_FLIGHTS order by " + choice);
			ResultSetMetaData rsm = rs.getMetaData();
			int col = rsm.getColumnCount();
			
			while (rs.next()) {
				String[] flights = new String[11];
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
