package com.snail.wms.common;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.time.DateFormatUtils;

/**
 * @author colin
 * 2019/2/1
 */
public class DateUtil {

    private  static String  ymdhms = "yyyyMMddHHmmss";


    public  static  String getNowDate2yyyyMMddHHmmss(){
        return DateFormatUtils.format(System.currentTimeMillis(),ymdhms);
    }
}
