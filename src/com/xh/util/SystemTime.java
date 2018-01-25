package com.xh.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ϵͳʱ��
 * 
 */
public class SystemTime {
//	private final static String s[] = { "��", "ţ", "��", "��", "��", "��", "��", "��",
//			"��", "��", "��", "��" };

	/**
	 * ��ȡϵͳʱ�䵽�� 20160607
	 * 
	 * @return
	 */
	private static StringBuffer time_to_day(Date date) {
		StringBuffer sb = new StringBuffer(TimeFormat.year_full_name(date));
		return sb.append(TimeFormat.month(date)).append(
				TimeFormat.day_two(date));
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 2016-06-07
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
	 * ��ȡϵͳʱ�䵽�� 2016/06/07
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
	 * ��ȡϵͳʱ�䵽�� 20160607
	 * 
	 * @return
	 */
	public static String time_to_day() {
		Date date = new Date();
		return time_to_day(date).toString();
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 2016-06-07
	 * 
	 * @return
	 */
	public static String time_to_day_one() {
		Date date = new Date();
		return time_to_day_one(date).toString();
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 2016/06/07
	 * 
	 * @return
	 */
	public static String time_to_day_two() {
		Date date = new Date();
		return time_to_day_two(date).toString();
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 20160607135436
	 * 
	 * @return
	 */
	private static StringBuffer time_to_second(Date date) {
		StringBuffer sb = time_to_day(date);
		return sb.append(TimeFormat.hour_H(date)).append(
				TimeFormat.minute(date)).append(TimeFormat.second(date));
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 2016-06-07 13:54:36
	 * 
	 * @return
	 */
	private static StringBuffer time_to_second_one(Date date) {
		return time_to_day_one(date).append(" ").append(
				TimeFormat.hour_minute_second(date));
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 2016/06/07 13:54:36
	 * 
	 * @return
	 */
	private static StringBuffer time_to_second_two(Date date) {
		return time_to_day_two(date).append(" ").append(
				TimeFormat.hour_minute_second(date));
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 20160607 13:54:36
	 * 
	 * @return
	 */
	private static StringBuffer time_to_second_three(Date date) {
		return time_to_day(date).append(" ").append(
				TimeFormat.hour_minute_second(date));
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 20160607135436
	 * 
	 * @return
	 */
	public static String time_to_second() {
		Date date = new Date();
		return time_to_second(date).toString();
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 2016-06-07 13:54:36
	 * 
	 * @return
	 */
	public static String time_to_second_one() {
		Date date = new Date();
		return time_to_second_one(date).toString();
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 2016/06/07 13:54:36
	 * 
	 * @return
	 */
	public static String time_to_second_two() {
		Date date = new Date();
		return time_to_second_two(date).toString();
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 20160607 13:54:36
	 * 
	 * @return
	 */
	public static String time_to_second_three() {
		Date date = new Date();
		return time_to_second_three(date).toString();
	}

	/**
	 * ��ȡϵͳʱ�䵽����
	 * 
	 * @param date
	 * @return
	 */
	private static StringBuffer time_to_mill(Date date) {
		return time_to_second(date).append(TimeFormat.mill(date));
	}

	/**
	 * ��ȡϵͳʱ�䵽��
	 * 
	 * @return
	 */
	public static String time_to_mill() {
		Date date = new Date();
		return time_to_mill(date).toString();
	}

	/**
	 * ��ȡϵͳʱ�䵽΢��
	 * 
	 * @return
	 */
	public static String time_to_subtle() {
		Date date = new Date();
		return time_to_mill(date).append(TimeFormat.subtle(date)).toString();
	}

	/**
	 * ��ʱ��ת��Ϊ����
	 * 
	 * @param month
	 *            ��
	 * @param day
	 *            ��
	 * @return
	 */
	public static String time_to_constellation(int month, int day) {
		if ((month == 3 && day >= 21) || (month == 4 && day <= 19))
			return "������";
		if ((month == 4 && day >= 20) || (month == 5 && day <= 20))
			return "��ţ��";
		if ((month == 5 && day >= 21) || (month == 6 && day <= 21))
			return "˫����";
		if ((month == 6 && day >= 22) || (month == 7 && day <= 22))
			return "��з��";
		if ((month == 7 && day >= 23) || (month == 8 && day <= 22))
			return "ʨ����";
		if ((month == 8 && day >= 23) || (month == 9 && day <= 22))
			return "��Ů��";
		if ((month == 9 && day >= 23) || (month == 10 && day <= 23))
			return "�����";
		if ((month == 10 && day >= 24) || (month == 11 && day <= 22))
			return "��Ы��";
		if ((month == 11 && day >= 23) || (month == 12 && day <= 21))
			return "������";
		if ((month == 12 && day >= 22) || (month == 1 && day <= 19))
			return "Ħ����";
		if ((month == 1 && day >= 20) || (month == 2 && day <= 18))
			return "ˮƿ��";
		return "˫����";
	}

	/**
	 * 
	 * @param year
	 *            �ж�����
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
	 *            ���ĳ��ĳ�µ�����
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
	 * ��ʱ��ת��Ϊʱ��� ʱ���ʽΪ yyyy-MM-dd HH:mm:ss
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
	 * ��ʱ��ת��Ϊʱ��� ʱ���ʽΪ yyyy��MM��dd�� HH:mm:ss
	 * 
	 * @param time
	 * @return
	 */
	public static long time_to_mill2(String time) {
		long mill = 0l;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy��MM��dd�� HH:mm:ss");
			Date date = simpleDateFormat.parse(time);
			mill = date.getTime();
		} catch (Exception e) {
			// TODO: handle exception

		}
		return mill;
	}

	/**
	 * ��ʱ��ת��Ϊʱ��� ʱ���ʽΪ yyyy/MM/dd hh:mm:ss
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
	 * �Ƚ�����ʱ��Ĵ�С ��ʽ 2016-03-06 �� 2016-03-06 09:51:40
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
	 * ʱ������ ��ʽ2016-03-06 �� 2016-03-06 09:51:40
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
	 * ת��Ϊ��Ф
	 * 
	 * @param year
	 * @return
	 */
	public static String chinese_zodiac(int year) {

		String[] shengxiaos = { "��", "ţ", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��" };
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
	 * ʱ���ת��Ϊʱ��
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
	 * ʱ��ת��Ϊʱ���
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
	 * ��ʱ��ƽ�ƶ��ٺ���
	 * 
	 * @param date
	 *            ��ƽ�Ƶ�ʱ��
	 * @param mill
	 * 
	 * @return
	 */
	public static Date date_translation_mill(Date date, long mill) {
		return mill_to_date(date_to_mill(date) + mill);
	}

	/**
	 * ��ʱ��ƽ�ƶ�����
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date date_translation_day(Date date, int day) {
		return date_translation_mill(date, day * 24l * 60 * 60 * 1000);
	}

	/**
	 * ��ʱ��ƽ�ƶ���Сʱ
	 * 
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date date_translation_hour(Date date, int hour) {
		return date_translation_mill(date, hour * 60l * 60 * 1000);
	}

	/**
	 * ��ʱ��ƽ�ƶ��ٷ���
	 * 
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date date_translation_minute(Date date, int minute) {
		return date_translation_mill(date, minute * 60l * 1000);
	}

	/**
	 * ��ʱ��ƽ�ƶ�����
	 * 
	 * @param date
	 * @param second
	 * @return
	 */
	public static Date date_translation_second(Date date, int second) {
		return date_translation_mill(date, second * 1000l);
	}

	/**
	 * ��ʱ��ƽ��
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
	// ����ʱ����23ʱ��01ʱ��ҹ�룬������ҹ����ҹ��ʮ��ʱ���ĵ�һ��ʱ������
	//
	// ����ʱ����01ʱ��03ʱ�������������ļ���ʮ��ʱ���ĵڶ���ʱ����ţ
	//
	// ����ʱ����03ʱ��05ʱ��ƽ�����ֳ��������糿��ʱ��ҹ���յĽ���֮�� ��
	//
	// ��îʱ����05ʱ��07ʱ���ճ����������������գ�ָ̫����¶����������ʱ�䡣 ��
	//
	// ����ʱ����07ʱ��09ʱ��ʳʱ��������ʳ��Ҳ�ǳ��緹ʱ�䣬 ��
	//
	// ����ʱ����09ʱ��11ʱ�����У�������خ�ȣ��ٽ������ʱ���Ϊ���С� ��
	//
	// ����ʱ����11ʱ��13ʱ�����У���������������� ��
	//
	// ��δʱ����13ʱ��15ʱ�� �Օi�������յ�������ȣ�̫��ƫ��Ϊ�յ�����
	//
	// ����ʱ����15ʳ��17ʱ�� ��ʱ���������̡�Ϧʳ�� ��
	//
	// ����ʱ����17����19ʱ�� ���룬�������䡢������Ϊ̫����ɽ��ʱ�� ��
	//
	// ����ʱ����19ʱ��21ʱ�� �ƻ裬������Ϧ����ĺ������ȣ���ʱ̫���Ѿ���ɽ���콫��δ�ڡ���ػ�ƣ��������ʣ��ʳƻƻ衣 ��
	//
	// ����ʱ����21ʱ��23ʱ���˶�����������ȣ���ʱҹɫ�������Ҳ�Ѿ�ֹͣ�����Ъ˯���ˡ��˶�Ҳ�����˾��� ��
	/**
	 * ʱ��ת��Ϊ��Ф �������Сʱ
	 * 
	 * @param time
	 * @return
	 */
	public static String time2Zodiac(int time) {
		if (time >= 23 || time < 1)
			return "��ʱ";
		if (time >= 1 || time < 3)
			return "��ʱ";
		if (time >= 3 || time < 5)
			return "��ʱ";
		if (time >= 5 || time < 7)
			return "îʱ";
		if (time >= 7 || time < 9)
			return "��ʱ";
		if (time >= 9 || time < 11)
			return "��ʱ";
		if (time >= 11 || time < 13)
			return "��ʱ";
		if (time >= 13 || time < 15)
			return "δʱ";
		if (time >= 15 || time < 17)
			return "��ʱ";
		if (time >= 17 || time < 19)
			return "��ʱ";
		if (time >= 19 || time < 21)
			return "��ʱ";
		return "��ʱ";
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
