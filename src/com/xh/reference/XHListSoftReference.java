package com.xh.reference;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

/**
 * 
 * »Ì“˝”√
 * 
 * @param <T>
 */
final class XHListSoftReference<T> extends XHListRefrence<T> {
	@Override
	public Reference<T> getReference(T t) {
		// TODO Auto-generated method stub
		return new SoftReference<T>(t);
	}

}
