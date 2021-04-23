package mainPackage.ApplicationLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.text.JTextComponent;

import mainPackage.BusinessLayer.Admin_Handler;

public class Admin_ViewFlights {

	JFrame f10;
	JTable t1;
	JScrollPane tableContainer;
	Admin_Handler flightObj = new Admin_Handler();
	JComboBox<String> sortList;
	String columns[];
	Admin_ViewFlights() {
		
		ArrayList<String[]> ar = getData("FLIGHT_ID");
    	String data[][] = new String[ar.size()][11];
    	for(int i = 0; i<ar.size(); i++) {
    		data[i]= ar.get(i);
    		
    	}
		
		f10 = new JFrame("Flights Details");
		f10.setLayout(new FlowLayout());
		//connect to database
		String columns1[] = {"Flight ID", "Plane ID", 
				"FROM", "TO", "Departure Time",  "Arrival Time", "Date", "Base Amount", "Total Seats", "Available Seats", "Arrival Status"};
		columns = columns1;
		
		//// New Code added for filters
		String sorters[] = {"Flight ID", "Source", "Destination", "Date"};
		sortList = new JComboBox<String>(sorters);
		
		t1 = new JTable(data, columns);
		t1.setPreferredScrollableViewportSize(new Dimension(1200, 200));
	    t1.setFillsViewportHeight(true);
	    t1.setBackground(new Color(0,102,102));
	    t1.setForeground(Color.WHITE);
	    t1.setOpaque(true);
	    t1.setGridColor(new Color(0,102,102));
	    
	    tableContainer = new JScrollPane(t1);
	    f10.add(sortList);
		f10.getContentPane().add(tableContainer, BorderLayout.CENTER);
		f10.setSize(600, 600);
	    f10.setLocation((1366-600)/2, (768-600)/2);
	    f10.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    //panel.add(tableContainer, BorderLayout.CENTER);
	    f10.pack();
	    f10.getContentPane().setBackground( Color.GRAY );
	    f10.setVisible(true);
		
	    
    	sortList.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				WelcomeScreenAndLogin.buttonSound();
				// TODO Auto-generated method stub
				if (sortList.getSelectedItem() == "Flight ID")
					DrawTable("FLIGHT_ID");
				else if (sortList.getSelectedItem() == "Source")
					DrawTable("SRC");
				else if (sortList.getSelectedItem() == "Destination")
					DrawTable("DESTINATION");
				else if (sortList.getSelectedItem() == "Date")
					DrawTable("FLIGHT_DATE");
			}
			
		});
    	
    	t1.addMouseListener(new MouseAdapter() {
    		  public void mouseClicked(MouseEvent e) {

    		        Integer row = t1.getSelectedRow();
    		        Integer col = t1.getSelectedColumn();

    		        //build your address / link

    		        System.out.println("ROW: " + row.toString() + ", COL: " + col.toString() );
    		      }
    		    });
	}

	private void DrawTable(String choiceOfSort) {
		
		ArrayList<String[]> ar = getData(choiceOfSort);
    	String data[][] = new String[ar.size()][11];
    	for(int i = 0; i<ar.size(); i++) {
    		data[i]= ar.get(i);
    		
    	}
		
    	if(data[0]==null) {
			JOptionPane.showMessageDialog(null, "Unable to Extract the Flights",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else {
			Component[] components = f10.getContentPane().getComponents();
		    for (Component component : components) {
		        if (component instanceof JScrollPane || component instanceof JTable) {
		            f10.remove(component);
		        }
		    }
			
			System.out.println("I AM IN HERE++++++");
		    t1 = new JTable(data, columns);
		    
		    t1.setPreferredScrollableViewportSize(new Dimension(1200, 200));
		    t1.setFillsViewportHeight(true);
		    t1.setBackground(new Color(0,102,102));
		    t1.setForeground(Color.WHITE);
		    t1.setOpaque(true);
		    
		    t1.setGridColor(new Color(0,102,102));
		    
		    
		    tableContainer = new JScrollPane(t1);
		    ;
		    //f10.add(sortList);
			f10.getContentPane().add(tableContainer, BorderLayout.CENTER);
			
			
			f10.invalidate();
			f10.validate();
			f10.repaint();
		}
	}
	private ArrayList<String[]> getData(String choice) 
	{
		// TODO Auto-generated method stub
		ArrayList<String[]> ar = new ArrayList<String[]>();
		
		ar = flightObj.ViewSched(choice);
		
		return ar;
	}
}
