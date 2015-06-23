package com.bookingOffice.www.util;

import java.util.Date;
import java.util.Calendar;

public class ValidityDurationUtil {
	
	private static final int validDuration = 3;
	
	public static Date toValidDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, validDuration);
		return new Date(calendar.getTimeInMillis());
	}
	
	public static Date toNormalDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -validDuration);
		return new Date(calendar.getTimeInMillis());
	}
	
}
