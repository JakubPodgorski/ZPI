package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

import Utils.DataBaseConnector;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.awt.Font;
import java.awt.Color;

public class Rejestracja extends JFrame {

	private JPanel contentPane;
	private JTextField txLogin;
	private JTextField txHaslo;
	private JTextField txHaslo2;
	JComboBox cbPracownik; 
	JLabel lblIstniejeUser;
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
		
		panel.setBorder(BorderFactory.createTitledBorder("Dane u\u017Cytkownika"));
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(16, 27, 93, 14);
		panel.add(lblNewLabel);
		
		txLogin = new JTextField();
		txLogin.setBounds(119, 24, 145, 20);
		panel.add(txLogin);
		txLogin.setColumns(10);
		
		txHaslo = new JPasswordField();
		txHaslo.setBounds(119, 55, 145, 20);
		panel.add(txHaslo);
		txHaslo.setColumns(10);
		
		txHaslo2 = new JPasswordField();
		txHaslo2.setBounds(119, 86, 145, 20);
		panel.add(txHaslo2);
		txHaslo2.setColumns(10);
		
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
		
		cbPracownik = new JComboBox();
		cbPracownik.setBounds(120, 26, 140, 20);
		panel_1.add(cbPracownik);
		
		cbPracownik.addItem("Administrator");
		cbPracownik.addItem("Pracownik");
		
		
		JLabel lblNewLabel_3 = new JLabel("Stanowisko:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 29, 100, 14);
		panel_1.add(lblNewLabel_3);
		
		JButton btnRejestruj = new JButton("Rejestruj");
		btnRejestruj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rejestracja();
			}
		});
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
		
		 lblIstniejeUser = new JLabel("");
		 lblIstniejeUser.setForeground(Color.RED);
		 lblIstniejeUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIstniejeUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblIstniejeUser.setBounds(10, 320, 307, 30);
		contentPane.add(lblIstniejeUser);
	}

	
	private void Rejestracja()
	{
		if(txLogin.getText().equals(""))
		{
			lblIstniejeUser.setText("Podaj login!");
			return;
		}
		
		if(txHaslo.getText().equals("") || txHaslo2.getText().equals(""))
		{
			lblIstniejeUser.setText("Podaj haslo!");
			return;
		}
		
		lblIstniejeUser.setText("");
		if(!txHaslo.getText().equals(txHaslo2.getText()))
		{
			lblIstniejeUser.setText("Wprowadzone has\u0142a s\u0105 r\u00F3\u017Cne");
			txHaslo2.setText("");
			txHaslo2.setFont(txHaslo2.getFont());
			return;
		}
		else
		{		
			
				
			CallableStatement stmt = null;
			Connection	con = DataBaseConnector.getConnection();
			if(con==null){
				 JOptionPane.showMessageDialog(null, "B\u0142\u0105d po\u0142\u0105czenia z baz\u0105 danych");
			}
			else{

				
				try {
					String login = txLogin.getText().toString();
					String haslo = txHaslo.getText().toString();
					String pracownik = cbPracownik.getSelectedItem().toString();
					if(pracownik.equals("Pracownik"))
					{
					stmt = con.prepareCall("{?= call user_add_user (?, ?)}");
					}
					else
					{
						stmt = con.prepareCall("{?= call user_add_admin (?, ?)}");
					}
					stmt.registerOutParameter (1, Types.INTEGER);
					
					 stmt.setString (2, login);  
					 stmt.setString (3, haslo);   
					 
					 stmt.execute ();
					 int retVal = stmt.getInt (1);
					
					 if(retVal == -1)
					 {
						 lblIstniejeUser.setText("Podany login jest zaj\u0119ty!");
					 
					 }
					 else
						 JOptionPane.showMessageDialog(null, "Dodano u\u017Cytkownika o loginie: " + login);
		
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				
			}
		}
	}
}
