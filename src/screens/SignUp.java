package screens;

import runners.Application;
import utils.UserManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame {

	private final JPanel signUp;
	private JTextField username;
	private JTextField name;
	private JPasswordField password;

	public SignUp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Application.favicon));
		setTitle(Application.appName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1290, 720);
		signUp = new JPanel();
		signUp.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(signUp);
		signUp.setLayout(null);
		
		createButton();
		createField();
		
		JLabel imgSignUp = new JLabel("");
		imgSignUp.setBounds(0, 5, 1290, 720);
		imgSignUp.setIcon(new ImageIcon(Application.signUpGUI));
		signUp.add(imgSignUp);
	}
	
	private void createButton() {
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
		btn_back.setBounds(1, 5, 92, 91);
		signUp.add(btn_back);
		
		JButton btn_sup = new JButton("");
		btn_sup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSignUp();
			}
		});
		btn_sup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_sup.setOpaque(false);
		btn_sup.setContentAreaFilled(false);
		btn_sup.setBorderPainted(false);
		btn_sup.setBorder(null);
		btn_sup.setBounds(534, 592, 214, 67);
		signUp.add(btn_sup);
	}
	
	private void createField() {
		username = new JTextField();
		username.setBorder(null);
		username.setFont(new Font("Arial", Font.PLAIN, 28));
		username.setBounds(214, 494, 250, 31);
		signUp.add(username);
		username.setColumns(10);
		
		name = new JTextField();
		name.setBorder(null);
		name.setFont(new Font("Arial", Font.PLAIN, 28));
		name.setBounds(820, 494, 250, 31);
		signUp.add(name);
		name.setColumns(10);
		
		password = new JPasswordField();
		password.setBorder(null);
		password.setFont(new Font("Arial", Font.PLAIN, 28));
		password.setBounds(516, 494, 250, 31);
		signUp.add(password);
	}
	
	private void handleSignUp() {
		String error = UserManager.signUp(username.getText(), new String(password.getPassword()), name.getText());

		if (error == null) {
			JOptionPane.showMessageDialog(null, "Sign Up Successfully");

			dispose();

			Account acc = new Account();
			acc.setVisible(true);

		} else if (error.equals("Please type all information")) {
			JOptionPane.showMessageDialog(null, "Please type all information");
		} else {
			JOptionPane.showMessageDialog(null, "Username has been used. Please use another username");
			username.setText("");
		}
	}
}