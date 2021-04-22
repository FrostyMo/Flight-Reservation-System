package mainPackage.ApplicationLayer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import mainPackage.BusinessLayer.Admin_Handler;

public class Admin_ViewFlights {

	JFrame f10;
	JTable t1;
	JScrollPane tableContainer;
	Admin_Handler flightObj = new Admin_Handler();
	
	Admin_ViewFlights() {
		
		f10 = new JFrame("Flights Details");
		f10.setLayout(new FlowLayout());
		//connect to database
		String columns[] = {"Flight ID", "Plane ID", 
				"FROM", "TO", "Departure Time",  "Arrival Time", "Date", "Base Amount", "Total Seats", "Available Seats", "Arrival Status"};
		
		ArrayList<String[]> ar = getData();
    	String data[][] = new String[ar.size()][11];
    	for(int i = 0; i<ar.size(); i++) {
    		data[i]= ar.get(i);
    		
    	}
		
    	if(data[0]==null) {
			JOptionPane.showMessageDialog(null, "Unable to Extract Employee Table",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else {
			System.out.println("I AM IN HERE++++++");
		    t1 = new JTable(data, columns);
		    
		    t1.setPreferredScrollableViewportSize(new Dimension(1200, 200));
		    t1.setFillsViewportHeight(true);
		    
		    tableContainer = new JScrollPane(t1);
			f10.getContentPane().add(tableContainer, BorderLayout.CENTER);
			
		    f10.setSize(600, 600);
		    f10.setLocation((1366-600)/2, (768-600)/2);
		    f10.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    //panel.add(tableContainer, BorderLayout.CENTER);
		    f10.pack();
		    f10.setVisible(true);
		}
	}

	private ArrayList<String[]> getData() 
	{
		// TODO Auto-generated method stub
		ArrayList<String[]> ar = new ArrayList<String[]>();
		
		ar = flightObj.ViewSched();
		
		return ar;
	}
}
