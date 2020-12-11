package com.rd.cloudcounter.service.impl;

import com.rd.cloudcounter.mapper.CustomerManagerMapper;
import com.rd.cloudcounter.pojo.CustomerManager;
import com.rd.cloudcounter.pojo.bo.ManagerBo;
import com.rd.cloudcounter.service.BaseService;
import com.rd.cloudcounter.service.CustomerManagerService;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @author
 * @create 2020-11-25-15:26
 */
@Service
public class CustomerManagerServiceImpl  extends BaseService implements CustomerManagerService {

    @Autowired
    private CustomerManagerMapper customerManagerMapper;

    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void CreateCusManager(ManagerBo managerBo) {

        //1.设置managerID
        String managerId = sid.nextShort();
        CustomerManager customerManager = new CustomerManager();
        customerManager.setManagerid(managerId);

        //2.copy
        BeanUtils.copyProperties(managerBo,customerManager);

        customerManager.setVisitnum(VISITNUM);
        customerManager.setCreatedBy(ADMIN);
        customerManager.setCreatedTime(new Date());

        customerManagerMapper.insert(customerManager);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public CustomerManager queryCusManagerById(String managerId) {

       return customerManagerMapper.selectByPrimaryKey(managerId);

    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateManagerFace(String managerId, String photoImgUrl) {

        CustomerManager customerManager = new CustomerManager();
        customerManager.setManagerid(managerId);
        customerManager.setPhotoimgurl(photoImgUrl);

        customerManager.setUpdatedBy(managerId);
        customerManager.setUpdatedTime(new Date());
        customerManagerMapper.updateByPrimaryKeySelective(customerManager);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public CustomerManager queryCusManagerByBankUserId(String bankUserId) {
        Example CMExample = new Example(CustomerManager.class);
        Example.Criteria criteria = CMExample.createCriteria();
        criteria.andEqualTo("bankUserID",bankUserId);
        CustomerManager result = customerManagerMapper.selectOneByExample(CMExample);

        return  result;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean deleteCusManagerByBankUserId(String bankUserId) {
        Example CMExample = new Example(CustomerManager.class);
        Example.Criteria criteria = CMExample.createCriteria();
        criteria.andEqualTo("bankUserID",bankUserId);

       int result =  customerManagerMapper.deleteByExample(CMExample);

       return  result==1?true:false;
    }
}
