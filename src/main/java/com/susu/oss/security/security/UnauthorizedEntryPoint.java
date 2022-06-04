package com.susu.oss.security.security;

import com.susu.oss.security.utils.ResponseUtil;
import com.susu.oss.security.utils.SecurityReturn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 未授权的统一处理方式
 * </p>
 *
 * @author qy
 * @since 2019-11-08
 */
@Slf4j
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        log.error("UnauthorizedEntryPoint ERROR: {}",authException.getMessage());
        ResponseUtil.out(response, SecurityReturn.error());
    }
}
