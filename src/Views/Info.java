package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Info extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Info frame = new Info();
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
	public Info() {
		setTitle("O programie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 11, 166, 100);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon("logo_srednie.png");
		lblNewLabel.setIcon(icon);
		
		JLabel lblAsystentBiuraTurystycznego = new JLabel("Asystent Biura Turystycznego");
		lblAsystentBiuraTurystycznego.setBounds(202, 11, 191, 14);
		contentPane.add(lblAsystentBiuraTurystycznego);
		
		JLabel lblStworzonePrzez = new JLabel("Stworzone przez:ZPITeam");
		lblStworzonePrzez.setBounds(202, 38, 196, 14);
		contentPane.add(lblStworzonePrzez);
		
		JLabel lblWersja = new JLabel("Wersja 1.0");
		lblWersja.setBounds(202, 63, 136, 14);
		contentPane.add(lblWersja);
		
		JLabel lblKontaktAndrzejbuziaczekpl = new JLabel("Kontakt: zpi_projekt@gmail.pl");
		lblKontaktAndrzejbuziaczekpl.setBounds(202, 88, 196, 14);
		contentPane.add(lblKontaktAndrzejbuziaczekpl);
	}

}
