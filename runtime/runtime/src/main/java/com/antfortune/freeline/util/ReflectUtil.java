package com.antfortune.freeline.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectUtil {

    public static Object invokeMethod(String className, String methodName,Class[] cls,
                                      Object[] args) throws Exception {
        Class clazz = Class.forName(className);
        return invokeMethod(clazz, null, methodName, cls, args);
    }

    public static Object invokeMethod(Object object, String methodName, Class[] cls,
                                      Object[] args) throws Exception {
        Class clazz = object.getClass();
        return invokeMethod(clazz, object, methodName, cls, args);
    }

    public static Object invokeMethod(Object object, String methodName) throws Exception {
        Class clazz = object.getClass();
        return invokeMethod(clazz, object, methodName, null, null);
    }

    public static Object invokeMethod(Class clazz, Object object, String methodName, Class[] cls,
                                      Object[] args) throws Exception {
        Method method;
        if (null == cls) {
            method = clazz.getMethod(methodName);
        } else {
            method = clazz.getMethod(methodName, cls);
        }

        method.setAccessible(true);

        if (null == args) {
            return method.invoke(object);
        } else {
            return method.invoke(object, args);
        }
    }

    public static Field fieldGetOrg(Object object, String name) throws Exception {
        Field field = object.getClass().getDeclaredField(name);
        field.setAccessible(true);
        return field;
    }

    public static Field fieldGetOrg(Object object, Class<?> clazz, String name) throws Exception
    {
        Field field = clazz.getDeclaredField(name);
        field.setAccessible(true);
        return field;
    }

    public static void fieldSet(Object object, String fieldName, Object value)
            throws Exception {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }

    public static void fieldSet(Object object, Class<?> clazz, String fieldName,
                                Object value) throws Exception {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }

    public static Object fieldGet(Object object, String fieldName) throws Exception {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }

    public static Object fieldGet(Object object, Class<?> clazz, String fieldName)
            throws Exception {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }
}
