package com.seecen.sc1709.hotel.dao.impl;

import com.seecen.sc1709.hotel.dao.DinnerTableDao;
import com.seecen.sc1709.hotel.entity.DinnerTable;
import com.seecen.sc1709.hotel.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DinnerTableDaoImpl implements DinnerTableDao {
    @Override
    public void add(DinnerTable dinnerTable) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("insert into t_dinner_table values(T_DINNER_TABLE_SEQ.nextval,?,?,?)");
            ps.setString(1,dinnerTable.getTableName());
            ps.setInt(2,dinnerTable.getTableState());
            ps.setString(3, String.valueOf(dinnerTable.getOrderDate()));
            ps.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn,ps,set);
        }
    }

    @Override
    public void delete(int did) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("DELETE FROM T_DINNER_TABLE WHERE DID=?");
            ps.setInt(1,did);
            //返回值是sql执行受影响的行数
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
    }

    @Override
    public void update(DinnerTable dinnerTable) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("UPDATE T_DINNER_TABLE set TABLE_NAME=?,TABLE_STATE=?,ORDER_DATE=? WHERE DID=?");
            ps.setString(1,dinnerTable.getTableName());
            ps.setInt(2,dinnerTable.getTableState());
            ps.setDate(3, (Date) dinnerTable.getOrderDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
    }

    @Override
    public DinnerTable findDinnerTableByDid(int did) {
        DinnerTable dinnerTable = null;
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("SELECT * FROM WHERE DID=?");
            ps.setInt(1,did);
            //返回值是sql执行受影响的行数
            ps.executeQuery();
            if(set.next()){
                dinnerTable = new DinnerTable();
                dinnerTable.setTableName(set.getString("table_name"));
                dinnerTable.setTableState(set.getInt("table_state"));
                dinnerTable.setOrderDate(set.getDate("order_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
        return dinnerTable;

    }

    @Override
    public List<DinnerTable> findDinnerTable(String keyword) {
        List<DinnerTable> list = new ArrayList<DinnerTable>();
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("SELECT * FROM T_DINNER_TABLE WHERE TABLE_NAME like ? ");
            ps.setString(1,"%"+keyword+"%");
            //返回值是sql执行受影响的行数
            ps.executeQuery();
            if(set.next()){
                DinnerTable dinnerTable = new DinnerTable();
                dinnerTable.setTableName(set.getString("table_name"));
                dinnerTable.setTableState(set.getInt("table_state"));
                dinnerTable.setOrderDate(set.getDate("order_date"));
                list.add(dinnerTable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
        return list;
    }
}
