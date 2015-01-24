package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Narz\u0119dzie administracyjne - Biuro podr\u00F3\u017Cy - Tw\u00F3j osobisty asystent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Logowanie");
		btnNewButton.setBounds(10, 11, 100, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rejestracja");
		btnNewButton_1.setBounds(121, 11, 100, 23);
		contentPane.add(btnNewButton_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 51, 860, 333);
		contentPane.add(tabbedPane);
		
		tabbedPane.addTab("Bilans finansowy oferty", new BilansFinasowy());
		tabbedPane.addTab("Panel Zarz¹dzania Rezerwacjami", new Rezerwacje());
		tabbedPane.addTab("Nadzorowanie ofertami", new Oferty());
		tabbedPane.addTab("Historia Klientów Biura", new Klienci());
		
		JButton btnPomoc = new JButton("Pomoc");
		btnPomoc.setBounds(230, 11, 100, 23);
		contentPane.add(btnPomoc);
		
		JButton btnOProgramie = new JButton("O programie");
		btnOProgramie.setBounds(339, 11, 110, 23);
		contentPane.add(btnOProgramie);
		
		JButton btnZmieHaso = new JButton("Zmie\u0144 has\u0142o");
		btnZmieHaso.setBounds(456, 11, 110, 23);
		contentPane.add(btnZmieHaso);
		
		JButton btnUsuKonto = new JButton("Usu\u0144 konto");
		btnUsuKonto.setBounds(578, 11, 110, 23);
		contentPane.add(btnUsuKonto);
		
		JPanel box = new JPanel();
		box.setToolTipText("");
		box.setBounds(699, 11, 171, 50);
		contentPane.add(box);
		box.setBorder(BorderFactory.createTitledBorder("Stan u¿ytkownika"));
		
		JLabel lblStan = new JLabel("//Stan");
		box.add(lblStan);
		
		JLabel lblOd = new JLabel("Od:");
		lblOd.setBounds(21, 415, 29, 14);
		contentPane.add(lblOd);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(45, 412, 85, 20);
		contentPane.add(comboBox);
		
		JLabel lblDo = new JLabel("Do:");
		lblDo.setBounds(140, 415, 22, 14);
		contentPane.add(lblDo);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(167, 412, 85, 20);
		contentPane.add(comboBox_1);
		
		JButton btnWyliczBilans = new JButton("Wylicz bilans");
		btnWyliczBilans.setBounds(290, 411, 110, 23);
		contentPane.add(btnWyliczBilans);
		
		JLabel lblBilans = new JLabel("BILANS:");
		lblBilans.setForeground(Color.BLACK);
		lblBilans.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBilans.setBounds(429, 395, 75, 56);
		contentPane.add(lblBilans);
		
		JLabel lblKasa = new JLabel("New label");
		lblKasa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKasa.setForeground(Color.RED);
		lblKasa.setBounds(504, 395, 85, 56);
		contentPane.add(lblKasa);
	}
}
