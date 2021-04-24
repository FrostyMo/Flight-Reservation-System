package mainPackage.ApplicationLayer;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import mainPackage.BusinessLayer.Admin_Handler;
import mainPackage.BusinessLayer.Customer_Handler;

public class Admin_UpdateBooking {
	private static final String NullPointerException = null;
	JFrame f9;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
	
	JTextField l2Input, l3Input, l4Input, l5Input, l6Input, l7Input, l8Input, l10Input, l9Input;
	JComboBox<String> listFlightID, listMeal, listSeat, listClass, listCheckin;
	JButton b1, b2, b3;
	private String flightID;
	private String PlaneID;
	private String RouteID;
	private String from;
	private String to;
	private String deptTime;
	private String arvTime;
	private String Date;
	private String Baseamount;
	private String arrivalStatus;
	Admin_Handler flightObj;
	public  Admin_UpdateBooking () {
		f9 = new JFrame("Update Flight");
		l1 = new JLabel("Select Flight ID : ");
		l2 = new JLabel("Plane ID : ");
		l3 = new JLabel("RouteID : ");
		l4 = new JLabel("From : ");
		l5 = new JLabel("To : ");
		l6 = new JLabel("DepartureTime: ");
		l7 = new JLabel("ArrivalTime: ");
		l8 = new JLabel("Date : ");
		l9 = new JLabel("Base Amount : ");
		l10 = new JLabel("Arrival Status: ");
//		String ar1[]={"", "Opt1", "Opt2", "Opt3", "Opt4"};
//		String ar2[]= {"", "1", "2", "3", "4"};
//		String ar3[]= {"", "Economy", "Business"};
//		String ar4[] = {"", "Yes", "No"};
		
		l2Input = new JTextField();
		l3Input = new JTextField();
		l4Input = new JTextField();
		l5Input = new JTextField();
		l6Input = new JTextField();
		l7Input = new JTextField();
		l8Input = new JTextField();
		l10Input = new JTextField();
		l9Input = new JTextField();
		listFlightID = new JComboBox<String>();
		//listPassengerID = new JComboBox<String>();
		//b1 = new JButton("Cancel Booking");
		b2 = new JButton("Update Booking");
		b3 = new JButton("Cancel");
		flightObj = new Admin_Handler();
		
		l1.setBounds(30, 40, 150, 30);		// Flight ID 	
		l2.setBounds(30, 90, 150, 30);		// PLANE ID
		l3.setBounds(30, 140, 150, 30);		// ROUTE ID
		l4.setBounds(30, 190, 150, 30);		// SOURCE
		l5.setBounds(30, 240, 150, 30);		// DESTINATION 
		l6.setBounds(30, 290, 150, 30);		// DEPT TIME
		l7.setBounds(30, 340, 150, 30);		// ARRIVAL TIME
		l8.setBounds(30, 390, 150, 30);		// DATE
		l9.setBounds(30, 440, 150, 30);		// BASE AMOUNT
		l10.setBounds(30, 490, 150, 30);	// ARRRIVAL STATUS
		//l11.setBounds(30, 540, 150, 30);	// CHECK IN		** WILL BE A LIST **
		
		listFlightID.setBounds(220, 40, 200, 30);
		l2Input.setBounds(220, 90, 200, 30);
		l3Input.setBounds(220, 140, 200, 30);
		l4Input.setBounds(220, 190, 200, 30);
		l5Input.setBounds(220, 240, 200, 30);
		l6Input.setBounds(220, 290, 200, 30);
		l7Input.setBounds(220, 340, 200, 30);
		l8Input.setBounds(220, 390, 200, 30);
		l9Input.setBounds(220, 440, 200, 30);
		l10Input.setBounds(220, 490, 200, 30);
		//listCheckin.setBounds(220, 540, 200, 30);
		
		System.out.println("Imhere hi");
		//b1.setBounds(40, 640, 150, 30);
		b2.setBounds(240, 640, 150, 30);
		b3.setBounds(440, 640, 150, 30);
		
		getFlights();
		f9.add(l1);
		f9.add(l2);
		f9.add(l3);
		f9.add(l4);
		f9.add(l5);
		f9.add(l6);
		f9.add(l7);
		f9.add(l8);
		f9.add(l9);
		f9.add(l10);
		f9.add(l2Input);
		f9.add(l3Input);
		f9.add(l4Input);
		f9.add(l6Input);
		f9.add(l9Input);
		f9.add(listFlightID);
		f9.add(l5Input);
		f9.add(l7Input);
		f9.add(l8Input);
		f9.add(l10Input);
		f9.add(b2);
		f9.add(b3);
		System.out.println("Imhere hi2");
		l2Input.setBackground(Employee_HomePage.myblue);
		l3Input.setBackground(Employee_HomePage.myblue);
		l4Input.setBackground(Employee_HomePage.myblue);
		l5Input.setBackground(Employee_HomePage.myblue);
		l10Input.setBackground(Employee_HomePage.myblue);
		System.out.println("Imhere hi3");
		l2Input.setForeground(Color.WHITE);
		l3Input.setForeground(Color.WHITE);
		l4Input.setForeground(Color.WHITE);
		l5Input.setForeground(Color.WHITE);
		l10Input.setForeground(Color.WHITE);
//		l2Input.setOpaque(true);
//		l3Input.setOpaque(true);
//		l4Input.setOpaque(true);
//		l6Input.setOpaque(true);
//		l9Input.setOpaque(true);
//		
		System.out.println("Imhere hi4");
		f9.setLayout(null);
		f9.setSize(600, 700);
		f9.setLocation((1366-600)/2, (768-600)/2);
		f9.setVisible(true);
		f9.setResizable(false);
		f9.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		System.out.println("Imhere hi5");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				if(listFlightID.getSelectedIndex()>0 && validateForm()) {
					if(updateRecord()) {
						JOptionPane.showMessageDialog(f9, "Booking Updated");
						f9.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(f9, "Error",
						"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(f9, 
					"Please Enter Complete Information ", "Invalid", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		System.out.println("Imhere hi6");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				f9.setVisible(false);
				//new AdminLogin();
			}
		});
		System.out.println("Imhere hi7");
		listFlightID.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				WelcomeScreenAndLogin.buttonSound();
				// TODO Auto-generated method stub
				//System.out.println(listBookingID.getSelectedIndex());
				if(listFlightID.getSelectedItem()!="" && arg0.getStateChange() == ItemEvent.SELECTED) {
					initializeDetails();
				}
				else {
					clearLabels();
				}
			}
			
		});
		
		System.out.println("Imhere hi8");
		
		b2.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b2.setBorderPainted(false);
				b2.setOpaque(true);
				b2.setBackground(Admin_HomePage.myred);
				b2.setForeground(Color.WHITE);
				b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b2.setBorderPainted(true);
				b2.setBackground(Color.WHITE);
				b2.setForeground(Color.BLACK);
				b2.setCursor(null);
				b2.setOpaque(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		b3.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b3.setBorderPainted(false);
				b3.setOpaque(true);
				b3.setBackground(Admin_HomePage.myred);
				b3.setForeground(Color.WHITE);
				b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b3.setBorderPainted(true);
				b3.setBackground(Color.WHITE);
				b3.setForeground(Color.BLACK);
				b3.setCursor(null);
				b3.setOpaque(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}//end constructor
	
	// GET ALL THE FLIGHT IDs IN A LIST
		private void getFlights() 
		{
			listFlightID.addItem("");
			String[] flighIDs = flightObj.getAllFlightIDs();
			for (int i=0; i<flighIDs.length; i++) {
				if (flighIDs[i]!="" && flighIDs[i]!=NullPointerException) {
					System.out.println(flighIDs[i]);
					listFlightID.addItem(flighIDs[i]);
				}
			}
			
		}
		protected void setInfoLabels() {
			// TODO Auto-generated method stub
			clearLabels();
			l2Input.setText(PlaneID);
			l3Input.setText(RouteID);
			l4Input.setText(from);
			l5Input.setText(to);
			l10Input.setText("0");
		}
		protected void initializeDetails() 
		{

			flightID = (String) listFlightID.getSelectedItem();
			from = flightObj.getSource(flightID);
			to = flightObj.getDest(flightID);
			PlaneID = flightObj.getPlaneName(flightID);
			RouteID = flightObj.getRouteID(flightID);
			//deptTime = flightObj.getDeptTime(flightID);
			//arvTime = flightObj.getArrivalTime(flightID);
		//	Date = flightObj.getDate(flightID);
		//	Baseamount = flightObj.getBaseAmount(flightID);
		//	arrivalStatus = flightObj.getArrivalStatus(flightID);
			setInfoLabels();
			
		}
		private void clearLabels() {
			l3Input.setText("");
			l4Input.setText("");
			l2Input.setText("");
			l6Input.setText("");
			l9Input.setText("");
		}
		protected boolean updateRecord() {
			deptTime = l6Input.getText();
			arvTime = l7Input.getText();
			Date = l8Input.getText();
			Baseamount = l9Input.getText();
			return flightObj.UpdateFlight(flightID, deptTime, arvTime, Date, Baseamount,from, to);
		}
		
		private boolean validateForm() {
			// TODO Auto-generated method stub
			if((((String)listFlightID.getSelectedItem()).length())==0||
					(l2Input.getText().length())==0||
				(l3Input.getText().length())==0||(l4Input.getText().length())==0
					||(l5Input.getText().length())==0||(l6Input.getText().length())==0||
							(l7Input.getText().length())==0||(l8Input.getText().length())==0||
									(l10Input.getText().length())==0||(l9Input.getText().length())==0)
				return false;
			else
				return true;
		}
	
}
