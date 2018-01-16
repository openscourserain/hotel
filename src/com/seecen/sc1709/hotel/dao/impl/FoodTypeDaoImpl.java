package com.seecen.sc1709.hotel.dao.impl;

import com.seecen.sc1709.hotel.dao.FoodTypeDao;
import com.seecen.sc1709.hotel.entity.FoodType;
import com.seecen.sc1709.hotel.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodTypeDaoImpl implements FoodTypeDao {
    @Override
    public void add(FoodType foodType) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("insert into t_food_type values(t_food_type_seq.nextval,?)");
            ps.setString(1,foodType.getTypeName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn,ps,set);
        }
    }

    @Override
    public void delete(int fid) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("DELETE FROM T_FOOD_TYPE WHERE FID=?");
            ps.setInt(1,fid);
            //返回值是sql执行受影响的行数
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
    }

    @Override
    public void update(FoodType foodType) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("UPDATE T_FOOD_TYPE set TYPE_NAME=? WHERE FID=?");
            ps.setString(1,foodType.getTypeName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
    }

    @Override
    public FoodType findFoodTypeByFid(int fid) {
        FoodType foodType = null;
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("SELECT * FROM T_FOOD_TYPE WHERE FID=?");
            ps.setInt(1,fid);
            //返回值是sql执行受影响的行数
            ps.executeQuery();
            if(set.next()){
                foodType= new FoodType();
                foodType.setFid(set.getInt("fid"));
                foodType.setTypeName(set.getString("type_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
        return foodType;
    }

    @Override
    public List<FoodType>findFoodType(String keyword) {
        List<FoodType> list = new ArrayList<FoodType>();
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("SELECT * FROM T_FOOD_TYPE WHERE TYPE_NAME like ? ");
            ps.setString(1,"%"+keyword+"%");
            //返回值是sql执行受影响的行数
            ps.executeQuery();
            if(set.next()){
                FoodType foodType = new FoodType();
                foodType.setFid(set.getInt("fid"));
                foodType.setTypeName(set.getString("typeName"));
                list.add(foodType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
        return list;
    }
}
