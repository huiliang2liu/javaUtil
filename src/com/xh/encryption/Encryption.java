package com.xh.encryption;

import java.math.BigInteger;

import com.xh.string.Base64;
public abstract class Encryption {
	/**
	 * 
	 * @param encrypionText
	 *            加密文件
	 * @param encrypionKey
	 *            密钥
	 * @return
	 */

	public  String encryption(String encrypionText, String encrypionKey)
			throws Exception{
		return SimpleEncryption.parseByte2HexStr(encryption(encrypionText.getBytes("utf-8"), encrypionKey.getBytes("utf-8")));
	};
	/**
	 * 
	 * @param encrypionText
	 *            加密文件
	 * @param encrypionKey
	 *            密钥
	 * @return
	 */
	public abstract byte[] encryption(byte[] encrypionText, byte[] encrypionKey)
			throws Exception;
	/**
	 * 
	 * @param decryptionText
	 *            解密文件
	 * @param decryptionKey
	 *            密钥
	 * @return
	 * @throws Exception
	 */

	public  String decryption(String decryptionText,
			String decryptionKey) throws Exception{
		return new String(decryption(SimpleEncryption.parseHexStr2Byte(decryptionText), decryptionKey.getBytes("utf-8")),"utf-8");
	};
	/**
	 * 
	 * @param decryptionText
	 *            解密文件
	 * @param decryptionKey
	 *            密钥
	 * @return
	 * @throws Exception
	 */
	public abstract byte[] decryption(byte[] buffs, byte[] decryptionKey)
			throws Exception;

	/**
	 * base 64 encode
	 * 
	 * @param bytes
	 *            待编码的byte[]
	 * @return 编码后的base 64 code
	 */
	byte[] base64Encode(byte[] bytes) {
		return Base64.encode(bytes, 0);
	}

	/**
	 * 将byte[]转为各种进制的字符串
	 * 
	 * @param bytes
	 *            byte[]
	 * @param radix
	 *            可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
	 * @return 转换后的字符串
	 */
	String binary(byte[] bytes, int radix) {
		return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
	}

	/**
	 * base 64 decode
	 * 
	 * @param base64Code
	 *            待解码的base 64 code
	 * @return 解码后的byte[]
	 * @throws Exception
	 */
	byte[] base64Decode(String base64Code) throws Exception {
		return Base64.decode(base64Code, 0);
	}

	byte[] base64Decode(byte[] base64Code) throws Exception {
		return Base64.decode(base64Code, 0);
	}

	// /**
	// * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
	// * hexStr2ByteArr(String strIn) 互为可逆的转换过程
	// *
	// * @param arrB
	// * 需要转换的byte数组
	// * @return 转换后的字符串
	// * @throws Exception
	// * 本方法不处理任何异常，所有异常全部抛出
	// */
	// String byteArr2HexStr(byte[] arrB) throws Exception {
	// int iLen = arrB.length;
	// // 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍..一个byte转成16进制最多不会超过两位。FF
	// StringBuffer sb = new StringBuffer(iLen * 2);
	// for (int i = 0; i < iLen; i++) {
	// int intTmp = arrB[i];
	// // 把负数转换为正数
	// while (intTmp < 0) {
	// intTmp = intTmp + 256;
	// }
	// // 小于0F的数需要在前面补0
	// if (intTmp < 16) {
	// sb.append("0");
	// }
	// sb.append(Integer.toString(intTmp, 16)); // 16代表进制
	// }
	// return sb.toString();
	// }
	//
	// /**
	// * 将表示16进制值的字符串转换为byte数组， 和public static String byteArr2HexStr(byte[]
	// arrB)
	// * 互为可逆的转换过程
	// *
	// * @param strIn
	// * 需要转换的字符串
	// * @return 转换后的byte数组
	// * @throws Exception
	// * 本方法不处理任何异常，所有异常全部抛出
	// * @author <a href="mailto:leo841001@163.com">LiGuoQing</a>
	// */
	// byte[] hexStr2ByteArr(String strIn) throws Exception {
	// byte[] arrB = strIn.getBytes();
	// int iLen = arrB.length;
	//
	// // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
	// byte[] arrOut = new byte[iLen / 2];
	// for (int i = 0; i < iLen; i = i + 2) {
	// String strTmp = new String(arrB, i, 2);
	// arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
	// }
	// return arrOut;
	// }
	static class Base64Utils {

		static private char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="
				.toCharArray();
		static private byte[] codes = new byte[256];
		static {
			for (int i = 0; i < 256; i++)
				codes[i] = -1;
			for (int i = 'A'; i <= 'Z'; i++)
				codes[i] = (byte) (i - 'A');
			for (int i = 'a'; i <= 'z'; i++)
				codes[i] = (byte) (26 + i - 'a');
			for (int i = '0'; i <= '9'; i++)
				codes[i] = (byte) (52 + i - '0');
			codes['+'] = 62;
			codes['/'] = 63;
		}

		/**
		 * 将原始数据编码为base64编码
		 */
		static public String encode(byte[] data) {
			char[] out = new char[((data.length + 2) / 3) * 4];
			for (int i = 0, index = 0; i < data.length; i += 3, index += 4) {
				boolean quad = false;
				boolean trip = false;
				int val = (0xFF & (int) data[i]);
				val <<= 8;
				if ((i + 1) < data.length) {
					val |= (0xFF & (int) data[i + 1]);
					trip = true;
				}
				val <<= 8;
				if ((i + 2) < data.length) {
					val |= (0xFF & (int) data[i + 2]);
					quad = true;
				}
				out[index + 3] = alphabet[(quad ? (val & 0x3F) : 64)];
				val >>= 6;
				out[index + 2] = alphabet[(trip ? (val & 0x3F) : 64)];
				val >>= 6;
				out[index + 1] = alphabet[val & 0x3F];
				val >>= 6;
				out[index + 0] = alphabet[val & 0x3F];
			}

			return new String(out);
		}

		/**
		 * 将base64编码的数据解码成原始数据
		 */
		static public byte[] decode(char[] data) {
			int len = ((data.length + 3) / 4) * 3;
			if (data.length > 0 && data[data.length - 1] == '=')
				--len;
			if (data.length > 1 && data[data.length - 2] == '=')
				--len;
			byte[] out = new byte[len];
			int shift = 0;
			int accum = 0;
			int index = 0;
			for (int ix = 0; ix < data.length; ix++) {
				int value = codes[data[ix] & 0xFF];
				if (value >= 0) {
					accum <<= 6;
					shift += 6;
					accum |= value;
					if (shift >= 8) {
						shift -= 8;
						out[index++] = (byte) ((accum >> shift) & 0xff);
					}
				}
			}
			if (index != out.length)
				throw new Error("miscalculated data length!");
			return out;
		}
	}
}
