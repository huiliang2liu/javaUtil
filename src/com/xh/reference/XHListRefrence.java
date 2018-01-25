package com.xh.reference;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;

public abstract class XHListRefrence<T> implements XHRefrence<T> {
	 List<Reference<T>> list;
    /**
     * 不可用
     */
	@Override @Deprecated
	public void add(Object key, T t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		if(list==null)
			list=new ArrayList<Reference<T>>();
		list.add(getReference(t));
	}
	
	public void delete(T t){
		if(list!=null)
			list.remove(t);
	}
	public void delete(int index){
		if(list!=null)
			list.remove(index);
	}
	/**
	 * 更新数据
	 * @param index
	 * @param t
	 */
    public void update(int index,T t){
    	if(list==null||index>=list.size()){
    		add(t);
    		return;
    	}
    	if(index<list.size()){
    		list.set(index, getReference(t));
    		return;
    	}
    }
    public int size(){
    	if(list!=null)
    	return list.size();
    	return 0;
    }
    /**
     * 不可用
     */
	@Override @Deprecated
	public T get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(int key) {
		// TODO Auto-generated method stub
		if (list!=null&&key < list.size() && key > -1) {
			T t = list.get(key).get();
			if (t == null)
				list.remove(key);
			return t;
		}
		return null;
	}

}
