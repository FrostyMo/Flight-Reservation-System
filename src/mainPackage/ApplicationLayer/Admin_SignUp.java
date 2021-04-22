package mainPackage.ApplicationLayer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import mainPackage.BusinessLayer.Admin_Handler;

public class Admin_SignUp {
	JFrame f5 ;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, lempID, signup_label;
	JTextField tName, tAge, tCnic, tPhone, tGender, tNationality, tPassport;
	JPasswordField pf1;
	JTextArea ta1;
	JButton b1, b2, b3;
	JScrollPane sp1;
	
	private String AdminID;
	private String AdminName;
	private String AdminPassword;
	private int age;
	private String AdminAddress;
	private String gender;
	private long phone;
	private String nation;
	private long passport;
	private long cnic;
	private String joinDate;
	Admin_Handler aH;
	
	final static Color myblue = new Color(6, 13, 83);
	final static Color mygrey = new Color(42, 42, 42);
	final static Color myred = new Color(75, 25, 27);
	final static Color mypurp = new Color(106,13,173);
	
	final static Font LABELFONT = new Font("Bradley Hand ITC", Font.BOLD, 20);
	// Person_ID,Assistant_ID,Assistant_Password,Join_Date
	//Person_ID,Person_Name,CNIC,Age,Address,Gender,Nationality,Phone_No,Passport_No
	public Admin_SignUp() {
		aH = new Admin_Handler();
		f5 = new JFrame("Admin SignUp");
		l1 = new JLabel("Admin ID : ");
		l2 = new JLabel("Admin Name  : ");
		l3 = new JLabel("Password  : ");
		l4 = new JLabel("CNIC  : ");
		l5 = new JLabel("Address: ");
		l6 = new JLabel("Age : ");
		l7 = new JLabel("Gender (M/F) : ");
		l8 = new JLabel("Nationality : ");
		l9 = new JLabel("Phone No : ");
		l10 = new JLabel("Passport No : ");
		lempID = new JLabel();
		tName = new JTextField();
		tCnic = new JTextField();
		tAge = new JTextField();
		tGender = new JTextField();
		tNationality = new JTextField();
		tPhone = new JTextField();
		tPassport = new JTextField();
		
		pf1 = new JPasswordField();
		ta1 = new JTextArea();
		
		b1 = new JButton("Create");
		b2 = new JButton("Back");
		b3 = new JButton("Clear");
		sp1 = new JScrollPane(ta1);
		
		l1.setBounds(40, 50, 140, 30);
		l2.setBounds(40, 100, 140, 30);
		l3.setBounds(40, 150, 140, 30);
		l4.setBounds(40, 200, 140, 30);
		l5.setBounds(40, 250, 140, 30);
		l6.setBounds(40, 370, 140, 30);
		l7.setBounds(40, 420, 140, 30);
		l8.setBounds(40, 470, 140, 30);
		l9.setBounds(40, 520, 140, 30);
		l10.setBounds(40, 570, 140, 30);
		lempID.setBounds(200, 50, 300, 30);
		tName.setBounds(200, 100, 300, 30);
		pf1.setBounds(200, 150, 300, 30);
		tCnic.setBounds(200, 200, 300, 30);
		ta1.setBounds(205, 250, 290, 100);
		tAge.setBounds(200, 370, 300, 30);
		tGender.setBounds(200, 420, 300, 30);
		tNationality.setBounds(200,470,300,30);
		tPhone.setBounds(200,520,300,30);
		tPassport.setBounds(200,570,300,30);
		
		b1.setBounds(80, 620, 150, 30);
		b2.setBounds(270, 620, 120, 30);
		b3.setBounds(460, 620, 120, 30);
		//sp1.setBounds(250, 260, 300, 40);
		/*
		l1.setFont(LABELFONT);
		l2.setFont(LABELFONT);
		l3.setFont(LABELFONT);
		l4.setFont(LABELFONT);
		l5.setFont(LABELFONT);
		l6.setFont(LABELFONT);
		l7.setFont(LABELFONT);
		
		//BufferedImage myImage = null;
		//try {
		//	myImage = ImageIO.read(new File("C:/image12.jpg"));
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//f5.setContentPane(new ImagePanel(myImage));
		*/
		f5.setLayout(null);
		f5.setSize(640, 700);
		f5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f5.setLocation((1366-640)/2, (768-700)/2);
		lempID.setOpaque(true);
		lempID.setBackground(Admin_HomePage.myred);
		lempID.setForeground(Color.WHITE);
		f5.setResizable(false);
		f5.add(l1);
		f5.add(l2);
		f5.add(l3);
		f5.add(l4);
		f5.add(l5);
		f5.add(l6);
		f5.add(l7);
		f5.add(l8);
		f5.add(l9);
		f5.add(l10);
		f5.add(lempID);
		f5.add(tName);
		f5.add(tAge);
		f5.add(tCnic);
		f5.add(ta1);
		f5.add(pf1);
		f5.add(tPhone);
		f5.add(tNationality);
		f5.add(tGender);
		f5.add(tPassport);
		
		f5.add(b1);
		f5.add(b2);
		f5.add(b3);
		f5.add(sp1);
		f5.setVisible(true);
		AdminID = aH.GenerateAdmID();
		lempID.setText(AdminID);
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				if(validateForm()) {
					initializeDetails();
					if(createRecord()) {
						JOptionPane.showMessageDialog(f5, "Admin Created");
						f5.setVisible(false);
					}
					else{
						JOptionPane.showMessageDialog(f5, "Record Not Created");
					}
				}
				else{
						JOptionPane.showMessageDialog(f5,  "Fill all the details", 
								"Error", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				f5.setVisible(false);
			}
		});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				Component[] components = f5.getContentPane().getComponents();
			    for (Component component : components) {
			        if (component instanceof JTextField || component instanceof JTextArea) {
			            JTextComponent specificObject = (JTextComponent) component;
			            specificObject.setText("");
			        }
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
		
	}// end of constructor
	@SuppressWarnings("deprecation")
	private boolean validateForm() {
		if(((tName.getText().length())==0)||((tName.getText().length())==0)||((tAge.getText().length())==0)
				||((pf1.getText().length())==0)||ta1.getText().length()==0||(tPhone.getText().length()==0)||tCnic.getText().length()==0)
			return false;
		else 
			return true;
	}
	
	@SuppressWarnings("deprecation")
	public void initializeDetails() {
		try {
		
		AdminName = tName.getText();
		AdminPassword = pf1.getText();
		age = Integer.parseInt(tAge.getText());
		AdminAddress = ta1.getText();
		cnic = Long.parseLong(tCnic.getText());
		phone = Long.parseLong(tPhone.getText());
		nation = tNationality.getText();
		gender = tGender.getText();
		passport = Long.parseLong(tPassport.getText());
		
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(f5, "Enter Valid Details", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean createRecord() 
	{
		String pattern = "dd/MM/yyyy";
		joinDate =new SimpleDateFormat(pattern).format(new Date());
		return aH.AddAdmin(AdminID, AdminName, AdminPassword, cnic, age, gender, AdminAddress, joinDate, nation, phone, passport);
	}
}

