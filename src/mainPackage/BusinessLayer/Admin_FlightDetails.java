package mainPackage.BusinessLayer;

public class Admin_FlightDetails {
	public String source, destination, date, price, depart, arrival, plane_id, Flight_ID, Route_ID;
	
	public Admin_FlightDetails(){
		source = destination = date = price = depart = arrival = plane_id = Flight_ID = Route_ID ="";
	}
	
	public void Instantiate(String fID, String src, String dest, String Date, String bprice, String dep, String arriv, String plane, String route) {
		Flight_ID = fID;
		source = src;
		destination = dest;
		date = Date;
		price = bprice;
		depart = dep;
		arrival = arriv;
		plane_id = plane;
		Route_ID = route;
	}
	
	String toInsertQuery() {
		String query = "INSERT INTO FRS_Flight_Schedule(Flight_ID,Plane_ID,Route_ID,Flight_Date,Time_Of_Depart,Time_Of_Arrival,Base_Amount) "
				+ "VALUES ('"+Flight_ID+"','"+plane_id+"','"+Route_ID+"','"+date+"','"+depart+"','"+arrival+"',"+Integer.parseInt(price)+")";
		return query;
	}
}
