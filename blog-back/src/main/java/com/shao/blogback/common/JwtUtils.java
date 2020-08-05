package com.shao.blogback.common;

import com.shao.blogback.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Data
@Component
public class JwtUtils {
    private final String key = "admin";//签名私钥
    private final Long invalidTime = 24L * 3600 * 1000;//签名失效时间

    /**
     * 生成令牌token
     */
    public String generateToken(User user, Map<String, Object> map) {
        //设置签名失效时间
        //创建JwtBuilder
        JwtBuilder jwtBuilder = Jwts.builder().setSubject(user.getUsername()).setIssuedAt(new Date()).
                //设置签名防止篡改
                        signWith(SignatureAlgorithm.HS512, key);
        //根据Map设置claim
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            jwtBuilder.claim(entry.getKey(), entry.getValue());
        }
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + invalidTime));
        //返回创建的token
        return jwtBuilder.compact();
    }

    /**
     * 解析token
     */
    public Claims parseJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }
}
