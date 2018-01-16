package com.seecen.sc1709.hotel.entity;

public class Food {
  /**
   * 食物id
   */
  private int foodId;
  /**
   * 食物名称
   *
   */
  private String foodName;
  /**
   * 食物类型ID
   */
  private int foodTypeId;
  /**
   * 食物价格
   */
  private double price;
  /**
   * 会员价格
   */
  private double mprice;
  /**
   * 食物简介
   */
  private String remark;
  /**
   * 食物图片
   */
  private String img;

  public int getFoodId() {
    return foodId;
  }

  public void setFoodId(int foodId) {
    this.foodId = foodId;
  }

  public String getFoodName() {
    return foodName;
  }

  public void setFoodName(String foodName) {
    this.foodName = foodName;
  }

  public int getFoodTypeId() {
    return foodTypeId;
  }

  public void setFoodTypeId(int foodTypeId) {
    this.foodTypeId = foodTypeId;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getMprice() {
    return mprice;
  }

  public void setMprice(double mprice) {
    this.mprice = mprice;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }
}
