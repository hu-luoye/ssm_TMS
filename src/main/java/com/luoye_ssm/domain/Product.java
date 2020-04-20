package com.luoye_ssm.domain;

import com.luoye_ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * 商品实体类
 */
public class Product {

    private long id;    //主键
    private String productNum;  //编号
    private String cityName;    //出发城市
    private String productName;     //商品名称
    private Date departureTime;     //出发时间
    private String departureTimeStr;
    private float productPrice;     //价格
    private String productDesc;     //评价
    private String productStaus;   //状态

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productNum='" + productNum + '\'' +
                ", cityName='" + cityName + '\'' +
                ", productName='" + productName + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStaus='" + productStaus + '\'' +
                '}';
    }

    //日期转为字符转
    public String getDepartureTimeStr() {
        if (departureTime != null) {
            departureTimeStr = DateUtils.dateToString(departureTime,"yyyy-MM-dd");
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getDepartureTime() throws ParseException {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductStaus() {
        return productStaus;
    }

    public void setProductStaus(String productStaus) {
        this.productStaus = productStaus;
    }
}
