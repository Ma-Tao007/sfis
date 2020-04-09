package com.util;

/**
 * ���ǹ��� HTML �����ŵ���
 * @author Well
 *
 */

public class HTMLUtil
{
	/**
	 * ���˷���
	 * @param str
	 * @return
	 */
	public static String parseHTML(String str)
	{
		if(str == null)
			return null;
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll(" ", "&nbsp;");
		str = str.replaceAll("\r\n", "<br/>");
		
		return str;
	}
}
