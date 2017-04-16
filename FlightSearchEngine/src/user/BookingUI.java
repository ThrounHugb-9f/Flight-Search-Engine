package user;

import java.awt.*;
import javax.swing.*;
import admin.*;
import booking.*;
import search.*;

public class BookingUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	// Breytur

	public BookingUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 482);
		setTitle("Booking");
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 201, 56, 16);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(123, 80, 97, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Flight Nr.");
		lblNewLabel.setBounds(12, 83, 56, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(281, 401, 97, 25);
		contentPane.add(btnSubmit);
		
		JLabel lblKe = new JLabel("Social security Nr.");
		lblKe.setBounds(12, 246, 119, 16);
		contentPane.add(lblKe);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(12, 297, 56, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPhoneNr = new JLabel("Phone Nr.");
		lblPhoneNr.setBounds(12, 344, 56, 16);
		contentPane.add(lblPhoneNr);
		
		JLabel lblBookYourFlight = new JLabel("Book your Flight!");
		lblBookYourFlight.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblBookYourFlight.setBounds(113, 13, 204, 30);
		contentPane.add(lblBookYourFlight);
		
		textField_1 = new JTextField();
		textField_1.setBounds(123, 243, 194, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(123, 198, 195, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(123, 294, 195, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 167, 390, 2);
		contentPane.add(separator);
		
		JLabel lblSeats = new JLabel("Seats");
		lblSeats.setBounds(12, 129, 56, 16);
		contentPane.add(lblSeats);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(123, 123, 48, 22);
		contentPane.add(spinner);
		
		textField_4 = new JTextField();
		textField_4.setBounds(123, 341, 195, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
}