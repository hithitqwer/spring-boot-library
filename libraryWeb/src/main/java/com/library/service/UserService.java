package com.library.service;

import com.library.entity.*;
import com.library.entity.LoginUser;

public interface UserService {

    LoginResult getLoginUser(LoginParam param) throws Exception;

    void addLoginUser(AddUserParam param);
}
