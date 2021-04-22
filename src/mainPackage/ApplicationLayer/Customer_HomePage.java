package mainPackage.ApplicationLayer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
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

import mainPackage.BusinessLayer.Customer_Handler;

public class Customer_HomePage {
	JFrame f17;
	JButton b1, b2, b3, b4, b6, b8, b9, b10, b11;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l10;
	JPasswordField pf1, pf2, pf3;
	JPanel p1;
	JPanel p2, p4;
	protected Component tf1;
	protected Component tf2;
	String userName;
	String Password;
	String workingDirectory;
	String requiredDirectory;
	Customer_Handler cH;
	Customer_HomePage(String userName){
		cH = new Customer_Handler();
		this.userName = userName;
		f17 = new JFrame(userName+"'s Homepage");
		f17.setLayout(null);
		f17.setSize(700, 495);
		f17.setLocation((1366-700)/2, (768-495)/2);
		
		b1 = new JButton("Additional Features");
		b2 = new JButton("Flights");
		b3 = new JButton("Change Password");
		b4 = new JButton("Logout");
		//b5 = new JButton("Create Employee");
		b6 = new JButton("Customer Support");
		//b7 = new JButton("View Employees");
		b8 = new JButton("Book a Flight");
		b9 = new JButton("Update/Cancel Booking");
		b10 = new JButton("Flight Schedule");
		b11 = new JButton("Change Password");
		
		
		l1 = new JLabel("Enter Previous Password : ");
		l2 = new JLabel("Enter New Password : ");
		l3 = new JLabel("Confirm New Password : ");
		l4 = new JLabel();
		l5 = new JLabel();
		l6 = new JLabel();
		l7 = new JLabel();
		l8 = new JLabel();
		l10 = new JLabel();
		
		pf1 = new JPasswordField();
		pf2 = new JPasswordField();
		pf3 = new JPasswordField();
		p1 = new JPanel();
		p2 = new JPanel();
		p4 = new JPanel();
		

		//l4.setBounds(40, 150, 150, 150);
		l5.setBounds(280, 150, 150, 150);
		//l6.setBounds(460, 150, 150, 150);
		l7.setBounds(100, 150, 150, 150);
		l8.setBounds(310, 150, 150, 150);
		l10.setBounds(520, 150, 150, 150);
		//String imageName1 = "cEmployee.jpg";
		String imageName2 = "cSupport.png";
		//String imageName3 = "sEmployee.jpg";
		String imageName4 = "book.png";
		String imageName5 = "cancel.png";
		String imageName7 = "search.png";
		workingDirectory = System.getProperty("user.dir");
		requiredDirectory = workingDirectory + "/" + "src/mainPackage/images/";
		try{
			
		//l4.setIcon(new ImageIcon(ImageIO.read(new File(requiredDirectory+imageName1))));
		l5.setIcon(new ImageIcon(ImageIO.read(new File(requiredDirectory+imageName2))));
		//l6.setIcon(new ImageIcon(ImageIO.read(new File(requiredDirectory+imageName3))));
		l7.setIcon(new ImageIcon(ImageIO.read(new File(requiredDirectory+imageName4))));
		l8.setIcon(new ImageIcon(ImageIO.read(new File(requiredDirectory+imageName5))));
		l10.setIcon(new ImageIcon(ImageIO.read(new File(requiredDirectory+imageName7))));
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		p1.setLayout(null);
		p2.setLayout(null);
		p4.setLayout(null);
		b1.setBounds(0, 405, 175, 50);
		b2.setBounds(175, 405, 175, 50);
		b3.setBounds(350, 405, 175, 50);
		b4.setBounds(525, 405, 175, 50);
		//b5.setBounds(40, 300, 150, 30);
		b6.setBounds(260, 300, 150, 30);
		//b7.setBounds(460, 300, 150, 30);
		b8.setBounds(70, 300, 150, 30);
		b9.setBounds(280, 300, 150, 30);
		b10.setBounds(490, 300, 150, 30);
		p1.setBounds(0, 0, 700, 400);
		p2.setBounds(0, 0, 700, 400);
		p4.setBounds(0, 120, 700, 300);
		
		pf1.setBounds(260, 50, 250, 30);
		pf2.setBounds(260, 110, 250, 30);
		pf3.setBounds(260, 170, 250, 30);
		l1.setBounds(60, 50, 200, 30);
		l2.setBounds(60, 110, 200, 30);
		l3.setBounds(60, 170, 200, 30);
		b11.setBounds(120, 230, 200, 30);
		
		BufferedImage myImage = null;
		try {
			
			myImage = ImageIO.read(new File(requiredDirectory+"customer.jpg"));
			myImage = WelcomeScreenAndLogin.resize(myImage, 710, 450);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f17.setContentPane(new ImagePanel(myImage));
		
		p1.setVisible(false);
		p2.setVisible(false);
		p4.setVisible(false);

		p1.setOpaque(false);
		p2.setOpaque(false);
		//p4.setOpaque(false);
		//p3.setBorder();
		//p1.add(b5);
		p1.add(b6);
		//p1.add(b7);
		//p1.add(l4);		// create emp and delete emp labels
		p1.add(l5);
		//p1.add(l6);
		p2.add(b8);
		p2.add(b9);
		p2.add(b10);
		p2.add(l7);
		p2.add(l8);
		p2.add(l10);
		p4.add(l1);
		p4.add(l2);
		p4.add(l3);
		p4.add(pf1);
		p4.add(pf2);
		p4.add(pf3);
		p4.add(b11);
		
		f17.add(b1);
		f17.add(b2);
		f17.add(b3);
		f17.add(b4);
		f17.add(p1);
		f17.add(p2);
		f17.add(p4);
		f17.setResizable(false);
		f17.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f17.setVisible(true);
		//Employee Button
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				p2.setVisible(false);
				p4.setVisible(false);
				p1.setVisible(true);
			}
		});
		//Flights button
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				p1.setVisible(false);
				p4.setVisible(false);
				p2.setVisible(true);
				}
		});
		//Change Password button
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				p1.setVisible(false);
				p2.setVisible(false);
				p4.setVisible(true);
			}});
		//Logout Button
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				f17.setVisible(false);
				new WelcomeScreenAndLogin();
			}
		});
		//Create employee button
//		b5.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ae) {
//				//f17.setVisible(false);
//				new CreateEmployee();
//			}
//		});
		//delete employee button
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				new Customer_Support(userName);
			}
		});
		//viewEmployee
//		b7.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ae) {
//				//connect to database
//				new Admin_ViewEmployees();
//			}
//		});
		// Book a flight button
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				new Customer_BookFlight(userName);
			}
		});
		
		//update/delete flight button
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				new Customer_UpdateBooking(userName);
			}
		});
		
		// change password button
		b11.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
					if(pf2.getText().equals(pf3.getText())) {
						if(ChangeuserPassword(pf1.getText(), pf2.getText())) {
						JOptionPane.showMessageDialog(p4, 
						"Password Updated Successfully", "Success!", JOptionPane.INFORMATION_MESSAGE);
						p4.setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(p4,
							"Old Password in incorrect", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else
						JOptionPane.showMessageDialog(f17, "New Passwords do not match",
								"Password Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		//view flights button
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				new Customer_ViewFlights(userName).Check_Flight();
			}
		});
		
		b1.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b1.setBorderPainted(false);
				b1.setOpaque(true);
				b1.setBackground(Admin_HomePage.mypurp);
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
				b2.setBackground(Admin_HomePage.mypurp);
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
				b3.setBackground(Admin_HomePage.mypurp);
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
		b4.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b4.setBorderPainted(false);
				b4.setOpaque(true);
				b4.setBackground(Admin_HomePage.mypurp);
				b4.setForeground(Color.WHITE);
				b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b4.setBorderPainted(true);
				b4.setBackground(Color.WHITE);
				b4.setForeground(Color.BLACK);
				b4.setCursor(null);
				b4.setOpaque(false);
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
//		b5.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				b5.setBorderPainted(false);
//				b5.setOpaque(true);
//				b5.setBackground(Admin_HomePage.myred);
//				b5.setForeground(Color.WHITE);
//				b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				b5.setBorderPainted(true);
//				b5.setBackground(Color.WHITE);
//				b5.setForeground(Color.BLACK);
//				b5.setCursor(null);
//				b5.setOpaque(false);
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
		b6.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b6.setBorderPainted(false);
				b6.setOpaque(true);
				b6.setBackground(Admin_HomePage.myred);
				b6.setForeground(Color.WHITE);
				b6.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b6.setBorderPainted(true);
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
//				b7.setBackground(Admin_HomePage.myred);
//				b7.setForeground(Color.WHITE);
//				b7.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				b7.setBorderPainted(true);
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
				b8.setBackground(Admin_HomePage.myred);
				b8.setForeground(Color.WHITE);
				b8.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b8.setBorderPainted(true);
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
				b9.setBackground(Admin_HomePage.myred);
				b9.setForeground(Color.WHITE);
				b9.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b9.setBorderPainted(true);
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
				b10.setBackground(Admin_HomePage.myred);
				b10.setForeground(Color.WHITE);
				b10.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b10.setBorderPainted(true);
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
				b11.setBackground(Admin_HomePage.myred);
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
		
	}// End of Constructor

	protected boolean ChangeuserPassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		if(validatePassword(oldPassword)) 
		{
			return cH.UpdatePassword(newPassword, userName);  
		}
		else {
			return false;
		}
	}
	
	private boolean validatePassword(String oldPassword) {
		// TODO Auto-generated method stub
		String pass=null;
		try {
			pass = cH.FindPassword(userName);
			if(pass.equals(oldPassword)) return true;
			else return false;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
