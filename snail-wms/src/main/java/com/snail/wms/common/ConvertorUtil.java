package com.snail.wms.common;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;


public class ConvertorUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转成json格式
     *
     * @param pojo
     * @return
     */
    public static String pojo2Json(Object pojo) {
        String rst = "{}";
        try {
            if (pojo == null) return rst;

            if (pojo instanceof String && isJsonStr(pojo.toString())) return pojo.toString();

            rst = objectMapper.writeValueAsString(pojo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rst;
    }

    /**
     * 判断字符串是不是json格式
     *
     * @param json
     * @return
     */
    public static boolean isJsonStr(String json) {
        try {
            JSONObject.fromObject(json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
