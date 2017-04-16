package user;

import java.awt.*;
import javax.swing.*;
import admin.*;
import booking.*;
import search.*;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLoginUI extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;

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
				
			}
		});
		btnLogIn.setBounds(317, 143, 97, 25);
		getContentPane().add(btnLogIn);
		
		textField = new JTextField();
		textField.setBounds(127, 43, 220, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(127, 93, 220, 22);
		getContentPane().add(passwordField);
		
	}

	public static void main(String[] args) {
		

	}
}