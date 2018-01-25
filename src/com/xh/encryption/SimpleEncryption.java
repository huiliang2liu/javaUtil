package com.xh.encryption;

import java.util.List;

import com.xh.string.Base64;
import com.xh.util.NumUtil;

/**
 * 
 * 简单加密
 */
public class SimpleEncryption {
	private final static String KEY = "0123456789ABCDEF";
	private final static List<Integer> factors;// 因子集合
	static {
		factors = NumUtil.relatively_prime_numbers(56);
	}

	/**
	 * 平移法加密
	 * 
	 * @param key
	 *            平移量 取值范围1-61
	 * @param clear
	 *            明文
	 * @return
	 */
	public static String translation_encryption(int key, String clear) {
		if (clear == null)
			throw new RuntimeException("clear is null");
		if (key < 1 || key > 61)
			key = 62 / 2;
		char[] cs = clear.toCharArray();
		char[] c1 = new char[cs.length];
		for (int i = 0; i < cs.length; i++) {
			char c = cs[i];
			if (com.xh.string.Util.is_numbers_or_letters(c)) {
				int ci = com.xh.encryption.Util.char2num(c);
				c = com.xh.encryption.Util.num2char((ci + key) % 62);
			}
			c1[i] = c;
		}
		return new String(c1);
	}

	/**
	 * 平移法解密
	 * 
	 * @param key
	 *            平移量 取值范围1-61
	 * @param cipher
	 *            密文
	 * @return
	 */
	public static String translation_decryption(int key, String cipher) {
		if (cipher == null)
			throw new RuntimeException("clear is null");
		if (key < 1 || key > 61)
			key = 62 / 2;
		char[] cs = cipher.toCharArray();
		char[] c1 = new char[cs.length];
		for (int i = 0; i < cs.length; i++) {
			char c = cs[i];
			if (com.xh.string.Util.is_numbers_or_letters(c)) {
				int ci = com.xh.encryption.Util.char2num(c);
				ci = ci - key;
				c = com.xh.encryption.Util.num2char(NumUtil.mode(62, ci));
			}
			c1[i] = c;
		}
		return new String(c1);
	}

	/**
	 * 仿射加密
	 * 
	 * @param clear
	 *            明文
	 * @param factor
	 *            因子
	 * @param translation
	 *            平移量
	 * @return
	 */
	public static String affine__encryption(String clear, int factor,
			int translation) {
		if (clear == null)
			throw new RuntimeException("clear is null");
		factor = int2factor(factor);
		if (translation < 1 || translation > 61)
			translation = 62 / 2;
		char[] cs = clear.toCharArray();
		char[] c1 = new char[cs.length];
		for (int i = 0; i < cs.length; i++) {
			char c = cs[i];
			if (com.xh.string.Util.is_numbers_or_letters(c)) {
				int ci = com.xh.encryption.Util.char2num(c);
				c = com.xh.encryption.Util
						.num2char((ci * factor + translation) % 62);
			}
			c1[i] = c;
		}
		return new String(c1);
	}

	/**
	 * 仿射解密
	 * 
	 * @param cipher
	 *            密文
	 * @param factor
	 *            因子
	 * @param translation
	 *            平移量
	 * @return
	 */
	public static String affine_decryption(String cipher, int factor,
			int translation) {
		if (cipher == null)
			throw new RuntimeException("clear is null");
		factor = int2factor(factor);
		if (translation < 1 || translation > 61)
			translation = 62 / 2;
		int a_ = -1;
		for (Integer integer : factors) {
			if (integer * factor % 62 == 1) {
				a_ = integer;
				break;
			}
		}
		char[] cs = cipher.toCharArray();
		char[] c1 = new char[cs.length];
		for (int i = 0; i < cs.length; i++) {
			char c = cs[i];
			if (com.xh.string.Util.is_numbers_or_letters(c)) {
				int ci = com.xh.encryption.Util.char2num(c);
				ci = ci - translation;
				c = com.xh.encryption.Util.num2char(NumUtil.mode(62, ci
						* a_));
			}
			c1[i] = c;
		}
		return new String(c1);
	}

	/**
	 * 序列法加密
	 * 
	 * @param key
	 *            密钥
	 * @param clear
	 *            明文
	 * @return
	 */
	public static String sequence_encryption(String key, String clear) {
		// key = Base64.encodeToString(key.getBytes(), 0);
		// clear = Base64.encodeToString(clear.getBytes(), 0);
		byte keys[] = key.getBytes();
		byte clears[] = clear.getBytes();
		byte ciphers[] = new byte[clears.length];
		if (keys.length >= clears.length)
			for (int i = 0; i < clears.length; i++) {
				int c = clears[i];
				int k = keys[i];
				ciphers[i] = (byte) (c ^ k);
			}
		else {
			for (int i = 0; i < clears.length; i++) {
				int c = clears[i];
				int k = keys[i % keys.length];
				ciphers[i] = (byte) (c ^ k);
			}
		}
		return new String(ciphers);
	}

	/**
	 * 序列法解密
	 * 
	 * @param key
	 *            密钥
	 * @param clear
	 *            密文
	 * @return
	 */
	public static String sequence_decryption(String key, String cipher) {
		// key = Base64.encodeToString(key.getBytes(), 0);
		byte keys[] = key.getBytes();
		byte ciphers[] = cipher.getBytes();
		byte clears[] = new byte[ciphers.length];
		if (keys.length >= ciphers.length)
			for (int i = 0; i < ciphers.length; i++) {
				int c = ciphers[i];
				int k = keys[i];
				clears[i] = (byte) (c ^ k);
			}
		else
			for (int i = 0; i < ciphers.length; i++) {
				int c = ciphers[i];
				int k = keys[i % keys.length];
				clears[i] = (byte) (c ^ k);
			}
		String clear = new String(clears);
		// clear = new String(Base64.decode(clear, 0));
		return clear;
	}

	/**
	 * 序列法加密
	 * 
	 * @param key
	 *            密钥
	 * @param clear
	 *            明文
	 * @return
	 */
	public static String sequence_encryption_base64(String key, String clear) {
		key = Base64.encodeToString(key.getBytes(), 0);
		clear = Base64.encodeToString(clear.getBytes(), 0);
		char keys[] = key.toCharArray();
		char clears[] = clear.toCharArray();
		char ciphers[] = new char[clears.length];
		if (keys.length >= clears.length)
			for (int i = 0; i < clears.length; i++) {
				int c = clears[i];
				int k = keys[i];
				ciphers[i] = (char) (c ^ k);
			}
		else {
			for (int i = 0; i < clears.length; i++) {
				int c = clears[i];
				int k = keys[i % keys.length];
				ciphers[i] = (char) (c ^ k);
			}
		}
		return new String(ciphers);
	}

	/**
	 * 序列法解密
	 * 
	 * @param key
	 *            密钥
	 * @param clear
	 *            密文
	 * @return
	 */
	public static String sequence_decryption_base64(String key, String cipher) {
		key = Base64.encodeToString(key.getBytes(), 0);
		char keys[] = key.toCharArray();
		char ciphers[] = cipher.toCharArray();
		char clears[] = new char[ciphers.length];
		if (keys.length >= ciphers.length)
			for (int i = 0; i < ciphers.length; i++) {
				int c = ciphers[i];
				int k = keys[i];
				clears[i] = (char) (c ^ k);
			}
		else
			for (int i = 0; i < ciphers.length; i++) {
				int c = ciphers[i];
				int k = keys[i % keys.length];
				clears[i] = (char) (c ^ k);
			}
		String clear = new String(clears);
		clear = new String(Base64.decode(clear, 0));
		return clear;
	}

	/**
	 * 是否为因子
	 * 
	 * @param factor
	 * @return
	 */
	private static boolean belong_to_factors(int factor) {
		for (Integer integer : factors) {
			if (factor == integer)
				return true;
		}
		return false;
	}

	/**
	 * 将int 转化为因子
	 * 
	 * @param factor
	 * @return
	 */
	private static int int2factor(int factor) {
		if (belong_to_factors(factor))
			return factor;
		return factors.get(factors.size() / 2);
	}
	/**
	 * 将十进制转换为十六进制
	 */
	public static String toHex(String txt) {
		if (txt == null) {
			return "";
		}
		return toHex(txt.getBytes());
	}

	/**
	 * 把一个十进制字节数组转换成十六进制
	 */
	public static String toHex(byte[] b) {
		if (b == null) {
			return "";
		}
		StringBuffer sb = new StringBuffer(2 * b.length);
		for (int i = 0; i < b.length; i++) {
			appendHex(sb, b[i]);
		}
		return sb.toString();
	}

	/**
	 * 将十六进制转换为十进制
	 */
	public static String fromHex(String hex) {
		if (hex == null) {
			return "";
		}
		return new String(toByte(hex));
	}

	/**
	 * 将十六进制转换成十进制字节数组
	 */
	public static byte[] toByte(String st) {
		int len = st.length() / 2;
		byte[] b = new byte[len];
		for (int i = 0; i < b.length; i++) {
			b[i] = Integer.valueOf(st.substring(2 * i, 2 * i + 2), 16)
					.byteValue();
		}
		return b;
	}
	private static void appendHex(StringBuffer sb, byte b) {
		sb.append(KEY.charAt((b >> 4) & 0x0f)).append(KEY.charAt(b & 0x0f));
	}
	/**将16进制转换为二进制
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
	        if (hexStr.length() < 1)
	                return null;
	        byte[] result = new byte[hexStr.length()/2];
	        for (int i = 0;i< hexStr.length()/2; i++) {
	                int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
	                int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
	                result[i] = (byte) (high * 16 + low);
	        }
	        return result;
	}
	/**将二进制转换成16进制 
	 * @param buf 
	 * @return 
	 */  
	public static String parseByte2HexStr(byte buf[]) {  
	        StringBuffer sb = new StringBuffer();  
	        for (int i = 0; i < buf.length; i++) {  
	                String hex = Integer.toHexString(buf[i] & 0xFF);  
	                if (hex.length() == 1) {  
	                        hex = '0' + hex;  
	                }  
	                sb.append(hex.toUpperCase());  
	        }  
	        return sb.toString();  
	}  
	public static void main(String[] args) {
//		int c_h=1;0000 0001
//		int c_v=c_h<<7;//1000 0000
//		int l=(2|c_h);//0000 0011
//		int r=4|c_h;//0000 0101   r|l 111     7
//		int t=l<<4;//0011 0000
//		int b=r<<4;//0101 0000 c_v|r   1000 0101  
//		int g=2|1;
//		System.out.println((l&r)==c_h); 
	  }
}
