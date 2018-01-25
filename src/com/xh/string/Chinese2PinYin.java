package com.xh.string;
//package com.xiao.hei.string;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import net.sourceforge.pinyin4j.PinyinHelper;
//import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
//import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
//import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
//import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
//import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
//
//public class Chinese2PinYin {
//
//	/**
//	 * 设置格式为小写拼音字母，不叫语调标示
//	 */
//	public static HanyuPinyinOutputFormat setFormat10() {
//		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
//		format.setCaseType(HanyuPinyinCaseType.LOWERCASE); // 小写拼音字母
//		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE); // 不加语调标识
//		format.setVCharType(HanyuPinyinVCharType.WITH_V); // u:的声母替换为v
//		return format;
//	}
//
//	/**
//	 * 设置格式为大写拼音字母，不叫语调标示
//	 */
//	public static HanyuPinyinOutputFormat setFormat20() {
//		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
//		format.setCaseType(HanyuPinyinCaseType.UPPERCASE); // 大写拼音字母
//		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE); // 不加语调标识
//		format.setVCharType(HanyuPinyinVCharType.WITH_V); // u:的声母替换为v
//		return format;
//	}
//
//	/**
//	 * 设置格式为小写拼音字母，用数字标示语调
//	 */
//	public static HanyuPinyinOutputFormat setFormat11() {
//		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
//		format.setCaseType(HanyuPinyinCaseType.LOWERCASE); // 小写拼音字母
//		format.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER); // 用数字作为语调表示
//		format.setVCharType(HanyuPinyinVCharType.WITH_V); // u:的声母替换为v
//		return format;
//	}
//
//	/**
//	 * 设置格式为大写拼音字母，用数字标示语调
//	 */
//	public static HanyuPinyinOutputFormat setFormat21() {
//		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
//		format.setCaseType(HanyuPinyinCaseType.UPPERCASE); // 大写拼音字母
//		format.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER); // 用数字作为语调表示
//		format.setVCharType(HanyuPinyinVCharType.WITH_V); // u:的声母替换为v
//		return format;
//	}
//
//	/**
//	 * 设置格式为小写拼音字母，直接标语调
//	 */
//	public static HanyuPinyinOutputFormat setFormat12() {
//		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
//		format.setCaseType(HanyuPinyinCaseType.LOWERCASE); // 小写拼音字母
//		format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK); // 用直接标语调
//		format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
//		return format;
//	}
//
//	// /**
//	// * 设置格式为大写拼音字母，直接标语调 不支持，会乱码
//	// */
//	// public static void setFormat22(){
//	// format.setCaseType(HanyuPinyinCaseType.UPPERCASE); // 大写拼音字母
//	// format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK); //用直接标语调
//	// format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
//	// }
//	/**
//	 * 将小写字母转化为大写
//	 */
//	public static String lowercase2Uppercase(String a) {
//		char ch = a.charAt(0);
//		if (ch >= 'a' && ch <= 'z')
//			return "" + (char) (ch - 'a' + 'A');
//		if (ch >= 'A' && ch <= 'Z')
//			return "" + ch;
//		return a;
//	}
//
//	/**
//	 * 将大写字母转化为小写
//	 */
//	public static String Uppercase2lowercase(String a) {
//		char ch = a.charAt(0);
//		if (ch >= 'a' && ch <= 'z')
//			return "" + ch;
//		if (ch >= 'A' && ch <= 'Z')
//			return "" + (char) (ch - 'A' + 'a');
//		return a;
//	}
//
//	/**
//	 * 将单个汉字转化为pinyin无音标
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chainese2PinYinNumber10(String chinese) {
//		try {
//			// 对英文字母的处理：小写字母转换为大写，大写的直接返回
//			char ch = chinese.charAt(0);
//			if (ch >= 'a' && ch <= 'z')
//				return "" + (char) (ch - 'a' + 'A');
//			if (ch >= 'A' && ch <= 'Z')
//				return "" + ch;
//			// 对汉语的处理
//			String[] arr = PinyinHelper.toHanyuPinyinStringArray(ch, setFormat10());
//			if (arr != null && arr.length > 0)
//				return arr[0];
//		} catch (BadHanyuPinyinOutputFormatCombination e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * 将单个汉字转化为PINYIN无音标
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chainese2PinYinNumber20(String chinese) {
//		try {
//			// 对英文字母的处理：小写字母转换为大写，大写的直接返回
//			char ch = chinese.charAt(0);
//			if (ch >= 'a' && ch <= 'z')
//				return "" + (char) (ch - 'a' + 'A');
//			if (ch >= 'A' && ch <= 'Z')
//				return "" + ch;
//			// 对汉语的处理
//			String[] arr = PinyinHelper.toHanyuPinyinStringArray(ch, setFormat20());
//			if (arr != null && arr.length > 0)
//				return arr[0];
//		} catch (BadHanyuPinyinOutputFormatCombination e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * 将单个汉字转化为PinYin无音标
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chainese2PinYinNumber30(String chinese) {
//		try {
//			// 对英文字母的处理：小写字母转换为大写，大写的直接返回
//			char ch = chinese.charAt(0);
//			if (ch >= 'a' && ch <= 'z')
//				return "" + (char) (ch - 'a' + 'A');
//			if (ch >= 'A' && ch <= 'Z')
//				return "" + ch;
//			// 对汉语的处理
//			String[] arr = PinyinHelper.toHanyuPinyinStringArray(ch, setFormat10());
//			if (arr != null && arr.length > 0) {
//				String re = "";
//				for (int i = 0; i < arr[0].length(); i++) {
//					if (i == 0)
//						re += lowercase2Uppercase(arr[0].substring(i, i + 1));
//					else
//						re += Uppercase2lowercase(arr[0].substring(i, i + 1));
//					// System.out.println(""+arr[0].charAt(0));
//				}
//				return re;
//			}
//		} catch (BadHanyuPinyinOutputFormatCombination e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * 将单个汉字转化为PY无音标
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chainese2PinYinNumber40(String chinese) {
//		try {
//			// 对英文字母的处理：小写字母转换为大写，大写的直接返回
//			char ch = chinese.charAt(0);
//			if (ch >= 'a' && ch <= 'z')
//				return "" + (char) (ch - 'a' + 'A');
//			if (ch >= 'A' && ch <= 'Z')
//				return "" + ch;
//			// 对汉语的处理
//			String[] arr = PinyinHelper.toHanyuPinyinStringArray(ch, setFormat10());
//			if (arr != null && arr.length > 0) {
//				String re = "";
//				re += lowercase2Uppercase(arr[0].substring(0, 1));
//				return re;
//			}
//		} catch (BadHanyuPinyinOutputFormatCombination e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * 将单个汉字转化为py无音标
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chainese2PinYinNumber50(String chinese) {
//		try {
//			// 对英文字母的处理：小写字母转换为大写，大写的直接返回
//			char ch = chinese.charAt(0);
//			if (ch >= 'a' && ch <= 'z')
//				return "" + (char) (ch - 'a' + 'A');
//			if (ch >= 'A' && ch <= 'Z')
//				return "" + ch;
//			// 对汉语的处理
//			String[] arr = PinyinHelper.toHanyuPinyinStringArray(ch, setFormat10());
//			if (arr != null && arr.length > 0) {
//				String re = "";
//				re += arr[0].substring(0, 1);
//				return re;
//			}
//		} catch (BadHanyuPinyinOutputFormatCombination e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * 将单个汉字转化为pinyin数字作为音标
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chainese2PinYinNumber11(String chinese) {
//		try {
//			// 对英文字母的处理：小写字母转换为大写，大写的直接返回
//			char ch = chinese.charAt(0);
//			if (ch >= 'a' && ch <= 'z')
//				return "" + (char) (ch - 'a' + 'A');
//			if (ch >= 'A' && ch <= 'Z')
//				return "" + ch;
//			// 对汉语的处理
//			String[] arr = PinyinHelper.toHanyuPinyinStringArray(ch, setFormat11());
//			if (arr != null && arr.length > 0)
//				return arr[0];
//		} catch (BadHanyuPinyinOutputFormatCombination e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * 将单个汉字转化为PINYIN数字作为音标
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chainese2PinYinNumber21(String chinese) {
//		try {
//			// 对英文字母的处理：小写字母转换为大写，大写的直接返回
//			char ch = chinese.charAt(0);
//			if (ch >= 'a' && ch <= 'z')
//				return "" + (char) (ch - 'a' + 'A');
//			if (ch >= 'A' && ch <= 'Z')
//				return "" + ch;
//			// 对汉语的处理
//			String[] arr = PinyinHelper.toHanyuPinyinStringArray(ch, setFormat21());
//			if (arr != null && arr.length > 0)
//				return arr[0];
//		} catch (BadHanyuPinyinOutputFormatCombination e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * 将单个汉字转化为pinyin有音标
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chainese2PinYinNumber12(String chinese) {
//		try {
//			// 对英文字母的处理：小写字母转换为大写，大写的直接返回
//			char ch = chinese.charAt(0);
//			if (ch >= 'a' && ch <= 'z')
//				return "" + (char) (ch - 'a' + 'A');
//			if (ch >= 'A' && ch <= 'Z')
//				return "" + ch;
//			// 对汉语的处理
//			String[] arr = PinyinHelper.toHanyuPinyinStringArray(ch, setFormat12());
//			if (arr != null && arr.length > 0)
//				return arr[0];
//		} catch (BadHanyuPinyinOutputFormatCombination e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * 将所有汉字转化为pinyin
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chainese2PinYinNumberAll10(String chinese) {
//		String a = "";
//		for (int i = 0; i < chinese.length(); i++) {
//			a += chainese2PinYinNumber10(chinese.substring(i, i + 1));
//			if (i != chinese.length() - 1)
//				a += "=";
//		}
//		return a;
//	}
//
//	/**
//	 * 将所有汉字转化为py
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chainese2PinYinNumberAll12(String chinese) {
//		String a = "";
//		for (int i = 0; i < chinese.length(); i++) {
//			a += chainese2PinYinNumber50(chinese.substring(i, i + 1));
//		}
//		return a;
//	}
//
//	/**
//	 * 将所有汉字转化为PY
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chainese2PinYinNumberAll13(String chinese) {
//		String a = "";
//		for (int i = 0; i < chinese.length(); i++) {
//			a += chainese2PinYinNumber40(chinese.substring(i, i + 1));
//		}
//		return a;
//	}
//
//	/**
//	 * 将所有汉字转化为PinYin
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chainese2PinYinNumberAll11(String chinese) {
//		String a = "";
//		for (int i = 0; i < chinese.length(); i++) {
//			a += chainese2PinYinNumber30(chinese.substring(i, i + 1));
//		}
//		return a;
//	}
//
//	/**
//	 * 将所有汉字转化为PINYIN
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chainese2PinYinNumberAll14(String chinese) {
//		String a = "";
//		for (int i = 0; i < chinese.length(); i++) {
//			a += chainese2PinYinNumber20(chinese.substring(i, i + 1));
//		}
//		return a;
//	}
//
//	/**
//	 * 升序排序
//	 * 
//	 * @param strings
//	 * @return
//	 */
//	public static String[] ascend(String[] strings) {
//		String[] sts = new String[strings.length];
//		for (int i = 0; i < sts.length; i++) {
//			sts[i] = chainese2PinYinNumber10(strings[i]);
//		}
//		String stsa;
//		String stringsa;
//		for (int i = 0; i < sts.length; i++) {
//			stsa = sts[i];
//			stringsa = strings[i];
//			for (int j = i + 1; j < sts.length; j++) {
//				for (int j2 = 0; j2 < stsa.length(); j2++) {
//					if (sts[j].length() <= j2)
//						break;
//					if (stsa.charAt(j2) < sts[j].charAt(j2))
//						break;
//					if (stsa.charAt(j2) > sts[j].charAt(j2)) {
//						stsa = sts[j];
//						sts[j] = sts[i];
//						sts[i] = stsa;
//						stringsa = strings[j];
//						strings[j] = strings[i];
//						strings[i] = stringsa;
//						break;
//					}
//				}
//			}
//		}
//		return strings;
//	}
//
//	/**
//	 * 升序排序,得到拼音列表
//	 * 
//	 * @param strings
//	 * @return
//	 */
//	public static String[] ascend1(String[] strings) {
//		String[] sts = new String[strings.length];
//		for (int i = 0; i < sts.length; i++) {
//			sts[i] = chainese2PinYinNumber10(strings[i]);
//		}
//		String stsa;
//		for (int i = 0; i < sts.length; i++) {
//			stsa = sts[i];
//			for (int j = i + 1; j < sts.length; j++) {
//				for (int j2 = 0; j2 < stsa.length(); j2++) {
//					if (sts[j].length() <= j2)
//						break;
//					if (stsa.charAt(j2) < sts[j].charAt(j2))
//						break;
//					if (stsa.charAt(j2) > sts[j].charAt(j2)) {
//						stsa = sts[j];
//						sts[j] = sts[i];
//						sts[i] = stsa;
//						break;
//					}
//				}
//			}
//		}
//		return sts;
//	}
//
//	/**
//	 * 升序排序,得到拼音首字母
//	 * 
//	 * @param strings
//	 * @return
//	 */
//	public static String[] ascend2(String[] strings) {
//		String[] sts = new String[strings.length];
//		for (int i = 0; i < sts.length; i++) {
//			sts[i] = chainese2PinYinNumber50(strings[i]);
//		}
//		String stsa;
//		for (int i = 0; i < sts.length; i++) {
//			stsa = sts[i];
//			for (int j = i + 1; j < sts.length; j++) {
//				if (stsa.charAt(0) > sts[j].charAt(0)) {
//					stsa = sts[j];
//					sts[j] = sts[i];
//					sts[i] = stsa;
//				}
//			}
//		}
//		return sts;
//	}
//
//	/**
//	 * 降序排序
//	 * 
//	 * @param strings
//	 * @return
//	 */
//	public static String[] order(String[] strings) {
//		String[] sts = new String[strings.length];
//		for (int i = 0; i < sts.length; i++) {
//			sts[i] = chainese2PinYinNumber10(strings[i]);
//		}
//		String stsa;
//		String stringsa;
//		for (int i = 0; i < sts.length; i++) {
//			stsa = sts[i];
//			stringsa = strings[i];
//			for (int j = i + 1; j < sts.length; j++) {
//				for (int j2 = 0; j2 < stsa.length(); j2++) {
//					if (sts[j].length() <= j2)
//						break;
//					if (stsa.charAt(j2) > sts[j].charAt(j2))
//						break;
//					if (stsa.charAt(j2) < sts[j].charAt(j2)) {
//						stsa = sts[j];
//						sts[j] = sts[i];
//						sts[i] = stsa;
//						stringsa = strings[j];
//						strings[j] = strings[i];
//						strings[i] = stringsa;
//						break;
//					}
//				}
//				// System.out.println(stringsa);
//			}
//		}
//		return strings;
//	}
//
//	/**
//	 * 降序排序，得到拼音列表
//	 * 
//	 * @param strings
//	 * @return
//	 */
//	public static String[] order1(String[] strings) {
//		String[] sts = new String[strings.length];
//		for (int i = 0; i < sts.length; i++) {
//			sts[i] = chainese2PinYinNumber10(strings[i]);
//		}
//		String stsa;
//		for (int i = 0; i < sts.length; i++) {
//			stsa = sts[i];
//			for (int j = i + 1; j < sts.length; j++) {
//				for (int j2 = 0; j2 < stsa.length(); j2++) {
//					if (sts[j].length() <= j2)
//						break;
//					if (stsa.charAt(j2) > sts[j].charAt(j2))
//						break;
//					if (stsa.charAt(j2) < sts[j].charAt(j2)) {
//						stsa = sts[j];
//						sts[j] = sts[i];
//						sts[i] = stsa;
//						break;
//					}
//				}
//			}
//		}
//		return sts;
//	}
//
//	/**
//	 * 降序排序，得到拼音首字母
//	 * 
//	 * @param strings
//	 * @return
//	 */
//	public static String[] order2(String[] strings) {
//		String[] sts = new String[strings.length];
//		for (int i = 0; i < sts.length; i++) {
//			sts[i] = chainese2PinYinNumber50(strings[i]);
//		}
//		String stsa;
//		for (int i = 0; i < sts.length; i++) {
//			stsa = sts[i];
//			for (int j = i; j < sts.length; j++) {
//				if (stsa.charAt(0) < sts[j].charAt(0)) {
//					stsa = sts[j];
//					sts[j] = sts[i];
//					sts[i] = stsa;
//				}
//			}
//		}
//		return sts;
//	}
//
//	/***************************************************************************
//	 * 获取中文汉字拼音 默认输出
//	 * 
//	 * @Name: Pinyin4jUtil.java
//	 * @Description: TODO
//	 * @author: wang_chian@foxmail.com
//	 * @version: Jan 13, 2012 9:54:01 AM
//	 * @param chinese
//	 * @return
//	 */
//	public static String getPinyin(String chinese) {
//		return getPinyinZh_CN(makeStringByStringSet(chinese));
//	}
//
//	/***************************************************************************
//	 * 拼音大写输出
//	 * 
//	 * @Name: Pinyin4jUtil.java
//	 * @Description: TODO
//	 * @author: wang_chian@foxmail.com
//	 * @version: Jan 13, 2012 9:58:45 AM
//	 * @param chinese
//	 * @return
//	 */
//	public static String getPinyinToUpperCase(String chinese) {
//		return getPinyinZh_CN(makeStringByStringSet(chinese)).toUpperCase();
//	}
//
//	/***************************************************************************
//	 * 拼音小写输出
//	 * 
//	 * @Name: Pinyin4jUtil.java
//	 * @Description: TODO
//	 * @author: wang_chian@foxmail.com
//	 * @version: Jan 13, 2012 9:58:45 AM
//	 * @param chinese
//	 * @return
//	 */
//	public static String getPinyinToLowerCase(String chinese) {
//		return getPinyinZh_CN(makeStringByStringSet(chinese)).toLowerCase();
//	}
//
//	/***************************************************************************
//	 * 首字母大写输出
//	 * 
//	 * @Name: Pinyin4jUtil.java
//	 * @Description: TODO
//	 * @author: wang_chian@foxmail.com
//	 * @version: Jan 13, 2012 10:00:54 AM
//	 * @param chinese
//	 * @return
//	 */
//	public static String getPinyinFirstToUpperCase(String chinese) {
//		return getPinyin(chinese);
//	}
//
//	/***************************************************************************
//	 * 拼音简拼输出
//	 * 
//	 * @Name: Pinyin4jUtil.java
//	 * @Description: TODO
//	 * @author: wang_chian@foxmail.com
//	 * @version: Jan 13, 2012 11:08:15 AM
//	 * @param chinese
//	 * @return
//	 */
//	public static String getPinyinJianPin(String chinese) {
//		return getPinyinConvertJianPin(getPinyin(chinese));
//	}
//
//	/***************************************************************************
//	 * 字符集转换
//	 * 
//	 * @Name: Pinyin4jUtil.java
//	 * @Description: TODO
//	 * @author: wang_chian@foxmail.com
//	 * @version: Jan 13, 2012 9:34:11 AM
//	 * @param chinese
//	 *            中文汉字
//	 * @throws BadHanyuPinyinOutputFormatCombination
//	 */
//	public static Set<String> makeStringByStringSet(String chinese) {
//		char[] chars = chinese.toCharArray();
//		if (chinese != null && !chinese.trim().equalsIgnoreCase("")) {
//			char[] srcChar = chinese.toCharArray();
//			String[][] temp = new String[chinese.length()][];
//			for (int i = 0; i < srcChar.length; i++) {
//				char c = srcChar[i];
//
//				// 是中文或者a-z或者A-Z转换拼音
//				if (String.valueOf(c).matches("[\\u4E00-\\u9FA5]+")) {
//
//					try {
//						temp[i] = PinyinHelper.toHanyuPinyinStringArray(
//								chars[i], getDefaultOutputFormat());
//
//					} catch (BadHanyuPinyinOutputFormatCombination e) {
//						e.printStackTrace();
//					}
//				} else if (((int) c >= 65 && (int) c <= 90)
//						|| ((int) c >= 97 && (int) c <= 122)) {
//					temp[i] = new String[] { String.valueOf(srcChar[i]) };
//				} else {
//					temp[i] = new String[] { "" };
//				}
//			}
//			String[] pingyinArray = Exchange(temp);
//			Set<String> zhongWenPinYin = new HashSet<String>();
//			for (int i = 0; i < pingyinArray.length; i++) {
//				zhongWenPinYin.add(pingyinArray[i]);
//			}
//			return zhongWenPinYin;
//		}
//		return null;
//	}
//
//	/***************************************************************************
//	 * Default Format 默认输出格式
//	 * 
//	 * @Name: Pinyin4jUtil.java
//	 * @Description: TODO
//	 * @author: wang_chian@foxmail.com
//	 * @version: Jan 13, 2012 9:35:51 AM
//	 * @return
//	 */
//	public static HanyuPinyinOutputFormat getDefaultOutputFormat() {
//		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
//		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 小写
//		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 没有音调数字
//		format.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);// u显示
//		return format;
//	}
//
//	/***************************************************************************
//	 * 
//	 * @Name: Pinyin4jUtil.java
//	 * @Description: TODO
//	 * @author: wang_chian@foxmail.com
//	 * @version: Jan 13, 2012 9:39:54 AM
//	 * @param strJaggedArray
//	 * @return
//	 */
//	public static String[] Exchange(String[][] strJaggedArray) {
//		String[][] temp = DoExchange(strJaggedArray);
//		return temp[0];
//	}
//
//	/***************************************************************************
//	 * 
//	 * @Name: Pinyin4jUtil.java
//	 * @Description: TODO
//	 * @author: wang_chian@foxmail.com
//	 * @version: Jan 13, 2012 9:39:47 AM
//	 * @param strJaggedArray
//	 * @return
//	 */
//	private static String[][] DoExchange(String[][] strJaggedArray) {
//		int len = strJaggedArray.length;
//		if (len >= 2) {
//			int len1 = strJaggedArray[0].length;
//			int len2 = strJaggedArray[1].length;
//			int newlen = len1 * len2;
//			String[] temp = new String[newlen];
//			int Index = 0;
//			for (int i = 0; i < len1; i++) {
//				for (int j = 0; j < len2; j++) {
//					temp[Index] = capitalize(strJaggedArray[0][i])
//							+ capitalize(strJaggedArray[1][j]);
//					Index++;
//				}
//			}
//			String[][] newArray = new String[len - 1][];
//			for (int i = 2; i < len; i++) {
//				newArray[i - 1] = strJaggedArray[i];
//			}
//			newArray[0] = temp;
//			return DoExchange(newArray);
//		} else {
//			return strJaggedArray;
//		}
//	}
//
//	/***************************************************************************
//	 * 首字母大写
//	 * 
//	 * @Name: Pinyin4jUtil.java
//	 * @Description: TODO
//	 * @author: wang_chian@foxmail.com
//	 * @version: Jan 13, 2012 9:36:18 AM
//	 * @param s
//	 * @return
//	 */
//	public static String capitalize(String s) {
//		char ch[];
//		ch = s.toCharArray();
//		if (ch[0] >= 'a' && ch[0] <= 'z') {
//			ch[0] = (char) (ch[0] - 32);
//		}
//		String newString = new String(ch);
//		return newString;
//	}
//
//	/***************************************************************************
//	 * 字符串集合转换字符串(等号分隔)
//	 * 
//	 * @Name: Pinyin4jUtil.java
//	 * @Description: TODO
//	 * @author: wang_chian@foxmail.com
//	 * @version: Jan 13, 2012 9:37:57 AM
//	 * @param stringSet
//	 * @return
//	 */
//	public static String getPinyinZh_CN(Set<String> stringSet) {
//		StringBuilder str = new StringBuilder();
//		int i = 0;
//		for (String s : stringSet) {
//			if (i == stringSet.size() - 1) {
//				str.append(s);
//			} else {
//				str.append(s + "=");
//			}
//			i++;
//		}
//		return str.toString();
//	}
//
//	/***************************************************************************
//	 * 获取每个拼音的简称
//	 * 
//	 * @Name: Pinyin4jUtil.java
//	 * @Description: TODO
//	 * @author: wang_chian@foxmail.com
//	 * @version: Jan 13, 2012 11:05:58 AM
//	 * @param chinese
//	 * @return
//	 */
//	public static String getPinyinConvertJianPin(String chinese) {
//		String[] strArray = chinese.split(",");
//		String strChar = "";
//		for (String str : strArray) {
//			char arr[] = str.toCharArray(); // 将字符串转化成char型数组
//			for (int i = 0; i < arr.length; i++) {
//				if (arr[i] >= 65 && arr[i] < 91) { // 判断是否是大写字母
//					strChar += new String(arr[i] + "");
//				}
//			}
//			strChar += ",";
//		}
//		return strChar;
//	}
//	/**
//	 * 将单个汉字转换为小写字母集合
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String[] chinese_2_lowercase_letters(String chinese) {
//		if (Util.is_chinese(chinese)) {
//			try {
//				return PinyinHelper.toHanyuPinyinStringArray(chinese.charAt(0),
//						setFormat10());
//			} catch (BadHanyuPinyinOutputFormatCombination e) {
//				return null;
//			}
//		}
//		return null;
//	}
//	/**
//	 * 将单个汉字转换为小写字母集合
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String[] chineses_2_lowercase_letters(String chinese) {
//			char[] cs=chinese.toCharArray();
//			List<String[]>  list=new ArrayList<String[]>();
//			int len=0;
//			for (int i = 0; i < cs.length; i++) {
//				String[] strings=chinese_2_lowercase_letters(cs[i]+"");
//				if(strings!=null){
//					len+=strings.length;
//					list.add(strings);
//				}
//			}
//			if(len==0)
//				return null;
//			String[] strings=new String[len];
//			return strings;
//	}
//
//	/**
//	 * 将单个汉字转换为小写字母（最小的拼音）
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chinese_2_lowercase_letter(String chinese) {
//		String[] strings = chinese_2_lowercase_letters(chinese);
//		if (strings == null)
//			return null;
//		String a = strings[0];
//		for (int i = 1; i < strings.length; i++) {
//			if (Util.comparator(a, strings[i]))
//				a = strings[i];
//		}
//		return a;
//	}
//
//	/**
//	 * 将单个汉字转换为小写字母（最大的拼音）
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chinese_2_big_lowercase_letter(String chinese) {
//		String[] strings = chinese_2_lowercase_letters(chinese);
//		if (strings == null)
//			return null;
//		String a = strings[0];
//		for (int i = 1; i < strings.length; i++) {
//			if (!Util.comparator(a, strings[i]))
//				a = strings[i];
//		}
//		return a;
//	}
//
//	/**
//	 * 单个汉字转换为拼音的小写首字母集合
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String[] chinese_2_lowercases(String chinese) {
//		String[] strings = chinese_2_lowercase_letters(chinese);
//		if (strings == null)
//			return null;
//		for (int i = 0; i < strings.length; i++) {
//			String s = strings[i];
//			strings[i] = s.substring(0, 1);
//		}
//		return strings;
//	}
//
//	/**
//	 * 单个汉字转换为拼音的小写首字母（最小的）
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chinese_2_lowercase(String chinese) {
//		String s = chinese_2_lowercase_letter(chinese);
//		if (s == null)
//			return null;
//		return s.substring(0, 1);
//	}
//
//	/**
//	 * 单个汉字转换为拼音的小写首字母（最大的）
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chinese_2_big_lowercase(String chinese) {
//		String s = chinese_2_big_lowercase_letter(chinese);
//		if (s == null)
//			return null;
//		return s.substring(0, 1);
//	}
//
//	/**
//	 * 将单个汉字转换为字母集合 首字母大写
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String[] chinese_2_capitalize(String chinese) {
//		String[] strings = chinese_2_lowercase_letters(chinese);
//		if (strings == null)
//			return null;
//		for (int i = 0; i < strings.length; i++) {
//			String s = strings[i];
//			int len = s.length();
//			if (len == 1)
//				strings[i] = s.toUpperCase();
//			else
//				strings[i] = s.substring(0, 1).toUpperCase()
//						+ s.substring(1, len);
//		}
//		return strings;
//	}
//
//	/**
//	 * 将单个汉字转换为大写字母 集合
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String[] chinese_2_capital_letters(String chinese) {
//		if (Util.is_chinese(chinese)) {
//			try {
//				return PinyinHelper.toHanyuPinyinStringArray(chinese.charAt(0),
//						setFormat20());
//			} catch (BadHanyuPinyinOutputFormatCombination e) {
//				return null;
//			}
//		}
//		return null;
//	}
//
//	/**
//	 * 将单个汉字转换为大写字母（最小）
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chinese_2_capital_letter(String chinese) {
//		String[] strings = chinese_2_capital_letters(chinese);
//		if (strings == null)
//			return null;
//		String a = strings[0];
//		for (int i = 1; i < strings.length; i++) {
//			if (Util.comparator(a, strings[i]))
//				a = strings[i];
//		}
//		return a;
//	}
//
//	/**
//	 * 将单个汉字转换为大写字母（最大）
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chinese_2_big_capital_letter(String chinese) {
//		String[] strings = chinese_2_capital_letters(chinese);
//		if (strings == null)
//			return null;
//		String a = strings[0];
//		for (int i = 1; i < strings.length; i++) {
//			if (!Util.comparator(a, strings[i]))
//				a = strings[i];
//		}
//		return a;
//	}
//
//	/**
//	 * 将单个汉字转换为拼音的大写首字母 集合
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String[] chinese_2_capitals(String chinese) {
//		String[] strings = chinese_2_capital_letters(chinese);
//		if (strings == null)
//			return null;
//		for (int i = 0; i < strings.length; i++) {
//			String s = strings[i];
//			strings[i] = s.substring(0, 1);
//		}
//		return strings;
//	}
//
//	/**
//	 * 将单个汉字转换为拼音的大写首字母（最小）
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chinese_2_capital(String chinese) {
//		String s = chinese_2_capital_letter(chinese);
//		if (s == null)
//			return null;
//		return s.substring(0, 1);
//	}
//
//	/**
//	 * 将单个汉字转换为拼音的大写首字母（最大）
//	 * 
//	 * @param chinese
//	 * @return
//	 */
//	public static String chinese_2_big_capital(String chinese) {
//		String s = chinese_2_big_capital_letter(chinese);
//		if (s == null)
//			return null;
//		return s.substring(0, 1);
//	}
//
//	/***************************************************************************
//	 * Test
//	 * 
//	 * @Name: Pinyin4jUtil.java
//	 * @Description: TODO
//	 * @author: wang_chian@foxmail.com
//	 * @version: Jan 13, 2012 9:49:27 AM
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		String str = "长杀长";
//		System.out.println("小写输出：" + getPinyinToLowerCase(str));
//		System.out.println("大写输出：" + getPinyinToUpperCase(str));
//		System.out.println("首字母大写输出：" + getPinyinFirstToUpperCase(str));
//		System.out.println("简拼输出：" + getPinyinJianPin(str));
//	}
//}
