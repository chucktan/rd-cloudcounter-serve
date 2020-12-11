package com.rd.cloudcounter.mapper;

import com.rd.cloudcounter.pojo.vo.ProListVo;
import com.rd.cloudcounter.pojo.vo.ProInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @create 2020-11-24-9:10
 */
public interface ProductMapperCustom {

    /**
     * 根据产品类型查询人气（浏览+分享+申请）前三的项目
     * @param proType
     * @return
     */
    public List<ProInfoVo> getProListTopThree(Integer proType);


    /**
     * 查询所有产品中人气前三的项目
     * @return
     */
//    public List<ProInfoVo> queryProListAllTopThree();


    /**
     * 根据产品Id查询产品详细信息及主信息
     * @param map
     * @return
     */
    public ProListVo getProDetails(@Param("paramsMap") Map<String,Object> map);


    /**
     * 增加产品分享量
     * @param proId
     * @param incSum
     * @return
     */
    public  int incProShareNum(@Param("proId") String proId,@Param("incSum") int incSum);


    /**
     * 增加产品浏览量
     * @param proId
     * @param incSum
     * @return
     */
    public  int incProViewNum(@Param("proId") String proId,@Param("incSum") int incSum);


    /**
     * 增加产品申请量
     * @param proId
     * @param incSum
     * @return
     */
    public  int incProApplyNum(@Param("proId") String proId,@Param("incSum") int incSum);



}
