package com.susu.oss.exception;

import com.susu.oss.common.Result;
import com.susu.oss.common.enums.ErrorEnum;
import com.susu.oss.common.utils.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class OssExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<String> error(Exception e){
        e.printStackTrace();
        return new Result<String>().error(ErrorEnum.ERROR_500);
    }

    @ExceptionHandler(OssException.class)
    @ResponseBody
    public Result<String> error(OssException e){
        e.printStackTrace();
        if(e.getCode() == null){
            return new Result<String>().error(e.getMsg());
        }else {
            if (StringUtils.isNotEmpty(e.getMsg())){
                return new Result<String>().error(e.getCode(),e.getMsg());
            }
            return new Result<String>().error(e.getCode(),"系统异常");
        }

    }

}
