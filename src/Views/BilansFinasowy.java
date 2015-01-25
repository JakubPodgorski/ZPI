package Views;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import Utils.DataBaseConnector;
import Utils.Constants;
import Utils.Parsing;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class BilansFinasowy extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public BilansFinasowy() {
		setLayout(null);
	
	

		final JLabel label = new JLabel("New label");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(629, 300, 145, 56);
		add(label);

		JLabel label_1 = new JLabel("BILANS:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(558, 300, 75, 56);
		add(label_1);

		UtilDateModel modelFrom = new UtilDateModel();
		JDatePanelImpl datePanelFrom = new JDatePanelImpl(modelFrom);
		final JDatePickerImpl datePickerFrom = new JDatePickerImpl(
		datePanelFrom);
		datePickerFrom.setBounds(141, 319, 115, 20);
		add(datePickerFrom);

		UtilDateModel modelTo = new UtilDateModel();
		JDatePanelImpl datePanelTo = new JDatePanelImpl(modelTo);
		final JDatePickerImpl datePickerTo = new JDatePickerImpl(datePanelTo);
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

		final Object rowDATAA[][] = new Object[60][6];

		
		   JTable table = new JTable(rowDATAA, Constants.columnNames);
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(10, 38, 837, 262);
	   
 
 

 table.getModel().addTableModelListener(new TableModelListener() {
	
   public void tableChanged(TableModelEvent e) {
 	  System.out.println(e);
   }
   
 });
	
 
	//	    table.setValueAt("",0,0);
		    add(scrollPane, BorderLayout.CENTER);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dateFrom = (Date) datePickerFrom.getModel()
						.getValue();
				Date dateTo = (Date) datePickerTo.getModel().getValue();
				if (dateFrom == null || dateTo == null) {
					label.setText("Wybierz daty");
				}
				else {
					String stmtStr = Constants.SELECT_EARNINGS;
					Connection con = null;
					PreparedStatement stmt = null;
					ResultSet rs = null;
					con = DataBaseConnector.getConnection();
					if(con==null){
						label.setText("Blad polaczenia z baza danych");
					}
					else{
					try {
						
						String dateFromString =Parsing.dateToString(dateFrom) ;
						String dateToString =Parsing.dateToString(dateTo) ;
						
						stmt = con.prepareStatement(stmtStr);
						stmt.setString(1,dateFromString);
						stmt.setString(2, dateToString);
						System.out.println(stmt.toString());
						rs = stmt.executeQuery();

						long earnings = 0;
						// if (rs == null) {
						// DataBaseConnector.close(rs, stmt, con);
						// }
						while (rs.next()) {
							earnings += rs.getLong(1);
							System.out.println(rs.getLong(1));
						}
						// DataBaseConnector.close(rs, stmt, con);
						label.setText(Long.toString(earnings));

						String stmtStr2 = Constants.SELECT_OFFERS;
						PreparedStatement stmt2 = null;
						ResultSet rs2 = null;
						
						//con=null;
						stmt2 = con.prepareStatement(stmtStr2);

						stmt2.setString(1,dateFromString);
						stmt2.setString(2, dateToString);
						System.out.println(stmtStr2.toString());
						rs2 = stmt2.executeQuery();

						// if (rs == null) {
						// DataBaseConnector.close(rs, stmt, con);
						// }
						
						
						int rownumber = 0;
						while (rs2.next()) {
							
							rowDATAA[rownumber][0]=rs2.getString(Constants.DB_OFFER_ID);
							rowDATAA[rownumber][1]=rs2.getString(Constants.DB_DATE_FROM)+" - "+rs2.getString(Constants.DB_DATE_TO);
							rowDATAA[rownumber][2]=rs2.getString(Constants.DB_CITY);
							rowDATAA[rownumber][3]=rs2.getString(Constants.DB_COST);
							rowDATAA[rownumber][4]=rs2.getString(Constants.DB_FINAL_PRICE);
							rowDATAA[rownumber][5]=rs2.getString(Constants.DB_COST);

							//System.out.println(rs2.getLong(1));
							
							rownumber++;
							
						}
						// DataBaseConnector.close(rs, stmt, con);
						
						   JTable table = new JTable(rowDATAA, Constants.columnNames);
						    JScrollPane scrollPane = new JScrollPane(table);
						    scrollPane.setBounds(10, 38, 837, 262);
						    add(scrollPane, BorderLayout.CENTER);

						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}}
		});
		add(button);
		

	}
}
