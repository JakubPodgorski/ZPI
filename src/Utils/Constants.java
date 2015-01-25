package Utils;

public class Constants {

	
	public static String SELECT_EARNINGS = "SELECT CENAZMARZA - CENA From OPCJAOFERTY WHERE TERMINOD >= ? AND TERMINDO <= ?";
  	public static String SELECT_OFFERS =  "SELECT * FROM OPCJAOFERTY s1, OPISOFERTY s2 WHERE s1.FK_OPISOFERTY = s2.ID AND s1.TERMINOD >= ? AND s1.TERMINDO <= ?";
  	
  	
  	public static String DB_DATE_FROM = "TERMINOD";
  	public static String DB_DATE_TO = "TERMINDO";
  	public static String DB_COST = "CENA";
  	public static String DB_FINAL_PRICE = "CENAZMARZA";
  	public static String DB_CITY = "MIASTO";
  	public static String DB_OFFER_ID = "NUMEROFERTY";

	
	public final static String columnNames[] = { "Numer oferty", "Termin", "Miasto", "Koszt w³asny", "Cena", "Zarezerwowano" };

	
}
