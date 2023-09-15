package screens;

import runners.Application;
import classes.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {

	private final JPanel home;

	public Home(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Application.favicon));
		setTitle(Application.appName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1290, 720);
		home = new JPanel();
		home.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(home);
		home.setLayout(null);
		
		createButton();
		createSideBar(user);
		
		JLabel welcome = new JLabel(user.getUsername());
		welcome.setForeground(Color.WHITE);
		welcome.setFont(new Font("Arial", Font.PLAIN, 43));
		welcome.setBounds(849, 73, 321, 43);
		home.add(welcome);
		
		JLabel imgHome = new JLabel("");
		imgHome.setBounds(0, 5, 1290, 720);
		imgHome.setIcon(new ImageIcon(Application.homeGUI));
		home.add(imgHome);
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
		home.add(btn_logOut);
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
		home.add(cre_sb);
		
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
		home.add(can_sb);
		
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
		home.add(viw_sb);
	}
}