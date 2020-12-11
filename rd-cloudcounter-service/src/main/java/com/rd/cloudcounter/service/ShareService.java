package com.rd.cloudcounter.service;

import com.rd.cloudcounter.pojo.bo.ShareBo;
import com.rd.cloudcounter.pojo.vo.ShareInfoVo;

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
    public List<ShareInfoVo> queryShareByUserId(String UserId);

    /**
     * 更新分享人Id,被分享客户经理Id查询该分享是否存在
     * @param userId
     * @param managerId
     * @return
     */
    public  boolean queryIsShareExist(String userId,String managerId);


    /**
     *  根据分享人Id,被分享客户经理Id，更新对应分享总分享数
     * @param userId
     * @param managerId
     * @param incNum
     */
    public boolean updateShareNum(String userId,String managerId,Integer incNum);
}
