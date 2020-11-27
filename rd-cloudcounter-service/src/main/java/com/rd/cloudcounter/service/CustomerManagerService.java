package com.rd.cloudcounter.service;

import com.rd.cloudcounter.pojo.CustomerManager;
import com.rd.cloudcounter.pojo.bo.ManagerBo;

/**
 * @author
 * @create 2020-11-23-15:31
 */
public interface CustomerManagerService {

    /**
     * 创建客户经理信息相关
     */
    public  void  CreateCusManager(ManagerBo managerBo);


    /**
     * 根据客户经理ID查询客户经理信息
     * @param managerId
     */
    public CustomerManager queryCusManagerById(String managerId);


    /**
     * 根据客户经理ID,头像Url地址更新客户经理头像
     * @param managerId
     * @param photoImgUrl
     */
    public void updateManagerFace(String managerId,String photoImgUrl);
}
