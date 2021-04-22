package mainPackage.BusinessLayer;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import mainPackage.DataLayer.ConnectDB;

public class Employee_BookingSchedule {
ConnectDB FRS_DataBase;
	
	Employee_BookingSchedule(){
		FRS_DataBase = new ConnectDB();
	}
	
	protected ArrayList<String[]> getAllActiveBookings() {
		ArrayList<String[]> arr = new ArrayList<String[]>();
		
		ResultSet rs = null;
		try {
			rs = FRS_DataBase.ExecuteQueryRS("SELECT * FROM FRS_EMPLOYEE_BOOKING");
			
			ResultSetMetaData rsm = rs.getMetaData();
			int col = rsm.getColumnCount();
			
			while (rs.next()) {
				String[] temp = new String[col];
				for (int i=0; i<col; i++) {
					temp[i] = rs.getString(i+1);
					System.out.println("ROW "+i+1+ temp[i]);
				}
				arr.add(temp);
			}
			for (int i=0; i<arr.size(); i++) {
				for (int j=0; j<arr.get(i).length; j++) {
					System.out.println("+"+arr.get(i)[j]);
				}
			}
			
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
		
		return arr;
	}
	
}
