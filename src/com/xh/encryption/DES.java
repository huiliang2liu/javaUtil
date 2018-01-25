package com.xh.encryption;

public class DES {
//	private String clean;
//	private String cipher;
	private String secret_key;
	private Secretkey secretkey;
	public DES() {
		// TODO Auto-generated constructor stub
	}
	public DES(String secret_key) {
		// TODO Auto-generated constructor stub
		this.secret_key=secret_key;
		secretkey=new Secretkey(secret_key);
	}
	public DES(Secretkey secretkey) {
		// TODO Auto-generated constructor stub
		this.secretkey=secretkey;
		secret_key=secretkey.getKey();
	}
	public String getSecret_key() {
		return secret_key;
	}
	public void setSecret_key(String secretKey) {
		secret_key = secretKey;
	}
	public Secretkey getSecretkey() {
		return secretkey;
	}
	public void setSecretkey(Secretkey secretkey) {
		this.secretkey = secretkey;
	}
	/**
	 * ¼ÓÃÜ
	 * @param clear
	 * @return
	 */
    public String encryption(String clear){
    	return null;
    }
}
