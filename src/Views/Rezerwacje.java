package Views;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.awt.BorderLayout;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import Utils.DataBaseConnector;
import Utils.Constants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



class Status
{
	HashMap<Integer, String> statusy;
	
	 Status(){
	 statusy = new HashMap<Integer,String>();
	 statusy.put(1, "W realizacji");
	 statusy.put(2, "Nie op\u0142acone");
	 statusy.put(3, "Op\u0142acone");
	 }
public int getValue(String text)
{
	if(text.equals("W realizacji")) return 1;
	else if(text.equals("Nie op\u0142acone")) return 2;
	else if(text.equals("Op\u0142acone")) return 3;
	
	else return -1;
	
}
public String getText(int value)
{
	return statusy.get(value);
}
}

public class Rezerwacje extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	 Object rowDATAA[][];
	
	private Status sts;
	
	
	public Rezerwacje() {
		setLayout(null);
		
		
		rowDATAA = new Object[60][7];
		sts = new Status();
		    table = new JTable(rowDATAA, Constants.kolumnyRezerwacje);
		    table.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		    JScrollPane scrollPane = new JScrollPane(table);
		    scrollPane.setBounds(10, 38, 837, 262);
		
		
	//	table = new JTable();
		//table.setBounds(10, 10, 837, 287);
		//add(table);
		    add(scrollPane, BorderLayout.CENTER);
		JButton btnNewButton = new JButton("Zaakceptuj rezerwacj\u0119");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AkceptujRezerwacje();
			}
		});
		btnNewButton.setBounds(182, 314, 165, 30);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Op\u0142acenie rezerwacji");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				OplacRezerwacje();
			}
		});
		btnNewButton_1.setBounds(371, 314, 165, 30);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Usu\u0144 rezerwacj\u0119");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsunRezerwacje();
			}
		});
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
			 JOptionPane.showMessageDialog(null, "B\u0142¹d po\u0142¹czenia z baz\u0105 danych");
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
					rowDATAA[rownumber][6]= sts.getText( Integer.parseInt(rs.getString("STATUS")));

					//System.out.println(rs2.getLong(1));
					
					rownumber++;
					
				}
				rs.close();
				stmt.close();
				// DataBaseConnector.close(rs, stmt, con);
				/*
				    table = new JTable(rowDATAA, Constants.columnNames);
				    JScrollPane scrollPane = new JScrollPane(table);
				    scrollPane.setBounds(10, 38, 837, 262);
				    add(scrollPane, BorderLayout.CENTER);
*/
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
	
		
		
		
	}
	private void AkceptujRezerwacje()
	{
		
		int rowId = table.getSelectedRow();
		System.out.println("Indeks " + rowId);
		if(rowId == -1 ||  rowDATAA[rowId][0] == null )
		{
			JOptionPane.showMessageDialog(null, "Zaznaczono pusty wiersz");
		}
		else
		{
			int status = sts.getValue((String)  rowDATAA[rowId][6]);
			
			if(status != 1 )
			{
				JOptionPane.showMessageDialog(null, "Rezerwacja ju\u017C zaakceptowana!");
				return;
				
			}
			
			ZmienStatus(status, rowId);
		}
			
	
}
	
	private void OplacRezerwacje()
	{
		int rowId = table.getSelectedRow();
		System.out.println("Indeks " + rowId);
		if(rowId == -1 ||  rowDATAA[rowId][0] == null )
		{
			JOptionPane.showMessageDialog(null, "Zaznaczono pusty wiersz");
		}
		else
		{
			int status = sts.getValue((String)  rowDATAA[rowId][6]);
			
			if(status != 2 )
			{
				JOptionPane.showMessageDialog(null, "Rezerwacja ju\u017C op\u0142acona lub nie zaakceptowana!");
				return;
				
			}
			
			ZmienStatus(status, rowId);
		}
	}
	
	
	private void ZmienStatus(int status, int rowId)
	{
		String procedure = "AKTUALIZUJ_ZAMOWIENIE_STATUS";
		
	CallableStatement stmt = null;
	Connection	con = DataBaseConnector.getConnection();
	if(con==null){
		 JOptionPane.showMessageDialog(null, "B\u0142\u0105d po\u0142\u0105czenia z baz\u0105 danych");
	}
	else{

		try {
			stmt = con.prepareCall("{?= call AKTUALIZUJ_ZAMOWIENIE_STATUS (?, ?)}");
			stmt.registerOutParameter (1, Types.INTEGER);
			
			 stmt.setString (2, (String) rowDATAA[rowId][0]);  
			 stmt.setString (3, Integer.toString(status + 1));   
			 
			 stmt.execute ();
			 int new_status = stmt.getInt (1);
			 System.out.println("Zmieniony status " + new_status);
			// stmt.close();
			// con.close();
			 if(new_status != -1)
			 {
			 rowDATAA[rowId][6] = sts.getText(status + 1);
			 table.repaint();
			 }
//();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		
	}
}
		private void UsunRezerwacje()
		{
			int rowId = table.getSelectedRow();
			System.out.println("Indeks " + rowId);
			if(rowId == -1 ||  rowDATAA[rowId][0] == null )
			{
				JOptionPane.showMessageDialog(null, "Zaznaczono pusty wiersz");
			}
			String procedure = "AKTUALIZUJ_ZAMOWIENIE_STATUS";
			
			CallableStatement stmt = null;
			Connection	con = DataBaseConnector.getConnection();
			if(con==null){
				 JOptionPane.showMessageDialog(null, "B\u0142\u0105d po\u0142\u0105czenia z baz\u0105 danych");
			}
			else{

				try {
					stmt = con.prepareCall("{?= call USUN_ZAMOWIENIE (?)}");
					stmt.registerOutParameter (1, Types.INTEGER);
					
					 stmt.setString (2, (String) rowDATAA[rowId][0]);  
					
					 
					 stmt.execute ();
				     int retVal = stmt.getInt (1);
				     if(retVal != -1)
				     {
					 System.out.println("Usunieto rezerwacje " );
					// 
					for(int i =0; i < rowDATAA[rowId].length; i ++)
					{
						rowDATAA[rowId][i] = null;
					}
					table.repaint();
					}
					// stmt.close();
					// con.close();
					
		//();
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				
			}
			
			
		}
	}
