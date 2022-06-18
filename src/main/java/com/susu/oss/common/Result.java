package com.susu.oss.common;


import com.susu.oss.common.constant.SysConstant;
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
     * 编码
     **/
    private int code = SysConstant.HTTP_SUCCESS_CODE;

    /**
     * 消息内容
     **/
    private String msg = SysConstant.HTTP_SUCCESS_MSG;

    /**
     * 数据
     **/
    private T data;

    private Result() {
    }

    private Result(T data) {
        this.data = data;
    }

    private Result(Integer code) {
        this.code = code;
    }

    private Result(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(String msg) {
        this.msg = msg;
    }


    private Result(T data,String msg) {
        this.data = data;
        this.msg = msg;
    }

    public static Result<String> ok() {
        return new Result<>();
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(data);
    }

    public static <T> Result<T> ok(T data,String msg) {
        return new Result<>(data,msg);
    }


    public static Result<String> error() {
        return new Result<>(ErrorEnum.ERROR_500.getCode(),ErrorEnum.ERROR_500.getMessage());
    }

    public static Result<String> error(String msg) {
        return new Result<>(ErrorEnum.ERROR_500.getCode(),msg);
    }

    public static Result<String> error(Integer code,String msg) {
        return new Result<>(code,msg);
    }

    public static Result<String> error(ErrorEnum e) {
        return new Result<>(e.getCode(),e.getMessage());
    }

}
