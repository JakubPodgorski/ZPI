package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodawanieOferty extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodawanieOferty frame = new DodawanieOferty();
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
	public DodawanieOferty() {
		setTitle("Nowa oferta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTytu = new JLabel("Tytu\u0142:");
		lblTytu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTytu.setBounds(10, 24, 91, 14);
		contentPane.add(lblTytu);
		
		JLabel lblNewLabel = new JLabel("Opis:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 63, 91, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(111, 21, 175, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(111, 49, 175, 73);
		contentPane.add(textArea);
		
		JLabel lblKraj = new JLabel("Kraj:");
		lblKraj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKraj.setBounds(37, 138, 64, 14);
		contentPane.add(lblKraj);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 133, 175, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMiasto = new JLabel("Miasto:");
		lblMiasto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMiasto.setBounds(55, 163, 46, 14);
		contentPane.add(lblMiasto);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 160, 175, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnZapisz = new JButton("Zapisz");
		btnZapisz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZapiszDane();
			}
		});
		btnZapisz.setBounds(79, 205, 89, 27);
		contentPane.add(btnZapisz);
		
		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				
			}
		});
		btnAnuluj.setBounds(197, 205, 89, 27);
		contentPane.add(btnAnuluj);
	}
	
	private void ZapiszDane()
	{
		
	}
}
