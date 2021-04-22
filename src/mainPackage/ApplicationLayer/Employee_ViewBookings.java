package mainPackage.ApplicationLayer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import mainPackage.BusinessLayer.Employee_Handler;

public class Employee_ViewBookings {

	JFrame f15;
	JTable t1;
	JScrollPane tableContainer;
	Employee_Handler eH;
	Employee_ViewBookings() {
		
		f15 = new JFrame("Reservations");
		f15.setLayout(new FlowLayout());
		//connect to database
		String columns[] = {"Booking ID", "Flight ID", "Customer Name", "Customer ID", "Contact", "# of Passengers"};
		eH = new Employee_Handler();
		
		ArrayList<String[]> ar = getBookings();
    	String data[][]=new String[ar.size()][6];
    	for(int i = 0; i<ar.size(); i++) {
    		data[i]= ar.get(i);
    		
    	}
		if(data[0]==null) {
			JOptionPane.showMessageDialog(null, "Unable to Extract Booking Table",
			"ERROR", JOptionPane.ERROR_MESSAGE);	
		}
		else {
			try{
		    t1 = new JTable(data, columns);
		    t1.setPreferredScrollableViewportSize(new Dimension(800, 200));
		    t1.setFillsViewportHeight(true);
		    
		    tableContainer = new JScrollPane(t1);
			f15.getContentPane().add(tableContainer, BorderLayout.CENTER);
			
		    f15.setSize(600, 600);
		    f15.setLocation((1366-600)/2, (768-600)/2);
		    f15.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    f15.pack();
		    f15.setVisible(true);
			}catch(Exception e) {
				
			}
		}
	}

	private ArrayList<String[]> getBookings() 
	{
		// TODO Auto-generated method stub
		ArrayList<String[]> ar = new ArrayList<String[]>(30);
		ar = eH.getAllActiveBookings();
//		for (int i=0; i<ar.size(); i++) {
//			for (int j=0; j<ar.get(i).length; j++) {
//				System.out.println("+"+ar.get(i)[j]);
//			}
//		}
		return ar;
	}
}
