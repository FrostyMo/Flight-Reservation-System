package mainPackage.ApplicationLayer;
import mainPackage.BusinessLayer.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class Admin_AddFlight {

	JFrame f8;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, ePrice, eDate;
	JTextField tf1, tf2, tf3, tf4, tf5;
	JComboBox<String> list1, list2, list3, planeList, listDepart, listArrival;
	JButton b1, b2;
	JPanel myPanel;
	String ar[], ar1[], ar2;
	//private String flightType;
	private String flightID;
	private String basePrice;
	private String source;
	private String destination;
	private String dates;
	private String departure;
	private String arrival;
	
	Admin_FlightVerification flights = new Admin_FlightVerification();
	
	Admin_AddFlight() {
		f8 = new JFrame("New Flight Form");
		l1 = new JLabel("<html><span style='size: 14'><b>Flight Type : </b></span></html>");
		l2 = new JLabel("<html><span style='size: 14'><b>Plane ID : </b></span></html>");
		l3 = new JLabel("<html><span style='size: 14'><b>Base Price: </b></span></html>");
		l4 = new JLabel("<html><span style='size: 14'><b>From  : </b></span></html>");
		l5 = new JLabel("<html><span style='size: 14'><b>To : </b></span></html>");
		l6 = new JLabel("<html><span style='size: 14'><b>Date (DD/MM/YYYY) : </b></span></html>");
		l7 = new JLabel("<html><span style='size: 14'><b>Departure Time : </b></span></html>");
		l8 = new JLabel("<html><span style='size: 14'><b>Arrival Time : </b></span></html>");
		
		myPanel = Admin_HomePage.adminPanel();
		myPanel.setLayout(null);
		f8.getContentPane().setBackground(new Color(0,0,0,0));
		String ar1[]={"", "Domestic", "International"};
		String times[] = {"", "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00",
				"13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" };
		
		list1 = new JComboBox<String>(ar1);
		tf1 = new JTextField();
		tf2 = new JTextField();
		list2 = new JComboBox<String>();
		list3 = new JComboBox<String>();
		planeList = new JComboBox<String>(flights.Planes_Available());
		listDepart = new JComboBox<String>(times);
		listArrival = new JComboBox<String>(times);
		tf3 = new JTextField();
		//tf4 = new JTextField();
		//tf5 = new JTextField();
		b1 = new JButton("OK");
		b2 = new JButton("Cancel");
		
		//// adding validation
		ePrice=new JLabel("Should be a number!");
		ePrice.setBounds(200, 132,200 , 15);
		ePrice.setFont(Admin_SignUp.ERRORFORMAT);
		//ePrice.setForeground(Color.RED);
		ePrice.setVisible(false);
		
		eDate=new JLabel("Correct Format: (DD/MM/YYYY)");
		eDate.setBounds(200, 252,200 , 15);
		eDate.setFont(Admin_SignUp.ERRORFORMAT);
		//eDate.setForeground(Color.RED);
		eDate.setVisible(false);
		
		l1.setBounds(30, 30, 120, 25);
		l2.setBounds(30, 70, 120, 25);
		l3.setBounds(30, 110, 120, 25);
		l4.setBounds(30, 150, 120, 25);
		l5.setBounds(30, 190, 120, 25);
		l6.setBounds(30, 230, 150, 25);
		l7.setBounds(30, 270, 120, 25);
		l8.setBounds(30, 310, 120, 25);
		
		l1.setForeground(Admin_SignUp.mypurp);
		l2.setForeground(Admin_SignUp.mypurp);	
		l3.setForeground(Admin_SignUp.mypurp);
		l4.setForeground(Admin_SignUp.mypurp);	
		l5.setForeground(Admin_SignUp.mypurp);	
		l6.setForeground(Admin_SignUp.mypurp);	
		l7.setForeground(Admin_SignUp.mypurp);	
		l8.setForeground(Admin_SignUp.mypurp);		
		
		
		list1.setBounds(200, 30, 200, 25);
		planeList.setBounds(200, 70, 200, 25);
		tf2.setBounds(200, 110, 200, 25);
		list2.setBounds(200, 150, 200, 25);
		list3.setBounds(200, 190, 200, 25);
		tf3.setBounds(200, 230, 200, 25);
		//tf4.setBounds(200, 270, 200, 25);
		//tf5.setBounds(200, 310, 200, 25);
		listDepart.setBounds(200, 270, 200, 25);
		listArrival.setBounds(200, 310, 200, 25);
		
		list1.setBackground(Color.WHITE);
		list2.setBackground(Color.WHITE);
		list3.setBackground(Color.WHITE);
		planeList.setBackground(Color.WHITE);
		listDepart.setBackground(Color.WHITE);
		listArrival.setBackground(Color.WHITE);
		
		b1.setBounds(120, 370, 120, 30);
		b2.setBounds(260, 370, 120, 30);
		
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
		//myPanel.add(tf1);
		myPanel.add(tf2);
		myPanel.add(list2);
		myPanel.add(list3);
		myPanel.add(planeList);
		myPanel.add(tf3);
		//myPanel.add(tf4);
		//myPanel.add(tf5);
		myPanel.add(listDepart);
		myPanel.add(listArrival);
		myPanel.add(b1);
		myPanel.add(b2);
		
		myPanel.add(ePrice);
		myPanel.add(eDate);
		
		f8.setLayout(null);
		f8.setPreferredSize(new Dimension(500,450));
		f8.setLocation((1366-420)/2, (768-450)/2);
		f8.setResizable(false);
		f8.setContentPane(myPanel);
		f8.pack();
		f8.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f8.setVisible(true);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				if(validateForm() && initializeDetails()) {
					if (createRecord()) {
						JOptionPane.showMessageDialog(f8, "Flight Added");
						f8.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(f8, "Flight Could Not be Added");
					}
				}
				else{
					JOptionPane.showMessageDialog(f8, "Fill All the Details in the Form correctly!",
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
		
		list1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				WelcomeScreenAndLogin.buttonSound();
				// TODO Auto-generated method stub
				if(list1.getSelectedItem().equals("Domestic")) {
					final String[] ar = {"","Islamabad", "Lahore", "Karachi", "Quetta", 
							"Skardu", "Sialkot", "Hyderabad", "Peshawar",
							"Nowshera"};

					changeListItems(ar);
				}
				else if(list1.getSelectedItem().equals("International")) {
					String[] ar2 = {"", "New Delhi", "Mumbai", "Kolkata", "Chennai", 
							"New York", "Chicago", "Dubai", "London","Hong Kong", 
							"Muscat", "Singapore", "Shanghai", "Toronto", "Cape Town"};
					//final String[] ar2 = flights.Routes_Available();
					changeListItems(ar2);
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
	}//end of constructor
	
	protected void changeListItems(String[] ar3) {
		// TODO Auto-generated method stub
			list2.removeAllItems();
			list3.removeAllItems();
		for(int i=0; i<ar3.length; i++) {
			list2.addItem(ar3[i]);
			list3.addItem(ar3[i]);
		}
	}

	private boolean createRecord() 
	{
		Admin_Handler obj = new Admin_Handler();
		if (!obj.Add(source, destination, dates, basePrice, departure, arrival, flightID))
			return false;
		return true;
	}
	
	private boolean parseData() {
		boolean successful = true;
		try {
			Integer.parseInt(basePrice);
			ePrice.setVisible(false);
			tf2.setBorder(null);
		}
		catch (Exception e) {
			ePrice.setVisible(true);
			Border border = BorderFactory.createLineBorder(Color.RED,2);
			tf2.setBorder(border);
			successful = false;
		}
		try {
		    DateTimeFormatter formatter =
		                      DateTimeFormatter.ofPattern("dd/MM/yyyy");
		    LocalDate date = LocalDate.parse(dates, formatter);
		    System.out.printf("%s%n", date);
		    eDate.setVisible(false);
			tf3.setBorder(null);
		}
		catch (DateTimeParseException exc) {
		    System.out.printf("%s is not parsable!%n", dates);
		    eDate.setVisible(true);
			Border border = BorderFactory.createLineBorder(Color.RED,2);
			tf3.setBorder(border);
			successful = false;
		}
		if (source.equals(destination)) {
			JOptionPane.showMessageDialog(f8, "SOURCE AND DESTINATION CAN NOT BE SAME",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			successful = false;
		}
		else {
			if (flights.Route_Exists(source, destination)=="") {
				String duration;
				duration = JOptionPane.showInputDialog("New Route being added, please add a duration: ");
				flights.Create_Route(source, destination, duration);
			}
		}
		return successful;
	}
	
	private boolean initializeDetails() {
		//flightType = (String) list1.getSelectedItem();
		basePrice = tf2.getText();
		source = (String) list2.getSelectedItem();
		destination = (String) list3.getSelectedItem();
		
		
		
		dates = tf3.getText();
		
		//departure = tf4.getText();
		//arrival = tf5.getText();
		
		departure = (String) listDepart.getSelectedItem();
		arrival = (String) listArrival.getSelectedItem();
		
		flightID = (String) planeList.getSelectedItem();
		return parseData();
	}

	private boolean validateForm() {
		// TODO Auto-generated method stub
		if((((String)planeList.getSelectedItem()).length())==0||(tf2.getText().length())==0||
				(tf3.getText().length())==0||(((String)listDepart.getSelectedItem()).length())==0||
				(((String)listArrival.getSelectedItem()).length())==0||((String) list1.getSelectedItem()).length()==0
				||((String) list2.getSelectedItem()).length()==0||
				((String) list3.getSelectedItem()).length()==0)
			return false;
		else
			return true;
	}
	
}
