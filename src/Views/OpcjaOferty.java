package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.Random;

import javax.swing.*;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import Utils.Constants;
import Utils.DataBaseConnector;
import Utils.Parsing;
public class OpcjaOferty extends JFrame {
	private static JComboBox comboBox;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextArea textArea;
	
	
	private JDatePickerImpl datePickerFrom;
	private JDatePickerImpl datePickerTo;
	
	private static String offersTable[][] = new String[30][2];

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpcjaOferty frame = new OpcjaOferty();
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
	public OpcjaOferty() {
		setTitle("Opcje oferty");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOferta = new JLabel("Oferta:");
		lblOferta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOferta.setBounds(23, 27, 93, 14);
		contentPane.add(lblOferta);
		
		
		
		comboBox = new JComboBox();
		setOffers();

		comboBox.setBounds(126, 24, 126, 20);
		contentPane.add(comboBox);
		JButton btnNowaOferta = new JButton("Nowa oferta");
		btnNowaOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodajOpisOferty();
			}
		});
		btnNowaOferta.setBounds(274, 23, 105, 23);
		contentPane.add(btnNowaOferta);

		
		JLabel lblTerminOd = new JLabel("Termin od:");
		lblTerminOd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTerminOd.setBounds(23, 58, 93, 14);
		contentPane.add(lblTerminOd);
		
		
		UtilDateModel modelFrom = new UtilDateModel();
		JDatePanelImpl datePanelFrom = new JDatePanelImpl(modelFrom);
		  datePickerFrom = new JDatePickerImpl(
				datePanelFrom);
		datePickerFrom.setBounds(126, 55, 126, 20);
		add(datePickerFrom);

	
		
		
//		
//		textField = new JTextField();
//		textField.setBounds(126, 55, 126, 20);
//		contentPane.add(textField);
//		textField.setColumns(10);
//		
		JLabel lblTerminDo = new JLabel("Termin do:");
		lblTerminDo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTerminDo.setBounds(23, 89, 93, 14);
		contentPane.add(lblTerminDo);
		
//		textField_1 = new JTextField();
//		textField_1.setBounds(126, 86, 126, 20);
//		contentPane.add(textField_1);
//		textField_1.setColumns(10);
		
		UtilDateModel modelTo = new UtilDateModel();
		JDatePanelImpl datePanelTo = new JDatePanelImpl(modelTo);
		datePickerTo = new JDatePickerImpl(datePanelTo);
		datePickerTo.setBounds(126, 86, 126, 20);
		add(datePickerTo);
		
		
		JLabel lblCena = new JLabel("Cena:");
		lblCena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCena.setBounds(33, 118, 83, 14);
		contentPane.add(lblCena);
		
		textField_2 = new JTextField();
		textField_2.setBounds(126, 115, 126, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(126, 146, 126, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCenaZMar = new JLabel("Cena z mar\u017C\u0105:");
		lblCenaZMar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCenaZMar.setBounds(23, 149, 93, 14);
		contentPane.add(lblCenaZMar);
		
		textField_4 = new JTextField();
		textField_4.setBounds(126, 177, 126, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ilo\u015B\u0107 os\u00F3b w pokoju:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 183, 106, 14);
		contentPane.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(126, 208, 126, 43);
		contentPane.add(textArea);
		
		JLabel lblUwagi = new JLabel("Uwagi:");
		lblUwagi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUwagi.setBounds(50, 221, 65, 14);
		contentPane.add(lblUwagi);
		
		JButton btnZapisz = new JButton("Zapisz");
		btnZapisz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZapiszOferte();
			}
		});
		btnZapisz.setBounds(126, 268, 89, 27);
		contentPane.add(btnZapisz);
		
		JButton btnNewButton = new JButton("Anuluj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 setVisible(false);
		 dispose();
		 
			}
		});
		btnNewButton.setBounds(255, 268, 89, 27);
		contentPane.add(btnNewButton);
	}

	private void DodajOpisOferty()
	{
		DodawanieOferty op = new DodawanieOferty();
		op.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		op.setVisible(true);
		
	}
	
	private void ZapiszOferte()
	{
	
		String ID=null;
		for(int i=0; i<offersTable.length; i++)
		{ 
			if (comboBox.getSelectedItem()!=null && offersTable[i][1]!=null && comboBox.getSelectedItem().equals(offersTable[i][1])){
			ID=offersTable[i][0];
		}
			
			
		}
		Date dateFrom = (Date) datePickerFrom.getModel().getValue();
		Date dateTo = (Date) datePickerTo.getModel().getValue();
				
		
		String price = textField_2.getText();
		String final_price = textField_3.getText();
		String person_count = textField_4.getText();
		String comments = textArea.getText();		

			CallableStatement stmt = null;
			Connection con = DataBaseConnector.getConnection();
			
			
			if(ID==null || ID.isEmpty()){
				JOptionPane.showMessageDialog(null,
						"B³¹d pobierania ID opisu oferty, skontaktuj siê z dostawc¹ aplikacji");
			}
			
			else if(dateFrom==null || dateTo==null || price==null || price.isEmpty() ||final_price==null || final_price.isEmpty() || person_count==null || person_count.isEmpty()){
				JOptionPane.showMessageDialog(null,
						"Uzupe³nij wszystkie dane");
			}
			else if (con == null) {
				JOptionPane.showMessageDialog(null,
						"B³¹d po³¹czenia z baz¹ danych");
			} else {


					try {
						
						String dateFromString = Parsing
								.dateToString(dateFrom);
						String dateToString = Parsing.dateToString(dateTo);
						
						stmt = con
								.prepareCall("{?= call OFERTA_DODAJ_OPCJE (?,?,?,?,?,?,?)}");
						stmt.registerOutParameter(1, Types.INTEGER);

						Random rand = new Random();
						stmt.setString(2, ID);
						stmt.setString(3, dateFromString);
						stmt.setString(4, dateToString);
						stmt.setString(5, price);
						stmt.setString(6, final_price);
						stmt.setString(7, person_count);
						stmt.setString(8, comments);
						

						stmt.execute();
						int retVal = stmt.getInt(1);
						if (retVal != -1) {
							System.out.println("Dodano opis " + retVal);

							JOptionPane.showMessageDialog(null,"Dodano ofertê.");
							OpcjaOferty.setOffers();
							setVisible(false);
							dispose();
							
							
OpisOferty.fillTable();
							
							
		//TODO					fillTable();
		// TODO					table.repaint();
							
						}
						// stmt.close();
						// con.close();

						// ();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();

					}
				
			
		}
		
		
		
		
		
	
		
		
		
	}
	
	public static void setOffers(){
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		con = DataBaseConnector.getConnection();
		String stmtStr = Constants.SELECT_OFFERS_DESCRIPTION;

		if (con == null) {
			//label.setText("Blad polaczenia z baza danych");
		} else {
			try {
				stmt=con.prepareStatement(stmtStr);
				DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
				model.removeAllElements();
				comboBox.repaint();				System.out.println(stmt.toString());
				rs = stmt.executeQuery();
				clearTable();				
				// if (rs == null) {
				// DataBaseConnector.close(rs, stmt, con);
				// }
				int row = 0;
				while (rs.next()) {
					offersTable[row][0]=rs.getString(1);
					offersTable[row][1]=rs.getString(2);
					row++;
					comboBox.addItem(rs.getString(2));

				}
				// DataBaseConnector.close(rs, stmt, con);
				



	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}}
	
	
//	public static void setSelected(){
//		comboBox.setSelectedItem("kabababababa");
//	}
	
static void clearTable(){
	
	for (int i = 0; i < offersTable.length; i++) {
		for (int j = 0; j < offersTable[i].length; j++) {
			offersTable[i][j] = null;
			// System.out.println(rowDATAA[i].length);
		}
	}
}
	
	
}
