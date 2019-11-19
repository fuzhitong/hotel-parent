/**
 * Project Name:hotel-pojo
 * File Name:InRoomInfo.java
 * Package Name:com.java.pojo
 * Date:上午9:19:55
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package net.fuzt.pojo;

import java.io.Serializable;

/**
 * Description: Date: 上午9:19:55 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
public class InRoomInfo implements Serializable {
	/**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
	private static final long serialVersionUID = 4772975486166865945L;

    private Long roomId;// 房间主键

    private String customerName;// 客人姓名

    private String gender;

    private String isVip;

    private String idcard;

    private String phone;

    private Float money;// 押金

    private String createDate;// 入住时间

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIsVip() {
        return isVip;
    }

    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "InRoomInfo [roomId=" + roomId + ", customerName=" + customerName + ", gender=" + gender + ", isVip="
                + isVip + ", idcard=" + idcard + ", phone=" + phone + ", money=" + money + ", createDate=" + createDate
                + "]";
    }

}
