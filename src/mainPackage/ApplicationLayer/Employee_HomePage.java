package mainPackage.ApplicationLayer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mainPackage.BusinessLayer.Employee_Handler;

public class Employee_HomePage {

	JFrame f12;
	JButton b1, b2, b3, b5, b6, b8, b9, b10, b11;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l20;
	JPasswordField pf1, pf2, pf3;
	JTextField tf1, tf2, tf3, tf4;	// tf4 for age
	JPanel p1, p2, p3, p4;
	String employeeID;
	String employeeName;
	String joinDate;
	String address;
	String age;
	
	Employee_Handler eH;
	String contact;
	final static Color myblue = new Color(6, 13, 83);
	final static Color mygrey = new Color(42, 42, 42);
	final static Color myred = new Color(75, 25, 27);
	final static Color mypurp = new Color(106,13,173);
	Employee_HomePage(String ID) {
		employeeID = ID;
		f12 = new JFrame("Employee Homepage");
		f12.setLayout(null);
		f12.setLocation((1366-700)/2, (768-500)/2);
		f12.setSize(700, 500);
		
		eH = new Employee_Handler();
		
		b1 = new JButton("View Flights");
		b2 = new JButton("Reservations");
		b3 = new JButton("Change Password");
		b5 = new JButton("View Profile");
		b6 = new JButton("Customer Queries");
		//b7 = new JButton("Cancel Reservations");
		b8 = new JButton("View Reservations");
		b9 = new JButton("Change password");
		b10 = new JButton("Edit Details");
		b11 = new JButton("Update Details");
		
		l1 = new JLabel("Enter Previous Password : ");
		l2 = new JLabel("Enter New Password : ");
		l3 = new JLabel("Confirm New Password : ");
		l4 = new JLabel();
		l5 = new JLabel("  Logout");
		l6 = new JLabel("Employee ID : ");
		l7 = new JLabel("Name : ");
		l8 = new JLabel("Age : ");
		l9 = new JLabel("Address : ");
		l10 = new JLabel("Join Date : ");
		l11 = new JLabel("Contact No :" );
		l12 = new JLabel();
		l13 = new JLabel();
		l14 = new JLabel();
		l15 = new JLabel();
		l16 = new JLabel();
		l17 = new JLabel();
		l18 = new JLabel();
		//l19 = new JLabel();
		l20 = new JLabel();
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		
		pf1 = new JPasswordField();
		pf2 = new JPasswordField();
		pf3 = new JPasswordField();
		p1 = new JPanel();		// Reservations Panel
		p2 = new JPanel();		// Change Password Panel
		p3 = new JPanel();		// Profile Panel
		p4 = new JPanel();		// Edit Profile Panel
		String workingDirectory = System.getProperty("user.dir");
		String requiredDirectory = workingDirectory + "/" + "src/mainPackage/images/";
		String imageName4 = "homepageEmp.jpg";
		BufferedImage myImage = null;
		try {
			myImage = ImageIO.read(new File(requiredDirectory+imageName4));
			myImage = WelcomeScreenAndLogin.resize(myImage, 770,600);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f12.setContentPane(new ImagePanel(myImage));
		p1.setLayout(null);
		p2.setLayout(null);
		p3.setLayout(null);
		p4.setLayout(null);
		p2.setOpaque(true);
		p3.setOpaque(true);
		p4.setOpaque(true);
		p1.setBounds(0, 120, 700, 280);
		p2.setBounds(0, 120, 700, 280);
		p3.setBounds(0, 120, 700, 280);
		p4.setBounds(0, 120, 700, 280);
		b2.setBounds(0, 400, 175, 60);
		b1.setBounds(175, 400, 175, 60);
		b5.setBounds(350, 400, 175, 60);
		b3.setBounds(525, 400, 175, 60);
		l18.setBounds(40, 70, 160, 160);
		//l19.setBounds(250, 70, 160, 160);
		l20.setBounds(460, 70, 160, 160);
		b6.setBounds(120, 170, 160, 30);
		//b7.setBounds(270, 230, 160, 30);
		b8.setBounds(420, 170, 160, 30);
		b9.setBounds(120, 230, 200, 30);
		b10.setBounds(350, 50, 150, 50);
		b11.setBounds(350, 50, 150, 50);
		l4.setBounds(450, 0, 250, 39);
		l4.setBackground(Color.WHITE);
		l5.setBounds(600, 39, 100, 30);
		l5.setOpaque(true);
		l5.setBackground(Color.WHITE);
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		l5.setVisible(false);
		l4.setOpaque(true);
		//b4.setBounds(50, 350, 150, 50)
		p1.setOpaque(false);
		
		pf1.setBounds(260, 50, 250, 30);
		pf2.setBounds(260, 110, 250, 30);
		pf3.setBounds(260, 170, 250, 30);
		l1.setBounds(60, 50, 200, 30);
		l2.setBounds(60, 110, 200, 30);
		l3.setBounds(60, 170, 200, 30);
		
		l6.setBounds(30, 20, 150, 25);		// EMP ID
		l7.setBounds(30, 60, 150, 25);		// NAME
		l8.setBounds(30, 100, 150, 25);		// AGE 
		l9.setBounds(30, 140, 150, 25);		// ADDRESS
		l10.setBounds(30, 180, 150, 25);	// JOIN DATE
		l11.setBounds(30, 220, 150, 25);	// CONTACT
		l12.setBounds(150, 20, 150, 25);
		l13.setBounds(150, 60, 150, 25);
		l14.setBounds(150, 100, 150, 25);
		l15.setBounds(150, 140, 150, 25);
		l16.setBounds(150, 180, 150, 25);
		l17.setBounds(150, 220, 150, 25);
		tf1.setBounds(150, 140, 150, 25);
		tf2.setBounds(150, 60, 150, 25);
		tf3.setBounds(150, 220, 150, 25);
		tf4.setBounds(150,100,150,25);
		
		l12.setBackground(mygrey);
		l13.setBackground(mygrey);
		l14.setBackground(mygrey);
		l15.setBackground(mygrey);
		l16.setBackground(mygrey);
		l17.setBackground(mygrey);
		l12.setForeground(Color.WHITE);
		l13.setForeground(Color.WHITE);
		l14.setForeground(Color.WHITE);
		l15.setForeground(Color.WHITE);
		l16.setForeground(Color.WHITE);
		l17.setForeground(Color.WHITE);
		l12.setOpaque(true);
		l13.setOpaque(true);
		l14.setOpaque(true);
		l15.setOpaque(true);
		l16.setOpaque(true);
		l17.setOpaque(true);
		
		l18.setBounds(150, 30, 150, 150);
		//l19.setBounds(300, 70, 150, 150);
		l20.setBounds(450, 30, 150, 150);
		String imageName1 = "viewEmp.png";
		//String imageName2 = "viewEmp.png";
		String imageName3 = "view.png";
		try{
			l18.setIcon(new ImageIcon(ImageIO.read(new File(requiredDirectory+imageName1))));
			//l19.setIcon(new ImageIcon(ImageIO.read(new File(requiredDirectory+imageName2))));
			l20.setIcon(new ImageIcon(ImageIO.read(new File(requiredDirectory+imageName3))));
		}catch(IOException ex) {
				ex.printStackTrace();
				ex.getMessage();
		}
		p1.add(b6);
		//p1.add(b7);
		p1.add(b8);
		p1.add(l18);
		//p1.add(l19);
		p1.add(l20);
		p2.add(l1);
		p2.add(pf1);
		p2.add(l2);
		p2.add(pf2);
		p2.add(pf2);
		p2.add(l3);
		p2.add(pf3);
		p2.add(b9);
		
		p3.add(l6);
		p3.add(l7);
		p3.add(l8);
		p3.add(l9);
		p3.add(l10);
		p3.add(l11);
		p3.add(l12);
		p3.add(l13);
		p3.add(l14);
		p3.add(l15);
		p3.add(l16);
		p3.add(l17);
		p3.add(b10);
		
		p4.add(tf1);
		p4.add(tf2);
		p4.add(tf3);
		p4.add(tf4); // age
		p4.add(b11);
		
		//f12.add(p3);
		f12.add(l4);
		f12.add(p1);
		f12.add(p2);
		f12.add(p3);
		f12.add(p4);
		f12.add(l5);
		f12.add(b1);
		f12.add(b2);
		f12.add(b3);
		f12.add(b5);
		getLabelName();
		l4.setFont(WelcomeScreenAndLogin.allLabel);
		l4.setText("  "+employeeName+"'s Account");
		f12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1.setVisible(false);
		p2.setVisible(false);
		p3.setVisible(false);
		p4.setVisible(false);
		f12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f12.setVisible(true);
		
		//view Flights Button
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				new Employee_ViewFlights();
			}
		});
		
		//reservations button
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				//f12.setVisible(false);
				//f12.remove(p3);
				if(p4.isVisible()) {
					JOptionPane.showMessageDialog(p4, "Details not updated");
					p4.setVisible(false);
				}
				p3.setVisible(false);
				p2.setVisible(false);
				p1.setVisible(true);
				//f12.setVisible(true);
			}
		});
		
		//Change Password Button
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				//f12.setVisible(false);
				if(p4.isVisible()) {
					JOptionPane.showMessageDialog(p4, "Details not updated");
					p4.setVisible(false);
				}
				p1.setVisible(false);
				p3.setVisible(false);
				p2.setVisible(true);
				//f12.setVisible(true);
			}
		});
		
		//View Profile Button
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				//connect to database
				//f12.setVisible(false);
				if(p4.isVisible()) {
					JOptionPane.showMessageDialog(p4, "Details not updated");
					p4.setVisible(false);
				}
				p1.setVisible(false);
				p2.setVisible(false);
				setDetails();
				p3.add(l6);
				p3.add(l7);
				p3.add(l8);
				p3.add(l9);
				p3.add(l10);
				p3.add(l11);
				p3.add(l12);
				p3.add(l13);
				p3.add(l14);
				p3.add(l16);
				p3.setVisible(true);
				//f12.setVisible(true);
			}
		});
		
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				new Employee_Support(employeeID);
			}
		});
		
//		b7.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ae) {
//				//new CancelReservation();
//			}
//		});
		
		// View Reservations button
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				new Employee_ViewBookings();
			}
		});
		
		// Change Password Button
		b9.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
					if(pf2.getText().equals(pf3.getText())) {
						if(ChangeEmployeePassword(pf1.getText(), pf2.getText())) {
						JOptionPane.showMessageDialog(p2, 
						"Password Updated Successfully", "Success!", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(p2,
							"Old Password in incorrect", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else
						JOptionPane.showMessageDialog(f12, "New Passwords do not match",
								"Password Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		// Edit Details Button
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				tf4.setText(l14.getText());	// TEXT FOR AGE
				tf1.setText(l15.getText());	// TEXT FOR ADDRESS
				tf2.setText(l13.getText());	// TEXT FOR NAME
				tf3.setText(l17.getText());	// TEXT FOR PHONE
				p3.setVisible(false);
				
				p4.add(l6);
				p4.add(l7);
				p4.add(l8);
				p4.add(l9);
				p4.add(l10);
				p4.add(l11);
				p4.add(l12);
				//p4.add(l14);
				p4.add(l16);
				
				p4.setVisible(true);
			}
		});
		
		// Update Details Button
		b11.addActionListener(new ActionListener() {		// IF PRESSED, FIELDS ARE CHECKED AND TEXT SENT IN SQL TO UPDATE EMP

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				WelcomeScreenAndLogin.buttonSound();
				if(tf1.getText().length()!=0 && tf2.getText().length()!=0 && tf3.getText().length()!=0 && tf4.getText().length()!=0) {
					address = tf1.getText();
					employeeName = tf2.getText();
					contact = tf3.getText();
					age = tf4.getText();
					l4.setText("  "+employeeName+"'s Account");
					updateDetails(tf1.getText(), tf2.getText(), tf3.getText(), tf4.getText());
					
				}
				
				else {
					JOptionPane.showMessageDialog(p4, "Contact or email cannot be null",
					"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		// Top Label with employee Name
		l4.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getButton() == MouseEvent.BUTTON1) {
					p1.setVisible(false);
					p2.setVisible(false);
					p3.setVisible(false);
					p4.setVisible(false);
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				l4.setBackground(myred);
				l4.setForeground(Color.WHITE);
				l4.setCursor(new Cursor(Cursor.HAND_CURSOR));
				l5.setVisible(true);
				l5.setBackground(myred);
				l5.setForeground(Color.WHITE);
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				l4.setBackground(Color.WHITE);
				l4.setForeground(Color.BLACK);
				l4.setCursor(null);
				l5.setVisible(false);
				l5.setBackground(Color.WHITE);
				l5.setForeground(Color.BLACK);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		// Logout Label
		l5.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				WelcomeScreenAndLogin.buttonSound();
				f12.setVisible(false);
				new WelcomeScreenAndLogin();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				l4.setBackground(myred);
				l4.setForeground(Color.WHITE);
				l4.setCursor(new Cursor(Cursor.HAND_CURSOR));
				l5.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				l4.setBackground(Color.WHITE);
				l4.setForeground(Color.BLACK);
				l4.setCursor(null);
				l5.setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}	
		});
		
		
		
		b1.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b1.setBorderPainted(false);
				b1.setOpaque(true);
				b1.setBackground(mypurp);
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
				b2.setBackground(mypurp);
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
				b3.setBackground(mypurp);
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
		b5.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b5.setBorderPainted(false);
				b5.setOpaque(true);
				b5.setBackground(mypurp);
				b5.setForeground(Color.WHITE);
				b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b5.setBorderPainted(true);
				b5.setBackground(Color.WHITE);
				b5.setForeground(Color.BLACK);
				b5.setCursor(null);
				b5.setOpaque(false);
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
		
		b6.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b6.setBorderPainted(false);
				b6.setOpaque(true);
//				b6.setContentAreaFilled(false);
				b6.setBackground(myred);
				b6.setForeground(Color.WHITE);
				b6.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b6.setBorderPainted(true);
				b6.setContentAreaFilled(true);
				b6.setBackground(Color.WHITE);
				b6.setForeground(Color.BLACK);
				b6.setCursor(null);
				b6.setOpaque(false);
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
//		b7.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				b7.setBorderPainted(false);
//				b7.setOpaque(true);
////				b7.setContentAreaFilled(false);
//				b7.setBackground(myred);
//				b7.setForeground(Color.WHITE);
//				b7.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				b7.setBorderPainted(true);
//				b7.setContentAreaFilled(true);
//				b7.setBackground(Color.WHITE);
//				b7.setForeground(Color.BLACK);
//				b7.setCursor(null);
//				b7.setOpaque(false);
//			}
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		b8.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b8.setBorderPainted(false);
				b8.setOpaque(true);
//				b8.setContentAreaFilled(false);
				b8.setBackground(myred);
				b8.setForeground(Color.WHITE);
				b8.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b8.setBorderPainted(true);
				b8.setContentAreaFilled(true);
				b8.setBackground(Color.WHITE);
				b8.setForeground(Color.BLACK);
				b8.setCursor(null);
				b8.setOpaque(false);
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
		b9.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b9.setBorderPainted(false);
				b9.setOpaque(true);
//				b9.setContentAreaFilled(false);
				b9.setBackground(myred);
				b9.setForeground(Color.WHITE);
				b9.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b9.setBorderPainted(true);
				b9.setContentAreaFilled(true);
				b9.setBackground(Color.WHITE);
				b9.setForeground(Color.BLACK);
				b9.setCursor(null);
				b9.setOpaque(false);
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
		
		b10.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b10.setBorderPainted(false);
				b10.setOpaque(true);
//				b10.setContentAreaFilled(false);
				b10.setBackground(myred);
				b10.setForeground(Color.WHITE);
				b10.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b10.setBorderPainted(true);
				b10.setContentAreaFilled(true);
				b10.setBackground(Color.WHITE);
				b10.setForeground(Color.BLACK);
				b10.setCursor(null);
				b10.setOpaque(false);
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
		
		b11.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b11.setBorderPainted(false);
				b11.setOpaque(true);
				b11.setBackground(myred);
				b11.setForeground(Color.WHITE);
				b11.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b11.setBorderPainted(true);
				b11.setBackground(Color.WHITE);
				b11.setForeground(Color.BLACK);
				b11.setCursor(null);
				b11.setOpaque(false);
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

	protected boolean ChangeEmployeePassword(String oldPassword, String newPassword) 
	{
		if(validatePassword(oldPassword)) 
		{
			return eH.UpdatePassword(newPassword, employeeID);  
		}
		else {
			return false;
		}
	}

	private boolean validatePassword(String oldPassword) 
	{
		String pass=null;
		try {
			pass = eH.FindPassword(employeeID);
			if(pass.equals(oldPassword)) return true;
			else return false;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	protected void updateDetails(String newAddress, String newName, String newContact, String newAge) 
	{
		
		if (eH.UpdateEmployee(employeeID, newAge, newAddress, newName, newContact))
			JOptionPane.showMessageDialog(p4,"Details Updated", "Success!", JOptionPane.INFORMATION_MESSAGE);
		backToProfile();
	}

	

	private void backToProfile() {
		// TODO Auto-generated method stub
		p4.setVisible(false);
		p3.add(l6);
		p3.add(l7);
		p3.add(l8);
		p3.add(l9);
		p3.add(l10);
		p3.add(l11);
		p3.add(l12);
		p3.add(l13);
		p3.add(l14);
		p3.add(l15);
		p3.add(l16);
		p3.add(l17);
		setinPanel();
		p3.setVisible(true);
	}

	protected void setDetails() 
	{
		String temp[] = new String[4];
		
		//if(joinDate==null||contact==null||age==null) {
			temp = eH.getEmployeeInfo(employeeID);
		//}
		age = temp[0];
		address = temp[1];
		joinDate = temp[2];
		contact = temp[3];
		setinPanel();
	}

	private void setinPanel() 
	{
		// TODO Auto-generated method stub
		l12.setText(employeeID);
		l13.setText(employeeName);
		l14.setText(age);
		l15.setText(address);
		l16.setText(joinDate);
		l17.setText(""+contact);
	}

	private void getLabelName() 
	{
		employeeName = eH.getEmployeeName(employeeID);
	}
}