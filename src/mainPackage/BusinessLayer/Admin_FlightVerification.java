package mainPackage.BusinessLayer;
import java.sql.*;
import java.util.Vector;

import mainPackage.DataLayer.ConnectDB;

public class Admin_FlightVerification {
	ConnectDB FRS_DataBase;
	
	
	public Admin_FlightVerification() {
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
	
	public String FindMaxIDandIncrement(String Table, String Column, int substringIndex) {
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
	
	public void Create_Route(String Src, String Dest, String Duration) {
		String max="";
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_Route");
			while (rs.next()) {
				
				if (rs.getString("ROUTE_ID").compareTo(max)>0) {
					max = rs.getString("ROUTE_ID");
				}
				
			}
			String newID = Incrementor(max,2);	// 2 because R-1000 starts numbers from 2nd index
			FRS_DataBase.ExecuteUpdate("INSERT INTO FRS_Route(Route_ID,Src,Destination,Flight_Duration) VALUES ('"+newID+"','"+Src+"','"+Dest+"','"+Duration+"')");
			
			
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
	
	public String Route_Exists(String Src, String Dest) {
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_Route");
			
			
			while (rs.next()) {
				
				if (rs.getString("Src").equals(Src) && rs.getString("Destination").equals(Dest)) {
					return rs.getString("Route_ID");
				}
				
			}
			
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return "";
	}
	public String[] Planes_Available() {
		String[] planes = new String[100];
		Vector<String> planesV = new Vector<String>(100);
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_Plane");
			
			while (rs.next()) {
				
				planesV.addElement(rs.getString("Plane_ID"));
				
			}
			for (int i=0; i<planesV.size(); i++) {
				
				planes[i] = planesV.elementAt(i);
				System.out.println(planes[i]);
			
			}
			
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
		
		return planes;
	}

	
	public String[] Routes_Available() {
		String[] Routes = new String[100];
		Vector<String> routes = new Vector<String>(100);
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_ROUTE");
			
			while (rs.next()) {
				
				if (!routes.contains(rs.getString("Src")))
					routes.addElement(rs.getString("Src"));
				if (!routes.contains(rs.getString("Destination")))
					routes.addElement(rs.getString("Destination"));
				
			}
			for (int i=0; i<routes.size(); i++) {
				Routes[i] = routes.elementAt(i);
			}
			
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
		
		return Routes;
	}
	
}
