package com.seecen.sc1709.hotel.dao;

import com.seecen.sc1709.hotel.entity.Food;

import java.util.List;

public interface FoodDao {
    /**增加食物*/
    public void add(Food food);
    /** 根据ID删除食物*/
    public void delete(int fid);
    /**更新食物信息**/
    public void update(Food food);
    /**根据ID查找食物**/
    public Food findFoodById(int fid);
    /**根据关键字查找食物**/
    public List<Food> findFoods(String keyword);
}
