package com.cf.colorm.filter;

import com.cf.colorm.utils.JWTUtls;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SignatureException;

@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    private static Log log = LogFactory.getLog(TokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws SignatureException {
        /** 地址过滤 */
//        String uri = request.getRequestURI();
//        if (uri.contains("/swagger-ui.html")) {
//            return true;
//        }

        String token1 = request.getHeader("Authorization");
        System.out.println(token1);

        /** Token 验证 */
        try {
            String token = request.getHeader("token");
            JWTUtls.verity(token);
        }catch (Exception e){
            log.info("失效");
            e.printStackTrace();
            return false;
        }
        return true;
    }
}