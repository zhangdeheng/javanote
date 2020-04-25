package com.share.basic.exception;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: zhangdeheng
 * @Date: 2020/4/25 6:02 下午
 * @Version 1.0
 */
public class Reflec {

    public static void main(String[] args) {
        //方法一
        DisposeException disposeException = new DisposeException();
        Class<? extends DisposeException> aClass = disposeException.getClass();
        //方法二
        Class<DisposeException> disposeExceptionClass = DisposeException.class;
        //方法三
        Class<?> clazz = null;
        try {
            clazz = Class.forName("com.share.basic.exception.DisposeException");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println("方法:" + m);
        }
        //获取属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println("属性:" + f);
        }
        //获取构造方法
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println("构造器" + c);
        }

        //获取对象
        try {
            DisposeException d = (DisposeException) clazz.newInstance();
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(int.class);
            DisposeException d1 = (DisposeException) declaredConstructor.newInstance(1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
