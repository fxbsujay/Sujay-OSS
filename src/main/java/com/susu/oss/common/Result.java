package com.susu.oss.common;


import com.susu.oss.common.enums.ErrorEnum;
import lombok.Data;

/**
 * <p>Description: Result</p>
 * <p>请求响应体</p>
 * @author sujay
 * @email fxbsujay@gmail.com
 * @date 9:40 2022/2/22
 * @version 1.0
 */
@Data
public class Result<T> {

    /**
     * 成功编码
     **/
    public static final int SUCCESS_CODE = 200;

    /**
     * 失败编码
     **/
    public static final int ERROR_CODE = 500;

    /**
     * 编码
     **/
    private int code = SUCCESS_CODE;

    /**
     * 消息内容
     **/
    private String msg = "操作成功";

    /**
     * 数据
     **/
    private T data;

    public Result<T> ok() {
        return this;
    }

    public Result<T> ok(T data) {
        this.setData(data);
        return this;
    }

    public Result<T> error() {
        this.setCode(ERROR_CODE);
        this.setMsg("操作失败");
        return this;
    }

    public Result<T> error(String msg) {
        this.setCode(ERROR_CODE);
        this.setMsg(msg);
        return this;
    }

    public Result<T> error(Integer code,String msg) {
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }

    public Result<T> error(ErrorEnum e) {
        this.setCode(e.getCode());
        this.setMsg(e.getMessage());
        return this;
    }

}
