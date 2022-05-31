package com.susu.oss.exception;

import com.susu.oss.common.Result;
import com.susu.oss.common.utils.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class OssExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.error();
    }

    @ExceptionHandler(OssException.class)
    @ResponseBody
    public Result error(OssException e){
        e.printStackTrace();
        if(e.getCode() == null){
            return Result.error(e.getMsg());
        }else {
            if (StringUtils.isNotEmpty(e.getMsg())){
                return Result.error(e.getCode(),e.getMsg());
            }
            return Result.error(e.getCode(),"系统异常");
        }

    }

}
