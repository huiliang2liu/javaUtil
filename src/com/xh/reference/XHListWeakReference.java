package com.xh.reference;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * 
 * ÈõÒıÓÃ
 * 
 * @param <T>
 */
final class XHListWeakReference<T> extends XHListRefrence<T> {

	@Override
	public Reference<T> getReference(T t) {
		// TODO Auto-generated method stub
		return new WeakReference<T>(t);
	}

}
