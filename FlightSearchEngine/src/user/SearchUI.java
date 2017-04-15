package user;

import search.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import admin.*;
import booking.*;
import search.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;


public class SearchUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDepart;
	private JTextField textFieldDestination;
	private JTextField textFieldDate;
	private JTable table;
	private JTable jTable_Display_Flights;
	private FlightModel[] flights;
	SearchController searchController = new SearchController();
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchUI frame = new SearchUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public SearchUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		setTitle("FlightSearchEngine");
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeparture = new JLabel("Departure:");
		lblDeparture.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDeparture.setBounds(300, 36, 89, 14);
		contentPane.add(lblDeparture);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDestination.setBounds(300, 78, 89, 14);
		contentPane.add(lblDestination);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setBounds(300, 118, 89, 14);
		contentPane.add(lblDate);
		
		textFieldDepart = new JTextField();
		textFieldDepart.setBounds(400, 33, 144, 20);
		contentPane.add(textFieldDepart);
		textFieldDepart.setColumns(10);
		
		textFieldDestination = new JTextField();
		textFieldDestination.setBounds(400, 75, 144, 20);
		contentPane.add(textFieldDestination);
		textFieldDestination.setColumns(10);
		
		textFieldDate = new JTextField();
		textFieldDate.setBounds(400, 115, 144, 20);
		contentPane.add(textFieldDate);
		textFieldDate.setColumns(10);
		
		jTable_Display_Flights = new JTable(model);
        jTable_Display_Flights.setBounds(6, 150, 988, 322);
        contentPane.add(jTable_Display_Flights);
		
		// Test class for JButton and JTable
		JButton btnSearchForFlight = new JButton("Search For Flights");
		btnSearchForFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textFieldValueDepart = getTextFieldDeparture();
				
				FlightModel[] flights = searchController.getFlightsByDeparture(textFieldValueDepart);
				
				model.setColumnIdentifiers(new String[] {"Flightnumber", "Departure", "Destination", ""
						+ "Departure Date", "Departure Time", "Arrival Date", "Arrival Time", ""
								+ "Seats Available", "Price"});
				for (FlightModel i : flights) {
					model.addRow(new String[] {Integer.toString(i.getFlightnumber()), i.getDeparture(),
											   i.getArrival(), i.getDeparturedate(), i.getDeparturetime(),
											   i.getArrivaldate(), i.getArrivaltime(), Integer.toString(i.getSeats()),
											   Integer.toString(i.getPrice())});
				}
				
				jTable_Display_Flights.setModel(model);
			}
		});
		
		/*
		JButton btnSearchForFlight = new JButton("Search For Flights");
		btnSearchForFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textFieldValueDepart = getTextFieldDeparture();
				
				FlightModel[] flights = searchController.getFlightsByDeparture(textFieldValueDepart);
				
				for (FlightModel i : flights) {
					System.out.print(i.getFlightnumber() + " ");
					System.out.print(i.getDeparture() + " ");
					System.out.print(i.getArrival() + " ");
					System.out.print(i.getDeparturedate() + " ");
					System.out.print(i.getDeparturetime() + " ");
					System.out.print(i.getArrivaldate() + " ");
					System.out.print(i.getArrivaltime() + " ");
					System.out.print(i.getSeats() + " ");
					System.out.println(i.getPrice());
					System.out.println();
				}
			}
		});
		*/
		btnSearchForFlight.setBounds(600, 66, 126, 40);
		contentPane.add(btnSearchForFlight);
        
	}
	
	public String getTextFieldDeparture() {
		String depText = new String(); 
		depText = textFieldDepart.getText(); 
		return depText;
		}
	
}
