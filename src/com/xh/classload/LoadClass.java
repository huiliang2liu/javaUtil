package com.xh.classload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Properties;

import com.xh.reflect.ClassManager;
import com.xh.util.Resource;


/**
 * author:xh 
 * email:825378291@qq.com
 * time：2017-2-10 上午10:46:00
 *
 */
public class LoadClass {
	  static boolean firstTime = true;
	    static Properties cacheProps = new Properties();
	/**
	 * 获取是否含有指定的类
	 * author:xh
	 * email:825378291@qq.com
	 * time:2017-2-10 上午10:47:31
	 * @param propName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static String getSystemProperty(final String propName) {
			return (String)
		            AccessController.doPrivileged(new PrivilegedAction() {
		                public Object run() {
		                    return System.getProperty(propName);
		                }
		            });
		    }
	/**
	 * 
	 * author:xh
	 * email:825378291@qq.com
	 * time:2017-2-10 下午02:21:28
	 * @param factoryId
	 * @param fallbackClassName
	 * @return
	 * @throws Exception
	 */
    static Object find(String factoryId, String fallbackClassName)
    throws Exception
{        
    // Use the system property first
    try {
        String systemProp = getSystemProperty(factoryId);
        if (systemProp != null) {                
            return ClassManager.new_object(name2class(factoryId, null));
        }
    } 
    catch (SecurityException se) {
    }

    // try to read from $java.home/lib/jaxp.properties
    try {
        String factoryClassName = null;
        if (firstTime) {
            synchronized (cacheProps) {
                if (firstTime) {
                    String configFile = getSystemProperty("java.home") + File.separator +
                        "lib" + File.separator + "jaxp.properties";
                    File f = new File(configFile);
                    firstTime = false;
                    if (doesFileExist(f)) {
                        cacheProps.load(getFileInputStream(f));
                    }
                }
            }
        }
        factoryClassName = cacheProps.getProperty(factoryId);            

        if (factoryClassName != null) {
            return ClassManager.new_object(name2class(factoryClassName, null));
        }
    } 
    catch (Exception ex) {
    }

    // Try Jar Service Provider Mechanism
    Object provider = findJarServiceProvider(factoryId);
    if (provider != null) {
        return provider;
    }
    if (fallbackClassName == null) {
    	return null;
    }
    
    return ClassManager.new_object(name2class(fallbackClassName, null));
}
    @SuppressWarnings("unchecked")
	static FileInputStream getFileInputStream(final File file)
    throws FileNotFoundException
{
try {
        return (FileInputStream)
            AccessController.doPrivileged(new PrivilegedExceptionAction() {
                public Object run() throws FileNotFoundException {
                    return new FileInputStream(file);
                }
            });
} catch (PrivilegedActionException e) {
    throw (FileNotFoundException)e.getException();
}
}
	/**
	 * 将名字转化为class
	 * author:xh
	 * email:825378291@qq.com
	 * time:2017-2-10 下午12:01:00
	 * @param className
	 * @param cl
	 * @param doFallback
	 * @return
	 * @throws ClassNotFoundException
	 */
	 @SuppressWarnings("unchecked")
	public static Class name2class(String className, ClassLoader cl) throws ClassNotFoundException 
	    {
	        try {
	            if (cl == null) {
	                cl = ClassLoaderManager.getContextClassLoader();
	                if (cl == null) {
	                    throw new ClassNotFoundException();
	                }
	                else {
	                    return cl.loadClass(className);
	                }
	            } 
	            else {
	                return cl.loadClass(className);
	            }
	        }
	        catch (ClassNotFoundException e1) {
	                // Use current class loader - should always be bootstrap CL
	                return Class.forName(className, true, LoadClass.class.getClassLoader());
	        }    
	    }
	   @SuppressWarnings("unchecked")
	static boolean doesFileExist(final File f) {
	        return ((Boolean)
	                AccessController.doPrivileged(new PrivilegedAction() {
	                    public Object run() {
	                        return new Boolean(f.exists());
	                    }
	                })).booleanValue();
	        }
	    private static Object findJarServiceProvider(String factoryId)
        throws Exception 
    {
        String serviceId = "META-INF/services/" + factoryId;
        InputStream is = null;
        
        // First try the Context ClassLoader
        ClassLoader cl = ClassLoaderManager.getContextClassLoader();
        if (cl != null) {
            is = Resource.getResourceAsStream(cl, serviceId);
            
            // If no provider found then try the current ClassLoader
            if (is == null) {
                cl = LoadClass.class.getClassLoader();                
                is = Resource.getResourceAsStream(cl, serviceId);
            }
        } else {
            // No Context ClassLoader, try the current ClassLoader
            cl = LoadClass.class.getClassLoader();
            is = Resource.getResourceAsStream(cl, serviceId);
        }
        
        if (is == null) {
            // No provider found
            return null;
        }
        
        BufferedReader rd;
        try {
            rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        } 
        catch (java.io.UnsupportedEncodingException e) {
            rd = new BufferedReader(new InputStreamReader(is));
        }
        
        String factoryClassName = null;
        try {
            // XXX Does not handle all possible input as specified by the
            // Jar Service Provider specification
            factoryClassName = rd.readLine();
            rd.close();
        } catch (IOException x) {
            // No provider found
            return null;
        }
        
        if (factoryClassName != null && !"".equals(factoryClassName)) {
            
            // Note: here we do not want to fall back to the current
            // ClassLoader because we want to avoid the case where the
            // resource file was found using one ClassLoader and the
            // provider class was instantiated using a different one.
            return ClassManager.new_object(name2class(factoryClassName, cl));
        }
        
        // No provider found
        return null;
    }
}
