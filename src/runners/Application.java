package runners;

import screens.Account;
import utils.DatabaseManager;

public class Application {

	public static String appName = "Stamford DocConnect Scheduler";
	public static String favicon = "GUI/favicon.png";
	public static String accountGUI = "GUI/account.jpg";
	public static String homeGUI = "GUI/home.jpg";
	public static String signInGUI = "GUI/sign-in.jpg";
	public static String signUpGUI = "GUI/sign-up.jpg";
	public static String createGUI = "GUI/create.jpg";
	public static String cancelGUI = "GUI/cancel.jpg";
	public static String viewGUI = "GUI/view.jpg";
	
	public static void main(String[] args) {
		DatabaseManager.getConnection();
		
		Account acc = new Account();
		acc.setVisible(true);
	}
}