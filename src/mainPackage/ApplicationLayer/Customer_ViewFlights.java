package mainPackage.ApplicationLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


import mainPackage.BusinessLayer.Customer_Handler;


public class Customer_ViewFlights {
	JFrame f10;
	JTable t1 = new JTable(new DefaultTableModel());
	JScrollPane tableContainer;
	Customer_Handler flightObj = new Customer_Handler();
	String columns[], FlightID;
	JComboBox<String> sortList;
	//Customer_BookFlight Object_Bf;
	String userName;
	

	Customer_ViewFlights(String uName, String none) {
		userName = uName;
		FlightID = "";
		String sorters[] = {"Flight ID", "Source", "Destination", "Date"};
		sortList = new JComboBox<String>(sorters);
		f10 = new JFrame("Flights Details");
		f10.setLayout(new FlowLayout());
		
		//connect to database
		String columns1[] = {"Flight ID", "FROM", "TO", "Departure Time",  "Arrival Time", "Date", "Base Amount"};
		columns = columns1;
		if (none.equals("NONE")) {
			f10.add(sortList);
			Check_Flight();
		}
	}
	
	protected boolean Check_Flight() {
		sortList.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				WelcomeScreenAndLogin.buttonSound();
				// TODO Auto-generated method stub
				if (sortList.getSelectedItem() == "Flight ID")
					DrawTable("FLIGHT_ID");
				else if (sortList.getSelectedItem() == "Source")
					DrawTable("SRC");
				else if (sortList.getSelectedItem() == "Destination")
					DrawTable("DESTINATION");
				else if (sortList.getSelectedItem() == "Date")
					DrawTable("FLIGHT_DATE");
			}
			
		});
//			Check_Flight();
		ArrayList<String[]> ar = getData("FLIGHT_ID");
    	String data[][] = new String[ar.size()][7];
    	for(int i = 0; i<ar.size(); i++) {
    		data[i]= ar.get(i);
    		
    	}
		
    	if(data[0]==null) {
			JOptionPane.showMessageDialog(null, "Unable to Extract Flight Table",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else {
			System.out.println("I AM IN HERE++++++");
		    t1 = new JTable(data, columns);
		    t1.setPreferredScrollableViewportSize(new Dimension(1000, 200));
		    t1.setFillsViewportHeight(true);
		    t1.setBackground(new Color(0,102,102));
		    t1.setForeground(Color.WHITE);
		    t1.setOpaque(true);
		    t1.setGridColor(new Color(0,102,102));
		    
		    tableContainer = new JScrollPane(t1);
			f10.getContentPane().add(tableContainer, BorderLayout.CENTER);
			
		    f10.setSize(600, 600);
		    f10.setLocation((1366-600)/2, (768-600)/2);
		    f10.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    //panel.add(tableContainer, BorderLayout.CENTER);
		    f10.pack();
		    f10.setVisible(true);
		}
    	
		return true;
	}
	
	protected String Check_Flight(String from, String to, String date, String passengers, String classType) {
		
		String sorters[] = {"Flight ID", "Source", "Destination", "Date"};
		sortList = new JComboBox<String>(sorters);
		
		ArrayList<String[]> ar = getData(from, to, date, passengers, classType);
		String data[][] = new String[ar.size()][7];
		for(int i = 0; i<ar.size(); i++) {
			data[i]= ar.get(i);
			
		}
		
		if(data.length==0) {
			JOptionPane.showMessageDialog(null, "Unable to Extract Flights Table, None Available",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else {
			System.out.println("I AM IN HERE++++++");
		    t1 = new JTable(data, columns);
		    t1.setPreferredScrollableViewportSize(new Dimension(1000, 200));
		    t1.setFillsViewportHeight(true);
		    t1.setBackground(new Color(0,102,102));
		    t1.setForeground(Color.WHITE);
		    t1.setOpaque(true);
		    t1.setGridColor(new Color(0,102,102));
		    
		    tableContainer = new JScrollPane(t1);
		    f10.add(sortList);
			f10.getContentPane().add(tableContainer, BorderLayout.CENTER);
			
		    f10.setSize(600, 600);
		    f10.setLocation((1366-600)/2, (768-600)/2);
		    f10.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    //panel.add(tableContainer, BorderLayout.CENTER);
		    f10.pack();
		    f10.setVisible(true);
		}
		sortList.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				WelcomeScreenAndLogin.buttonSound();
				// TODO Auto-generated method stub
				if (sortList.getSelectedItem() == "Flight ID")
					DrawTable("FLIGHT_ID");
				else if (sortList.getSelectedItem() == "Source")
					DrawTable("SRC");
				else if (sortList.getSelectedItem() == "Destination")
					DrawTable("DESTINATION");
				else if (sortList.getSelectedItem() == "Date")
					DrawTable("FLIGHT_DATE");
			}
			
		});
    	
		t1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    	    @Override
    	    public void valueChanged(ListSelectionEvent event) {
    	    	WelcomeScreenAndLogin.buttonSound();
    	        if (t1.getSelectedRow() > -1) {
    	            // print first column value from selected row
    	            System.out.println(t1.getValueAt(t1.getSelectedRow(), 0).toString());
    	            System.out.println(t1.getValueAt(t1.getSelectedRow(), 1).toString());
    	            System.out.println(t1.getValueAt(t1.getSelectedRow(), 2).toString());
    	            FlightID = (t1.getValueAt(t1.getSelectedRow(), 0).toString());
    	            
    	            
    	            
    	            int result = JOptionPane.showConfirmDialog(f10,"Do you want to Book this Flight?", "CONFIRMATION", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    	                 if(result == JOptionPane.YES_OPTION){
    	                    f10.setVisible(false);
    	                    new Customer_PassengerDetails(Integer.parseInt(passengers), flightObj.AddBooking(FlightID, passengers,userName));
    	                 }else if (result == JOptionPane.NO_OPTION){
    	                	 
    	                 }
    	        }
    	    }
    	});
		
		return FlightID;
	}
	
	private ArrayList<String[]> getData(String from, String to, String date, String passengers, String classType){
		ArrayList<String[]> ar = new ArrayList<String[]>();
		ar = flightObj.ViewSched(from, to, date, passengers, classType);
		if (ar.size()<=0) {
			JOptionPane.showMessageDialog(null, "No Flight Available for Specified Date, Showing all Source to Destination Flights",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			ar = flightObj.ViewSched(from, to, "%", passengers, classType);
		}
		return ar;
	}
	
	
	private void DrawTable(String choiceOfSort) {
		
		ArrayList<String[]> ar = getData(choiceOfSort);
    	String data[][] = new String[ar.size()][11];
    	for(int i = 0; i<ar.size(); i++) {
    		data[i]= ar.get(i);
    		
    	}
		
    	if(data[0]==null) {
			JOptionPane.showMessageDialog(null, "Unable to Extract the Flights",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else {
			Component[] components = f10.getContentPane().getComponents();
		    for (Component component : components) {
		        if (component instanceof JScrollPane || component instanceof JTable) {
		            f10.remove(component);
		        }
		    }
			
			System.out.println("I AM IN HERE++++++");
		    t1 = new JTable(data, columns);
		    
		    t1.setPreferredScrollableViewportSize(new Dimension(1000, 200));
		    t1.setFillsViewportHeight(true);
		    t1.setBackground(new Color(0,102,102));
		    t1.setForeground(Color.WHITE);
		    t1.setOpaque(true);
		    
		    t1.setGridColor(new Color(0,102,102));
		    
		    
		    tableContainer = new JScrollPane(t1);
		    
		    //f10.add(sortList);
			f10.getContentPane().add(tableContainer, BorderLayout.CENTER);
			
			
			f10.invalidate();
			f10.validate();
			f10.repaint();
		}
	}

	private ArrayList<String[]> getData(String choice) 
	{
		// TODO Auto-generated method stub
		ArrayList<String[]> ar = new ArrayList<String[]>();
		
		ar = flightObj.ViewSched(choice);
		
		return ar;
	}
	
	
}
