package com.xh.encryption;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/*
 *DES 加密
 */
public class DESEncryption extends Encryption {

	@Override
	public byte[] decryption(byte[] buffs, byte[] decryptionKey)
			throws Exception {
		// TODO Auto-generated method stub
		 // DES算法要求有一个可信任的随机数源  
        SecureRandom random = new SecureRandom();  
        // 创建一个DESKeySpec对象  
        DESKeySpec desKey = new DESKeySpec(decryptionKey);  
        // 创建一个密匙工厂  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
        // 将DESKeySpec对象转换成SecretKey对象  
        SecretKey securekey = keyFactory.generateSecret(desKey);  
        // Cipher对象实际完成解密操作  
        Cipher cipher = Cipher.getInstance("DES");  
        // 用密匙初始化Cipher对象  
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);  
        // 真正开始解密操作  
        return cipher.doFinal(buffs);  
	}

	@Override
	public byte[] encryption(byte[] encrypionText, byte[] encrypionKey)
			throws Exception {
		// TODO Auto-generated method stub
		 SecureRandom random = new SecureRandom();  
	        DESKeySpec desKey = new DESKeySpec(encrypionKey);  
	        //创建一个密匙工厂，然后用它把DESKeySpec转换成  
	        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
	        SecretKey securekey = keyFactory.generateSecret(desKey);  
	        //Cipher对象实际完成加密操作  
	        Cipher cipher = Cipher.getInstance("DES");  
	        //用密匙初始化Cipher对象  
	        cipher.init(Cipher.ENCRYPT_MODE, securekey, random);  
	        //现在，获取数据并加密  
	        //正式执行加密操作  
	        return cipher.doFinal(encrypionText); 
	}
}
