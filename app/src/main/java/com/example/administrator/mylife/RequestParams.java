package com.example.administrator.mylife;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/15 0015.
 */
//http://apis.juhe.cn/cook/query?key=8e0cd522f45195e924433235d6314b64&menu=%E8%A5%BF%E7%BA%A2%E6%9F%BF&rn=1&pn=3
public class RequestParams {
    public static Map<String,String> testRequestParam(String menu,String rn,String pn) {
        Map<String,String> params = new HashMap<>();
        params.put("key","8e0cd522f45195e924433235d6314b64");
        params.put("menu",menu);
        params.put("rn",rn);
        params.put("pn",pn);
        return params;
    }
}
