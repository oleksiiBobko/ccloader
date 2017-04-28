package org.classes.ccloader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class App {
    
    public static void main(String args[]) throws Exception {

        CCLoader ccl = new CCLoader(App.class.getClassLoader());
        Class<?> clazz = ccl.loadClass("org.classes.ccloader.Foo");
        Method m = clazz.getMethod("inc", new Class<?>[0]);
        Object o = clazz.newInstance();
        m.invoke(o, new Object[0]);
        Field f = clazz.getField("i");
        int i = f.getInt(o);
        
        
        CCLoader ccl1 = new CCLoader(App.class.getClassLoader());
        Class<?> clazz1 = ccl1.loadClass("org.classes.ccloader.Foo");
        Object o1 = clazz1.newInstance();
        Field f1 = clazz1.getField("i");
        int i1 = f1.getInt(o1);
        
        System.out.println("clazz i = " + i + " clazz1 i = " + i1);
        
    }
}
