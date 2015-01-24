package Views;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

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
		
		table = new JTable();
		table.setBounds(10, 38, 837, 259);
		add(table);
		
		JLabel label = new JLabel("New label");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(629, 300, 85, 56);
		add(label);
		
		JLabel label_1 = new JLabel("BILANS:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(558, 300, 75, 56);
		add(label_1);
		
		JButton button = new JButton("Wylicz bilans");
		button.setBounds(428, 319, 110, 23);
		add(button);
		
		
		UtilDateModel modelFrom = new UtilDateModel();
		JDatePanelImpl datePanelFrom = new JDatePanelImpl(modelFrom);
		JDatePickerImpl datePickerFrom = new JDatePickerImpl(datePanelFrom);	
		datePickerFrom.setBounds(141, 319, 115, 20);
		add(datePickerFrom);
		
		
		UtilDateModel modelTo = new UtilDateModel();
		JDatePanelImpl datePanelTo = new JDatePanelImpl(modelTo);
		JDatePickerImpl datePickerTo = new JDatePickerImpl(datePanelTo); 
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
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(67, 10, 160, 20);
		add(comboBox_2);

	}
}
