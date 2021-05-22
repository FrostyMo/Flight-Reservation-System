package mainPackage.ApplicationLayer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import mainPackage.BusinessLayer.Customer_Handler;



public class Customer_PassengerDetails {
	JFrame f8;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8;
	JTextField tf1, tf2, tf3, tf4, tf5;
	JComboBox<String> list1, list2, list3, passengers, listDepart, listArrival, listClass;
	JButton b1, b2;
	JPanel myPanel;
	JLabel ecnic,eluggage, eage;
	String ar[], ar1[], ar2;
	private String name;
	private String CNIC;
	private String classType;
	//private String flightID;
	//private String basePrice;
	private String age;
	private String meal_Option;
	private String seat_Option;
	private String luggage;
	private String check_In;
	private String Booking_ID;
	private Integer added_Price=0;
	ArrayList<String[]> All_Passengers;
	int numOfPassengers;
	int count;
	//private String departure;
	//private String arrival;
	final static Font ERRORFORMAT = new Font("Verdana",Font.ITALIC,10);
	
	Customer_Handler cHandler;
	
	Customer_PassengerDetails(int P, String bID) {
		Booking_ID = bID;
		numOfPassengers = P;
		count = 0;
		cHandler = new Customer_Handler();
		
		All_Passengers = new ArrayList<String[]>();
		f8 = new JFrame("Passenger Information Form");
		l1 = new JLabel("Name : ");
		l2 = new JLabel("CNIC : ");
		l3 = new JLabel("Age: ");
		l4 = new JLabel("Meal_Option : ");
		l5 = new JLabel("Seat_Option : ");
		l6 = new JLabel("Luggage : ");
		l7 = new JLabel("Class: ");
		l8 = new JLabel("Check-IN Online: ");
		
		String ar1[]={"", "Opt1", "Opt2", "Opt3", "Opt4"};
		String ar2[]= {"", "1", "2", "3", "4"};
		String ar3[]= {"", "Economy", "Business"};
		String ar4[] = {"", "Yes", "No"};
		
		list1 = new JComboBox<String>(ar1);
		tf1 = new JTextField();
		tf2 = new JTextField();
		list2 = new JComboBox<String>(ar2);
		list3 = new JComboBox<String>(ar4);
		
		
		listClass = new JComboBox<String>(ar3);
		tf3 = new JTextField();
		tf4 = new JTextField();
		//tf5 = new JTextField();
		b1 = new JButton("Submit");
		b2 = new JButton("Cancel");
		
		eluggage=new JLabel("Should be a number!");
		eage=new JLabel("Should be a number!");
		ecnic=new JLabel("Format xxxx-xxxxxxx-x");
		
		myPanel = Customer_HomePage.customerPanel();
		myPanel.setLayout(null);
		f8.getContentPane().setBackground(new Color(0,0,0,0));
		
		ecnic.setBounds(200, 102, 200, 15);
		eage.setBounds(200, 152, 200, 15);
		eluggage.setBounds(200, 302, 200, 15);
		
		ecnic.setFont(ERRORFORMAT);
		eage.setFont(ERRORFORMAT);
		eluggage.setFont(ERRORFORMAT);
		
		ecnic.setForeground(Color.RED);
		eage.setForeground(Color.RED);
		eluggage.setForeground(Color.RED);
		
		ecnic.setBackground(null);
		eage.setBackground(null);
		eluggage.setBackground(null);
		
		ecnic.setVisible(false);
		eage.setVisible(false);
		eluggage.setVisible(false);
		
		l1.setBounds(30, 30, 120, 25);
		l2.setBounds(30, 80, 120, 25);
		l3.setBounds(30, 130, 120, 25);
		l4.setBounds(30, 180, 120, 25);
		l5.setBounds(30, 230, 120, 25);
		l6.setBounds(30, 280, 150, 25);
		l7.setBounds(30, 330, 120, 25);
		l8.setBounds(30, 380, 150, 25);
		
		l1.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l2.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l3.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l4.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l5.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l6.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l7.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l8.setFont(WelcomeScreenAndLogin.WHITELABEL);
		
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		l4.setForeground(Color.WHITE);
		l5.setForeground(Color.WHITE);
		l6.setForeground(Color.WHITE);
		l7.setForeground(Color.WHITE);
		l8.setForeground(Color.WHITE);
		
		tf1.setBounds(200, 30, 200, 25);	// name
		tf2.setBounds(200, 80, 200, 25);	// cnic
		tf3.setBounds(200, 130, 200, 25);	// age
		list1.setBounds(200, 180, 200, 25);	// meal
		list2.setBounds(200, 230, 200, 25); // seat
		tf4.setBounds(200, 280, 200, 25);	// luggage
		listClass.setBounds(200, 330, 200, 25);	// classes
		list3.setBounds(200, 380, 200, 25);		// checkin
		
		
		list1.setBackground(Color.WHITE);
		list2.setBackground(Color.WHITE);
		list3.setBackground(Color.WHITE);
		listClass.setBackground(Color.WHITE);
		
		b1.setBounds(110, 440, 120, 30);
		b2.setBounds(260, 440, 120, 30);
		
		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		
		b1.setFocusable(false);
		b2.setFocusable(false);
		
		b1.setOpaque(true);
		b2.setOpaque(true);
		
		myPanel.add(l1);
		myPanel.add(l2);
		myPanel.add(l3);
		myPanel.add(l4);
		myPanel.add(l5);
		myPanel.add(l6);
		myPanel.add(l7);
		myPanel.add(l8);
		
		myPanel.add(list1);
		myPanel.add(tf1);
		myPanel.add(tf2);
		myPanel.add(list2);
		myPanel.add(list3);
		//myPanel.add(passengers);
		myPanel.add(listClass);
		myPanel.add(tf3);
		myPanel.add(tf4);
		//myPanel.add(tf5);
		//myPanel.add(listDepart);
		//myPanel.add(listArrival);
		myPanel.add(b1);
		myPanel.add(b2);
		myPanel.add(ecnic);
		myPanel.add(eluggage);
		myPanel.add(eage);
		
		f8.setLayout(null);
		f8.setPreferredSize(new Dimension(500,520));
//		f9.setSize(600, 670);
		f8.setLocation((1366-600)/2, (768-600)/2);
		f8.setContentPane(myPanel);
		f8.pack();
		f8.setVisible(true);
		f8.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		f8.setVisible(true);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				if(validateForm() && initializeDetails()) {
					if (count<numOfPassengers) {
						if (showRecord()) {
							JOptionPane.showMessageDialog(f8, "INFO SAVED");
							//f8.setVisible(false);
							tf1.setText("");
							tf2.setText("");
							tf3.setText("");
							tf4.setText("");
							list1.setSelectedIndex(0);
							list2.setSelectedIndex(0);
							list3.setSelectedIndex(0);
							listClass.setSelectedIndex(0);
							if (count==numOfPassengers) {
								JOptionPane.showMessageDialog(f8, "ALL PASSENGERS ADDED");
								f8.setVisible(false);
							}
						}
						else {
							JOptionPane.showMessageDialog(f8, "INFO COULDNT BE SAVED");
						}
					}
					else {
						JOptionPane.showMessageDialog(f8, "ALL PASSENGERS ADDED");
						f8.setVisible(false);
					}
				}
				else{
					JOptionPane.showMessageDialog(f8, "Fill All the Details in the Form",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				f8.setVisible(false);
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
			
		
	}//end of constructor
	
	private static boolean validateCNIC(String CNIC) {
		if(CNIC.matches("\\d{5}[-]\\d{7}[-]\\d{1}")) 
			return true;
		else {
			return false;
		}

	}

	private boolean showRecord() 
	{
			String[] info = {Booking_ID,name,CNIC,age,meal_Option,seat_Option,luggage,classType,check_In, added_Price.toString()};
			All_Passengers.add(info);
			if (cHandler.AddPassenger(info)) {
				count++;
				return true;
			}
			else 
				return false ;
	}
	
	private boolean initializeDetails() {
		Vector<Boolean> vec = new Vector<Boolean>();
		boolean val = false;
		added_Price = 0;
		name = tf1.getText();
		CNIC = tf2.getText();
		age = tf3.getText();
		luggage = tf4.getText();
		Border border = BorderFactory.createLineBorder(Color.RED);
		try {
			if (Integer.parseInt(luggage)>40) {
				added_Price +=5000;
			}
			tf4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			eluggage.setVisible(false);
			
			val=true;
		}
		catch(Exception exc) {
			// luggage incorrect 
			tf4.setBorder(border);
			eluggage.setVisible(true);
//			eluggage.setOpaque(true);
			val = false;
			vec.add(val);
		}
		
		try {
			Integer.parseInt(age);
				
			tf3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			eage.setVisible(false);
			
			val=true;
		}
		catch(Exception exc) {
			// luggage incorrect 
			tf3.setBorder(border);
			eage.setVisible(true);
//			eage.setOpaque(true);
			val = false;
			vec.add(val);
		}
		  
		if (validateCNIC(CNIC)) {
			tf2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			ecnic.setVisible(false);
			
			val=true;
		}
		else {
			// incorrect cnic
			tf2.setBorder(border);
			ecnic.setVisible(true);
//			ecnic.setOpaque(true);
			val = false;
			vec.add(val);
		}
		meal_Option = (String) list1.getSelectedItem();
		seat_Option = (String) list2.getSelectedItem();
		check_In = (String) list3.getSelectedItem();
		if (check_In.equals("Yes")) {
			added_Price += 5000;
		}
		classType = (String) listClass.getSelectedItem();
		if (classType.equals("Business")) {
			added_Price +=25000;
		}
		
		
		if(vec.contains(false)) {
			val=false;
			JOptionPane.showMessageDialog(f8, "Enter Valid Details", "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("some attribute invalid");
		}
		else {
			val=true;
			System.out.println("all correct");
		}
		return val;
	}

	private boolean validateForm() {
		// TODO Auto-generated method stub
		if(((	tf1.getText().length())==0||(tf2.getText().length())==0||(tf3.getText().length())==0||
				((String) listClass.getSelectedItem()).length()==0||
				(tf4.getText().length())==0
				||((String) list1.getSelectedItem()).length()==0
				||((String) list2.getSelectedItem()).length()==0||
				((String) list3.getSelectedItem()).length()==0))
			return false;
		else
			return true;
	}
}

