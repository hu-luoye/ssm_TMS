package com.luoye_ssm.domain;

/**
 * 游客信息实体类
 */
public class Traveller {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private int credentialsType;    //证件类型：0身份证 1护照 2学生证
    private String credentialsTypeStr;
    private String credentialsNum;
    private int travellerType;      //0成人 1游客
    private String travellerTypeStr;

    @Override
    public String toString() {
        return "Traveller{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", credentialsType=" + credentialsType +
                ", credentialsTypeStr='" + credentialsTypeStr + '\'' +
                ", credentialsNum='" + credentialsNum + '\'' +
                ", travellerType=" + travellerType +
                ", travellerTypeStr='" + travellerTypeStr + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(int credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        if (credentialsType == 0) credentialsTypeStr = "身份证";
        else if (credentialsType == 1) credentialsTypeStr = "护照";
        else if (credentialsType == 2) credentialsTypeStr = "学生证";
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public int getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(int travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        if (travellerType == 0) travellerTypeStr = "成人";
        else if (travellerType == 1) travellerTypeStr = "学生";
        else if (travellerType == 2) travellerTypeStr = "儿童";
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}
