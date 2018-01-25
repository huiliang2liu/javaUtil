package com.xh.encryption;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import com.xh.string.Base64;

public  class AsymmetricEncryption  {  
    public static final String KEY_ALGORITHM = "RSA";  
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";  
  
    private static final String PUBLIC_KEY = "RSAPublicKey";  
    private static final String PRIVATE_KEY = "RSAPrivateKey";  
  
    /** 
     * ��˽Կ����Ϣ��������ǩ�� 
     *  
     * @param data 
     *            �������� 
     * @param privateKey 
     *            ˽Կ 
     *  
     * @return 
     * @throws Exception 
     */  
    public static String sign(byte[] data, String privateKey) throws Exception {  
        // ������base64�����˽Կ  
        byte[] keyBytes = Base64.decode(privateKey, 0);  
  
        // ����PKCS8EncodedKeySpec����
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

		// KEY_ALGORITHM ָ���ļ����㷨
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		// ȡ˽Կ�׶���
		PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

		// ��˽Կ����Ϣ��������ǩ��
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(priKey);
		signature.update(data);

		return Base64.encodeToString(signature.sign(), 0);
	}

	/**
	 * У������ǩ��
	 * 
	 * @param data
	 *            ��������
	 * @param publicKey
	 *            ��Կ
	 * @param sign
	 *            ����ǩ��
	 * 
	 * @return У��ɹ�����true ʧ�ܷ���false
	 * @throws Exception
	 * 
	 */
	public static boolean verify(byte[] data, String publicKey, String sign)
			throws Exception {

		// ������base64����Ĺ�Կ
		byte[] keyBytes = Base64.decode(publicKey, 0);

		// ����X509EncodedKeySpec����
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

		// KEY_ALGORITHM ָ���ļ����㷨
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		// ȡ��Կ�׶���
		PublicKey pubKey = keyFactory.generatePublic(keySpec);

		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(pubKey);
		signature.update(data);

		// ��֤ǩ���Ƿ�����
		return signature.verify(Base64.decode(sign, 0));
	}

	/**
	 * ����<br>
	 * ��˽Կ����
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(byte[] data, byte[] key)
			throws Exception {
		// ����Կ����
		byte[] keyBytes = Base64.decode(key, 0);

		// ȡ��˽Կ
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

		// �����ݽ���
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);

		return cipher.doFinal(data);
	}
	/**
	 * ����<br>
	 * ��˽Կ����
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decryptByPrivateKey(String data, String key)
			throws Exception {
		return new String(decryptByPrivateKey(SimpleEncryption.parseHexStr2Byte(data), key.getBytes("utf-8")),"utf-8");
	}

	/**
	 * ����<br>
	 * �ù�Կ����
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] data, byte[] key)
			throws Exception {
		// ����Կ����
		byte[] keyBytes = Base64.decode(key, 0);

		// ȡ�ù�Կ
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicKey = keyFactory.generatePublic(x509KeySpec);

		// �����ݽ���
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicKey);

		return cipher.doFinal(data);
	}
	/**
	 * ����<br>
	 * �ù�Կ����
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decryptByPublicKey(String data, String key)
			throws Exception {
		return new String(decryptByPublicKey(SimpleEncryption.parseHexStr2Byte(data), key.getBytes("utf-8")),"utf-8");
	}
	/**
	 * ����<br>
	 * �ù�Կ����
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data, byte[] key)
			throws Exception {

		// ȡ�ù�Կ
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64
				.decode(key, 0));
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicKey = keyFactory.generatePublic(x509KeySpec);

		// �����ݼ���
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(data);
	}
	/**
	 * ����<br>
	 * �ù�Կ����
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptByPublicKey(String data, String key)
			throws Exception {
	return SimpleEncryption.parseByte2HexStr(encryptByPublicKey(data.getBytes("utf-8"), key.getBytes("utf-8")));
	}

	/**
	 * ����<br>
	 * ��˽Կ����
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(byte[] data, byte[] key)
			throws Exception {
		// ����Կ����
		byte[] keyBytes = Base64.decode(key, 0);

		// ȡ��˽Կ
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

		// �����ݼ���
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);

		return cipher.doFinal(data);
	}
	/**
	 * ����<br>
	 * ��˽Կ����
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static  String encryptByPrivateKey(String data, String key)
			throws Exception {
	return SimpleEncryption.parseByte2HexStr(encryptByPrivateKey(data.getBytes("utf-8"), key.getBytes("utf-8")));
	}

	/**
	 * ȡ��˽Կ
	 * 
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPrivateKey(Map<String, Object> keyMap)
			throws Exception {
		Key key = (Key) keyMap.get(PRIVATE_KEY);
		return Base64.encodeToString(key.getEncoded(), 0);
	}

	/**
	 * ȡ�ù�Կ
	 * 
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPublicKey(Map<String, Object> keyMap)
			throws Exception {
		Key key = (Key) keyMap.get(PUBLIC_KEY);

		return Base64.encodeToString(key.getEncoded(), 0);
	}

	/**
	 * ��ʼ����Կ
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> initKey() throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator
				.getInstance(KEY_ALGORITHM);
		keyPairGen.initialize(1024);

		KeyPair keyPair = keyPairGen.generateKeyPair();

		// ��Կ
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

		// ˽Կ
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

		Map<String, Object> keyMap = new HashMap<String, Object>(2);

		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);
		return keyMap;
	}
}