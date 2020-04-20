package com.luoye_ssm.domain;

import com.luoye_ssm.utils.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 */
public class Order {
    private int id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private String orderStatus;    //状态，是否支付
    private int propleCount;
    private Product product;
    private List<Traveller> travellers;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", propleCount=" + propleCount +
                ", product=" + product +
                ", travellers=" + travellers +
                ", member=" + member +
                ", payType='" + payType + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                '}';
    }

    private Member member;
    private String payType;    //支付方式 微信、支付宝、其他
    private String orderDesc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    //日期转string
    public String getOrderTimeStr() {
        if (orderTime != null) {
            return DateUtils.dateToString(orderTime,"yyyy-MM-dd");
        }else
        return "尚未记录时间";
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPropleCount() {
        return propleCount;
    }

    public void setPropleCount(int propleCount) {
        this.propleCount = propleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}
