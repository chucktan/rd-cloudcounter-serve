package com.rd.cloudcounter.mapper;

import com.rd.cloudcounter.pojo.vo.ShareInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @create 2020-12-03-15:23
 */
public interface ShareMapperCustom {

    /**
     * 根据用户ID查询用户分享信息
     * @param userId
     * @return
     */
    public List<ShareInfoVo> getShareList(String userId);

    /**
     * 增加分享总分享量
     * @param userId
     * @param managerId
     * @param incSum
     * @return
     */
    public  int incShareNum(@Param("userId") String userId,@Param("managerId") String managerId, @Param("incSum") int incSum);
}
