package com.snail.wms.common;

import com.snail.wms.common.ResultType;
import com.snail.wms.common.enums.CodeEnum;

/**
 * 业务结果实体类
 *
 * @param <R>
 * @author colin
 */
public class Result<R> {

    //结果类型
    private ResultType result;

    private String code;
    //原因
    private  String msg;
    //返回的业务结果数据；
    private  R body = (R) "{}";

    public Result() {
        super();
        this.result = ResultType.success;
        this.code = CodeEnum.N00000.getCode();
        this.msg = CodeEnum.N00000.getMsg();
    }

    public Result(String msg) {
        this.msg = msg;
        this.result = ResultType.success;
        this.code = CodeEnum.N00000.getCode();
    }

    public Result(String msg, R body) {
        this.msg = msg;
        if(body != null) this.body = body;
        this.result = ResultType.success;
        this.code = CodeEnum.N00000.getCode();
    }

    public Result(ResultType result, String code, String msg) {
        this.result = result;
        this.code = code;
        this.msg = msg;
    }

    public Result(ResultType result, String code, String msg, R body) {
        this.result = result;
        this.code = code;
        this.msg = msg;
        if(body != null) this.body = body;
    }

    public ResultType getResult() {
        return result;
    }

    public void setResult(ResultType result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public R getBody() {
        return body;
    }

    public void setBody(R body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result=" + result +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", body=" + body +
                '}';
    }
}
