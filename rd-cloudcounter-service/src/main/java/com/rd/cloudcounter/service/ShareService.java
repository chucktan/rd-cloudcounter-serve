package com.rd.cloudcounter.service;

import com.rd.cloudcounter.pojo.ShareInfo;
import com.rd.cloudcounter.pojo.bo.ShareBo;

import java.util.List;

/**
 * @author
 * @create 2020-11-23-15:34
 */
public interface ShareService {

    /**
     * 创建分享信息相关
     */
    public void CreateShare(ShareBo shareBo);

    /**
     * 根据分享人Id查询分享信息
     * @param UserId
     */
    public List<ShareInfo> queryShareByUserId(String UserId);
}
