package com.hsyl.mall.dao;

import java.util.Map;

import com.hsyl.mall.pojo.MallUser;

public interface MallUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MallUser record);

    int insertSelective(MallUser record);

    MallUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallUser record);

    int selectUserAccount(String userAccount);
    
    int selectUserIsExist(Map<String,Object> map);
}