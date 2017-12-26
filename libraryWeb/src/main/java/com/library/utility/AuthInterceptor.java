package com.library.utility;

import com.library.entity.LoginUser;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String url=request.getRequestURL().toString();
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Auth auth = method.getAnnotation(Auth.class);
        if (auth == null) {
            return true;
        }
        else{
            LoginUser curUser = UserAuthHelper.getCurUser();
            if(curUser==null){
                throw new BusinessException(401,"请登陆");
            }
            else{
                if(auth.role()=="admin" && curUser.getRole()!="admin"){
                    throw new BusinessException(501,"权限不足");
                }
            }
            return true;
        }
    }
}
