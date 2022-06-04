package com.susu.oss.security.utils;


import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

public class SecurityReturn {


    @ApiModelProperty(value = "是否成功")
    private Boolean success = true;

    @ApiModelProperty(value = "返回码")
    private Integer code = 0;

    @ApiModelProperty(value = "返回消息")
    private String message = "操作成功";

    @ApiModelProperty(value = "返回数据")
    private Object data;

    //把构造方法私有
    private SecurityReturn() {}

    //成功静态方法
    public static SecurityReturn ok() {
        return new SecurityReturn();
    }

    //成功静态方法
    public static SecurityReturn ok(Object data) {
        SecurityReturn r = new SecurityReturn();
        r.setData(data);
        return r;
    }

    //成功静态方法
    public static SecurityReturn ok(String key,String value) {
        Map<String,String> map = new HashMap<>();
        map.put(key,value);
        SecurityReturn r = new SecurityReturn();
        r.setData(map);
        return r;
    }

    //失败静态方法
    public static SecurityReturn error() {
        SecurityReturn r = new SecurityReturn();
        r.setSuccess(false);
        r.setCode(1);
        r.setMessage("操作失败");
        return r;
    }

    //失败静态方法
    public static SecurityReturn error(String message) {
        SecurityReturn r = new SecurityReturn();
        r.setSuccess(false);
        r.setCode(1);
        r.setMessage(message);
        return r;
    }

    //失败静态方法
    public static SecurityReturn error(Integer code, String message) {
        SecurityReturn r = new SecurityReturn();
        r.setSuccess(false);
        r.setCode(1);
        r.setMessage(message);
        r.setCode(code);
        return r;
    }

    public SecurityReturn success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public SecurityReturn message(String message){
        this.setMessage(message);
        return this;
    }

    public SecurityReturn code(Integer code){
        this.setCode(code);
        return this;
    }

    public SecurityReturn data(Object value){
        this.data = value;
        return this;
    }

    public SecurityReturn data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
