package com.susu.oss.common.enums;

import lombok.Getter;

/**
 * @author fxbsujay@gmail.com
 */
@Getter
public enum ErrorEnum {

    /**
     *  系统异常
     */
    ERROR_404(404,"未找到对应资源"),
    ERROR_500(500,"操作失败");

    /**
     * code 编码
     */
    private final Integer code;

    /**
     * message 消息内容
     */
    private final String message;

    ErrorEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
