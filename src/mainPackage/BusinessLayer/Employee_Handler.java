package mainPackage.BusinessLayer;

import java.util.ArrayList;

import mainPackage.DataLayer.ConnectDB;

public class Employee_Handler {
	ConnectDB FRS_DataBase;
	Employee_Information eI;
	Employee_EditEmployee eE;
	Employee_BookingSchedule bS;
	Employee_Support sup;
	public Employee_Handler(){
		FRS_DataBase = new ConnectDB();
		eI = new Employee_Information();
		eE = new Employee_EditEmployee();
		bS = new Employee_BookingSchedule();
		sup = new Employee_Support();
	}
	
	
	public String getEmployeeName(String empID) {
		return eI.getEmployeeName(empID);
	}
	
	public String FindPassword(String empID) {
		return eI.FindPassword(empID);
	}

	public boolean UpdatePassword(String newpass, String userName) {
		// TODO Auto-generated method stub
		return eI.UpdatePassword(newpass, userName);
	}

	public String[] getEmployeeInfo(String empID) {
		return eI.getEmployeeInfo(empID);
	}
	
	public boolean UpdateEmployee(String empID, String newAge, String newAddress, String newName, String newContact) {
		String pID = eI.getPersonID(empID);
		return eE.UpdateEmployee(pID, newAge, newAddress, newName, newContact);
	}
	
	protected boolean DeleteEmployee(String empID) {
		return eE.DeleteEmployee(empID);
	}
	
	public ArrayList<String[]> getAllActiveBookings() {
		return bS.getAllActiveBookings();
	}
	public String[] getCustomerSupportIDs() {
		return sup.getCustomerSupportIDs();
	}
	public String getResponses(String ticketID) {
		return sup.getResponses(ticketID);
	}
	public String getCustomerID(String ticketID) {
		return sup.getCustomerID(ticketID);
	}
	public boolean respondToCustomer(String ticketID, String customerID, String assistantID, String response) {
		return sup.respondToCustomer(ticketID, customerID, assistantID, response);
	}
	public ArrayList<String[]> EmployeeList(){
		return eI.EmployeeList();
	}
	protected String GenerateEmpID() {
		return eE.GenerateEmpID();
	}
	protected boolean AddEmployee(String empID, String name, String pass, long cnic, int age, String gender, String address, String joindate, String nation, long phone, long passport) {
		return eE.AddEmployee(empID, name, pass, cnic, age, gender, address, joindate, nation, phone, passport);
	}
	protected String[] getAllEmployeeIDs() {
		return eI.getAllEmployeeIDs();
	}
		
}
