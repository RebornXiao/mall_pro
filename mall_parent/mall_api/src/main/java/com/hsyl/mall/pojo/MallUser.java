package com.hsyl.mall.pojo;

import java.io.Serializable;
import java.util.Date;

public class MallUser implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Long id;

    private String userId;

    private String userName;

    private String nickName;

    private Date brithDate;

    private Date cteateDate;

    private String userPasswoed;

    private String userPhoto;

    private Integer userLeve;

    private String userPhone;

    private String userAccount;

    private Integer accountType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Date getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(Date brithDate) {
        this.brithDate = brithDate;
    }

    public Date getCteateDate() {
        return cteateDate;
    }

    public void setCteateDate(Date cteateDate) {
        this.cteateDate = cteateDate;
    }

    public String getUserPasswoed() {
        return userPasswoed;
    }

    public void setUserPasswoed(String userPasswoed) {
        this.userPasswoed = userPasswoed == null ? null : userPasswoed.trim();
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto == null ? null : userPhoto.trim();
    }

    public Integer getUserLeve() {
        return userLeve;
    }

    public void setUserLeve(Integer userLeve) {
        this.userLeve = userLeve;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }
}