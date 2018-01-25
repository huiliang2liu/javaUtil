package com.xh.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.xh.encryption.MD5;


/**
 * ���ø�ʽ��
 * 
 */
public class CommonFormat {
	/**
	 * ��ȡɢ����
	 * 
	 * @param object
	 * @return
	 */
	public static String hash_code(Object object) {
		return String.format("%h", object);
	}

	/**
	 * ��ʽ��Ϊʮ����
	 * 
	 * @param object
	 * @return
	 */
	public static String decimalism(Object object) {
		return String.format("%d", object);
	}

	/**
	 * ��ʽ��Ϊ�˽���
	 * 
	 * @param object
	 * @return
	 */
	public static String octal(Object object) {
		return String.format("%o", object);
	}

	/**
	 * ��ʽ��Ϊʮ������
	 * 
	 * @param object
	 * @return
	 */
	public static String hexadecimal(Object object) {
		return String.format("%X", object);
	}

	/**
	 * ת��Ϊ��ѧ������
	 * 
	 * @param object
	 * @return
	 */
	public static String e(Object object) {
		return String.format("%e", object);
	}

	/**
	 * ���ַ���ʽ��Ϊ�ض��ĸ�ʽ
	 * 
	 * @param format
	 *            ��ʽ *********
	 * @param string
	 *            ����ʽ��������
	 * @return
	 */
	public static String format(String format, Object object) {
		StringBuffer sb = new StringBuffer();
		String string = object.toString();
		int len = format.length() - string.length();
		if (len > 0) {
			sb.append(format.substring(0, len));
		}
		if (len < 0) {
			string = string.substring(0, format.length());
		}
		return sb.append(string).toString();
	}

	/**
	 * �������͸�ʽ�� ������0�
	 * 
	 * @param integer
	 *            ����λ
	 * @param decimal
	 *            С��λ
	 * @param format
	 *            ��ʽ������
	 * @return
	 */
	public static String format_double(int integer, int decimal, double format) {
		return format_double(integer, decimal, format, "0");
	}

	/**
	 * �������͸�ʽ��
	 * 
	 * @param integer
	 *            ����λ
	 * @param decimal
	 *            С��λ
	 * @param format
	 *            ��ʽ������
	 * @param fill
	 *            ��λ��
	 * @return
	 */
	public static String format_double(int integer, int decimal, double format,
			String fill) {
		String string = format + "";
		String a[] = string.split("\\.");
		String si = format_string(a[0], integer, fill);
		String sd = format_string(a.length > 1 ? a[1] : "", decimal, fill);
		return si + "." + sd;
	}

	/**
	 * �����θ�ʽ��
	 * 
	 * @param length
	 *            ����
	 * @param format
	 *            ��ʽ������
	 * @param fill
	 *            ��λ��
	 * @return
	 */
	public static String format_long(int length, long format, String fill) {
		return format_string(format + "", length, fill);
	}

	/**
	 * �����θ�ʽ�� ������0��λ
	 * 
	 * @param length
	 *            ����
	 * @param format
	 *            ��ʽ������
	 * @return
	 */
	public static String format_long(int length, long format) {
		return format_long(length, format, "0");
	}

	/**
	 * �ַ�����ʽ��
	 * 
	 * @param format
	 *            ��ʽ������
	 * @param length
	 *            ����
	 * @param fill
	 *            ��λ��
	 * @return
	 */
	public static String format_string(String format, int length, String fill) {
		int len_poor = format.length() - length;
		if (len_poor == 0)
			return format;
		if (len_poor > 0)
			return format.substring(0, length);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < -len_poor; i++) {
			sb.append(fill);
		}
		return sb.append(format).toString();
	}

	// ���������ַ�
	public static String StringFilter(String str) throws PatternSyntaxException {
		// ֻ������ĸ������
		// String regEx = "[^a-zA-Z0-9]";
		// ��������������ַ�
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~��@#��%����&*��������+|{}������������������������]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	/**
	 * ���ַ�ת��Ϊ32�ַ�
	 * 
	 * @param string
	 * @return
	 */
	public static String md5len32(String string) {
		if(string==null)
			return "11111111111111111111111111111111";
		return MD5.String2MD5Method1(string);
	}

	/**
	 * ���ַ�ת��Ϊ16Ϊ�ַ�
	 * 
	 * @param string
	 * @return
	 */
	public static String md5len16(String string) {
		if(string==null)
			return "1111111111111111";
		return MD5.String2MD5Method16(string);
	}
	public static void main(String[] args) {
		System.out.println(hexadecimal(16908311));
	}
}
