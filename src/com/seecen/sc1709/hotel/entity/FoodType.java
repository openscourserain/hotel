package com.seecen.sc1709.hotel.entity;

public class FoodType {
  /**
   * 食物ID
   */
  private int fid;
  /**
   * 食物名字
   */
  private String typeName;

  public int getFid() {
    return fid;
  }

  public void setFid(int fid) {
    this.fid = fid;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }
}
