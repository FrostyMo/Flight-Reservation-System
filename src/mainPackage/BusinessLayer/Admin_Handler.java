package mainPackage.BusinessLayer;


import java.util.ArrayList;


public class Admin_Handler {
	protected Admin_EditFlight editFlight;
	protected Admin_FlightDetails fD;
	protected Admin_FlightSchedule sD;
	protected Admin_Information aI;
	protected Employee_Handler eH;
	protected Admin_FlightVerification helper;
	public Admin_Handler() {
		editFlight = new Admin_EditFlight();
		fD = new Admin_FlightDetails();
		sD = new Admin_FlightSchedule();
		aI = new Admin_Information();
		eH = new Employee_Handler();
		helper = new Admin_FlightVerification();
	}
	
	public boolean Add(String source, String destination, String date, String price, String depart, String arrival, String plane_id) {
		
		
		
		String Flight_ID = helper.FindMaxIDandIncrement("FRS_FLIGHT_SCHEDULE", "FLIGHT_ID", 2); // 2 because numbers in F-1000 start from 2nd index
		String route = helper.Route_Exists(source, destination);
		
		fD.Instantiate(Flight_ID, source, destination, date, price, depart, arrival, plane_id, route);
		
		return editFlight.Add(fD);
		
	}
	
	public boolean Delete(String Flight_ID) {
		
		return editFlight.Delete(Flight_ID);
	}
	
	public ArrayList<String[]> ViewSched() {
		return sD.ViewSched();
	}
	
	public String[] getAllFlightIDs() {
		return sD.getFlightIDs();
	}
	
	public String getPlaneName(String Flight_ID) {
		return sD.getPlaneName(Flight_ID);
	}
	public String getRouteID(String Flight_ID) {
		return sD.getRoute(Flight_ID);
	}
	
	public String getSource(String Flight_ID) {
		return sD.getSrc(Flight_ID);
	}
	
	public String getDeptTime(String Flight_ID) {//getDate 
		return sD.getdeptime(Flight_ID);
	}
	public String getArrivalTime(String Flight_ID) {
		return sD.getarrTime(Flight_ID);
	}
	public String getDate(String Flight_ID) {
		return sD.getdate(Flight_ID);
	}
	public String getBaseAmount(String Flight_ID) {
		return sD.getbamount(Flight_ID);
	}
	public String getArrivalStatus(String Flight_ID) {
		return sD.getarrStatus(Flight_ID);
	}
	public String getDest(String Flight_ID) {
		return sD.getDest(Flight_ID);
	}
	public boolean UpdatePassword(String newpass, String userName){
		return aI.UpdatePassword(newpass, userName);
	}
	public String FindPassword(String user) {
		return aI.FindPassword(user);
	}
	
	public ArrayList<String[]> EmployeeList(){
		return eH.EmployeeList();
	}
	public String GenerateEmpID() {
		return eH.GenerateEmpID();
	}
	public String GenerateAdmID() {
		return aI.GenerateAdmID();
	}
	public boolean AddAdmin(String admID, String name, String pass, long cnic, int age, String gender, String address, String joindate, String nation, long phone, long passport) {
		return aI.AddAdmin(admID, name, pass, cnic, age, gender, address, joindate, nation, phone, passport);
	}
	public boolean AddEmployee(String empID, String name, String pass, long cnic, int age, String gender, String address, String joindate, String nation, long phone, long passport) {
		return eH.AddEmployee(empID, name, pass, cnic, age, gender, address, joindate, nation, phone, passport);
	}
	public boolean UpdateFlight(String flightID, String deptTime, String arriveTime, String Date, String Baseamount) {
		return editFlight.UpdateFlight(flightID, deptTime, arriveTime, Date, Baseamount);
	}
	
	public String[] getAllEmployeeIDs() {
		return eH.getAllEmployeeIDs();
	}
	public String getEmployeeName(String empID) {
		return eH.getEmployeeName(empID);
	}
	public String[] getEmployeeInfo(String empID) {
		return eH.getEmployeeInfo(empID);
	}
	
	public boolean DeleteEmployee(String empID) {
		return eH.DeleteEmployee(empID);
	}
}
