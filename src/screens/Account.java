package screens;

import runners.Application;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Account extends JFrame {

	private final JPanel account;

	public Account() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Application.favicon));
		setTitle(Application.appName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1290, 720);
		account = new JPanel();
		account.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(account);
		account.setLayout(null);
		
		createButton();
		
		JLabel imgAccount = new JLabel("");
		imgAccount.setBounds(0, 5, 1290, 720);
		imgAccount.setIcon(new ImageIcon(Application.accountGUI));
		account.add(imgAccount);
	}
	
	private void createButton() {
		JButton btn_sup = new JButton("");
		btn_sup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				SignUp sup = new SignUp();
				sup.setVisible(true);
			}
		});
		btn_sup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_sup.setOpaque(false);
		btn_sup.setContentAreaFilled(false);
		btn_sup.setBorderPainted(false);
		btn_sup.setBorder(null);
		btn_sup.setBounds(518, 564, 245, 88);
		account.add(btn_sup);
		
		JButton btn_sin = new JButton("");
		btn_sin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				SignIn sin = new SignIn();
				sin.setVisible(true);
			}
		});
		btn_sin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_sin.setOpaque(false);
		btn_sin.setContentAreaFilled(false);
		btn_sin.setBorderPainted(false);
		btn_sin.setBorder(null);
		btn_sin.setBounds(518, 414, 245, 88);
		account.add(btn_sin);
	}
}