package com.susu.oss.security.filter;

import com.susu.oss.common.enums.ErrorEnum;
import com.susu.oss.security.security.TokenManager;
import com.susu.oss.security.utils.ResponseUtil;
import com.susu.oss.security.utils.SecurityReturn;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * 访问过滤器
 * </p>
 *
 * @author qy
 * @since 2019-11-08
 */

public class AuthenticationFilter extends BasicAuthenticationFilter {
    private TokenManager tokenManager;

    public AuthenticationFilter(AuthenticationManager authManager, TokenManager tokenManager) {
        super(authManager);
        this.tokenManager = tokenManager;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        UsernamePasswordAuthenticationToken authentication = null;
        try {
            // 看用户是否登录
            authentication = getAuthentication(req);
        } catch (Exception e) {

            ResponseUtil.out(res, SecurityReturn.error());
        }

        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            ResponseUtil.out(res, SecurityReturn.error(ErrorEnum.ERROR_500));
        }

        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {

        String token = request.getHeader("x-token");
        if (token != null && !"".equals(token.trim())) {
           // 权限列表
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            // 获取用户名
            String userName = tokenManager.getUserFromToken(token);
            if (!StringUtils.isEmpty(userName)) {
                return new UsernamePasswordAuthenticationToken(userName, token, authorities);
            }
            return null;
        }
        return null;
    }
}
