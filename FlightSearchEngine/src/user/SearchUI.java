package user;

import search.*;

import java.awt.*;
import javax.swing.*;
import admin.*;
import booking.*;
import search.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;


public class SearchUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDepart;
	private JTextField textFieldArrival;
	private JTextField textFieldDate;
	private JTable table;

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
		
		JLabel lblArrival = new JLabel("Arrival:");
		lblArrival.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblArrival.setBounds(300, 78, 89, 14);
		contentPane.add(lblArrival);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setBounds(300, 118, 89, 14);
		contentPane.add(lblDate);
		
		textFieldDepart = new JTextField();
		textFieldDepart.setBounds(400, 33, 144, 20);
		contentPane.add(textFieldDepart);
		textFieldDepart.setColumns(10);
		
		textFieldArrival = new JTextField();
		textFieldArrival.setBounds(400, 75, 144, 20);
		contentPane.add(textFieldArrival);
		textFieldArrival.setColumns(10);
		
		textFieldDate = new JTextField();
		textFieldDate.setBounds(400, 115, 144, 20);
		contentPane.add(textFieldDate);
		textFieldDate.setColumns(10);
		
		JButton btnSearchForFlight = new JButton("Search For Flights");
		btnSearchForFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSearchForFlight.setBounds(600, 66, 126, 40);
		contentPane.add(btnSearchForFlight);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 181, 988, 214);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
			
	}
}