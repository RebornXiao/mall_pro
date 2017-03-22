package com.hsyl.mall.pojo;

import java.io.Serializable;
import java.util.Date;

public class MallGoods implements Serializable{
   
	private static final long serialVersionUID = 1L;

	private Long id;

    private Integer goodsId;

    private String goodsType;

    private Double goodsPrice;

    private Date productDate;

    private String goodsPhoto;

    private Integer goodsStatus;

    private Long goodsAmout;

    private Integer goodsProper;

    private String contactTel;

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

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public String getGoodsPhoto() {
        return goodsPhoto;
    }

    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto == null ? null : goodsPhoto.trim();
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Long getGoodsAmout() {
        return goodsAmout;
    }

    public void setGoodsAmout(Long goodsAmout) {
        this.goodsAmout = goodsAmout;
    }

    public Integer getGoodsProper() {
        return goodsProper;
    }

    public void setGoodsProper(Integer goodsProper) {
        this.goodsProper = goodsProper;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }
}