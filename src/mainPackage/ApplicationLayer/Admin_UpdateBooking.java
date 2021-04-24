package mainPackage.ApplicationLayer;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import mainPackage.BusinessLayer.Admin_Handler;
import mainPackage.BusinessLayer.Customer_Handler;

public class Admin_UpdateBooking {
	private static final String NullPointerException = null;
	JFrame f9;
	JPanel myPanel;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
	JLabel formatDeptTime, formatArrTime, formatDate, formatPrice;
	JTextField l2Input, l3Input, l4Input, l5Input, l6Input, l7Input, l8Input, l10Input, l9Input;
	JComboBox<String> listFlightID, listMeal, listSeat, listClass, listCheckin;
	JButton b1, b2, b3;
	private String flightID;
	private String PlaneID;
	private String RouteID;
	private String from;
	private String to;
	private String deptTime, deptTimeCopy;
	private String arvTime, arvTimeCopy;
	private String Date, DateCopy;
	private String Baseamount, BaseamountCopy;
	private String arrivalStatus, arrivalStatusCopy;
	Admin_Handler flightObj;
	public  Admin_UpdateBooking () {
		f9 = new JFrame("Update Flight");
		l1 = new JLabel("<html><span style='size: 14'><b>Select Flight ID : </b></span></html>");
		l2 = new JLabel("<html><span style='size: 14'><b>Plane ID : </b></span></html>");
		l3 = new JLabel("<html><span style='size: 14'><b>RouteID : </b></span></html>");
		l4 = new JLabel("<html><span style='size: 14'><b>From : </b></span></html>");
		l5 = new JLabel("<html><span style='size: 14'><b>To : </b></span></html>");
		l6 = new JLabel("<html><span style='size: 14'><b>DepartureTime: </b></span></html>");
		l7 = new JLabel("<html><span style='size: 14'><b>ArrivalTime: </b></span></html>");
		l8 = new JLabel("<html><span style='size: 14'><b>Date : </b></span></html>");
		l9 = new JLabel("<html><span style='size: 14'><b>Base Amount : </b></span></html>");
		l10 = new JLabel("<html><span style='size: 14'><b>Arrival Status: </b></span></html>");
		
		
		myPanel = Admin_HomePage.adminPanel();
		myPanel.setLayout(null);
		f9.getContentPane().setBackground(new Color(0,0,0,0));
		//// Format validation
		formatDeptTime = new JLabel("Correct format is 00:00");
		formatArrTime = new JLabel("Correct format is 00:00");
		formatDate = new JLabel("Correct format is DD/MM/YYYY");
		formatPrice = new JLabel("Must be Numerical only");

		
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
		
		l1.setForeground(Admin_SignUp.mypurp);		// Flight ID 	
		l2.setForeground(Admin_SignUp.mypurp);	// PLANE ID
		l3.setForeground(Admin_SignUp.mypurp);	// ROUTE ID
		l4.setForeground(Admin_SignUp.mypurp);		// SOURCE
		l5.setForeground(Admin_SignUp.mypurp);		// DESTINATION 
		l6.setForeground(Admin_SignUp.mypurp);		// DEPT TIME
		l7.setForeground(Admin_SignUp.mypurp);		// ARRIVAL TIME
		l8.setForeground(Admin_SignUp.mypurp);		// DATE
		l9.setForeground(Admin_SignUp.mypurp);		// BASE AMOUNT
		l10.setForeground(Admin_SignUp.mypurp);	// ARRRIVAL STATUS
		//l11.setBounds(30, 540, 150, 30);	// CHECK IN		** WILL BE A LIST **
		
		listFlightID.setBounds(220, 40, 200, 30);
		l2Input.setBounds(220, 90, 200, 30);
		l3Input.setBounds(220, 140, 200, 30);
		l4Input.setBounds(220, 190, 200, 30);
		l5Input.setBounds(220, 240, 200, 30);
		l6Input.setBounds(220, 290, 200, 30);	// DEPT TIME
		l7Input.setBounds(220, 340, 200, 30);
		l8Input.setBounds(220, 390, 200, 30);
		l9Input.setBounds(220, 440, 200, 30);	// BASE AMOUNT
		l10Input.setBounds(220, 490, 200, 30);
		//listCheckin.setBounds(220, 540, 200, 30);
		
		//// Formating validations 
		formatDeptTime.setBounds(220, 322, 200, 15);
		formatArrTime.setBounds(220, 372, 200, 15);
		formatDate.setBounds(220, 422, 200, 15);
		formatPrice.setBounds(220, 472, 200, 15);
		
		formatDeptTime.setFont(Admin_SignUp.ERRORFORMAT);
		formatArrTime.setFont(Admin_SignUp.ERRORFORMAT);
		formatDate.setFont(Admin_SignUp.ERRORFORMAT);
		formatPrice.setFont(Admin_SignUp.ERRORFORMAT);
		
//		formatDeptTime.setForeground(Color.RED);
//		formatArrTime.setForeground(Color.RED);
//		formatDate.setForeground(Color.RED);
//		formatPrice.setForeground(Color.RED);
		
		formatDeptTime.setVisible(false);
		formatArrTime.setVisible(false);
		formatDate.setVisible(false);
		formatPrice.setVisible(false);
		
		////
		
		System.out.println("Imhere hi");
		//b1.setBounds(40, 640, 150, 30);
		b2.setBounds(120, 550, 150, 30);
		b3.setBounds(340, 550, 150, 30);
		
		getFlights();
		myPanel.add(l1);
		myPanel.add(l2);
		myPanel.add(l3);
		myPanel.add(l4);
		myPanel.add(l5);
		myPanel.add(l6);
		myPanel.add(l7);
		myPanel.add(l8);
		myPanel.add(l9);
		myPanel.add(l10);
		myPanel.add(l2Input);
		myPanel.add(l3Input);
		myPanel.add(l4Input);
		myPanel.add(l6Input);
		myPanel.add(l9Input);
		myPanel.add(listFlightID);
		myPanel.add(l5Input);
		myPanel.add(l7Input);
		myPanel.add(l8Input);
		myPanel.add(l10Input);
		myPanel.add(b2);
		myPanel.add(b3);
		
		//// Format validations
		myPanel.add(formatDeptTime);
		myPanel.add(formatArrTime);
		myPanel.add(formatDate);
		myPanel.add(formatPrice);
		
		System.out.println("Imhere hi2");
		l2Input.setBackground(Admin_SignUp.mypurp);
		l3Input.setBackground(Admin_SignUp.mypurp);
		l4Input.setBackground(Admin_SignUp.mypurp);
		l5Input.setBackground(Admin_SignUp.mypurp);
		l10Input.setBackground(Admin_SignUp.mypurp);
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
		
		System.out.println("Imhere hi4");
		f9.setLayout(null);
		f9.setPreferredSize(new Dimension(600,620));
		f9.setLocation((1366-600)/2, (768-600)/2);
		//f9.setResizable(false);
		f9.setContentPane(myPanel);
		f9.pack();
		f9.setVisible(true);
		
		f9.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//f9.getContentPane().setBackground(new Color(107, 0, 179));
		
		System.out.println("Imhere hi5");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				if(listFlightID.getSelectedIndex()>0 && validateForm()) {
					if(updateRecord() == 1) {
						JOptionPane.showMessageDialog(f9, "Flight Updated");
						f9.setVisible(false);
					}
					else if (updateRecord() == 2){
						JOptionPane.showMessageDialog(f9, "All data is Same!",
						"ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if (updateRecord() == 3){
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
			l6Input.setText(deptTime);
			l7Input.setText(arvTime);
			l8Input.setText(Date);
			l9Input.setText(Baseamount);
			l10Input.setText(arrivalStatus);
		}
		protected void initializeDetails() 
		{

			flightID = (String) listFlightID.getSelectedItem();
			from = flightObj.getSource(flightID);
			to = flightObj.getDest(flightID);
			PlaneID = flightObj.getPlaneName(flightID);
			RouteID = flightObj.getRouteID(flightID);
			deptTime = flightObj.getDeptTime(flightID);
			arvTime = flightObj.getArrivalTime(flightID);
			Date = flightObj.getDate(flightID);
			Baseamount = flightObj.getBaseAmount(flightID);
			arrivalStatus = flightObj.getArrivalStatus(flightID);
			deptTimeCopy = deptTime;
			arvTimeCopy = arvTime;
			DateCopy = Date;
			BaseamountCopy = Baseamount;
			setInfoLabels();
			
		}
		private void clearLabels() {
			l3Input.setText("");
			l4Input.setText("");
			l2Input.setText("");
			l6Input.setText("");
			l9Input.setText("");
		}
		
		protected boolean parseData() {
			boolean successful = true;
			// parse departure time
			try {
		        LocalTime.parse(deptTime);
		        System.out.println("Valid time string: " + deptTime);
		        formatDeptTime.setVisible(false);
		        l6Input.setBorder(null);
		    } catch (Exception e) {
		    	formatDeptTime.setVisible(true);
		        System.out.println("Invalid time string: " + deptTime);
		        Border border = BorderFactory.createLineBorder(Color.RED,2);
				l6Input.setBorder(border);
				successful = false;
		    }
			// parse arrival time
			try {
		        LocalTime.parse(arvTime);
		        System.out.println("Valid time string: " + arvTime);
		        formatArrTime.setVisible(false);
		        l7Input.setBorder(null);
		    } catch (Exception e) {
		    	formatArrTime.setVisible(true);
		        System.out.println("Invalid time string: " + deptTime);
		        Border border = BorderFactory.createLineBorder(Color.RED,2);
				l7Input.setBorder(border);
				successful = false;
		    }
			
			// parse date
			try {
			    DateTimeFormatter formatter =
			                      DateTimeFormatter.ofPattern("dd/MM/yyyy");
			    LocalDate date = LocalDate.parse(Date, formatter);
			    System.out.printf("%s%n", date);
			    formatDate.setVisible(false);
				l8Input.setBorder(null);
			}
			catch (DateTimeParseException exc) {
			    System.out.printf("%s is not parsable!%n", Date);
			    formatDate.setVisible(true);
				Border border = BorderFactory.createLineBorder(Color.RED,2);
				l8Input.setBorder(border);
				successful = false;
			    
			}
			
			// parse price
			try {
				Integer.parseInt(Baseamount);
				formatPrice.setVisible(false);
				l9Input.setBorder(null);
			}
			catch (Exception e) {
				formatPrice.setVisible(true);
				Border border = BorderFactory.createLineBorder(Color.RED,2);
				l9Input.setBorder(border);
				successful = false;
			}
			return successful;
		}
		
		// Update the record after parsing and validating
		protected int updateRecord() {
			deptTime = l6Input.getText();
			arvTime = l7Input.getText();
			Date = l8Input.getText();
			Baseamount = l9Input.getText();
			
			// parse unsuccessful, return false
			if (!parseData())
				return 0;
			
			// No change in data
			if (deptTime.equals(deptTimeCopy) && arvTime.equals(arvTimeCopy) && Date.equals(DateCopy) && Baseamount.equals(BaseamountCopy))
				return 2;
			
			// Try updating
			else if (flightObj.UpdateFlight(flightID, deptTime, arvTime, Date, Baseamount,from, to))
				return 1;
			return 0;
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
