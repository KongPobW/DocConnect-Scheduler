package screens;

import runners.Application;
import classes.User;
import utils.AppointManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cancel extends JFrame {

	private final JPanel cancel;
	private JTextField appointID;
	private JPasswordField password;

	public Cancel(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Application.favicon));
		setTitle(Application.appName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1290, 720);
		cancel = new JPanel();
		cancel.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(cancel);
		cancel.setLayout(null);
		
		createField();
		createButton(user);
		createSideBar(user);
		
		JLabel imgCancel = new JLabel("");
		imgCancel.setBounds(0, 5, 1290, 720);
		imgCancel.setIcon(new ImageIcon(Application.cancelGUI));
		cancel.add(imgCancel);
	}
	
	private void createButton(User user) {
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
		cancel.add(btn_logOut);
		
		JButton btn_can = new JButton("");
		btn_can.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleCancel(user);
			}
		});
		btn_can.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_can.setOpaque(false);
		btn_can.setContentAreaFilled(false);
		btn_can.setBorderPainted(false);
		btn_can.setBorder(null);
		btn_can.setBounds(576, 507, 218, 67);
		this.cancel.add(btn_can);
	}
	
	private void createField() {
		appointID = new JTextField();
		appointID.setBorder(null);
		appointID.setFont(new Font("Arial", Font.PLAIN, 28));
		appointID.setBounds(592, 254, 250, 31);
		cancel.add(appointID);
		appointID.setColumns(10);
		
		password = new JPasswordField();
		password.setBorder(null);
		password.setFont(new Font("Arial", Font.PLAIN, 28));
		password.setBounds(592, 390, 250, 31);
		cancel.add(password);
	}
	
	private void createSideBar(User user) {
		JButton cre_sb = new JButton("");
		cre_sb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				Create cre = new Create(user);
				cre.setVisible(true);
			}
		});
		cre_sb.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cre_sb.setOpaque(false);
		cre_sb.setContentAreaFilled(false);
		cre_sb.setBorderPainted(false);
		cre_sb.setBorder(null);
		cre_sb.setBounds(1, 240, 344, 58);
		cancel.add(cre_sb);
		
		JButton can_sb = new JButton("");
		can_sb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				Cancel can = new Cancel(user);
				can.setVisible(true);
			}
		});
		can_sb.setCursor(new Cursor(Cursor.HAND_CURSOR));
		can_sb.setOpaque(false);
		can_sb.setContentAreaFilled(false);
		can_sb.setBorderPainted(false);
		can_sb.setBorder(null);
		can_sb.setBounds(1, 376, 344, 58);
		cancel.add(can_sb);
		
		JButton viw_sb = new JButton("");
		viw_sb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				View viw = new View(user);
				viw.setVisible(true);
			}
		});
		viw_sb.setCursor(new Cursor(Cursor.HAND_CURSOR));
		viw_sb.setOpaque(false);
		viw_sb.setContentAreaFilled(false);
		viw_sb.setBorderPainted(false);
		viw_sb.setBorder(null);
		viw_sb.setBounds(3, 509, 344, 58);
		cancel.add(viw_sb);
	}
	
	private void handleCancel(User user) {
		if (appointID.getText().equals("") || password.getPassword().equals("")) {
			JOptionPane.showMessageDialog(null, "Please type all information");
			return;
		}

		boolean isSuccess = AppointManager.removeAppointment(appointID.getText(), user.getUsername(), new String(password.getPassword()));

		if (isSuccess) {
			JOptionPane.showMessageDialog(null, "Cancel Appointment Successfully");

			dispose();

			Home hom = new Home(user);
			hom.setVisible(true);

		} else {
			JOptionPane.showMessageDialog(null, "Incorrect, please try again");

			appointID.setText("");
			password.setText("");
		}
	}
}