package com.snail.wms.common;

import com.snail.wms.common.annotation.Length;
import com.snail.wms.common.annotation.NotEmpty;
import com.snail.wms.common.annotation.NotEmptyByAttributes;
import com.snail.wms.common.enums.CodeEnum;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author colin
 * 2019/2/1
 */
public class CheckUtil {

    /**
     * 数据项校验
     *
     * @param req
     */
    public static void checkRequest(Object req) throws BaseException {
        if (req == null) {
            throw new BaseException(CodeEnum.N00002.getCode(), CodeEnum.N00002.name());
        }

        String name;
        Class<?> clazz = req.getClass();

        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field fields[] = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                name = field.getName();
                // 校验是否可以为空
                NotEmpty notEmpty = field.getAnnotation(NotEmpty.class);
                if (notEmpty != null && notEmpty.values()) {
                    Object obj = null;
                    try {
                        obj = field.get(req);
                    } catch (Exception e) {
                    }
                    if (obj == null || (field.getType() == String.class && StringUtils.isBlank(obj.toString()))
                            || (field.getType() == Integer.class && obj == null)) {
                        throw new BaseException(CodeEnum.N00003.getCode(), "数据项[" + name + "]不可为空");
                    }
                }

                //指定属性校验指定值
                NotEmptyByAttributes neba = field.getAnnotation(NotEmptyByAttributes.class);
                if (neba != null) {
                    // 属性名称
                    String attrName = neba.name();
                    // 属性指定检验值
                    String attrValue = neba.value();
                    String currentAttrValue = "";
                    Object obj = null;
                    try {
                        Field tempField = clazz.getDeclaredField(attrName);
                        tempField.setAccessible(true);
                        currentAttrValue = tempField.get(req).toString();
                        obj = field.get(req);
                    } catch (Exception e) {

                    }
                    if (attrValue.equals(currentAttrValue)) {
                        if (obj == null || (field.getType() == String.class && StringUtils.isBlank(obj.toString()))
                                || (field.getType() == Integer.class && obj == null)) {
                            throw new BaseException(CodeEnum.N00003.getCode(), "数据项[" + name + "]不可为空");
                        }
                    }

                }

                // 校验长度
                Length length = field.getAnnotation(Length.class);
                if (length != null) {
                    Object obj = null;
                    try {
                        obj = field.get(req);
                    } catch (Exception e) {

                    }
                    // 实际值为null时则不校验长度
                    if (obj == null || (field.getType() == String.class && StringUtils.isBlank(obj.toString()))) {
                        continue;
                    }
                    // 最小长度
                    int min = length.min();
                    if (obj.toString().length() < min) {
                        throw new BaseException(CodeEnum.N00003.getCode(), "数据项[" + name + "]的长度不能小于" + min);
                    }
                    // 最大长度
                    int max = length.max();
                    if (obj.toString().length() > max) {
                        throw new BaseException(CodeEnum.N00003.getCode(),
                                "数据项[" + name + "]的长度不能超过最大长度" + max);
                    }
                    // 验证规则
                    String reg = length.reg();
                    // 编译正则表达式
                    Pattern pattern = Pattern.compile(reg);
                    Matcher matcher = pattern.matcher(obj.toString());
                    // 字符串是否与正则表达式相匹配
                    boolean rs = matcher.matches();
                    if (!rs) {
                        throw new BaseException(CodeEnum.N00003.getCode(), "数据项[" + name + "]的格式不正确");
                    }
                }
            }
        }
    }
}
