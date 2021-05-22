package mainPackage.ApplicationLayer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mainPackage.BusinessLayer.Customer_Handler;

public class Customer_UpdateBooking {
	JFrame f9;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
	JPanel myPanel;
	JTextField l2Input, l3Input, l4Input, l6Input, l9Input;
	JComboBox<String> listBookingID, listPassengerID, listMeal, listSeat, listClass, listCheckin;
	JButton b1, b2, b3;
	private String flightID;
	private String bookingID;
	private String passID;
	private String PassengerName;
	private String Meal;
	private String Seat;
	private String Luggage;
	private String Class;
	private String Checkin;
	private String from;
	private String to;
	String userName;
	Customer_Handler flightObj;
	
	public Customer_UpdateBooking(String user) {
		userName = user;
		f9 = new JFrame("Update or Cancel Booking");
		l1 = new JLabel("Select Booking ID : ");
		l2 = new JLabel("Flight ID : ");
		l3 = new JLabel("From : ");
		l4 = new JLabel("To : ");
		l5 = new JLabel("Select Passenger ID : ");
		l6 = new JLabel("Name : ");
		l7 = new JLabel("Meal Option : ");
		l8 = new JLabel("Seat Option : ");
		l9 = new JLabel("Luggage : ");
		l10 = new JLabel("Class : ");
		l11 = new JLabel("Check In: ");
		String ar1[]={"", "Opt1", "Opt2", "Opt3", "Opt4"};
		String ar2[]= {"", "1", "2", "3", "4"};
		String ar3[]= {"", "Economy", "Business"};
		String ar4[] = {"", "Yes", "No"};
		
		myPanel = Customer_HomePage.customerPanel();
		myPanel.setLayout(null);
		f9.getContentPane().setBackground(new Color(0,0,0,0));
		
		l2Input = new JTextField();
		l3Input = new JTextField();
		l4Input = new JTextField();
		l6Input = new JTextField();
		l9Input = new JTextField();
		listBookingID = new JComboBox<String>();
		listPassengerID = new JComboBox<String>();
		listMeal = new JComboBox<String>(ar1);
		listSeat = new JComboBox<String>(ar2);
		listClass = new JComboBox<String>(ar3);
		listCheckin = new JComboBox<String>(ar4);
		b1 = new JButton("Cancel Booking");
		b2 = new JButton("Update Booking");
		b3 = new JButton("Cancel");
		flightObj = new Customer_Handler();
		
		
		
		l1.setBounds(30, 40, 200, 30);		// BOOKING ID 	** WILL BE A LIST **
		l2.setBounds(30, 90, 150, 30);		// FLIGHT ID
		l3.setBounds(30, 140, 150, 30);		// SOURCE
		l4.setBounds(30, 190, 150, 30);		// DESTINATION
		l5.setBounds(30, 240, 200, 30);		// PASSENGER ID ** WILL BE A LIST **
		l6.setBounds(30, 290, 150, 30);		// NAME
		l7.setBounds(30, 340, 150, 30);		// MEAL OPT		** WILL BE A LIST **
		l8.setBounds(30, 390, 150, 30);		// SEAT OPT		** WILL BE A LIST **
		l9.setBounds(30, 440, 150, 30);		// LUGGAGE
		l10.setBounds(30, 490, 150, 30);	// CLASS		** WILL BE A LIST **
		l11.setBounds(30, 540, 150, 30);	// CHECK IN		** WILL BE A LIST **
		
		l1.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l2.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l3.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l4.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l5.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l6.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l7.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l8.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l9.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l10.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l11.setFont(WelcomeScreenAndLogin.WHITELABEL);
		
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		l4.setForeground(Color.WHITE);
		l5.setForeground(Color.WHITE);
		l6.setForeground(Color.WHITE);
		l7.setForeground(Color.WHITE);
		l8.setForeground(Color.WHITE);
		l9.setForeground(Color.WHITE);
		l10.setForeground(Color.WHITE);
		l11.setForeground(Color.WHITE);
		
		
		listBookingID.setBounds(270, 40, 220, 30);
		l2Input.setBounds(270, 90, 200, 30);
		l3Input.setBounds(270, 140, 200, 30);
		l4Input.setBounds(270, 190, 200, 30);
		listPassengerID.setBounds(270, 240, 220, 30);
		l6Input.setBounds(270, 290, 200, 30);
		listMeal.setBounds(270, 340, 220, 30);
		listSeat.setBounds(270, 390, 220, 30);
		l9Input.setBounds(270, 440, 200, 30);
		listClass.setBounds(270, 490, 220, 30);
		listCheckin.setBounds(270, 540, 220, 30);
		
		l2Input.setHorizontalAlignment(SwingConstants.CENTER);
		l2Input.setAlignmentY(SwingConstants.CENTER);
		l3Input.setHorizontalAlignment(SwingConstants.CENTER);
		l3Input.setAlignmentY(SwingConstants.CENTER);
		l4Input.setHorizontalAlignment(SwingConstants.CENTER);
		l4Input.setAlignmentY(SwingConstants.CENTER);
		l6Input.setHorizontalAlignment(SwingConstants.CENTER);
		l6Input.setAlignmentY(SwingConstants.CENTER);
		l9Input.setHorizontalAlignment(SwingConstants.CENTER);
		l9Input.setAlignmentY(SwingConstants.CENTER);
		DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
	    listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
	    listBookingID.setRenderer(listRenderer);
	    listPassengerID.setRenderer(listRenderer);
	    listMeal.setRenderer(listRenderer);
	    listSeat.setRenderer(listRenderer);
	    listClass.setRenderer(listRenderer);
	    listCheckin.setRenderer(listRenderer);
	    
		
		b1.setBounds(40, 600, 150, 30);
		b2.setBounds(240, 600, 150, 30);
		b3.setBounds(440, 600, 150, 30);
		
		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		
		b1.setOpaque(true);
		b2.setOpaque(true);
		b2.setOpaque(true);
		
		b1.setFocusable(false);
		b2.setFocusable(false);
		b2.setFocusable(false);
		
		getBookings();
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
		myPanel.add(l11);
		myPanel.add(l2Input);
		myPanel.add(l3Input);
		myPanel.add(l4Input);
		myPanel.add(l6Input);
		myPanel.add(l9Input);
		myPanel.add(listBookingID);
		myPanel.add(listPassengerID);
		myPanel.add(listMeal);
		myPanel.add(listSeat);
		myPanel.add(listClass);
		myPanel.add(listCheckin);
		myPanel.add(b1);
		myPanel.add(b2);
		myPanel.add(b3);
		
		l2Input.setBackground(Employee_HomePage.myblue);
		l3Input.setBackground(Employee_HomePage.myblue);
		l4Input.setBackground(Employee_HomePage.myblue);
		l6Input.setBackground(Employee_HomePage.myblue);
		l9Input.setBackground(Employee_HomePage.myblue);
		
		l2Input.setEditable(false);
		l3Input.setEditable(false);
		l4Input.setEditable(false);
		l6Input.setEditable(false);
		l9Input.setEditable(false);
		
		l2Input.setForeground(Color.WHITE);
		l3Input.setForeground(Color.WHITE);
		l4Input.setForeground(Color.WHITE);
		l6Input.setForeground(Color.WHITE);
		l9Input.setForeground(Color.WHITE);
//		l2Input.setOpaque(true);
//		l3Input.setOpaque(true);
//		l4Input.setOpaque(true);
//		l6Input.setOpaque(true);
//		l9Input.setOpaque(true);
//		
		f9.setLayout(null);
		f9.setPreferredSize(new Dimension(600,670));
//		f9.setSize(600, 670);
		f9.setLocation((1366-600)/2, (768-600)/2);
		f9.setContentPane(myPanel);
		f9.pack();
		f9.setVisible(true);
		f9.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				if(listBookingID.getSelectedIndex()>0) {
					if(deleteRecord()) {
						JOptionPane.showMessageDialog(f9, "Booking Deleted");
						f9.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(f9, "Error",
						"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(f9, 
					"Please Select a Booking ID ", "Invalid", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				if(listBookingID.getSelectedIndex()>0 && validateForm()) {
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
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				f9.setVisible(false);
				//new AdminLogin();
			}
		});
		
		listBookingID.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				WelcomeScreenAndLogin.buttonSound();
				// TODO Auto-generated method stub
				//System.out.println(listBookingID.getSelectedIndex());
				if(listBookingID.getSelectedItem()!="" && arg0.getStateChange() == ItemEvent.SELECTED) {
					initializeDetails();
				}
				else {
					clearLabels();
				}
			}
			
		});
		listPassengerID.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent arg1) {
				WelcomeScreenAndLogin.buttonSound();
				// TODO Auto-generated method stub
				//System.out.println(listBookingID.getSelectedIndex());
				if(listPassengerID.getSelectedItem()!="None" && arg1.getStateChange() == ItemEvent.SELECTED) {
					initializePassengerDetails();
				}
				else {
					clearPassengerLabels();
				}
			}
		});
		
		b1.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b1.setBorderPainted(false);
				b1.setOpaque(true);
				b1.setBackground(Admin_HomePage.myred);
				b1.setForeground(Color.WHITE);
				b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b1.setBorderPainted(true);
				b1.setBackground(Color.WHITE);
				b1.setForeground(Color.BLACK);
				b1.setCursor(null);
//				b1.setOpaque(false);
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
//				b2.setOpaque(false);
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
//				b3.setOpaque(false);
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
	}//end of constructor

	private void clearLabels() {
		l3Input.setText("");
		l4Input.setText("");
		l2Input.setText("");
		l6Input.setText("");
		l9Input.setText("");
		listPassengerID.setSelectedItem("");
		listMeal.setSelectedItem("");
		listSeat.setSelectedItem("");
		listClass.setSelectedItem("");
		listCheckin.setSelectedItem("");
	}
	private void clearPassengerLabels() {
		l9Input.setText("");
		listMeal.setSelectedItem("");
		listSeat.setSelectedItem("");
		listClass.setSelectedItem("");
		listCheckin.setSelectedItem("");
	}
	protected void setInfoLabels() {
		// TODO Auto-generated method stub
		clearLabels();
		l2Input.setText(flightID);
		l3Input.setText(from);
		l4Input.setText(to);
	}
	protected void setPassengerInfoLabels() {
		// TODO Auto-generated method stub
		clearPassengerLabels();
		l6Input.setText(PassengerName);
		l9Input.setText(Luggage);
		listMeal.setSelectedItem(Meal);
		listSeat.setSelectedItem(Seat);
		listClass.setSelectedItem(Class);
		listCheckin.setSelectedItem(Checkin);
	}
	
	protected void initializeDetails() 
	{

		bookingID = (String) listBookingID.getSelectedItem();
		from = flightObj.getSource(bookingID);
		to = flightObj.getDestination(bookingID);
		flightID = flightObj.getFlightID(bookingID);
		
		setInfoLabels();
		
		getPassengers();
	}
	
	protected void initializePassengerDetails() 
	{
		passID = (String) listPassengerID.getSelectedItem();
		PassengerName = flightObj.getPassengerName(passID);
		Meal = flightObj.getPassengerMeal(passID);
		Seat = flightObj.getPassengerSeat(passID);
		Luggage = flightObj.getPassengerLuggage(passID);
		Class = flightObj.getPassengerClass(passID);
		Checkin = flightObj.getPassengerCheckIn(passID);
		setPassengerInfoLabels();
	}
	
	protected boolean updateRecord() {
		PassengerName = l6Input.getText();
		Luggage = l9Input.getText();
		Meal = (String) listMeal.getSelectedItem();
		Seat = (String) listSeat.getSelectedItem();
		Class = (String) listClass.getSelectedItem();
		Checkin = (String) listCheckin.getSelectedItem();
		return flightObj.UpdateBooking(passID, PassengerName, Meal, Seat, Luggage, Class, Checkin);
	}
	
	// CANCEL THE BOOKING IF BUTTON PRESSED
	protected boolean deleteRecord() 
	{
		// TODO Auto-generated method stub */
		if (!flightObj.CancelBooking(bookingID))
			return false;
		return true;
	}
	
	// GET ALL THE PASSENGER IDs IN A LIST
	public void getPassengers() {
		listPassengerID.removeAllItems();
		listPassengerID.addItem("None");
		String[] passengerIDs = flightObj.getPassengerID(bookingID);
		for (int i=0; i<passengerIDs.length; i++) {
			if (passengerIDs[i]!="")
				listPassengerID.addItem(passengerIDs[i]);
		}
	}
	
	// GET ALL THE BOOKING IDs IN A LIST
	private void getBookings() 
	{
		listBookingID.addItem("");
		String[] bookingIDs = flightObj.getActiveBookings(userName);
		for (int i=0; i<bookingIDs.length; i++) {
			if (bookingIDs[i]!="")
				listBookingID.addItem(bookingIDs[i]);
		}
		
	}
	
	private boolean validateForm() {
		// TODO Auto-generated method stub
		if((((String)listBookingID.getSelectedItem()).length())==0||
				((String) listClass.getSelectedItem()).length()==0||
				(l2Input.getText().length())==0
				||((String) listPassengerID.getSelectedItem()).length()==0
				||((String) listMeal.getSelectedItem()).length()==0||
				((String) listSeat.getSelectedItem()).length()==0||
				((String) listCheckin.getSelectedItem()).length()==0||(l3Input.getText().length())==0||(l4Input.getText().length())==0
				||(l6Input.getText().length())==0||(l9Input.getText().length())==0)
			return false;
		else
			return true;
	}
}
