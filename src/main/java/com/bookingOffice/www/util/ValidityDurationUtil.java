package com.bookingOffice.www.util;

import java.sql.Date;
import java.util.Calendar;

public class ValidityDurationUtil {
	
	private static final int validDuration = 3;
	
	public static Date toValidDate(java.sql.Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, validDuration);
		return new Date(calendar.getTimeInMillis());
	}
	
	public static Date toNormalDate(java.sql.Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -validDuration);
		return new Date(calendar.getTimeInMillis());
	}
	
	public static Date toValidDate(java.util.Date date) {
		java.sql.Date sqlDate = new Date(date.getTime());
		return toValidDate(sqlDate);
	}
	
	public static Date toNormalDate(java.util.Date date) {
		java.sql.Date sqlDate = new Date(date.getTime());
		return toNormalDate(sqlDate);
	}
}
