package com.hsyl.mall.dao;

import com.hsyl.mall.pojo.MallGoods;

public interface MallGoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MallGoods record);

    int insertSelective(MallGoods record);

    MallGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallGoods record);

    int updateByPrimaryKey(MallGoods record);
}