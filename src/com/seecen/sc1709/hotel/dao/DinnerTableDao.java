package com.seecen.sc1709.hotel.dao;

import com.seecen.sc1709.hotel.entity.DinnerTable;

import java.util.List;

public interface DinnerTableDao {
    /**增加餐桌*/
        public void add( DinnerTable dinnerTable);
    /** 根据ID删除餐桌*/
    public void delete(int did);
    /**更新餐桌信息**/
    public void update(DinnerTable dinnerTable);
    /**根据ID查找餐桌**/
    public DinnerTable findDinnerTableByDid(int did);
    /**根据关键字查找餐桌**/
    public List<DinnerTable> findDinnerTable(String keyword);
}
