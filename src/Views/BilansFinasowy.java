package Views;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class BilansFinasowy extends JPanel {

	/**
	 * Create the panel.
	 */
	public BilansFinasowy() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(66, 94, 46, 14);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(122, 90, 89, 23);
		add(btnNewButton);

	}

}
