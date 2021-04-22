package mainPackage.ApplicationLayer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import mainPackage.BusinessLayer.Customer_Handler;



public class Customer_PassengerDetails {
	JFrame f8;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8;
	JTextField tf1, tf2, tf3, tf4, tf5;
	JComboBox<String> list1, list2, list3, passengers, listDepart, listArrival, listClass;
	JButton b1, b2;
	
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
		
		
		l1.setBounds(30, 30, 120, 25);
		l2.setBounds(30, 70, 120, 25);
		l3.setBounds(30, 110, 120, 25);
		l4.setBounds(30, 150, 120, 25);
		l5.setBounds(30, 190, 120, 25);
		l6.setBounds(30, 230, 150, 25);
		l7.setBounds(30, 270, 120, 25);
		l8.setBounds(30, 310, 150, 25);
		
		
		tf1.setBounds(200, 30, 200, 25);	// name
		tf2.setBounds(200, 70, 200, 25);	// cnic
		tf3.setBounds(200, 110, 200, 25);	// age
		list1.setBounds(200, 150, 200, 25);	// meal
		list2.setBounds(200, 190, 200, 25); // seat
		tf4.setBounds(200, 230, 200, 25);	// luggage
		listClass.setBounds(200, 270, 200, 25);	// classes
		list3.setBounds(200, 310, 200, 25);		// checkin
		
		
		
		
		
		
		list1.setBackground(Color.WHITE);
		list2.setBackground(Color.WHITE);
		list3.setBackground(Color.WHITE);
		listClass.setBackground(Color.WHITE);
		
		b1.setBounds(50, 370, 120, 30);
		b2.setBounds(200, 370, 120, 30);
		
		f8.add(l1);
		f8.add(l2);
		f8.add(l3);
		f8.add(l4);
		f8.add(l5);
		f8.add(l6);
		f8.add(l7);
		f8.add(l8);
		
		f8.add(list1);
		f8.add(tf1);
		f8.add(tf2);
		f8.add(list2);
		f8.add(list3);
		//f8.add(passengers);
		f8.add(listClass);
		f8.add(tf3);
		f8.add(tf4);
		//f8.add(tf5);
		//f8.add(listDepart);
		//f8.add(listArrival);
		f8.add(b1);
		f8.add(b2);
		
		f8.setLayout(null);
		f8.setSize(500, 450);
		f8.setLocation((1366-420)/2, (768-450)/2);
		f8.setResizable(false);
		f8.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f8.setVisible(true);
		
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
				b1.setOpaque(false);
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
			
		
	}//end of constructor
	


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
		added_Price = 0;
		name = tf1.getText();
		CNIC = tf2.getText();
		age = tf3.getText();
		luggage = tf4.getText();
		if (Integer.parseInt(luggage)>40) {
			added_Price +=5000;
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
		
		
		
		return true;
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

