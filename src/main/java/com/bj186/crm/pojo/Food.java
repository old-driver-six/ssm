package com.bj186.crm.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Food  implements Serializable {
    private Long foodID;
    private String foodName;
    private Float price;
    private String foodType;
    private String imgUrl;
    private String  sheifTime;
    private Set<Bill> bills = new HashSet<Bill>();

    @Override
    public String toString() {
        return "Food{" +
                "foodID=" + foodID +
                ", foodName='" + foodName + '\'' +
                ", price=" + price +
                ", foodType='" + foodType + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", sheifTime='" + sheifTime + '\'' +
                ", bills=" + bills +
                '}';
    }

    public Long getFoodID() {
        return foodID;
    }

    public void setFoodID(Long foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSheifTime() {
        return sheifTime;
    }

    public void setSheifTime(String sheifTime) {
        this.sheifTime = sheifTime;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }
}
