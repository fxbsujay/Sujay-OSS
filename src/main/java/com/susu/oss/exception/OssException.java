package com.susu.oss.exception;

import com.susu.oss.common.enums.ErrorEnum;

public class OssException extends RuntimeException{

    private Integer code = ErrorEnum.ERROR_500.getCode();

    private String msg = ErrorEnum.ERROR_500.getMessage();

    public OssException(ErrorEnum e) {
        this.code = e.getCode();
        this.msg = e.getMessage();
    }

    public OssException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public OssException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public OssException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
