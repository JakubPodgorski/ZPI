package Utils;

public class Constants {

	
	public static String SELECT_EARNINGS = "SELECT s1.CENAZMARZA - s1.CENA, s1.ILOSCOSOBWPOKOJU, s1.ID, s1.CENA From OPCJAOFERTY s1 WHERE s1.TERMINOD >= ? AND s1.TERMINDO <= ? ";
	public static String SELECT_EARNINGS_WITH_RESERVATION = "SELECT s1.CENAZMARZA - s1.CENA, s1.ILOSCOSOBWPOKOJU, s1.ID, s1.CENA From OPCJAOFERTY s1, REZERWACJA s2 WHERE s1.ID=s2.FK_OPCJAOFERTY AND s1.TERMINOD >= ? AND s1.TERMINDO <= ? AND s1.ID=?";
	
  	public static String SELECT_OFFERS_TIMESTAMP =  "SELECT * FROM OPCJAOFERTY s1, OPISOFERTY s2 WHERE s1.FK_OPISOFERTY = s2.ID AND s1.TERMINOD >= ? AND s1.TERMINDO <= ?";
  	
  	
    public static String SELECT_RESERVATIONS = "select R.ID, R.IMIE, R.NAZWISKO, R.KRAJ, R.MIASTO, R.ULICA, R.NUMERDOMU, R.KODPOCZTOWY, R.MAIL, R.TELEFON, R.STATUS, OPCJA.TERMINOD, OPCJA.TERMINDO, OPCJA.CENA, OPCJA.CENAZMARZA, OPCJA.ILOSCOSOBWPOKOJU, OPIS.NUMEROFERTY, OPIS.MIASTO AS OFERTA_MIASTO, OPIS.KRAJ AS OFERTA_KRAJ FROM REZERWACJA R INNER JOIN OPCJAOFERTY OPCJA ON R.FK_OPCJAOFERTY = OPCJA.ID INNER JOIN OPISOFERTY OPIS ON OPCJA.FK_OPISOFERTY = OPIS.ID";
    public static String SELECT_ALL_OFFERS = "SELECT s1.TYTUL, s1.OPIS, s1.KRAJ, s1.MIASTO, s1.OCENA, s1.NUMEROFERTY, s2.* FROM OPISOFERTY s1, OPCJAOFERTY s2 WHERE s1.ID = s2.FK_OPISOFERTY";
  	public static String SELECT_OFFERS_DESCRIPTION = "SELECT ID, TYTUL FROM OPISOFERTY";
    
    
  	public static String DB_DATE_FROM = "TERMINOD";
  	public static String DB_DATE_TO = "TERMINDO";
  	public static String DB_COST = "CENA";
  	public static String DB_FINAL_PRICE = "CENAZMARZA";
  	public static String DB_CITY = "MIASTO";
  	public static String DB_COUNTRY = "KRAJ";
  	public static String DB_OFFER_ID = "NUMEROFERTY";
  	public static String DB_DESCRIPTION = "OPIS";
  	public static String DB_TITLE = "TYTUL";
  	public static String DB_PHOTO = "ZDJECIE";
  	public static String DB_MARK = "OCENA";
  	public static String DB_ID = "ID";
  	public static String DB_PERSON_COUNT = "ILOSCOSOBWPOKOJU";

	
	public final static String columnNamesBilans[] = { "Numer oferty", "Termin", "Miasto", "Koszt w\u0142asny", "Cena", "Zarezerwowano", "Zysk" };
	public final static String columnNamesOffers[] = { "Numer oferty", "Tytu\u0142", "Opis", "Kraj", "Miasto", "Wolne miejsca", "Cena za miejsce", "Ocena" };

	public final static String kolumnyRezerwacje[] = { "Numer rezerwacji", "Dane oferty", "Imi\u0119 i nazwisko", "Adres", "E-mail", "Telefon", "Status" };

	
}
