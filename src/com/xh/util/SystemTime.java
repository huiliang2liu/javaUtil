package com.xh.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 系统时间
 * 
 */
public class SystemTime {
//	private final static String s[] = { "鼠", "牛", "虎", "免", "龙", "蛇", "马", "羊",
//			"猴", "鸡", "狗", "猪" };

	/**
	 * 获取系统时间到日 20160607
	 * 
	 * @return
	 */
	private static StringBuffer time_to_day(Date date) {
		StringBuffer sb = new StringBuffer(TimeFormat.year_full_name(date));
		return sb.append(TimeFormat.month(date)).append(
				TimeFormat.day_two(date));
	}

	/**
	 * 获取系统时间到日 2016-06-07
	 * 
	 * @param date
	 * @return
	 */
	private static StringBuffer time_to_day_one(Date date) {
		StringBuffer sb = new StringBuffer(TimeFormat.year_full_name(date));
		sb.append("-").append(TimeFormat.month(date)).append("-").append(
				TimeFormat.day_two(date));
		return sb;
	}

	/**
	 * 获取系统时间到日 2016/06/07
	 * 
	 * @param date
	 * @return
	 */
	private static StringBuffer time_to_day_two(Date date) {
		StringBuffer sb = new StringBuffer(TimeFormat.year_full_name(date));
		sb.append("/").append(TimeFormat.month(date)).append("/").append(
				TimeFormat.day_two(date));
		return sb;
	}

	/**
	 * 获取系统时间到日 20160607
	 * 
	 * @return
	 */
	public static String time_to_day() {
		Date date = new Date();
		return time_to_day(date).toString();
	}

	/**
	 * 获取系统时间到日 2016-06-07
	 * 
	 * @return
	 */
	public static String time_to_day_one() {
		Date date = new Date();
		return time_to_day_one(date).toString();
	}

	/**
	 * 获取系统时间到日 2016/06/07
	 * 
	 * @return
	 */
	public static String time_to_day_two() {
		Date date = new Date();
		return time_to_day_two(date).toString();
	}

	/**
	 * 获取系统时间到秒 20160607135436
	 * 
	 * @return
	 */
	private static StringBuffer time_to_second(Date date) {
		StringBuffer sb = time_to_day(date);
		return sb.append(TimeFormat.hour_H(date)).append(
				TimeFormat.minute(date)).append(TimeFormat.second(date));
	}

	/**
	 * 获取系统时间到秒 2016-06-07 13:54:36
	 * 
	 * @return
	 */
	private static StringBuffer time_to_second_one(Date date) {
		return time_to_day_one(date).append(" ").append(
				TimeFormat.hour_minute_second(date));
	}

	/**
	 * 获取系统时间到秒 2016/06/07 13:54:36
	 * 
	 * @return
	 */
	private static StringBuffer time_to_second_two(Date date) {
		return time_to_day_two(date).append(" ").append(
				TimeFormat.hour_minute_second(date));
	}

	/**
	 * 获取系统时间到秒 20160607 13:54:36
	 * 
	 * @return
	 */
	private static StringBuffer time_to_second_three(Date date) {
		return time_to_day(date).append(" ").append(
				TimeFormat.hour_minute_second(date));
	}

	/**
	 * 获取系统时间到秒 20160607135436
	 * 
	 * @return
	 */
	public static String time_to_second() {
		Date date = new Date();
		return time_to_second(date).toString();
	}

	/**
	 * 获取系统时间到秒 2016-06-07 13:54:36
	 * 
	 * @return
	 */
	public static String time_to_second_one() {
		Date date = new Date();
		return time_to_second_one(date).toString();
	}

	/**
	 * 获取系统时间到秒 2016/06/07 13:54:36
	 * 
	 * @return
	 */
	public static String time_to_second_two() {
		Date date = new Date();
		return time_to_second_two(date).toString();
	}

	/**
	 * 获取系统时间到秒 20160607 13:54:36
	 * 
	 * @return
	 */
	public static String time_to_second_three() {
		Date date = new Date();
		return time_to_second_three(date).toString();
	}

	/**
	 * 获取系统时间到毫秒
	 * 
	 * @param date
	 * @return
	 */
	private static StringBuffer time_to_mill(Date date) {
		return time_to_second(date).append(TimeFormat.mill(date));
	}

	/**
	 * 获取系统时间到秒
	 * 
	 * @return
	 */
	public static String time_to_mill() {
		Date date = new Date();
		return time_to_mill(date).toString();
	}

	/**
	 * 获取系统时间到微妙
	 * 
	 * @return
	 */
	public static String time_to_subtle() {
		Date date = new Date();
		return time_to_mill(date).append(TimeFormat.subtle(date)).toString();
	}

	/**
	 * 将时间转化为星座
	 * 
	 * @param month
	 *            月
	 * @param day
	 *            日
	 * @return
	 */
	public static String time_to_constellation(int month, int day) {
		if ((month == 3 && day >= 21) || (month == 4 && day <= 19))
			return "白羊座";
		if ((month == 4 && day >= 20) || (month == 5 && day <= 20))
			return "金牛座";
		if ((month == 5 && day >= 21) || (month == 6 && day <= 21))
			return "双子座";
		if ((month == 6 && day >= 22) || (month == 7 && day <= 22))
			return "巨蟹座";
		if ((month == 7 && day >= 23) || (month == 8 && day <= 22))
			return "狮子座";
		if ((month == 8 && day >= 23) || (month == 9 && day <= 22))
			return "处女座";
		if ((month == 9 && day >= 23) || (month == 10 && day <= 23))
			return "天秤座";
		if ((month == 10 && day >= 24) || (month == 11 && day <= 22))
			return "天蝎座";
		if ((month == 11 && day >= 23) || (month == 12 && day <= 21))
			return "射手座";
		if ((month == 12 && day >= 22) || (month == 1 && day <= 19))
			return "摩羯座";
		if ((month == 1 && day >= 20) || (month == 2 && day <= 18))
			return "水瓶座";
		return "双鱼座";
	}

	/**
	 * 
	 * @param year
	 *            判断闰年
	 */
	public static boolean leap_year(int year) {
		if (year % 100 == 0) {
			if (year % 400 == 0)
				return true;
		} else if (year % 4 == 0)
			return true;
		return false;
	}

	/**
	 * 
	 * @param month
	 * @param year
	 *            获得某年某月的天数
	 */
	public static int month_day(int month, int year) {
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			if (leap_year(year))
				return 29;
			else
				return 28;
		}
		return 31;
	}

	/**
	 * 将时间转化为时间戳 时间格式为 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param time
	 * @return
	 */
	public static long time_to_mill1(String time) {
		long mill = 0l;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Date date = simpleDateFormat.parse(time);
			mill = date.getTime();
		} catch (Exception e) {
			// TODO: handle exception

		}
		return mill;
	}

	/**
	 * 将时间转化为时间戳 时间格式为 yyyy年MM月dd日 HH:mm:ss
	 * 
	 * @param time
	 * @return
	 */
	public static long time_to_mill2(String time) {
		long mill = 0l;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy年MM月dd日 HH:mm:ss");
			Date date = simpleDateFormat.parse(time);
			mill = date.getTime();
		} catch (Exception e) {
			// TODO: handle exception

		}
		return mill;
	}

	/**
	 * 将时间转化为时间戳 时间格式为 yyyy/MM/dd hh:mm:ss
	 * 
	 * @param time
	 * @return
	 */
	public static long time_to_mill3(String time) {
		long mill = 0l;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy/MM/dd hh:mm:ss");
			Date date = simpleDateFormat.parse(time);
			mill = date.getTime();
		} catch (Exception e) {
			// TODO: handle exception

		}
		return mill;
	}

	/**
	 * 比较两个时间的大小 格式 2016-03-06 或 2016-03-06 09:51:40
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static boolean compare(String time1, String time2) {
		long time11 = time_to_mill1(time1.split(" ").length > 1 ? time1 : time1
				+ " 00:00:00");
		long time21 = time_to_mill1(time2.split(" ").length > 1 ? time2 : time2
				+ " 00:00:00");
		return time11 > time21;
	}

	/**
	 * 时间排序 格式2016-03-06 或 2016-03-06 09:51:40
	 * 
	 * @return
	 */
	public static List<String> sort(List<String> times) {
		if (times == null)
			return times;
		for (int i = 1; i < times.size(); i++) {
			for (int j = 0; j < times.size() - i; j++) {
				String time1 = times.get(j);
				String time2 = times.get(j + 1);
				if (compare(time2, time1)) {
					times.set(j, time2);
					times.set(j + 1, time1);
				}
			}
		}
		return times;
	}

	/**
	 * 转化为生肖
	 * 
	 * @param year
	 * @return
	 */
	public static String chinese_zodiac(int year) {

		String[] shengxiaos = { "鼠", "牛", "虎", "免", "龙", "蛇", "马", "羊", "猴",
				"鸡", "狗", "猪" };
		String shengxiao;
		int m = Math.abs(year - 2008) % 12;
		if (year >= 2008) {
			shengxiao = shengxiaos[m];
		} else {
			if (m == 0) {
				m = 12;
			}
			shengxiao = shengxiaos[12 - m];
		}
		return shengxiao;
	}

	/**
	 * 时间戳转化为时间
	 * 
	 * @param mill
	 * @return
	 */
	public static Date mill_to_date(long mill) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String d = format.format(mill);
			Date date = format.parse(d);
			return date;
		} catch (Exception e) {
			// TODO: handle exception
			return new Date();
		}
	}

	/**
	 * 时间转化为时间戳
	 * 
	 * @param date
	 * @return
	 */
	public static long date_to_mill(Date date) {
		if (date == null)
			date = new Date();
		return date.getTime();
	}

	/**
	 * 将时间平移多少毫秒
	 * 
	 * @param date
	 *            被平移的时间
	 * @param mill
	 * 
	 * @return
	 */
	public static Date date_translation_mill(Date date, long mill) {
		return mill_to_date(date_to_mill(date) + mill);
	}

	/**
	 * 将时间平移多少天
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date date_translation_day(Date date, int day) {
		return date_translation_mill(date, day * 24l * 60 * 60 * 1000);
	}

	/**
	 * 将时间平移多少小时
	 * 
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date date_translation_hour(Date date, int hour) {
		return date_translation_mill(date, hour * 60l * 60 * 1000);
	}

	/**
	 * 将时间平移多少分钟
	 * 
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date date_translation_minute(Date date, int minute) {
		return date_translation_mill(date, minute * 60l * 1000);
	}

	/**
	 * 将时间平移多少秒
	 * 
	 * @param date
	 * @param second
	 * @return
	 */
	public static Date date_translation_second(Date date, int second) {
		return date_translation_mill(date, second * 1000l);
	}

	/**
	 * 将时间平移
	 * 
	 * @param date
	 * @param day
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	public static Date date_translation(Date date, int day, int hour,
			int minute, int second) {
		return date_translation_mill(date, day * 24l * 60 * 60 * 1000 + hour
				* 60l * 60 * 1000 + minute * 60l * 1000 + second * 1000l);
	}
	// 【子时】（23时至01时）夜半，又名子夜、中夜：十二时辰的第一个时辰．鼠
	//
	// 【丑时】（01时至03时）鸡鸣，又名荒鸡：十二时辰的第二个时辰。牛
	//
	// 【寅时】（03时至05时）平旦，又称黎明、早晨、时是夜与日的交替之际 虎
	//
	// 【卯时】（05时至07时）日出，又名破晓、旭日，指太阳刚露脸，初升的时间。 兔
	//
	// 【辰时】（07时至09时）食时，又名早食，也是吃早饭时间， 龙
	//
	// 【巳时】（09时至11时）隅中，又名日禺等：临近中午的时候称为隅中。 蛇
	//
	// 【午时】（11时至13时）日中，又名日正、中午等 马
	//
	// 【未时】（13时至15时） 日昳，又名日跌、日央等：太阳偏西为日跌。羊
	//
	// 【申时】（15食至17时） 哺时，又名日铺、夕食等 猴
	//
	// 【酉时】（17是至19时） 日入，又名日落、傍晚：意为太阳落山的时候。 鸡
	//
	// 【戌时】（19时至21时） 黄昏，又名日夕、日暮、日晚等：此时太阳已经落山，天将黑未黑。天地昏黄，万物朦胧，故称黄昏。 狗
	//
	// 【亥时】（21时至23时）人定，又名定昏等：此时夜色已深，人们也已经停止活动，安歇睡眠了。人定也就是人静。 猪
	/**
	 * 时间转换为生肖 输入的是小时
	 * 
	 * @param time
	 * @return
	 */
	public static String time2Zodiac(int time) {
		if (time >= 23 || time < 1)
			return "子时";
		if (time >= 1 || time < 3)
			return "丑时";
		if (time >= 3 || time < 5)
			return "寅时";
		if (time >= 5 || time < 7)
			return "卯时";
		if (time >= 7 || time < 9)
			return "辰时";
		if (time >= 9 || time < 11)
			return "巳时";
		if (time >= 11 || time < 13)
			return "午时";
		if (time >= 13 || time < 15)
			return "未时";
		if (time >= 15 || time < 17)
			return "申时";
		if (time >= 17 || time < 19)
			return "酉时";
		if (time >= 19 || time < 21)
			return "戌时";
		return "亥时";
	}
	public static void main(String[] args) {
		System.out.println(time_to_second_one());
		try  
		{  
			Date date=new Date();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");  
		    String dateString = String.format("%tY", date)+"-"+String.format("%tm", date)+"-01 ";  
		    date = sdf.parse(dateString);
		    String first_day=String.format("%tA", date);
		    System.out.println(first_day);
		}  
		catch (Exception e)  
		{  
		    System.out.println(e.getMessage());  
		}
	}
}
