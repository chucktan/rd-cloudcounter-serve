package com.rd.cloudcounter.service.impl;


import com.rd.cloudcounter.mapper.ShareInfoMapper;
import com.rd.cloudcounter.pojo.ShareInfo;
import com.rd.cloudcounter.pojo.bo.ShareBo;
import com.rd.cloudcounter.service.BaseService;
import com.rd.cloudcounter.service.ShareService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author
 * @create 2020-11-24-16:04
 */
@Service
public class ShareServiceImpl extends BaseService implements ShareService {

    @Autowired
    private ShareInfoMapper shareInfoMapper;

    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void CreateShare(ShareBo shareBo) {

        //1.创建分享
        String shareId = sid.nextShort();
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareid(shareId);
        shareInfo.setShareuserid(shareBo.getShareUserId());
        shareInfo.setSharedmangerid(shareBo.getShareManagerId());
        //TDOD 设置分享链接
        shareInfo.setSharedurl(shareBo.getSharedUrl());

        shareInfo.setCreatedBy(ADMIN);
        shareInfo.setCreatedTime(new Date());

        shareInfoMapper.insert(shareInfo);

//        return  shareInfo;

        //TODO 分享功能如何分享没能搞清楚
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ShareInfo> queryShareByUserId(String UserId) {
        Example shareInfoExp = new Example(ShareInfo.class);
        Example.Criteria criteria =  shareInfoExp.createCriteria();
        criteria.andEqualTo("shareUserID",UserId);

        return  shareInfoMapper.selectByExample(shareInfoExp);
    }
}
