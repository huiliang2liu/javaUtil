package com.xh.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.xh.encryption.MD5;


/**
 * 常用格式化
 * 
 */
public class CommonFormat {
	/**
	 * 获取散列码
	 * 
	 * @param object
	 * @return
	 */
	public static String hash_code(Object object) {
		return String.format("%h", object);
	}

	/**
	 * 格式化为十进制
	 * 
	 * @param object
	 * @return
	 */
	public static String decimalism(Object object) {
		return String.format("%d", object);
	}

	/**
	 * 格式化为八进制
	 * 
	 * @param object
	 * @return
	 */
	public static String octal(Object object) {
		return String.format("%o", object);
	}

	/**
	 * 格式化为十六进制
	 * 
	 * @param object
	 * @return
	 */
	public static String hexadecimal(Object object) {
		return String.format("%X", object);
	}

	/**
	 * 转化为科学计数法
	 * 
	 * @param object
	 * @return
	 */
	public static String e(Object object) {
		return String.format("%e", object);
	}

	/**
	 * 将字符格式化为特定的格式
	 * 
	 * @param format
	 *            格式 *********
	 * @param string
	 *            被格式化对现象
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
	 * 将浮点型格式化 不足用0填补
	 * 
	 * @param integer
	 *            整数位
	 * @param decimal
	 *            小数位
	 * @param format
	 *            格式化对象
	 * @return
	 */
	public static String format_double(int integer, int decimal, double format) {
		return format_double(integer, decimal, format, "0");
	}

	/**
	 * 将浮点型格式化
	 * 
	 * @param integer
	 *            整数位
	 * @param decimal
	 *            小数位
	 * @param format
	 *            格式化对象
	 * @param fill
	 *            补位符
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
	 * 将整形格式化
	 * 
	 * @param length
	 *            长度
	 * @param format
	 *            格式化对象
	 * @param fill
	 *            补位符
	 * @return
	 */
	public static String format_long(int length, long format, String fill) {
		return format_string(format + "", length, fill);
	}

	/**
	 * 将整形格式化 不足用0补位
	 * 
	 * @param length
	 *            长度
	 * @param format
	 *            格式化对象
	 * @return
	 */
	public static String format_long(int length, long format) {
		return format_long(length, format, "0");
	}

	/**
	 * 字符串格式化
	 * 
	 * @param format
	 *            格式化对象
	 * @param length
	 *            长度
	 * @param fill
	 *            补位符
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

	// 过滤特殊字符
	public static String StringFilter(String str) throws PatternSyntaxException {
		// 只允许字母和数字
		// String regEx = "[^a-zA-Z0-9]";
		// 清除掉所有特殊字符
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	/**
	 * 将字符转换为32字符
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
	 * 将字符转换为16为字符
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
