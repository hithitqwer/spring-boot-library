package com.library.controller;
import com.library.entity.*;
import com.library.service.UserService;
import com.library.utility.ApiResult;
import com.library.utility.Auth;
import com.library.utility.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "UserController", description = "用户管理接口")
@EnableAutoConfiguration
@RequestMapping(value = "/api/library")
public class UserController{

    @Autowired
    public UserService userService;

    @ApiOperation(value = "测试接口",notes = "create by 张聪", httpMethod = "GET")
    @RequestMapping(value = "/users/{username}",method = RequestMethod.GET)
    @Auth(role = "admin")
    public String getUser(@PathVariable String username, @RequestParam String pwd){
        if(pwd.equals("1")){
            throw new BusinessException("test");
        }
        else if(pwd.equals("2")){
            throw  new IllegalArgumentException();
        }
        return "Welcome," + username;
    };

    @ApiOperation(value = "登陆接口",notes = "create by 张聪", httpMethod = "POST")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ApiResult<LoginResult> login(LoginParam param) throws Exception{
        return new ApiResult<LoginResult>(userService.getLoginUser(param));
    }

    @ApiOperation(value = "后台添加用户",notes = "create by 张聪", httpMethod = "POST")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @Auth(role = "admin")
    public ApiResult addUser(AddUserParam param){
        userService.addLoginUser(param);
        return new ApiResult();
    }
}

