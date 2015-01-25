package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Parsing {

	
	 public static String dateToString(Date date)  {
	        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd", Locale.ENGLISH);
	        if (date != null) {
	            return sdf.format(date);
	        }
	        return null;
	    }

	 
	 public static String dateToStringVisualFriendly(Date date)  {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
	        if (date != null) {
	            return sdf.format(date);
	        }
	        return null;
	    }
	 
}
