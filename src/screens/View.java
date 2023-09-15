package screens;

import runners.Application;
import classes.Appointment;
import classes.User;
import utils.AppointManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.util.ArrayList;

public class View extends JFrame {

	private final JPanel view;

	public View(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Application.favicon));
		setTitle(Application.appName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1290, 720);
		view = new JPanel();
		view.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(view);
		view.setLayout(null);
		
		createButton();
		createSideBar(user);
		createTable(user);
		
		JLabel imgView = new JLabel("");
		imgView.setBounds(0, 5, 1290, 720);
		imgView.setIcon(new ImageIcon(Application.viewGUI));
		view.add(imgView);
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
		view.add(btn_logOut);
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
		view.add(cre_sb);
		
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
		view.add(can_sb);
		
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
		view.add(viw_sb);
	}
	
	private void createTable(User user) {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(430, 237, 758, 339);
		view.add(scrollPane);
		
		JTable table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"AppID", "Date", "Time", "Username", "Phone", "Department"
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel tbModel = (DefaultTableModel) table.getModel();
		
		tbModel.setRowCount(0);

		ArrayList<Appointment> appointments = AppointManager.getAllAppointments(user);

		for (Appointment appointment : appointments) {
			String appID = appointment.getAppID();
			String date = appointment.getDate();
			String time = appointment.getTime();
			String name = appointment.getUsername();
			String phone = appointment.getPhoneNumber();
			String dept = appointment.getDepartment();

			String[] tbData = {appID, date, time, name, phone, dept};

			tbModel.addRow(tbData);
		}
	}
}