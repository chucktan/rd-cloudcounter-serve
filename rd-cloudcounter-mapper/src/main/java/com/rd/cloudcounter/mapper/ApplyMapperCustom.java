package com.rd.cloudcounter.mapper;

import com.rd.cloudcounter.pojo.vo.ApplyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @create 2020-12-04-9:29
 */
public interface ApplyMapperCustom {

    /**
     * 查询产品申请列表
     * @param map
     * @return
     */
    public List<ApplyVo> getApplyList(@Param("paramsMap") Map<String,Object> map);
}
