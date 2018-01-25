package com.xh.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

import com.xh.json.JSONArray;
import com.xh.json.JSONObject;
import com.xh.reflect.ClassManager;

public class Json2Object {
	public static Object JSONObject2Object(Class c, JSONObject jo) {
		try {
			if (c == null || jo == null || jo.length() == 0)
				return null;
			Object t = ClassManager.new_object(c);
			Field[] fields = c.getDeclaredFields();
			if (fields != null || fields.length > 0) {
				for (Field field : fields) {
					if (!field.isAccessible())
						field.setAccessible(true);
					if (is_final(field.getModifiers()))
						continue;
					Object object = get_key(jo, field.getName());
					if (object == null)
						continue;
					if (object instanceof JSONObject) {
						field.set(t, JSONObject2Object(field.getType(),
								(JSONObject) object));
					} else if (object instanceof JSONArray) {
						field.set(t, JSONArray2Object(field.getType(), (JSONArray)object));
					} else
						field.set(t, object);
				}
			}
			return t;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static Object JSONObject2Object1(Class c, JSONObject jo) {
		try {
			if (c == null || jo == null || jo.length() == 0)
				return null;
			Object t = ClassManager.new_object(c);
			Iterator<String> keys=jo.keys();
			if(keys==null)
				return t;
			while (keys.hasNext()) {
				String key=keys.next();
				Field field=c.getDeclaredField(key);
				if(field==null||is_final(field.getModifiers()))
					continue;
				if (!field.isAccessible())
					field.setAccessible(true);
				Object object = get_key(jo, key);
				if (object instanceof JSONObject) {
					field.set(t, JSONObject2Object(field.getType(),
							(JSONObject) object));
				} else if (object instanceof JSONArray) {
					field.set(t, JSONArray2Object(field.getType(), (JSONArray)object));
				} else
					field.set(t, object);
			}
			return t;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static Object JSONArray2Object(Class c, JSONArray ja)
			throws Exception {
		if (c == null || ja == null || ja.length() == 0)
			return null;
		Class cl = null;
		boolean is_l = false;
		if (c.getName().indexOf("[L") == 0) {
			cl = Class.forName(c.getName().substring(2, c.getName().length()));
			is_l = true;
		} else {
			Type parameterizedType = cl.getGenericSuperclass();
			if (parameterizedType instanceof ParameterizedType) {
				ParameterizedType pt = (ParameterizedType) parameterizedType;
				cl = (Class) pt.getActualTypeArguments()[0];
			} else
				return null;
		}
		ArrayList list = new ArrayList();
		for (int i = 0; i < ja.length(); i++) {
			Object object = ja.get(i);
			if (object instanceof JSONObject)
				list.add(JSONObject2Object(cl, (JSONObject) object));
			else
				list.add(object);
		}
		return is_l ? list.toArray() : list;
	}

	public static Object get_key(JSONObject jo, String key) {
		try {
			return jo.get(key);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 是否被static修饰
	 * 
	 * @param modifiers
	 * @return
	 */
	public static boolean is_final(int modifiers) {
		return Modifier.isFinal(modifiers);
	}


	/**
	 * 判断是否为boolean类型
	 * 
	 * @param cl
	 * @return
	 */
	public static boolean is_boolean(Class cl) {
		return Boolean.class.isAssignableFrom(cl);
	}

	/**
	 * 判断整型
	 * 
	 * @param cl
	 * @return
	 */
	public static boolean is_integer(Class cl) {
		return Byte.class.isAssignableFrom(cl)
				|| Short.class.isAssignableFrom(cl)
				|| Integer.class.isAssignableFrom(cl)
				|| Long.class.isAssignableFrom(cl);
	}

	/**
	 * 判断浮点型
	 * 
	 * @param cl
	 * @return
	 */
	public static boolean is_float(Class cl) {
		return Float.class.isAssignableFrom(cl)
				|| Double.class.isAssignableFrom(cl);
	}

	/**
	 * 判断是是否为字符
	 * 
	 * @param cl
	 * @return
	 */
	public static boolean is_char(Class cl) {
		return Character.class.isAssignableFrom(cl);
	}
}
