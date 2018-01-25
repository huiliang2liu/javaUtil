package com.xh.reference;

import java.lang.ref.Reference;

interface XHRefrence<T> {
	/**
	 * 添加缓存
	 * 
	 * @param key
	 * @param t
	 */
	public void add(Object key, T t);

	/**
	 * 获取缓存中的数据
	 * 
	 * @param key
	 * @return
	 */
	public T get(Object key);
	/**
	 * 添加缓存
	 * 
	 * @param key
	 * @param t
	 */
	public void add(T t);

	/**
	 * 获取缓存中的数据
	 * 
	 * @param key
	 * @return
	 */
	public T get(int key);
	/**
	 * 获取缓存器
	 * @param t
	 * @return
	 */
	 Reference<T> getReference(T t);
}
