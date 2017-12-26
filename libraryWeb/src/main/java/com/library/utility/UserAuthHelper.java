package com.library.utility;

import com.google.gson.Gson;
import com.library.entity.LoginUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
public class UserAuthHelper  {

    public static boolean hasLogin() throws  Exception{
        return  getCurUser()!=null;
    }

    public static LoginUser getCurUser() throws  Exception{
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies=request.getCookies();
        LoginUser loginuser = null;
        for(Cookie cookie:cookies){
            if("libraryauth".equals(cookie.getName())){
                String value = cookie.getValue();
                String key = "9ba45bfd500642328ec03ad8ef1b6e75";// 自定义密钥
                EncryptUtil des = new EncryptUtil(key, "utf-8");
                String cookieStr = des.decode(value);
                LoginUser user = new Gson().fromJson(cookieStr ,LoginUser.class);
                if(user!=null && user.getSysNo() < 0){
                    loginuser= user;
                }
            }
        }
        return loginuser;
    }

    public static String getLoginToken(LoginUser user) throws Exception{
        String userJson = new Gson().toJson(user);
        String key = "9ba45bfd500642328ec03ad8ef1b6e75";
        EncryptUtil des = new EncryptUtil(key,"utf-8");
        return des.encode(userJson);
    }
}
