package com.share.basic;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @Author: zhangdeheng
 * @Date: 2020/4/27 2:43 下午
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        JSONObject jj = new JSONObject();
        try {
            jj.put("id","111");
            System.out.println(jj.getInt("id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
