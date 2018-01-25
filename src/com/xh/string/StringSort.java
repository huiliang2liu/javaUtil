package com.xh.string;

public class StringSort {
	/**
	 * √∞≈›≈≈–Ú
	 * 
	 * @param st
	 * @return
	 */
	public static String[] bubble_sort(String[] st) {
		if (st == null)
			return st;
		for (int i = 1; i < st.length; i++) {
			for (int j = 0; j < st.length - i; j++) {
				if (Util.comparator(st[j], st[j + 1])) {
					String sj = st[j];
					st[j] = st[j + 1];
					st[j + 1] = sj;
				}
			}
		}
		return st;
	}

	/**
	 * ÷±Ω”≈≈–Ú
	 * 
	 * @param st
	 * @return
	 */
	public static String[] directly_sort(String[] st) {
		if (st == null)
			return null;
		int index;
		for (int i = 0; i < st.length; i++) {
			index = 0;
			for (int j = 0; j < st.length - i; j++) {
				if (Util.comparator(st[j], st[index]))
					index = j;
			}
			String s = st[st.length - i - 1];
			st[st.length - i - 1] = st[index];
			st[index] = s;
		}
		return st;
	}
	/**
	 * ≤Â»Î≈≈–Ú
	 * 
	 */
	public static String[] insert_sort(String[] st) {
		if (st == null || st.length < 2)
			return st;
		String st1[] = new String[st.length];
		for (int i = 0; i < st1.length; i++) {
			String s = st[i];
			int index = Util.index_0618(st1, s);
			for (int j = i; j >= index; j--) {
				st1[j + 1] = st[j];
			}
			st1[index] = s;
		}
		return st1;
	}

	public static void main(String[] args) {
		String a[] = { "hui", "liang", "z", "liu", "xiao", "a" };
		a = directly_sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");
		}
	}
}
