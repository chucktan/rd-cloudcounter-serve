package com.rd.cloudcounter.service;

import com.rd.cloudcounter.pojo.UserInfo;
import com.rd.cloudcounter.pojo.bo.UserInfoBo;

/**
 * @author
 * @create 2020-11-20-14:54
 */
public interface UserService {

    /**
     * 创建用户
     * @return
     */
    public UserInfo createUser(UserInfoBo userInfoBo);

    /**
     * 检测用户是否存在，用于登录
     * @param userName
     * @return
     */
    public UserInfo  queryUserForLogin(String userName);
}
