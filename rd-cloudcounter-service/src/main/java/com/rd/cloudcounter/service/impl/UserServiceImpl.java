package com.rd.cloudcounter.service.impl;

import com.rd.cloudcounter.mapper.UserInfoMapper;
import com.rd.cloudcounter.pojo.UserInfo;
import com.rd.cloudcounter.pojo.bo.UserInfoBo;
import com.rd.cloudcounter.service.BaseService;
import com.rd.cloudcounter.service.UserService;
import com.rd.cloudcounter.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @author
 * @create 2020-11-20-14:59
 */
@Service
public class UserServiceImpl   extends BaseService implements UserService  {


    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public UserInfo createUser(UserInfoBo userInfoBo) {

        //分布式ID
        String userId = sid.nextShort();
        UserInfo user = new UserInfo();
        user.setUserid(userId);

        user.setUsername(userInfoBo.getUserName());
        user.setUserimgurl(userInfoBo.getUserImgUrl());
        user.setOpenID(userInfoBo.getOpenID());
//        try {
//            user.setPassword(MD5Utils.getMD5Str(userInfoBo.getPassword()));
//        }catch (Exception e){
//            e.printStackTrace();
//        }

//        user.setUserimgurl(userInfoBo.getUserImgUrl());

        user.setCreatedBy(ADMIN);
        user.setCreatedTime(new Date());

        userInfoMapper.insert(user);
        return  user;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public UserInfo queryUserForLogin(String userName,String password) {

        Example userExample = new Example(UserInfo.class);
        Example.Criteria userCriteria =  userExample.createCriteria();
        userCriteria.andEqualTo("userName",userName);
        userCriteria.andEqualTo("password",password);

        UserInfo userResult = userInfoMapper.selectOneByExample(userExample);

        return  userResult;

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public UserInfo queryUserByOpenId(String openId) {


        Example userExample = new Example(UserInfo.class);
        Example.Criteria userCriteria =  userExample.createCriteria();
        userCriteria.andEqualTo("openID",openId);

        UserInfo userResult = userInfoMapper.selectOneByExample(userExample);

        return  userResult;
    }
}
