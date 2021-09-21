package com.zyyu.ucp.utils;

import com.zyyu.ucp.enums.TokenCheckEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

/**
 * @func Jwt相关
 * Token身份认证方式
 */
public class JwtUtil {
    /**
     * 私钥
     */
    final static String base64EncodedSecretKey = "base64EncodedSecretKey";
    /**
     * 过期时间,测试使用20分钟
     */
    final static long TOKEN_EXP = 1000 * 60 * 20;

    final static String CLAIMS_ROLE="role";



    /**
     * 获取 Token
     * @param userId
     * @return
     */
    public static String getToken(String userId,String role) {
        return Jwts.builder()
                .setSubject(userId)
                .claim(CLAIMS_ROLE, role)
                .setIssuedAt(new Date())
                /*过期时间*/
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXP))
                .signWith(SignatureAlgorithm.HS256, base64EncodedSecretKey)
                .compact();
    }

    /**
     * @func 检查token, 只要不正确就会抛出异常
     */
    public static TokenCheckEnum checkToken(String token,String role){
        try {
            final Claims claims = Jwts.parser().setSigningKey(base64EncodedSecretKey).parseClaimsJws(token).getBody();
            if(claims!=null && role.equals(claims.get(CLAIMS_ROLE))){
                return TokenCheckEnum.PASS;
            }
        } catch (ExpiredJwtException e1) {
            return TokenCheckEnum.EXPIRED;
        }
        return TokenCheckEnum.INVALID;
    }

    /**
     * 根据token获取用id
     * @param token
     * @return
     */
    public static String getUserId(String token){
        Claims claims = Jwts.parser().setSigningKey(base64EncodedSecretKey).parseClaimsJws(token).getBody();
        String userId =  claims.getSubject();
        return userId;
    }
}
