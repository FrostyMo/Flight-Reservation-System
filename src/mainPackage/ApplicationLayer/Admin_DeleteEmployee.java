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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mainPackage.BusinessLayer.Admin_Handler;

public class Admin_DeleteEmployee {

	JFrame f6;
	JPanel myPanel;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
	JComboBox<String> cb1;
	JButton b1, b2;
	private String employeeName;
	private String employeeID;
	private String address;
	private Long contact;
	private String joinDate;
	private String age;
	Admin_Handler aH;
	public Admin_DeleteEmployee() {
		f6 = new JFrame("Delete Employee");
		l1 = new JLabel("<html><span style='size: 14'><b>Select Employee ID : </b></span></html>");
		l2 = new JLabel("<html><span style='size: 14'><b>Employee Name : </b></span></html>v");
		l3 = new JLabel("<html><span style='size: 14'><b>Address : </b></span></html>");
		l4 = new JLabel("<html><span style='size: 14'><b>Contact : </b></span></html>");
		l5 = new JLabel("<html><span style='size: 14'><b>Age : </b></span></html>");
		l10 = new JLabel("<html><span style='size: 14'><b>Join Date : </b></span></html>");
		l6 = new JLabel();
		l7 = new JLabel();
		l8 = new JLabel();
		l9 = new JLabel();
		l11 = new JLabel();
		
		aH = new Admin_Handler();
		
		cb1 = new JComboBox<String>();
		b1 = new JButton("OK");
		b2 = new JButton("Cancel");
		
		myPanel = Admin_HomePage.adminPanel();
		myPanel.setLayout(null);
		f6.getContentPane().setBackground(new Color(0,0,0,0));
		
		getEmployeeID();
		l1.setBounds(30, 40, 150, 30);
		l2.setBounds(30, 90, 150, 30);
		l3.setBounds(30, 140, 150, 30);
		l4.setBounds(30, 190, 150, 30);
		l5.setBounds(30, 240, 150, 30);
		l10.setBounds(30, 290, 150, 30);
		cb1.setBounds(220, 40, 200, 30);
		l6.setBounds(220, 90, 200, 30);
		l7.setBounds(220, 140, 200, 30);
		l8.setBounds(220, 190, 200, 30);
		l9.setBounds(220, 240, 200, 30);
		l11.setBounds(220, 290, 200, 30);
		b1.setBounds(40, 310, 150, 30);
		b2.setBounds(220, 310, 150, 30);
		
		myPanel.add(l1);
		myPanel.add(l2);
		myPanel.add(l3);
		myPanel.add(l4);
		myPanel.add(l5);
		myPanel.add(l6);
		myPanel.add(l7);
		myPanel.add(l8);
		myPanel.add(l9);
		myPanel.add(cb1);
		myPanel.add(b1);
		myPanel.add(b2);
		
		l7.setBackground(Employee_HomePage.mygrey);
		l8.setBackground(Employee_HomePage.mygrey);
		l9.setBackground(Employee_HomePage.mygrey);
		l6.setBackground(Employee_HomePage.mygrey);
		l7.setForeground(Color.WHITE);
		l8.setForeground(Color.WHITE);
		l9.setForeground(Color.WHITE);
		l6.setForeground(Color.WHITE);
		l7.setOpaque(true);
		l8.setOpaque(true);
		l9.setOpaque(true);
		l6.setOpaque(true);
		
		f6.setLayout(null);
		f6.setPreferredSize(new Dimension(450,420));
		f6.setLocation((1366-450)/2, (768-420)/2);
		f6.setContentPane(myPanel);
		f6.pack();
		f6.setVisible(true);
		f6.setResizable(false);
		f6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				if(cb1.getSelectedIndex()>0) {
					if(deleteRecord()) {
						JOptionPane.showMessageDialog(f6, "Employee Deleted");
						f6.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(f6, "Error",
						"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(f6, 
					"Please Select a Employee ID ", "Invalid", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				f6.setVisible(false);
				//new AdminLogin();
			}
		});

		cb1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				WelcomeScreenAndLogin.buttonSound();
				// TODO Auto-generated method stub
				//System.out.println(cb1.getSelectedIndex());
				if(cb1.getSelectedItem()!="" && ItemEvent.SELECTED == arg0.getStateChange()) {
					initializeDetails();
				}
				else {
					clearLabels();
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
	}//end of constructor

	private void clearLabels() {
		l6.setText("");
		l7.setText("");
		l8.setText("");
		l9.setText("");
	}
	
	protected void setInfoLabels() {
		// TODO Auto-generated method stub
		clearLabels();
		l6.setText(employeeName);
		l7.setText(address);
		l8.setText(""+contact);
		l9.setText(age);
		l11.setText(joinDate);
	}
	
	protected void initializeDetails() 
	{
		employeeID = (String) cb1.getSelectedItem();
		employeeName = aH.getEmployeeName(employeeID);
		String[] info = aH.getEmployeeInfo(employeeID);
		age = info[0];
		address = info[1];
		joinDate = info[2];
		contact = Long.parseLong(info[3]);
		setInfoLabels();
	}

	protected boolean deleteRecord() 
	{
		return aH.DeleteEmployee(employeeID);
	}//end of deleteRecord()
	
	private void getEmployeeID() 
	{
		cb1.addItem("");
		String[] ar = aH.getAllEmployeeIDs();
		for (int i=0; i<ar.length;i++) {
			cb1.addItem(ar[i]);
		}
	}
}
