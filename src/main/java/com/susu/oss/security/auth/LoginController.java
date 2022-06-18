package com.susu.oss.security.auth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.susu.oss.common.Result;
import com.susu.oss.common.enums.ErrorEnum;
import com.susu.oss.common.utils.ConvertUtils;
import com.susu.oss.common.utils.EasyCaptchaUtils;
import com.susu.oss.common.utils.JwtUtils;
import com.susu.oss.common.utils.StringUtils;
import com.susu.oss.dao.UserDao;
import com.susu.oss.dto.UserDTO;
import com.susu.oss.entity.UserEntity;
import com.susu.oss.exception.OssException;
import com.wf.captcha.SpecCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Api(tags="登录管理")
@RequestMapping("/auth")
@Slf4j
public class LoginController {


    @Autowired
    private UserDao userDao;

    @GetMapping("captcha")
    @ApiOperation(value = "验证码", produces="application/octet-stream")
    @ApiImplicitParam(paramType = "query", dataType="string", name = "uuid", required = true)
    public void captcha(HttpServletResponse response, String uuid) {
        if (StringUtils.isBlank(uuid)) {
            throw new OssException(ErrorEnum.ERROR_500);
        }

        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //生成验证码
        SpecCaptcha captcha = EasyCaptchaUtils.getSpecCaptcha();
        try {
            captcha.out(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        log.info("验证码：{}",captcha.text());
    }

    @GetMapping("info")
    @ApiOperation(value = "获取用户信息")
    public Result<UserDTO> info(HttpServletRequest request){
        String username = JwtUtils.getUserToken(request);
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        UserEntity sysUserEntity = userDao.selectOne(wrapper);
        UserDTO userDTO = ConvertUtils.sourceToTarget(sysUserEntity, UserDTO.class);
        return Result.ok(userDTO);
    }

    @PostMapping("login")
    @ApiOperation("登录")
    public void login(HttpServletRequest request){
        log.info("=======登录======");
    }

    @PostMapping("logout")
    @ApiOperation("登出")
    public void logout(HttpServletRequest request){
        log.info("=======登出======");
    }
}
