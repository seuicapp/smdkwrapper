package com.seuic.mdm.api.uitl;

import com.seuic.mdm.api.base.SMDKResult;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public final class ReflectionTool {
    public static Object invokeConstructorMethod(String className, Class< ? >[] parameterTypes, Object[] args) {
        Object obj = null;
        try {
            Class cls = Class.forName(className);
            Constructor< ? > cons = cls.getConstructor(parameterTypes);
            obj = cons.newInstance(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * Call a static method that has a return value
     *
     * @param className      -
     * @param methodName     -
     * @param parameterTypes -
     * @param args           -
     * @return -
     */
    public static Object invokeStaticMethodWithReturn(String className, String methodName, Class< ? >[] parameterTypes, Object[] args) {
        Object obj = null;
        try {
            Class c = Class.forName(className);
            Method method = c.getMethod(methodName, parameterTypes);
            obj = method.invoke(null, args);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            Throwable throwable = e.getTargetException();
            throw new RuntimeException(throwable.getMessage());
        } catch (Exception e) {
            return null;
        }
        return obj;
    }

    /**
     * Call a static method with no return value
     *
     * @param className      -
     * @param methodName     -
     * @param parameterTypes -
     * @param args           -
     */
    public static void invokeStaticVoidMethod(String className, String methodName, Class< ? >[] parameterTypes, Object[] args) {
        try {
            Class c = Class.forName(className);
            Method method = c.getMethod(methodName, parameterTypes);
            method.invoke(null, args);
        } catch (InvocationTargetException e) {
            Throwable throwable = e.getTargetException();
            throw new RuntimeException(throwable.getMessage());
        } catch (Exception e) {
            throw null;
        }
    }

    //
//    /**
//     * Call a object method that has a return value
//     * @param targetObject   -
//     * @param methodName     -
//     * @param parameterTypes -
//     * @param args           -
//     * @param fieldClass     -
//     * @return -
//     */
    public static < T > T invokeDynamicMethodWithReturn(Object targetObject, String methodName, Class< ? >[] parameterTypes, Object[] args, Class< T > fieldClass) {
        T obj = null;
        try {
            Method method = targetObject.getClass().getMethod(methodName, parameterTypes);
            obj = (T) method.invoke(targetObject, args);
            if (obj == null && fieldClass.isAssignableFrom(List.class)) {
                obj = (T) new LinkedList();
            }
        } catch (InvocationTargetException e) {
            Throwable throwable = e.getTargetException();
            throw new RuntimeException(throwable.getMessage());
        } catch (Exception e) {
            return null;
        }
        return obj;
    }

    public static < T > T invokeDynamicMethodWithReturn(Object targetObject, String methodName, Class< T > fieldClass) {
        return invokeDynamicMethodWithReturn(targetObject, methodName, new Class[]{}, new Object[]{}, fieldClass);
    }

    /**
     * Call a object method with no return value
     *
     * @param targetObject   -
     * @param methodName     -
     * @param parameterTypes -
     * @param args           -
     * @return -
     */
    public static int invokeDynamicVoidMethod(Object targetObject, String methodName, Class< ? >[] parameterTypes, Object[] args) {
        try {
            Method method = targetObject.getClass().getMethod(methodName, parameterTypes);
            method.invoke(targetObject, args);
        } catch (InvocationTargetException e) {
            Throwable throwable = e.getTargetException();
            throw new RuntimeException(throwable.getMessage());
        } catch (Exception e) {
            return SMDKResult.NOT_SUPPORT;
        }
        return SMDKResult.SUCCESS;
    }

}
