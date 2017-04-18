package user;

import search.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SearchUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDepart;
	private JTextField textFieldDestination;
	private JTextField textFieldDate;
	private JTextField textFieldPick;
	private JTable table;
	private JTable jTable_Display_Flights;
	private FlightModel[] flightsDepart;
	private FlightModel[] flightsDest;
	private FlightModel[] flightsDate;
	private JLabel lblPriceRange;
	
	private BookingUI startBook;

	
	SearchController searchController = new SearchController();
	DefaultTableModel modelDepart = new DefaultTableModel();
	DefaultTableModel modelDest = new DefaultTableModel();
	DefaultTableModel modelDate = new DefaultTableModel();
	DefaultTableModel modelFlights = new DefaultTableModel();
	private JScrollPane scrollPane;

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
		setBounds(100, 100, 929, 610);
		setTitle("FlightSearchEngine");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmLogInAs = new JMenuItem("log in as admin");
		mntmLogInAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AdminLoginUI LogIn = new AdminLoginUI();
				LogIn.setVisible(true);
			}
		});
		
		mnFile.add(mntmLogInAs);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeparture = new JLabel("Departure:");
		lblDeparture.setBounds(300, 36, 89, 14);
		lblDeparture.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblDeparture);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setBounds(300, 78, 89, 14);
		lblDestination.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblDestination);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(300, 118, 89, 14);
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblDate);
		
		JLabel lblPickFlight = new JLabel("Enter Flightnumber:");
		lblPickFlight.setBounds(30, 36, 89, 14);
		lblPickFlight.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		contentPane.add(lblPickFlight);
		
		textFieldPick = new JTextField();
		textFieldPick.setBounds(120, 33, 144, 20);
		contentPane.add(textFieldPick);
		textFieldPick.setColumns(10);
		
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
		
		lblPriceRange = new JLabel("Price Range:");
		lblPriceRange.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPriceRange.setBounds(300, 153, 92, 16);
		contentPane.add(lblPriceRange);
		
		// Searching for flights by their departing city
		JButton btnSearchForFlightDepart = new JButton("Search For Flights By Departure");
		btnSearchForFlightDepart.setBounds(600, 30, 250, 30);
		btnSearchForFlightDepart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Refreshing table
				while (modelDepart.getRowCount() > 0) {
					modelDepart.removeRow(0);
				}
				
				// Getting text values
				String textFieldValueDepart = getTextFieldDeparture();
				
				flightsDepart = searchController.getFlightsByDeparture(textFieldValueDepart);
				
				// Setting data into table
				modelDepart.setColumnIdentifiers(new String[] {"Flightnumber", "Departure", "Destination", ""
						+ "Departure Date", "Departure Time", "Arrival Date", "Arrival Time", ""
								+ "Seats Available", "Price"});
				for (FlightModel i : flightsDepart) {
					modelDepart.addRow(new String[] {Integer.toString(i.getFlightnumber()), i.getDeparture(),
											   i.getArrival(), i.getDeparturedate(), i.getDeparturetime(),
											   i.getArrivaldate(), i.getArrivaltime(), Integer.toString(i.getSeats()),
											   Integer.toString(i.getPrice())});
				}
				
				jTable_Display_Flights.setModel(modelDepart);
				jTable_Display_Flights.setEnabled(false);
				
			}
			
		});
		contentPane.add(btnSearchForFlightDepart);
		
		
		// Searching for flights by their destination
		JButton btnSearchForFlightByDestination = new JButton("Search For Flights By Destination");
		btnSearchForFlightByDestination.setBounds(600, 70, 250, 30);
		btnSearchForFlightByDestination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Refreshing table
				while (modelDest.getRowCount() > 0) {
					modelDest.removeRow(0);
				}
				
				// Getting text values
				String textFieldValueDest = getTextFieldDestination();
				
				flightsDest = searchController.getFlightsByDestination(textFieldValueDest);
				
				// Setting data into table
				modelDest.setColumnIdentifiers(new String[] {"Flightnumber", "Departure", "Destination", ""
						+ "Departure Date", "Departure Time", "Arrival Date", "Arrival Time", ""
								+ "Seats Available", "Price"});
				for (FlightModel i : flightsDest) {
					modelDest.addRow(new String[] {Integer.toString(i.getFlightnumber()), i.getDeparture(),
											   i.getArrival(), i.getDeparturedate(), i.getDeparturetime(),
											   i.getArrivaldate(), i.getArrivaltime(), Integer.toString(i.getSeats()),
											   Integer.toString(i.getPrice())});
				}
				
				jTable_Display_Flights.setModel(modelDest);
				jTable_Display_Flights.setEnabled(false);
			}
		});
		contentPane.add(btnSearchForFlightByDestination);
		
		// Searching for flights by their date
		JButton btnSearchForFlights = new JButton("Search For Flights By Date");
		btnSearchForFlights.setBounds(600, 110, 250, 30);
		btnSearchForFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Refresh table
				while (modelDate.getRowCount() > 0) {
					modelDate.removeRow(0);
				}
				
				// Getting text values
				String textFieldValueDate = getTextFieldDate();
				
				flightsDate = searchController.getFlightsByDate(textFieldValueDate);
				
				// Setting data into table
				modelDate.setColumnIdentifiers(new String[] {"Flightnumber", "Departure", "Destination", ""
						+ "Departure Date", "Departure Time", "Arrival Date", "Arrival Time", ""
								+ "Seats Available", "Price"});
				for (FlightModel i : flightsDate) {
					modelDate.addRow(new String[] {Integer.toString(i.getFlightnumber()), i.getDeparture(),
											   i.getArrival(), i.getDeparturedate(), i.getDeparturetime(),
											   i.getArrivaldate(), i.getArrivaltime(), Integer.toString(i.getSeats()),
											   Integer.toString(i.getPrice())});
				}
				
				jTable_Display_Flights.setModel(modelDate);
				jTable_Display_Flights.setEnabled(false);
			}
		});
		contentPane.add(btnSearchForFlights);
		
		JSlider slider = new JSlider();
		slider.setMajorTickSpacing(5000);
		slider.setMaximum(200000);
		slider.setBounds(400, 147, 144, 29);
		contentPane.add(slider);
		
		JButton btnSearchFlightsByPriceRange = new JButton("Search For Flights By Price Range");
		btnSearchFlightsByPriceRange.setBounds(600, 150, 250, 30);
		contentPane.add(btnSearchFlightsByPriceRange);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 223, 887, 300);
		contentPane.add(scrollPane);
		
		jTable_Display_Flights = new JTable();
		jTable_Display_Flights.setEnabled(false);
		scrollPane.setViewportView(jTable_Display_Flights);
        
		
		// Picking a flight
		JButton btnPickFlight = new JButton("Pick Flight");
		btnPickFlight.setBounds(30, 80, 250, 30);
		btnPickFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Getting text values
				int textFieldValuePick = getTextFieldPick();
				
				FlightModel flight = searchController.pickFlight(textFieldValuePick);
				
				startBook = new BookingUI(flight);
				startBook.setVisible(true);
			}
		});
		contentPane.add(btnPickFlight);
		
		JButton btnSearchForAllFlights = new JButton("Show All Flights");
		btnSearchForAllFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(modelFlights.getRowCount() > 0) {
					modelFlights.removeRow(0);
				}
				
				// Getting information on all flights
				FlightModel[] allFlights = searchController.getAllFlights();
				
				modelFlights.setColumnIdentifiers(new String[] {"Flightnumber", "Departure", "Destination", ""
						+ "Departure Date", "Departure Time", "Arrival Date", "Arrival Time", ""
								+ "Seats Available", "Price"});
				for (FlightModel i : allFlights) {
					modelFlights.addRow(new String[] {Integer.toString(i.getFlightnumber()), i.getDeparture(),
							   i.getArrival(), i.getDeparturedate(), i.getDeparturetime(),
							   i.getArrivaldate(), i.getArrivaltime(), Integer.toString(i.getSeats()),
							   Integer.toString(i.getPrice())});
				}
				
				jTable_Display_Flights.setModel(modelFlights);
			}
		});
		btnSearchForAllFlights.setBounds(30, 129, 250, 47);
		contentPane.add(btnSearchForAllFlights);
	}
	
	
	public String getTextFieldDeparture() { 
		String depText = textFieldDepart.getText(); 
		return depText;
		}
	
	public String getTextFieldDestination() {
		String destText = textFieldDestination.getText();
		return destText;
	}
	
	public String getTextFieldDate() {
		String dateText = textFieldDate.getText();
		return dateText;
	}
	
	public int getTextFieldPick() {
		String pickText = textFieldPick.getText();
		int flightNumber = Integer.parseInt(pickText);
		return flightNumber;
	}
}





