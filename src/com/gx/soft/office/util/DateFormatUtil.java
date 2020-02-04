package com.gx.soft.office.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class DateFormatUtil {
	public static final String DATASIMPLEFOMAT="yyyy-MM-dd";
	public static final String DATAFOMAT="yyyy-MM-dd HH:mm:ss";
	public static final String DATAHHMMFOMAT="yyyy-MM-dd hh:mm";
	public static final String DATA24H="yyyy-MM-dd hh:mm:ss";
	public static Date convertDate(String adateStrteStr,String format){ 
		java.util.Date date = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format); 
			date = (Date)simpleDateFormat.parse(adateStrteStr);
		} catch (ParseException e) {
		}
		return date; 
	}
	
	public static Date convertDate1(String adateStrteStr,String format) throws ParseException { 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format); 
		Date date = (Date)simpleDateFormat.parseObject(adateStrteStr);
		return date; 
	}
	public static String convertUtilDateToString(java.util.Date date,String format)
	{
		 if(date!=null){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format); 
			return simpleDateFormat.format(date);
		 }else
		 {
			 return "";
		}
		
	}
	
	public static Date convertDate(String adateStrteStr) { 
		 String format="yyyy-MM-dd HH:mm:ss";
		java.util.Date date = null; 
		try { 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format); 
		date = simpleDateFormat.parse(adateStrteStr); 
		} catch (Exception ex) { 
		
		} 
		return date; 
		}
	
	public static Date convertDateFormat(String adateStrteStr,String format) { 
	
		java.util.Date date = null; 
		try { 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format); 
		date = simpleDateFormat.parse(adateStrteStr); 
		} catch (Exception ex) { 
		
		} 
		return date; 
		}
	
	public static String convertUtilDateToString(java.util.Date date)
	{
		 String format="yyyy-MM-dd HH:mm:ss";
		 if(date!=null){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format); 
			return simpleDateFormat.format(date);
		 }else
		 {
			 return "";
		}
		
	}
	
	public static String convertUtilDateToStringShow(java.util.Date date)
	{
		 String format="yyyy-MM-dd ";
		 if(date!=null){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format); 
			return simpleDateFormat.format(date);
		 }else
		 {
			 return "";
		}
		
	}
	
	public static String covertSqlDateToString(java.sql.Date date)
	{
		 if(date!=null){
		 String format="yyyy-MM-dd HH:mm:ss";
	     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format); 
		 return simpleDateFormat.format(date);
		 }else
		 {
			 return "";
		}
		
	}
	
	public static java.util.Date convertSqlToUtil(java.sql.Date date)
	{ 
		if(date==null)
		{
			return null;
		}
		
		return new java.util.Date(date.getTime());
	}
	public static java.sql.Date convertUtilToSql(java.util.Date date)
	{
		return new java.sql.Date(date.getTime());
	}
    
	//����ʱ���1��
	public static Date DayAddOne(Date date)
	{
        Date   newDate2   =   new   Date(date.getTime()   +   1000   *   60   *   60   *   24);   
        System.out.println(newDate2);

			 return null;

		
	}
	public static Timestamp converStringToTimeStamp(String str){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp t1 = null;
		try {
			Date date = sf.parse(str);
			System.out.println(date);
			 t1 = new Timestamp(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return t1;
	}

}
