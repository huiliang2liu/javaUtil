package com.xh.string;

/**
 * ������֤
 * 
 */
public class RegularVerify {
	/**
	 * �����ַ�
	 */
	private static final String ANY_CHARACTER = ".";
	/**
	 * 0-9
	 */
	private static final String ZORE_TO_NINE = "\\d";
	/**
	 * ������
	 */
	private static final String NO_NUMBER = "\\D";
	/**
	 * ����հ��ַ� �� \t \n
	 */
	private static final String BLANK_CHARACTER = "\\s";
	/**
	 * ����ǿհ��ַ�
	 */
	private static final String NO_BLANK_CHARACTER = "\\S";
	/**
	 * �����ʶ�� ������ $
	 */
	private static final String TAG = "\\w";
	/**
	 * �Ǳ�ʶ��
	 */
	private static final String NO_TAG = "\\W";
	/**
	 * ��ʾСд��ĸ
	 */
	private static final String LOWERCASE = "\\p{Lower}";
	/**
	 * �����д��ĸ
	 */
	private static final String CAPITAL = "\\p{Upper}";
	/**
	 * ������ĸ
	 */
	private static final String LETTER = "\\p{Alpha}";
	/**
	 * ���ֻ���ĸ
	 */
	private static final String NUMBER_OR_LETTER = "\\p{Alnum}";
	/**
	 * ������
	 */
	private static final String PUNCTUATION = "\\p{Punct}";
	/**
	 * ���ִ��� 0��1��
	 */
	private static final String TIME_ZORE_OR_ONE = "?";
	/**
	 * ���� 0�λ���
	 */
	private static final String TIME_ZORE_OR_MENY = "*";
	/**
	 * ����1�λ��߶��
	 */
	private static final String TIME_ONE_OR_MENY = "+";
	// {n}����n��
	// {n,} ����n��
	// {n,m}n��m��
	/**
	 * ����
	 */
	private static final String E_MAIL = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
	/**
	 * �ֻ�����
	 */
	private static final String MOBILE_PHON_NUMBER = "^((13[0-9])|(15[0-9])|(18[0-9])|(145)|(147)|(170)|(17[6-8]))\\d{8}$";
	/**
	 * ��������
	 */
	private static final String MACHINE_NUMBER = "^((d{3,4})|d{3,4}-)?d{7,8}$";
	/**
	 * ���֤
	 */
	private static final String CARD = "(\\d{18})|(\\d{17}x)";
	/**
	 * �ʱ�
	 */
	private static final String ZIP_COODE = "\\d{6}";

	/**
	 * ��֤����
	 * 
	 * @param e_mail
	 * @return
	 */
	public static boolean is_e_mail(String e_mail) {
		return e_mail.matches(E_MAIL);
	}

	/**
	 * ��֤�ֻ�����
	 * 
	 * @param number
	 * @return
	 */
	public static boolean is_mobile_phon_number(String number) {
		return number.matches(MOBILE_PHON_NUMBER);
	}

	/**
	 * ��֤��������
	 * 
	 * @param number
	 * @return
	 */
	public static boolean is_machine_number(String number) {
		return number.matches(MACHINE_NUMBER);
	}

	/**
	 * ��֤���֤
	 * 
	 * @param card
	 * @return
	 */
	public static boolean is_card(String card) {
		return card.matches(CARD);
	}

	/**
	 * ��֤�ʱ�
	 * 
	 * @param zip_coode
	 * @return
	 */
	public static boolean is_zip_coode(String zip_coode) {
		return zip_coode.matches(ZIP_COODE);
	}
}
