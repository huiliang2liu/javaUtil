package com.xh.classload;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * �������������
 * author:xh 
 * email:825378291@qq.com
 * time��2017-2-10 ����10:51:29
 *
 */
public class ClassLoaderManager {
	/**
	 * ��ȡ�������������
	 * author:xh
	 * email:825378291@qq.com
	 * time:2017-2-10 ����10:52:05
	 * @return
	 * @throws SecurityException
	 */
    @SuppressWarnings("unchecked")
	public static ClassLoader getContextClassLoader() throws SecurityException{
    	return (ClassLoader)
    		AccessController.doPrivileged(new PrivilegedAction() {
    	    public Object run() {
                    ClassLoader cl = null;
                    //try {
                    cl = Thread.currentThread().getContextClassLoader();
                    //} catch (SecurityException ex) { }
                    
                    if (cl == null)
                        return getSystemClassLoader();
                    
                    return cl;
                }
            });
        }
    /**
     * ��ȡϵͳ�������
     * author:xh
     * email:825378291@qq.com
     * time:2017-2-10 ����10:53:50
     * @return
     */
    public static ClassLoader getSystemClassLoader(){
    	return ClassLoader.getSystemClassLoader();
    }
}
