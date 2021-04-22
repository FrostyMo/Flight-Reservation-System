package mainPackage.ApplicationLayer;

import java.awt.Color;
import java.awt.Cursor;
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

import mainPackage.BusinessLayer.Admin_Handler;

public class Admin_DeleteFlight {

	JFrame f9;
	JLabel l1, l2, l3, l4, l5, l6, l7;
	JComboBox<String> cb1;
	JButton b1, b2;
	private String flightID;
	private String flightName;
	private String from;
	private String to;
	
	Admin_Handler flightObj;
	
	public Admin_DeleteFlight() {
		f9 = new JFrame("Delete Flight");
		l1 = new JLabel("Select Flight ID : ");
		l2 = new JLabel("Flight Name : ");
		l3 = new JLabel("From : ");
		l4 = new JLabel("To : ");
		l5 = new JLabel();
		l6 = new JLabel();
		l7 = new JLabel();
		cb1 = new JComboBox<String>();
		b1 = new JButton("OK");
		b2 = new JButton("Cancel");
		flightObj = new Admin_Handler();
		
		l1.setBounds(30, 40, 150, 30);
		l2.setBounds(30, 90, 150, 30);
		l3.setBounds(30, 140, 150, 30);
		l4.setBounds(30, 190, 150, 30);
		cb1.setBounds(220, 40, 200, 30);
		l5.setBounds(220, 90, 200, 30);
		l6.setBounds(220, 140, 200, 30);
		l7.setBounds(220, 190, 200, 30);
		
		b1.setBounds(40, 250, 150, 30);
		b2.setBounds(220, 250, 150, 30);
		
		getFlights();
		f9.add(l1);
		f9.add(l2);
		f9.add(l3);
		f9.add(l4);
		f9.add(l5);
		f9.add(l6);
		f9.add(l7);
		f9.add(cb1);
		f9.add(b1);
		f9.add(b2);
		
		l5.setBackground(Employee_HomePage.myblue);
		l6.setBackground(Employee_HomePage.myblue);
		l7.setBackground(Employee_HomePage.myblue);
		l5.setForeground(Color.WHITE);
		l6.setForeground(Color.WHITE);
		l7.setForeground(Color.WHITE);
		l5.setOpaque(true);
		l6.setOpaque(true);
		l7.setOpaque(true);
		
		f9.setLayout(null);
		f9.setSize(450, 350);
		f9.setLocation((1366-450)/2, (768-350)/2);
		f9.setVisible(true);
		f9.setResizable(false);
		f9.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				if(cb1.getSelectedIndex()>0) {
					if(deleteRecord()) {
						JOptionPane.showMessageDialog(f9, "Flight Deleted");
						f9.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(f9, "Error",
						"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(f9, 
					"Please Select a Flight ID ", "Invalid", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				f9.setVisible(false);
				//new AdminLogin();
			}
		});
		
		cb1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				WelcomeScreenAndLogin.buttonSound();
				// TODO Auto-generated method stub
				//System.out.println(cb1.getSelectedIndex());
				if(cb1.getSelectedItem()!="") {
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
		l5.setText("");
	}
	
	protected void setInfoLabels() {
		// TODO Auto-generated method stub
		clearLabels();
		l5.setText(flightName);
		l6.setText(from);
		l7.setText(to);
	}
	
	private void initializeDetails() 
	{
		/*
		 * // TODO Auto-generated method stub */
		flightID = (String) cb1.getSelectedItem();
		flightName = flightObj.getPlaneName(flightID);
		from = flightObj.getSource(flightID);
		to = flightObj.getDest(flightID);
		setInfoLabels();
		
		
	}
	
	private boolean deleteRecord() 
	{
		// TODO Auto-generated method stub */
		if (!flightObj.Delete(flightID))
			return false;
		return true;
	}
	
	private void getFlights() 
	{
		cb1.addItem("");
		String[] flightIDs = flightObj.getAllFlightIDs();
		for (int i=0; i<flightIDs.length; i++) {
			cb1.addItem(flightIDs[i]);
		}
		
	}
}