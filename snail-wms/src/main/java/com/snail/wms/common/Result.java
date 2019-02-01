package com.snail.wms.common;

import com.snail.wms.common.ResultType;

/**
 * 业务结果实体类
 *
 * @param <R>
 * @author colin
 */
public class Result<R> {
    //结果类型
    private  ResultType code;
    //失败的原因
    private final String msg;
    //返回的业务结果数据；
    private  R body = (R) "{}";

    public Result() {
        super();
        this.code = ResultType.success;
        this.msg = "success";
    }

    /**
     * 成功方法
     * @param code
     * @param body
     * @param msg
     */
    public Result(ResultType code, R body, String msg) {
        super();
        this.code = code;
        if(body != null) this.body = body;
        this.msg = msg;
    }

    /**
     * 成功方法
     * @param code
     * @param body
     */
    public Result(ResultType code, R body) {
        super();
        this.code = code;
        if(body != null) this.body = body;
        this.msg = "success";
    }

    /**
     * 成功方法
     * @param body
     * @param msg
     */
    public Result(R body,String msg) {
        super();
        this.code = ResultType.success;
        if(body != null) this.body = body;
        this.msg = msg;
    }

    /**
     * 成功方法
     * @param body
     */
    public Result(R body) {
        super();
        this.code = ResultType.success;
        if(body != null) this.body = body;
        this.msg = "success";
    }

    public ResultType getCode() {
        return code;
    }

    public R getBody() {
        return body;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Result [code=" + code + ", body=" + body + ", msg=" + msg + "]";
    }


}
