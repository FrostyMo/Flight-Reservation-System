package mainPackage.BusinessLayer;

import java.sql.ResultSet;

import mainPackage.DataLayer.ConnectDB;

public class Customer_EditBooking {
	
	ConnectDB FRS_DataBase;
	Customer_EditBooking(){
		FRS_DataBase = new ConnectDB();
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
	
	
	
	protected boolean AddPassenger(String[] str) {
		String Passenger_ID = FindMaxIDandIncrement("FRS_PASSENGER","PASSENGER_ID", 3);
		String q = "INSERT INTO FRS_Passenger(Passenger_ID,Booking_ID,Passenger_Name,CNIC,Age,Meal_Option,Seat_Option,Luggage,Class,Check_In,Added_Price) "
				+ " VALUES ('"+Passenger_ID+"','"+str[0]+"','"+str[1]+"',"+str[2]+","+str[3]+",'"+str[4]+"',"+str[5]+",'"+str[6]+"','"+str[7]+"','"+str[8]+"',"+str[9]+")";

		return FRS_DataBase.ExecuteUpdate(q);
	}
	protected String AddBooking(String FlightID, String Passengers, String user) {
		String B_ID = FindMaxIDandIncrement("FRS_BOOKING","BOOKING_ID", 2);
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT CUSTOMER_ID FROM FRS_CUSTOMER_ACCOUNT WHERE CUSTOMER_USER='"+user+"'");
			rs.next();
			user = rs.getString("CUSTOMER_ID");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		String q = "INSERT INTO FRS_Booking(Booking_ID,Flight_ID,Customer_ID,Number_Of_Passengers) "
				+ "VALUES ('"+B_ID+"','"+FlightID+"','"+user+"',"+Passengers+")";
		
		FRS_DataBase.ExecuteUpdate(q);
		return B_ID;
	}
	
	// HOTEL, PASSENGER, BOOKING
	protected boolean CancelBooking(String Booking_ID) {
		if (!FRS_DataBase.ExecuteUpdate("DELETE FROM FRS_HOTEL WHERE BOOKING_ID = '"+Booking_ID+"'"))
			return false;
		if (!FRS_DataBase.ExecuteUpdate("DELETE FROM FRS_PASSENGER WHERE BOOKING_ID = '"+Booking_ID+"'"))
			return false;
		return FRS_DataBase.ExecuteUpdate("DELETE FROM FRS_BOOKING WHERE BOOKING_ID = '"+Booking_ID+"'");
		
	}
	// PASSENGER ID ** WILL BE A LIST **
	// NAME
	// MEAL OPT		** WILL BE A LIST **
	// SEAT OPT		** WILL BE A LIST **
	// LUGGAGE
	// CLASS		** WILL BE A LIST **
	// CHECK IN		** WILL BE A LIST **
	
	protected boolean UpdateBooking(String passID, String name, String meal, String seat, String luggage, String Class, String checkin) {
		String q = "UPDATE FRS_PASSENGER SET PASSENGER_NAME = '"+name+"', MEAL_OPTION = '"+meal+"', SEAT_OPTION = '"+seat+"', LUGGAGE = '"+luggage+"',"
				+ " CLASS = '"+Class+"', CHECK_IN = '"+checkin+"' WHERE PASSENGER_ID = '"+passID+"'";
		
		return FRS_DataBase.ExecuteUpdate(q);
	}
}
