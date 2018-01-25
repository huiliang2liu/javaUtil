package com.xh.reference;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
/**
 * 
 * ÈõÒıÓÃ
 * @param <T>
 */
final class XHMapWeakReference<T> extends XHMapRefrence<T> {

	@Override
	public Reference<T> getReference(T t) {
		// TODO Auto-generated method stub
		return new WeakReference<T>(t);
	}

}
