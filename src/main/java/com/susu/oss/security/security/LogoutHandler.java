package com.susu.oss.security.security;

import com.susu.oss.security.utils.ResponseUtil;
import com.susu.oss.security.utils.SecurityReturn;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 登出业务逻辑类
 * </p>
 *
 * @author qy
 * @since 2019-11-08
 */
public class LogoutHandler implements org.springframework.security.web.authentication.logout.LogoutHandler {

    private TokenManager tokenManager;

    public LogoutHandler(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    // 退出
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String token = request.getHeader("token");
        if (token != null) {
            tokenManager.removeToken(token);
            //清空当前用户缓存中的权限数据
            String userName = tokenManager.getUserFromToken(token);
        }
        ResponseUtil.out(response, SecurityReturn.ok());
    }

}
