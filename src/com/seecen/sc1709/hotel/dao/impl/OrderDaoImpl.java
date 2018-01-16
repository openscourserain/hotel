package com.seecen.sc1709.hotel.dao.impl;

import com.seecen.sc1709.hotel.dao.OrderDao;
import com.seecen.sc1709.hotel.entity.Order;
import com.seecen.sc1709.hotel.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void add(Order order) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("insert into T_ORDERS values(T_ORDERS_SEQ.nextval,?,?,?,?)");
            ps.setInt(1,order.getTableId());
            ps.setDate(2, (Date) order.getOrderDate());
            ps.setDouble(3,order.getTotalPrice());
            ps.setInt(4,order.getOrderState());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            JDBCUtil.close(conn,ps,set);
        }
    }

    @Override
    public void delete(int oid) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("DELETE FROM T_ORDERS WHERE OID=?");
            ps.setInt(1,oid);
            //返回值是sql执行受影响的行数
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
    }

    @Override
    public void update(Order order) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("UPDATE T_ORDERS set TABLE_ID=?,ORDER_DATE=?,TOTAL_PRICE=?,ORDER_STATE=? WHERE OID=?");
            ps.setInt(1,order.getTableId());
            ps.setDate(2, (Date) order.getOrderDate());
            ps.setDouble(3,order.getTotalPrice());
            ps.setInt(4,order.getOrderState());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
    }

    @Override
    public Order findOrderByOid(int oid) {
        Order order = null;
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("SELECT * FROM T_ORDERS WHERE OID=?");
            ps.setInt(1,oid);
            //返回值是sql执行受影响的行数
            ps.executeQuery();
            if(set.next()){
                order = new Order();
                order.setOid(set.getInt("oid"));
                order.setTableId(set.getInt("table_id"));
                order.setOrderDate(set.getDate("order_date"));
                order.setTotalPrice(set.getDouble("total_price"));
                order.setOrderState(set.getInt("order_state"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
        return order;
    }


}
