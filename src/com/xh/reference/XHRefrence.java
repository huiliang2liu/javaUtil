package com.xh.reference;

import java.lang.ref.Reference;

interface XHRefrence<T> {
	/**
	 * ��ӻ���
	 * 
	 * @param key
	 * @param t
	 */
	public void add(Object key, T t);

	/**
	 * ��ȡ�����е�����
	 * 
	 * @param key
	 * @return
	 */
	public T get(Object key);
	/**
	 * ��ӻ���
	 * 
	 * @param key
	 * @param t
	 */
	public void add(T t);

	/**
	 * ��ȡ�����е�����
	 * 
	 * @param key
	 * @return
	 */
	public T get(int key);
	/**
	 * ��ȡ������
	 * @param t
	 * @return
	 */
	 Reference<T> getReference(T t);
}
