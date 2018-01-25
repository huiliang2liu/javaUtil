package com.xh.reference;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

/**
 * 
 * ÈíÒıÓÃ
 * 
 * @param <T>
 */
final class XHMapSoftReference<T> extends XHMapRefrence<T> {

	@Override
	public Reference<T> getReference(T t) {
		// TODO Auto-generated method stub
		return new SoftReference<T>(t);
	}

}
