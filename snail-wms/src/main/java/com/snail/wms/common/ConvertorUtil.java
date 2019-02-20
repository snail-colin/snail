package com.snail.wms.common;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;

/**
 * 转换工具
 * @author colin
 */
public class ConvertorUtil {

    public static ObjectMapper objectMapper = new ObjectMapper();

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

    /**
     * json字符串转成map
     * @param json
     * @return
     */
    public static Map<String, Object> json2map(String json){
        ObjectMapper obj = new ObjectMapper();
        Map<String, Object> rst = null;
        try {
            rst = obj.readValue(json, Map.class);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rst;
    }
}
