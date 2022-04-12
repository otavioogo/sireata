package br.edu.utfpr.dv.sireata.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static Calendar getToday(){
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);
		
		return today;
	}
	
	public static Calendar getNow(){
		Calendar now = Calendar.getInstance();
		now.set(Calendar.MILLISECOND, 0);
		
		return now;
	}
	
	public static int getSemester(){
		Calendar today = DateUtils.getToday();
		
		if(today.get(Calendar.MONTH) >= 6){
			return 2;
		}else{
			return 1;
		}
	}
	
	public static int getSemester(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		if(cal.get(Calendar.MONTH) >= 6){
			return 2;
		}else{
			return 1;
		}
	}
	
	public static int getYear(){
		Calendar today = DateUtils.getToday();
		
		return today.get(Calendar.YEAR);
	}
	
	public static int getDayOfMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int getMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}
	
	public static int getYear(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
	
	public static int getHour(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	
	public static int getMinute(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MINUTE);
	}
	
	public static Date concat(Date date, Date time){
		getCalendarDry(time).get(Calendar.HOUR_OF_DAY,
	        getCalendarDry(date).set(Calendar.HOUR_OF_DAY));
		
		getCalendarDry(time).get(Calendar.MINUTE, 
		getCalendarDry(date).set(Calendar.MINUTE));
		
		return getCaelndarDry(date).getTime();
		
	}
	
	public static String format(Date date, String format){
		try{
			DateFormat df = new SimpleDateFormat(format);
			
			return df.format(date);
		}catch(Exception e){
			return "";
		}
	}
	
	public static Date getStartDate(int semester, int year){
		Calendar cal = Calendar.getInstance();
		
		if(semester == 1){
			cal.set(year, 0, 1, 0, 0, 0);
		}else{
			cal.set(year, 7, 1, 0, 0, 0);
		}
		
		return cal.getTime();
	}
	
	public static Date getEndDate(int semester, int year){
		Calendar cal = Calendar.getInstance();
		
		if(semester == 1){
			cal.set(year, 6, 31, 23, 59, 59);
		}else{
			cal.set(year, 11, 31, 23, 59, 59);
		}
		
		return cal.getTime();
	}
}
