package com.hsyl.mall.pojo;

import java.io.Serializable;

public class MallGoodsSales implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Long id;

    private Integer goodsId;

    private String goodsType;

    private Long salesAmount;

    private Long salesSurplus;

    private Double goodsSalary;

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

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public Long getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Long salesAmount) {
        this.salesAmount = salesAmount;
    }

    public Long getSalesSurplus() {
        return salesSurplus;
    }

    public void setSalesSurplus(Long salesSurplus) {
        this.salesSurplus = salesSurplus;
    }

    public Double getGoodsSalary() {
        return goodsSalary;
    }

    public void setGoodsSalary(Double goodsSalary) {
        this.goodsSalary = goodsSalary;
    }
}