package user;

import java.awt.*;
import javax.swing.*;
import admin.*;
import booking.*;
import search.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminUI extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JLabel lblInsertNewFlight;
	private JButton InsertButton;
	private JLabel lblArrivalDate;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblArrivalTime;
	private JLabel lblSeats;
	private JLabel lblPrice;
	private JSeparator separator_1;
	private JLabel label;
	private JTextField textField;
	private JButton btnDeleteFlight;
	private JLabel lblDeleteFlightNumber;
	
	// Breytur

	public AdminUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 905);
		setTitle("Admin");
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(12, 113, 958, 348);
		contentPane.add(table);
		
		JButton btnShowAllFlights = new JButton("Show all flights");
		btnShowAllFlights.setBounds(410, 48, 97, 25);
		contentPane.add(btnShowAllFlights);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 475, 958, 2);
		contentPane.add(separator);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 536, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(286, 536, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDeparture = new JLabel("Flightnumber");
		lblDeparture.setBounds(112, 507, 75, 16);
		contentPane.add(lblDeparture);
		
		textField_3 = new JTextField();
		textField_3.setBounds(456, 536, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblArrival = new JLabel("Departure");
		lblArrival.setBounds(286, 507, 56, 16);
		contentPane.add(lblArrival);
		
		JLabel lblDepartureTime = new JLabel("Arrival");
		lblDepartureTime.setBounds(456, 507, 116, 16);
		contentPane.add(lblDepartureTime);
		
		textField_4 = new JTextField();
		textField_4.setBounds(112, 613, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(286, 613, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(456, 613, 116, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(112, 693, 116, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(286, 693, 116, 22);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(456, 693, 116, 22);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		lblInsertNewFlight = new JLabel("Insert new flight");
		lblInsertNewFlight.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInsertNewFlight.setBounds(700, 507, 189, 36);
		contentPane.add(lblInsertNewFlight);
		
		InsertButton = new JButton("Submit");
		InsertButton.setBounds(700, 612, 123, 52);
		contentPane.add(InsertButton);
		
		lblArrivalDate = new JLabel("Departure Date");
		lblArrivalDate.setBounds(112, 584, 116, 16);
		contentPane.add(lblArrivalDate);
		
		lblNewLabel = new JLabel("Departure Time");
		lblNewLabel.setBounds(286, 584, 116, 16);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Arrival Date");
		lblNewLabel_1.setBounds(456, 584, 116, 16);
		contentPane.add(lblNewLabel_1);
		
		lblArrivalTime = new JLabel("Arrival Time");
		lblArrivalTime.setBounds(112, 664, 116, 16);
		contentPane.add(lblArrivalTime);
		
		lblSeats = new JLabel("Seats");
		lblSeats.setBounds(286, 664, 56, 16);
		contentPane.add(lblSeats);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBounds(456, 664, 56, 16);
		contentPane.add(lblPrice);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(12, 735, 958, 2);
		contentPane.add(separator_1);
		
		label = new JLabel("Flightnumber");
		label.setBounds(112, 761, 75, 16);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(112, 790, 116, 22);
		contentPane.add(textField);
		
		btnDeleteFlight = new JButton("Delete");
		btnDeleteFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteFlight.setBounds(700, 789, 123, 25);
		contentPane.add(btnDeleteFlight);
		
		lblDeleteFlightNumber = new JLabel("Delete flight number");
		lblDeleteFlightNumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDeleteFlightNumber.setBounds(682, 749, 189, 36);
		contentPane.add(lblDeleteFlightNumber);
		
	}
}
