package com.share.basic.innerclass;

/**
 * @Author: zhangdeheng
 * @Date: 2020/4/25 10:45 下午
 * @Version 1.0
 * 静态内部类
 */
public class Out {

    private static int a;

    private int b;

    public static class StatisticInner{
        public void print(){
            System.out.println(a);
        }
    }
    public class Inner{

    }
}
