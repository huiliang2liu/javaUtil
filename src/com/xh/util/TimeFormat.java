package com.xh.util;

import java.util.Date;


public class TimeFormat {
	/**
	 * ���ʱ��
	 * 
	 * @param date
	 * @return
	 */
	public static String time_zone(Date date) {
		return String.format("%tZ", date);
	}

	/**
	 * ���ʱ��ƫ���� ���GMT RFC 82
	 * 
	 * @param date
	 * @return
	 */
	public static String time_offset(Date date) {
		return String.format("%tz", date);
	}

	/**
	 * ������������
	 * 
	 * @param date
	 * @return
	 */
	public static String am_or_pm(Date date) {
		return String.format("%tp", date);
	}

	/**
	 * ��õ�ǰ΢���� 9λ
	 * 
	 * @param date
	 * @return
	 */
	public static String subtle(Date date) {
		return String.format("%tN", date);
	}

	/**
	 * ��õ�ǰ������ 3λ
	 * 
	 * @param date
	 * @return
	 */
	public static String mill(Date date) {
		return String.format("%tL", date);
	}

	/**
	 * ��õ�ǰ�� 2λ
	 * 
	 * @param date
	 * @return
	 */
	public static String second(Date date) {
		return String.format("%tS", date);
	}

	/**
	 * ��õ�ǰ���� 2Ϊ
	 * 
	 * @param date
	 * @return
	 */
	public static String minute(Date date) {
		return String.format("%tM", date);
	}

	/**
	 * ��õ�ǰСʱ 1-12
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_l(Date date) {
		return String.format("%tl", date);
	}

	/**
	 * ��õ�ǰСʱ 0-23
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_k(Date date) {
		return String.format("%tk", date);
	}

	/**
	 * ��õ�ǰСʱ 01-12
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_I(Date date) {
		return String.format("%tI", date);
	}

	/**
	 * ��õ�ǰСʱ 00-23
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_H(Date date) {
		return String.format("%tH", date);
	}

	/**
	 * ��õ�ǰʱ�� 15:25
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_minute(Date date) {
		return String.format("%tR", date);
	}

	/**
	 * ��õ�ǰʱ�� 15:23:50
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_minute_second(Date date) {
		return String.format("%tT", date);
	}

	/**
	 * ��õ�ǰʱ�� 03:22:06 ����
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_minute_second_pm_or_am(Date date) {
		return String.format("%tr", date);
	}

	/**
	 * ��ȡ��ǰʱ�䵽�� 03/25/08����/��/�꣩
	 * 
	 * @param date
	 * @return
	 */
	public static String mdy(Date date) {
		return String.format("%tD", date);
	}

	/**
	 * ��ȡ��ǰʱ�䵽�� 2008-03-25 �ꡪ�¡���
	 * 
	 * @param date
	 * @return
	 */
	public static String ymd(Date date) {
		return String.format("%tF", date);
	}

	/**
	 * ��������� 1-31
	 * 
	 * @param date
	 * @return
	 */
	public static String day_one(Date date) {
		return String.format("%te", date);
	}

	/**
	 * ��������� 01-31
	 * 
	 * @param date
	 * @return
	 */
	public static String day_two(Date date) {
		return String.format("%td", date);
	}

	/**
	 * һ���еĵڼ��� 085
	 * 
	 * @param date
	 * @return
	 */
	public static String day_to_year(Date date) {
		return String.format("%tj", date);
	}

	/**
	 * ����·ݼ��
	 */
	public static String month_referred(Date date) {
		return String.format("%tb", date);
	}

	/**
	 * ����·�ȫ��
	 * 
	 * @param date
	 * @return
	 */
	public static String month_full_name(Date date) {
		return String.format("%tB", date);
	}

	/**
	 * ����·� 01-12
	 * 
	 * @param date
	 * @return
	 */
	public static String month(Date date) {
		return String.format("%tm", date);
	}

	/**
	 *������ڼ��
	 * 
	 * @param date
	 * @return
	 */
	public static String week_referred(Date date) {
		return String.format("%ta", date);
	}

	/**
	 * �������ȫ��
	 * 
	 * @param date
	 * @return
	 */
	public static String week_full_name(Date date) {
		return String.format("%tA", date);
	}

	/**
	 * ������� 16
	 * 
	 * @param date
	 * @return
	 */
	public static String year_referred(Date date) {
		return String.format("%ty", date);
	}

	/**
	 * �����ȫ�� 2016
	 * 
	 * @param date
	 * @return
	 */
	public static String year_full_name(Date date) {
		return String.format("%tY", date);
	}

	/**
	 * ���ڶ� ���� 25 13:37:22 CST 2016
	 * 
	 * @param date
	 * @return
	 */
	public static String time(Date date) {
		return String.format("%tc", date);
	}

	/**
	 * ��ȡʱ�������
	 * 
	 * @param date
	 * @return
	 */
	public static String time_to_second(Date date) {
		return String.format("%ts", date);
	}

	/**
	 * ��ȡʱ���������
	 * 
	 * @param date
	 * @return
	 */
	public static String time_to_mill(Date date) {
		return String.format("%tQ", date);
	}

	/**
	 * ��ȡʱ���������
	 * 
	 * @return
	 * 
	 */
	public static long time_to_mill() {
		return System.currentTimeMillis();
	}

}
