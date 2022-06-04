package com.susu.oss.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author fxbsuajy@gmail.com
 * @since 2019/10/16
 */
public class JwtUtils {

    /**
     * 过期时间
     */
    public static final long EXPIRE = 1000 * 60 * 60 * 24;

    /**
     * 秘钥
     */
    public static final String APP_SECRET = "123456";

    public static String getJwtToken(String id, String nickname){

        StringUtils.isNotBlank("");
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("greenLeaf")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("id", id)
                .claim("nickname", nickname)
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
    }

    /**
     * 判断token是否存在与有效
     * @param jwtToken token
     * @return boolean
     */
    public static boolean checkToken(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     * @param request 请求
     * @return boolean
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("x-token");
            if(StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token获取id
     * @param request 请求
     * @return 用户信息
     */
    public static String getMemberIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("x-token");
        if ( StringUtils.isEmpty(jwtToken) ) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("id");
    }

    public static String getUserToken(HttpServletRequest request) {
        String token = request.getHeader("x-token");
        if ( StringUtils.isEmpty(token) ) return "";
        return Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody().getSubject();
    }
}
