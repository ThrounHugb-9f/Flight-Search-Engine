package user;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import admin.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminUI extends JFrame {
	
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
	private JButton btnInsertFlight;
	private JLabel lblArrivalDate;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblArrivalTime;
	private JLabel lblSeats;
	private JLabel lblPrice;
	private JSeparator separator_1;
	private JLabel label;
	private JTextField textFieldFlightNumberDelete;
	private JButton btnDeleteFlight;
	private JLabel lblDeleteFlightNumber;
	
	AdminController adminController = new AdminController();
	DefaultTableModel modelFlights = new DefaultTableModel();
	private JScrollPane scrollPane;
	
	public AdminUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 775);
		setTitle("Admin");
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShowAllFlights = new JButton("Show all flights");
		btnShowAllFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(modelFlights.getRowCount()>0) {
					modelFlights.removeRow(0);
				}
				
				// Getting information on all flights
				AdminModel[] allFlights = adminController.getAllFlights();
				
				modelFlights.setColumnIdentifiers(new String[] {"Flightnumber", "Departure", "Destination", ""
						+ "Departure Date", "Departure Time", "Arrival Date", "Arrival Time", ""
								+ "Seats Available", "Price"});
				for (AdminModel i : allFlights) {
					modelFlights.addRow(new String[] {Integer.toString(i.getFlightnumber()), i.getDeparture(),
							   i.getArrival(), i.getDeparturedate(), i.getDeparturetime(),
							   i.getArrivaldate(), i.getArrivaltime(), Integer.toString(i.getSeats()),
							   Integer.toString(i.getPrice())});
				}
				
				table.setModel(modelFlights);
				
			}
		});
		btnShowAllFlights.setBounds(410, 48, 132, 25);
		contentPane.add(btnShowAllFlights);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 360, 958, 2);
		contentPane.add(separator);
		
		textFieldFlightNumber = new JTextField();
		textFieldFlightNumber.setBounds(112, 404, 116, 22);
		contentPane.add(textFieldFlightNumber);
		textFieldFlightNumber.setColumns(10);
		
		textFieldDeparture = new JTextField();
		textFieldDeparture.setBounds(275, 404, 116, 22);
		contentPane.add(textFieldDeparture);
		textFieldDeparture.setColumns(10);
		
		JLabel lblDeparture = new JLabel("Flightnumber");
		lblDeparture.setBounds(112, 375, 105, 16);
		contentPane.add(lblDeparture);
		
		textFieldArrival = new JTextField();
		textFieldArrival.setBounds(442, 404, 116, 22);
		contentPane.add(textFieldArrival);
		textFieldArrival.setColumns(10);
		
		JLabel lblArrival = new JLabel("Departure");
		lblArrival.setBounds(286, 375, 96, 16);
		contentPane.add(lblArrival);
		
		JLabel lblDepartureTime = new JLabel("Arrival");
		lblDepartureTime.setBounds(442, 375, 116, 16);
		contentPane.add(lblDepartureTime);
		
		textFieldDepartureDate = new JTextField();
		textFieldDepartureDate.setBounds(112, 468, 116, 22);
		contentPane.add(textFieldDepartureDate);
		textFieldDepartureDate.setColumns(10);
		
		textFieldDepartureTime = new JTextField();
		textFieldDepartureTime.setBounds(275, 468, 116, 22);
		contentPane.add(textFieldDepartureTime);
		textFieldDepartureTime.setColumns(10);
		
		textFieldArrivalDate = new JTextField();
		textFieldArrivalDate.setBounds(442, 468, 116, 22);
		contentPane.add(textFieldArrivalDate);
		textFieldArrivalDate.setColumns(10);
		
		textFieldArrivalTime = new JTextField();
		textFieldArrivalTime.setBounds(112, 536, 116, 22);
		contentPane.add(textFieldArrivalTime);
		textFieldArrivalTime.setColumns(10);
		
		textFieldSeats = new JTextField();
		textFieldSeats.setBounds(275, 536, 116, 22);
		contentPane.add(textFieldSeats);
		textFieldSeats.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(442, 536, 116, 22);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		lblInsertNewFlight = new JLabel("Insert new flight");
		lblInsertNewFlight.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInsertNewFlight.setBounds(693, 390, 189, 36);
		contentPane.add(lblInsertNewFlight);
		
		
		
		
		
		
		
		
		// Insert a new flight into database
		btnInsertFlight = new JButton("Submit");
		btnInsertFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Getting text values
				String textFieldValueFlightNumber = getTextFieldFlightNumber();
				String textFieldValueDeparture = getTextFieldDeparture();
				String textFieldValueArrival = getTextFieldArrival();
				String textFieldValueDepartureDate = getTextFieldDepartureDate();
				String textFieldValueDepartureTime = getTextFieldDepartureTime();
				String textFieldValueArrivalDate = getTextFieldArrivalDate();
				String textFieldValueArrivalTime = getTextFieldArrivalTime();
				String textFieldValueSeats = getTextFieldSeats();
				String textFieldValuePrice = getTextFieldPrice();
				
				// Inserting a new flight
				adminController.addNewFlight(Integer.parseInt(textFieldValueFlightNumber), textFieldValueDeparture,
						textFieldValueArrival, textFieldValueDepartureDate, textFieldValueDepartureTime,
						textFieldValueArrivalDate, textFieldValueArrivalTime, Integer.parseInt(textFieldValueSeats),
						Integer.parseInt(textFieldValuePrice));
			}
		});
		btnInsertFlight.setBounds(700, 471, 123, 52);
		contentPane.add(btnInsertFlight);
		
		lblArrivalDate = new JLabel("Departure Date");
		lblArrivalDate.setBounds(112, 439, 116, 16);
		contentPane.add(lblArrivalDate);
		
		lblNewLabel = new JLabel("Departure Time");
		lblNewLabel.setBounds(275, 439, 116, 16);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Arrival Date");
		lblNewLabel_1.setBounds(442, 439, 116, 16);
		contentPane.add(lblNewLabel_1);
		
		lblArrivalTime = new JLabel("Arrival Time");
		lblArrivalTime.setBounds(112, 507, 116, 16);
		contentPane.add(lblArrivalTime);
		
		lblSeats = new JLabel("Seats");
		lblSeats.setBounds(275, 507, 56, 16);
		contentPane.add(lblSeats);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBounds(442, 507, 56, 16);
		contentPane.add(lblPrice);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(12, 592, 958, 2);
		contentPane.add(separator_1);
		
		label = new JLabel("Flightnumber");
		label.setBounds(112, 607, 116, 16);
		contentPane.add(label);
		
		textFieldFlightNumberDelete = new JTextField();
		textFieldFlightNumberDelete.setColumns(10);
		textFieldFlightNumberDelete.setBounds(112, 636, 116, 22);
		contentPane.add(textFieldFlightNumberDelete);
		
		// Delete a flight from database
		btnDeleteFlight = new JButton("Delete");
		btnDeleteFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Get text value
				String textFieldValueFlightNumberDelete = getTextFieldFlightNumberDelete();
				
				// Delete a flight from database
				adminController.deleteFlight(Integer.parseInt(textFieldValueFlightNumberDelete));
			}
		});
		btnDeleteFlight.setBounds(700, 663, 123, 41);
		contentPane.add(btnDeleteFlight);
		
		lblDeleteFlightNumber = new JLabel("Delete flight number");
		lblDeleteFlightNumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDeleteFlightNumber.setBounds(693, 607, 189, 36);
		contentPane.add(lblDeleteFlightNumber);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 93, 958, 237);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		
		scrollPane.setViewportView(table);
		
	}
	
	public String getTextFieldFlightNumber() {
		String flightnText = textFieldFlightNumber.getText();
		return flightnText;
	}
	
	public String getTextFieldDeparture() {
		String deparText = textFieldDeparture.getText();
		return deparText;
	}
	
	public String getTextFieldArrival() {
		String arriText = textFieldArrival.getText();
		return arriText;
	}
	
	public String getTextFieldDepartureDate() {
		String deparDateText = textFieldDepartureDate.getText();
		return deparDateText;
	}
	
	public String getTextFieldDepartureTime() {
		String deparTimeText = textFieldDepartureTime.getText();
		return deparTimeText;
	}
	
	public String getTextFieldArrivalDate() {
		String arriDateText = textFieldArrivalDate.getText();
		return arriDateText;
	}
	
	public String getTextFieldArrivalTime() {
		String arriTimeText = textFieldArrivalTime.getText();
		return arriTimeText;
	}
	
	public String getTextFieldSeats() {
		String seatsText = textFieldSeats.getText();
		return seatsText;
	}
	
	public String getTextFieldPrice() {
		String priceText = textFieldPrice.getText();
		return priceText;
	}
	
	public String getTextFieldFlightNumberDelete() {
		String flightNumberDeleteText = textFieldFlightNumberDelete.getText();
		return flightNumberDeleteText;
	}
}
