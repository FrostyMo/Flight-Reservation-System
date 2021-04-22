package mainPackage.BusinessLayer;
import mainPackage.DataLayer.*;

public class Admin_EditFlight {

	ConnectDB FRS_DB;
	public Admin_EditFlight() {
		FRS_DB = new ConnectDB();
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
	
}
