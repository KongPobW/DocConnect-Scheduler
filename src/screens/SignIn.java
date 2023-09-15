package screens;

import runners.Application;
import classes.User;
import utils.UserManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SignIn extends JFrame {

	private JPanel signIn;
	private JTextField username;
	private JPasswordField password;

	public SignIn() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Application.favicon));
		setTitle(Application.appName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1290, 720);
		signIn = new JPanel();
		signIn.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(signIn);
		signIn.setLayout(null);
		
		createButton();
		createField();
		
		JLabel imgSignIn = new JLabel("");
		imgSignIn.setBounds(0, 5, 1290, 720);
		imgSignIn.setIcon(new ImageIcon(Application.signInGUI));
		signIn.add(imgSignIn);
	}
	
	private void createButton() {
		JButton btn_sin = new JButton("");
		btn_sin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSignIn();
			}
		});
		btn_sin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_sin.setOpaque(false);
		btn_sin.setContentAreaFilled(false);
		btn_sin.setBorderPainted(false);
		btn_sin.setBorder(null);
		btn_sin.setBounds(534, 592, 214, 67);
		signIn.add(btn_sin);
		
		JButton btn_back = new JButton("");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				Account acc = new Account();
				acc.setVisible(true);
			}
		});
		btn_back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_back.setOpaque(false);
		btn_back.setContentAreaFilled(false);
		btn_back.setBorderPainted(false);
		btn_back.setBorder(null);
		btn_back.setBounds(-7, 5, 92, 91);
		signIn.add(btn_back);
	}
	
	private void createField() {
		password = new JPasswordField();
		password.setBorder(null);
		password.setFont(new Font("Arial", Font.PLAIN, 28));
		password.setBounds(698, 491, 245, 31);
		signIn.add(password);
		
		username = new JTextField();
		username.setBorder(null);
		username.setFont(new Font("Arial", Font.PLAIN, 28));
		username.setBounds(344, 491, 245, 31);
		signIn.add(username);
		username.setColumns(10);
	}
	
	private void handleSignIn() {
		User foundUser = UserManager.signIn(username.getText(), new String(password.getPassword()));

		if (foundUser != null) {
			JOptionPane.showMessageDialog(null, "Sign In Successfully");

			dispose();

			Home hom = new Home(foundUser);
			hom.setVisible(true);

		} else if (username.getText().equals("") || Arrays.toString(password.getPassword()).equals("")) {
			JOptionPane.showMessageDialog(null, "Please type all information");
		} else {
			JOptionPane.showMessageDialog(null, "Incorrect, please try again");

			username.setText("");
			password.setText("");
		}
	}
}