package com.share.basic.annotation;

/**
 * @Author: zhangdeheng
 * @Date: 2020/4/25 8:03 下午
 * @Version 1.0
 */
public class Apple {

    @FruitProvider(id = 1, name = "富士康集团", address = "陕西")
    private String appleProvider;

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
}
