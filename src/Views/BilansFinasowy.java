package Views;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import Utils.DataBaseConnector;
import Utils.Constants;
import Utils.Parsing;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class BilansFinasowy extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	Object rowDATAA[][] = new Object[15][9];
	private JDatePickerImpl datePickerFrom;
	private JDatePickerImpl datePickerTo;

	/**
	 * Create the panel.
	 */
	public BilansFinasowy() {
		setLayout(null);

		final JLabel label = new JLabel("");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(629, 300, 145, 56);
		add(label);

		JLabel label_1 = new JLabel("BILANS:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(558, 300, 75, 56);
		add(label_1);

		Date date = new Date();

		UtilDateModel modelFrom = new UtilDateModel();

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -31);
		Date dateMinus31Days = cal.getTime();

		modelFrom.setDate(dateMinus31Days.getYear() + 1900,
				dateMinus31Days.getMonth(), dateMinus31Days.getDate());
		modelFrom.setSelected(true);
		JDatePanelImpl datePanelFrom = new JDatePanelImpl(modelFrom);
		datePickerFrom = new JDatePickerImpl(datePanelFrom);
		datePickerFrom.setBounds(141, 319, 115, 20);
		add(datePickerFrom);

		UtilDateModel modelTo = new UtilDateModel();
		modelTo.setDate(date.getYear() + 1900, date.getMonth(), date.getDate());
		modelTo.setSelected(true);

		JDatePanelImpl datePanelTo = new JDatePanelImpl(modelTo);

		datePickerTo = new JDatePickerImpl(datePanelTo);
		datePickerTo.setBounds(293, 319, 115, 20);
		add(datePickerTo);

		JLabel label_2 = new JLabel("Do:");
		label_2.setBounds(266, 322, 22, 14);
		add(label_2);

		JLabel label_3 = new JLabel("Od:");
		label_3.setBounds(117, 322, 29, 14);
		add(label_3);

		JLabel lblOferta = new JLabel("Oferta:");
		lblOferta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOferta.setBounds(0, 13, 57, 14);
		add(lblOferta);

		JButton button = new JButton("Wylicz bilans");
		button.setBounds(428, 319, 110, 23);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		table = new JTable(rowDATAA, Constants.columnNamesBilans) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false; // Disallow the editing of any cell
			}
		};
		table.setDefaultRenderer(Object.class, centerRenderer);
		table.setAutoCreateRowSorter(true);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 38, 837, 262);

		table.getModel().addTableModelListener(new TableModelListener() {

			public void tableChanged(TableModelEvent e) {
				System.out.println(e);
			}

		});

		add(scrollPane, BorderLayout.CENTER);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dateFrom = (Date) datePickerFrom.getModel().getValue();
				Date dateTo = (Date) datePickerTo.getModel().getValue();
				if (dateFrom == null || dateTo == null) {
					label.setText("Wybierz daty");
				} else {
					String stmtStr = Constants.SELECT_EARNINGS;
					Connection con = null;
					PreparedStatement stmt = null;
					ResultSet rs = null;
					con = DataBaseConnector.getConnection();
					if (con == null) {
						label.setText("Blad polaczenia z baza danych");
					} else {
						try {
							DecimalFormat df = new DecimalFormat("#.00");

							String dateFromString = Parsing
									.dateToString(dateFrom);
							String dateToString = Parsing.dateToString(dateTo);

							stmt = con.prepareStatement(stmtStr);
							stmt.setString(1, dateFromString);
							stmt.setString(2, dateToString);
							System.out.println(stmt.toString());
							rs = stmt.executeQuery();
							clearTable();

							double earnings = 0;
							// if (rs == null) {
							// DataBaseConnector.close(rs, stmt, con);
							// }
							int row = 0;
							while (rs.next() && row < rowDATAA.length) {
								Connection con3 = null;
								con3 = DataBaseConnector.getConnection();
								ResultSet rs3 = null;
								String stmtStr3 = Constants.SELECT_EARNINGS_WITH_RESERVATION;
								PreparedStatement stmt3 = null;
								stmt3 = con3.prepareStatement(stmtStr3);
								stmt3.setString(1, dateFromString);
								stmt3.setString(2, dateToString);
								stmt3.setString(3, rs.getString(3));

								System.out.println(stmt3.toString());
								rs3 = stmt3.executeQuery();
								double earnings_temp = 0;
								int person_count = 0;
								if (!rs3.isBeforeFirst()) {
									earnings_temp -= rs.getDouble(4) / 10;
								}

								else {
									while (rs3.next()) {
										earnings_temp += rs3.getLong(1)
												* rs3.getLong(2);
										person_count += rs3.getLong(2);
									}

								}
								earnings += earnings_temp;
								rowDATAA[row][5] = person_count;
								rowDATAA[row][6] = df.format(earnings_temp);
								row++;

							}
							// DataBaseConnector.close(rs, stmt, con);

							if (earnings > 0) {
								label.setForeground(new Color(0, 153, 0));
							} else {
								label.setForeground(Color.red);

							}

							label.setText(df.format(earnings));

							String stmtStr2 = Constants.SELECT_OFFERS_TIMESTAMP;
							PreparedStatement stmt2 = null;
							ResultSet rs2 = null;

							// con=null;
							stmt2 = con.prepareStatement(stmtStr2);

							stmt2.setString(1, dateFromString);
							stmt2.setString(2, dateToString);
							System.out.println(stmtStr2.toString());
							rs2 = stmt2.executeQuery();

							// if (rs == null) {
							// DataBaseConnector.close(rs, stmt, con);
							// }

							int rownumber = 0;
							while (rs2.next() && rownumber < rowDATAA.length) {

								rowDATAA[rownumber][0] = rs2
										.getString(Constants.DB_OFFER_ID);

								Date offerFrom = rs2
										.getDate(Constants.DB_DATE_FROM);
								String offerFromString = Parsing
										.dateToStringVisualFriendly(offerFrom);
								Date offerTo = rs2
										.getDate(Constants.DB_DATE_TO);
								String offerToString = Parsing
										.dateToStringVisualFriendly(offerTo);

								rowDATAA[rownumber][1] = offerFromString
										+ " - " + offerToString;
								rowDATAA[rownumber][2] = rs2
										.getString(Constants.DB_CITY);
								rowDATAA[rownumber][3] = rs2
										.getString(Constants.DB_COST);
								rowDATAA[rownumber][4] = rs2
										.getString(Constants.DB_FINAL_PRICE);

								rownumber++;

							}
							//
							table.repaint();

						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		add(button);

	}

	void clearTable() {

		for (int i = 0; i < rowDATAA.length; i++) {
			for (int j = 0; j < rowDATAA[i].length; j++) {
				rowDATAA[i][j] = null;
				// System.out.println(rowDATAA[i].length);
			}
		}

	}

}
