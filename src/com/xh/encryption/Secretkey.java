package com.xh.encryption;

import java.util.ArrayList;
import java.util.List;


public class Secretkey {
	private List<byte[]> keys;
    private String key;
	public Secretkey(String key){
		// TODO Auto-generated constructor stub
		this(key.getBytes());
	}


	public Secretkey(byte[] buff) {
		// TODO Auto-generated constructor stub
		key=new String(buff);
		if (buff.length % 64 != 0)
			throw new RuntimeException("len mode 64 !=0");
		keys = new ArrayList<byte[]>();
		byte[] b56 = generate_key56(buff);
		for (int i = 1; i < 17; i++) {
			System.out.println(new String(b56));
			b56 = translation(b56, i);
			System.out.println(new String(b56));
			keys.add(generate_key48(b56));
		}
	}

	public String getKey() {
		return key;
	}


	/**
	 * 生成密钥
	 * 
	 * @param buff
	 * @param i
	 * @return
	 */
	private byte[] generate_key48(byte[] buff) {
		// TODO Auto-generated method stub
		int len = buff.length / 56;
		byte[] b = new byte[len * 48];
		byte[] bs = new byte[56];
		for (int j = 0; j < len; j++) {
			System.arraycopy(buff, j * 56, bs, 0, 56);
			System.arraycopy(projection48(bs), 0, b, j * 48, 48);
		}
		return b;
	}

	/**
	 * 密钥投射
	 * 
	 * @param bs
	 * @return
	 */
	private byte[] projection48(byte[] bs) {
		// TODO Auto-generated method stub
		byte[] buff = new byte[48];
		for (int i = 0; i < 48; i++) {
			buff[i] = bs[Util.PC_2[i] - 1];
		}
		return buff;
	}

	/**
	 * 平移
	 * 
	 * @param b56
	 * @param i
	 * @return
	 */
	private byte[] translation(byte[] b56, int i) {
		// TODO Auto-generated method stub
		for (int j = 0; j < b56.length; j++) {
			b56[j] = (byte) ((i == 1 || i == 2 || i == 9 || i == 16) ? b56[j] >> 1
					: b56[j] >> 2);
		}
		return b56;
	}

	/**
	 * 生成密钥
	 * 
	 * @param buff
	 * @param i
	 * @return
	 */
	private byte[] generate_key56(byte[] buff) {
		// TODO Auto-generated method stub
		int len = buff.length / 64;
		byte[] b = new byte[len * 56];
		byte[] bs = new byte[64];
		for (int j = 0; j < len; j++) {
			System.arraycopy(buff, j * 64, bs, 0, 64);
			System.arraycopy(projection56(bs), 0, b, j * 56, 56);
		}
		return b;
	}

	/**
	 * 密钥投射
	 * 
	 * @param bs
	 * @return
	 */
	private byte[] projection56(byte[] bs) {
		// TODO Auto-generated method stub
		byte[] buff = new byte[56];
		for (int i = 0; i < 56; i++) {
			buff[i] = bs[Util.PC_1[i] - 1];
		}
		return buff;
	}

	public List<byte[]> getKeys() {
		return keys;
	}

	public static void main(String[] args) {
		String key = "abdefghijklmnopqrstuvwxyzabdefghijklmnopqrstuvwxyz0123456789*+/%";
		byte[] b = key.getBytes();
		System.out.println(b.length);
		Secretkey secretkey = new Secretkey(key.getBytes());
		List<byte[]> bs = secretkey.getKeys();
//		for (byte[] cs : bs) {
//			System.out.println(new String(cs));
//		}
	}
}
