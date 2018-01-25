package com.xh.string;

/**
 * 正则验证
 * 
 */
public class RegularVerify {
	/**
	 * 任意字符
	 */
	private static final String ANY_CHARACTER = ".";
	/**
	 * 0-9
	 */
	private static final String ZORE_TO_NINE = "\\d";
	/**
	 * 非数字
	 */
	private static final String NO_NUMBER = "\\D";
	/**
	 * 代表空白字符 如 \t \n
	 */
	private static final String BLANK_CHARACTER = "\\s";
	/**
	 * 代表非空白字符
	 */
	private static final String NO_BLANK_CHARACTER = "\\S";
	/**
	 * 代表标识符 不包括 $
	 */
	private static final String TAG = "\\w";
	/**
	 * 非标识符
	 */
	private static final String NO_TAG = "\\W";
	/**
	 * 表示小写字母
	 */
	private static final String LOWERCASE = "\\p{Lower}";
	/**
	 * 代表大写字母
	 */
	private static final String CAPITAL = "\\p{Upper}";
	/**
	 * 代表字母
	 */
	private static final String LETTER = "\\p{Alpha}";
	/**
	 * 数字或字母
	 */
	private static final String NUMBER_OR_LETTER = "\\p{Alnum}";
	/**
	 * 代表标点
	 */
	private static final String PUNCTUATION = "\\p{Punct}";
	/**
	 * 出现次数 0或1次
	 */
	private static final String TIME_ZORE_OR_ONE = "?";
	/**
	 * 出现 0次或多次
	 */
	private static final String TIME_ZORE_OR_MENY = "*";
	/**
	 * 出现1次或者多次
	 */
	private static final String TIME_ONE_OR_MENY = "+";
	// {n}正好n次
	// {n,} 至少n次
	// {n,m}n到m次
	/**
	 * 邮箱
	 */
	private static final String E_MAIL = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
	/**
	 * 手机号码
	 */
	private static final String MOBILE_PHON_NUMBER = "^((13[0-9])|(15[0-9])|(18[0-9])|(145)|(147)|(170)|(17[6-8]))\\d{8}$";
	/**
	 * 座机号码
	 */
	private static final String MACHINE_NUMBER = "^((d{3,4})|d{3,4}-)?d{7,8}$";
	/**
	 * 身份证
	 */
	private static final String CARD = "(\\d{18})|(\\d{17}x)";
	/**
	 * 邮编
	 */
	private static final String ZIP_COODE = "\\d{6}";

	/**
	 * 验证邮箱
	 * 
	 * @param e_mail
	 * @return
	 */
	public static boolean is_e_mail(String e_mail) {
		return e_mail.matches(E_MAIL);
	}

	/**
	 * 验证手机号码
	 * 
	 * @param number
	 * @return
	 */
	public static boolean is_mobile_phon_number(String number) {
		return number.matches(MOBILE_PHON_NUMBER);
	}

	/**
	 * 验证座机号码
	 * 
	 * @param number
	 * @return
	 */
	public static boolean is_machine_number(String number) {
		return number.matches(MACHINE_NUMBER);
	}

	/**
	 * 验证身份证
	 * 
	 * @param card
	 * @return
	 */
	public static boolean is_card(String card) {
		return card.matches(CARD);
	}

	/**
	 * 验证邮编
	 * 
	 * @param zip_coode
	 * @return
	 */
	public static boolean is_zip_coode(String zip_coode) {
		return zip_coode.matches(ZIP_COODE);
	}
}
