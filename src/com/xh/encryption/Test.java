package com.xh.encryption;


import com.xh.encryption.AESEncryption;
import com.xh.encryption.AsymmetricEncryption;
import com.xh.encryption.DESEncryption;



public class Test {
public static void main(String[] args) throws Exception {
	String key="������������������������������������������������������������";
	AESEncryption aesEncryption=new AESEncryption();
	String text="������������������������������������������������������������������������";
	text=aesEncryption.encryption(text, key);
	System.out.println(text);
	text=aesEncryption.decryption(text, key);
	System.out.println(text);
	DESEncryption desEncryption=new DESEncryption();
	text=desEncryption.encryption(text, key);
	System.out.println(text);
	text=desEncryption.decryption(text, key);
	System.out.println(text);
	String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCKEW8cLjDQJeq+yRn7RIwx3V7bPF+tGACauVwklvkrZb7D19k+lOgK1Fgnl7bXuBkvyLGTf8QoFkdDG1criGCGhs8ulKR1cKPxzIDw6GtYUyqizgndxYUIthO+8Jj+R1ph0X4Ej0FtinKSpMulpdhDOVeR2d6WEYoPBZVnN59//wIDAQAB";
	String privateKey="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIoRbxwuMNAl6r7JGftEjDHdXts8X60YAJq5XCSW+StlvsPX2T6U6ArUWCeXtte4GS/IsZN/xCgWR0MbVyuIYIaGzy6UpHVwo/HMgPDoa1hTKqLOCd3FhQi2E77wmP5HWmHRfgSPQW2KcpKky6Wl2EM5V5HZ3pYRig8FlWc3n3//AgMBAAECgYAFOpfMp2st1uHHC/Kx82yjztBy2Rx+f7Q2J+L3d8hD/nx1Ck2t8xG+p0AXb8V68fvyNVWUUnhpVD6qqfRpL6cIIrPicChNAgjcltzPzu0C0rX/zPyGIo3VrKFL/1t96dZyUF9jI1g8cMYjuwEbiJW7MBqlXMxFm7xGS5SEvtJQ8QJBAOb33yAMCoPqCffiC/oazHB72LuHHwJGElm52ZKmk0rm00ee7Dan012fAmP4YhLvia+pXUefrPWdBzx+o/t7FPsCQQCZCBUSiJ6q70TkxdAfiETzuDnG+hGUAn9JRdJSPcmIsDBjU7JdnYs35+8GxczJCBqCRXer3OIYOY8fpRDdwqnNAkEAvrF2QgJPCDzKACRc2SEZG+HUvnfALWNnMTeVoFPxlkzfselPg4yqoUhwc9OWPaYR2ruNrV3zMlJ0sAirIS2s0wJARTtL1TurlKd0oo7/bhSHJT+WG/esFirfDPYihYRgdY9IBNernQCWKC+sioLX96bL312wGzdtrgn0Pxu9OqZDjQJAJcyxPJzdVHhi+W1ZYklXeUEQI+iEGmI92DqUUFGWbkF7Me0F1kfGHtRTQlhJbhLTK/J5lMXcXoiS6BebEkntqg==";
	System.err.println("��Կ���ܡ���˽Կ����");

	text= AsymmetricEncryption.encryptByPublicKey(text,
			publicKey);
	System.out.println("���ܺ�:" +text);
	text = AsymmetricEncryption.decryptByPrivateKey(
			text, privateKey);

	System.err.println("���ܺ�: " + text);
	
	
	System.err.println("˽Կ���ܡ�����Կ����");

	text = AsymmetricEncryption.encryptByPrivateKey(text,
			privateKey);
	System.out.println("���ܺ�:" + text);
	text = AsymmetricEncryption.decryptByPublicKey(
			text, publicKey);

	System.err.println("���ܺ�: " + text);

	System.err.println("˽Կǩ��������Կ��֤ǩ��");
	// ����ǩ��
	String sign = AsymmetricEncryption.sign(text.getBytes(), privateKey);
	System.err.println("ǩ��:\r" + sign);

	// ��֤ǩ��
	boolean status = AsymmetricEncryption.verify(text.getBytes(), publicKey,
			sign);
	System.err.println("״̬:\r" + status);

}
/**��������ת����16���� 
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
}
