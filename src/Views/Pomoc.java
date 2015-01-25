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
		
		JLabel lblNewLabel_1 = new JLabel("<html>Na pocz¹tku U¿ytkownik wybiera opcjê „rejestracja”. Nastêpnie system wyœwietla okno z formularzem z polami do wype³nienia: login, has³o, powtórz has³o, mail oraz typ konta - stanowisko. Dodatkowo pojawiaj¹ siê dwa przyciski „rejestruj” oraz „anuluj” – w razie chêci przerwania procesu rejestracji. Kolejno U¿ytkownik wybiera opcje „rejestruj”, a system wyœwietla komunikat o pomyœlnej rejestracji u¿ytkownika jeœli wszystkie wymagania odnoœnie formatu danych zosta³y spe³nione. Finalnie serwer zapisuje dane u¿ytkownika w bazie danych, a U¿ytkownik zostaje automatycznie zalogowany do systemu</html>");
		lblNewLabel_1.setBounds(10, 36, 723, 76);
		panel.add(lblNewLabel_1);
		
	//	JScrollPane scroll = new JScrollPane(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Jak usun¹æ konto?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 120, 245, 17);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html>U¿ytkownik wybiera opcjê „usuñ konto”. Nastêpnie system wyœwietla zapytanie o potwierdzenie usuniêcia konta z opcjami „tak” i „nie” - zamykaj¹c¹ okno wylogowania. Kolejnym krokiem U¿ytkownika jest wybranie opcji „tak”. Ostatecznie system wylogowuje u¿ytkownika , a serwer usuwa konto u¿ytkownika z bazy danych.</html>");
		lblNewLabel_3.setBounds(10, 136, 723, 61);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Jak zresetowaæ has³o?");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 205, 232, 17);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("<html>Pierwszym krokiem U¿ytkownika jest wybranie opcji „logowanie”. Nastêpnie system wyœwietla formularz z polami login, has³o i mail oraz opcjê „logowanie”, „resetuj has³o” oraz „anuluj” przerywaj¹c¹ proces logowania. Kolejno U¿ytkownik wprowadza login oraz adres mail w odpowiednie pole formularza oraz wybiera opcjê „resetuj has³o”. Finalnie system wyœwietla komunikat o pomyœlnym zresetowaniu has³a dla podanego loginu, a serwer resetuje has³o dla podanego loginu, generuje nowe has³o oraz wysy³a je na maila.</html>");
		lblNewLabel_5.setBounds(10, 230, 723, 75);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Jak zmieniæ has³o?");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 313, 232, 17);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("<html>Na pocz¹tku U¿ytkownik wybiera opcjê „zmieñ has³o”. Nastêpnie system wyœwietla okno z formularzem z polami  stare has³o, nowe has³o i powtórz has³o oraz opcjami „zmieñ has³o” oraz „anuluj” przerywaj¹c¹ proces zmiany has³a. Kolejno U¿ytkownik uzupe³nia dane oraz wybiera opcjê „zmieñ has³o”, a finalnie serwer weryfikuje has³a i zapisuje je w bazie danych.</html>");
		lblNewLabel_7.setBounds(10, 338, 723, 42);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Jak siê zalogowaæ/wylogowaæ?");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(10, 392, 321, 18);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("<html>U¿ytkownik wybiera opcjê „logowanie”. Nastêpnie system wyœwietla formularz z polami login, has³o i mail oraz opcjê „logowanie”, „resetuj has³o” oraz „anuluj” przerywaj¹c¹ proces logowania. Kolejno U¿ytkownik wprowadza login oraz has³o w odpowiednie pole formularza oraz wybiera opcjê „zaloguj”. Ostatecznie system wyœwietla komunikat o pomyœlnym zalogowaniu u¿ytkownika, natomiast serwer weryfikuje dane u¿ytkownika i loguje go do aplikacji.</html>");
		lblNewLabel_9.setBounds(10, 417, 723, 61);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Jak siê zalogowaæ/wylogowaæ?");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(10, 489, 321, 18);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("<html>Pierwszym krokiem U¿ytkownika jest wybranie opcji „wylogowanie”. Kolejno system wyœwietla zapytanie o potwierdzenie wylogowania z opcjami „tak” i „nie” - zamykaj¹c¹ okno wylogowania. Nastêpnie U¿ytkownik wybiera opcjê „tak”, a system wylogowuje u¿ytkownika.</html>");
		lblNewLabel_11.setBounds(10, 514, 723, 47);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Jak sprawdziæ informacje o produkcie?");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12.setBounds(10, 572, 391, 17);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("<html>Na pocz¹tku U¿ytkownik wybiera opcjê „o programie”. Nastêpnie system wyœwietla logo aplikacji oraz informacje na temat m.in. nazwy projektu i autorów oraz danych kontaktowych.</html>");
		lblNewLabel_13.setBounds(10, 597, 723, 42);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Jak sprawdziæ bilans ofert?");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_14.setBounds(10, 643, 424, 17);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("<html>Pierwszym krokiem U¿ytkownika jest wybranie opcji „bilans finansowy ofert”. Kolejno system wyœwietla zak³adkê z tabel¹ zawieraj¹c¹ dane ofert, ich koszt oraz cenê z ostatniego miesi¹ca wraz z bilansem dla tych ofert oraz pola „od” i „do” ograniczaj¹ce wyœwietlane oferty po wybraniu opcji „wylicz bilans”. Nastêpnie U¿ytkownik definiuje zakres wyœwietlanych ofert w polach „od” i „do” oraz wybiera opcjê „wylicz bilans”, a system ostatecznie zwraca listê ofert z podanego terminu wraz z obliczonym dla nich bilansem finansowym. U¿ytkownik uzyskuje mo¿liwoœæ sortowania wyœwietlanej listy wed³ug swoich upodobañ.</html>");
		lblNewLabel_15.setBounds(10, 668, 723, 69);
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Jak dodawaæ nowe oferty?");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_16.setBounds(10, 748, 294, 18);
		panel.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("<html>U¿ytkownik wybiera opcjê „nadzorowanie ofertami”. Kolejno system wyœwietla zak³adkê z tabel¹ zawieraj¹c¹ dane ofert wraz z trzema opcjami „dodaj now¹ ofertê”, „zmieñ zaznaczon¹ ofertê”, „usuñ zaznaczon¹ ofertê”. Nastêpnie U¿ytkownik wybiera opcjê „dodaj now¹ ofertê”, a system otwiera nowe okno z formularzem zawieraj¹cym pola na zdjêcie oferty, kraj, miasto, nazwê hotelu, termin, pokój, liczbê osób, cenê i koszt oraz opcjê „dodaj”. Ostatecznie U¿ytkownik uzupe³nia podane pola, a nastêpnie wybiera opcjê „dodaj”. Finalnie system wyœwietla komunikat o poprawnym dodaniu oferty, natomiast serwer odœwie¿a listê ofert w aplikacji desktopowej oraz webowej.</html>");
		lblNewLabel_17.setBounds(10, 773, 723, 92);
		panel.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Jak przegl¹daæ listê rezerwacji?");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_18.setBounds(10, 876, 294, 17);
		panel.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("<html>U¿ytkownik wybiera opcjê „panel zarz¹dzania rezerwacjami”. Nastêpnie system wyœwietla zak³adkê z tabel¹ zawieraj¹c¹ dane rezerwacji wraz z czterema opcjami „zaakceptuj rezerwacje”, „zmieñ rezerwacje”, „rezerwacja op³acona” oraz „usuñ rezerwacjê”. Finalnie U¿ytkownik uzyskuje mo¿liwoœæ sortowania wyœwietlanej listy wed³ug swoich upodobañ.</html>");
		lblNewLabel_19.setBounds(10, 901, 723, 61);
		panel.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Jak akceptowaæ rezerwacje?");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_20.setBounds(10, 973, 260, 17);
		panel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("<html>U¿ytkownik wybiera opcjê „panel zarz¹dzania rezerwacjami”. Nastêpnie system wyœwietla zak³adkê z tabel¹ zawieraj¹c¹ dane rezerwacji wraz z czterema opcjami „zaakceptuj rezerwacje”, „zmieñ rezerwacje”, „rezerwacja op³acona” oraz „usuñ rezerwacjê”. Kolejno U¿ytkownik sortuje wyœwietlan¹ listê wed³ug swoich upodobañ, , wybiera jedn¹ z rezerwacji oraz wybiera opcjê „zaakceptuj rezerwacje”. Finalnie system wyœwietla komunikat o poprawnej zmianie statusu rezerwacji na zaakceptowan¹, natomiast serwer odœwie¿a listê rezerwacji w aplikacji desktopowej oraz wysy³a wiadomoœæ mailow¹ </html>");
		lblNewLabel_21.setBounds(10, 996, 723, 118);
		
		panel.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22= new JLabel("Jak potwierdzaæ op³acenie rezerwacji?");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_22.setBounds(10, 1120, 290, 17);
		panel.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("<html>Pierwszym krokiem U¿ytkownika jest wybranie opcji „panel zarz¹dzania rezerwacjami”. Kolejno system wyœwietla zak³adkê z tabel¹ zawieraj¹c¹ dane rezerwacji wraz z czterema opcjami „zaakceptuj rezerwacje”, „zmieñ rezerwacje”, „rezerwacja op³acona” oraz „usuñ rezerwacjê”. Nastêpnie U¿ytkownik sortuje wyœwietlan¹ listê wed³ug swoich upodobañ, , wybiera jedn¹ z rezerwacji oraz wybiera opcjê „rezerwacja op³acona”. Ostatecznie system wyœwietla komunikat o poprawnej zmianie statusu rezerwacji na op³acony, natomiast serwer odœwie¿a listê rezerwacji w aplikacji desktopowej oraz wysy³a wiadomoœæ mailow¹ do klienta na jego skrzynkê pocztow¹ o potwierdzeniu op³acenia rezerwacji.</html>");
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
