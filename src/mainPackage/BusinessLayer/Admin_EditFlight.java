package mainPackage.BusinessLayer;
import mainPackage.DataLayer.*;

public class Admin_EditFlight {
	protected Admin_FlightVerification helper;
	ConnectDB FRS_DB;
	public Admin_EditFlight() {
		FRS_DB = new ConnectDB();
		helper = new Admin_FlightVerification();
	}
	
	protected boolean Add(Admin_FlightDetails obj) {
		return FRS_DB.ExecuteUpdate(obj.toInsertQuery());
	}
	
	protected boolean Delete(String Flight_ID) {
		if (!FRS_DB.ExecuteUpdate("DELETE FROM FRS_HOTEL WHERE BOOKING_ID IN (SELECT BOOKING_ID FROM FRS_BOOKING WHERE FLIGHT_ID = '"+Flight_ID+"')"))
			return false;
		if (!FRS_DB.ExecuteUpdate("DELETE FROM FRS_PASSENGER WHERE BOOKING_ID IN (SELECT BOOKING_ID FROM FRS_BOOKING WHERE FLIGHT_ID = '"+Flight_ID+"')"))
			return false;
		if (!(FRS_DB.ExecuteUpdate("DELETE FROM FRS_BOOKING WHERE FLIGHT_ID = '"+Flight_ID+"'")))
				return false;
		return FRS_DB.ExecuteUpdate("DELETE FROM FRS_FLIGHT_SCHEDULE WHERE FLIGHT_ID = '"+Flight_ID+"'");
	}
	//UpdateBooking
	protected boolean UpdateFlight(String flightID, String deptTime, String arriveTime, String Date, String Baseamount,String Src, String Dest) {
		//String routeID= helper.Route_Exists(Src, Dest);
		
		String q = "UPDATE FRS_FLIGHT_SCHEDULE SET Flight_Date = '"+Date+"', Time_Of_Depart = '"+deptTime+"', Time_Of_Arrival = '"+arriveTime+"', Base_Amount = '"
	+Baseamount+"' WHERE FLIGHT_ID = '"+flightID+"'";
		
		return FRS_DB.ExecuteUpdate(q);
	}
}
