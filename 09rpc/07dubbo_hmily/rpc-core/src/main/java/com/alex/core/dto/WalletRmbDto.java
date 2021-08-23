package com.alex.core.dto;

import java.io.Serializable;
import java.util.Date;

public class WalletRmbDto implements Serializable {

    private static final long serialVersionUID = -1;

    private int userId;

    private Double money;

    private Date updatedAt;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
