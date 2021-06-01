package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.model.Bill;

public interface BillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);
}