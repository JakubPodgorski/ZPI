package Views;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class BilansFinasowy extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public BilansFinasowy() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 38, 837, 259);
		add(table);
		
		JLabel label = new JLabel("New label");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(559, 300, 85, 56);
		add(label);
		
		JLabel label_1 = new JLabel("BILANS:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(488, 300, 75, 56);
		add(label_1);
		
		JButton button = new JButton("Wylicz bilans");
		button.setBounds(358, 319, 110, 23);
		add(button);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(263, 319, 85, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(141, 319, 85, 20);
		add(comboBox_1);
		
		JLabel label_2 = new JLabel("Do:");
		label_2.setBounds(236, 322, 22, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("Od:");
		label_3.setBounds(117, 322, 29, 14);
		add(label_3);
		
		JLabel lblOferta = new JLabel("Oferta:");
		lblOferta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOferta.setBounds(0, 13, 57, 14);
		add(lblOferta);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(67, 10, 160, 20);
		add(comboBox_2);

	}
}
