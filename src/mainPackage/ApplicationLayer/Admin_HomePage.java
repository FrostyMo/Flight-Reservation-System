package mainPackage.ApplicationLayer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
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

import mainPackage.BusinessLayer.Admin_Handler;

class Admin_HomePage {

	JFrame adminHomeFrame;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l10, l11;
	JPasswordField pf1, pf2, pf3;
	JPanel p1;
	JPanel p2, p4;
	protected Component tf1;
	protected Component tf2;
	String adminName;
	String Password;
	String workingDirectory;
	String requiredDirectory;
	final static Color mypurp = new Color(106, 13, 173);
	final static Color myred = new Color(75, 25, 27);
	Admin_Handler aH;

	Admin_HomePage(String adminName) {
		this.adminName = adminName;
		adminHomeFrame = new JFrame("Admin Homepage");
		adminHomeFrame.setLayout(null);
		adminHomeFrame.setSize(700, 495);
		adminHomeFrame.setLocation((1366 - 700) / 2, (768 - 495) / 2);

		aH = new Admin_Handler();

		b1 = new JButton("Employee");
		b2 = new JButton("Flights");
		b3 = new JButton("Change Password");
		b4 = new JButton("Logout");
		b5 = new JButton("Create Employee");
		b6 = new JButton("Delete Employee");
		b7 = new JButton("View Employees");
		b8 = new JButton("Add Flight");
		b9 = new JButton("Delete Flight");
		b10 = new JButton("View Flights");
		b12 = new JButton("Update Flights");
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
		l11 = new JLabel();

		pf1 = new JPasswordField();
		pf2 = new JPasswordField();
		pf3 = new JPasswordField();
		p1 = new JPanel();
		p2 = new JPanel();
		p4 = new JPanel();

		l4.setBounds(100, 150, 150, 150);
		l5.setBounds(310, 150, 150, 150);
		l6.setBounds(520, 150, 150, 150);
		
		l7.setBounds(80, 150, 150, 150);
		l8.setBounds(230, 150, 150, 150);
		l10.setBounds(380, 150, 150, 150);
		l11.setBounds(530, 150, 150, 150);
		String imageName1 = "createEmp.png";
		String imageName2 = "deleteEmp.png";
		String imageName3 = "viewEmp.png";
		String imageName4 = "add.png";
		String imageName5 = "delete.png";
		String imageName7 = "view.png";
		workingDirectory = System.getProperty("user.dir");
		requiredDirectory = workingDirectory + "/" + "src/mainPackage/images/";
		try {

			l4.setIcon(new ImageIcon(ImageIO.read(new File(requiredDirectory + imageName1))));
			l5.setIcon(new ImageIcon(ImageIO.read(new File(requiredDirectory + imageName2))));
			l6.setIcon(new ImageIcon(ImageIO.read(new File(requiredDirectory + imageName3))));
			l7.setIcon(new ImageIcon(ImageIO.read(new File(requiredDirectory + imageName4))));
			l8.setIcon(new ImageIcon(ImageIO.read(new File(requiredDirectory + imageName5))));
			l10.setIcon(new ImageIcon(ImageIO.read(new File(requiredDirectory + imageName7))));
			l11.setIcon(new ImageIcon(ImageIO.read(new File(requiredDirectory + imageName1))));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		p1.setLayout(null);
		p2.setLayout(null);
		p4.setLayout(null);
		b1.setBounds(0, 405, 175, 50);
		b2.setBounds(175, 405, 175, 50);
		b3.setBounds(350, 405, 175, 50);
		b4.setBounds(525, 405, 175, 50);
		b5.setBounds(70, 300, 150, 30);
		b6.setBounds(280, 300, 150, 30);
		b7.setBounds(490, 300, 150, 30);
		b8.setBounds(70, 300, 120, 30);
		b9.setBounds(220, 300, 120, 30);
		b10.setBounds(370, 300, 120, 30);
		b12.setBounds(520, 300, 120, 30);
		
		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b10.setBackground(Color.WHITE);
		b11.setBackground(Color.WHITE);
		b12.setBackground(Color.WHITE);
		
		b1.setFocusable(false);
		b2.setFocusable(false);
		b3.setFocusable(false);
		b4.setFocusable(false);
		b5.setFocusable(false);
		b6.setFocusable(false);
		b7.setFocusable(false);
		b8.setFocusable(false);
		b9.setFocusable(false);
		b10.setFocusable(false);
		b11.setFocusable(false);
		b12.setFocusable(false);
		b5.setBorder(WelcomeScreenAndLogin.BORDERBLACK);
		b6.setBorder(WelcomeScreenAndLogin.BORDERBLACK);
		b7.setBorder(WelcomeScreenAndLogin.BORDERBLACK);
		b8.setBorder(WelcomeScreenAndLogin.BORDERBLACK);
		b9.setBorder(WelcomeScreenAndLogin.BORDERBLACK);
		b10.setBorder(WelcomeScreenAndLogin.BORDERBLACK);
		b11.setBorder(WelcomeScreenAndLogin.BORDERBLACK);
		b12.setBorder(WelcomeScreenAndLogin.BORDERBLACK);
		
		
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
		b11.setOpaque(true);
		b12.setOpaque(true);
		
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

			myImage = ImageIO.read(new File(requiredDirectory + "bear.jpg"));
			myImage = WelcomeScreenAndLogin.resize(myImage, 710, 450);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adminHomeFrame.setContentPane(new ImagePanel(myImage));

		p1.setVisible(false);
		p2.setVisible(false);
		p4.setVisible(false);

		p1.setOpaque(false);
		p2.setOpaque(false);
		// p4.setOpaque(false);
		// p3.setBorder();
		p1.add(b5);
		p1.add(b6);
		p1.add(b7);
		p1.add(l4);
		p1.add(l5);
		p1.add(l6);
		p2.add(b8);
		p2.add(b9);
		p2.add(b10);
		p2.add(b12);
		p2.add(l7);
		p2.add(l8);
		p2.add(l10);
		p2.add(l11);
		p4.add(l1);
		p4.add(l2);
		p4.add(l3);
		p4.add(pf1);
		p4.add(pf2);
		p4.add(pf3);
		p4.add(b11);

		adminHomeFrame.add(b1);
		adminHomeFrame.add(b2);
		adminHomeFrame.add(b3);
		adminHomeFrame.add(b4);
		adminHomeFrame.add(p1);
		adminHomeFrame.add(p2);
		adminHomeFrame.add(p4);
		adminHomeFrame.setResizable(false);
		adminHomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminHomeFrame.setVisible(true);
		// Employee Button
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				p2.setVisible(false);
				p4.setVisible(false);
				p1.setVisible(true);
			}
		});
		// Flights button
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				p1.setVisible(false);
				p4.setVisible(false);
				p2.setVisible(true);
			}
		});
		// Change Password button
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				p1.setVisible(false);
				p2.setVisible(false);
				p4.setVisible(true);
			}
		});
		// Logout Button
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				adminHomeFrame.setVisible(false);
				new WelcomeScreenAndLogin();
			}
		});
		// Create employee button
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				// adminHomeFrame.setVisible(false);
				new Admin_CreateEmployee();
			}
		});
		// delete employee button
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				new Admin_DeleteEmployee();
			}
		});
		// viewEmployee
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				// connect to database
				new Admin_ViewEmployees();
			}
		});
		// add flight button
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				new Admin_AddFlight();
			}
		});

		// delete flight button
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				new Admin_DeleteFlight();
			}
		});

		// Update Flight
		b12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				new Admin_UpdateBooking();
			}
		});

		// change password button
		b11.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				if (pf2.getText().equals(pf3.getText())) {
					if (ChangeAdminPassword(pf1.getText(), pf2.getText())) {
						JOptionPane.showMessageDialog(p4, "Password Updated Successfully", "Success!",
								JOptionPane.INFORMATION_MESSAGE);
						p4.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(p4, "Old Password in incorrect", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else
					JOptionPane.showMessageDialog(adminHomeFrame, "New Passwords do not match", "Password Error",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		// view flights button
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WelcomeScreenAndLogin.buttonSound();
				new Admin_ViewFlights();
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
				b1.setOpaque(true);
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
				b4.setBorderPainted(false);
				b4.setOpaque(true);
				b4.setBackground(mypurp);
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
				b5.setBorderPainted(false);
				b5.setOpaque(true);
				b5.setBackground(myred);
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
				b6.setBorderPainted(false);
				b6.setOpaque(true);
				b6.setBackground(myred);
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
				b7.setBorderPainted(false);
				b7.setOpaque(true);
				b7.setBackground(myred);
				b7.setForeground(Color.WHITE);
				b7.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b7.setBorderPainted(true);
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
				b8.setBorderPainted(false);
				b8.setOpaque(true);
				b8.setBackground(myred);
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
				b9.setBorderPainted(false);
				b9.setOpaque(true);
				b9.setBackground(myred);
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
		b10.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b10.setBorderPainted(false);
				b10.setOpaque(true);
				b10.setBackground(myred);
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
				b10.setOpaque(true);
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
		b12.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b12.setBorderPainted(false);
				b12.setOpaque(true);
				b12.setBackground(myred);
				b12.setForeground(Color.WHITE);
				b12.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				b12.setBorderPainted(true);
				b12.setBackground(Color.WHITE);
				b12.setForeground(Color.BLACK);
				b12.setCursor(null);
				b12.setOpaque(true);
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
				b11.setOpaque(true);
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

	protected boolean ChangeAdminPassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		if (validatePassword(oldPassword)) {
			return aH.UpdatePassword(newPassword, adminName);
		} else {
			return false;
		}
	}

	private boolean validatePassword(String oldPassword) {
		// TODO Auto-generated method stub
		String pass = null;
		try {
			pass = aH.FindPassword(adminName);
			if (pass.equals(oldPassword))
				return true;
			else
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public static JPanel adminPanel() {
		JPanel myPanel = new JPanel() {
			   protected void paintComponent(Graphics g) {
			      Paint p = new GradientPaint(0.0f, 0.0f, new Color(192, 173, 131, 200),
			       getWidth(), getHeight(), new Color(142, 123, 100, 255), true);
			      Graphics2D g2d = (Graphics2D)g;
			      g2d.setPaint(p);
			      g2d.fillRect(0, 0, getWidth(), getHeight());
			   }
		};
		return myPanel;
	}
}
