package com.library.mapper;

import com.library.entity.AddUserParam;
import com.library.entity.LoginParam;
import com.library.entity.LoginUser;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper {

    LoginUser getLoginUser(@Param("info") LoginParam info);

    LoginUser getLoginUserByUserId(String userId);

    void addUser(AddUserParam info);
}
