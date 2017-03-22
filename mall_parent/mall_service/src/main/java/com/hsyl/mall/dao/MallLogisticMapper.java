package com.hsyl.mall.dao;

import com.hsyl.mall.pojo.MallLogistic;

public interface MallLogisticMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MallLogistic record);

    int insertSelective(MallLogistic record);

    MallLogistic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallLogistic record);

    int updateByPrimaryKey(MallLogistic record);
}