package Views;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Random;

import Utils.Constants;
import Utils.DataBaseConnector;

public class OpisOferty extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTable table;
	static Object rowDATAA[][] = new Object[25][9];
	static String idTable[] = new String[25];

	/**
	 * Create the panel.
	 */
	public OpisOferty() {
		setLayout(null);

		JButton btnNewButton = new JButton("Dodaj now\u0105 ofert\u0119");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodajOferte();
			}
		});
		btnNewButton.setBounds(238, 309, 175, 30);
		add(btnNewButton);

		JButton btnNewButton_2 = new JButton(
				"Usu\u0144 zaznaczon\u0105 ofert\u0119 ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsunOferte();
			}
		});
		btnNewButton_2.setBounds(423, 309, 175, 30);
		add(btnNewButton_2);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table = new JTable(rowDATAA, Constants.columnNamesOffers){
		    public boolean isCellEditable(int rowIndex, int colIndex) {
		        return false;   //Disallow the editing of any cell
		    }
		};
		table.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		table.setDefaultRenderer(Object.class, centerRenderer);
		
	/*	DefaultTableModel tableModel = new DefaultTableModel() {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		        //all cells false
		        return false;
		    }
		};

		table.setModel(tableModel);*/
	//	table.setEnabled(false);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 38, 837, 262);
		add(scrollPane, BorderLayout.CENTER);

	}

	
	public static void fillTable() {

		String stmtStr = Constants.SELECT_ALL_OFFERS;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// table.repaint();
		// table.update(getGraphics());
		// table.revalidate();
		con = DataBaseConnector.getConnection();
		if (con == null) {
			// label.setText("Blad polaczenia z baza danych");
		} else {
			try {

				stmt = con.prepareStatement(stmtStr);
				System.out.println(stmt.toString());
				rs = stmt.executeQuery();

				int row = 0;

				clearTable();
				while (rs.next()) {
					rowDATAA[row][0] = rs.getString(Constants.DB_OFFER_ID);
					rowDATAA[row][1] = rs.getString(Constants.DB_TITLE);
									
					rowDATAA[row][2] = rs.getString(Constants.DB_DESCRIPTION);
					rowDATAA[row][3] = rs.getString(Constants.DB_COUNTRY);
					rowDATAA[row][4] = rs.getString(Constants.DB_CITY);
					rowDATAA[row][5] = 4 * rs.getInt(Constants.DB_PERSON_COUNT);
					rowDATAA[row][6] = rs.getString(Constants.DB_FINAL_PRICE);
					rowDATAA[row][7] = rs.getString(Constants.DB_MARK);
					idTable[row] = rs.getString(Constants.DB_ID);
					row++;

				}
				// DataBaseConnector.close(rs, stmt, con);
				// table = new JTable(rowDATAA, Constants.columnNamesOffers);
				table.repaint();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private void DodajOferte() {
		OpcjaOferty ofe = new OpcjaOferty();
		ofe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ofe.setVisible(true);
		
		
		
		
	}

	private void UsunOferte() {

		int rowId = table.getSelectedRow();
		System.out.println("Indeks " + rowId);
		if (rowId == -1 || rowDATAA[rowId][0] == null) {
			JOptionPane.showMessageDialog(null, "Zaznaczono pusty wiersz");

		} else {
			CallableStatement stmt = null;
			Connection con = DataBaseConnector.getConnection();
			if (con == null) {
				JOptionPane.showMessageDialog(null,
						"B³¹d po³¹czenia z baz¹ danych");
			} else {
				// int confirmation = JOptionPane.showConfirmDialog(null,
				// "Czy na pewno chcesz usun¹æ t¹ ofertê?");

				// System.out.println("CONF"+ confirmation);

				if (JOptionPane.showConfirmDialog(null,
						"Czy na pewno chcesz usun\u0105\u0107 t\u0119 ofert\u0119?") == 0) {
					try {
						stmt = con
								.prepareCall("{?= call OFERTA_USUN_OPCJE (?)}");
						stmt.registerOutParameter(1, Types.INTEGER);

						stmt.setString(2, idTable[rowId]);

						stmt.execute();
						int retVal = stmt.getInt(1);
						if (retVal != -1) {
							System.out.println("Usunieto rezerwacje " + retVal);

							JOptionPane.showMessageDialog(null,
									"Usunieto ofertê");
							fillTable();
							table.repaint();
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
		}
	}

	static void clearTable() {

		for (int i = 0; i < rowDATAA.length; i++) {
			for (int j = 0; j < rowDATAA[i].length; j++) {
				rowDATAA[i][j] = null;
				// System.out.println(rowDATAA[i].length);
			}
		}

	}

}
