package com.share.basic.annotation;

import java.lang.reflect.Field;

/**
 * @Author: zhangdeheng
 * @Date: 2020/4/25 8:04 下午
 * @Version 1.0
 */
public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            if (f.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider annotation = f.getAnnotation(FruitProvider.class);
                System.out.println("供应商编号:" + annotation.id() + ",供应商名称:" + annotation.name() + ",供应商地址:" + annotation.address());
            }
        }
    }

}
