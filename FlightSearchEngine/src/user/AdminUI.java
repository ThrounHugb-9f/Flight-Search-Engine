package user;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import admin.*;
import booking.*;
import search.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.border.TitledBorder;

public class AdminUI extends JFrame {
	
	// Breytur
	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldFlightNumber;
	private JTextField textFieldDeparture;
	private JTextField textFieldArrival;
	private JTextField textFieldDepartureDate;
	private JTextField textFieldDepartureTime;
	private JTextField textFieldArrivalDate;
	private JTextField textFieldArrivalTime;
	private JTextField textFieldSeats;
	private JTextField textFieldPrice;
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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUI frame = new AdminUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

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
		
		textFieldFlightNumber = new JTextField();
		textFieldFlightNumber.setBounds(112, 536, 116, 22);
		contentPane.add(textFieldFlightNumber);
		textFieldFlightNumber.setColumns(10);
		
		textFieldDeparture = new JTextField();
		textFieldDeparture.setBounds(286, 536, 116, 22);
		contentPane.add(textFieldDeparture);
		textFieldDeparture.setColumns(10);
		
		JLabel lblDeparture = new JLabel("Flightnumber");
		lblDeparture.setBounds(112, 507, 103, 16);
		contentPane.add(lblDeparture);
		
		textFieldArrival = new JTextField();
		textFieldArrival.setBounds(456, 536, 116, 22);
		contentPane.add(textFieldArrival);
		textFieldArrival.setColumns(10);
		
		JLabel lblArrival = new JLabel("Departure");
		lblArrival.setBounds(286, 507, 97, 16);
		contentPane.add(lblArrival);
		
		JLabel lblDepartureTime = new JLabel("Arrival");
		lblDepartureTime.setBounds(456, 507, 116, 16);
		contentPane.add(lblDepartureTime);
		
		textFieldDepartureDate = new JTextField();
		textFieldDepartureDate.setBounds(112, 613, 116, 22);
		contentPane.add(textFieldDepartureDate);
		textFieldDepartureDate.setColumns(10);
		
		textFieldDepartureTime = new JTextField();
		textFieldDepartureTime.setBounds(286, 613, 116, 22);
		contentPane.add(textFieldDepartureTime);
		textFieldDepartureTime.setColumns(10);
		
		textFieldArrivalDate = new JTextField();
		textFieldArrivalDate.setBounds(456, 613, 116, 22);
		contentPane.add(textFieldArrivalDate);
		textFieldArrivalDate.setColumns(10);
		
		textFieldArrivalTime = new JTextField();
		textFieldArrivalTime.setBounds(112, 693, 116, 22);
		contentPane.add(textFieldArrivalTime);
		textFieldArrivalTime.setColumns(10);
		
		textFieldSeats = new JTextField();
		textFieldSeats.setBounds(286, 693, 116, 22);
		contentPane.add(textFieldSeats);
		textFieldSeats.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(456, 693, 116, 22);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
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
		
		btnDeleteFlight.setBounds(700, 789, 123, 25);
		contentPane.add(btnDeleteFlight);
		
		lblDeleteFlightNumber = new JLabel("Delete flight number");
		lblDeleteFlightNumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDeleteFlightNumber.setBounds(682, 749, 189, 36);
		contentPane.add(lblDeleteFlightNumber);
		
		btnDeleteFlight = new JButton("Delete");
		btnDeleteFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}