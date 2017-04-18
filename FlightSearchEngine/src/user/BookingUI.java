package user;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import booking.BookingController;
import booking.BookingManager;
import booking.BookingModel;
import search.FlightModel;


public class BookingUI extends JFrame {

	private JPanel contentPane;
	private JSpinner seats;
	private JTextField textFieldSocialSec;
	private JTextField textFieldName;
	private JTextField textFieldMail;
	private JTextField textFieldPhone;

	private FlightModel pickedFlight;
	
	BookingController bookingController;

	// Constructor
	public BookingUI(FlightModel flight) {
		bookingController = new BookingController(flight);
		pickedFlight = flight;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 408, 482);
		setTitle("Booking");
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 201, 56, 16);
		contentPane.add(lblName);

		JLabel flightNr = new JLabel(" " + flight.getFlightnumber());
		flightNr.setBounds(123, 80, 97, 22);
		contentPane.add(flightNr);

		JLabel lblNewLabel = new JLabel("Flight Nr.");
		lblNewLabel.setBounds(12, 83, 56, 16);
		contentPane.add(lblNewLabel);

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

		textFieldSocialSec = new JTextField();
		textFieldSocialSec.setBounds(123, 243, 194, 22);
		contentPane.add(textFieldSocialSec);
		textFieldSocialSec.setColumns(10);

		textFieldName= new JTextField();
		textFieldName.setBounds(123, 198, 195, 22);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);

		textFieldMail = new JTextField();
		textFieldMail.setBounds(123, 294, 195, 22);
		contentPane.add(textFieldMail);
		textFieldMail.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 167, 390, 2);
		contentPane.add(separator);

		JLabel lblSeats = new JLabel("Seats");
		lblSeats.setBounds(12, 129, 56, 16);
		contentPane.add(lblSeats);

		seats = new JSpinner();
		seats.setBounds(123, 123, 48, 22);
		contentPane.add(seats);

		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(123, 341, 195, 22);
		contentPane.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(281, 401, 97, 25);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get text values
				int id = 29; // �arf a� breyta
				String name = getTextFieldName();
				int securityNr = getTextFieldSocialSec();
				String email = getTextFieldMail();
				int phone = getTextFieldPhone();
				int reservedSeats = getNumSeats();
				int flightNumber = flight.getFlightnumber();
				
				BookingModel book = new BookingModel(id, name,
							securityNr, email, phone, reservedSeats,
							flightNumber);
				
				BookingController bookFlight = new BookingController(book);
				
				bookFlight.addNewBooking();
				
			}
		});
		contentPane.add(btnSubmit);
	}
	
	public int getTextFieldSocialSec() {
		int sn = Integer.parseInt(textFieldSocialSec.getText());
		return sn;
	}
	
	public String getTextFieldName() {
		String name = textFieldName.getText();
		return name;
	}
	
	public String getTextFieldMail() {
		String mail = textFieldMail.getText();
		return mail;
	}
	
	public int getTextFieldPhone() {
		int phone = Integer.parseInt(textFieldPhone.getText());
		return phone;
	}
	
	public int getNumSeats() {
		int numSeats = (Integer) seats.getValue();
		return numSeats;
	}
}