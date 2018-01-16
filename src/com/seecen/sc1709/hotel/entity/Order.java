package com.seecen.sc1709.hotel.entity;

import java.util.Date;

public class Order {
  /**订单主键 */
  private int oid;
  /**餐桌ID*/
  private int tableId;
  private Date orderDate;//订单时间
  private double totalPrice;//总金额
  private int orderState;//下单状态

  public int getOid() {
    return oid;
  }

  public void setOid(int oid) {
    this.oid = oid;
  }

  public int getTableId() {
    return tableId;
  }

  public void setTableId(int tableId) {
    this.tableId = tableId;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public int getOrderState() {
    return orderState;
  }

  public void setOrderState(int orderState) {
    this.orderState = orderState;
  }
}
