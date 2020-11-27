package com.rd.cloudcounter.service.impl;

import com.rd.cloudcounter.enums.ApplyState;
import com.rd.cloudcounter.enums.ApplyType;
import com.rd.cloudcounter.mapper.ApplyInfoMapper;
import com.rd.cloudcounter.mapper.ProductMapperCustom;
import com.rd.cloudcounter.pojo.ApplyInfo;
import com.rd.cloudcounter.pojo.bo.ApplyBo;
import com.rd.cloudcounter.service.ApplyService;
import com.rd.cloudcounter.service.BaseService;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author
 * @create 2020-11-25-13:09
 */
@Service
public class ApplyServiceImpl  extends BaseService implements ApplyService {

    @Autowired
    private ApplyInfoMapper applyInfoMapper;

    @Autowired
    private ProductMapperCustom productMapperCustom;

    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void CreateApply(ApplyBo applyBo) {

        //1.设置applyId
        String applyId = sid.nextShort();
        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setApplyid(applyId);

        //2.copy其他变量
        BeanUtils.copyProperties(applyBo,applyInfo);

        applyInfo.setApttypename(ApplyType.getValue(applyBo.getApttype()));
        applyInfo.setState(ApplyState.APPLYING.type);
        applyInfo.setCreatedBy(ADMIN);
        applyInfo.setCreatedTime(new Date());

        applyInfoMapper.insert(applyInfo);

        //3.产品的申请数+1
        productMapperCustom.incProApplyNum(applyBo.getApplyproid(),INCNUM);

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ApplyInfo queryApplyInfoById(String applyId) {
        Example applyExp = new Example(ApplyInfo.class);
        Example.Criteria criteria =  applyExp.createCriteria();
        criteria.andEqualTo("applyID",applyId);

        return  applyInfoMapper.selectOneByExample(applyExp);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ApplyInfo> queryApplyList(String userId, Integer state) {
        Example applyExp = new Example(ApplyInfo.class);
        Example.Criteria criteria =  applyExp.createCriteria();
        criteria.andEqualTo("applyUserID",userId);
        criteria.andEqualTo("state",state);

        return  applyInfoMapper.selectByExample(applyExp);

    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateApplyState(String applyId, Integer state) {
        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setApplyid(applyId);
        applyInfo.setState(state);
        applyInfo.setUpdatedBy(ADMIN);
        applyInfo.setUpdatedTime(new Date());

        applyInfoMapper.updateByPrimaryKeySelective(applyInfo);

    }
}
