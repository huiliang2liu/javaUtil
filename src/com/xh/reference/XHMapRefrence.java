package com.xh.reference;

import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;



public abstract class XHMapRefrence<T> implements XHRefrence<T>{
	private Map<Object, Reference<T>> map;
	@Override
	public void add(Object key, T t) {
		// TODO Auto-generated method stub
		if(map==null)
			map=new TreeMap<Object, Reference<T>>();
		map.put(key, getReference(t));
	}

    /**
     * 不可用
     */
	@Override @Deprecated
	public void add(T t) {
		// TODO Auto-generated method stub
		
	}
   public void delete(T t){
	   if(map==null)
		   return;
	  if(map.containsValue(t)){
		  Set<Entry<Object, Reference<T>>> set=map.entrySet();
		  Iterator<Entry<Object, Reference<T>>> iterator=set.iterator();
		  while (iterator.hasNext()) {
			  Entry<Object, Reference<T>> entry=iterator.next();
			if(entry.getValue().get()==t){
				map.remove(entry.getKey());
			}
		}
	  }
   }
   public void delete(String key){
	   if(map==null)
		   return;
	  if(map.containsKey(key))
				map.remove(key);
   }
	@Override
	public T get(Object key) {
		// TODO Auto-generated method stub
		if (map!=null&&map.containsKey(key)) {
			T t = map.get(key).get();
			if (t == null)
				map.remove(key);
			return t;
		}
		return null;
	}

    /**
     * 不可用
     */
	@Override @Deprecated
	public T get(int key) {
		// TODO Auto-generated method stub
		return null;
	}

}
