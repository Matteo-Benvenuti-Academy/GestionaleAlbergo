package com.gestionaleAlberghi.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCurrentDate {
	public static String getCurrentDateString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date(System.currentTimeMillis());
		return formatter.format(date);
		
	}
}
