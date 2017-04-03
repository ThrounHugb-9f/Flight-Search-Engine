package user;

import java.awt.*;
import javax.swing.*;
import admin.*;
import booking.*;
import search.*;

public class AdminUI extends JFrame {
	
	private JPanel contentPane;
	
	// Breytur

	public AdminUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Admin");
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}

}
