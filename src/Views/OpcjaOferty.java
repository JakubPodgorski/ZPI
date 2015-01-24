package Views;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class OpcjaOferty extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpcjaOferty frame = new OpcjaOferty();
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
	public OpcjaOferty() {
		setTitle("Opcje oferty");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOferta = new JLabel("Oferta:");
		lblOferta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOferta.setBounds(23, 27, 93, 14);
		contentPane.add(lblOferta);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(126, 24, 126, 20);
		contentPane.add(comboBox);
		
		JButton btnNowaOferta = new JButton("Nowa oferta");
		btnNowaOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodajOpisOferty();
			}
		});
		btnNowaOferta.setBounds(274, 23, 105, 23);
		contentPane.add(btnNowaOferta);
		
		JLabel lblTerminOd = new JLabel("Termin od:");
		lblTerminOd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTerminOd.setBounds(23, 58, 93, 14);
		contentPane.add(lblTerminOd);
		
		textField = new JTextField();
		textField.setBounds(126, 55, 126, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTerminDo = new JLabel("Termin do:");
		lblTerminDo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTerminDo.setBounds(23, 89, 93, 14);
		contentPane.add(lblTerminDo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 86, 126, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCena = new JLabel("Cena:");
		lblCena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCena.setBounds(33, 118, 83, 14);
		contentPane.add(lblCena);
		
		textField_2 = new JTextField();
		textField_2.setBounds(126, 115, 126, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(126, 146, 126, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCenaZMar = new JLabel("Cena z mar\u017C\u0105:");
		lblCenaZMar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCenaZMar.setBounds(23, 149, 93, 14);
		contentPane.add(lblCenaZMar);
		
		textField_4 = new JTextField();
		textField_4.setBounds(126, 177, 126, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ilo\u015B\u0107 os\u00F3b w pokoju:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 183, 106, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(126, 208, 126, 43);
		contentPane.add(textArea);
		
		JLabel lblUwagi = new JLabel("Uwagi:");
		lblUwagi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUwagi.setBounds(50, 221, 65, 14);
		contentPane.add(lblUwagi);
		
		JButton btnZapisz = new JButton("Zapisz");
		btnZapisz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZapiszOferte();
			}
		});
		btnZapisz.setBounds(126, 268, 89, 27);
		contentPane.add(btnZapisz);
		
		JButton btnNewButton = new JButton("Anuluj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 setVisible(false);
		 dispose();
		 
			}
		});
		btnNewButton.setBounds(255, 268, 89, 27);
		contentPane.add(btnNewButton);
	}

	private void DodajOpisOferty()
	{
		DodawanieOferty op = new DodawanieOferty();
		op.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		op.setVisible(true);
		
	}
	
	private void ZapiszOferte()
	{
	
	}
}
