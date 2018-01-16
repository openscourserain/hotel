package com.seecen.sc1709.hotel.dao.impl;

import com.seecen.sc1709.hotel.dao.FoodDao;
import com.seecen.sc1709.hotel.entity.Food;
import com.seecen.sc1709.hotel.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    /**增加食物*/
    @Override
    public void add(Food food) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
                    conn.prepareStatement("insert into t_food values(t_food_seq.nextval,?,?,?,?,?,?)");
                    ps.setString(1,food.getFoodName());
                    ps.setInt(2,food.getFoodTypeId());
                    ps.setDouble(3,food.getPrice());
                    ps.setDouble(4,food.getMprice());
                    ps.setString(5,food.getRemark());
                    ps.setString(6,food.getImg());
                    ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }

    }
    /** 根据ID删除食物*/
    @Override
    public void delete(int fid) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("DELETE FROM T_FOOD WHERE FOOD_ID=?");
            ps.setInt(1,fid);
            //返回值是sql执行受影响的行数
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
    }
    /**更新食物信息**/
    @Override
    public void update(Food food) {

            Connection conn = JDBCUtil.getConnection();
            PreparedStatement ps = null;
            ResultSet set = null;
            try {
                conn.prepareStatement("UPDATE T_FOOD set FOOD_NAME=?,FOOD_TYPE_ID=?,PRICE=?,MPRICE=?,REMARK=? WHERE FOOD_ID=?");
                ps.setString(1,food.getFoodName());
                ps.setInt(2,food.getFoodTypeId());
                ps.setDouble(3,food.getPrice());
                ps.setDouble(4,food.getMprice());
                ps.setString(5,food.getRemark());
                ps.setString(6,food.getImg());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                JDBCUtil.close(conn,ps,set);
            }
    }
    /**根据ID查找食物**/
    @Override
    public Food findFoodById(int fid) {
        Food food = null;
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("SELECT * FROM T_FOOD WHERE FOOD_ID=?");
            ps.setInt(1,fid);
            //返回值是sql执行受影响的行数
            ps.executeQuery();
            if(set.next()){
                food = new Food();
                food.setFoodId(set.getInt("food_Id"));
                food.setFoodName(set.getString("food_Name"));
                food.setFoodTypeId(set.getInt("foodType_Id"));
                food.setPrice(set.getDouble("price"));
                food.setMprice(set.getDouble("mprice"));
                food.setRemark(set.getString("remark"));
                food.setImg(set.getString("img"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
        return food;
    }
    /**根据关键字查找食物**/
    @Override
    public List<Food> findFoods(String keyword) {
        List<Food> list = new ArrayList<Food>();
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            conn.prepareStatement("SELECT * FROM T_FOOD WHERE FOOD_NAME like ? ");
            ps.setString(1,"%"+keyword+"%");
            //返回值是sql执行受影响的行数
            ps.executeQuery();
            if(set.next()){
                Food food = new Food();
                food.setFoodId(set.getInt("foodId"));
                food.setFoodName(set.getString("foodName"));
                food.setFoodTypeId(set.getInt("foodTypeId"));
                food.setPrice(set.getDouble("price"));
                food.setMprice(set.getDouble("mprice"));
                food.setRemark(set.getString("remark"));
                food.setImg(set.getString("img"));
                list.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
        return list;
    }
}
