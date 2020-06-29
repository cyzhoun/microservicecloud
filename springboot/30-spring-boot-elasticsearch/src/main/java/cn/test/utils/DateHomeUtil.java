package cn.test.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Date 和 String类型的转换工具类
 * @author issuser
 *
 */
public class DateHomeUtil {
	
	private static DateHomeUtil dateHomeUtil;
	public static DateHomeUtil getInstance() {
		if (dateHomeUtil == null) {
			dateHomeUtil = new DateHomeUtil();
		}
		return dateHomeUtil;
	}

	public static Locale DEFAULT_LOCALE = Locale.CHINESE;

	
	/**
	 * 功能:java.util.Date类型转换为字符串类型
	 * 格式 : yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String dateToStr(Date date) {
		return DateHomeUtil.dateToStr(date, "yyyy-MM-dd");
	}

	/**
	 * 功能:java.util.Date类型转换为字符串类型
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToStr(Date date, String format) {
		try {
			if (date == null) {
				return "";
			}
			if (format == null || format.length() <= 0) {
				format = "yyyy-MM-dd";
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 功能:字符串类型转换为java.util.Date类型
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date strToDate(String strDate) throws ParseException {
		return DateHomeUtil.strToDate(strDate, "yyyy-MM-dd");
	}

	/**
	 * 功能:字符串类型转换为java.util.Date类型
	 * @param strDate
	 * @param format
	 * @return
	 */
	public static Date strToDate(String strDate, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format, DEFAULT_LOCALE);
			sdf.setLenient(true);
			return sdf.parse(strDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 转换为想要的日期类型
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date dateToDate(Date date, String format) {
		try {
			if (date == null) {
				return null;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format, DEFAULT_LOCALE);
			String str = sdf.format(date);
			str = str.substring(0, str.indexOf("-"));
			if (str.length() >= 8) {
				str = str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6);
			} else {
				return date;
			}
			return sdf.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
