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
import javax.swing.JTextArea;

import mainPackage.BusinessLayer.Employee_Handler;

public class Employee_Support {

	JFrame f9;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8,l9;
	JComboBox<String> cb1;
	JTextArea queryText, responseText;
	JButton b1, b2;
	private String ticketID;
	private String customerID;
	private String assistantID;
	private String query;
	private String response;
	
	Employee_Handler empObj;
	
	public Employee_Support(String ID) {
		assistantID = ID;
		f9 = new JFrame("Customer Support");
		l1 = new JLabel("Select Ticket ID : ");
		l2 = new JLabel("Customer ID : ");
		l3 = new JLabel("Assistant ID : ");
		l4 = new JLabel("Query : ");
		l5 = new JLabel("Response : ");
		l6 = new JLabel();
		l7 = new JLabel();
		queryText = new JTextArea();
		responseText = new JTextArea();
		
		cb1 = new JComboBox<String>();
		b1 = new JButton("Respond");
		b2 = new JButton("Cancel");
		empObj = new Employee_Handler();
		
		l1.setBounds(30, 40, 150, 30);
		l2.setBounds(30, 90, 150, 30);
		l3.setBounds(30, 140, 150, 30);
		l4.setBounds(30, 190, 150, 30);
		l5.setBounds(30, 330, 150, 30);
		
		cb1.setBounds(215, 40, 200, 30);
		l6.setBounds(220, 90, 150, 30);
		l7.setBounds(220, 140, 150, 30);
		//l8.setBounds(30, 190, 150, 30);
		//l9.setBounds(30, 240, 150, 30);
		
		queryText.setBounds(220, 190, 380, 120);
		responseText.setBounds(220, 330, 380, 120);
		
		b1.setBounds(170, 480, 150, 30);
		b2.setBounds(350, 480, 150, 30);
		
		getCustomers();
		f9.add(l1);
		f9.add(l2);
		f9.add(l3);
		f9.add(l4);
		f9.add(l5);
		f9.add(l6);
		f9.add(l7);
		f9.add(cb1);
		f9.add(queryText);
		f9.add(responseText);
		f9.add(b1);
		f9.add(b2);
		
		//l5.setBackground(EmployeeHomePage.myblue);
		l6.setBackground(Employee_HomePage.mygrey);
		l7.setBackground(Employee_HomePage.mygrey);
		//l5.setForeground(Color.WHITE);
		l6.setForeground(Color.WHITE);
		l7.setForeground(Color.WHITE);
		//l5.setOpaque(true);
		l6.setOpaque(true);
		l7.setOpaque(true);
		
		f9.setLayout(null);
		f9.setSize(700, 550);
		f9.setLocation((1366-600)/2, (768-550)/2);
		f9.setVisible(true);
		f9.setResizable(false);
		f9.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				if(cb1.getSelectedIndex()>0 && responseText.getText()!="") {
					response = responseText.getText();
					if(respondToCustomer()) {
						JOptionPane.showMessageDialog(f9, "Response Sent");
						f9.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(f9, "Error",
						"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(f9, 
					"Please Select a Ticket ID and Enter Response", "Invalid", JOptionPane.ERROR_MESSAGE);
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
				if(cb1.getSelectedItem()!="" && arg0.getStateChange() == ItemEvent.SELECTED) {
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
	}
	
	protected void setInfoLabels() {
		// TODO Auto-generated method stub
		clearLabels();
		l6.setText(customerID);
		l7.setText(assistantID);
		queryText.setText(query);
	}
	
	protected void initializeDetails() 
	{
		
		ticketID = (String) cb1.getSelectedItem();
		query = empObj.getResponses(ticketID);
		customerID = empObj.getCustomerID(ticketID);
		
		setInfoLabels();
		
		
	}
	
	protected boolean respondToCustomer() 
	{
		return empObj.respondToCustomer(ticketID, customerID, assistantID, response);
	}
	
	public void getCustomers() 
	{
		cb1.addItem("");
		String[] ticketIDs = empObj.getCustomerSupportIDs();
		for (int i=0; i<ticketIDs.length; i++) {
			cb1.addItem(ticketIDs[i]);
		}
		
	}
}
