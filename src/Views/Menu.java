package Views;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;




import Utils.DataBaseConnector;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
        private Logowanie logView;
        private JLabel lblStan;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
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
*/
	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Narz\u0119dzie administracyjne - Biuro podr\u00F3\u017Cy - Tw\u00F3j osobisty asystent");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 473);
		setMinimumSize(new Dimension(900,473));
		setMaximumSize(new Dimension(1500,700));
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Wyloguj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Logowanie();
			}
		});
		btnNewButton.setBounds(10, 11, 100, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rejestracja");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// rejestracja
				RejestrujUsera();
			}
		});
		btnNewButton_1.setBounds(121, 11, 100, 23);
		contentPane.add(btnNewButton_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(10, 51, 860, 383);
		contentPane.add(tabbedPane);
		
		tabbedPane.addTab("Bilans finansowy oferty", new BilansFinasowy());
		final Rezerwacje rez = new Rezerwacje();
		tabbedPane.addTab("Panel Zarz�dzania Rezerwacjami", rez);
		tabbedPane.addTab("Nadzorowanie ofertami", new OpisOferty());
		
		tabbedPane.addChangeListener( new ChangeListener(){
			public void stateChanged(ChangeEvent evt)
			{
				JTabbedPane tbPane = (JTabbedPane) evt.getSource();
				if(tbPane.getSelectedIndex() == 1)
				{
					rez.WyszukajRezerwacje();
				}
			}
			
		});
		
	//	tabbedPane.addTab("Historia Klient�w Biura", new Klienci());
		
		JButton btnPomoc = new JButton("Pomoc");
		btnPomoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help();
			}
		});
		btnPomoc.setBounds(230, 11, 100, 23);
		contentPane.add(btnPomoc);
		
		JButton btnOProgramie = new JButton("O programie");
		btnOProgramie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Informacje();
				
			}
		});
		btnOProgramie.setBounds(339, 11, 110, 23);
		contentPane.add(btnOProgramie);	
		
		JButton btnZmieHaso = new JButton("Zmie\u0144 has\u0142o");
		btnZmieHaso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZmienHaslo();
			}
		});
		btnZmieHaso.setBounds(456, 11, 110, 23);
		contentPane.add(btnZmieHaso);
		
		JButton btnUsuKonto = new JButton("Usu\u0144 konto");
		btnUsuKonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsunKonto();
			}
		});
		btnUsuKonto.setBounds(578, 11, 110, 23);
		contentPane.add(btnUsuKonto);
		
		JPanel box = new JPanel();
		box.setToolTipText("");
		box.setBounds(699, 11, 171, 50);
		contentPane.add(box);
		box.setBorder(BorderFactory.createTitledBorder("Zalogowano jako"));
		
		lblStan = new JLabel();
		lblStan.setForeground(new Color(0, 0, 204));
		lblStan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		box.add(lblStan);
	}
	
	private void RejestrujUsera()
	{
		Rejestracja register = new  Rejestracja();
		register.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		register.setVisible(true);
	}
	
	private void Logowanie()
	{		
		logView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                logView.clearLoggingData();
		logView.setVisible(true);
                this.dispose();
	}
	private void Help()
	{
		Pomoc pm = new Pomoc();
		pm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pm.setVisible(true);
	}
	private void Informacje()
	{
		Info info = new Info();
		info.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		info.setVisible(true);
	}
	// TODO
	private void ZmienHaslo(){
		//if (zalogowany){
		
		ZmianaHasla zh = new ZmianaHasla();
		zh.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		zh.setVisible(true);
		//}
		
	}
	
	private void UsunKonto()
	{
		// if(zalogowany){
		//Usun();
		
		//}
	}
        
        public void setLogView(Logowanie log) {
            this.logView = log;
        }
	
        public void setLoginAsLabel(String login) {
            lblStan.setText(login);
        }
}
