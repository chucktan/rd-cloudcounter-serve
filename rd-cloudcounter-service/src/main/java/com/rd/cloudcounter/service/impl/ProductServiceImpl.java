package com.rd.cloudcounter.service.impl;

import com.rd.cloudcounter.mapper.ProductDetailMapper;
import com.rd.cloudcounter.mapper.ProductInfoMapper;
import com.rd.cloudcounter.mapper.ProductMapperCustom;
import com.rd.cloudcounter.pojo.ProductDetail;
import com.rd.cloudcounter.pojo.ProductInfo;
import com.rd.cloudcounter.pojo.vo.ProInfoVo;
import com.rd.cloudcounter.pojo.vo.ProListVo;
import com.rd.cloudcounter.service.BaseService;
import com.rd.cloudcounter.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @create 2020-11-24-9:04
 */
@Service
public class ProductServiceImpl extends BaseService implements ProductService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Autowired
    private ProductMapperCustom productMapperCustom;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ProductInfo> queryProList(Integer proType) {
        Example proListExp = new Example(ProductInfo.class);
        Example.Criteria criteria =   proListExp.createCriteria();
        criteria.andEqualTo("productType",proType);

        return  productInfoMapper.selectByExample(proListExp);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ProInfoVo> queryProListTopThree(Integer proType) {
        return  productMapperCustom.getProListTopThree(proType);
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ProListVo queryProInfoById(String proId) {
        Map<String,Object> map = new HashMap<>();
        map.put("proId",proId);

        return  productMapperCustom.getProDetails(map);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateProIsValid(String proId,Integer isValid) {

        //更新产品主表信息
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductid(proId);
        productInfo.setIsvalid(isValid);
        productInfo.setUpdatedBy(ADMIN);
        productInfo.setUpdatedTime(new Date());
        productInfoMapper.updateByPrimaryKeySelective(productInfo);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateProDetailsIsValid(String intrlId, Integer isValid) {

        //更新产品详情表信息
        ProductDetail productDetail = new ProductDetail();
        productDetail.setIntrid(intrlId);
        productDetail.setIsvalid(isValid);
        productDetail.setUpdatedBy(ADMIN);
        productDetail.setUpdatedTime(new Date());
        productDetailMapper.updateByPrimaryKeySelective(productDetail);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateProViewNum(String proId, Integer incNum) {
        //TODO：须整合redis 分布式锁zooker

        int result = productMapperCustom.incProViewNum(proId,incNum);
        return  result == 1?true:false;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateProShareNum(String proId, Integer incNum) {
        //TODO：须整合redis 分布式锁zooker

        int result = productMapperCustom.incProShareNum(proId,incNum);
        return  result == 1?true:false;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateProApplyNum(String proId, Integer incNum) {
        //TODO：须整合redis 分布式锁zooker
        int result = productMapperCustom.incProApplyNum(proId,incNum);
        return  result == 1?true:false;
    }
}
