package Views;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import Utils.DataBaseConnector;
import Utils.Constants;
public class Rezerwacje extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	 Object rowDATAA[][];
	
	public Rezerwacje() {
		setLayout(null);
		
		
		rowDATAA = new Object[60][7];
		
		 JTable table = new JTable(rowDATAA, Constants.kolumnyRezerwacje);
		    JScrollPane scrollPane = new JScrollPane(table);
		    scrollPane.setBounds(10, 38, 837, 262);
		
		
	//	table = new JTable();
		//table.setBounds(10, 10, 837, 287);
		//add(table);
		    add(scrollPane, BorderLayout.CENTER);
		JButton btnNewButton = new JButton("Zaakceptuj rezerwacj\u0119");
		btnNewButton.setBounds(182, 314, 165, 30);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Op\u0142acenie rezerwacji");
		btnNewButton_1.setBounds(371, 314, 165, 30);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Usu\u0144 rezerwacj\u0119");
		btnNewButton_2.setBounds(559, 314, 165, 30);
		add(btnNewButton_2);
		
	//	WyszukajRezerwacje();

	}

	public void WyszukajRezerwacje()
	{
		String stmtStr = Constants.SELECT_RESERVATIONS;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		con = DataBaseConnector.getConnection();
		if(con==null){
			 JOptionPane.showMessageDialog(null, "B³¹d po³¹czenia z baz¹ danych");
		}
		else{
	
			try {
				
			//	String dateFromString =Parsing.dateToString(dateFrom) ;
			//	String dateToString =Parsing.dateToString(dateTo) ;
				
				stmt = con.prepareStatement(stmtStr);
			
				System.out.println(stmt.toString());
				rs = stmt.executeQuery();

				
				int rownumber = 0;
				while (rs.next()) {
					
					rowDATAA[rownumber][0]=rs.getString("ID");
					rowDATAA[rownumber][1]=rs.getString("NUMEROFERTY");
					rowDATAA[rownumber][2]=rs.getString("IMIE") + " " + rs.getString("NAZWISKO");
					rowDATAA[rownumber][3]=rs.getString("MIASTO") +" " + rs.getString("ULICA") + " " + rs.getString("NUMERDOMU") +" " + rs.getString("KODPOCZTOWY");
					rowDATAA[rownumber][4]=rs.getString("MAIL");
					rowDATAA[rownumber][5]=rs.getString("TELEFON");
					rowDATAA[rownumber][6]=rs.getString("STATUS");

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
	
	
		
		
		
	}
	
}
