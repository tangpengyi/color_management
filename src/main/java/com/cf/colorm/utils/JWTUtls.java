package com.cf.colorm.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;

import java.util.Calendar;

public class JWTUtls {


    private static final String SECERT = "123456123456123456";

    /**
     * 生成token
     * @return
     */
    public static String getToken(){

        Calendar instance = Calendar.getInstance();

        //设置过期时间
        instance.add(Calendar.DATE,7);

        return JWT.create()
                .withClaim("userId", "12")
                .withClaim("userName", "admin")
                //制定过期时间
                .withExpiresAt(instance.getTime())
                //签名
                .sign(Algorithm.HMAC256(SECERT));
    }

    /**
     * 验证token
     * @param token
     */
    public static DecodedJWT verity(String token){
        return JWT.require(Algorithm.HMAC256(SECERT)).build().verify(token);
    }

}
