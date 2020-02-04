package com.gx.core.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;

public class StringUtils {
	protected StringUtils() {
	}

	public static boolean isEmpty(String text) {
		return org.apache.commons.lang3.StringUtils.isEmpty(text);
	}

	public static boolean isBlank(String text) {
		return org.apache.commons.lang3.StringUtils.isBlank(text);
	}

	public static boolean isNotBlank(String text) {
		return org.apache.commons.lang3.StringUtils.isNotBlank(text);
	}

	public static String capitalize(String text) {
		return org.apache.commons.lang3.StringUtils.capitalize(text);
	}

	public static String substring(String text, int offset, int limit) {
		return org.apache.commons.lang3.StringUtils.substring(text, offset,
				limit);
	}

	public static String substringBefore(String text, String token) {
		return org.apache.commons.lang3.StringUtils
				.substringBefore(text, token);
	}

	public static String substringAfter(String text, String token) {
		return org.apache.commons.lang3.StringUtils.substringAfter(text, token);
	}

	public static String[] splitByWholeSeparator(String text, String separator) {
		return org.apache.commons.lang3.StringUtils.splitByWholeSeparator(text,
				separator);
	}

	public static String join(List list, String separator) {
		return org.apache.commons.lang3.StringUtils.join(list, separator);
	}

	public static String escapeHtml(String text) {
		return StringEscapeUtils.escapeHtml4(text);
	}

	public static String unescapeHtml(String text) {
		return StringEscapeUtils.unescapeHtml4(text);
	}

	public static String escapeXml(String text) {
		return StringEscapeUtils.escapeXml11(text);
	}

	public static String unescapeXml(String text) {
		return StringEscapeUtils.unescapeXml(text);
	}

	public static String trim(String text) {
		if (text == null) {
			return null;
		}

		text = text.replace("" + ((char) 160), " ");

		text = org.apache.commons.lang3.StringUtils.trim(text);
		text = org.apache.commons.lang3.StringUtils.strip(text, "　");

		return text;
	}

	/**
	 * 如果字符串为空或者长度为0，设置默认值为###
	 * 
	 * @param str
	 */
	public static void setDefualtStringIfNull(String str) {
		if (str == null || str.length() < 1) {
			str = "###";
		}
	}

	/**
	 * 校验字符串非空，且长度大于0
	 * 
	 * @param str
	 * @return
	 */
	public static boolean validateString(String str) {
		return (str != null && str.length() > 0);
	}

	/**
	 * 若字符串不为空，则返回字符串，否则返回空字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String getString(String str) {
		return validateString(str) ? str : "";
	}

	public static String getString(Object str) {
		return str != null && validateString(str.toString()) ? str.toString()
				: "";
	}

	/**
	 * 校验string是否为double
	 * 
	 * @param str
	 * @return
	 */
	public static boolean validateDouble(String str) {
		boolean isDouble = false;
		if (!validateString(str)) {// 长度小于0，或者为0，直接返回false
			return isDouble;
		}
		try {

			Double.valueOf(str);
			isDouble = true;
		} catch (NumberFormatException e) {

		}
		return isDouble;
	}
	public static boolean validateLong(String str) {
		boolean isDouble = false;
		if (!validateString(str)) {// 长度小于0，或者为0，直接返回false
			return isDouble;
		}
		try {
			
			Long.valueOf(str);
			isDouble = true;
		} catch (NumberFormatException e) {
			
		}
		return isDouble;
	}
	public static boolean validateLong(Object obj) {
		boolean isLong = false;
		if (obj == null) {
			return isLong;
		}
		String str = obj.toString();
		if (!validateString(str)) {// 长度小于0，或者为0，直接返回false
			return isLong;
		}
		try {

			Long.valueOf(str);
			isLong = true;
		} catch (NumberFormatException e) {

		}
		return isLong;
	}
	public static boolean validateDate(String str, String formatPattern) {
		boolean isDate = false;
		if (!validateString(str)) {// 长度小于0，或者为0，直接返回false
			return isDate;
		}
		try {

			SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
			sdf.parse(str);
			;
			isDate = true;
		} catch (ParseException e) {

		}
		return isDate;
	}

	public static boolean validateFloat(Object obj) {
		boolean isFloat = false;
		if (obj == null) {
			return isFloat;
		}
		String str = obj.toString();
		if (!validateString(str)) {// 长度小于0，或者为0，直接返回false
			return isFloat;
		}
		try {

			Float.valueOf(str);
			isFloat = true;
		} catch (NumberFormatException e) {

		}
		return isFloat;
	}

	public static boolean validateInteger(Object obj) {
		boolean isInteger = false;
		if (obj == null) {
			return isInteger;
		}
		String str = obj.toString();
		if (!validateString(str)) {// 长度小于0，或者为0，直接返回false
			return isInteger;
		}
		try {

			Integer.valueOf(str);
			isInteger = true;
		} catch (NumberFormatException e) {

		}
		return isInteger;
	}

	/**
	 * 除去某字符串中的最后一个某符号
	 * 
	 * @param str
	 * @param ch
	 * @return
	 */
	public static String getStringExceptLastChar(String str, String ch) {
		if (validateString(str) && str.endsWith(ch)) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	/**
	 * @Description:把list转换为一个用逗号分隔的字符串
	 */
	public static String listToString(List<String> list) {
		StringBuilder sb = new StringBuilder();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (i < list.size() - 1) {
					sb.append(list.get(i) + ",");
				} else {
					sb.append(list.get(i));
				}
			}
		}
		return sb.toString();
	}

	public static String listToString(List<String> list, String separator) {
		StringBuilder sb = new StringBuilder();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (i < list.size() - 1) {
					sb.append("'" + list.get(i) + "'" + separator);
				} else {
					sb.append("'" + list.get(i) + "'");
				}
			}
		}
		return sb.toString();
	}

	public static String UTF_8ToGBK(String str) {
		try {
			return new String(str.getBytes("UTF-8"), "GBK");
		} catch (Exception ex) {
			return null;
		}
	}

	public static String UTF8ToGBK(String str) {
		try {
			return new String(str.getBytes("UTF-16BE"), "GBK");
		} catch (Exception ex) {
			return null;
		}
	}

	public static String GBK(String str) {
		try {
			return new String(str.getBytes("GBK"), "GBK");
		} catch (Exception ex) {
			return null;
		}
	}

	public static String getStr(String str) {
		try {
			String temp_p = str;
			String temp = new String(temp_p.getBytes("ISO8859_1"), "GBK");
			//temp = sqlStrchop(temp);
			return temp;
		} catch (Exception e) {
			return null;
		}
	}
	public static Long getLong(Object str) {
		try {
			if(str !=null &&validateLong(str.toString())){
				return Long.valueOf(str.toString());
			}else{
				return 0l;
			}
			
		} catch (Exception e) {
			return null;
		}
	}
}
