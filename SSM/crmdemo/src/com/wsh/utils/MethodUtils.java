package com.wsh.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MethodUtils {
	
	public static String getTime() {
		Date date = new Date();
		String strDateFormat = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		return sdf.format(date);
	}
}
