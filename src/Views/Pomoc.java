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
		
		JLabel lblNewLabel_1 = new JLabel("<html>Na pocz�tku U�ytkownik wybiera opcj� �rejestracja�. Nast�pnie system wy�wietla okno z formularzem z polami do wype�nienia: login, has�o, powt�rz has�o, mail oraz typ konta - stanowisko. Dodatkowo pojawiaj� si� dwa przyciski �rejestruj� oraz �anuluj� � w razie ch�ci przerwania procesu rejestracji. Kolejno U�ytkownik wybiera opcje �rejestruj�, a system wy�wietla komunikat o pomy�lnej rejestracji u�ytkownika je�li wszystkie wymagania odno�nie formatu danych zosta�y spe�nione. Finalnie serwer zapisuje dane u�ytkownika w bazie danych, a U�ytkownik zostaje automatycznie zalogowany do systemu</html>");
		lblNewLabel_1.setBounds(10, 36, 723, 76);
		panel.add(lblNewLabel_1);
		
	//	JScrollPane scroll = new JScrollPane(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Jak usun�� konto?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 120, 245, 17);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html>U�ytkownik wybiera opcj� �usu� konto�. Nast�pnie system wy�wietla zapytanie o potwierdzenie usuni�cia konta z opcjami �tak� i �nie� - zamykaj�c� okno wylogowania. Kolejnym krokiem U�ytkownika jest wybranie opcji �tak�. Ostatecznie system wylogowuje u�ytkownika , a serwer usuwa konto u�ytkownika z bazy danych.</html>");
		lblNewLabel_3.setBounds(10, 136, 723, 61);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Jak zresetowa� has�o?");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 205, 232, 17);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("<html>Pierwszym krokiem U�ytkownika jest wybranie opcji �logowanie�. Nast�pnie system wy�wietla formularz z polami login, has�o i mail oraz opcj� �logowanie�, �resetuj has�o� oraz �anuluj� przerywaj�c� proces logowania. Kolejno U�ytkownik wprowadza login oraz adres mail w odpowiednie pole formularza oraz wybiera opcj� �resetuj has�o�. Finalnie system wy�wietla komunikat o pomy�lnym zresetowaniu has�a dla podanego loginu, a serwer resetuje has�o dla podanego loginu, generuje nowe has�o oraz wysy�a je na maila.</html>");
		lblNewLabel_5.setBounds(10, 230, 723, 75);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Jak zmieni� has�o?");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 313, 232, 17);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("<html>Na pocz�tku U�ytkownik wybiera opcj� �zmie� has�o�. Nast�pnie system wy�wietla okno z formularzem z polami  stare has�o, nowe has�o i powt�rz has�o oraz opcjami �zmie� has�o� oraz �anuluj� przerywaj�c� proces zmiany has�a. Kolejno U�ytkownik uzupe�nia dane oraz wybiera opcj� �zmie� has�o�, a finalnie serwer weryfikuje has�a i zapisuje je w bazie danych.</html>");
		lblNewLabel_7.setBounds(10, 338, 723, 42);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Jak si� zalogowa�/wylogowa�?");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(10, 392, 321, 18);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("<html>U�ytkownik wybiera opcj� �logowanie�. Nast�pnie system wy�wietla formularz z polami login, has�o i mail oraz opcj� �logowanie�, �resetuj has�o� oraz �anuluj� przerywaj�c� proces logowania. Kolejno U�ytkownik wprowadza login oraz has�o w odpowiednie pole formularza oraz wybiera opcj� �zaloguj�. Ostatecznie system wy�wietla komunikat o pomy�lnym zalogowaniu u�ytkownika, natomiast serwer weryfikuje dane u�ytkownika i loguje go do aplikacji.</html>");
		lblNewLabel_9.setBounds(10, 417, 723, 61);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Jak si� zalogowa�/wylogowa�?");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(10, 489, 321, 18);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("<html>Pierwszym krokiem U�ytkownika jest wybranie opcji �wylogowanie�. Kolejno system wy�wietla zapytanie o potwierdzenie wylogowania z opcjami �tak� i �nie� - zamykaj�c� okno wylogowania. Nast�pnie U�ytkownik wybiera opcj� �tak�, a system wylogowuje u�ytkownika.</html>");
		lblNewLabel_11.setBounds(10, 514, 723, 47);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Jak sprawdzi� informacje o produkcie?");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12.setBounds(10, 572, 391, 17);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("<html>Na pocz�tku U�ytkownik wybiera opcj� �o programie�. Nast�pnie system wy�wietla logo aplikacji oraz informacje na temat m.in. nazwy projektu i autor�w oraz danych kontaktowych.</html>");
		lblNewLabel_13.setBounds(10, 597, 723, 42);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Jak sprawdzi� bilans ofert?");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_14.setBounds(10, 643, 424, 17);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("<html>Pierwszym krokiem U�ytkownika jest wybranie opcji �bilans finansowy ofert�. Kolejno system wy�wietla zak�adk� z tabel� zawieraj�c� dane ofert, ich koszt oraz cen� z ostatniego miesi�ca wraz z bilansem dla tych ofert oraz pola �od� i �do� ograniczaj�ce wy�wietlane oferty po wybraniu opcji �wylicz bilans�. Nast�pnie U�ytkownik definiuje zakres wy�wietlanych ofert w polach �od� i �do� oraz wybiera opcj� �wylicz bilans�, a system ostatecznie zwraca list� ofert z podanego terminu wraz z obliczonym dla nich bilansem finansowym. U�ytkownik uzyskuje mo�liwo�� sortowania wy�wietlanej listy wed�ug swoich upodoba�.</html>");
		lblNewLabel_15.setBounds(10, 668, 723, 69);
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Jak dodawa� nowe oferty?");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_16.setBounds(10, 748, 294, 18);
		panel.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("<html>U�ytkownik wybiera opcj� �nadzorowanie ofertami�. Kolejno system wy�wietla zak�adk� z tabel� zawieraj�c� dane ofert wraz z trzema opcjami �dodaj now� ofert�, �zmie� zaznaczon� ofert�, �usu� zaznaczon� ofert�. Nast�pnie U�ytkownik wybiera opcj� �dodaj now� ofert�, a system otwiera nowe okno z formularzem zawieraj�cym pola na zdj�cie oferty, kraj, miasto, nazw� hotelu, termin, pok�j, liczb� os�b, cen� i koszt oraz opcj� �dodaj�. Ostatecznie U�ytkownik uzupe�nia podane pola, a nast�pnie wybiera opcj� �dodaj�. Finalnie system wy�wietla komunikat o poprawnym dodaniu oferty, natomiast serwer od�wie�a list� ofert w aplikacji desktopowej oraz webowej.</html>");
		lblNewLabel_17.setBounds(10, 773, 723, 92);
		panel.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Jak przegl�da� list� rezerwacji?");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_18.setBounds(10, 876, 294, 17);
		panel.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("<html>U�ytkownik wybiera opcj� �panel zarz�dzania rezerwacjami�. Nast�pnie system wy�wietla zak�adk� z tabel� zawieraj�c� dane rezerwacji wraz z czterema opcjami �zaakceptuj rezerwacje�, �zmie� rezerwacje�, �rezerwacja op�acona� oraz �usu� rezerwacj�. Finalnie U�ytkownik uzyskuje mo�liwo�� sortowania wy�wietlanej listy wed�ug swoich upodoba�.</html>");
		lblNewLabel_19.setBounds(10, 901, 723, 61);
		panel.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Jak akceptowa� rezerwacje?");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_20.setBounds(10, 973, 260, 17);
		panel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("<html>U�ytkownik wybiera opcj� �panel zarz�dzania rezerwacjami�. Nast�pnie system wy�wietla zak�adk� z tabel� zawieraj�c� dane rezerwacji wraz z czterema opcjami �zaakceptuj rezerwacje�, �zmie� rezerwacje�, �rezerwacja op�acona� oraz �usu� rezerwacj�. Kolejno U�ytkownik sortuje wy�wietlan� list� wed�ug swoich upodoba�, , wybiera jedn� z rezerwacji oraz wybiera opcj� �zaakceptuj rezerwacje�. Finalnie system wy�wietla komunikat o poprawnej zmianie statusu rezerwacji na zaakceptowan�, natomiast serwer od�wie�a list� rezerwacji w aplikacji desktopowej oraz wysy�a wiadomo�� mailow� </html>");
		lblNewLabel_21.setBounds(10, 996, 723, 118);
		
		panel.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22= new JLabel("Jak potwierdza� op�acenie rezerwacji?");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_22.setBounds(10, 1120, 290, 17);
		panel.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("<html>Pierwszym krokiem U�ytkownika jest wybranie opcji �panel zarz�dzania rezerwacjami�. Kolejno system wy�wietla zak�adk� z tabel� zawieraj�c� dane rezerwacji wraz z czterema opcjami �zaakceptuj rezerwacje�, �zmie� rezerwacje�, �rezerwacja op�acona� oraz �usu� rezerwacj�. Nast�pnie U�ytkownik sortuje wy�wietlan� list� wed�ug swoich upodoba�, , wybiera jedn� z rezerwacji oraz wybiera opcj� �rezerwacja op�acona�. Ostatecznie system wy�wietla komunikat o poprawnej zmianie statusu rezerwacji na op�acony, natomiast serwer od�wie�a list� rezerwacji w aplikacji desktopowej oraz wysy�a wiadomo�� mailow� do klienta na jego skrzynk� pocztow� o potwierdzeniu op�acenia rezerwacji.</html>");
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
