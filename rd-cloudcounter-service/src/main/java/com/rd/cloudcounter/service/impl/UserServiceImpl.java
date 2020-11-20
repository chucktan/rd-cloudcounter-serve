package com.rd.cloudcounter.service.impl;

import com.rd.cloudcounter.mapper.UserInfoMapper;
import com.rd.cloudcounter.pojo.UserInfo;
import com.rd.cloudcounter.pojo.bo.UserInfoBo;
import com.rd.cloudcounter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @create 2020-11-20-14:59
 */
@Service
public class UserServiceImpl  implements UserService {


    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo createUser(UserInfoBo userInfoBo) {

        return null;
    }

    @Override
    public UserInfo queryUserForLogin(String userName) {
        return null;
    }
}
