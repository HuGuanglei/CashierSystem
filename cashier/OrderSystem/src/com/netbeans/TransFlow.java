package com.netbeans;

import java.sql.Date;

/**
 * 商品信息实体
 *
 * @author fufei
 *
 */
public class TransFlow {

    int id;//主键
    int proId;//商品id
    String proName;
    float amt;//交易金额
    int bal;//交易数量
    Date transDate;//交易日期

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public float getAmt() {
        return amt;
    }

    public void setAmt(float amt) {
        this.amt = amt;
    }

    public int getBal() {
        return bal;
    }

    public void setBal(int bal) {
        this.bal = bal;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    @Override
    public String toString() {
        return "TransFlow{" + "id=" + id + ", proId=" + proId + ", amt=" + amt + ", bal=" + bal + ", transDate=" + transDate + '}';
    }
}
