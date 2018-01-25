package com.xh.encryption;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class AESEncryption extends Encryption {



	@Override
	public byte[] decryption(byte[] buffs, byte[] decryptionKey)
			throws Exception {
		// TODO Auto-generated method stub
		 KeyGenerator kgen = KeyGenerator.getInstance("AES");  
         kgen.init(128, new SecureRandom(decryptionKey));  
         SecretKey secretKey = kgen.generateKey();  
         byte[] enCodeFormat = secretKey.getEncoded();  
         SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");              
         Cipher cipher = Cipher.getInstance("AES");// 创建密码器  
         cipher.init(Cipher.DECRYPT_MODE, key);// 初始化  
         byte[] result = cipher.doFinal(buffs);  
         return result; // 加密  
	}


	@Override
	public byte[] encryption(byte[] encrypionText, byte[] encrypionKey)
			throws Exception {
		// TODO Auto-generated method stub
            KeyGenerator kgen = KeyGenerator.getInstance("AES");  
            kgen.init(128, new SecureRandom(encrypionKey));  
            SecretKey secretKey = kgen.generateKey();  
            byte[] enCodeFormat = secretKey.getEncoded();  
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");  
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器  
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化  
            byte[] result = cipher.doFinal(encrypionText);  
            return result; // 加密  
	}
}
