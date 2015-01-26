package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;

public class Pomoc extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pomoc frame = new Pomoc();
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
	public Pomoc() {
		setTitle("Pomoc");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 859, 915);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		panel.setPreferredSize(new Dimension( 760, 1300));
	//	contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Jak za\u0142o\u017Cy\u0107 konto?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 232, 17);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Na pocz\u0105tku U\u017Cytkownik wybiera opcj\u0119 „rejestracja”. Nast\u0119pnie system wy\u015Bwietla okno z formularzem z polami do wype\u0142nienia: login, has\u0142o, powt\u00F3rz has\u0142o, mail oraz typ konta - stanowisko. Dodatkowo pojawiaj\u0105 si\u0119 dwa przyciski „rejestruj” oraz „anuluj” – w razie ch\u0119ci przerwania procesu rejestracji. Kolejno U\u017Cytkownik wybiera opcje „rejestruj”, a system wy\u015Bwietla komunikat o pomy\u015Blnej rejestracji u\u017Cytkownika je\u015Bli wszystkie wymagania odno\u015Bnie formatu danych zosta\u0142y spe\u0142nione. Finalnie serwer zapisuje dane u\u017Cytkownika w bazie danych, a U\u017Cytkownik zostaje automatycznie zalogowany do systemu</html>");
		lblNewLabel_1.setBounds(10, 36, 723, 76);
		panel.add(lblNewLabel_1);
		
	//	JScrollPane scroll = new JScrollPane(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Jak usun\u0105\u0107 konto?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 120, 245, 17);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html>U\u017Cytkownik wybiera opcj\u0119 „usu\u0144 konto”. Nast\u0119pnie system wy\u015Bwietla zapytanie o potwierdzenie usuni\u0119cia konta z opcjami „tak” i „nie” - zamykaj\u0105c\u0105 okno wylogowania. Kolejnym krokiem U\u017Cytkownika jest wybranie opcji „tak”. Ostatecznie system wylogowuje u\u017Cytkownika , a serwer usuwa konto u\u017Cytkownika z bazy danych.</html>");
		lblNewLabel_3.setBounds(10, 136, 723, 61);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Jak zresetowa\u0107 has\u0142o?");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 205, 232, 17);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("<html>Pierwszym krokiem U\u017Cytkownika jest wybranie opcji „logowanie”. Nast\u0119pnie system wy\u015Bwietla formularz z polami login, has\u0142o i mail oraz opcj\u0119 „logowanie”, „resetuj has\u0142o” oraz „anuluj” przerywaj\u0105c\u0105 proces logowania. Kolejno U\u017Cytkownik wprowadza login oraz adres mail w odpowiednie pole formularza oraz wybiera opcj\u0119 „resetuj has\u0142o”. Finalnie system wy\u015Bwietla komunikat o pomy\u015Blnym zresetowaniu has\u0142a dla podanego loginu, a serwer resetuje has\u0142o dla podanego loginu, generuje nowe has\u0142o oraz wysy\u0142a je na maila.</html>");
		lblNewLabel_5.setBounds(10, 230, 723, 75);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Jak zmieni\u0107 has\u0142o?");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 313, 232, 17);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("<html>Na pocz\u0105tku U\u017Cytkownik wybiera opcj\u0119 „zmie\u0144 has\u0142o”. Nast\u0119pnie system wy\u015Bwietla okno z formularzem z polami  stare has\u0142o, nowe has\u0142o i powt\u00F3rz has\u0142o oraz opcjami „zmie\u0144 has\u0142o” oraz „anuluj” przerywaj\u0105c\u0105 proces zmiany has\u0142a. Kolejno U\u017Cytkownik uzupe\u0142nia dane oraz wybiera opcj\u0119 „zmie\u0144 has\u0142o”, a finalnie serwer weryfikuje has\u0142a i zapisuje je w bazie danych.</html>");
		lblNewLabel_7.setBounds(10, 338, 723, 42);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Jak si\u0119 zalogowa\u0107/wylogowa\u0107?");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(10, 392, 321, 18);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("<html>U\u017Cytkownik wybiera opcj\u0119 „logowanie”. Nast\u0119pnie system wy\u015Bwietla formularz z polami login, has\u0142o i mail oraz opcj\u0119 „logowanie”, „resetuj has\u0142o” oraz „anuluj” przerywaj\u0105c\u0105 proces logowania. Kolejno U\u017Cytkownik wprowadza login oraz has\u0142o w odpowiednie pole formularza oraz wybiera opcj\u0119 „zaloguj”. Ostatecznie system wy\u015Bwietla komunikat o pomy\u015Blnym zalogowaniu u\u017Cytkownika, natomiast serwer weryfikuje dane u\u017Cytkownika i loguje go do aplikacji.</html>");
		lblNewLabel_9.setBounds(10, 417, 723, 61);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Jak si\u0119 zalogowa\u0107/wylogowa\u0107?");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(10, 489, 321, 18);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("<html>Pierwszym krokiem U\u017Cytkownika jest wybranie opcji „wylogowanie”. Kolejno system wy\u015Bwietla zapytanie o potwierdzenie wylogowania z opcjami „tak” i „nie” - zamykaj\u0105c\u0105 okno wylogowania. Nast\u0119pnie U\u017Cytkownik wybiera opcj\u0119 „tak”, a system wylogowuje u\u017Cytkownika.</html>");
		lblNewLabel_11.setBounds(10, 514, 723, 47);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Jak sprawdzi\u0107 informacje o produkcie?");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12.setBounds(10, 572, 391, 17);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("<html>Na pocz\u0105tku U\u017Cytkownik wybiera opcj\u0119 „o programie”. Nast\u0119pnie system wy\u015Bwietla logo aplikacji oraz informacje na temat m.in. nazwy projektu i autor\u00F3w oraz danych kontaktowych.</html>");
		lblNewLabel_13.setBounds(10, 597, 723, 42);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Jak sprawdzi\u0107 bilans ofert?");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_14.setBounds(10, 643, 424, 17);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("<html>Pierwszym krokiem U\u017Cytkownika jest wybranie opcji „bilans finansowy ofert”. Kolejno system wy\u015Bwietla zak\u0142adk\u0119 z tabel\u0105 zawieraj\u0105c\u0105 dane ofert, ich koszt oraz cen\u0119 z ostatniego miesi\u0105ca wraz z bilansem dla tych ofert oraz pola „od” i „do” ograniczaj\u0105ce wy\u015Bwietlane oferty po wybraniu opcji „wylicz bilans”. Nast\u0119pnie U\u017Cytkownik definiuje zakres wy\u015Bwietlanych ofert w polach „od” i „do” oraz wybiera opcj\u0119 „wylicz bilans”, a system ostatecznie zwraca list\u0119 ofert z podanego terminu wraz z obliczonym dla nich bilansem finansowym. U\u017Cytkownik uzyskuje mo\u017Cliwo\u015B\u0107 sortowania wy\u015Bwietlanej listy wed\u0142ug swoich upodoba\u0144.</html>");
		lblNewLabel_15.setBounds(10, 668, 723, 69);
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Jak dodawa\u0107 nowe oferty?");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_16.setBounds(10, 748, 294, 18);
		panel.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("<html>U\u017Cytkownik wybiera opcj\u0119 „nadzorowanie ofertami”. Kolejno system wy\u015Bwietla zak\u0142adk\u0119 z tabel\u0105 zawieraj\u0105c\u0105 dane ofert wraz z trzema opcjami „dodaj now\u0105 ofert\u0119”, „zmie\u0144 zaznaczon\u0105 ofert\u0119”, „usu\u0144 zaznaczon\u0105 ofert\u0119”. Nast\u0119pnie U\u017Cytkownik wybiera opcj\u0119 „dodaj now\u0105 ofert\u0119”, a system otwiera nowe okno z formularzem zawieraj\u0105cym pola na zdj\u0119cie oferty, kraj, miasto, nazw\u0119 hotelu, termin, pok\u00F3j, liczb\u0119 os\u00F3b, cen\u0119 i koszt oraz opcj\u0119 „dodaj”. Ostatecznie U\u017Cytkownik uzupe\u0142nia podane pola, a nast\u0119pnie wybiera opcj\u0119 „dodaj”. Finalnie system wy\u015Bwietla komunikat o poprawnym dodaniu oferty, natomiast serwer od\u015Bwie\u017Ca list\u0119 ofert w aplikacji desktopowej oraz webowej.</html>");
		lblNewLabel_17.setBounds(10, 773, 723, 92);
		panel.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Jak przegl\u0105da\u0107 list\u0119 rezerwacji?");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_18.setBounds(10, 876, 294, 17);
		panel.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("<html>U\u017Cytkownik wybiera opcj\u0119 „panel zarz\u0105dzania rezerwacjami”. Nast\u0119pnie system wy\u015Bwietla zak\u0142adk\u0119 z tabel\u0105 zawieraj\u0105c\u0105 dane rezerwacji wraz z czterema opcjami „zaakceptuj rezerwacje”, „zmie\u0144 rezerwacje”, „rezerwacja op\u0142acona” oraz „usu\u0144 rezerwacj\u0119”. Finalnie U\u017Cytkownik uzyskuje mo\u017Cliwo\u015B\u0107 sortowania wy\u015Bwietlanej listy wed\u0142ug swoich upodoba\u0144.</html>");
		lblNewLabel_19.setBounds(10, 901, 723, 61);
		panel.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Jak akceptowa\u0107 rezerwacje?");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_20.setBounds(10, 973, 260, 17);
		panel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("<html>U\u017Cytkownik wybiera opcj\u0119 „panel zarz\u0105dzania rezerwacjami”. Nast\u0119pnie system wy\u015Bwietla zak\u0142adk\u0119 z tabel\u0105 zawieraj\u0105c\u0105 dane rezerwacji wraz z czterema opcjami „zaakceptuj rezerwacje”, „zmie\u0144 rezerwacje”, „rezerwacja op\u0142acona” oraz „usu\u0144 rezerwacj\u0119”. Kolejno U\u017Cytkownik sortuje wy\u015Bwietlan\u0105 list\u0119 wed\u0142ug swoich upodoba\u0144, , wybiera jedn\u0105 z rezerwacji oraz wybiera opcj\u0119 „zaakceptuj rezerwacje”. Finalnie system wy\u015Bwietla komunikat o poprawnej zmianie statusu rezerwacji na zaakceptowan\u0105, natomiast serwer od\u015Bwie\u017Ca list\u0119 rezerwacji w aplikacji desktopowej oraz wysy\u0142a wiadomo\u015B\u0107 mailow\u0105 </html>");
		lblNewLabel_21.setBounds(10, 996, 723, 118);
		
		panel.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22= new JLabel("Jak potwierdza\u0107 op\u0142acenie rezerwacji?");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_22.setBounds(10, 1120, 290, 17);
		panel.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("<html>Pierwszym krokiem U\u017Cytkownika jest wybranie opcji „panel zarz\u0105dzania rezerwacjami”. Kolejno system wy\u015Bwietla zak\u0142adk\u0119 z tabel\u0105 zawieraj\u0105c\u0105 dane rezerwacji wraz z czterema opcjami „zaakceptuj rezerwacje”, „zmie\u0144 rezerwacje”, „rezerwacja op\u0142acona” oraz „usu\u0144 rezerwacj\u0119”. Nast\u0119pnie U\u017Cytkownik sortuje wy\u015Bwietlan\u0105 list\u0119 wed\u0142ug swoich upodoba\u0144, , wybiera jedn\u0105 z rezerwacji oraz wybiera opcj\u0119 „rezerwacja op\u0142acona”. Ostatecznie system wy\u015Bwietla komunikat o poprawnej zmianie statusu rezerwacji na op\u0142acony, natomiast serwer od\u015Bwie\u017Ca list\u0119 rezerwacji w aplikacji desktopowej oraz wysy\u0142a wiadomo\u015B\u0107 mailow\u0105 do klienta na jego skrzynk\u0119 pocztow\u0105 o potwierdzeniu op\u0142acenia rezerwacji.</html>");
		lblNewLabel_23.setBounds(10, 1143, 723, 118);
		
		panel.add(lblNewLabel_23);
		
		
		/*
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(10, 11, 823, 940);
		*/
		
		JScrollPane scrollPaneCreating = new JScrollPane(panel,
			        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
			        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			    scrollPaneCreating.setMinimumSize(new Dimension(160, 200));
			    scrollPaneCreating.setPreferredSize(new Dimension(160, 200));
		
			    scrollPaneCreating.setBounds(10, 11, 760, 600);
		getContentPane().add(scrollPaneCreating);
		
	}
}
