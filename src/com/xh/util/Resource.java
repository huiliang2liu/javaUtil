package com.xh.util;

import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;

import com.xh.classload.ClassLoaderManager;

/**
 * author:xh email:825378291@qq.com time：2017-2-10 上午11:34:34
 * 
 */
public class Resource {
	/**
	 * 打开指定资源 author:xh email:825378291@qq.com time:2017-2-10 上午11:37:51
	 * 
	 * @param name
	 * @return
	 */
	public static InputStream getResourceAsStream(String name) {
		return getResourceAsStream(ClassLoaderManager.getContextClassLoader(),
				name);
	}

	/**
	 * 获取资源的url author:xh email:825378291@qq.com time:2017-2-10 上午11:39:35
	 * 
	 * @param name
	 * @return
	 */
	public static URL getResource(String name) {
		return getResource(ClassLoaderManager.getContextClassLoader(), name);
	}

	/**
	 * 打开指定资源 author:xh email:825378291@qq.com time:2017-2-10 上午10:58:31
	 * 
	 * @param cl
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static InputStream getResourceAsStream(final ClassLoader cl,
			final String name) {
		return (InputStream) AccessController
				.doPrivileged(new PrivilegedAction() {
					public Object run() {
						InputStream ris;
						if (cl == null) {
							ris = ClassLoader.getSystemResourceAsStream(name);
						} else {
							ris = cl.getResourceAsStream(name);
						}
						return ris;
					}
				});
	}

	/**
	 * 获取资源的url author:xh email:825378291@qq.com time:2017-2-10 上午11:38:15
	 * 
	 * @param cl
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static URL getResource(final ClassLoader cl, final String name) {
		return (URL) AccessController.doPrivileged(new PrivilegedAction() {
			public Object run() {
				URL ris;
				if (cl == null) {
					ris = ClassLoader.getSystemResource(name);
				} else {
					ris = cl.getResource(name);
				}
				return ris;
			}
		});
	}
	public static void main(String[] args) {
		String text="ni|hao|da|ye|";
		System.out.println(text.substring(0, text.lastIndexOf("|")));
		for (String string : text.substring(0, text.lastIndexOf("|")).split("\\|")) {
			System.out.println(string);
		}
	}
}
