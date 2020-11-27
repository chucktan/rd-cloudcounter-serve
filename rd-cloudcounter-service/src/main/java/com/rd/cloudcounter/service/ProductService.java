package com.rd.cloudcounter.service;

import com.rd.cloudcounter.pojo.ProductInfo;
import com.rd.cloudcounter.pojo.vo.ProInfoVo;
import com.rd.cloudcounter.pojo.vo.ProListVo;

import java.util.List;

/**
 * @author
 * @create 2020-11-23-15:15
 */
public interface ProductService {

    /**
     * 根据产品类别查询产品列表
     * @param proType
     */
    public List<ProductInfo> queryProList(Integer proType);

    /**
     * 根据产品类型查询人气（浏览+分享+申请）前三的项目
     * @param proType
     */
    public List<ProInfoVo> queryProListTopThree(Integer proType);


    /**
     *  根据产品Id查询产品详细信息及主信息
     * @param proId
     */
    public ProListVo queryProInfoById(String proId);


    /**
     * 根据产品Id更新产品状态（是否有效）
     * @param proId
     * @param isValid
     */
    public void updateProIsValid(String proId,Integer isValid);

    /**
     * 根据产品详情Id更新产品状态（是否有效）
     * @param intrlId
     * @param isValid
     */
    public void updateProDetailsIsValid(String intrlId,Integer isValid);

    /**
     *  根据产品Id更新产品浏览数
     * @param proId
     * @param incNum
     */
    public boolean updateProViewNum(String proId,Integer incNum);

    /**
     * 根据产品Id更新产品分享数
     * @param proId
     * @param incNum
     */
    public boolean updateProShareNum(String proId,Integer incNum);


    /**
     * 根据产品Id更新产品申请数
     * @param proId
     * @param incNum
     */
    public boolean updateProApplyNum(String proId,Integer incNum);

}
