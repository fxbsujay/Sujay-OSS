package com.susu.oss.security.utils;


import com.susu.oss.common.constant.SysConstant;
import com.susu.oss.common.enums.ErrorEnum;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Map;

public class SecurityReturn {

    @ApiModelProperty(value = "是否成功")
    private Boolean success = true;

    @ApiModelProperty(value = "返回码")
    private Integer code = SysConstant.HTTP_SUCCESS_CODE;

    @ApiModelProperty(value = "返回消息")
    private String msg = SysConstant.HTTP_SUCCESS_MSG;

    @ApiModelProperty(value = "返回数据")
    private Object data;

    private SecurityReturn() {}

    //成功静态方法
    public static SecurityReturn ok() {
        return new SecurityReturn();
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
        return error(ErrorEnum.ERROR_500);
    }

    public static SecurityReturn error(String msg) {
        SecurityReturn r = new SecurityReturn();
        r.setSuccess(false);
        r.setMsg(msg);
        r.setCode(ErrorEnum.ERROR_500.getCode());
        return r;
    }

    //失败静态方法
    public static SecurityReturn error(ErrorEnum e) {
        SecurityReturn r = new SecurityReturn();
        r.setSuccess(false);
        r.setMsg(e.getMessage());
        r.setCode(e.getCode());
        return r;
    }

    public SecurityReturn success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public SecurityReturn message(String message){
        this.setMsg(message);
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
