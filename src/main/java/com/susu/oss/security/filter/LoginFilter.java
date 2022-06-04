package com.susu.oss.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.susu.oss.security.entity.SecurityUser;
import com.susu.oss.security.entity.User;
import com.susu.oss.security.security.TokenManager;
import com.susu.oss.security.utils.ResponseUtil;
import com.susu.oss.security.utils.SecurityReturn;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * <p>
 * 登录过滤器，继承UsernamePasswordAuthenticationFilter，对用户名密码进行登录校验
 * </p>
 *
 * @author qy
 * @since 2019-11-08
 */
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private TokenManager tokenManager;

    public LoginFilter(AuthenticationManager authenticationManager, TokenManager tokenManager) {
        this.authenticationManager = authenticationManager;
        this.tokenManager = tokenManager;
        this.setPostOnly(false);
        // 拦截地址
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/auth/login","POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        User user = null;
        try {
            user = new ObjectMapper().readValue(req.getInputStream(), User.class);
        }catch (SecurityException | IOException s){
            throw new SecurityException(s);
        }

        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),
                        new ArrayList<>()));
    }

    /**
     * 登录成功
     * @param req
     * @param res
     * @param chain
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        // 获取用户
        SecurityUser user = (SecurityUser) auth.getPrincipal();
        // 获取token
        String token = tokenManager.createToken(user.getCurrentUserInfo().getUsername());

        // 返回token
        ResponseUtil.out(res, SecurityReturn.ok("token", token));
    }

    /**
     * 登录失败
     * @param request
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException e) throws IOException, ServletException {
        ResponseUtil.out(response, SecurityReturn.error());
    }
}
