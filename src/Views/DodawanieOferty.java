package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import Utils.DataBaseConnector;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Random;

public class DodawanieOferty extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodawanieOferty frame = new DodawanieOferty();
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
	public DodawanieOferty() {
		setTitle("Nowa oferta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTytu = new JLabel("Tytu\u0142:");
		lblTytu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTytu.setBounds(10, 24, 91, 14);
		contentPane.add(lblTytu);
		
		JLabel lblNewLabel = new JLabel("Opis:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 63, 91, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(111, 21, 175, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(111, 49, 175, 73);
		contentPane.add(textArea);
		
		JLabel lblKraj = new JLabel("Kraj:");
		lblKraj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKraj.setBounds(37, 138, 64, 14);
		contentPane.add(lblKraj);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 133, 175, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMiasto = new JLabel("Miasto:");
		lblMiasto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMiasto.setBounds(55, 163, 46, 14);
		contentPane.add(lblMiasto);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 160, 175, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		JLabel lblLink = new JLabel("Zdj\u0119cie:");
		lblLink.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLink.setBounds(55, 188, 46, 14);
		contentPane.add(lblLink);
		
		textField_3 = new JTextField();
		textField_3.setBounds(111, 187, 175, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		JButton btnZapisz = new JButton("Zapisz");
		btnZapisz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZapiszDane();
			}
		});
		btnZapisz.setBounds(79, 225, 89, 27);
		contentPane.add(btnZapisz);
		
		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				
			}
		});
		btnAnuluj.setBounds(197, 225, 89, 27);
		contentPane.add(btnAnuluj);
	}
	
	private void ZapiszDane()
	{
		
		
	String title=	textField.getText();
		String description = textArea.getText();
		String country = textField_1.getText();
		String city = textField_2.getText();
		String link = textField_3.getText();	

			CallableStatement stmt = null;
			Connection con = DataBaseConnector.getConnection();
			
			if(title==null || title.isEmpty() ||description==null || description.isEmpty() || country==null || country.isEmpty() || city==null || city.isEmpty() || link==null || link.isEmpty() ){
				JOptionPane.showMessageDialog(null,
						"Uzupe\u0142nij wszystkie dane");
			}
			else if (con == null) {
				JOptionPane.showMessageDialog(null,
						"B\u0142¹d po³¹czenia z baz¹ danych");
			} else {


					try {
						stmt = con
								.prepareCall("{?= call OFERTA_DODAJ_OPIS (?,?,?,?,?,?)}");
						stmt.registerOutParameter(1, Types.INTEGER);

						Random rand = new Random();
						stmt.setString(2, title);
						stmt.setString(3, description);
						stmt.setString(4, country);
						stmt.setString(5, city);
						stmt.setString(6, link);
						
						stmt.setString(7, Integer.toString(rand.nextInt(99999)));


						stmt.execute();
						int retVal = stmt.getInt(1);
						if (retVal != -1) {
							System.out.println("Dodano opis " + retVal);

							JOptionPane.showMessageDialog(null,"Dodano opis.");
							OpcjaOferty.setOffers();
							setVisible(false);
							dispose();

						}

						// ();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();

					}
				
			
		}
		
		
		
		
		
	}
}
