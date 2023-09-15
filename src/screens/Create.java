package screens;

import runners.Application;
import classes.Appointment;
import classes.User;
import utils.AppointManager;
import utils.DatabaseManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Create extends JFrame {

	private final JPanel create;
	private JTextField date;
	private JTextField time;
	private JTextField phone;
	private JComboBox<String> dept;
	private final User savedUser;

	public Create(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Application.favicon));
		setTitle(Application.appName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1290, 720);
		create = new JPanel();
		create.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(create);
		create.setLayout(null);

		savedUser = user;
		
		createField();
		createDrop();
		createButton();
		createSideBar();
		
		JLabel imgCreate = new JLabel("");
		imgCreate.setBounds(0, 5, 1290, 720);
		imgCreate.setIcon(new ImageIcon(Application.createGUI));
		create.add(imgCreate);
	}
	
	private void createButton() {
		JButton btn_logOut = new JButton("");
		btn_logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmLogOut = JOptionPane.showConfirmDialog(null, "Do you confirm to log out?", "Select an Option...", JOptionPane.YES_NO_OPTION);
				
				//yes = 0, no = 1, cancel = 2
				if (confirmLogOut == 0) {
					dispose();
				
					Account acc = new Account();
					acc.setVisible(true);
				}
			}
		});
		btn_logOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_logOut.setOpaque(false);
		btn_logOut.setContentAreaFilled(false);
		btn_logOut.setBorderPainted(false);
		btn_logOut.setBorder(null);
		btn_logOut.setBounds(1196, 5, 85, 86);
		create.add(btn_logOut);
		
		JButton btn_cre = new JButton("");
		btn_cre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleCreate();
			}
		});
		btn_cre.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_cre.setOpaque(false);
		btn_cre.setContentAreaFilled(false);
		btn_cre.setBorderPainted(false);
		btn_cre.setBorder(null);
		btn_cre.setBounds(576, 507, 218, 67);
		create.add(btn_cre);
	}
	
	private void createField() {
		date = new JTextField("YYYY-MM-DD");
		date.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				placeHolderDateGained();
			}
			
			public void focusLost(FocusEvent e) {
				placeHolderDateLost();
			}
		});
		date.setForeground(Color.LIGHT_GRAY);
		date.setBorder(null);
		date.setFont(new Font("Arial", Font.ITALIC, 28));
		date.setBounds(591, 257, 250, 31);
		create.add(date);
		date.setColumns(10);
		
		time = new JTextField("HH:MM:SS");
		time.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				placeHolderTimeGained();
			}

			public void focusLost(FocusEvent e) {
				placeHolderTimeLost();
			}
		});
		time.setForeground(Color.LIGHT_GRAY);
		time.setBorder(null);
		time.setFont(new Font("Arial", Font.ITALIC, 28));
		time.setBounds(915, 257, 250, 31);
		create.add(time);
		time.setColumns(10);
		
		phone = new JTextField("098xxxxxxx");
		phone.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				placeHolderPhoneGained();
			}

			public void focusLost(FocusEvent e) {
				placeHolderPhoneLost();
			}
		});
		phone.setForeground(Color.LIGHT_GRAY);
		phone.setBorder(null);
		phone.setFont(new Font("Arial", Font.PLAIN, 28));
		phone.setBounds(591, 393, 250, 31);
		create.add(phone);
		phone.setColumns(10);
	}
	
	private void createSideBar() {
		JButton cre_sb = new JButton("");
		cre_sb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				Create cre = new Create(savedUser);
				cre.setVisible(true);
			}
		});
		cre_sb.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cre_sb.setOpaque(false);
		cre_sb.setContentAreaFilled(false);
		cre_sb.setBorderPainted(false);
		cre_sb.setBorder(null);
		cre_sb.setBounds(1, 240, 344, 58);
		create.add(cre_sb);
		
		JButton can_sb = new JButton("");
		can_sb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				Cancel can = new Cancel(savedUser);
				can.setVisible(true);
			}
		});
		can_sb.setCursor(new Cursor(Cursor.HAND_CURSOR));
		can_sb.setOpaque(false);
		can_sb.setContentAreaFilled(false);
		can_sb.setBorderPainted(false);
		can_sb.setBorder(null);
		can_sb.setBounds(1, 376, 344, 58);
		create.add(can_sb);
		
		JButton viw_sb = new JButton("");
		viw_sb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				View viw = new View(savedUser);
				viw.setVisible(true);
			}
		});
		viw_sb.setCursor(new Cursor(Cursor.HAND_CURSOR));
		viw_sb.setOpaque(false);
		viw_sb.setContentAreaFilled(false);
		viw_sb.setBorderPainted(false);
		viw_sb.setBorder(null);
		viw_sb.setBounds(3, 509, 344, 58);
		create.add(viw_sb);
	}
	
	private void createDrop() {
		dept = new JComboBox<String>();
		dept.setBorder(null);
		dept.setFont(new Font("Arial", Font.PLAIN, 22));
		dept.setBounds(915, 393, 250, 31);
		create.add(dept);
		
		try {

			Connection con = DatabaseManager.getConnection();

			assert con != null;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM doc_connect.department");

			dept.addItem("Choose...");

			while (rs.next()) {
				dept.addItem(rs.getString("Dname"));
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	private void placeHolderDateGained() {
		if (date.getText().equals("YYYY-MM-DD")) {
			date.setText("");
			date.setForeground(Color.BLACK);
			date.setFont(new Font("Arial", Font.PLAIN, 28));
		}
	}

	private void placeHolderDateLost() {
		if (date.getText().equals("")) {
			date.setForeground(Color.LIGHT_GRAY);
			date.setFont(new Font("Arial", Font.ITALIC, 28));
			date.setText("YYYY-MM-DD");
		}
	}

	private void placeHolderTimeGained() {
		if (time.getText().equals("HH:MM:SS")) {
			time.setText("");
			time.setForeground(Color.BLACK);
			time.setFont(new Font("Arial", Font.PLAIN, 28));
		}
	}

	private void placeHolderTimeLost() {
		if (time.getText().equals("")) {
			time.setForeground(Color.LIGHT_GRAY);
			time.setFont(new Font("Arial", Font.ITALIC, 28));
			time.setText("HH:MM:SS");
		}
	}

	private void placeHolderPhoneGained() {
		if (phone.getText().equals("098xxxxxxx")) {
			phone.setText("");
			phone.setForeground(Color.BLACK);
			phone.setFont(new Font("Arial", Font.PLAIN, 28));
		}
	}

	private void placeHolderPhoneLost() {
		if (phone.getText().equals("")) {
			phone.setForeground(Color.LIGHT_GRAY);
			phone.setFont(new Font("Arial", Font.ITALIC, 28));
			phone.setText("098xxxxxxx");
		}
	}
	
	private void handleCreate() {
		Appointment appointment = new Appointment(date.getText(), time.getText(), phone.getText(), dept.getSelectedItem().toString(), savedUser.getUsername());

		if (appointment.getDate().equals("YYYY-MM-DD") || appointment.getTime().equals("HH:MM:SS") || appointment.getPhoneNumber().equals("098xxxxxxx")) {
			JOptionPane.showMessageDialog(null, "Please type all information");
			return;
		} else if (appointment.getDepartment().equals("Choose...")) {
			JOptionPane.showMessageDialog(null, "Please choose the department");
			return;
		}

		AppointManager.addAppointment(appointment);

		JOptionPane.showMessageDialog(null, "Create Appointment Successfully");

		dispose();

		Home hom = new Home(savedUser);
		hom.setVisible(true);
	}
}