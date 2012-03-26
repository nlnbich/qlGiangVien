package cit.group10.qlGiangvien.others;

import java.text.DateFormat;
import java.util.Date;

public class ValidateData {

	static public String returnDate(Object value) {

//		System.out.println(value.toString()) ;
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
		// Object value = event.getProperty().getValue();

//		if (value == null || !(value instanceof Date)) {
//			return "";
//		} else {
			String dateOut = dateFormatter.format(value);
			return dateOut;
			// Show notification
			// getWindow().showNotification("Starting date: " + dateOut);
//		}

	}//end of returnDate

}
