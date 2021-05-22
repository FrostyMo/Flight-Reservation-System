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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import mainPackage.BusinessLayer.Customer_Handler;

public class Customer_BookFlight {

	JFrame f8;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, eDate;
	JTextField tf1, tf2, tf3, tf4, tf5;
	JComboBox<String> list1, list2, list3, passengers, listDepart, listArrival, listClass;
	JButton b1, b2;
	JPanel myPanel, myPanel1;
	
	String ar[], ar1[], ar2;
	//private String flightType;
	private String numPassengers;
	private String classType;
	//private String flightID;
	//private String basePrice;
	private String source;
	private String destination;
	private String dates;
	private String userName;
	public String fID;
	//private String departure;
	//private String arrival;
	
	Customer_Handler cH;
	
	Customer_BookFlight(String user) {
		userName = user;
		f8 = new JFrame("Information Form");
		f8.setLayout(null);
//		f8.setPreferredSize(new Dimension(530,450));
		f8.setSize(530,450);
		f8.setLocation((1366-420)/2, (768-450)/2);
		l1 = new JLabel("Flight Type : ");
		l2 = new JLabel("# of Passengers : ");
		l3 = new JLabel("Class: ");
		l4 = new JLabel("From : ");
		l5 = new JLabel("To : ");
		l6 = new JLabel("Date (DD/MM/YYYY) : ");
		
		cH = new Customer_Handler();
		
		String ar1[]={"", "Domestic", "International"};
		String ar2[]= {"", "1", "2", "3", "4", "5"};
		String ar3[]= {"", "Economy", "Business"};
		String times[] = {"", "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00",
				"13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" };
		
		list1 = new JComboBox<String>(ar1);
		tf1 = new JTextField();
		tf2 = new JTextField();
		list2 = new JComboBox<String>();
		list3 = new JComboBox<String>();
		
		passengers = new JComboBox<String>(ar2);
		listDepart = new JComboBox<String>(times);
		listArrival = new JComboBox<String>(times);
		listClass = new JComboBox<String>(ar3);
		tf3 = new JTextField();
		//tf4 = new JTextField();
		//tf5 = new JTextField();
		b1 = new JButton("Search");
		b2 = new JButton("Cancel");
		
		
		eDate=new JLabel("Correct Format: (DD/MM/YYYY)");
		eDate.setBounds(250, 302, 200, 15);
		eDate.setFont(Admin_SignUp.ERRORFORMAT);
		eDate.setForeground(Color.RED);
		eDate.setOpaque(true);
		eDate.setVisible(false);
		
		myPanel = Customer_HomePage.customerPanel();
		myPanel.setLayout(null);
//		f8.getContentPane().setBackground(new Color(0,0,0,0));
		
		String workingDirectory = System.getProperty("user.dir");
		String requiredDirectory = workingDirectory + "/" + "src/mainPackage/images/";
		
		BufferedImage myImage = null;
		try {
			
			myImage = ImageIO.read(new File(requiredDirectory+"flights1.jpg"));
			myImage = WelcomeScreenAndLogin.resize(myImage, 710, 450);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f8.setContentPane(new ImagePanel(myImage));
		
		
		
		l1.setBounds(30, 30, 180, 25);
		l2.setBounds(30, 80, 180, 25);
		l3.setBounds(30, 130, 180, 25);
		l4.setBounds(30, 180, 180, 25);
		l5.setBounds(30, 230, 180, 25);
		l6.setBounds(30, 280, 210, 25);
		
		l1.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l2.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l3.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l4.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l5.setFont(WelcomeScreenAndLogin.WHITELABEL);
		l6.setFont(WelcomeScreenAndLogin.WHITELABEL);
		
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		l4.setForeground(Color.WHITE);
		l5.setForeground(Color.WHITE);
		l6.setForeground(Color.WHITE);
		
		
		list1.setBounds(250, 30, 220, 25);
		passengers.setBounds(250, 80, 220, 25);
		listClass.setBounds(250, 130, 220, 25);
		list2.setBounds(250, 180, 220, 25);
		list3.setBounds(250, 230, 220, 25);
		tf3.setBounds(250, 280, 200, 25);
		//tf4.setBounds(200, 270, 200, 25);
		//tf5.setBounds(200, 310, 200, 25);
		
		DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
	    listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
	    
	    list1.setRenderer(listRenderer);
	    list2.setRenderer(listRenderer);
	    list3.setRenderer(listRenderer);
	    listClass.setRenderer(listRenderer);
	    passengers.setRenderer(listRenderer);
	    
		list1.setBackground(Color.WHITE);
		list2.setBackground(Color.WHITE);
		list3.setBackground(Color.WHITE);
		passengers.setBackground(Color.WHITE);
		listDepart.setBackground(Color.WHITE);
		listArrival.setBackground(Color.WHITE);
		listClass.setBackground(Color.WHITE);
		
		b1.setBounds(120, 370, 120, 30);
		b2.setBounds(270, 370, 120, 30);
		
		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		myPanel.setBounds(0, 0, 530, 350);
		myPanel.add(l1);
		myPanel.add(l2);
		myPanel.add(l3);
		myPanel.add(l4);
		myPanel.add(l5);
		myPanel.add(l6);
		
		myPanel.add(list1);
		//myPanel.add(tf1);
		//myPanel.add(tf2);
		myPanel.add(list2);
		myPanel.add(list3);
		myPanel.add(passengers);
		myPanel.add(listClass);
		myPanel.add(tf3);
		myPanel.add(eDate);
		//myPanel.add(tf4);
		//myPanel.add(tf5);
		//myPanel.add(listDepart);
		//myPanel.add(listArrival);
//		myPanel.add(b1);
//		myPanel.add(b2);
	
		myPanel.setVisible(false);
		f8.add(myPanel);
		f8.add(b1);
		f8.add(b2);
	
//		f8.pack();
		f8.setVisible(true);
		f8.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f8.setResizable(false);
//		f8.setVisible(true);
		myPanel.setVisible(true);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				if(validateForm() && initializeDetails()) {
					if (showRecord()) {
						JOptionPane.showMessageDialog(f8, "SHOWING FILTERED FLIGHTS");
						f8.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(f8, "Flight Could Not be Added");
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
		list1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				WelcomeScreenAndLogin.buttonSound();
				// TODO Auto-generated method stub
				if(list1.getSelectedItem().equals("Domestic")) {
					final String[] ar = {"","Islamabad", "Lahore", "Karachi", "Quetta", 
							"Skardu", "Sialkot", "Hyderabad", "Peshawar",
							"Nowshera"};
					//final String[] ar = flights.Routes_Available();
//					for (int i=0; i<ar.length; i++) {
//						System.out.println(ar[i]+" d");
//					}
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

	private boolean showRecord() 
	{
		Customer_ViewFlights obj = new Customer_ViewFlights(userName, "YES");
		obj.Check_Flight(source, destination, dates, numPassengers, classType);
		f8.setVisible(false);
		//new Passenger_Details(Integer.parseInt(numPassengers), cH.AddBooking(fID, numPassengers,userName));
			return true;
	}
	
	private boolean initializeDetails() {
		//flightType = (String) list1.getSelectedItem();
		numPassengers = (String) passengers.getSelectedItem();
		source = (String) list2.getSelectedItem();
		destination = (String) list3.getSelectedItem();
		classType = (String) listClass.getSelectedItem();
		if (source.equals(destination)) {
			JOptionPane.showMessageDialog(f8, "SOURCE AND DESTINATION CAN NOT BE SAME",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		dates = tf3.getText();
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
			return false;
		}
		
		
		return true;
	}

	private boolean validateForm() {
		// TODO Auto-generated method stub
		if((((String)passengers.getSelectedItem()).length())==0||
				((String) listClass.getSelectedItem()).length()==0||
				(tf3.getText().length())==0
				||((String) list1.getSelectedItem()).length()==0
				||((String) list2.getSelectedItem()).length()==0||
				((String) list3.getSelectedItem()).length()==0)
			return false;
		else
			return true;
	}
}
