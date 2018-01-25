package com.xh.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 *���ֳ�����
 */
public class NumUtil {
	/**
	 * �Ƿ�Ϊż��
	 * 
	 * @param num
	 * @return
	 */
	public static boolean is_even_number(long num) {
		return num % 2 == 0;
	}

	/**
	 * �Ƿ�Ϊ����
	 * 
	 * @param num
	 * @return
	 */
	public static boolean is_uneven_number(long num) {
		return !is_even_number(num);
	}

	/**
	 * �Ƿ�Ϊ����
	 * 
	 * @param num
	 * @return
	 */
	public static boolean is_composite_number(long num) {
		if (num < 4)
			return false;
		for (long i = 2; i < num; i++) {
			if (num % i == 0)
				return true;
		}
		return false;
	}

	/**
	 * �Ƿ�Ϊ����
	 * 
	 * @param num
	 * @return
	 */
	public static boolean is_uncomposite_number(long num) {
		return !is_composite_number(num);
	}

	/**
	 * ��ȡ���е�����
	 * 
	 * @param num
	 * @return
	 */
	public static List<Long> factors(long num) {
		List<Long> factors = new ArrayList<Long>();
		for (long i = 1; i < num + 1; i++) {
			if (num % i == 0)
				factors.add(i);
		}
		return factors;
	}

	/**
	 * �Ƿ���
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static boolean relatively_prime(long num1, long num2) {
		if (max_common_divisor(num1, num2) == 1)
			return true;
		return false;
	}

	/**
	 * ��Լ��
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static List<Long> common_divisors(long num1, long num2) {
		List<Long> common_divisors = new ArrayList<Long>();
		for (long i = 1; i < (num1 > num2 ? num2 : num1) + 1; i++) {
			if (num1 % i == 0 && num2 % i == 0)
				common_divisors.add(i);
		}
		return common_divisors;
	}

	/**
	 * ���Լ��
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static long max_common_divisor(long num1, long num2) {
		if (num1 == 0)
			return num2;
		if (num2 == 0)
			return num1;
		return num1 > num2 ? max_common_divisor(num2, num1 % num2)
				: max_common_divisor(num1, num2 % num1);
	}

	/**
	 * �����֮�ڵĺ����������������
	 * 
	 * @param num
	 * @return
	 */
	public static List<Long> composite_numbers(long num) {
		List<Long> composite_numbers = new ArrayList<Long>();
		for (long i = 1; i < num + 1; i++) {
			if (is_composite_number(i))
				composite_numbers.add(i);
		}
		return composite_numbers;
	}

	/**
	 * �����֮�ڵ������������������
	 * 
	 * @param num
	 * @return
	 */
	public static List<Long> uncomposite_numbers(long num) {
		List<Long> uncomposite_numbers = new ArrayList<Long>();
		for (long i = 2; i < num + 1; i++) {
			if (is_uncomposite_number(i))
				uncomposite_numbers.add(i);
		}
		return uncomposite_numbers;
	}

	/**
	 * �����֮��������֮���ʵ���
	 * 
	 * @param num
	 * @return
	 */
	public static List<Integer> relatively_prime_numbers(int num) {
		List<Integer> relatively_prime_numbers = new ArrayList<Integer>();
		for (int i = 1; i < num; i++) {
			if (relatively_prime(i, num))
				relatively_prime_numbers.add(i);
		}
		return relatively_prime_numbers;
	}

	public static int mode(int divisor, int dividend) {
		if (divisor == 0)
			throw new RuntimeException("divisor=0");
		if (dividend > 0)
			return dividend % divisor;
		int mode = dividend % divisor;
		return mode == 0 ? mode : mode + divisor;
	}

	public static void main(String[] args) throws UnknownHostException {
//		Map<String, Object> map=new TreeMap<String, Object>();
//		map.put("code", 1);
//		map.put("msg", "msg");
//		List<People> peoples=new ArrayList<People>();
//		for (int i = 0; i < 5; i++) {
//			People people=new People();
//			people.setIs_bind(i%2==0);
//			peoples.add(people);
//		}
//		map.put("list", peoples);
//		map.put("people", new People());
		System.out.println(InetAddress.getLocalHost().getHostAddress());
	}
	public static class People{
		String name="С��";
		int age=25;
		float height=1.65f;
		boolean is_bind=true;
		public boolean isIs_bind() {
			return is_bind;
		}
		public void setIs_bind(boolean isBind) {
			is_bind = isBind;
		}
		
	}
}
