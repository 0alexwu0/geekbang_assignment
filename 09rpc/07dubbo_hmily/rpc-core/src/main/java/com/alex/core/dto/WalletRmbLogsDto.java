package com.alex.core.dto;

import java.io.Serializable;
import java.util.Date;

public class WalletRmbLogsDto implements Serializable {

    private static final long serialVersionUID = -1;

    private int userId;

    private Double money;

    private Date createdAt;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
