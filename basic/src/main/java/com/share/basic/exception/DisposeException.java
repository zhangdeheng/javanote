package com.share.basic.exception;

/**
 * @Author: zhangdeheng
 * @Date: 2020/4/25 11:47 上午
 * @Version 1.0
 * 异常处理方式
 */
public class DisposeException {
    public static void throwDemo(String s){
        if(s.equals("abc")){
            throw new NumberFormatException();
        }else {
            System.out.println(s);
        }
    }

    public static int div(int a,int b) throws Exception{
        return a/b;
    }

    public static void main(String[] args)  {
        try {
            throwDemo("abc");
            div(2,0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
