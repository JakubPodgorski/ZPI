package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rejestracja extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rejestracja frame = new Rejestracja();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public Rejestracja() {
		setTitle("Rejestracja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 343, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProszOWprowadzenie = new JLabel("Prosz\u0119 o wprowadzenie");
		lblProszOWprowadzenie.setBounds(95, 11, 194, 14);
		contentPane.add(lblProszOWprowadzenie);
		
		JLabel lblPoprawnychDanych = new JLabel("poprawnych danych");
		lblPoprawnychDanych.setBounds(95, 36, 154, 14);
		contentPane.add(lblPoprawnychDanych);
		
		JLabel lblDlaNowegoUytkownika = new JLabel("dla nowego u\u017Cytkownika:");
		lblDlaNowegoUytkownika.setBounds(95, 61, 154, 14);
		contentPane.add(lblDlaNowegoUytkownika);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 98, 306, 128);
		contentPane.add(panel);
		
		panel.setBorder(BorderFactory.createTitledBorder("Dane u¿ytkownika"));
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(16, 27, 93, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(119, 24, 145, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(119, 55, 145, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(119, 86, 145, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Has\u0142o:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(26, 58, 83, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Powt\u00F3z has\u0142o:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 89, 99, 14);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 237, 306, 68);
		contentPane.add(panel_1);
		panel_1.setBorder(BorderFactory.createTitledBorder("Dane pracownika"));
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(120, 26, 140, 20);
		panel_1.add(comboBox);
		
		comboBox.addItem("Zarz¹dca");
		comboBox.addItem("Pracownik");
		
		JLabel lblNewLabel_3 = new JLabel("Stanowisko:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 29, 100, 14);
		panel_1.add(lblNewLabel_3);
		
		JButton btnRejestruj = new JButton("Rejestruj");
		btnRejestruj.setBounds(58, 361, 96, 23);
		contentPane.add(btnRejestruj);
		
		JButton btnNewButton = new JButton("Anuluj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnNewButton.setBounds(164, 361, 96, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblIstniejeUser = new JLabel("");
		lblIstniejeUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblIstniejeUser.setBounds(10, 326, 307, 14);
		contentPane.add(lblIstniejeUser);
	}

}
