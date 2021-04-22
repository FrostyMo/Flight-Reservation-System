package mainPackage.BusinessLayer;

import java.util.ArrayList;

public class Customer_Handler {
	
	protected Customer_Schedule sD;
	protected Customer_EditBooking eB;
	protected Customer_Information cI;
	protected Customer_BookingSchedule bS;
	protected Customer_Support cS;
	
	public Customer_Handler() {
		sD = new Customer_Schedule();
		eB = new Customer_EditBooking();
		cI = new Customer_Information();
		bS = new Customer_BookingSchedule();
		cS = new Customer_Support();
	}
	
	public boolean AddPassenger(String[] str) {
		return eB.AddPassenger(str);
	}
	
	public String AddBooking(String FlightID, String Passengers,String user) {
		
		return eB.AddBooking(FlightID, Passengers, user);
	}
	
	public ArrayList<String[]> ViewSched() {
		return sD.ViewSched();
	}
	public ArrayList<String[]> ViewSched(String from, String to, String date, String passengers, String classType) {
		return sD.ViewSched(from, to, date, passengers, classType);
	}
	
	public boolean UpdatePassword(String newpass, String userName){
		return cI.UpdatePassword(newpass, userName);
	}
	public String FindPassword(String user) {
		return cI.FindPassword(user);
	}
	
	public String[] getActiveBookings(String userName) {
		return bS.getBookingIDs(userName);
	}
	
	public boolean UpdateBooking(String passID, String name, String meal, String seat, String luggage, String Class, String checkin) {
		return eB.UpdateBooking(passID, name, meal, seat, luggage, Class, checkin);
	}
	
	public boolean CancelBooking(String Booking_ID) {
		return eB.CancelBooking(Booking_ID);
	}
	
	public String[] getPassengerID(String bookingID) {
		return bS.getPassengerID(bookingID);
	}
	
	public String getPassengerName(String passID) {
		return bS.getPassengerName(passID);
	}
	public String getPassengerMeal(String passID) {
		return bS.getPassengerMeal(passID);
	}
	public String getPassengerSeat(String passID) {
		return bS.getPassengerSeat(passID);
	}
	public String getPassengerLuggage(String passID) {
		return bS.getPassengerLuggage(passID);
	}
	public String getPassengerClass(String passID) {
		return bS.getPassengerClass(passID);
	}
	public String getPassengerCheckIn(String passID) {
		return bS.getPassengerCheckIn(passID);
	}
	
	public String getSource(String bookingID) {
		return bS.getSource(bookingID);
	}
	public String getDestination(String bookingID) {
		return bS.getDestination(bookingID);
	}
	public String getFlightID(String bookingID) {
		return bS.getFlightID(bookingID);
	}
	public String getCustomerID(String userName) {
		return cS.getCustomerID(userName);
	}
	public String[] getCustomerSupportIDs(String custID) {
		return cS.getCustomerSupportIDs(custID);
	}
	public String getResponses(String ticketID) {
		return cS.getResponses(ticketID);
	}
	public boolean respondToAssistant(String ticketID, String customerID, String assistantID, String query) {
		return cS.respondToAssistant(ticketID, customerID, assistantID, query);
	}
	public String GenerateNewTicketID() {
		return cS.GenerateNewTicketID();
	}
}
