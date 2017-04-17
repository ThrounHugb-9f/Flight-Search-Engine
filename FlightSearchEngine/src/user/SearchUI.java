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
	private JTable table;
	private JTable jTable_Display_Flights;
	private FlightModel[] flightsDepart;
	private FlightModel[] flightsDest;
	private FlightModel[] flightsDate;
	private JLabel lblFlightNumber;
	private JLabel lblDeparture_1;
	private JLabel lblDestination_1;
	private JLabel lblDepartureDate;
	private JLabel lblDepartureTime;
	private JLabel lblArrivalDate;
	private JLabel lblArrivalTime;
	private JLabel lblSeats;
	private JLabel lblPrice;
	private JLabel lblPriceRange;
	
	SearchController searchController = new SearchController();
	DefaultTableModel modelDepart = new DefaultTableModel();
	DefaultTableModel modelDest = new DefaultTableModel();
	DefaultTableModel modelDate = new DefaultTableModel();

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
		setBounds(100, 100, 950, 550);
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
		
		jTable_Display_Flights = new JTable();
		jTable_Display_Flights.setBounds(6, 220, 938, 302);
        contentPane.add(jTable_Display_Flights);
			
		lblFlightNumber = new JLabel("Flightnumber");
		lblFlightNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFlightNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlightNumber.setBounds(6, 192, 89, 16);
		contentPane.add(lblFlightNumber);
		
		lblDeparture_1 = new JLabel("Departure");
		lblDeparture_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDeparture_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeparture_1.setBounds(95, 192, 89, 16);
		contentPane.add(lblDeparture_1);
		
		lblDestination_1 = new JLabel("Destination");
		lblDestination_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDestination_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestination_1.setBounds(196, 192, 89, 16);
		contentPane.add(lblDestination_1);
		
		lblDepartureDate = new JLabel("Departure Date");
		lblDepartureDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDepartureDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepartureDate.setBounds(297, 192, 104, 16);
		contentPane.add(lblDepartureDate);
		
		lblDepartureTime = new JLabel("Departure Time");
		lblDepartureTime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDepartureTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepartureTime.setBounds(413, 192, 104, 16);
		contentPane.add(lblDepartureTime);
		
		lblArrivalDate = new JLabel("Arrival Date");
		lblArrivalDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblArrivalDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrivalDate.setBounds(529, 192, 79, 16);
		contentPane.add(lblArrivalDate);
		
		lblArrivalTime = new JLabel("Arrival Time");
		lblArrivalTime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblArrivalTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrivalTime.setBounds(628, 192, 79, 16);
		contentPane.add(lblArrivalTime);
		
		lblSeats = new JLabel("Seats");
		lblSeats.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSeats.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeats.setBounds(717, 192, 61, 16);
		contentPane.add(lblSeats);
		
		lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(791, 192, 134, 16);
		contentPane.add(lblPrice);
		
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
			}
		});
		contentPane.add(btnSearchForFlights);
		
		JSlider slider = new JSlider();
		slider.setBounds(400, 147, 144, 29);
		contentPane.add(slider);
		
		JButton btnSearchFlightsByPriceRange = new JButton("Search For Flights By Price Range");
		btnSearchFlightsByPriceRange.setBounds(600, 150, 250, 30);
		contentPane.add(btnSearchFlightsByPriceRange);
        
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
}





