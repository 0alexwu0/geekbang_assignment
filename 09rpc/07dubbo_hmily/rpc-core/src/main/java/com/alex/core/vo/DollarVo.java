package com.alex.core.vo;

import java.io.Serializable;

public class DollarVo implements Serializable {

    private static final long serialVersionUID = -1;

    private int userId;

    private Double money;

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
}
