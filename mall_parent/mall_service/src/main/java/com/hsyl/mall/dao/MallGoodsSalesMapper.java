package com.hsyl.mall.dao;

import com.hsyl.mall.pojo.MallGoodsSales;

public interface MallGoodsSalesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MallGoodsSales record);

    int insertSelective(MallGoodsSales record);

    MallGoodsSales selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallGoodsSales record);

    int updateByPrimaryKey(MallGoodsSales record);
}