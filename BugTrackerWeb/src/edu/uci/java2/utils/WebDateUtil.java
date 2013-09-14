package edu.uci.java2.utils;

import java.util.Date;

public class WebDateUtil {
	
	private final static String DIVIDER = "-";

	//Static access only 
	private WebDateUtil() { }

	@SuppressWarnings("deprecation")
	public static String formatForWebpageDisplay(Date date){
		if (date == null)
			return "";
		
		int year = date.getYear() + 1900;
		int day = date.getDate();
		int month = date.getMonth() + 1;
		
		StringBuilder sb = new StringBuilder();
		sb.append(convertWithLeadingZero(month));
		sb.append(DIVIDER);
		sb.append(convertWithLeadingZero(day));
		sb.append(DIVIDER);
		sb.append(year);
		
		return sb.toString();
	}
	
	private static String convertWithLeadingZero(int input){
		return (input < 10) ? "0" + String.valueOf(input): String.valueOf(input); 
	}
	
	@SuppressWarnings("deprecation")
	public static Date dateFromWebpage(String dateString){
		String[] dateParts = dateString.split(DIVIDER);
		int[] dateInts = new int[3];
		
		for(int i = 0; i < dateParts.length; i++)
			dateInts[i] = Integer.parseInt(dateParts[i]);

		return new Date(dateInts[2] - 1900, dateInts[0] - 1, dateInts[1]);
	}
	
}
