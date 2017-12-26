package com.library.service.imp;

import com.library.entity.AddUserParam;
import com.library.entity.LoginParam;
import com.library.entity.LoginResult;
import com.library.entity.LoginUser;
import com.library.mapper.UserMapper;
import com.library.service.UserService;
import com.library.utility.BusinessException;
import com.library.utility.UserAuthHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public LoginResult getLoginUser(LoginParam param) throws Exception{
        if(param==null
                || param.getUserId()==null
                || param.getPassword()==null
                || param.getUserId().length()==0
                || param.getPassword().length()==0){
            throw  new BusinessException("登陆名或者账号密码不能为空");
        }
        LoginUser loginUser = userMapper.getLoginUser(param);
        if(loginUser==null){
            throw new BusinessException("账号或者密码不正确");
        }
        //token有效期是一天
        Date expireDate = new Date(new Date().getTime() + 3600*24*1000);
        loginUser.setExpireDateTime(expireDate);
        LoginResult result = new LoginResult();
        result.setRole(loginUser.getRole());
        result.setCustomerId(loginUser.getUserId());
        result.setToken(UserAuthHelper.getLoginToken(loginUser));
        result.setExpireTime(3600*24);
        return result;
    }

    @Override
    public void addLoginUser(AddUserParam param) {
        if(param==null
                || param.getUserId()==null
                || param.getPassword()==null
                || param.getUserId().length()==0
                || param.getPassword().length()==0){
            throw  new BusinessException("账号ID和密码不能为空");
        }

        LoginUser user = userMapper.getLoginUserByUserId(param.getUserId());
        if(user!=null){
            throw new BusinessException("账户Id不能重复");
        }
        userMapper.addUser(param);
    }
}
