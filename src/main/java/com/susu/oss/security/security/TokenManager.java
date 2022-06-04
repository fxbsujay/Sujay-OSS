package com.susu.oss.security.security;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * <p>
 * token管理
 * </p>
 *
 * @author qy
 * @since 2019-11-08
 */
@Component
public class TokenManager {

    /**
     * 过期时间
     */
    private final long TOKEN_EXPIRATION = 24 * 60 * 60 * 1000;

    /**
     * 密钥
     */
    private final String TOKEN_SIGN_KEY = "123456";

    /**
     * 创建token
     */
    public String createToken(String username) {
        return Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, TOKEN_SIGN_KEY).compressWith(CompressionCodecs.GZIP).compact();
    }

    /**
     * 解析token中的用户信息
     */
    public String getUserFromToken(String token) {
        return Jwts.parser().setSigningKey(TOKEN_SIGN_KEY).parseClaimsJws(token).getBody().getSubject();
    }


    public void removeToken(String token) {
        // jwttoken无需删除，客户端扔掉即可。

    }

}
