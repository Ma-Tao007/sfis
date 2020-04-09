package com.jwillim.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil
{
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat datetimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * ��Date�����ʽ��Ϊ�����ַ�����ʱ�䣩
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date)
	{
		if(date == null)
			return null;
		return dateFormatter.format(date);
	}
	
	/**
	 * ��Date�����ʽ��Ϊ����ʱ���ַ�
	 * @param date
	 * @return
	 */
	public static String formatDateTime(Date date)
	{
		if(date == null)
			return null;
		return datetimeFormatter.format(date);
	}
	
	/**
	 * �������ַ�����ʱ�䣩 ת��ΪDate����
	 * @param str
	 * @return
	 * @throws ParseException 
	 */
	public static Date parseDateString(String str) throws ParseException
	{
		if(str == null)
			return null;
		return dateFormatter.parse(str);
	}
	
	/**
	 * ������ʱ���ַ� ת��ΪDate����
	 * @param str
	 * @return
	 * @throws ParseException 
	 */
	public static Date parseDateTimeString(String str) throws ParseException
	{
		if(str == null)
			return null;
		return datetimeFormatter.parse(str);
	}
}
