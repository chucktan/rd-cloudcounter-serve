package com.rd.cloudcounter.service;

import com.rd.cloudcounter.pojo.ApplyInfo;
import com.rd.cloudcounter.pojo.bo.ApplyBo;
import com.rd.cloudcounter.pojo.vo.ApplyVo;

import java.util.List;

/**
 * @author
 * @create 2020-11-23-15:27
 */
public interface ApplyService {

    /**
     * 根据申请ID查询产品申请相关信息
     * @param applyId
     *
     */
    public  ApplyInfo  queryApplyInfoById(String applyId);

    /**
     * 根据申请人ID,申请状态查产品申请信息
     * @param userId
     * @param state
     */
    public List<ApplyVo> queryApplyList(String userId, Integer state);

    /**
     * 创建产品申请信息相关
     */
    public void CreateApply(ApplyBo applyBo);


    /**
     * 根据申请ID,修改申请状态
     * @param applyId
     */
    public void updateApplyState(String applyId,Integer state);

}
