package com.rightmanagement.demo.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT token的格式：header.payload.signature
 * header中用于存放签名的生成算法
 * payload中用于存放用户名、token的生成时间和过期时间
 * signature为以header和payload生成的签名，一旦header和payload被篡改，验证将失败
 *
 *
 *  jwtToken工具类
 * 生成：generateToken
 * 解析：getUserNameFromToken
 * 判断是否还有效：validateToken
 */
@Component
public class JwtTokenUtil {
    private static final Logger LOGGER= LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final String ClAIM_KEY_USERNAME="sub";
    private static final String CLAIM_KEY_CREATED="created";

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 生成token
     * @param claims
     * @return
     */
    private String generateToken(Map<String,Object> claims){
       return Jwts.builder()
            .setClaims(claims)
            .setExpiration(generateExpirationDate())  //过期时间
            .signWith(SignatureAlgorithm.HS256,secret) // 签名算法以及密匙
            .compact();
    }

    /**
     * 从token中获取JWT中的负载
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token){
        Claims claims=null;
        try{
            claims=Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch(Exception e){
            LOGGER.info("Jwt格式验证错误",token);
        }
        return claims;
    }

    /**
     * 生成过期时间
     * @return
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis()+expiration*1000);
    }

    /**
     * 从token中获取用户名
     * @param token
     * @return
     */
    public String getUserNameFromToken(String token){
        String username;
        try{
            Claims claims=getClaimsFromToken(token);
            username=claims.getSubject();
        }catch(Exception e){
            username=null;
        }
        return username;
    }

    /**
     * 判断token是否有效
     * @param token  将token中的username
     * @param userDetails 数据库中的用户信息
     * @return
     */
    public boolean validateToken(String token, UserDetails userDetails){
       String username =getUserNameFromToken(token);
       return username.equals(userDetails.getUsername())&&!isTokenExpired(token);
    }

    /**
     * token是否过期
     * @param token
     * @return
     */
    private boolean isTokenExpired(String token){
        Date expiredDate= getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }
    /**
     * 获取过期时间
     * @param token
     * @return
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims=getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 根据用户信息生成token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims=new HashMap<>();
        claims.put(ClAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }

    /**
     * token是否能刷新
     * @param token
     * @return
     */
    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token){
         Claims claims=getClaimsFromToken(token);
         claims.put(CLAIM_KEY_CREATED,new Date());
         return generateToken(claims);
    }
}
