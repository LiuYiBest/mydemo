package com.liu.coder.utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyidiao on 2017/7/10.
 */

public class ControllerUtils {

    /**
     * Ajax执行结果回调函数，返回map对象
     * 需jackson包支持
     *
     * @param result
     * @param message
     * @return map
     */

    public static Map ajaxResult(Boolean result, String message) {
        Map map = new HashMap();
        map.put("result", result);
        map.put("message", message);
        return map;
    }

    /**
     * Ajax执行结果回调函数，返回Json字符串
     * 需fastjson包支持
     *
     * @param result
     * @param message
     * @return String json格式
     */

    public static String ajaxResultWithJsonString(Boolean result, String message) {
        Map map = new HashMap();
        map.put("result", result);
        map.put("message", message);
        return JSON.toJSONString(map);
    }
}
