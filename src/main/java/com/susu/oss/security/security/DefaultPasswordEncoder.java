package com.susu.oss.security.security;

import com.susu.oss.exception.OssException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * <p>
 * t密码的处理方法类型
 * </p>
 *
 * @author qy
 * @since 2019-11-08
 */
@Component
public class DefaultPasswordEncoder implements PasswordEncoder {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public DefaultPasswordEncoder() {
        this(-1);
    }

    /**
     * @param strength
     *            the log rounds to use, between 4 and 31
     */
    public DefaultPasswordEncoder(int strength) {

    }

    @Override
    public String encode(CharSequence rawPassword) {

        if (rawPassword == null) {
            throw new OssException("密码为空");
        }

        return passwordEncoder.encode(rawPassword);
    }


    /**
     * security验证
     * @param rawPassword 被解析的密码
     * @param encodedPassword 存储的密码。
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        if (StringUtils.isEmpty(rawPassword) || StringUtils.isEmpty(encodedPassword)){
            throw  new OssException("密码为空");
        }

        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            throw new OssException("密码错误");
        }
        return true;

    }
}
