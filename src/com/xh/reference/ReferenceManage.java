package com.xh.reference;

public class ReferenceManage {
	/**
	 * 获取缓存实体
	 * @param <T>
	 * 
	 * @param type
	 * @return
	 */
	private static <T> XHRefrence<T> gRefrence(Type type) {
		return type.getXhRefrence();
	}

	/**
	 * 获取缓存实体
	 * 
	 * @param type
	 * @return
	 */
	public static <T> XHListSoftReference<T> gXhListSoftReference() {
		return (XHListSoftReference) gRefrence(Type.XHLIST_SOFT_REFERENCE);
	}

	/**
	 * 获取缓存实体
	 * 
	 * @param type
	 * @return
	 */
	public static <T> XHListWeakReference<T> gXhListWeakReference() {
		return (XHListWeakReference) gRefrence(Type.XHLIST_WEAK_REFERENCE);
	}

	/**
	 * 获取缓存实体
	 * 
	 * @param type
	 * @return
	 */
	public static <T> XHMapSoftReference<T> gXhMapSoftReference() {
		return (XHMapSoftReference) gRefrence(Type.XHMAP_SOFT_REFERENCE);
	}

	/**
	 * 获取缓存实体
	 * 
	 * @param type
	 * @return
	 */
	public static <T> XHMapWeakReference<T> gXhMapWeakReference() {
		return (XHMapWeakReference) gRefrence(Type.XHMAP_WEAK_REFERENCE);
	}

	/**
	 * 
	 * 缓存类型
	 */
	private enum Type {
		XHLIST_SOFT_REFERENCE(new XHListSoftReference()), XHLIST_WEAK_REFERENCE(
				new XHListWeakReference()), XHMAP_SOFT_REFERENCE(
				new XHMapSoftReference()), XHMAP_WEAK_REFERENCE(
				new XHMapWeakReference());
		private XHRefrence xhRefrence;

		private Type(XHRefrence xhRefrence) {
			// TODO Auto-generated constructor stub
			this.xhRefrence = xhRefrence;
		}

		public XHRefrence getXhRefrence() {
			return xhRefrence;
		}

	}
}
