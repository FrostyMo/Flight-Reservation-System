package mainPackage.BusinessLayer;

import java.sql.ResultSet;
import java.util.Vector;

import mainPackage.DataLayer.ConnectDB;

public class Customer_BookingSchedule {
	
	ConnectDB FRS_DataBase;
	
	Customer_BookingSchedule(){
		FRS_DataBase = new ConnectDB();
	}
	
	
	protected String[] getBookingIDs(String customer_ID) {
		String[] bookings = new String[100];
		Vector<String> bookingsV = new Vector<String>();
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT BOOKING_ID, FLIGHT_ID, SRC, DESTINATION, PASSENGER_ID, PASSENGER_NAME, MEAL_OPTION, SEAT_OPTION "
					+ "LUGGAGE, CLASS, CHECK_IN FROM PASSENGER_DETAILS WHERE CUSTOMER_USER = '"+customer_ID+"'");
			
			while (rs.next()) {
				if (!bookingsV.contains(rs.getString("BOOKING_ID")))
					bookingsV.addElement(rs.getString("BOOKING_ID"));
				
			}
			String[] bookings1 = new String[bookingsV.size()];
			for (int i=0; i<bookingsV.size(); i++) {
				
				bookings1[i] = bookingsV.elementAt(i);
				System.out.println(bookings[i]);
			
			}
			return bookings1;
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
		
		return bookings;
	}
	
	protected String[] getPassengerID(String bookingID) {
		Vector<String> columnV = new Vector<String>();
		String[] column = new String[100];
		int count = 0;
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT PASSENGER_ID FROM PASSENGER_DETAILS WHERE BOOKING_ID = '"+bookingID+"'");
			while(rs.next()) {
				if (!columnV.contains(rs.getString("PASSENGER_ID"))){
					columnV.addElement(rs.getString("PASSENGER_ID"));
					count++;
				}
			}
			String[] column1 = new String[count];
			for (int i=0; i<columnV.size(); i++) {
				column1[i] = columnV.elementAt(i);
			}
			return column1;
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
			
		return column;
	}
	protected String getColumnNameBooking(String bookID, String columnName) {
		String column = "";
		
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT "+columnName+" FROM PASSENGER_DETAILS WHERE BOOKING_ID = '"+bookID+"'");
			rs.next();
			return rs.getString(columnName);
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
			
		
		return column;
	}
	
	protected String getColumnNamePassenger(String passID, String columnName) {
		String column = "";
		
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT "+columnName+" FROM PASSENGER_DETAILS WHERE PASSENGER_ID = '"+passID+"'");
			rs.next();
			return rs.getString(columnName);
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
			
		
		return column;
	}
	
	protected String getPassengerName(String passID) {
		return getColumnNamePassenger(passID, "PASSENGER_NAME");
	}
	protected String getPassengerMeal(String passID) {
		return getColumnNamePassenger(passID, "MEAL_OPTION");
	}
	protected String getPassengerSeat(String passID) {
		return getColumnNamePassenger(passID, "SEAT_OPTION");
	}
	protected String getPassengerLuggage(String passID) {
		return getColumnNamePassenger(passID, "LUGGAGE");
	}
	protected String getPassengerClass(String passID) {
		return getColumnNamePassenger(passID, "CLASS");
	}
	protected String getPassengerCheckIn(String passID) {
		return getColumnNamePassenger(passID, "CHECK_IN");
	}
	
	protected String getSource(String bookingID) {
		return getColumnNameBooking(bookingID, "SRC");
	}
	protected String getDestination(String bookingID) {
		return getColumnNameBooking(bookingID, "DESTINATION");
	}
	protected String getFlightID(String bookingID) {
		return getColumnNameBooking(bookingID, "FLIGHT_ID");
	}
	
}
