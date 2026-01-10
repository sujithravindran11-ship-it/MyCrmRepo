package com.comcast.crm.generic.javautility;

import java.io.ObjectInputStream.GetField;
import java.lang.invoke.StringConcatFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber= random.nextInt(10000);
		return randomNumber;
	}

	public String getSystemDate() {
		
		Date dateobj= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String date= sdf.format(dateobj);
		return date;

	}
	
	public static String getRequiredDateYYYYMMDD(int days) {

		Date dateobj= new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        sdf.format(dateobj);
        Calendar cal = sdf.getCalendar(); // current date
        cal.add(Calendar.DAY_OF_MONTH, days);  // add days

        return sdf.format(cal.getTime());
    }

}
