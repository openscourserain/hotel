package com.seecen.sc1709.hotel.dao.impl;

import com.seecen.sc1709.hotel.dao.OrderDetailDao;
import com.seecen.sc1709.hotel.entity.Food;
import com.seecen.sc1709.hotel.entity.OrderDetail;
import com.seecen.sc1709.hotel.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailDaoImpl implements OrderDetailDao {
    @Override
    public void add(OrderDetail orderDetail) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("insert into T_ORDER_DETAIL values(T_ORDER_DETAIL_SEQ.nextval,?,?,?)");
            ps.setInt(1, orderDetail.getOrderId());
            ps.setInt(2, orderDetail.getFoodId());
            ps.setInt(3, orderDetail.getFoodCount());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, set);
        }
    }

    @Override
    public void delete(int detailId) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("DELETE FROM T_ORDER_DETAIL WHERE DETAIL_ID=?");
            ps.setInt(1, detailId);
            //返回值是sql执行受影响的行数
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, set);
        }
    }

    @Override
    public void update(OrderDetail orderDetail) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("UPDATE T_ORDER_DETAIL set ORDER_ID=?,FOOD_ID=?,FOOD_COUNT=?, WHERE DETAIL_ID=?");
            ps.setInt(1, orderDetail.getOrderId());
            ps.setInt(2, orderDetail.getFoodId());
            ps.setInt(3, orderDetail.getFoodCount());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, set);
        }
    }

    @Override
    public OrderDetail findOrderByIdetailId(int detailId) {
        OrderDetail orderDetail = null;
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("SELECT * FROM T_FOOD WHERE FOOD_ID=?");
            ps.setInt(1,detailId);
            //返回值是sql执行受影响的行数
            ps.executeQuery();
            if(set.next()){
                orderDetail = new OrderDetail();
                orderDetail.setDetailId(set.getInt("detail_id"));
                orderDetail.setOrderId(set.getInt("order_id"));
                orderDetail.setFoodId(set.getInt("food_id"));
                orderDetail.setFoodCount(set.getInt("food_count"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }

        return orderDetail;
    }

}
