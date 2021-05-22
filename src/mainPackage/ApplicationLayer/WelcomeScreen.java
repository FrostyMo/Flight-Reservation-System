package mainPackage.ApplicationLayer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;

import mainPackage.BusinessLayer.Login;

class WelcomeScreenAndLogin {
	
	JFrame welcomeFrame, adminLoginFrame, empLoginFrame, custLoginFrame, f5;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, signup_label, signup_entry1, signup_entry2;
	JTextField tf1, tf2, tf3;
	JPasswordField pf1, pf2, pf3;
	
	final static Border BUTTONBORDER = BorderFactory.createLineBorder(new Color(255,102,102), 1);
	final static Border BORDERBLACK = BorderFactory.createLineBorder(Color.BLACK, 2);
	final static Font allButton = new Font("Bookman Old Style", Font.PLAIN, 16);
	final static Font allLabel = new Font("Berlin Sans FB", Font.PLAIN, 18);
	final static Font WHITELABEL = new Font("Berlin Sans FB", Font.PLAIN, 18);
	static BufferedImage myImage = null;
	Login login = new Login();
	final static Color myblue = new Color(6, 13, 83);
	final static Color myred = new Color(75, 25, 27);
	final static Color mypurp = new Color(106, 13, 173);
	final static Color mypurp2 = new Color(87, 17, 138);
	static String requiredDirectory = System.getProperty("user.dir") + "/" + "src/mainPackage/images/";
	static String buttonPath = requiredDirectory + "button.wav";
	@SuppressWarnings("static-access")
	WelcomeScreenAndLogin(){
		
		welcomeFrame = new JFrame("Welcome To FRS Login Page");
		adminLoginFrame = new JFrame("Login As Admin");
		empLoginFrame = new JFrame("Login As Employee");
		custLoginFrame = new JFrame("Login As Customer");
		//f5 = new JFrame("SignUp As Employee");
		
		welcomeFrame.getContentPane().setBackground(Color.BLACK);
		
		//Connect.getConnection();		// Static Connection To database
		
		l1 = new JLabel();
		l2 = new JLabel();
		l3 = new JLabel("Enter login id : ");
		l4 = new JLabel("Enter Password : ");
		l5 = new JLabel("Enter login id : ");
		l6 = new JLabel("Enter Password : ");
		l7 = new JLabel("Enter User ID : ");
		l8 = new JLabel("Enter Password : ");
		signup_label = new JLabel("Sign Up", SwingConstants.CENTER);
		signup_entry1 = new JLabel("Admin", SwingConstants.CENTER);
		signup_entry2 = new JLabel("Customer", SwingConstants.CENTER);
		
		b1 = new JButton("Admin");
		b2 = new JButton("Employee");
		b3 = new JButton("Customer");
		b4 = new JButton("Submit");
		b5 = new JButton("Back");
		b6 = new JButton("Submit");
		b7 = new JButton("Back");
		b8 = new JButton("Submit");
		b9 = new JButton("Back");
		b10 = new JButton("SignUp Admin");
		
		b1.setFont(allButton);
		b2.setFont(allButton);
		b3.setFont(allButton);
		b4.setFont(allButton);
		b5.setFont(allButton);
		b6.setFont(allButton);
		b7.setFont(allButton);
		b8.setFont(allButton);
		b9.setFont(allButton);
		b10.setFont(allButton);
		l1.setFont(allLabel);
		l2.setFont(allLabel);
		l3.setFont(allLabel);
		l4.setFont(allLabel);
		l5.setFont(allLabel);
		l6.setFont(allLabel);
		l7.setFont(allLabel);
		l8.setFont(allLabel);
		
		signup_label.setBounds(600, 0, 90, 39);
		signup_label.setBackground(Color.WHITE);
		signup_label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		signup_label.setOpaque(true);
		
		signup_entry1.setBounds(580, 39, 130, 30);
		signup_entry1.setOpaque(true);
		signup_entry1.setBackground(Color.WHITE);
		signup_entry1.setForeground(Color.BLACK);
		signup_entry1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		signup_entry1.setVisible(false);
		
		signup_entry2.setBounds(580, 69, 130, 30);
		signup_entry2.setOpaque(true);
		signup_entry2.setBackground(Color.WHITE);
		signup_entry2.setForeground(Color.BLACK);
		signup_entry2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		signup_entry2.setVisible(false);
		
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		pf1 = new JPasswordField();
		pf2 = new JPasswordField();
		pf3 = new JPasswordField();
		
		b1.setBounds(100, 400, 150, 30);
		b2.setBounds(300, 400, 150, 30);
		b3.setBounds(500, 400, 150, 30);
		b4.setBounds(70, 200, 130, 40);
		b5.setBounds(250, 200, 130, 40);
		b6.setBounds(70, 200, 130, 40);
		b7.setBounds(250, 200, 130, 40);
		b8.setBounds(70, 200, 130, 40);
		b9.setBounds(250, 200, 130, 40);
		b10.setBounds(500, 200, 150, 30);	// Admin Sign up
		
		b1.setOpaque(true);
		b2.setOpaque(true);
		b3.setOpaque(true);
		b4.setOpaque(true);
		b5.setOpaque(true);
		b6.setOpaque(true);
		b7.setOpaque(true);
		b8.setOpaque(true);
		b9.setOpaque(true);
		b10.setOpaque(true);
		
		b1.setBorder(BUTTONBORDER);
		b2.setBorder(BUTTONBORDER);
		b3.setBorder(BUTTONBORDER);
		b4.setBorder(BUTTONBORDER);
		b5.setBorder(BUTTONBORDER);
		b6.setBorder(BUTTONBORDER);
		b7.setBorder(BUTTONBORDER);
		b8.setBorder(BUTTONBORDER);
		b9.setBorder(BUTTONBORDER);
		b10.setBorder(BUTTONBORDER);
		
		
		b1.setBackground(Color.white);
		b2.setBackground(Color.white);
		b3.setBackground(Color.white);
		b4.setBackground(Color.white);
		b5.setBackground(Color.white);
		b6.setBackground(Color.white);
		b7.setBackground(Color.white);
		b8.setBackground(Color.white);
		b9.setBackground(Color.white);
		
		b1.setFocusable(false);
		b2.setFocusable(false);
		b3.setFocusable(false);
		
		
		l3.setBounds(40, 50, 140, 40);
		l4.setBounds(40, 120, 140, 40);
		l5.setBounds(40, 50, 140, 40);
		l6.setBounds(40, 120, 140, 40);
		l7.setBounds(40, 50, 140, 40);
		l8.setBounds(40, 120, 140, 40);
		tf1.setBounds(200, 50, 200, 30);
		tf2.setBounds(200, 50, 200, 30);
		tf3.setBounds(200, 50, 200, 30);
		pf1.setBounds(200, 120, 200, 30);
		pf2.setBounds(200, 120, 200, 30);
		pf3.setBounds(200, 120, 200, 30);
		

		try {
			String image = "batman2.jpg";
		    String workingDirectory = System.getProperty("user.dir");
		    String requiredDirectory = workingDirectory + "/" + "src/mainPackage/images/"
		            + image;
		    
		    System.out.println(requiredDirectory);
			//String path = mainPackage.images->class.getResource("mainScreen.jpg").getPath();
			myImage = ImageIO.read(new File(requiredDirectory));
			myImage = resize(myImage, 720,600);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		
		welcomeFrame.setContentPane(new ImagePanel(myImage));
		welcomeFrame.add(b1);
		welcomeFrame.add(b2);
		welcomeFrame.add(b3);
		adminLoginFrame.add(l3);
		adminLoginFrame.add(l4);
		adminLoginFrame.add(tf1);
		adminLoginFrame.add(pf1);
		adminLoginFrame.add(b4);
		adminLoginFrame.add(b5);
		
		empLoginFrame.add(l5);
		empLoginFrame.add(l6);
		empLoginFrame.add(tf2);
		empLoginFrame.add(pf2);
		empLoginFrame.add(b6);
		empLoginFrame.add(b7);
		
		custLoginFrame.add(l7);
		custLoginFrame.add(l8);
		custLoginFrame.add(tf3);
		custLoginFrame.add(pf3);
		custLoginFrame.add(b8);
		custLoginFrame.add(b9);
		//welcomeFrame.add(b10);
		welcomeFrame.add(signup_label);
		welcomeFrame.add(signup_entry1);
		welcomeFrame.add(signup_entry2);
		
		welcomeFrame.setDefaultCloseOperation(welcomeFrame.EXIT_ON_CLOSE);
		adminLoginFrame.setDefaultCloseOperation(welcomeFrame.DISPOSE_ON_CLOSE);
		empLoginFrame.setDefaultCloseOperation(welcomeFrame.DISPOSE_ON_CLOSE);
		custLoginFrame.setDefaultCloseOperation(welcomeFrame.DISPOSE_ON_CLOSE);
		welcomeFrame.setSize(720, 495);
		welcomeFrame.setLayout(null);
		welcomeFrame.setLocation((1600-770)/2, (900-495)/2);
		welcomeFrame.setVisible(true);
		welcomeFrame.setResizable(false);
		
		adminLoginFrame.setSize(450, 320);
		adminLoginFrame.setLocation((1366-450)/2, (768-320)/2);
		adminLoginFrame.setLayout(null);
		adminLoginFrame.setResizable(false);
		adminLoginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		empLoginFrame.setSize(450, 320);
		empLoginFrame.setLocation((1366-450)/2, (768-320)/2);
		empLoginFrame.setLayout(null);
		empLoginFrame.setResizable(false);
		empLoginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		custLoginFrame.setSize(450, 320);
		custLoginFrame.setLocation((1366-450)/2, (768-320)/2);
		custLoginFrame.setLayout(null);
		custLoginFrame.setResizable(false);
		custLoginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//b1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		
		
		// Top Label with sign up
		signup_label.addMouseListener(new MouseListener() {
	
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getButton() == MouseEvent.BUTTON1) {
					JOptionPane.showMessageDialog(f5, "Please Select one of the User type to Sign Up!", "Hi", JOptionPane.INFORMATION_MESSAGE);
				}
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				signup_label.setBackground(myred);
				signup_label.setForeground(Color.WHITE);
				signup_label.setCursor(new Cursor(Cursor.HAND_CURSOR));
				signup_entry1.setVisible(true);
				signup_entry1.setBackground(myred);
				signup_entry1.setForeground(Color.WHITE);
				signup_entry2.setVisible(true);
				signup_entry2.setBackground(myred);
				signup_entry2.setForeground(Color.WHITE);
				
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				signup_label.setBackground(Color.WHITE);
				signup_label.setForeground(Color.BLACK);
				signup_label.setCursor(null);
				signup_entry1.setVisible(false);
				signup_entry1.setBackground(Color.WHITE);
				signup_entry1.setForeground(Color.BLACK);
				signup_entry2.setVisible(false);
				signup_entry2.setBackground(Color.WHITE);
				signup_entry2.setForeground(Color.BLACK);
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
		
		// Admin Signup Label
		signup_entry1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				WelcomeScreenAndLogin.buttonSound();
				
				new Admin_SignUp();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				signup_label.setBackground(myred);
				signup_label.setForeground(Color.WHITE);
				signup_entry1.setCursor(new Cursor(Cursor.HAND_CURSOR));
				signup_entry1.setVisible(true);
				signup_entry2.setBackground(myred);
				signup_entry2.setForeground(Color.WHITE);
				signup_entry2.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				signup_label.setBackground(Color.WHITE);
				signup_label.setForeground(Color.BLACK);
				signup_entry1.setCursor(null);
				signup_entry1.setVisible(false);
				signup_entry2.setCursor(null);
				signup_entry2.setVisible(false);
				signup_entry2.setBackground(Color.WHITE);
				signup_entry2.setForeground(Color.BLACK);
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
		
		signup_entry2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				WelcomeScreenAndLogin.buttonSound();
				new Customer_SignUp();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				signup_label.setBackground(myred);
				signup_label.setForeground(Color.WHITE);
				signup_entry2.setCursor(new Cursor(Cursor.HAND_CURSOR));
				signup_entry2.setBackground(Color.WHITE);
				signup_entry2.setForeground(Color.BLACK);
				signup_entry2.setVisible(true);
				signup_entry1.setVisible(true);
				signup_entry1.setBackground(myred);
				signup_entry1.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				signup_label.setBackground(Color.WHITE);
				signup_label.setForeground(Color.BLACK);
				signup_entry1.setCursor(null);
				signup_entry1.setVisible(false);
				signup_entry2.setCursor(null);
				signup_entry2.setVisible(false);
				signup_entry1.setBackground(Color.WHITE);
				signup_entry1.setForeground(Color.BLACK);
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
		//Login as Admin button
		b1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonSound();
				tf1.setText("");
				pf1.setText("");
				adminLoginFrame.setVisible(true);
			}
		});
		
		// Login as Employee Button
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				buttonSound();
				tf2.setText("");
				pf2.setText("");
				empLoginFrame.setVisible(true);
			}
		});
		
		// Login as Customer button
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				buttonSound();
				tf3.setText("");
				pf3.setText("");
				custLoginFrame.setVisible(true);
				//Privileges for user 
			}
		});
		
		// Administrator login page's submit button
		
		b4.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent ae) {
				buttonSound();
				if(login.loginAdmin(tf1.getText(), pf1.getText())) {
					adminLoginFrame.setVisible(false);
					welcomeFrame.setVisible(false);
					new Admin_HomePage(tf1.getText());
				}else {
					JOptionPane.showMessageDialog(adminLoginFrame,
					"Invalid Employee ID or Password. Please try again",
					"Login Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// back to welcome screen button
		b5.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae) {
				buttonSound();
				adminLoginFrame.setVisible(false);
				welcomeFrame.setVisible(true);
			}
		});
		
		// employee submit button
		b6.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent ae) {
				buttonSound();
				if(login.loginEmployee(tf2.getText(), pf2.getText())) {
					empLoginFrame.setVisible(false);
					welcomeFrame.setVisible(false);
					new Employee_HomePage(tf2.getText());
				}else {
					JOptionPane.showMessageDialog(empLoginFrame,
					"Invalid Employee ID or Password. Please try again",
					"Login Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// back button
		b7.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae) {
				buttonSound();
				empLoginFrame.setVisible(false);
				welcomeFrame.setVisible(true);
			}
		});
		
		// Customer submit button
		b8.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent ae) {
				
				
				if(login.loginUser(tf3.getText(), pf3.getText())) {
					buttonSound();
					custLoginFrame.setVisible(false);
					welcomeFrame.setVisible(false);
					new Customer_HomePage(tf3.getText());
				}else {
					JOptionPane.showMessageDialog(empLoginFrame,
					"Invalid User ID or Password. Please try again",
					"Login Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// back button
		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				buttonSound();
				custLoginFrame.setVisible(false);
				welcomeFrame.setVisible(true);
			}
		});
		
		// Sign up Admin
//		b10.addActionListener(new ActionListener()
//		{
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				buttonSound();
//				new Admin_SignUp();
//				//adminLoginFrame.setVisible(true);
//			}
//		});
		
		b1.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b1.setBorderPainted(false);
				b1.setOpaque(true);
				b1.setBackground(myred);
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
				//b1.setOpaque(false);
				
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
				b2.setBackground(myred);
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
				b2.setOpaque(true);
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
				b3.setBackground(myred);
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
				b3.setOpaque(true);
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
				
				b4.setOpaque(true);
				b4.setContentAreaFilled(false);
				b4.setBackground(myblue);
				b4.setForeground(Color.BLUE);
				b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b4.setContentAreaFilled(true);
				b4.setBackground(Color.WHITE);
				b4.setForeground(Color.BLACK);
				b4.setCursor(null);
				b4.setOpaque(true);
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
				
				b5.setOpaque(true);
				b5.setContentAreaFilled(false);
				b5.setBackground(myblue);
				b5.setForeground(Color.BLUE);
				b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b5.setContentAreaFilled(true);
				b5.setBackground(Color.WHITE);
				b5.setForeground(Color.BLACK);
				b5.setCursor(null);
				b5.setOpaque(true);
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
				
				b6.setOpaque(true);
				b6.setContentAreaFilled(false);
				b6.setBackground(myblue);
				b6.setForeground(Color.BLUE);
				b6.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b6.setContentAreaFilled(true);
				b6.setBackground(Color.WHITE);
				b6.setForeground(Color.BLACK);
				b6.setCursor(null);
				b6.setOpaque(true);
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
		b7.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				b7.setOpaque(true);
				b7.setContentAreaFilled(false);
				b7.setBackground(myblue);
				b7.setForeground(Color.BLUE);
				b7.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b7.setContentAreaFilled(true);
				b7.setBackground(Color.WHITE);
				b7.setForeground(Color.BLACK);
				b7.setCursor(null);
				b7.setOpaque(true);
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
		b8.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b8.setOpaque(true);
				b8.setContentAreaFilled(false);
				b8.setBackground(myblue);
				b8.setForeground(Color.BLUE);
				b8.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b8.setContentAreaFilled(true);
				b8.setBackground(Color.WHITE);
				b8.setForeground(Color.BLACK);
				b8.setCursor(null);
				b8.setOpaque(true);
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
				b9.setOpaque(true);
				b9.setContentAreaFilled(false);
				b9.setBackground(myblue);
				b9.setForeground(Color.BLUE);
				b9.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b9.setContentAreaFilled(true);
				b9.setBackground(Color.WHITE);
				b9.setForeground(Color.BLACK);
				b9.setCursor(null);
				b9.setOpaque(true);
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
//		b10.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//				b10.setOpaque(true);
//				b10.setContentAreaFilled(false);
//				b10.setBackground(myblue);
//				b10.setForeground(Color.BLUE);
//				b10.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				b10.setContentAreaFilled(true);
//				b10.setBackground(Color.WHITE);
//				b10.setForeground(Color.BLACK);
//				b10.setCursor(null);
//				b10.setOpaque(false);
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
	}
	
	public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}  
	public static void main(String args[]) throws Exception{
		
		new WelcomeScreenAndLogin();
	}
	public static void buttonSound() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(buttonPath).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}