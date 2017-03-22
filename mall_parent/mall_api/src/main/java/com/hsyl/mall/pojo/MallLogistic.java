package com.hsyl.mall.pojo;

import java.io.Serializable;

public class MallLogistic implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Long id;

    private Integer goodsId;

    private String userId;

    private Integer goodsType;

    private Long goodsAmount;

    private Double goodsCountSalary;

    private String receveAddres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Long getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Long goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Double getGoodsCountSalary() {
        return goodsCountSalary;
    }

    public void setGoodsCountSalary(Double goodsCountSalary) {
        this.goodsCountSalary = goodsCountSalary;
    }

    public String getReceveAddres() {
        return receveAddres;
    }

    public void setReceveAddres(String receveAddres) {
        this.receveAddres = receveAddres == null ? null : receveAddres.trim();
    }
}