package Views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;

public class Rezerwacje extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Rezerwacje() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 10, 837, 287);
		add(table);
		
		JButton btnNewButton = new JButton("Zaakceptuj rezerwacj\u0119");
		btnNewButton.setBounds(182, 314, 165, 30);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Op\u0142acenie rezerwacji");
		btnNewButton_1.setBounds(371, 314, 165, 30);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Usu\u0144 rezerwacj\u0119");
		btnNewButton_2.setBounds(559, 314, 165, 30);
		add(btnNewButton_2);

	}

}
