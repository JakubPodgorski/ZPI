package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Logowanie extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logowanie frame = new Logowanie();
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
	public Logowanie() {
		setTitle("Okno logowania");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProszOPodanie = new JLabel("Prosz\u0119 o podanie swoich danych dost\u0119powych:");
		lblProszOPodanie.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProszOPodanie.setBounds(25, 25, 259, 14);
		contentPane.add(lblProszOPodanie);
		
		textField = new JTextField();
		textField.setBounds(140, 50, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 81, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("U\u017Cytkownik:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(35, 53, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblHaso = new JLabel("Has\u0142o:");
		lblHaso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHaso.setBounds(45, 84, 90, 14);
		contentPane.add(lblHaso);
		
		JButton btnZaloguj = new JButton("Zaloguj");
		btnZaloguj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		//logowanie
				Menu m = new Menu();
				m.setDefaultCloseOperation(EXIT_ON_CLOSE);
				m.setVisible(true);
				
				setVisible(false);
				dispose();
				
			}
		});
		btnZaloguj.setBounds(25, 136, 110, 23);
		contentPane.add(btnZaloguj);
		
		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.setBounds(140, 136, 110, 23);
		contentPane.add(btnAnuluj);
		
		JButton btnZresetujHaso = new JButton("Zresetuj has\u0142o");
		btnZresetujHaso.setBounds(255, 136, 115, 23);
		contentPane.add(btnZresetujHaso);
		
		JLabel lblNiepoprawneHaslo = new JLabel("");
		lblNiepoprawneHaslo.setBounds(255, 69, 46, 14);
		contentPane.add(lblNiepoprawneHaslo);
	}
}
