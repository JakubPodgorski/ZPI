package Views;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;

public class Oferty extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Oferty() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 10, 837, 287);
		add(table);
		
		JButton btnNewButton = new JButton("Dodaj now\u0105 ofert\u0119");
		btnNewButton.setBounds(238, 309, 175, 30);
		add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Usu\u0144 zaznaczon\u0105 ofert\u0119 ");
		btnNewButton_2.setBounds(423, 309, 175, 30);
		add(btnNewButton_2);

	}

}
