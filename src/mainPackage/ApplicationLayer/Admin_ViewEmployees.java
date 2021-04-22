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

public class Admin_ViewEmployees {

	JFrame f7;
	JTable t1;
	JScrollPane tableContainer;
	ArrayList<String[]> ar;
	Admin_Handler aH;
	Admin_ViewEmployees() {
		aH = new Admin_Handler();
		f7 = new JFrame("Employee Details");
		f7.setLayout(new FlowLayout());
		//connect to database
		String columns[] = {"Employee ID", "Name", "Password", "Age", "Address", "Join Date", "Phone No"};
		getData();
		
		String data[][]=new String[ar.size()][7];
		for(int i = 0; i<ar.size(); i++) {
    		data[i]= ar.get(i);	
    	}
    	
		if(data.length == 0) {
			JOptionPane.showMessageDialog(null, "Unable to Extract Employee Table",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			
		}
		else {
			try{
		    t1 = new JTable(data, columns);
		    t1.setPreferredScrollableViewportSize(new Dimension(800, 200));
		    t1.setFillsViewportHeight(true);
		    
		    tableContainer = new JScrollPane(t1);
			f7.getContentPane().add(tableContainer, BorderLayout.CENTER);
			
		    f7.setSize(700, 700);
		    f7.setLocation((1366-600)/2, (768-600)/2);
		    f7.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    //panel.add(tableContainer, BorderLayout.CENTER);
		    f7.pack();
		    f7.setVisible(true);
			}catch(Exception e) {
				
			}
		}
	}

	private void getData() 
	{	
		ar = new ArrayList<String[]>();
		ar = aH.EmployeeList();
		
	}
}