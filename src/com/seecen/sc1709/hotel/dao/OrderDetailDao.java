package com.seecen.sc1709.hotel.dao;

import com.seecen.sc1709.hotel.entity.OrderDetail;

import java.util.List;

public interface OrderDetailDao {
    /**增加订单详情*/
    public void add(OrderDetail orderDetail);
    /** 根据ID删除订单详情*/
    public void delete(int detailId);
    /**更新订单详情信息**/
    public void update(OrderDetail orderDetail);
    /**根据ID查找订单详情**/
    public OrderDetail findOrderByIdetailId(int detailId);

}
