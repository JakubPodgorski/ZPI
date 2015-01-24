package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZmianaHasla extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnZapisz;
	private JButton btnAnuluj;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZmianaHasla frame = new ZmianaHasla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public ZmianaHasla() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAktualneHaso = new JLabel("Aktualne has\u0142o:");
		lblAktualneHaso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAktualneHaso.setBounds(10, 34, 126, 14);
		contentPane.add(lblAktualneHaso);
		
		JLabel lblNoweHaso = new JLabel("Nowe has\u0142o:");
		lblNoweHaso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNoweHaso.setBounds(10, 64, 126, 14);
		contentPane.add(lblNoweHaso);
		
		JLabel lblPowtrzNoweHaso = new JLabel("Powt\u00F3rz nowe has\u0142o:");
		lblPowtrzNoweHaso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPowtrzNoweHaso.setBounds(10, 94, 126, 14);
		contentPane.add(lblPowtrzNoweHaso);
		
		textField = new JPasswordField();
		textField.setBounds(146, 31, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(146, 64, 150, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JPasswordField();
		textField_2.setBounds(146, 91, 150, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		btnZapisz = new JButton("Zapisz");
		btnZapisz.setBounds(60, 133, 89, 30);
		contentPane.add(btnZapisz);
		
		btnAnuluj = new JButton("Anuluj");
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnAnuluj.setBounds(181, 133, 89, 30);
		contentPane.add(btnAnuluj);
	}

}
