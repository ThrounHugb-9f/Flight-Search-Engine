package user;

import java.awt.*;
import javax.swing.*;
import admin.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AdminLoginUI extends JFrame {
	private JTextField textFieldUserName;
	private JPasswordField passwordField;
	
	AdminLoginController adminLoginController = new AdminLoginController();

	public AdminLoginUI() {
		setBounds(new Rectangle(400, 190, 445, 230));
		getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setBounds(12, 46, 73, 16);
		getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 93, 73, 16);
		getContentPane().add(lblPassword);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textFieldValueUserName = getTextFieldUserName();
				String textFieldValuePassword = getTextFieldPassword();
				
				if (adminLoginController.checkUserAndPass(textFieldValueUserName, textFieldValuePassword) == true) {
					AdminUI adminUI = new AdminUI();
					adminUI.setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		btnLogIn.setBounds(317, 143, 97, 25);
		getContentPane().add(btnLogIn);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(127, 43, 220, 22);
		getContentPane().add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(127, 93, 220, 22);
		getContentPane().add(passwordField);
		
	}
	
	public String getTextFieldUserName() {
		String usern = textFieldUserName.getText();
		return usern;
	}
	
	@SuppressWarnings("deprecation")
	public String getTextFieldPassword() {
		String passw = passwordField.getText();
		return passw;
	}

}