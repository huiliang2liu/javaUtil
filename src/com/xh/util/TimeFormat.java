package com.xh.util;

import java.util.Date;


public class TimeFormat {
	/**
	 * 获得时区
	 * 
	 * @param date
	 * @return
	 */
	public static String time_zone(Date date) {
		return String.format("%tZ", date);
	}

	/**
	 * 获得时区偏移量 相对GMT RFC 82
	 * 
	 * @param date
	 * @return
	 */
	public static String time_offset(Date date) {
		return String.format("%tz", date);
	}

	/**
	 * 获得下午或上午
	 * 
	 * @param date
	 * @return
	 */
	public static String am_or_pm(Date date) {
		return String.format("%tp", date);
	}

	/**
	 * 获得当前微妙数 9位
	 * 
	 * @param date
	 * @return
	 */
	public static String subtle(Date date) {
		return String.format("%tN", date);
	}

	/**
	 * 获得当前毫秒数 3位
	 * 
	 * @param date
	 * @return
	 */
	public static String mill(Date date) {
		return String.format("%tL", date);
	}

	/**
	 * 获得当前秒 2位
	 * 
	 * @param date
	 * @return
	 */
	public static String second(Date date) {
		return String.format("%tS", date);
	}

	/**
	 * 获得当前分钟 2为
	 * 
	 * @param date
	 * @return
	 */
	public static String minute(Date date) {
		return String.format("%tM", date);
	}

	/**
	 * 获得当前小时 1-12
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_l(Date date) {
		return String.format("%tl", date);
	}

	/**
	 * 获得当前小时 0-23
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_k(Date date) {
		return String.format("%tk", date);
	}

	/**
	 * 获得当前小时 01-12
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_I(Date date) {
		return String.format("%tI", date);
	}

	/**
	 * 获得当前小时 00-23
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_H(Date date) {
		return String.format("%tH", date);
	}

	/**
	 * 获得当前时间 15:25
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_minute(Date date) {
		return String.format("%tR", date);
	}

	/**
	 * 获得当前时间 15:23:50
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_minute_second(Date date) {
		return String.format("%tT", date);
	}

	/**
	 * 获得当前时间 03:22:06 下午
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_minute_second_pm_or_am(Date date) {
		return String.format("%tr", date);
	}

	/**
	 * 获取当前时间到日 03/25/08（月/日/年）
	 * 
	 * @param date
	 * @return
	 */
	public static String mdy(Date date) {
		return String.format("%tD", date);
	}

	/**
	 * 获取当前时间到日 2008-03-25 年—月—日
	 * 
	 * @param date
	 * @return
	 */
	public static String ymd(Date date) {
		return String.format("%tF", date);
	}

	/**
	 * 获得日期天 1-31
	 * 
	 * @param date
	 * @return
	 */
	public static String day_one(Date date) {
		return String.format("%te", date);
	}

	/**
	 * 获得日期天 01-31
	 * 
	 * @param date
	 * @return
	 */
	public static String day_two(Date date) {
		return String.format("%td", date);
	}

	/**
	 * 一年中的第几天 085
	 * 
	 * @param date
	 * @return
	 */
	public static String day_to_year(Date date) {
		return String.format("%tj", date);
	}

	/**
	 * 获得月份简称
	 */
	public static String month_referred(Date date) {
		return String.format("%tb", date);
	}

	/**
	 * 获得月份全称
	 * 
	 * @param date
	 * @return
	 */
	public static String month_full_name(Date date) {
		return String.format("%tB", date);
	}

	/**
	 * 获得月份 01-12
	 * 
	 * @param date
	 * @return
	 */
	public static String month(Date date) {
		return String.format("%tm", date);
	}

	/**
	 *获得星期简称
	 * 
	 * @param date
	 * @return
	 */
	public static String week_referred(Date date) {
		return String.format("%ta", date);
	}

	/**
	 * 获得星期全称
	 * 
	 * @param date
	 * @return
	 */
	public static String week_full_name(Date date) {
		return String.format("%tA", date);
	}

	/**
	 * 获得年简称 16
	 * 
	 * @param date
	 * @return
	 */
	public static String year_referred(Date date) {
		return String.format("%ty", date);
	}

	/**
	 * 获得年全称 2016
	 * 
	 * @param date
	 * @return
	 */
	public static String year_full_name(Date date) {
		return String.format("%tY", date);
	}

	/**
	 * 星期二 三月 25 13:37:22 CST 2016
	 * 
	 * @param date
	 * @return
	 */
	public static String time(Date date) {
		return String.format("%tc", date);
	}

	/**
	 * 获取时间戳到秒
	 * 
	 * @param date
	 * @return
	 */
	public static String time_to_second(Date date) {
		return String.format("%ts", date);
	}

	/**
	 * 获取时间戳到毫秒
	 * 
	 * @param date
	 * @return
	 */
	public static String time_to_mill(Date date) {
		return String.format("%tQ", date);
	}

	/**
	 * 获取时间戳到毫秒
	 * 
	 * @return
	 * 
	 */
	public static long time_to_mill() {
		return System.currentTimeMillis();
	}

}
